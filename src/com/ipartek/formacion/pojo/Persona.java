package com.ipartek.formacion.pojo;

public class Persona {

	private int id;
	private String nombre;
	private String dni;
	private String fecha;
	private String observaciones;
	private String email;	
	
	public Persona() {
		super();
		this.id = -1;
		this.nombre = "";
		this.dni= "";
		this.fecha= null;
		this.observaciones= "";
		this.email= "";
	}
	
	
////////////////////////////////////
	public Persona(String nombre, String dni, String fecha, String observaciones, String email) {
		super();
		this.id = -1;
		this.nombre = nombre;
		this.dni = dni;
		this.fecha = fecha;
		this.observaciones = observaciones;
		this.email = email;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
