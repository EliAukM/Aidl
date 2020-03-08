package com.wf.aidlclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.wf.aidlserver.IUserAidl;
import com.wf.aidlserver.UserBean;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindService();
    }



public IUserAidl iUserAidl;

    public void bindService(){

        ServiceConnection connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

                Log.e("TAG","客户端输出：连接成功");

                iUserAidl =  IUserAidl.Stub.asInterface(service);

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                iUserAidl = null;
            }
        };

        Intent intent = new Intent();//                                      com.wf.aidlserver.UserAIDLServers
        intent.setComponent(new ComponentName("com.wf.aidlserver", "com.wf.aidlserver.UserAIDLServers"));
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

//查询用户按钮
    public void SelectUser(View view) {
        try {
            List<UserBean> userList = iUserAidl.getUserList();

            Log.e("TAG","客户端打印数据：查询服务端数返回="+userList.toString());

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

//    添加用户按钮
    public void AddUser(View view) {

        UserBean bean = new UserBean();
        bean.setSex("男");
        bean.setName("测试");
        try {
            iUserAidl.addUser(bean);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
