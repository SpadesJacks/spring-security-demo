package com.phn.model;

import javax.persistence.*;

/**
 * @author zhuolin
 * @version 创建时间：2017/11/1 17:19
 * classType:
 */
@Entity
@Table(name = "users_roles", schema = "sec", catalog = "")
public class UsersRolesEntity {
    private Integer uid;
    private Integer rid;
    private int id;

    @Basic
    @Column(name = "uid")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "rid")
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

        UsersRolesEntity that = (UsersRolesEntity) o;

        if (id != that.id) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (rid != null ? !rid.equals(that.rid) : that.rid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (rid != null ? rid.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
