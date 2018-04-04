package com.kh.tc.file.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.tc.file.model.service.fileService;
import com.kh.tc.file.model.vo.File;

@WebServlet("/selectOne.qfile")
public class SelectQnAFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectQnAFileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		System.out.println("fileName : " + fileName);
		File qnaFile = new fileService().selectQnAFile(fileName);

		String page = "";

		if (qnaFile != null) {
			HttpSession session = request.getSession();
			session.setAttribute("qnaFile", qnaFile);
			response.sendRedirect("views/community/qnaDetail.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
