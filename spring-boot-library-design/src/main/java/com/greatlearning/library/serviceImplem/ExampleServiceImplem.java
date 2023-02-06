package com.greatlearning.library.serviceImplem;

import org.springframework.stereotype.Service;

import com.greatlearning.library.model.FullName;
import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.service.ExampleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleServiceImplem implements ExampleService {

	@Override
	public GreatLearning get() {
		log.info("Inside get method...");
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName("Learning Controller");
		greatLearning.setCourseType("Information Technology");
		greatLearning.setInstructorName(FullName.builder().firstName("Samarth").lastName("Narula").build());
		return greatLearning;
	}
	
	@Override
	public GreatLearning customInfo(String courseName, String courseType, String instructorName) {
		log.info("Inside customInfo method...");
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName(courseName);
		greatLearning.setCourseType(courseType);
		greatLearning.setInstructorName(FullName.builder().firstName("Samarth").lastName("Narula").build());
		return greatLearning;
	}
}
