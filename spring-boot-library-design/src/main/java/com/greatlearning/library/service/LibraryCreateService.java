package com.greatlearning.library.service;

import java.util.List;

import com.greatlearning.library.entity.Library;

public interface LibraryCreateService {

	String addSingleLibrary(Library library);

	String addAllLibraries(List<Library> libraries);

	Library addLibraryWithSaveAndFlush(Library library);

}