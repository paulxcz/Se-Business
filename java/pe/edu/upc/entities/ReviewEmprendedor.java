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
@Table(name = "ReviewEmprendedor")
public class ReviewEmprendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReview;
	
	@Column(name="calificacion", nullable = false)
	private int calificacion;
	@Column(name="detalleReview", length = 150, nullable = false)
	private String detalleReview;
	
	@ManyToOne
	@JoinColumn(name="idEmprendedor", nullable = false)
	private Emprendedor emprendedor;

	public ReviewEmprendedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewEmprendedor(int idReview, int calificacion, String detalleReview, Emprendedor emprendedor) {
		super();
		this.idReview = idReview;
		this.calificacion = calificacion;
		this.detalleReview = detalleReview;
		this.emprendedor = emprendedor;
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

	public Emprendedor getEmprendedor() {
		return emprendedor;
	}

	public void setEmprendedor(Emprendedor emprendedor) {
		this.emprendedor = emprendedor;
	}
	
	
	
}
