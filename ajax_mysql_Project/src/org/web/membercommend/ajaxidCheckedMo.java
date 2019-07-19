package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDao;

public class ajaxidCheckedMo implements MemberCommend{

	@Override
	public void excuteCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		MemberDao dao = MemberDao.getInstance();
		
		int rs = dao.idChecked(userId);
		PrintWriter out = response.getWriter();
		out.write(rs+"");
		out.flush();
	}

}
