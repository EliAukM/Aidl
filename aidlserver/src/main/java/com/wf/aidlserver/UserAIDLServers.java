package com.wf.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UserAIDLServers extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {


        IBinder iBinder = new IUserAidl.Stub() {
            @Override
            public void addUser(UserBean user) throws RemoteException {

                Log.e("TAG","服务端打印：接收到客户端发送的User数据"+user.toString());


            }

            @Override
            public List<UserBean> getUserList() throws RemoteException {

                Log.e("TAG","服务端打印：客户端要求查询User数据开始");

                List<UserBean> userBeans = new ArrayList<>();

                UserBean bean = new UserBean();
                bean.setName("张一");
                bean.setSex("男");

                UserBean bean2 = new UserBean();
                bean2.setName("张二");
                bean2.setSex("男");

                userBeans.add(bean);
                userBeans.add(bean2);

                Log.e("TAG","服务端打印：客户端要求查询User数据返回");

                return userBeans;
            }
        };

        return iBinder;
    }
}
