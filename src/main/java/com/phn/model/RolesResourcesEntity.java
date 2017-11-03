package com.phn.model;

import javax.persistence.*;

/**
 * @author zhuolin
 * @version 创建时间：2017/11/1 17:19
 * classType:
 */
@Entity
@Table(name = "roles_resources", schema = "sec", catalog = "")
public class RolesResourcesEntity {
    private Integer rsid;
    private Integer rid;
    private int id;

    @Basic
    @Column(name = "rsid")
    public Integer getRsid() {
        return rsid;
    }

    public void setRsid(Integer rsid) {
        this.rsid = rsid;
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

        RolesResourcesEntity that = (RolesResourcesEntity) o;

        if (id != that.id) return false;
        if (rsid != null ? !rsid.equals(that.rsid) : that.rsid != null) return false;
        if (rid != null ? !rid.equals(that.rid) : that.rid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rsid != null ? rsid.hashCode() : 0;
        result = 31 * result + (rid != null ? rid.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
