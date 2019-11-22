package com.sino.base.HashDemo;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * @author yulong
 * @create 2019/11/19
 * 非加密hash
 */
public class MurmurHash {

    public static void main(String[] args) {
        HashFunction hashFunction = Hashing.murmur3_32();
        HashCode hashCode = hashFunction.hashString("123", Charset.forName("UTF-8"));
        System.out.println(hashCode);
    }

}
