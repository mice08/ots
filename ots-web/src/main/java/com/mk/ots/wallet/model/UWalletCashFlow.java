package com.mk.ots.wallet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mk.framework.util.CashflowTypeEnumSerializer;

import java.math.BigDecimal;
import java.util.Date;

public class UWalletCashFlow {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_wallet_cashflow.id
     *
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_wallet_cashflow.mid
     *
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    @JsonIgnore
    private Long mid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_wallet_cashflow.cashflowtype
     *
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    @JsonSerialize(using = CashflowTypeEnumSerializer.class)
    private CashflowTypeEnum cashflowtype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_wallet_cashflow.price
     *
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_wallet_cashflow.sourceid
     *
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    private Long sourceid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_wallet_cashflow.createtime
     *
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    @JsonFormat(pattern = "yyyyMMddHHmmss",timezone="GMT+8")
    private Date createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_wallet_cashflow.id
     *
     * @return the value of u_wallet_cashflow.id
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_wallet_cashflow.id
     *
     * @param id the value for u_wallet_cashflow.id
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_wallet_cashflow.mid
     *
     * @return the value of u_wallet_cashflow.mid
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    public Long getMid() {
        return mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_wallet_cashflow.mid
     *
     * @param mid the value for u_wallet_cashflow.mid
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_wallet_cashflow.cashflowtype
     *
     * @return the value of u_wallet_cashflow.cashflowtype
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    public CashflowTypeEnum getCashflowtype() {
        return cashflowtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_wallet_cashflow.cashflowtype
     *
     * @param cashflowtype the value for u_wallet_cashflow.cashflowtype
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    public void setCashflowtype(CashflowTypeEnum cashflowtype) {
        this.cashflowtype = cashflowtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_wallet_cashflow.price
     *
     * @return the value of u_wallet_cashflow.price
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_wallet_cashflow.price
     *
     * @param price the value for u_wallet_cashflow.price
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_wallet_cashflow.sourceid
     *
     * @return the value of u_wallet_cashflow.sourceid
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    public Long getSourceid() {
        return sourceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_wallet_cashflow.sourceid
     *
     * @param sourceid the value for u_wallet_cashflow.sourceid
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    public void setSourceid(Long sourceid) {
        this.sourceid = sourceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_wallet_cashflow.createtime
     *
     * @return the value of u_wallet_cashflow.createtime
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_wallet_cashflow.createtime
     *
     * @param createtime the value for u_wallet_cashflow.createtime
     * @mbggenerated Wed Sep 09 15:07:34 CST 2015
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}