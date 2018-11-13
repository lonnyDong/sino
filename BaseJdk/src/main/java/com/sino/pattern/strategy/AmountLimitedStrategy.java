package com.sino.pattern.strategy;

import java.math.BigDecimal;

/**
 * 
 * @author lonny
 *
 */
public class AmountLimitedStrategy implements PayStrategy {

	BigDecimal LIMIT_5000 = new BigDecimal("5000");

	@Override
	public ChannelEnum selectChannel(PayParams payParams) {

		int compareTo = LIMIT_5000.compareTo(payParams.getAmount());

		// 支付限额(C1单笔 5000 C2 单笔最高 100000)
		if (compareTo == -1) {
			return ChannelEnum.BOFOO;

		} else if (compareTo == 1) {
			return ChannelEnum.FUIOU;
		} else {
			return ChannelEnum.UNKOWN;
		}

	}

}
