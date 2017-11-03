package com.phn.dao;


import java.util.List;

/**
 * @author zhuolin
 * @version 创建时间：2017/11/1 17:21
 * classType:
 */
public interface RolesDao {

     List<String> getUserRoles(Integer userId);

}
