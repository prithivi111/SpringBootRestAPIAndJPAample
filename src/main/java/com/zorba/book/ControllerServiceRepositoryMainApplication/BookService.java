package com.zorba.book.ControllerServiceRepositoryMainApplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	private static List<Book> listOfBooks = new ArrayList<>();
	{
		listOfBooks.add(new Book(12,"Alibaba and Chalis Chor", "Ramesh"));
		listOfBooks.add(new Book(22, "Life in Japan", "Yoshida"));
		listOfBooks.add(new Book(998,"Newyork Night", "Simon"));
	}
	
	public List<Book> getBooks(){
		return listOfBooks;		
	}
	
	public Book getBookById(int id) {	
		Book b = new Book();
			for(Book book:listOfBooks) {
				if (book.getId() == id){
					b= book;
					break;
				}
			}
		return b;
	}
	
	public Book addBook(Book book) {
		listOfBooks.add(book);
		return book;	
	}
	
	public Boolean deleteBook(int id) {
		Boolean flag = false;
			for (int i = 0; i < listOfBooks.size(); i++) {
			  Book book = listOfBooks.get(i);
			    if (book.getId() == id) {
			         listOfBooks.remove(book);	
			         flag= true;
			          break;
			        }
			 }
			return flag;
	}
	
	public Boolean updateBook(Book book, int id) {
		Boolean flag = false;
		for (int i = 0; i < listOfBooks.size(); i++) {
			  Book e = listOfBooks.get(i);
			    if (e.getId() == id) {
			    	  listOfBooks.get(i).setTitle(book.getTitle());
			          listOfBooks.get(i).setAuthor(book.getAuthor());
			          flag = true;
			          break;
			        }
			 }
		return flag;
	}
	
}
