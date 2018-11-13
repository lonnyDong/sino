package com.sino.pattern.strategy;

import java.math.BigDecimal;
//c1 0-3000  0.03%  3000+ 0.02%   c2 0-5000  0.035%  5000+ 0.015%
//0-3000  3000-5000  5000+

/**
 * 根据费率计算维度
 * @author lonny
 *
 */
public class FeeRateStrategy implements PayStrategy{

	
	private BigDecimal B_5000 = new BigDecimal(5000);
	
	
	@Override
	public ChannelEnum selectChannel(PayParams payParams) {

		BigDecimal amount = payParams.getAmount();

		int compareTo = B_5000.compareTo(amount);
		if (compareTo == -1) {
			return ChannelEnum.BOFOO;
		} else if (compareTo == 1) {
			return ChannelEnum.FUIOU;
		} else {
			return ChannelEnum.UNKOWN;
		}

	}


	
	

}
