package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDao;

public class ajaxMemberUpdateMo implements MemberCommend{

	@Override
	public void excuteCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userAddr = request.getParameter("userAddr");
		
		MemberDao dao = MemberDao.getInstance();
		int rs = dao.update(userId, userPw, userName, userAddr);
		
		PrintWriter out = response.getWriter();
		out.write(rs+"");
		out.flush();
		
	}

}
