package pkg;

import java.util.LinkedList;

public class Sucursal {

	private int id;
	private int telefono;
	private String direccion;
	private String nombre;
	private LinkedList<Empleado> empleados;
	
	//Constructor
	public Sucursal(int id, int telefono, String direccion, String nombre) {
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nombre = nombre;
		this.empleados = new LinkedList<Empleado>();
	}
	
	//Setters y Getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public LinkedList<Empleado> getEmpleados() {
		return empleados;
	}

	public void addEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
		empleado.setIdSucursal(getId());
	}
	
}
