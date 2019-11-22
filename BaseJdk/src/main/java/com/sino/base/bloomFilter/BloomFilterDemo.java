package com.sino.base.bloomFilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yulong
 * @create 2019/11/19
 * <p>
 * 布隆过滤器
 */
public class BloomFilterDemo {

    /**
     * 创建一个插入对象为一亿，误报率为0.01%的布隆过滤器
     */

    private static final BloomFilter<String> dealIdBloomFilter = BloomFilter.create(new Funnel<String>() {

        private static final long serialVersionUID = 1L;

        @Override
        public void funnel(String arg0, PrimitiveSink arg1) {

            arg1.putString(arg0, Charsets.UTF_8);
        }

    }, 1000000, 0.0001);


    private final BloomFilter<String> dealIdBloomFilter2 = BloomFilter.create(new Funnel<String>() {

        private static final long serialVersionUID = 1L;

        @Override
        public void funnel(String arg0, PrimitiveSink arg1) {

            arg1.putString(arg0, Charsets.UTF_8);
        }

    }, 1024 * 1024 * 32, 0.0000001d);//fpp 失误率


    public synchronized boolean containsDealId(String deal_id) {

        if (StringUtils.isEmpty(deal_id)) {

            return true;
        }

        boolean exists = dealIdBloomFilter.mightContain(deal_id);
        if (!exists) {
            dealIdBloomFilter.put(deal_id);
        }
        return exists;
    }


    public static void main(String[] args) {

        for (int i = 10; i <= 100; i++) {
            dealIdBloomFilter.put(i + "");
            boolean b = dealIdBloomFilter.mightContain(i + "");
            System.out.println(i + "is contains:" + b);

        }

    }
}
