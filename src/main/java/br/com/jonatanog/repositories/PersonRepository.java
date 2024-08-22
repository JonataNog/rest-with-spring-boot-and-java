package br.com.jonatanog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jonatanog.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
}
