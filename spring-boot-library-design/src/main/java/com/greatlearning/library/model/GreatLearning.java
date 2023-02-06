package com.greatlearning.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GreatLearning {
	// Encapsulation by making private variables and public getters and setters
	private String courseName;
	private String courseType;
	//private String instructorName;
	private FullName instructorName;
	
}
