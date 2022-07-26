package com.thunder.serveraidl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.thunder.serveraidl.IServerAidl_Interface;

public class MainActivity extends AppCompatActivity {
    private String TAG = "serverAidl";

    // define aidl interface
    private IServerAidl_Interface mAidlServerService;
    // create connection
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG, "Server aidl service connected");
            //使用AIDLService1.Stub.asInterface()方法將傳入的IBinder物件傳換成了mAIDL_Service對象
            mAidlServerService = IServerAidl_Interface.Stub.asInterface(service);
            //通過該物件調用在IServerAidl_Interface.aidl檔中定義的介面方法,從而實現跨進程通信
            try {
                mAidlServerService.AIDL_getServerData();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Intent intent = new Intent()
                .setComponent(new ComponentName(
                        "com.thunder.serveraidl",
                        "com.thunder.serveraidl.ServerService"));
        //綁定服務,傳入intent和ServiceConnection對象
        startForegroundService(intent);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);


         */
    }
}