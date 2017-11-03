package com.phn.dao.impl;

import com.phn.dao.ResoucesDao;
import com.phn.dto.RoleResourcesDTO;
import com.phn.model.ResourcesEntity;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhuolin
 * @version 创建时间：2017/11/1 17:21
 * classType:
 */
@Repository
public class ResoucesDaoImp implements ResoucesDao {

    @Autowired
    SessionFactory sessionFactory;

    public List<ResourcesEntity> findAll() {
        return sessionFactory.openSession().createQuery("select r from ResourcesEntity r").list();
    }

    public List<RoleResourcesDTO> findRoleAndResources() {
        return sessionFactory.openSession()
                .createSQLQuery("select r.rolename roleName, re.url url from roles r, roles_resources rr ,resources re where r.id = rr.rid and re.id = rr.rsid ")
                .addScalar("roleName", StandardBasicTypes.STRING).addScalar("url",StandardBasicTypes.STRING).setResultTransformer(Transformers.aliasToBean(RoleResourcesDTO.class)).list();
    }
}
