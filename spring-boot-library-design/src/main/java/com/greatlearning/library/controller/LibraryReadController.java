package com.greatlearning.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.service.LibraryReadService;

@RestController
@RequestMapping("/readService")
public class LibraryReadController {

	@Autowired
	LibraryReadService readService;

	@GetMapping("/getAllLibraries")
	public List<Library> getAllLibraries() {
		return readService.getAllLibrary();
	}

	@GetMapping("/getAllLibrariesWithNoBooks")
	public List<Library> getAllLibrariesWithNoBooks() {
		return readService.getAllLibrariesWithNoBooks();
	}

	@GetMapping("/getLibrariesPaged")
	public Page<Library> getLibrariesPaged() {
		return readService.getLibrariesPaged();
	}

	@GetMapping("/getLibrariesCustomPaged")
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int noOfRecords) {
		return readService.getLibrariesCustomPaged(pageNumber, noOfRecords);
	}

	@GetMapping("/getLibrariesWithLatestAddedOrder")
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readService.getLibrariesWithLatestAddedOrder();
	}

	@GetMapping("/getLibrariesCustomSortedById")
	public List<Library> getLibrariesCustomSortedById(Direction dir) {
		return readService.getLibrariesCustomSortedById(dir);
	}

	@GetMapping("/getLibrariesCustomSortedByName")
	public List<Library> getLibrariesCustomSortedByName(Direction dir) {
		return readService.getLibrariesCustomSortedByName(dir);
	}

	@GetMapping("/getLibrariesPagedAndSortedByNameAndWithTheseBooks")
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
		return readService.getLibrariesPagedAndSortedByNameAndWithTheseBooks(commaSeparatedBookNames);
	}

	@GetMapping("/getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks")
	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(int pageNumber,
			int noOfRecords, String commaSeparatedBookNames) {
		return readService.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(pageNumber,
				noOfRecords, commaSeparatedBookNames);
	}
	
	@GetMapping("/getSortedByNameAndWithTheseBooks")
	public List<Library> getSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
		return readService.getSortedByNameAndWithTheseBooks(commaSeparatedBookNames);
	}
	
	@PostMapping("/getLibrariesByIds")
	public List<Library> getLibrariesByIds(@RequestBody List<Long> ids) {
		return readService.getLibrariesByIds(ids);
	}
	
	@GetMapping("/getALibraryById")
	public Optional<Library> getALibraryById(Long id) {
		return readService.getALibraryById(id);
	}
	
	@GetMapping("/getALibraryWithTheseBooks")
	public Optional<Library> getALibraryWithTheseBooks(String commaSeparatedBookNames) {
		return readService.getALibraryWithTheseBooks(commaSeparatedBookNames);
	}
	
	@GetMapping("/getLibrariesPagedAndSortedByName")
	public Page<Library> getLibrariesPagedAndSortedByName() {
		return readService.getLibrariesPagedAndSortedByName();
	}
	
}
