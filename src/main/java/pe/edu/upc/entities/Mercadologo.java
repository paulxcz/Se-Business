package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mercadologo")
public class Mercadologo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMercadologo;
	@Column(name = "nombreMercadologo", length = 45, nullable = false)
	private String nombreMercadologo;
	@Column(name = "numeroMercadologo", nullable = false)
	private String numeroMercadologo;
	@Column(name = "ratingMercadologo", nullable = false)
	private int ratingMercadologo;
	@Column(name = "correoMercadologo", length = 80, nullable = false)
	private String correoMercadologo;
	@Column(name = "linkedinMercadologo", length = 80, nullable = false)
	private String linkedinMercadologo;
	public Mercadologo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mercadologo(int idMercadologo, String nombreMercadologo, String numeroMercadologo, int ratingMercadologo,
			String correoMercadologo, String linkedinMercadologo) {
		super();
		this.idMercadologo = idMercadologo;
		this.nombreMercadologo = nombreMercadologo;
		this.numeroMercadologo = numeroMercadologo;
		this.ratingMercadologo = ratingMercadologo;
		this.correoMercadologo = correoMercadologo;
		this.linkedinMercadologo = linkedinMercadologo;
	}
	public int getIdMercadologo() {
		return idMercadologo;
	}
	public void setIdMercadologo(int idMercadologo) {
		this.idMercadologo = idMercadologo;
	}
	public String getNombreMercadologo() {
		return nombreMercadologo;
	}
	public void setNombreMercadologo(String nombreMercadologo) {
		this.nombreMercadologo = nombreMercadologo;
	}
	public String getNumeroMercadologo() {
		return numeroMercadologo;
	}
	public void setNumeroMercadologo(String numeroMercadologo) {
		this.numeroMercadologo = numeroMercadologo;
	}
	public int getRatingMercadologo() {
		return ratingMercadologo;
	}
	public void setRatingMercadologo(int ratingMercadologo) {
		this.ratingMercadologo = ratingMercadologo;
	}
	public String getCorreoMercadologo() {
		return correoMercadologo;
	}
	public void setCorreoMercadologo(String correoMercadologo) {
		this.correoMercadologo = correoMercadologo;
	}
	public String getLinkedinMercadologo() {
		return linkedinMercadologo;
	}
	public void setLinkedinMercadologo(String linkedinMercadologo) {
		this.linkedinMercadologo = linkedinMercadologo;
	}

}
