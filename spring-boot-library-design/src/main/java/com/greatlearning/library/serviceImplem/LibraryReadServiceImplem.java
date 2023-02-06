package com.greatlearning.library.serviceImplem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;
import com.greatlearning.library.service.LibraryReadService;

@Service
public class LibraryReadServiceImplem implements LibraryReadService {

	@Autowired
	LibraryRepository readRepository;

	@Override
	public List<Library> getAllLibrary() {
		return readRepository.findAll();
	}

	@Override
	public List<Library> getAllLibrariesWithNoBooks() {
		Library libraryWithNoBooks = new Library();
		libraryWithNoBooks.setCommaSeparatedBookNames("");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithNoBooks, exampleMatcher);
		return readRepository.findAll(example);
	}

	@Override
	public Page<Library> getLibrariesPaged() {
		Pageable first3Records = PageRequest.of(0, 3);
		return readRepository.findAll(first3Records);
	}

	@Override
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage) {
		Pageable first3Records = PageRequest.of(pageNumber, numberOfRecordsOnAPage);
		return readRepository.findAll(first3Records);
	}

	@Override
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "name"));
	}

	// Combination of example matcher, paging and sorting
	@Override
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
		Library librariesWithTheseBooks = new Library();
		librariesWithTheseBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparaetedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(librariesWithTheseBooks, exampleMatcher);
		Pageable page = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(example, page);
	}

	@Override
	public Page<Library> getLibrariesPagedAndSortedByName() {
		Pageable page = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(page);
	}

	@Override
	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(int pageNo,
			int noOfRecords, String commaSeparatedBookNames) {
		Library librariesWithTheseBooks = new Library();
		librariesWithTheseBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(librariesWithTheseBooks, exampleMatcher);
		Pageable page = PageRequest.of(pageNo, noOfRecords, Sort.by("name"));
		return readRepository.findAll(example, page);
	}

	@Override
	public List<Library> getSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
		Library librariesWithTheseBooks = new Library();
		librariesWithTheseBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(librariesWithTheseBooks, exampleMatcher);
		return readRepository.findAll(example, Sort.by("name"));
	}

	@Override
	public List<Library> getLibrariesByIds(List<Long> ids) {
		return readRepository.findAllById(ids);
	}

	@Override
	public Optional<Library> getALibraryById(Long id) {
		return readRepository.findById(id);
	}

	@Override
	public Optional<Library> getALibraryWithTheseBooks(String commaSeparatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return readRepository.findOne(example);
	}
}
