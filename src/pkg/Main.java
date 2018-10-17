package pkg;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		//-Nuevo Empleado y Sucursal
		Empleado e = new Empleado(99, "1234567-8", "Juan", "Perez", 1234,5 );
		Sucursal s = new Sucursal(99, 46641234, "18 de Julio 123", "Centro");
		//-Agrego el nuevo empleado a la sucursal
		s.addEmpleado(e);
		
		//-Los ingreso en la base de datos
		DAOSucursales.insert(s);
		DAOEmpleados.insert(e);
		
	
		
		//-Modifico los datos del Empleado y la Sucursal
		e.setNombre("Jorge");
		s.setNombre("Nautico");
		
		//-Actualizo la información en la BD
		DAOEmpleados.update(e);
		DAOSucursales.update(s);
		
		//-Imprimo en consola todas las sucursales
		LinkedList<Sucursal> sucursales2 = DAOSucursales.findAll();
		imprimirSucursales(sucursales2);
				
		//-Imprimo en consola todos los empleados
		LinkedList<Empleado> empleados2 = DAOEmpleados.findAll();
		imprimirEmpleados(empleados2);
		
		
		
		
	}
	private static void imprimirSucursales(LinkedList<Sucursal> sucursales) {
		for(Sucursal s: sucursales){
			imprimirSucursal(s);
		}

	}


	private static void imprimirSucursal(Sucursal s) {

		System.out.println("ID Sucursal: " + s.getId());
		System.out.println("Nombre: " + s.getNombre());
		System.out.println("Dirección: " + s.getDireccion());
		System.out.println("Teléfono: " + s.getTelefono());
		System.out.println();		
	}
	
	private static void imprimirEmpleados(LinkedList<Empleado> empleados) {
		for (Empleado e : empleados){
			imprimirEmpleado(e);
		}
	}

	private static void imprimirEmpleado(Empleado e) {

		System.out.println("ID Empleado: " + e.getId());
		System.out.println("Nombre: " + e.getNombre());
		System.out.println("Cédula: " + e.getCedula());
		System.out.println("Apellido: " + e.getApellido());
		System.out.println("Sueldo: " + e.getSueldo());
		System.out.println("ID Sucursal: " + e.getIdSucursal());
		System.out.println();
	}

}
