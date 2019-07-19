package org.web.bordcommend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BordCommend {
	
	void excuteCommend(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException;
}
