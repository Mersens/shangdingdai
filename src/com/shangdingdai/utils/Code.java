package com.shangdingdai.utils;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
/**
 * 
 * @author Mersens
 * 创建显示验证码
 */
public class Code {
	 
	  private static final char[] CHARS = {  
	        '2', '3', '4', '5', '6', '7', '8', '9',  
	        'a', 'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm',   
	        'n',  'q', 'r', 't', 'u', 'y', 'z',  
	        'A', 'B',  'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',   
	        'N',  'Q', 'R', 'T', 'U',  'Y', 'Z'  
	    };  
	      
	    private static Code bmpCode;  
	    
	    //单例模式，存在一个实例  
	    public static Code getInstance() {  
	        if(bmpCode == null)  
	            bmpCode = new Code();  
	        return bmpCode;  
	    }  
	      
	    //默认验证码显示常量
	    private static final int DEFAULT_CODE_LENGTH = 4;  
	    private static final int DEFAULT_FONT_SIZE = 30;  
	    private static final int DEFAULT_LINE_NUMBER = 2;  
	    private static final int BASE_PADDING_LEFT = 12, RANGE_PADDING_LEFT = 20, BASE_PADDING_TOP = 20, RANGE_PADDING_TOP = 20;  
	    private static final int DEFAULT_WIDTH = 120, DEFAULT_HEIGHT = 56;  
	      
	
	    private int width = DEFAULT_WIDTH, height = DEFAULT_HEIGHT;   

	    private int base_padding_left = BASE_PADDING_LEFT, range_padding_left = RANGE_PADDING_LEFT,   
	            base_padding_top = BASE_PADDING_TOP, range_padding_top = RANGE_PADDING_TOP;  
	      

	    private int codeLength = DEFAULT_CODE_LENGTH, line_number = DEFAULT_LINE_NUMBER, font_size = DEFAULT_FONT_SIZE;  
	
	    private String code;  
	    private int padding_left, padding_top;  
	    private Random random = new Random();  
	    //验证码图片  
	    public Bitmap createBitmap() {  
	        padding_left = 0;  
	          
	        Bitmap bp = Bitmap.createBitmap(width, height, Config.ARGB_8888);   
	        Canvas c = new Canvas(bp);  
	  
	        code = createCode();  
	          
	        c.drawColor(Color.WHITE);  
	        Paint paint = new Paint();  
	        paint.setTextSize(font_size);  
	          
	        for (int i = 0; i < code.length(); i++) {  
	            randomTextStyle(paint);  
	            randomPadding();  
	            c.drawText(code.charAt(i) + "", padding_left, padding_top, paint);  
	        }  
	  
	        for (int i = 0; i < line_number; i++) {  
	            drawLine(c, paint);  
	        }  
	          
	        c.save( Canvas.ALL_SAVE_FLAG );//保存    
	        c.restore();//  
	        return bp;  
	    }  
	    //获取验证码的字符串  
	    public String getCode() {  
	        return code;  
	    }  
	      
	    //验证码  
	    private String createCode() {  
	        StringBuilder buffer = new StringBuilder();  
	        for (int i = 0; i < codeLength; i++) {  
	            buffer.append(CHARS[random.nextInt(CHARS.length)]);  
	        }  
	        return buffer.toString();  
	    }  
	      
	    private void drawLine(Canvas canvas, Paint paint) {  
	        int color = randomColor();  
	        int startX = random.nextInt(width);  
	        int startY = random.nextInt(height);  
	        int stopX = random.nextInt(width);  
	        int stopY = random.nextInt(height);  
	        paint.setStrokeWidth(1);  
	        paint.setColor(color);  
	        canvas.drawLine(startX, startY, stopX, stopY, paint);  
	    }  
	      
	    private int randomColor() {  
	        return randomColor(1);  
	    }  
	  
	    private int randomColor(int rate) {  
	        int red = random.nextInt(256) / rate;  
	        int green = random.nextInt(256) / rate;  
	        int blue = random.nextInt(256) / rate;  
	        return Color.rgb(red, green, blue);  
	    }  
	      
	    private void randomTextStyle(Paint paint) {  
	        int color = randomColor();  
	        paint.setColor(color);  
	        paint.setFakeBoldText(random.nextBoolean());  //true为粗体，false为非粗体  
/*	        float skewX = random.nextInt(11) / 10;  
	        skewX = random.nextBoolean() ? skewX : -skewX;  
	        paint.setTextSkewX(skewX); //float类型参数，负数表示右斜，整数左斜  
//	      paint.setUnderlineText(true); //true为下划线，false为非下划线  
//	      paint.setStrikeThruText(true); //true为删除线，false为非删除线  
*/	    }  
	      
	    private void randomPadding() {  
	        padding_left += base_padding_left + random.nextInt(range_padding_left);  
	        padding_top = base_padding_top + random.nextInt(range_padding_top);  
	    }  
	} 

