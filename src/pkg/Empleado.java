package pkg;

public class Empleado {

	private int id;
	private String cedula;
	private String nombre;
	private String apellido;
	private float sueldo;
	private int idSucursal;
	
	//Constructor sin idSucursal (para luego usar sucursal.AddEmpleado();)
	public Empleado(int idEmpleado, String cedula, String nombre, String apellido, float sueldo) {
		this.id = idEmpleado;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
	}
	
	//Constructor completo
	public Empleado(int id, String cedula, String nombre, String apellido, float sueldo, int idSucursal) {
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
		this.idSucursal = idSucursal;
	}


	//Setters y Getters
	public int getId() {
		return id;
	}
	public void setId(int idEmpleado) {
		this.id = idEmpleado;	
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public int getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	
}
