//package com.sino.middle_ware.test;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import com.sino.middle_ware.bean.City;
//import com.sino.middle_ware.dao.CityDao;
////import com.sino.middle_ware.service.RedisService;
//
//import redis.clients.jedis.JedisCluster;
//import redis.clients.jedis.SortingParams;
//
//
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration(locations="classpath:application.properties")
//public class JedisTestDemo {
//
//	@Autowired
//	JedisCluster jedisCluster;
//	
//	@Autowired
//	CityDao cityDao;
//	
////	@Autowired
////	RedisService redisServiceImpl;
//	
//	@Autowired
//	private RedisTemplate redisTemplate;
//	
//	
////	private static final String HASH_KEY_CITY = "h_sino_city_";
//	
//	 /***  
//     * 列表  
//     *//*  
//    @Test  
//    public void testList() {  
//        System.out.println("===========添加一个list===========");  
//        jedisCluster.lpush("collections", "ArrayList", "Vector", "Stack", "HashMap", "WeakHashMap", "LinkedHashMap");  
//        jedisCluster.lpush("collections", "HashSet"); // 叠加  
//        jedisCluster.lpush("collections", "TreeSet"); // 叠加  
//        jedisCluster.lpush("collections", "TreeMap"); // 叠加  
//        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));//-1代表倒数第一个元素，-2代表倒数第二个元素  
//        System.out.println("collections区间0-3的元素："+jedisCluster.lrange("collections",0,3)); // 前面4个值  
//        System.out.println("===============================");  
//        // 删除列表指定的值 ，第二个参数为删除的个数（有重复时），后add进去的值先被删，类似于出栈  
//        System.out.println("删除指定元素个数："+jedisCluster.lrem("collections", 2, "HashMap"));  
//        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));  
//        System.out.println("删除下表0-3区间之外的元素："+jedisCluster.ltrim("collections", 0, 3));  
//        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));  
//        System.out.println("collections列表出栈（左端）："+jedisCluster.lpop("collections"));  
//        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));  
//        System.out.println("collections添加元素，从列表右端，与lpush相对应："+jedisCluster.rpush("collections", "EnumMap"));  
//        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));  
//        System.out.println("collections列表出栈（右端）："+jedisCluster.rpop("collections"));  
//        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));  
//        System.out.println("修改collections指定下标1的内容："+jedisCluster.lset("collections", 1, "LinkedArrayList"));  
//        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));  
//        System.out.println("===============================");  
//        System.out.println("collections的长度："+jedisCluster.llen("collections"));  
//        System.out.println("获取collections下标为2的元素："+jedisCluster.lindex("collections", 2));  
//        System.out.println("===============================");  
//        jedisCluster.lpush("sortedList", "3","6","2","0","7","4");  
//        System.out.println("sortedList排序前："+jedisCluster.lrange("sortedList", 0, -1));  
//        System.out.println(jedisCluster.sort("sortedList"));  
//        System.out.println("sortedList排序后："+jedisCluster.lrange("sortedList", 0, -1));  
//    }  
//  
//    *//***  
//     * set集合  
//     *//*  
//    @Test  
//    public void testSet() {  
//        System.out.println("============向集合中添加元素============");  
//        System.out.println(jedisCluster.sadd("eleSet", "e1","e2","e4","e3","e0","e8","e7","e5"));  
//        System.out.println(jedisCluster.sadd("eleSet", "e6"));  
//        System.out.println(jedisCluster.sadd("eleSet", "e6")); // 返回0，集合中已经存在  
//        System.out.println("eleSet的所有元素为："+jedisCluster.smembers("eleSet"));  
//        System.out.println("删除一个元素e0："+jedisCluster.srem("eleSet", "e0"));  
//        System.out.println("eleSet的所有元素为："+jedisCluster.smembers("eleSet"));  
//        System.out.println("删除两个元素e7和e6："+jedisCluster.srem("eleSet", "e7","e6"));  
//        System.out.println("eleSet的所有元素为："+jedisCluster.smembers("eleSet"));  
//        System.out.println("随机的移除集合中的一个元素："+jedisCluster.spop("eleSet"));  
//        System.out.println("随机的移除集合中的一个元素："+jedisCluster.spop("eleSet"));  
//        System.out.println("eleSet的所有元素为："+jedisCluster.smembers("eleSet"));  
//        System.out.println("eleSet中包含元素的个数："+jedisCluster.scard("eleSet"));  
//        System.out.println("e3是否在eleSet中："+jedisCluster.sismember("eleSet", "e3"));  
//        System.out.println("e1是否在eleSet中："+jedisCluster.sismember("eleSet", "e1"));  
//        System.out.println("e5是否在eleSet中："+jedisCluster.sismember("eleSet", "e5"));  
//  
//        // 集群下并存会报错：redis.clients.jedisCluster.exceptions.JedisClusterException: No way to dispatch this command to Redis Cluster because keys have different slots.  
//        // Redis集群，从key1集合与key2集合并存、交集、差集，两个键经过crc16算法可能有不同的槽。  
//        System.out.println("=================================");  
//        System.out.println(jedisCluster.sadd("eleSet1", "e1","e2","e4","e3","e0","e8","e7","e5"));  
//        System.out.println(jedisCluster.sadd("eleSet2", "e1","e2","e4","e3","e0","e8"));  
//        System.out.println("将eleSet1中删除e1并存入eleSet3中："+jedisCluster.smove("eleSet1", "eleSet3", "e1"));  
//        System.out.println("将eleSet1中删除e2并存入eleSet3中："+jedisCluster.smove("eleSet1", "eleSet3", "e2"));  
//        System.out.println("eleSet1中的元素："+jedisCluster.smembers("eleSet1"));  
//        System.out.println("eleSet3中的元素："+jedisCluster.smembers("eleSet3")); 
//  
//       System.out.println("============集合运算=================");  
//        System.out.println("eleSet1中的元素："+jedisCluster.smembers("eleSet1"));  
//        System.out.println("eleSet2中的元素："+jedisCluster.smembers("eleSet2"));  
//        System.out.println("eleSet1和eleSet2的交集:"+jedisCluster.sinter("eleSet1","eleSet2"));  
//        System.out.println("eleSet1和eleSet2的并集:"+jedisCluster.sunion("eleSet1","eleSet2"));  
//        System.out.println("eleSet1和eleSet2的差集:"+jedisCluster.sdiff("eleSet1","eleSet2"));
//        jedisCluster.del("eleSet");  
//        jedisCluster.del("eleSet1");  
//        jedisCluster.del("eleSet2");  
//        jedisCluster.del("eleSet3");  
//    }  
//  
//    *//***  
//     * 散列  hash
//     *//*  
//    @Test  
//    public void testHash() {  
//        Map<String,String> map = new HashMap<String,String>();  
//        map.put("key1","value1");  
//        map.put("key2","value2");  
//        map.put("key3","value3");  
//        map.put("key4","value4");  
//        jedisCluster.hmset("hash",map);  
//        jedisCluster.hset("hash", "key5", "value5");  
//        System.out.println("散列hash的所有键值对为："+jedisCluster.hgetAll("hash"));//return Map<String,String>  
//        System.out.println("散列hash的所有键为："+jedisCluster.hkeys("hash"));//return Set<String>  
//        System.out.println("散列hash的所有值为："+jedisCluster.hvals("hash"));//return List<String>  
//        System.out.println("将key6保存的值加上一个整数，如果key6不存在则添加key6："+jedisCluster.hincrBy("hash", "key6", 6));  
//        System.out.println("散列hash的所有键值对为："+jedisCluster.hgetAll("hash"));  
//        System.out.println("将key6保存的值加上一个整数，如果key6不存在则添加key6："+jedisCluster.hincrBy("hash", "key6", 3));  
//        System.out.println("散列hash的所有键值对为："+jedisCluster.hgetAll("hash"));  
//        System.out.println("删除一个或者多个键值对："+jedisCluster.hdel("hash", "key2"));  
//        System.out.println("散列hash的所有键值对为："+jedisCluster.hgetAll("hash"));  
//        System.out.println("散列hash中键值对的个数："+jedisCluster.hlen("hash"));  
//        System.out.println("判断hash中是否存在key2："+jedisCluster.hexists("hash","key2"));  
//        System.out.println("判断hash中是否存在key3："+jedisCluster.hexists("hash","key3"));  
//        System.out.println("获取hash中的值："+jedisCluster.hmget("hash","key3"));  
//        System.out.println("获取hash中的值："+jedisCluster.hmget("hash","key3","key4"));  
//    }  
//  
//    *//**  
//     * 有序集合  
//     *//*  
//    @Test  
//    public void testSortedSet() {  
//        Map<String,Double> map = new HashMap<String,Double>();  
//        map.put("key2",1.2);  
//        map.put("key3",4.0);  
//        map.put("key4",5.0);  
//        map.put("key5",0.2);  
//        // 将一个或多个 member 元素及其 score 值加入到有序集 key 当中，如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值  
//        // score 值可以是整数值或双精度浮点数  
//        System.out.println(jedisCluster.zadd("zset", 3,"key1"));  
//        System.out.println(jedisCluster.zadd("zset",map));  
//        System.out.println("zset中的所有元素："+jedisCluster.zrange("zset", 0, -1));  
//        System.out.println("zset中的所有元素："+jedisCluster.zrangeWithScores("zset", 0, -1));  
//        System.out.println("zset中的所有元素："+jedisCluster.zrangeByScore("zset", 0,100));  
//        System.out.println("zset中的所有元素："+jedisCluster.zrangeByScoreWithScores("zset", 0,100));  
//        System.out.println("zset中key2的分值："+jedisCluster.zscore("zset", "key2"));  
//        System.out.println("zset中key2的排名："+jedisCluster.zrank("zset", "key2"));  
//        System.out.println("删除zset中的元素key3："+jedisCluster.zrem("zset", "key3"));  
//        System.out.println("zset中的所有元素："+jedisCluster.zrange("zset", 0, -1));  
//        System.out.println("zset中元素的个数："+jedisCluster.zcard("zset"));  
//        System.out.println("zset中分值在1-4之间的元素的个数："+jedisCluster.zcount("zset", 1, 4));  
//        System.out.println("key2的分值加上5："+jedisCluster.zincrby("zset", 5, "key2"));  
//        System.out.println("key3的分值加上4："+jedisCluster.zincrby("zset", 4, "key3"));  
//        System.out.println("zset中的所有元素："+jedisCluster.zrange("zset", 0, -1));  
//    }  
//  
//    *//**  
//     * 排序  
//     *//*  
//    @Test  
//    public void testSort() {  
//        jedisCluster.lpush("collections", "ArrayList", "Vector", "Stack", "HashMap", "WeakHashMap", "LinkedHashMap");  
//        System.out.println("collections的内容："+jedisCluster.lrange("collections", 0, -1));  
//        SortingParams sortingParameters = new SortingParams();  
//        // 当数据集中保存的是字符串值时，你可以用 ALPHA,默认是升序  
//        System.out.println("alpha排序方式：" + jedisCluster.sort("collections",sortingParameters.alpha()));  
//        System.out.println("===============================");  
//        jedisCluster.lpush("sortedList", "3","6","2","0","7","4");  
//        System.out.println("sortedList排序前："+jedisCluster.lrange("sortedList", 0, -1));  
//        System.out.println("升序："+jedisCluster.sort("sortedList", sortingParameters.asc()));  
//        System.out.println("降序："+jedisCluster.sort("sortedList", sortingParameters.desc()));  
//        System.out.println("===============================");  
//        // 集群下不支持分割表排序  
//        jedisCluster.lpush("userlist", "33");  
//        jedisCluster.lpush("userlist", "22");  
//        jedisCluster.lpush("userlist", "55");  
//        jedisCluster.lpush("userlist", "11");  
//        jedisCluster.hset("user:66", "name", "66");  
//        jedisCluster.hset("user:55", "name", "55");  
//        jedisCluster.hset("user:33", "name", "33");  
//        jedisCluster.hset("user:22", "name", "79");  
//        jedisCluster.hset("user:11", "name", "24");  
//        jedisCluster.hset("user:11", "add", "beijing");  
//        jedisCluster.hset("user:22", "add", "shanghai");  
//        jedisCluster.hset("user:33", "add", "guangzhou");  
//        jedisCluster.hset("user:55", "add", "chongqing");  
//        jedisCluster.hset("user:66", "add", "xi'an");  
//        sortingParameters = new SortingParams();  
//        // 符号 "->" 用于分割哈希表的键名(key name)和索引域(hash field)，格式为 "key->field"  
//        sortingParameters.get("user:*->name");  
//        sortingParameters.get("user:*->add");  
//        System.out.println(jedisCluster.sort("userlist",sortingParameters));  
//    }
//	
//	*//***  
//     * 整数和浮点数  
//     *//*  
//     
//	@Test
//	public void jedisClusterTest2() {
//
//		jedisCluster.set("key1", "1");
//		jedisCluster.set("key2", "2");
//		jedisCluster.set("key3", "2.3");
//		System.out.println("key1的值：" + jedisCluster.get("key1"));
//		System.out.println("key2的值：" + jedisCluster.get("key2"));
//		System.out.println("key1的值加1：" + jedisCluster.incr("key1"));
//		System.out.println("获取key1的值：" + jedisCluster.get("key1"));
//		System.out.println("key2的值减1：" + jedisCluster.decr("key2"));
//		System.out.println("获取key2的值：" + jedisCluster.get("key2"));
//		System.out.println("将key1的值加上整数5：" + jedisCluster.incrBy("key1", 5));
//		System.out.println("获取key1的值：" + jedisCluster.get("key1"));
//		System.out.println("将key2的值减去整数5：" + jedisCluster.decrBy("key2", 5));
//		System.out.println("获取key2的值：" + jedisCluster.get("key2"));
//		System.out.println("key3的值：" + jedisCluster.get("key3"));
//
//	}
//	
//	
//	
//	*//**
//	 *cluster -- String 
//	 *//*
//	@Test
//	public void jedisClusterTest() {
//		jedisCluster.set("name", "zhangsan");
//		String name = jedisCluster.get("name");
//		System.err.println("name:"+name);
//        System.out.println("判断某个键是否存在："+jedisCluster.exists("username"));  
//        System.out.println("新增<'username','wukong'>的键值对："+jedisCluster.set("username", "xiaohai"));  
//        System.out.println("是否存在:"+jedisCluster.exists("username"));  
//        System.out.println("新增<'password','password'>的键值对："+jedisCluster.set("password", "123456"));  
//        System.out.println("删除键password:"+jedisCluster.del("password"));  
//        System.out.println("判断键password是否存在："+jedisCluster.exists("password"));  
//        System.out.println("设置键username的过期时间为10s:"+jedisCluster.expire("username", 10));  
//        try {
//			TimeUnit.SECONDS.sleep(2);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		} 
//        System.out.println("查看键username的剩余生存时间："+jedisCluster.ttl("username"));  
//        System.out.println("移除键username的生存时间："+jedisCluster.persist("username"));  
//        System.out.println("查看键username的剩余生存时间："+jedisCluster.ttl("username"));  
//        System.out.println("查看键username所存储的值的类型："+jedisCluster.type("username"));
//	}
//	
//	
//	
//	*//***
//	 * hash 类型数据
//	 */
//	@Test
//	public void HashTest() {
//		
//		HashOperations opsForHash = redisTemplate.opsForHash();
//		HashMap<String,Object> city = new HashMap<>();
//		city.put("id", 1);
//		city.put("name", "重庆");
//		city.put("simple_name", "渝");
//		
//		HashMap<String,Object> city2 = new HashMap<>();
//		city2.put("id", 2);
//		city2.put("name", "广州");
//		city2.put("simple_name", "穗");
//
////		opsForHash.put(HASH_KEY_CITY, HASH_KEY_CITY+1, city);
////		opsForHash.put(HASH_KEY_CITY, HASH_KEY_CITY+2, city2);
////		
////		opsForHash.putAll(HASH_KEY_CITY+1, city);
////		opsForHash.putAll(HASH_KEY_CITY+2, city2);
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
////	
////	@Test
////	public void test3() {
////		City findCityById = redisServiceImpl.findCityById(1);
////		System.out.println(findCityById);
////		int deleteCity = redisServiceImpl.deleteCity(2);
//////		redisServiceImpl.updateCity(city);
////		
////		
////	}
//	
//	@Test
//	public void test2() {
//		City city = new City("武汉", "汉");
//		cityDao.insert(city);
//		City selectByPrimaryKey = cityDao.selectByPrimaryKey(1);
//	
//	}
//	
//	
////	
////	@Test
////	public void test() {
////		
////		for (int i = 0; i < 3; i++) {
////			System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
////		}
////		
////		
////		Jedis resource = jedisPool.getResource();
////		resource.set("cityName", "wuhan");
////		Long db = resource.getDB();
////		System.err.println("输出db:"+db);
////		
////		
////		Jedis db2 = jedisPool.getResource();
////		System.err.println("输出db2:"+db2);
////		
////		int numActive = jedisPool.getNumActive();
////		
////		System.out.println("numActive:"+numActive);
////		
////	}
//	
//	
//	
//	
//	
//	
//}
