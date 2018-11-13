package com.sino.pattern.strategy;

import java.math.BigDecimal;

/**
 * 支付参数
 * 
 * @author lonny
 *
 */

public class PayParams {

	// 金额
	private BigDecimal amount;
	// 支付渠道编码
	private String bankCode;
	// 支付订单号
	private String orderNo;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "PayParams [amount=" + amount + ", bankCode=" + bankCode + ", orderNo=" + orderNo + "]";
	}

}
