package com.greatlearning.library.serviceImplem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;
import com.greatlearning.library.service.LibraryCountService;

@Service
public class LibraryCountServiceImpl implements LibraryCountService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public long countLibraries() {
		return libraryRepository.count();
	}

	@Override
	public long countLibrariesWithZeroBooks() {
		Library librariesWithZeroBooks = new Library();
		librariesWithZeroBooks.setCommaSeparatedBookNames("");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(librariesWithZeroBooks, exampleMatcher);
		return libraryRepository.count(example);
	}
}
