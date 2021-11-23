package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Contrato")
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContrato;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaCulminacionEstimada;
	
	@Column(name = "especificaciones", length = 160 ,nullable = false)
	private String especificaciones;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateContrato;
	
	@ManyToOne
	@JoinColumn(name="idProyecto", nullable = false)
	private Proyecto proyecto;
	
	@ManyToOne
	@JoinColumn(name="idMercadologo", nullable = false)
	private Mercadologo mercadologo;

	public Contrato() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Contrato(int idContrato, Date fechaCulminacionEstimada, String especificaciones, Date dateContrato,
			Proyecto proyecto, Mercadologo mercadologo) {
		super();
		this.idContrato = idContrato;
		this.fechaCulminacionEstimada = fechaCulminacionEstimada;
		this.especificaciones = especificaciones;
		this.dateContrato = dateContrato;
		this.proyecto = proyecto;
		this.mercadologo = mercadologo;
	}


	public int getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	
	public Date getFechaCulminacionEstimada() {
		return fechaCulminacionEstimada;
	}

	public void setFechaCulminacionEstimada(Date fechaCulminacionEstimada) {
		this.fechaCulminacionEstimada = fechaCulminacionEstimada;
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
	

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Mercadologo getMercadologo() {
		return mercadologo;
	}

	public void setMercadologo(Mercadologo mercadologo) {
		this.mercadologo = mercadologo;
	}


}
