package br.com.zupacademy.guzzo.mercadolivre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.guzzo.mercadolivre.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
	Optional<Compra> findByUuid(String uuid);
}
