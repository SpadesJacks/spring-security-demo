package com.phn.security;

import com.phn.dao.RolesDao;
import com.phn.dao.UsersDao;
import com.phn.model.UsersEntity;
import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author zhuolin
 * @version 创建时间：2017/11/1 19:15
 * classType:
 */
public class CustomUserDetailsService implements UserDetailsService {

    protected static Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    UsersDao usersDao;

    @Autowired
    RolesDao rolesDao;

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {

        UserDetails user = null;

        try {
            UsersEntity loginUser = usersDao.getLoginUser(username);
            List<String> roles = rolesDao.getUserRoles(loginUser.getId());
            user = new User(loginUser.getUsername(), loginUser.getPassword()
                    .toLowerCase(), true, true, true, true,
                 getAuthorities(roles));
        } catch (Exception e) {
            logger.error("Error in retrieving user");
            throw new UsernameNotFoundException("Error in retrieving user");
        }

        return user;
    }

    /**
     * 获得访问角色权限
     *
     * @param roles
     * @return
     */
    public Collection<GrantedAuthority> getAuthorities(List<String> roles) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        for(String role : roles){
            authList.add(new SimpleGrantedAuthority(role));
        }
        return authList;
    }
}
