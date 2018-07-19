package com.sino.middle_ware.dao;

import java.util.List;

import com.sino.middle_ware.bean.City;

public interface CityDao {
	
    int deleteByPrimaryKey(Integer CityId);

    int insert(City record);

    City selectByPrimaryKey(Integer CityId);

    int updateByPrimaryKey(City record);
   
    List<City> selectAllCity();

	
    
    
}