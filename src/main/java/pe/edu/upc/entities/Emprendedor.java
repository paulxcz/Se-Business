package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Emprendedor")
public class Emprendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmprendedor;
	
	@Column(name = "nombreEmprendedor", length = 50, nullable = false)
	private String nombreEmprendedor;
	@Column(name = "nombreEmpresa", length = 50, nullable=false)
	private String nombreEmpresa;
	@Column(name = "ratingEmprendedor", nullable = false)
	private float ratingEmprendedor;
	@Column(name = "giroNegocio", length = 70, nullable=false)
	private String giroNegocio;
	public Emprendedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emprendedor(int idEmprendedor, String nombreEmprendedor, String nombreEmpresa, String giroNegocio, float ratingEmprendedor) {
		super();
		this.idEmprendedor = idEmprendedor;
		this.nombreEmprendedor = nombreEmprendedor;
		this.nombreEmpresa = nombreEmpresa;
		this.ratingEmprendedor=ratingEmprendedor;
		this.giroNegocio = giroNegocio;
	}
	public int getIdEmprendedor() {
		return idEmprendedor;
	}
	public void setIdEmprendedor(int idEmprendedor) {
		this.idEmprendedor = idEmprendedor;
	}
	public String getNombreEmprendedor() {
		return nombreEmprendedor;
	}
	public void setNombreEmprendedor(String nombreEmprendedor) {
		this.nombreEmprendedor = nombreEmprendedor;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	public float getRatingEmprendedor() {
		return ratingEmprendedor;
	}
	public void setRatingEmprendedor(float ratingEmprendedor) {
		this.ratingEmprendedor = ratingEmprendedor;
	}
	
	
	public String getGiroNegocio() {
		return giroNegocio;
	}
	public void setGiroNegocio(String giroNegocio) {
		this.giroNegocio = giroNegocio;
	}

}
