package org.web.bordcommend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.borddao.BordDao;
import org.web.borddto.BordDto;
import org.web.memberdao.MemberDao;
import org.web.memberdto.MemberDto;

public class BordMbord implements BordCommend{

	@Override
	public void excuteCommend(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String userId = request.getParameter("userId");
		PrintWriter out = response.getWriter();
		out.write(getJSON(userId));
		out.flush();
	}
	private String getJSON(String userId) {
		BordDao dao = BordDao.getInstance();
		StringBuffer sf = new StringBuffer("");
		ArrayList<BordDto> lists = dao.mBordList(userId);
	
		sf.append("{\"result1\":[");
		for(BordDto dto:lists) {
						
			sf.append("{\"mId\":\""+dto.getmId());
			sf.append("\",\"mGroup\":\""+dto.getmGroup());
			sf.append("\",\"mIndent\":\""+dto.getmIndent());
			sf.append("\",\"step\":\""+dto.getStep());
			sf.append("\",\"hit\":\""+dto.getHit());
			sf.append("\",\"nickName\":\""+dto.getNickName());
			sf.append("\",\"userId\":\""+dto.getUserId());
			sf.append("\",\"mPw\":\""+dto.getmPw());
			sf.append("\",\"memo\":\""+dto.getMemo());
			sf.append("\",\"title\":\""+dto.getTitle());
			sf.append("\",\"mTimestamp\":\""+dto.getmTimestamp()+"\"},");
		}
		sf.delete(sf.length()-1,sf.length());
		
		sf.append("]}");
		System.out.println(sf.toString());
		
		return sf.toString();
	}
}
