package com.pattern.abfactory;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

/**
 * @Description:
 * @Author: WangYuJ
 * @Date 2018/6/28
 */
@Entity
@Table(name = "RECEIPT_COMBINE_FEE", schema = "YSPOS_BOSS", catalog = "")
public class ReceiptCombineFee {
    private String id;
    private Long paySum;
    private String fileAddr;
    private Time createDate;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PAY_SUM")
    public Long getPaySum() {
        return paySum;
    }

    public void setPaySum(Long paySum) {
        this.paySum = paySum;
    }

    @Basic
    @Column(name = "FILE_ADDR")
    public String getFileAddr() {
        return fileAddr;
    }

    public void setFileAddr(String fileAddr) {
        this.fileAddr = fileAddr;
    }

    @Basic
    @Column(name = "CREATE_DATE")
    public Time getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Time createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptCombineFee that = (ReceiptCombineFee) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(paySum, that.paySum) &&
                Objects.equals(fileAddr, that.fileAddr) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, paySum, fileAddr, createDate);
    }
}
