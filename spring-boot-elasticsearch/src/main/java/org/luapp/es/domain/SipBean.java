package org.luapp.es.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "t_sip", type = "sip", shards = 1, replicas = 0, refreshInterval = "-1")
public class SipBean {
    @Id
    private Long id;
    @Field
    private Integer actiontype;
    private Integer areaid;
    private String assetid;
    private Integer bandwidth;
    private String c1url;
    private String destination;
    private String dstip;
    private Integer dstport;
    private String frequency;
    private String groupcode;
    private String programno;
    private String purchasetoken;
    private String qamname;
    private String requestheader;
    private String responseheader;
    private Integer responsetime;
    private Integer scale;
    private String sessionid;
    private String sn;
    private String source;
    private String srcip;
    private Integer srcport;
    private Integer statuscode;
    @Field(type = FieldType.Text)
    private String statusmsg;
    private Date time;
    private String url;


    public SipBean() {
    }

    public SipBean(Long id, Integer actiontype, Integer areaid, String assetid, Integer bandwidth, String c1url,
                   String destination, String dstip, Integer dstport, String frequency, String groupcode, String programno,
                   String purchasetoken, String qamname, String requestheader, String responseheader, Integer responsetime,
                   Integer scale, String sessionid, String sn, String source, String srcip, Integer srcport,
                   Integer statuscode, String statusmsg, Date time, String url) {
        this.id = id;
        this.actiontype = actiontype;
        this.areaid = areaid;
        this.assetid = assetid;
        this.bandwidth = bandwidth;
        this.c1url = c1url;
        this.destination = destination;
        this.dstip = dstip;
        this.dstport = dstport;
        this.frequency = frequency;
        this.groupcode = groupcode;
        this.programno = programno;
        this.purchasetoken = purchasetoken;
        this.qamname = qamname;
        this.requestheader = requestheader;
        this.responseheader = responseheader;
        this.responsetime = responsetime;
        this.scale = scale;
        this.sessionid = sessionid;
        this.sn = sn;
        this.source = source;
        this.srcip = srcip;
        this.srcport = srcport;
        this.statuscode = statuscode;
        this.statusmsg = statusmsg;
        this.time = time;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getActiontype() {
        return actiontype;
    }

    public void setActiontype(Integer actiontype) {
        this.actiontype = actiontype;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public String getAssetid() {
        return assetid;
    }

    public void setAssetid(String assetid) {
        this.assetid = assetid;
    }

    public Integer getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getC1url() {
        return c1url;
    }

    public void setC1url(String c1url) {
        this.c1url = c1url;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDstip() {
        return dstip;
    }

    public void setDstip(String dstip) {
        this.dstip = dstip;
    }

    public Integer getDstport() {
        return dstport;
    }

    public void setDstport(Integer dstport) {
        this.dstport = dstport;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode;
    }

    public String getProgramno() {
        return programno;
    }

    public void setProgramno(String programno) {
        this.programno = programno;
    }

    public String getPurchasetoken() {
        return purchasetoken;
    }

    public void setPurchasetoken(String purchasetoken) {
        this.purchasetoken = purchasetoken;
    }

    public String getQamname() {
        return qamname;
    }

    public void setQamname(String qamname) {
        this.qamname = qamname;
    }

    public String getRequestheader() {
        return requestheader;
    }

    public void setRequestheader(String requestheader) {
        this.requestheader = requestheader;
    }

    public String getResponseheader() {
        return responseheader;
    }

    public void setResponseheader(String responseheader) {
        this.responseheader = responseheader;
    }

    public Integer getResponsetime() {
        return responsetime;
    }

    public void setResponsetime(Integer responsetime) {
        this.responsetime = responsetime;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSrcip() {
        return srcip;
    }

    public void setSrcip(String srcip) {
        this.srcip = srcip;
    }

    public Integer getSrcport() {
        return srcport;
    }

    public void setSrcport(Integer srcport) {
        this.srcport = srcport;
    }

    public Integer getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Integer statuscode) {
        this.statuscode = statuscode;
    }

    public String getStatusmsg() {
        return statusmsg;
    }

    public void setStatusmsg(String statusmsg) {
        this.statusmsg = statusmsg;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}