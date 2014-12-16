package com.gxl;

import java.io.File;

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
	public void uploadFile() throws Exception {
		String perSessionKey = this.getHttpServletRequest().getParameter("perSessionKey");
		System.out.print("");
		for(int i =1;i<=100;i++){
			Thread.sleep(500);
			this.getHttpServletRequest().getSession().setAttribute(perSessionKey, i);
			System.out.println("--"+this.getHttpServletRequest().getSession().getAttribute(perSessionKey));
		}
		//Ö´ÐÐÍê±Ï
		this.getHttpServletRequest().getSession().setAttribute(perSessionKey, 0);
		this.setAjax("200");
	}
}
