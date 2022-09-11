package com.diego.bookstore.service;

import com.diego.bookstore.model.Categoria;
import com.diego.bookstore.model.Livro;
import com.diego.bookstore.repository.CategoriaRepository;
import com.diego.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {

        Categoria cat1 = new Categoria(null, "Informática", "Livros de Informática");
        Categoria cat2 = new Categoria(null, "Diversos", "Livros diversos");
        Categoria cat3 = new Categoria(null, "Ficção", "Livros de Ficção");

        Livro l1 = new Livro(null, "Clean code", "Robert Marint", "Lorem ipsum", cat1);
        Livro l2 = new Livro(null, "Engenharia de Software", "Leandro Leal", "Lorem ipsum", cat2);
        Livro l3 = new Livro(null, "The Time Machine", "M. G. Wells", "Lorem ipsum", cat3);
        Livro l4 = new Livro(null, "The War Of The Worlds", "Bruce Mckain", "Lorem ipsum", cat2);
        Livro l5 = new Livro(null, "I, Robot", "Isaac Asimoz", "Lorem ipsum", cat2);

        cat1.getLivros().add(l1);
        cat2.getLivros().addAll(Arrays.asList(l2, l4, l5));
        cat3.getLivros().add(l3);

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2, cat3));
        livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
    }
}
