package br.com.jonatanog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jonatanog.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
}
