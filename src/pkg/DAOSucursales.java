package pkg;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DAOSucursales {

	private static final String INSERT_SUCURSAL = "INSERT INTO SUCURSALES (ID_SUCURSAL, TELEFONO, DIRECCION, NOMBRE) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_SUCURSAL = "UPDATE SUCURSALES SET TELEFONO = ?, DIRECCION = ?, NOMBRE = ? WHERE ID_SUCURSAL = ?";
	private static final String DELETE_SUCURSAL = "DELETE FROM SUCURSALES WHERE ID_SUCURSAL = ?";
	private static final String ALL_SUCURSALES = "SELECT * FROM SUCURSALES";
	private static final String SUCURSAL_ID = "SELECT * FROM SUCURSALES WHERE ID_SUCURSAL = ?";
	
	//insterta el empleado pasado por parametros
	public static boolean insert(Sucursal sucursal) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_SUCURSAL);
			statement.setInt(1, sucursal.getId());
			statement.setInt(2, sucursal.getTelefono());
			statement.setString(3, sucursal.getDireccion());
			statement.setString(4, sucursal.getNombre());
			
			return statement.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//actualiza los datos de la sucursal
	public static boolean update(Sucursal sucursal) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_SUCURSAL);
			
			statement.setInt(1, sucursal.getTelefono());
			statement.setString(2, sucursal.getDireccion());
			statement.setString(3, sucursal.getNombre());
			statement.setInt(4, sucursal.getId());
			
			return statement.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//elimina del sistema la sucursal
	public static boolean delete(Sucursal sucursal) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_SUCURSAL);
			
			statement.setInt(1, sucursal.getId());
			
			return statement.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//devuelve en una LinkedList todas las sucursales almacenadas
	public static LinkedList<Sucursal> findAll(){
		LinkedList<Sucursal> sucursales = new LinkedList<>();
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_SUCURSALES);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Sucursal sucursal = getSucursalFromResultSet(resultSet);
				sucursales.add(sucursal);
			}
			
			return sucursales;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Busca una sucursal por su Id
	public static Sucursal find(int idSucursal) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(SUCURSAL_ID);
			
			statement.setInt(1, idSucursal);
			
			ResultSet resultSet = statement.executeQuery();
			
			Sucursal sucursal = null;
			while (resultSet.next()) {
				sucursal = getSucursalFromResultSet(resultSet);
			}
			
			return sucursal;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	//obtener sucursal desde ResultSet
	private static Sucursal getSucursalFromResultSet(ResultSet resultSet) throws SQLException{
		
		int id = resultSet.getInt("ID_SUCURSAL");
		int telefono = resultSet.getInt("TELEFONO");
		String direccion = resultSet.getString("DIRECCION");
		String nombre = resultSet.getString("NOMBRE");
		
		Sucursal sucursal = new Sucursal(id, telefono, direccion, nombre);
		
		return sucursal;
	}
}
