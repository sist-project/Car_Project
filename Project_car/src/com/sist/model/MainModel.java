package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

public class MainModel {

	@RequestMapping("main/main.do")
	public String mainModel(HttpServletRequest request) {
//		System.out.println("메인모델");
		List<NewsVO> list=MainDAO.newsMainData();
//		System.out.println("메인뉴스:"+list.size());
		request.setAttribute("nList", list);
		
		List<CarVO> list1=MainDAO.carEfficiency();
//		System.out.println("연비효율:"+list1.size());
//		for(CarVO vo:list1)
//		{
//			System.out.println(vo.getCar_name());
//		}
		request.setAttribute("eList", list1);
		
		
		List<CarVO> list2=MainDAO.carRegdate();
		request.setAttribute("rList", list2);
//		for(CarVO vo:list2)
//		{
//			System.out.println(vo.getCar_name());
//		}
		
		List<CarVO> list3=MainDAO.carPriceList();
		request.setAttribute("pList", list3);
		
		List<AccVO> list4=MainDAO.carAccList();
		request.setAttribute("aList", list4);
		System.out.println(list4.size());
		
		
		List<CarVO> list5=MainDAO.carPopularList();
		request.setAttribute("poList", list5);
		
		request.setAttribute("main_jsp", "../cmmn/default-aside.jsp");

		
		return "main.jsp";
	}
	
	@RequestMapping("main/test.do")
	public String popup(HttpServletRequest request)
	{
		return "test.jsp";
	}
	
	@RequestMapping("main/test1.do")
	public String popup1(HttpServletRequest request)
	{
		return "test1.jsp";
	}
	
	@RequestMapping("main/test2.do")
	public String popup2(HttpServletRequest request)
	{
		return "test2.jsp";
	}
	
	@RequestMapping("main/test3.do")
	public String popup3(HttpServletRequest request)
	{
		return "test3.jsp";
	}
	
	@RequestMapping("main/test4.do")
	public String popup4(HttpServletRequest request)
	{
		return "test4.jsp";
	}
	
	@RequestMapping("main/test5.do")
	public String popup5(HttpServletRequest request)
	{
		return "test5.jsp";
	}
}
