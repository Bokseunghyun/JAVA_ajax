package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDao;
import org.web.memberdto.MemberDto;

public class ajaxMemberListMo implements MemberCommend{

	@Override
	public void excuteCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userAddr = request.getParameter("userAddr");
		
		PrintWriter out = response.getWriter();
		out.write(getJSON());
		out.flush();
	}
		
		private String getJSON() {
			StringBuffer sf = new StringBuffer("");
			MemberDao dao = MemberDao.getInstance();
			
			ArrayList<MemberDto> lists = dao.memberList();
			
			sf.append("{\"result\":[");
			for(MemberDto dto:lists) {
				sf.append("{\"userId\":\""+dto.getUserId());
				sf.append("\",\"userPw\":\""+dto.getUserPw());
				sf.append("\",\"userName\":\""+dto.getUserName());
				sf.append("\",\"userAddr\":\""+dto.getUserAddr()+"\"},");
			}
			sf.delete(sf.length()-1,sf.length());
			
			sf.append("]}");
			System.out.println(sf.toString());
			
			return sf.toString();
		}
	}


