package es.salesianos.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.salesianos.model.Consola;

public class ConsolaRepository {

	AbstractConnection connection;

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	public void insert(Consola userFormulario) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO consolas (ID,nombre)" + "VALUES (?, ?,?)");
			preparedStatement.setString(1, userFormulario.getID());
			preparedStatement.setString(2, userFormulario.getNombre());
			preparedStatement.setString(3, userFormulario.getEmpresa());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
		}

		connection.close(conn);
	}





	public Optional<Consola> search(Consola consol) {
		Consola consola = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = null;

		try {
			conn = connection.open(jdbcUrl);
			preparedStatement = conn.prepareStatement("SELECT * FROM consolas WHERE ID = ? and empresa = ?" );
			preparedStatement.setString(1, consol.getID());
			preparedStatement.setString(2, consol.getEmpresa());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				consola = new Consola();
				consola.setID(resultSet.getString("ID"));
				consola.setNombre(resultSet.getString("nombre"));
				consola.setEmpresa(resultSet.getString("empresa"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}

		return Optional.ofNullable(consola);

	}

	public void update(Consola consol) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = connection.open(jdbcUrl);
			preparedStatement = conn.prepareStatement("UPDATE consolas SET " + "nombre= ? WHERE ID = ?");

			preparedStatement.setString(1, consol.getNombre());
			preparedStatement.setString(2, consol.getID());
			preparedStatement.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}
	}

	public List<Consola> listAllConsolas() {
		List<Consola> consolas = new ArrayList<Consola>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			conn = connection.open(jdbcUrl);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM consolas");

			while (resultSet.next()) {
				Consola consola = new Consola();
				consola.setID(resultSet.getString("ID"));
				consola.setNombre(resultSet.getString("nombre"));

				consolas.add(consola);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(resultSet);
			connection.close(statement);
			connection.close(conn);
		}

		return consolas;
	}

}
