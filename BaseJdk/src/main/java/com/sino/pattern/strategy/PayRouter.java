package com.sino.pattern.strategy;

public class PayRouter {
	
	private PayStrategy payStrategy;

	public PayStrategy getPayStrategy() {
		return payStrategy;
	}

	public void setPayStrategy(PayStrategy payStrategy) {
		this.payStrategy = payStrategy;
	}
	
	public ChannelEnum pay(PayParams payParams){
		
		return this.payStrategy.selectChannel(payParams);
		
	}
	
	/**
	 * 组合策略
	 * 根据优先级选择如果返回unknow 那么选择下一个维度
	 */
	
	
	
	
	
}
