package com.diego.bookstore.repository;

import com.diego.bookstore.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query(value = "select l from Livro l where l.categoria.id = :idCat order by titulo")
    List<Livro> findAllByCategoria(@Param(value = "idCat") Integer idCat);
}
