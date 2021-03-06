package com.shangdingdai.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.widget.Toast;

public class NetworkStateService extends Service{
    private ConnectivityManager connectivityManager;  
    private NetworkInfo info;  
  
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {  
        @SuppressLint("ShowToast")
		@Override  
        public void onReceive(Context context, Intent intent) {  
            String action = intent.getAction();  
            if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {  
                connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);  
                info = connectivityManager.getActiveNetworkInfo();    
                if(info != null && info.isAvailable()) {  
                    
                } else {  
                    Toast.makeText(getApplicationContext(), "没有可用网络，请检查网络设置", Toast.LENGTH_SHORT).show();
                }  
            }  
        }  
    };  
      
    @Override  
    public IBinder onBind(Intent intent) {  
        return null;  
    }  
  
    @Override  
    public void onCreate() {  
        super.onCreate();  
        IntentFilter mFilter = new IntentFilter();  
        mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);  
        registerReceiver(mReceiver, mFilter);  
    }  
  
    @Override  
    public void onDestroy() {  
        super.onDestroy();  
        unregisterReceiver(mReceiver);  
    }  
  
    @Override  
    public int onStartCommand(Intent intent, int flags, int startId) {  
        return super.onStartCommand(intent, flags, startId);  
    } 
}
