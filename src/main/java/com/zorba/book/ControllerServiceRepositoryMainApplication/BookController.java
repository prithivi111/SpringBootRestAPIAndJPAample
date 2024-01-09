package com.zorba.book.ControllerServiceRepositoryMainApplication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BookController")
public class BookController {
	
	@Autowired
	private BookService bookservice;
	
	//get all books
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks(){
		List<Book> list=this.bookservice.getBooks();
		if(list.size()>0) {
			return ResponseEntity.of(Optional.of(list));		
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	//get book by id
	@GetMapping("/books/{id}") //http:localhost8080/BookController/books/12
	public ResponseEntity<Book> getBooks(@PathVariable("id") int id) {
		Book book = this.bookservice.getBookById(id);	
		if(book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(book);
		}
	}
	
	//post a book
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		try{
			b = this.bookservice.addBook(book);
			System.out.println(b);
			return ResponseEntity.status(HttpStatus.CREATED).body(book);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//delete a book
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
	   try {
		   this.bookservice.deleteBook(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}
	
	//update a book
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable ("id") int id){
		   try {
			   this.bookservice.updateBook(book, id);
			   return ResponseEntity.ok(book);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}	
	}
}
