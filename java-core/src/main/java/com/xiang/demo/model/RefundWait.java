package com.xiang.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class RefundWait implements Serializable {
    /**
     * 待处理退款id
     */
    private String id;

    /**
     * 账号
     */
    private String account;

    /**
     * 订单ID
     */
    private Long orderid;

    /**
     * 生成退款时间
     */
    private Date time;

    /**
     * 订单时间
     */
    private Date ordertime;

    /**
     * 充值明细ID
     */
    private String orderdetailid;

    /**
     * 退款金额
     */
    private Double refund;

    /**
     * 充值的手机号
     */
    private String phone;

    /**
     * 审核状态，<0为待审核，0=通过 1=不用审核 2=审核驳回
     */
    private Integer auditstatus;

    /**
     * 审核原因
     */
    private String auditreason;

    /**
     * 审核人
     */
    private String auditor;

    /**
     * 审核时间
     */
    private Date audittime;

    /**
     * 备注详情
     */
    private String details;

    /**
     * 尝试处理次数
     */
    private Integer getcnt;

    /**
     * 占用工作者id
     */
    private String workerid;

    /**
     * 占用时间
     */
    private Date occupiedtime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public String getOrderdetailid() {
        return orderdetailid;
    }

    public void setOrderdetailid(String orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    public Double getRefund() {
        return refund;
    }

    public void setRefund(Double refund) {
        this.refund = refund;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(Integer auditstatus) {
        this.auditstatus = auditstatus;
    }

    public String getAuditreason() {
        return auditreason;
    }

    public void setAuditreason(String auditreason) {
        this.auditreason = auditreason;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getGetcnt() {
        return getcnt;
    }

    public void setGetcnt(Integer getcnt) {
        this.getcnt = getcnt;
    }

    public String getWorkerid() {
        return workerid;
    }

    public void setWorkerid(String workerid) {
        this.workerid = workerid;
    }

    public Date getOccupiedtime() {
        return occupiedtime;
    }

    public void setOccupiedtime(Date occupiedtime) {
        this.occupiedtime = occupiedtime;
    }
}