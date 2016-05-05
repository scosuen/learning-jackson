package com.scott.learn_jackson;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

	@JsonProperty("student_id")
    private int studentId;
	
	@JsonProperty("student_name")
	private String studentName;
	
	@JsonIgnore
	private long createOn;
	
	@JsonProperty("create_on")
	private String createOnStr;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public long getCreateOn() {
		return createOn;
	}

	public void setCreateOn(long createOn) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.createOnStr = formatter.format(new Date(createOn));
		this.createOn = createOn;
	}

	public String getCreateOnStr() {
		return createOnStr;
	}

	public void setCreateOnStr(String createOnStr) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.createOn = formatter.parse(createOnStr).getTime();
		this.createOnStr = createOnStr;
	}
	
	@Override
	public String toString() {
		return "studend id: " + getStudentId() + ", student name: " + getStudentName() + ", create on: " + getCreateOn();
	}
	

}
