package com.nw.syn.model;

import javax.persistence.*;

@Entity
@Table(name="org_public_view")
public class OrgPublicView {
    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PARENT_ID")
    private String parentId;

    @Column(name = "ATTR")
    private String attr;

    @Column(name = "SYSDATAID")
    private String sysDataId;

    @Column(name = "FULL_PATH")
    private String fullPath;

    @Column(name = "FULL_PATH_ORGID")
    private String fullPathOrgId;

    @Column(name = "ORDER_NO")
    private String orderNo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getSysDataId() {
        return sysDataId;
    }

    public void setSysDataId(String sysDataId) {
        this.sysDataId = sysDataId;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getFullPathOrgId() {
        return fullPathOrgId;
    }

    public void setFullPathOrgId(String fullPathOrgId) {
        this.fullPathOrgId = fullPathOrgId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
