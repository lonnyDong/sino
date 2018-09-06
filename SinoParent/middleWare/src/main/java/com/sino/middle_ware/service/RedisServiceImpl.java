//package com.sino.middle_ware.service;
//
//import java.util.concurrent.TimeUnit;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Service;
//import com.sino.middle_ware.bean.City;
//import com.sino.middle_ware.dao.CityDao;
//
//@Service
//public class RedisServiceImpl implements RedisService {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(RedisServiceImpl.class);
//
//	@Autowired
//	private RedisTemplate redisTemplate;
//	
//	@Autowired
//	CityDao cityDao;
//
//	/**
//	 * 从数据库获取
//	 */
//	City getCityFromDb(int id){
//		return cityDao.selectByPrimaryKey(id);
//	}
//	
//	
//	/**
//	 * 获取城市逻辑： 如果缓存存在，从缓存中获取城市信息 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public City findCityById(int id) {
//		// 从缓存中获取城市信息
//		String key = "city_sino_" + id;
//		ValueOperations<String, City> operations = redisTemplate.opsForValue();
//		boolean hasKey = redisTemplate.hasKey(key);
//		if (hasKey) {
//			City city = operations.get(key);
//
//			LOGGER.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + city.toString());
//			return city;
//		}
//		City city = getCityFromDb(id);
//		operations.set(key, city, 80, TimeUnit.SECONDS);
//		LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());
//		return city;
//	}
//
//	@Override
//	public int saveCity(City city) {
//		int insert = cityDao.insert(city);
//		return insert;
//	}
//
//	/**
//	 * 更新城市逻辑： 如果缓存存在，删除 如果缓存不存在，不操作
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public int updateCity(City city) {
//		int ret = cityDao.updateByPrimaryKey(city);
//
//		// 缓存存在，删除缓存
//		String key = "city_sino_" + city.getId();
//		boolean hasKey = redisTemplate.hasKey(key);
//		if (hasKey) {
//			redisTemplate.delete(key);
//			LOGGER.info("CityServiceImpl.updateCity() : 从缓存中删除城市 >> " + city.toString());
//		}
//
//		return ret;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public int deleteCity(int id) {
//
//		int ret = cityDao.deleteByPrimaryKey(id);
//		String key = "city_sino_" + id;
//		boolean hasKey = redisTemplate.hasKey(key);
//		if (hasKey) {
//			redisTemplate.delete(key);
//			LOGGER.info("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> " + id);
//		}
//		return ret;
//	}
//
//	@Override
//	public String test() {
//
//		return "test redis success!";
//	}
//
//}
