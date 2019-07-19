package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDao;
import org.web.memberdto.MemberDto;

public class ajaxMemberViewMo implements MemberCommend {

	@Override
	public void excuteCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		PrintWriter out = response.getWriter();
		out.write(getJSON(userId));
		out.flush();
	}

	private String getJSON(String userId) {
		StringBuffer sf = new StringBuffer();
		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = dao.memberView(userId);
		
		sf.append("{\"result\":[");
		sf.append("{\"userId\":\""+dto.getUserId()+"\",\"userPw\":\""+dto.getUserPw()+
				"\",\"userName\":\""+dto.getUserName()+
				"\",\"userAddr\":\""+dto.getUserAddr()+"\"");
		sf.append("}]}");
		System.out.println(sf.toString());
		
		return sf.toString();
	}
	
}
