package com.sino.pattern.strategy;

/**
 * @author lonny
 * 策略模式
 * 支付选择的维度
 * 
 * 1.通道健康指标(C1 -招行不可用  C2-工行不可用)
 * 2.支付限额(C1单笔  5000  C2 单笔最高 100000)
 * 3.费率优惠程度（c1 0-3000  0.01%  3000+ 0.03%   c2 0-5000  0.015%  5000+ 0.02%）
 * 4.支付成功率 （C1 98.1% C2 97.8%）
 */
public interface PayStrategy {

	ChannelEnum selectChannel(PayParams payParams);
	
	
	 
}
