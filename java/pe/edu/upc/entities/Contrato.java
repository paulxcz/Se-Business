package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contrato")
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContrato;
	
	@Column(name = "cldContrato", nullable = false)
	private int cldContrato;
	@Column(name = "culminacion", length = 60 ,nullable = false)
	private String culminacion;
	@Column(name = "especificaciones", length = 160 ,nullable = false)
	private String especificaciones;
	@Column(name = "estado", length = 90 ,nullable = false)
	private String estado;
	
	private Date dateContrato;

	public Contrato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contrato(int idContrato, int cldContrato, String culminacion, String especificaciones, String estado,
			Date dateContrato) {
		super();
		this.idContrato = idContrato;
		this.cldContrato = cldContrato;
		this.culminacion = culminacion;
		this.especificaciones = especificaciones;
		this.estado = estado;
		this.dateContrato = dateContrato;
	}

	public int getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	public int getCldContrato() {
		return cldContrato;
	}

	public void setCldContrato(int cldContrato) {
		this.cldContrato = cldContrato;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getDateContrato() {
		return dateContrato;
	}

	public void setDateContrato(Date dateContrato) {
		this.dateContrato = dateContrato;
	}

}
