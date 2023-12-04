package ejercicio;

import java.sql.*;
import java.util.Scanner;

public class GestionEstudiantes {

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionestudiantes", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void insertarEstudiante(String nombre, String apellido, int edad, String curso) {
		Connection con = conectar();
		try {
			String query = "INSERT INTO estudiantes (nombre, apellido, edad, curso) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nombre);
			pstmt.setString(2, apellido);
			pstmt.setInt(3, edad);
			pstmt.setString(4, curso);
			pstmt.executeUpdate();
			System.out.println("Estudiante agregado correctamente.");
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarEstudiantes() {
		Connection con = conectar();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM estudiantes");
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre") + ", Apellido: "
						+ rs.getString("apellido") + ", Edad: " + rs.getInt("edad") + ", Curso: "
						+ rs.getString("curso"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actualizarEstudiante(int id, String nombre, String apellido, int edad, String curso) {
		Connection con = conectar();
		try {
			String query = "UPDATE estudiantes SET nombre=?, apellido=?, edad=?, curso=? WHERE id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nombre);
			pstmt.setString(2, apellido);
			pstmt.setInt(3, edad);
			pstmt.setString(4, curso);
			pstmt.setInt(5, id);
			pstmt.executeUpdate();
			System.out.println("Estudiante actualizado correctamente.");
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminarEstudiante(int id) {
		Connection con = conectar();
		try {
			String query = "DELETE FROM estudiantes WHERE id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("Estudiante eliminado correctamente.");
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		GestionEstudiantes gestion = new GestionEstudiantes();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Seleccione una opción:");
			System.out.println("|1| Insertar estudiante");
			System.out.println("|2| Mostrar estudiantes");
			System.out.println("|3| Actualizar estudiante");
			System.out.println("|4| Eliminar estudiante");
			System.out.println("|5| Salir");

			int opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				System.out.println("Ingrese nombre del estudiante:");
				String nombre = scanner.nextLine();
				System.out.println("Ingrese apellido del estudiante:");
				String apellido = scanner.nextLine();
				System.out.println("Ingrese edad del estudiante:");
				int edad = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Ingrese curso del estudiante:");
				String curso = scanner.nextLine();
				gestion.insertarEstudiante(nombre, apellido, edad, curso);
				break;
			case 2:
				gestion.mostrarEstudiantes();
				break;
			case 3:
				System.out.println("Ingrese ID del estudiante a actualizar:");
				int idActualizar = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Ingrese nuevo nombre del estudiante:");
				String nuevoNombre = scanner.nextLine();
				System.out.println("Ingrese nuevo apellido del estudiante:");
				String nuevoApellido = scanner.nextLine();
				System.out.println("Ingrese nueva edad del estudiante:");
				int nuevaEdad = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Ingrese nuevo curso del estudiante:");
				String nuevoCurso = scanner.nextLine();
				gestion.actualizarEstudiante(idActualizar, nuevoNombre, nuevoApellido, nuevaEdad, nuevoCurso);
				break;
			case 4:
				System.out.println("Ingrese ID del estudiante a eliminar:");
				int idEliminar = scanner.nextInt();
				scanner.nextLine(); // Para consumir el salto de línea
				gestion.eliminarEstudiante(idEliminar);
				break;
			case 5:
				System.out.println("Saliendo...");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}
		}
	}
}
