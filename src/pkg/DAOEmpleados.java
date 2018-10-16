package pkg;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DAOEmpleados {

	private static final String INSERT_EMPLEADO = "INSERT INTO EMPLEADOS (ID_EMPLEADO, CEDULA, NOMBRE, APELLIDO, SUELDO, ID_SUCURSAL) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_EMPLEADO = "UPDATE EMPLEADOS SET CEDULA = ?, NOMBRE = ?, APELLIDO = ?, SUELDO = ?, ID_SUCURSAL = ? WHERE ID_EMPLEADO = ?";
	private static final String DELETE_EMPLEADO = "DELETE FROM EMPLEADOS WHERE ID_EMPLEADO = ?";
	private static final String ALL_EMPLEADOS = "SELECT * FROM EMPLEADOS";
	private static final String EMPLEADOS_ID = "SELECT * FROM EMPLEADOS WHERE ID_EMPLEADO = ?";
	
	//insterta el empleado pasado por parametros
	public static boolean insert(Empleado empleado) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_EMPLEADO);
			statement.setInt(1, empleado.getId());
			statement.setString(2, empleado.getCedula());
			statement.setString(3, empleado.getNombre());
			statement.setString(4, empleado.getApellido());
			statement.setFloat(5, empleado.getSueldo());
			statement.setInt(6, empleado.getIdSucursal());
			
			return statement.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//actualiza los datos del empleado
	public static boolean update(Empleado empleado) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_EMPLEADO);
			
			statement.setString(1, empleado.getCedula());
			statement.setString(2, empleado.getNombre());
			statement.setString(3, empleado.getApellido());
			statement.setFloat(4, empleado.getSueldo());
			statement.setInt(5, empleado.getIdSucursal());
			statement.setInt(6, empleado.getId());
			
			return statement.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//elimina del sistem el empleado
	public static boolean delete(Empleado empleado) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_EMPLEADO);
			
			statement.setInt(1, empleado.getId());
			
			return statement.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//devuelve en una LinkedList todos los empleados almacenados
	public static LinkedList<Empleado> findAll(){
		LinkedList<Empleado> empleados = new LinkedList<>();
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_EMPLEADOS);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Empleado empleado = getEmpleadoFromResultSet(resultSet);
				empleados.add(empleado);
			}
			
			return empleados;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Busca un empleado por su Id
	public static Empleado find(int idEmpleado) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(EMPLEADOS_ID);
			statement.setInt(1, idEmpleado);
			
			ResultSet resultSet = statement.executeQuery();
			Empleado empleado = null;
			while (resultSet.next()) {
				empleado = getEmpleadoFromResultSet(resultSet);
			}
			
			return empleado;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	//obtener empleado desde ResultSet
	private static Empleado getEmpleadoFromResultSet(ResultSet resultSet) throws SQLException{
		
		int idEmpleado = resultSet.getInt("ID_EMPLEADO");
		String cedula = resultSet.getString("CEDULA");
		String nombre = resultSet.getString("NOMBRE");
		String apellido = resultSet.getString("APELLIDO");
		float sueldo = resultSet.getFloat("SUELDO");
		int idSucursal = resultSet.getInt("ID_SUCURSAL");
		
		Empleado empleado = new Empleado( idEmpleado, cedula, nombre, apellido, sueldo, idSucursal);
		
		return empleado;
	}
	
}
