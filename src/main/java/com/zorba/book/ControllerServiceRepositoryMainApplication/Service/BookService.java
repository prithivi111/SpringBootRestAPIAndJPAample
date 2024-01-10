package com.zorba.book.ControllerServiceRepositoryMainApplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
//	private static List<Book> listOfBooks = new ArrayList<>();
//	{
//		listOfBooks.add(new Book(12,"Alibaba and Chalis Chor", "Ramesh"));
//		listOfBooks.add(new Book(22, "Life in Japan", "Yoshida"));
//		listOfBooks.add(new Book(998,"Newyork Night", "Simon"));
//	}
	
	public List<Book> getBooks(){
		List<Book> listOfBooks = (List<Book>) this.bookRepository.findAll();	
		return listOfBooks;
	}
	
	public Book getBookById(int id) {	
		Book book = null;
		book= bookRepository.findById(id);
		return book;
	}
	
	public Book addBook(Book book) {
		Book result = bookRepository.save(book);
		return result;	
	}
	
	public void deleteBook(int id) {
// public Boolean deleteBook(int id) {
//		Boolean flag = false;
//			for (int i = 0; i < listOfBooks.size(); i++) {
//			  Book book = listOfBooks.get(i);
//			    if (book.getId() == id) {
//			         listOfBooks.remove(book);	
//			         flag= true;
//			          break;
//			        }
//			 }
//			return flag;
//  }	
		bookRepository.deleteById(id);
	}
	
	public void updateBook(Book book, int id) {
//		Boolean flag = false;
//		for (int i = 0; i < listOfBooks.size(); i++) {
//			  Book e = listOfBooks.get(i);
//			    if (e.getId() == id) {
//			    	  listOfBooks.get(i).setTitle(book.getTitle());
//			          listOfBooks.get(i).setAuthor(book.getAuthor());
//			          flag = true;
//			          break;
//			        }
//			 }
//		return flag;
		
		book.setId(id);
		bookRepository.save(book);
	}
	
}
