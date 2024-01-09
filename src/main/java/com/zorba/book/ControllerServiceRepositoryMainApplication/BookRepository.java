package com.zorba.book.ControllerServiceRepositoryMainApplication;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer>{
	public Book findById(int id);
}
 