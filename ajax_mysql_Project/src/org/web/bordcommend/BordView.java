package org.web.bordcommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.borddao.BordDao;
import org.web.borddto.BordDto;

public class BordView implements BordCommend{

	@Override
	public void excuteCommend(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		int mId = Integer.parseInt(request.getParameter("mId"));
		PrintWriter out = response.getWriter();
		out.write(getJSON(mId));
		out.flush();
	
	}
	private String getJSON(int mId) {
		BordDao dao = BordDao.getInstance();
		StringBuffer sf = new StringBuffer("");
		BordDto dto = dao.BordView(mId);
	
		
		sf.append("{\"result1\":");
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
		sf.append("\",\"mTimestamp\":\""+dto.getmTimestamp()+"\"");
		sf.append("}}");
		
		System.out.println(sf.toString());
		
		return sf.toString();
	}
}
