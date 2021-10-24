package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Soporte")
public class Soporte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSoporte;
	@Column(name = "nombreSoporte", length = 50, nullable = false)
	private String nombreSoporte;
	@Column(name = "DescripcionProblema", length = 50, nullable = false)
	private String DescripcionProblema;
	
	public Soporte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Soporte(int idSoporte, String nombreSoporte, String descripcionProblema) {
		super();
		this.idSoporte = idSoporte;
		this.nombreSoporte = nombreSoporte;
		DescripcionProblema = descripcionProblema;
	}
	public int getIdSoporte() {
		return idSoporte;
	}
	public void setIdSoporte(int idSoporte) {
		this.idSoporte = idSoporte;
	}
	public String getNombreSoporte() {
		return nombreSoporte;
	}
	public void setNombreSoporte(String nombreSoporte) {
		this.nombreSoporte = nombreSoporte;
	}
	public String getDescripcionProblema() {
		return DescripcionProblema;
	}
	public void setDescripcionProblema(String descripcionProblema) {
		DescripcionProblema = descripcionProblema;
	}
	
}
