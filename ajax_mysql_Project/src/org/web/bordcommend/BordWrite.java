package org.web.bordcommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.borddao.BordDao;

public class BordWrite implements BordCommend{

	@Override
	public void excuteCommend(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			
			System.out.println("글쓰기");
		
		 String nickName = request.getParameter("nickName");
		 String userId = request.getParameter("userId");
		 String mPw = request.getParameter("mPw");
		 String title = request.getParameter("title");
		 String memo = request.getParameter("memo");
		 
		 BordDao dao = BordDao.getInstance();
		int rs = dao.write(nickName, userId, mPw, title, memo);
		
		PrintWriter out = response.getWriter();
		out.write(rs+"");
		out.flush();
		 
	}

}
