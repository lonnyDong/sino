package redislock.dao;



import redislock.bean.City;

import java.util.List;

/**
 * @author Administrator
 */
public interface CityDao {
	
    int deleteByPrimaryKey(Integer CityId);

    int insert(City record);

    City selectByPrimaryKey(Integer CityId);

    int updateByPrimaryKey(City record);
   
    List<City> selectAllCity();

	
    
    
}