package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.memberdao.MemberDao;

public class ajaxMemberDeleteMo implements MemberCommend{
	@Override
	public void excuteCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		MemberDao dao = MemberDao.getInstance();
		HttpSession session = request.getSession();
		
		int rs = dao.delete(userId, userPw);
		if(rs==1) {
			
			session.removeAttribute("sessionId");
		}
		PrintWriter out = response.getWriter();
		out.write(rs+"");
		
		out.flush();
	}
}
