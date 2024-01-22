package com.sist.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sist.dao.FoodVO;

public interface FoodService {
	public List<FoodVO> foodFindData2(@Param("name") String name,@Param("address") String address);
	public List<FoodVO> foodFindData(Map map);
}