package sic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "encuesta")
public class Encuesta {

	private long id;
	private long numeroDocumento;
	private String correo;
	private String comentarios;
	private MarcaComputador marcaPC;
	private Date fechaRespuesta;

	public Encuesta() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "numero_documento", nullable = false)
	public long getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	@Column(name = "correo", nullable = false)
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Column(name = "comentarios", nullable = false)
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@ManyToOne
	@JoinColumn(name = "marca_PC", nullable = false)
	public MarcaComputador getMarcaPC() {
		return marcaPC;
	}

	public void setMarcaPC(MarcaComputador marcaPC) {
		this.marcaPC = marcaPC;
	}

	@Column(name = "fecha_respuesta", nullable = false)
	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

}
