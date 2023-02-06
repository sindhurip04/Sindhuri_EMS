package com.greatlearning.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.service.LibraryCountService;
import com.greatlearning.library.service.LibraryCreateService;
import com.greatlearning.library.service.LibraryDeleteService;
import com.greatlearning.library.service.LibraryExistService;
import com.greatlearning.library.service.LibraryReadService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

	@Autowired
	LibraryReadService libraryReadServiceImpl;

	@Autowired
	LibraryCreateService libraryCreateServiceImpl;
	
	@Autowired
	LibraryCountService libraryCountServiceImpl;
	
	@Autowired
	LibraryExistService libraryExistServiceImpl;
	
	@Autowired
	LibraryDeleteService libraryDeleteServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("Hello Spring Boot");
		System.out.println("Hello Dev Tools");
	}

	@Override
	public void run(String... args) throws Exception {

		// readServiceImplMethodsExecution();
		//createServiceImplMethodsExecution();
		//countServiceImplMethodsExecution();
		//existServiceImplMethodsExecution();
		//deleteServiceImplMethodsExecution();

	}

	private void deleteServiceImplMethodsExecution() {
//		log.info("Delete Single Library -> {}",libraryDeleteServiceImpl.deleteSingleLibrary(
//				Library.builder().id(11l).name("E Library").commaSeparatedBookNames("abc, xyz").build()));
//		log.info("Prune Table -> {}",libraryDeleteServiceImpl.pruneTable());
//		List<Library> libraries = new ArrayList<>();
//		libraries.add(Library.builder().id(3l).name("Animal Library").commaSeparatedBookNames("").build());
//		libraries.add(Library.builder().id(4l).name("Cloud Library").commaSeparatedBookNames("").build());
//		log.info("Delete All the list of Libraries -> {}",libraryDeleteServiceImpl.deleteAllThese(libraries));
//		log.info("Delete all libraries in batch -> {}",libraryDeleteServiceImpl.deleteAllInBatch());
//		log.info("Delete Library by id -> {}",libraryDeleteServiceImpl.deleteLibraryById(3l));
//		log.info("Delete all the list of libraries in batch -> {}",libraryDeleteServiceImpl.deleteAllTheseInBatch(libraries));
	}

	private void existServiceImplMethodsExecution() {
		log.info("Check if library exists by id -> {}",libraryExistServiceImpl.checkLibraryExistById(11l));
		log.info("Check if library exists by Example -> {}",libraryExistServiceImpl.checkLibraryExistByExample("Blue Star, Red Star"));
	}

	private void countServiceImplMethodsExecution() {
		log.info("Count the no. of libraries -> {}",libraryCountServiceImpl.countLibraries());
		log.info("Count the no. of libraries with Zero Books -> {}",libraryCountServiceImpl.countLibrariesWithZeroBooks());
	}

	private void createServiceImplMethodsExecution() {
		log.info("Persist a single library -> {}", libraryCreateServiceImpl.addSingleLibrary(
				Library.builder().id(11l).name("E Library").commaSeparatedBookNames("abc, xyz").build()));

		List<Library> libraries = new ArrayList<>();
		libraries.add(Library.builder().id(12l).name("F Library").commaSeparatedBookNames("abc, efg").build());
		libraries.add(Library.builder().id(13l).name("G Library").commaSeparatedBookNames("efg").build());
		log.info("Persist all the libraries -> {}", libraryCreateServiceImpl.addAllLibraries(libraries));

		log.info("Persist Library using Save and Flush -> {}", libraryCreateServiceImpl.addLibraryWithSaveAndFlush(
				Library.builder().id(14l).name("H Library").commaSeparatedBookNames("hij, xyz").build()));
	}

	private void readServiceImplMethodsExecution() {
		log.info("Fetch all Libraries -> {}", libraryReadServiceImpl.getAllLibrary());
		log.info("Fetchh all Libraries with no books -> {}", libraryReadServiceImpl.getAllLibrariesWithNoBooks());
//		log.info("Fetch Libraries in Paged format -> {}", libraryReadServiceImpl.getLibrariesPaged());
//		Page<Library> page = libraryReadServiceImpl.getLibrariesPaged();
//		List<Library> libraries = page.get().collect(Collectors.toList());
//		log.info("Fetch Libraries in Paged format -> {}",libraries);
		log.info("Fetch Libraries in Paged format -> {}",
				libraryReadServiceImpl.getLibrariesPaged().get().collect(Collectors.toList()));
		log.info("Fetch Libraries in Paged format -> {}",
				libraryReadServiceImpl.getLibrariesCustomPaged(1, 3).get().collect(Collectors.toList()));
		log.info("Fetch Libraries with latest added order -> {}",
				libraryReadServiceImpl.getLibrariesWithLatestAddedOrder());
		log.info("Fetch Libraries sorted by custom order id -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.ASC));
		log.info("Fetch Libraries sorted by custom order id -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.ASC));
		log.info("Fetch Libraries default paged, sorted and with these books: -> {}", libraryReadServiceImpl
				.getLibrariesPagedAndSortedByNameAndWithTheseBooks("abc, lmn, xyz").get().collect(Collectors.toList()));
		log.info("Fetch all libraries paged and sorted by name -> {}",
				libraryReadServiceImpl.getLibrariesPagedAndSortedByName().get().collect(Collectors.toList()));
		log.info("Fetch Libraries custom paged and default sorted and with these books: -> {}",
				libraryReadServiceImpl
						.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(1, 3, "abc, lmn, xyz")
						.get().collect(Collectors.toList()));
		log.info("Fetch all libraries sorted by name and with these books -> {}",
				libraryReadServiceImpl.getSortedByNameAndWithTheseBooks("abc, lmn, xyz"));

		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);

		log.info("Fetch libraries by ids -> {}", libraryReadServiceImpl.getLibrariesByIds(ids));

		long id = 1l;
		Optional<Library> optionalLibrary = libraryReadServiceImpl.getALibraryById(id);
		if (optionalLibrary.isPresent()) {
			log.info("Fetch Library by id -> {}", optionalLibrary.get());
		} else {
			log.info("No matching library with this id " + id + " was found in DB!!");
		}

		Optional<Library> optionalSingleLibrary = libraryReadServiceImpl
				.getALibraryWithTheseBooks("Yellow Sun, Blue Star, Red Star");
		if (optionalLibrary.isPresent()) {
			log.info("Fetch Library with these book names-> {}", optionalSingleLibrary.get());
		} else {
			log.info("No matching library with these books was found in DB!!");
		}
	}

}
