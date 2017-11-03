package com.phn.dao.impl;

import com.phn.dao.RolesDao;
import com.phn.model.RolesEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhuolin
 * @version 创建时间：2017/11/1 17:21
 * classType:
 */
@Repository
public class RolesDaoImp implements RolesDao {

    @Autowired
    SessionFactory sessionFactory;

    public List<String> getUserRoles(Integer userId) {
        return sessionFactory.openSession()
                .createQuery("select r.rolename from RolesEntity r,UsersRolesEntity ur where r.id = ur.rid and ur.uid = :userId")
                .setParameter("userId", userId).list();
    }


}
