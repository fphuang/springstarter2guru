package com.coy.sect2.repositories;

import com.coy.sect2.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
