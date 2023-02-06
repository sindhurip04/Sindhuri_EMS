package com.greatlearning.library.serviceImplem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;
import com.greatlearning.library.service.LibraryExistService;

@Service
public class LibraryExistServiceImpl implements LibraryExistService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public boolean checkLibraryExistById(Long id) {
		return libraryRepository.existsById(id);
	}

	@Override
	public boolean checkLibraryExistByExample(String commaSeparatedBookNames) {
		Library library = new Library();
		library.setCommaSeparatedBookNames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(library, exampleMatcher);
		return libraryRepository.exists(example);
	}
}
