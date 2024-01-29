package com.sist.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.GoodsDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;
@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	@GetMapping("goods/goods_all.do")
	public String goods_main(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		List<GoodsVO> list=dao.goodsListData(start, end);
		int totalpage=dao.goodsTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../goods/goods_all.jsp");
		return "main/main";
	}
	@GetMapping("goods/detail_before.do")
	public String goods_detail_before(int no,HttpServletResponse response,RedirectAttributes ra)
	{
		// 쿠키는 일반 객체 => 매개변수로 받을 수 없다 
		Cookie cookie=new Cookie("goods_"+no, String.valueOf(no));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		// sendRedirect => 값 전송 
		ra.addAttribute("no", no);
		return "redirect:../goods/goods_detail.do";
	}
	@GetMapping("goods/goods_detail.do")
	public String goods_detail(int no,Model model)
	{
		GoodsVO vo=dao.goodsDetailData(no);
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../goods/goods_detail.jsp");
		return "main/main";
	}
	@RequestMapping("goods/goods_find.do")
	public String goods_find(String page,String ss,Model model)
	{
		if(ss==null)
			ss="가";
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		Map map=new HashedMap();
		map.put("ss", ss);
		map.put("start", start);
		map.put("end", end);
		List<GoodsVO> list=dao.goodsFindData(map);
		int totalpage=dao.goodsFindTotalPage(map);
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		model.addAttribute("ss", ss);
		
		model.addAttribute("main_jsp", "../goods/goods_find.jsp");
		return "main/main";
	}
}
