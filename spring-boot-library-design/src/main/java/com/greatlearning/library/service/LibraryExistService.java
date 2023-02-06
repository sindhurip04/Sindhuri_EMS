package com.greatlearning.library.service;

public interface LibraryExistService {

	boolean checkLibraryExistById(Long id);

	boolean checkLibraryExistByExample(String commaSeparatedBookNames);

}