package com.sist.web;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.dao.*;
@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	
	@GetMapping("goods/list.do")
	public String goods_list()
	{
		return "goods/list";
	}
	
	@GetMapping(value="goods/list_vue.do",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	// => @RestController 
	public String goods_list_vue(int page)
	{
		// [{fno:1,poster:'',name:''},{fno:1,poster:'',name:''}....{startPage:1...}] 
		// VueJS =>연결전에 초기값을 설정
		/*
		 *   data(){
		 *      return {
		 *        page:1
		 *      }
		 *   }
		 */
		int rowSize=20;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		// WHERE num BETWEEN #{start} AND #{end}
		//                  map.get("start") map.get("end")
		List<GoodsVO> list=dao.goodsListData(map);
		int totalpage=dao.goodsTotalPage();
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		int i=0;
		JSONArray arr=new JSONArray(); // [] {}
		for(GoodsVO vo:list)
		{
			JSONObject obj=new JSONObject(); // VO를 담는 객체 
			obj.put("no", vo.getNo());
			obj.put("price", vo.getGoods_price());
			obj.put("poster", vo.getGoods_poster()); // [{"fno":1,"name":"aaa","poster":"..jpg",}
			if(i==0)
			{
			   obj.put("curpage", page);
			   obj.put("totalpage", totalpage);
			   obj.put("startPage", startPage);
			   obj.put("endPage", endPage);
			}
			arr.add(obj);
			i++;
		}
	    return arr.toJSONString();	
	}
	
	@GetMapping(value="goods/page_vue.do")
	@ResponseBody
	public String goods_page_vue(int page)
	{
		// =>startPage endPage curpage totalpage
		return "";
	}
}
