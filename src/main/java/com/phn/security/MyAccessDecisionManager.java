package com.phn.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author zhuolin
 * @version 创建时间：2017/11/2 10:53
 * classType:
 */
public class MyAccessDecisionManager implements AccessDecisionManager {

    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttributes == null) {
            return;
        }
        Iterator<ConfigAttribute> ite = configAttributes.iterator();
        while (ite.hasNext()) {
            ConfigAttribute ca = ite.next();
            String needRole = ((SecurityConfig) ca).getAttribute();

            System.out.println("authentication size" + authentication.getAuthorities().size());
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (needRole.trim().equalsIgnoreCase(ga.getAuthority().toString())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("");
    }

    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    public boolean supports(Class<?> aClass) {
        return true;
    }
}
