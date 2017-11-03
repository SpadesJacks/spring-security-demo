package com.phn.security;

import com.phn.dao.ResoucesDao;
import com.phn.dao.UsersDao;
import com.phn.dto.RoleResourcesDTO;
import com.phn.model.ResourcesEntity;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.*;

/**
 * @author zhuolin
 * @version 创建时间：2017/11/2 10:53
 * classType:
 */
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

//    ApplicationContext applicationContext =

    ResoucesDao resoucesDao;

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    public MyInvocationSecurityMetadataSourceService(ResoucesDao resoucesDao) {
        this.resoucesDao = resoucesDao;
        loadResourceDefine();
    }

    private void loadResourceDefine() {
        List<RoleResourcesDTO> entities = resoucesDao.findRoleAndResources();
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        for (RoleResourcesDTO entity : entities) {
            if (!resourceMap.containsKey(entity.getUrl())) {
                resourceMap.put(entity.getUrl(), new ArrayList<ConfigAttribute>());
            }
            resourceMap.get(entity.getUrl()).add(new SecurityConfig(entity.getRoleName()));
        }
        System.out.println(resourceMap);
    }

    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String url = ((FilterInvocation) o).getRequestUrl();
        int firstQuestionMarkIndex = url.indexOf("?");
        if (firstQuestionMarkIndex != -1) {
            url = url.substring(0, firstQuestionMarkIndex);
        }
        return resourceMap.get(url);
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    public boolean supports(Class<?> aClass) {
        return true;
    }
}
