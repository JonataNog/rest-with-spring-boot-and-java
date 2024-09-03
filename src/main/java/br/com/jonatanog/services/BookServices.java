package br.com.jonatanog.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jonatanog.controllers.BookController;
import br.com.jonatanog.data.vo.v1.BookVO;
import br.com.jonatanog.exceptions.RequiredObjectIsNullException;
import br.com.jonatanog.exceptions.ResourceNotFoundException;
import br.com.jonatanog.mapper.DozerMapper;
import br.com.jonatanog.model.Book;
import br.com.jonatanog.repositories.BookRepository;

@Service
public class BookServices {
	
	private Logger logger = Logger.getLogger(BookServices.class.getName());

	@Autowired
	BookRepository repository;
	
	public List<BookVO> findAll(){
		logger.info("Finding all Books!");
		
		var books = DozerMapper.parseListObjects(repository.findAll(), BookVO.class);
		
		books.stream().forEach(b -> b.add(linkTo(methodOn(BookController.class).findById(b.getKey())).withSelfRel()));
		
		return books;
	}
	
	public BookVO findById(Long id) {
		logger.info("Finding one Book!");
		
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		var vo = DozerMapper.parseObject(entity, BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return vo;
	}
	
	public BookVO create(BookVO book) {
		if(book == null) throw new RequiredObjectIsNullException();
		
		logger.info("Creating one Book!");
		
		var entity = DozerMapper.parseObject(book, Book.class);
		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public BookVO update(BookVO book) {
		if(book == null) throw new RequiredObjectIsNullException();
		
		logger.info("Updating one Book!");
		
		var entity = repository.findById(book.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setTitle(book.getTitle());
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		
		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one Book!");
		
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}

}
