package com.scott.learn_jackson;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		writeJson ();
		
		readJson ();
	}
	
	public static void writeJson () throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Student student = new Student();
		student.setStudentId(1);
		student.setStudentName("sun");
		student.setCreateOn(new Date().getTime());
		String jsonInString = mapper.writeValueAsString(student);
		
		System.out.println("writeJson:" + jsonInString);
		
		jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
		System.out.println("writeJson(format):" + jsonInString);
	}
	
	public static void readJson () throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"student_id\": \"2\",\"student_name\": \"ying\", \"create_on\":\"2016-05-05 16:19:26\"}";
		Student student = mapper.readValue(jsonString, Student.class);
		
		System.out.println("readJson:" + student);
	}
}
