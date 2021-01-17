package sic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sic.model.MarcaComputador;
import sic.repository.MarcaComputadorRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class MarcaComputadorController {
	@Autowired
	private MarcaComputadorRepository marcaComputadorRepository;

	@GetMapping("/marcas")
	public List<MarcaComputador> getAllMarcas() {
		return marcaComputadorRepository.findAll();
	}

}
