package com.greatlearning.library.service;

import com.greatlearning.library.model.GreatLearning;

public interface ExampleService {

	GreatLearning get();

	GreatLearning customInfo(String courseName, String courseType, String instructorName);

}