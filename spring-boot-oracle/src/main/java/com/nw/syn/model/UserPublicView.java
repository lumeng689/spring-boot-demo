package com.nw.syn.model;

import javax.persistence.*;

@Entity
@Table(name = "user_public_view")
public class UserPublicView {
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "BASEORG_ID")
    private String baseOrgId;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LOGIN_NAME")
    private String loginName;
    @Column(name = "STATE")
    private String stage;
    @Column(name = "SAPHRID")
    private String sapHrId;
    // 0或1或2
    @Column(name = "SEX_CODE")
    private byte sexCode;
    //样例  1963-12-12
    @Column(name = "BIRTH_DATE")
    private String birthDate;
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "REMARK")
    private String remark;
    @Column(name = "FULL_PATH")
    private String fullPath;
    @Column(name = "FULL_PATH_ORGID")
    private String fullPathOrgId;
    @Column(name = "DISP_ORDER")
    private Integer dispOrder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBaseOrgId() {
        return baseOrgId;
    }

    public void setBaseOrgId(String baseOrgId) {
        this.baseOrgId = baseOrgId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getSapHrId() {
        return sapHrId;
    }

    public void setSapHrId(String sapHrId) {
        this.sapHrId = sapHrId;
    }

    public byte getSexCode() {
        return sexCode;
    }

    public void setSexCode(byte sexCode) {
        this.sexCode = sexCode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getDispOrder() {
        return dispOrder;
    }

    public void setDispOrder(Integer dispOrder) {
        this.dispOrder = dispOrder;
    }
}
