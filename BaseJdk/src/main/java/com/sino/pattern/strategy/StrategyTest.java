package com.sino.pattern.strategy;

import java.math.BigDecimal;

public class StrategyTest {


	
	
	public static void main(String[] args) {
		PayParams payParams = new PayParams();
		payParams.setAmount(new BigDecimal("6000"));
		payParams.setBankCode("cmb");
		payParams.setOrderNo("j001002003");
		
		PayRouter payRouter = new PayRouter();
//		AmountLimitedStrategy amountLimitedStrategy = new AmountLimitedStrategy();
		
		FeeRateStrategy feeRateStrategy = new FeeRateStrategy();
		
		payRouter.setPayStrategy(feeRateStrategy);
		ChannelEnum pay = payRouter.pay(payParams);
		System.out.println(pay);
		
		
	}
	
	
}
