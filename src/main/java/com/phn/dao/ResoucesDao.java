package com.phn.dao;

import com.phn.dto.RoleResourcesDTO;
import com.phn.model.ResourcesEntity;

import java.util.List;

/**
 * @author zhuolin
 * @version 创建时间：2017/11/1 17:21
 * classType:
 */
public interface ResoucesDao {

    List<ResourcesEntity> findAll();

    List<RoleResourcesDTO> findRoleAndResources();
}
