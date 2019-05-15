package com.sist.dao;


import java.util.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;


/*
 * 
 */
public class AccDAO {
	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
		
	}
	
/*	public static List<AccVO> accListData()
	{
		List<AccVO> list =new ArrayList<AccVO>();
		//연결 =>SqlSession (Connection ,PreparedStatement)
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("accListData");

			
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		finally {
			if(session!=null)
				session.close();
		}
		return list;
	}*/
	public static AccVO accDetailData(String product_id)
	{
		AccVO list =new AccVO();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectOne("accDetailData",product_id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(session!=null)
			session.close();
		}
		return list;
	}
	   public static List<AccVO> accListData(Map map)
	   {
		   List<AccVO> list=new ArrayList<AccVO>();
		   // 연결 => SqlSession (Connection,PreparedStatement)
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession();//connection연결
			   list=session.selectList("accListData",map);
			   
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();//Error처리 
			   /*session.rollback();*/
		   }
		   finally
		   {
			   // 반환 => DBCP ==> 반드시 사용후에 반환 
			   if(session!=null)
				   session.close();
		   }
		   return list;
	   }
	   
	   public static int accTotalPage(Map map)
	   {
		   int list=0;
		   // 연결 => SqlSession (Connection,PreparedStatement)
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession();//connection연결
			   list=session.selectOne("accTotalPage",map);
			   
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();//Error처리 
			   /*session.rollback();*/
		   }
		   finally
		   {
			   // 반환 => DBCP ==> 반드시 사용후에 반환 
			   if(session!=null)
				   session.close();
		   }
		   return list;
	   }
	   public static List<AccVO> accCate(String name)
		{
			List<AccVO> list =new ArrayList<AccVO>();
			//연결 =>SqlSession (Connection ,PreparedStatement)
			SqlSession session=null;
			try {
				session=ssf.openSession();
				list=session.selectList("accCate",name);

				
			} catch (Exception ex) {
				ex.printStackTrace();
				
			}
			finally {
				if(session!=null)
					session.close();
			}
			return list;
		}
	   public static List<AccVO> accSearchData(String keyword)
		{
			List<AccVO> list=new ArrayList<AccVO>();
			SqlSession session=null;
			try
			{
				session=ssf.openSession();
				list=session.selectList("accSearchData",keyword);
			}
			catch(Exception ex)
			{
				ex.printStackTrace(); 
			}
			finally
			{
				if(session!=null)
	    			session.close();
			}
			return list;
		}
	   

		// 찜 저장
		public static void accInsert(Acc_payVO vo) {
			SqlSession session = null;
			try {
				// session생성
				session = ssf.openSession(true);
				session.insert("accInsert", vo);

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (session != null)
					session.close();
			}
		}


		// 확인
		public static int accOkCount(Acc_payVO vo) {
			int count = 0;
			SqlSession session = null;
			try {
				// session생성
				session = ssf.openSession();
				count=session.selectOne("accOkCount", vo);

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (session != null)
					session.close();
			}

			return count;

		}
		//목록 출력
		public static List<String> accGetData(String id)
		{
			List<String> list=new ArrayList<String>();
			SqlSession session=null;
			
			try {
				session=ssf.openSession();
				list=session.selectList("accGetData",id);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			finally {
				if (session != null)
					session.close();
				
			}
			return list;
			
		}
		

}
