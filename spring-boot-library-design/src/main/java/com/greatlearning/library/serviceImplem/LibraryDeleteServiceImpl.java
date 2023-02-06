package com.greatlearning.library.serviceImplem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;
import com.greatlearning.library.service.LibraryDeleteService;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService {

	@Autowired
	LibraryRepository libraryRepository;
	
	@Override
	public String deleteSingleLibrary(Library library) {
		libraryRepository.delete(library);
		return "Deleted library "+ library.getName();
	}
	
	@Override
	public String pruneTable() {
		libraryRepository.deleteAll();
		return "Prune Complete!";
	}
	
	@Override
	public String deleteAllThese(List<Library> libraries) {
		libraryRepository.deleteAll(libraries);
		return "Delete all complete!";
	}
	
	@Override
	public String deleteAllInBatch() {
		libraryRepository.deleteAllInBatch();
		return "Delete all in batch completed!";
	}
	
	@Override
	public String deleteLibraryById(Long id) {
		libraryRepository.deleteById(id);
		return "Library with id "+id+" is deleted";
	}
	
	@Override
	public String deleteAllTheseInBatch(List<Library> libraries) {
		libraryRepository.deleteInBatch(libraries);
		return "Deleted all the libraries in the list in batch mode.";
	}
}
