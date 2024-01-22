package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;
public interface FoodMapper {
  /*
   *      namespace="com.sist.mapper.FoodMapper"
   *      <select id="foodFindData" resultType="FoodVO" parameterType="hashmap">
		    SELECT fno,name,type,address,price,content
		    FROM food_menu_house
		    WHERE ${col_name} LIKE '%'||#{ss}||'%'
		  </select>
		  µ¿Àû Äõ¸® 
   */
  public List<FoodVO> foodFindData(Map map);
  
  @Select("SELECT fno,name,address "
		 +"FROM food_menu_house "
		 +"WHERE name LIKE '%'||#{name}||'%' AND address LIKE '%'||#{address}||'%'")
  public List<FoodVO> foodFindData2(@Param("name") String name,@Param("address") String address);
}