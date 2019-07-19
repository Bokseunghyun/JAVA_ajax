package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logOutOkMo implements MemberCommend {

	@Override
	public void excuteCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if(session!=null)
		{
			session.invalidate();
			out.write("1");
		}else {
			out.write("0");
		}
		
		out.flush();
		
	}

}
