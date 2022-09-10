package com.diego.bookstore.service;

import com.diego.bookstore.model.Livro;
import com.diego.bookstore.repository.LivroRepository;
import com.diego.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Integer idCat) {
        categoriaService.findById(idCat);
        return livroRepository.findAllByCategoria(idCat);
    }
}