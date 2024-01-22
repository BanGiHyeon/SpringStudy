package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository("fDao")
public class FoodDAO {
   @Autowired
   private FoodMapper mapper;
   
   public List<FoodVO> foodFindData(Map map)
   {
	   return mapper.foodFindData(map);
   }
   
   public List<FoodVO> foodFindData2(String name,String address)
   {
	   return mapper.foodFindData2(name, address);
   }
}