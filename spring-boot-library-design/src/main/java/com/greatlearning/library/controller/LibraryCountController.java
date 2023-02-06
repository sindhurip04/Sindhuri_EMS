package com.greatlearning.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.service.LibraryCountService;

@RestController
@RequestMapping("/countService")
public class LibraryCountController {

	@Autowired
	LibraryCountService countService;
	
	@GetMapping("/countLibraries")
	public long countLibraries() {
		return countService.countLibraries();
	}
	
	@GetMapping("/countLibrariesWithZeroBooks")
	public long countLibrariesWithZeroBooks() {
		return countService.countLibrariesWithZeroBooks();
	}
}
