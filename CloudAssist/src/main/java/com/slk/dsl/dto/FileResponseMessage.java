package com.slk.dsl.dto;

import java.util.List;

public class FileResponseMessage {
	 private String message;
	 //private int progress;
	 private List<String> Files;
	 
	
	
	public FileResponseMessage(String message, List<String> Files) {
		super();
		this.message = message;
		//this.progress = progress;
		this.Files = Files;
	}

	public List<String> getFiles() {
		return Files;
	}

	public void setFiles(List<String>files) {
		Files = files;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/*
	 * public int getProgress() { return progress; } public void setProgress(int
	 * progress) { this.progress = progress; }
	 */
	 
}
