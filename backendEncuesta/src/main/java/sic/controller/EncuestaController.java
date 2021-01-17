package sic.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sic.exception.ResourceNotFoundException;
import sic.model.Encuesta;
import sic.repository.EncuestaRepository;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EncuestaController {
	@Autowired
	private EncuestaRepository encuestaRepository;

	@GetMapping("/encuestas")
	public List<Encuesta> getAllEncuestas() {
		return encuestaRepository.findAll();
	}

	@GetMapping("/encuestas/{id}")
	public ResponseEntity<Encuesta> getEncuestaById(@PathVariable(value = "id") Long encuestaId)
			throws ResourceNotFoundException {
		Encuesta encuesta = encuestaRepository.findById(encuestaId)
				.orElseThrow(() -> new ResourceNotFoundException("Encuesta no encontrada para id :: " + encuestaId));
		return ResponseEntity.ok().body(encuesta);
	}

	@PostMapping("/encuestas")
	public Encuesta createEncuesta(@Valid @RequestBody Encuesta encuesta) {
		return encuestaRepository.save(encuesta);
	}

	@PutMapping("/encuestas/{id}")
	public ResponseEntity<Encuesta> updateEncuesta(@PathVariable(value = "id") Long encuestaId,
			@Valid @RequestBody Encuesta encuestaDetails) throws ResourceNotFoundException {
		Encuesta encuesta = encuestaRepository.findById(encuestaId)
				.orElseThrow(() -> new ResourceNotFoundException("Encuesta no encontrada para id :: " + encuestaId));

		encuesta.setComentarios(encuestaDetails.getComentarios());
		encuesta.setCorreo(encuestaDetails.getCorreo());
		encuesta.setFechaRespuesta(encuestaDetails.getFechaRespuesta());
		encuesta.setMarcaPC(encuestaDetails.getMarcaPC());
		encuesta.setNumeroDocumento(encuestaDetails.getNumeroDocumento());

		final Encuesta updatedEncuesta = encuestaRepository.save(encuesta);
		return ResponseEntity.ok(updatedEncuesta);
	}

	@DeleteMapping("/encuestas/{id}")
	public Map<String, Boolean> deleteEncuesta(@PathVariable(value = "id") Long encuestaId)
			throws ResourceNotFoundException {
		Encuesta encuesta = encuestaRepository.findById(encuestaId)
				.orElseThrow(() -> new ResourceNotFoundException("Encuesta no encontrada para id :: " + encuestaId));

		encuestaRepository.delete(encuesta);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
