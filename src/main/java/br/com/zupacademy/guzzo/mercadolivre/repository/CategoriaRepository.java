package br.com.zupacademy.guzzo.mercadolivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.guzzo.mercadolivre.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
