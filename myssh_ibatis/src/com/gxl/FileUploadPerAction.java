package com.gxl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ssh.baseaction.BaseAction;
@Component
@Scope("prototype")
public class FileUploadPerAction extends BaseAction {

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	@Override
	public String execute(){
		return null;
	}
	public void getPer() throws IOException{
		HttpServletResponse response = this.getHttpServletResponse();
		String fullContentType = "text/html;charset=UTF-8";
		response.setContentType(fullContentType);
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out = response.getWriter();
		System.out.println("xx--"+this.getHttpServletRequest().getSession().getAttribute("per"));
		out.print(this.getHttpServletRequest().getSession().getAttribute("per"));
		out.flush();
		out.close();
	}
}
