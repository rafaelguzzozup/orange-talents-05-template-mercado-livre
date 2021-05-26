package br.com.zupacademy.guzzo.mercadolivre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zupacademy.guzzo.mercadolivre.controller.form.CategoriaForm;
import br.com.zupacademy.guzzo.mercadolivre.model.Categoria;
import br.com.zupacademy.guzzo.mercadolivre.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaForm form) {

		Categoria categoria = form.converterParaCategoria();

		if (form.getIdCategoriaMae() != null) {
			Categoria categoriaMae = categoriaRepository.findById(form.getIdCategoriaMae()).get();

			categoria.setCategoriaMae(categoriaMae);
		}

		categoriaRepository.save(categoria);
		return ResponseEntity.ok().build();
	}
}
