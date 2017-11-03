package com.phn.dao;

import com.phn.model.UsersEntity;

/**
 * @author zhuolin
 * @version 创建时间：2017/11/1 17:21
 * classType:
 */
public interface UsersDao {

     UsersEntity getLoginUser(String username);
}
