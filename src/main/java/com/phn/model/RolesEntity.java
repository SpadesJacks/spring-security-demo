package com.phn.model;

import javax.persistence.*;

/**
 * @author zhuolin
 * @version 创建时间：2017/11/1 17:19
 * classType:
 */
@Entity
@Table(name = "roles", schema = "sec", catalog = "")
public class RolesEntity {
    private String rolename;
    private int id;

    @Basic
    @Column(name = "rolename")
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesEntity that = (RolesEntity) o;

        if (id != that.id) return false;
        if (rolename != null ? !rolename.equals(that.rolename) : that.rolename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rolename != null ? rolename.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}
