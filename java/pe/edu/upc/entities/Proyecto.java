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
@Table(name="proyectos")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idProyecto;
	
	@Column(name = "nombre" , nullable = false)
	private String nombre;
	
	@Column(name="anuncio", length = 160, nullable = true)
	private String anuncio;
	
	@ManyToOne
	@JoinColumn(name="idEmprendedor", nullable = false)
	private Emprendedor emprendedor;
	
	@Column(name="descripcion", length = 160, nullable = false)
	private String descripcion;
	
	@Column(name="estado", length = 100 ,nullable = false)
	private String estado;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaFinalizacion;

	public Proyecto(int idProyecto, String nombre, String anuncio, Emprendedor emprendedor, String descripcion,
			String estado, Date fechaFinalizacion) {
		super();
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.anuncio = anuncio;
		this.emprendedor = emprendedor;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaFinalizacion = fechaFinalizacion;
	}
	
	public Proyecto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(String anuncio) {
		this.anuncio = anuncio;
	}

	public Emprendedor getEmprendedor() {
		return emprendedor;
	}

	public void setEmprendedor(Emprendedor emprendedor) {
		this.emprendedor = emprendedor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	
}
