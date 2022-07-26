package com.thunder.serveraidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;


public class ServerService extends Service {
    private final String TAG = "serverAidl";

    public ServerService() {
    }

    // 实例化AIDL的Stub类(Binder的子类)

    private final IServerAidl_Interface.Stub mBinder = new IServerAidl_Interface.Stub() {

        //重写接口里定义的方法
        @Override
        public void AIDL_getServerData() throws RemoteException {

            //Log.e(TAG, "Client access server aidl successfully");
            //重写接口里定义的方法
            Log.e(TAG, "client can call server service func successfully");

        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        Log.e(TAG, "Received binding.");
        return mBinder;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        Log.e(TAG,"Service 11111111 onCreate()");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("执行了onStartCommand()");
        return super.onStartCommand(intent, flags, startId);


    }

}