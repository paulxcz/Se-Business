package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ReviewMercadologo")
public class ReviewMercadologo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReview;
	
	@Column(name="calificacion", nullable = false)
	private int calificacion;
	@Column(name="detalleReview", length = 150, nullable = false)
	private String detalleReview;
	
	@ManyToOne
	@JoinColumn(name="idMercadologo", nullable = false)
	private Mercadologo mercadologo;

	public ReviewMercadologo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewMercadologo(int idReview, int calificacion, String detalleReview, Mercadologo mercadologo) {
		super();
		this.idReview = idReview;
		this.calificacion = calificacion;
		this.detalleReview = detalleReview;
		this.mercadologo = mercadologo;
	}

	public int getIdReview() {
		return idReview;
	}

	public void setIdReview(int idReview) {
		this.idReview = idReview;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getDetalleReview() {
		return detalleReview;
	}

	public void setDetalleReview(String detalleReview) {
		this.detalleReview = detalleReview;
	}

	public Mercadologo getMercadologo() {
		return mercadologo;
	}

	public void setMercadologo(Mercadologo mercadologo) {
		this.mercadologo = mercadologo;
	}
	
	
	
}
