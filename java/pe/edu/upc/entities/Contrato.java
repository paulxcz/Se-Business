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
	@JoinColumn(name="idEmprendedor", nullable = false)
	private Emprendedor emprendedor;
	
	@ManyToOne
	@JoinColumn(name="idMercadologo", nullable = false)
	private Mercadologo mercadologo;

	public Contrato() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Contrato(int idContrato, Date fechaCulminacionEstimada, String especificaciones, Date dateContrato,
			Emprendedor emprendedor, Mercadologo mercadologo) {
		super();
		this.idContrato = idContrato;
		this.fechaCulminacionEstimada = fechaCulminacionEstimada;
		this.especificaciones = especificaciones;
		this.dateContrato = dateContrato;
		this.emprendedor = emprendedor;
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
	

	public Emprendedor getEmprendedor() {
		return emprendedor;
	}

	public void setEmprendedor(Emprendedor emprendedor) {
		this.emprendedor = emprendedor;
	}

	public Mercadologo getMercadologo() {
		return mercadologo;
	}

	public void setMercadologo(Mercadologo mercadologo) {
		this.mercadologo = mercadologo;
	}


}
