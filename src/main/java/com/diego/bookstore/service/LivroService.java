package com.diego.bookstore.service;

import com.diego.bookstore.model.Categoria;
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

    public Livro update(Integer id, Livro obj) {
        Livro newObj = findById(id);
        updateData(newObj, obj);
        return livroRepository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setTexto(obj.getTexto());
        newObj.setNomeAutor(obj.getNomeAutor());
    }

    public Livro create(Integer idCat, Livro obj) {
        obj.setId(null);
        Categoria cat = categoriaService.findById(idCat);
        obj.setCategoria(cat);
        return livroRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        livroRepository.deleteById(id);
    }
}
