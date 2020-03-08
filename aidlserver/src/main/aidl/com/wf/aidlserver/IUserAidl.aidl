// IUserAidl.aidl
package com.wf.aidlserver;

// Declare any non-default types here with import statements

import com.wf.aidlserver.UserBean;

interface IUserAidl {

void addUser(in UserBean user);

List<UserBean> getUserList();

}
