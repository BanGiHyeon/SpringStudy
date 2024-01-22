package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;
@Service("fs")
public class FoodServiceImpl implements FoodService{
	@Autowired
    private FoodDAO dao;
	@Override
	public List<FoodVO> foodFindData2(String name, String address) {
		// TODO Auto-generated method stub
		return dao.foodFindData2(name, address);
	}

	@Override
	public List<FoodVO> foodFindData(Map map) {
		// TODO Auto-generated method stub
		return dao.foodFindData(map);
	}

}