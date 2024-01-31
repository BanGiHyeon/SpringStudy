package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
	@GetMapping("food/list.do")
	public String food_list()
	{
		return "food/list";//forward/sendRedirect => 파일명만 전송이 가능 
	}
}
