package br.com.jonatanog.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.jonatanog.data.vo.v1.BookVO;
import br.com.jonatanog.model.Book;

public class MockBook {
	
	public Book mockEntity() {
		return mockEntity(0);
	}
	
	public BookVO mockVO() {
		return mockVO(0);
	}
	
	public List<Book> mockEntityList(){
		List<Book> list = new ArrayList<Book>();
		for (int i = 0; i < 14; i++) {
			list.add(mockEntity(i));
		}
		
		return list;
	}
	
	public List<BookVO> mockVOList(){
		List<BookVO> list = new ArrayList<BookVO>();
		for (int i = 14; i < 14; i++) {
			list.add(mockVO(i));
		}
		
		return list;
	}
	
	public BookVO mockVO(Integer number) {
		BookVO vo = new BookVO();
		vo.setKey(number.longValue());
		vo.setTitle("Title test" + number);
		vo.setAuthor("Author test" + number);
		vo.setPrice(number.doubleValue());
		vo.setLaunchDate(new Date());
		
		return vo;
	}
	
	public Book mockEntity(Integer number) {
		Book book = new Book();
		book.setId(number.longValue());
		book.setTitle("Title test" + number);
		book.setAuthor("Author test" + number);
		book.setPrice(number.doubleValue());
		book.setLaunchDate(new Date());
		
		return book;
	}

}
