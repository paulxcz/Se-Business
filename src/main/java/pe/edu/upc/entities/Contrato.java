package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Contrato")
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContrato;
	
	@Column(name = "culminacion", length = 60 ,nullable = false)
	private String culminacion;
	@Column(name = "especificaciones", length = 160 ,nullable = false)
	private String especificaciones;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateContrato;

	public Contrato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contrato(int idContrato, int cldContrato, String culminacion, String especificaciones, String estado,
			Date dateContrato) {
		super();
		this.idContrato = idContrato;
		this.culminacion = culminacion;
		this.especificaciones = especificaciones;
		this.dateContrato = dateContrato;
	}

	public int getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	public String getCulminacion() {
		return culminacion;
	}

	public void setCulminacion(String culminacion) {
		this.culminacion = culminacion;
	}

	public String getEspecificaciones() {
		return especificaciones;
	}

	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
	}

	public Date getDateContrato() {
		return dateContrato;
	}


	public void setDateContrato(Date dateContrato) {
		this.dateContrato = dateContrato;
	}

}
