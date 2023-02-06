package com.greatlearning.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.service.LibraryExistService;

@RestController
@RequestMapping("/existService")
public class LibraryExistController {

	@Autowired
	LibraryExistService existService;
	
	@GetMapping("checkLibraryExistById")
	public boolean checkLibraryExistById(Long id) {
		return existService.checkLibraryExistById(id);
	}
	
	@GetMapping("checkLibraryExistByExample")
	public boolean checkLibraryExistByExample(String commaSeparatedBookNames) {
		return existService.checkLibraryExistByExample(commaSeparatedBookNames);
	}
}
