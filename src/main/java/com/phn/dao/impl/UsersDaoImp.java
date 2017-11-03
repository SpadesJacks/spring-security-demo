package com.phn.dao.impl;

import com.phn.dao.UsersDao;
import com.phn.model.UsersEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhuolin
 * @version 创建时间：2017/11/1 17:21
 * classType:
 */
@Repository
public class UsersDaoImp implements UsersDao {

    @Autowired()
    @Qualifier("sessionFactory")
    SessionFactory sessionFactory;


    @Transactional
    public UsersEntity getLoginUser(String username) {
        return (UsersEntity) sessionFactory.openSession().createQuery("from UsersEntity where username = :userName")
                .setParameter("userName", username).uniqueResult();
    }
}
