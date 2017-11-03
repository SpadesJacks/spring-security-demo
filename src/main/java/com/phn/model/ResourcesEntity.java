package com.phn.model;

import javax.persistence.*;

/**
 * @author zhuolin
 * @version 创建时间：2017/11/1 17:19
 * classType:
 */
@Entity
@Table(name = "resources", schema = "sec", catalog = "")
public class ResourcesEntity {
    private String url;
    private String resourcename;
    private int id;

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "resourcename")
    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
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

        ResourcesEntity that = (ResourcesEntity) o;

        if (id != that.id) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (resourcename != null ? !resourcename.equals(that.resourcename) : that.resourcename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (resourcename != null ? resourcename.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
