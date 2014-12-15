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
public class FileUploadAction extends BaseAction {
	private File fileToUpload;
	private String fileToUploadContentType;
	private String fileToUploadFileName;
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getFileToUpload() {
		return fileToUpload;
	}

	public void setFileToUpload(File fileToUpload) {
		this.fileToUpload = fileToUpload;
	}

	public String getFileToUploadContentType() {
		return fileToUploadContentType;
	}

	public void setFileToUploadContentType(String fileToUploadContentType) {
		this.fileToUploadContentType = fileToUploadContentType;
	}

	public String getFileToUploadFileName() {
		return fileToUploadFileName;
	}

	public void setFileToUploadFileName(String fileToUploadFileName) {
		this.fileToUploadFileName = fileToUploadFileName;
	}

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
	public String uploadFile() throws Exception {
		System.out.print("");
		for(int i =1;i<=100;i++){
			Thread.sleep(500);
			this.getHttpServletRequest().getSession().setAttribute("per", i);
			System.out.println("--"+this.getHttpServletRequest().getSession().getAttribute("per"));
		}
		this.getHttpServletRequest().getSession().setAttribute("per", 0);
		HttpServletResponse response = this.getHttpServletResponse();
		String fullContentType = "text/html;charset=UTF-8";
		response.setContentType(fullContentType);
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out = response.getWriter();
		out.print("{\"hello\":\"gxl\"}");
		out.flush();
		out.close();
		return NONE;
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
