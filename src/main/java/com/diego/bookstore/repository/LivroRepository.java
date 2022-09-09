package com.diego.bookstore.repository;

import com.diego.bookstore.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Categoria, Integer> {
}
