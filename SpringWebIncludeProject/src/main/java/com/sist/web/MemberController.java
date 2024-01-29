package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class MemberController {
   @Autowired
   private MemberDAO dao;
   
   @GetMapping("member/login.do")
   public String member_login()
   {
      return "member/login";
   }
   @PostMapping("member/login_ok.do")
   public String member_login_ok(String id,String pwd,Model model,HttpSession session)//session은 매개변수로
   {
      MemberVO svo=new MemberVO();
      svo.setId(id);
      svo.setPwd(pwd);
      MemberVO vo=dao.memberLogin(svo);
      if(vo.getMsg().equals("OK"))
      {
         session.setAttribute("id", vo.getId());
         session.setAttribute("name", vo.getName());
      }
      model.addAttribute("msg",vo.getMsg());
      
      return "member/login_ok";
   }
   @PostMapping("member/logout.do")
   public String member_logout(HttpSession session)
   {
	   session.invalidate();
	   return "redirect:../main/main.do";
   }
}