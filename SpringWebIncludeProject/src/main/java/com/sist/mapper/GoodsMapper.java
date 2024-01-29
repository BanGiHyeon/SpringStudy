package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/*
 *   private int no,hit,goods_discount;
	 private String goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster;
 */
import org.apache.ibatis.annotations.Update;

import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;
public interface GoodsMapper {
	@Select("SELECT no,goods_price,goods_poster,num "
			+"FROM (SELECT no,goods_price,goods_poster,rownum as num "
			+"FROM (SELECT no,goods_price,goods_poster "
			+"FROM goods_all ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsTotalPage();
	
	@Update("UPDATE goods_all SET "
			+"hit=hit+1 "
			+"WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,goods_discount,goods_name,goods_sub,goods_price,"
			+"goods_first_price,goods_delivery,goods_poster "
			+"FROM goods_all "
			+"WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	
	@Select("SELECT no,goods_name,goods_poster,num "
			+"FROM (SELECT no,goods_name,goods_poster,rownum as num "
			+"FROM (SELECT no,goods_name,goods_poster "
			+"FROM goods_all "
			+"WHERE goods_sub LIKE '%'||#{ss}||'%'"
			+"ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all "
			+"WHERE goods_sub LIKE '%'||#{ss}||'%'")
	public int goodsFindTotalPage(Map map);
	
}
