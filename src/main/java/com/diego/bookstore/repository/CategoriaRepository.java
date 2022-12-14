package com.diego.bookstore.repository;

import com.diego.bookstore.model.Categoria;
import com.diego.bookstore.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
