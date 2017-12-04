package es.salesianos.connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.salesianos.model.Consola;
import es.salesianos.model.VideoJuego;

public class VideoJuegoRepository {

	private AbstractConnection connection = new AbstractConnection() {

		@Override
		public String getDriver() {
			return "org.h2.Driver";
		}

		@Override
		public String getDatabaseUser() {
			return "sa";
		}

		@Override
		public String getDatabasePassword() {
			return "";
		}
	};
	
	private AbstractConnection connectionPostgres = new AbstractConnection() {

		@Override
		public String getDriver() {
			return "org.postgresql.Driver";
		}

		@Override
		public String getDatabaseUser() {
			return "postgres";
		}

		@Override
		public String getDatabasePassword() {
			return "postgres";
		}
	};

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	public void insert(VideoJuego videojuego) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO videojuegos (ID,titulo,edadRecomendada,fechaLanzamiento)" + "VALUES (?, ?, ?,?)");
			preparedStatement.setString(1, videojuego.getID());
			preparedStatement.setString(2, videojuego.getTitulo());
			preparedStatement.setString(3, videojuego.getEdadRecomendada());
			preparedStatement.setDate(4,(Date) videojuego.getFechaLanzamiento()); 
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
		}

		connection.close(conn);
	}





	public Optional<VideoJuego> search (VideoJuego videojuego, Consola consola) {
		VideoJuego videoJuego = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = null;

		try {
			conn = connection.open(jdbcUrl);
			preparedStatement = conn.prepareStatement("SELECT * FROM videojuegos WHERE ID = ? and empresa = ?");
			preparedStatement.setString(1, videojuego.getID());
			preparedStatement.setString(2, consola.getEmpresa());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				videoJuego = new VideoJuego();
				videoJuego.setID(resultSet.getString("ID"));
				videoJuego.setTitulo(resultSet.getString("titulo"));
				videoJuego.setEdadRecomendada(resultSet.getString("edadRecomendada"));
				videoJuego.setFechaLanzamiento(resultSet.getString("fechaRecomendada")); 
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}

		return Optional.ofNullable(videoJuego);

	}
	

	public Optional<VideoJuego> searchPorEdad (VideoJuego videojuego) {
		VideoJuego videoJuego = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = null;

		try {
			conn = connection.open(jdbcUrl);
			preparedStatement = conn.prepareStatement("SELECT * FROM videojuegos WHERE edadRecomendada = ? or edadRecomendada <= ?");
			preparedStatement.setString(1, videojuego.getEdadRecomendada());
			preparedStatement.setString(2, videojuego.getEdadRecomendadaoMayor(videojuego.getEdadRecomendada()));
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				videoJuego = new VideoJuego();
				videoJuego.setID(resultSet.getString("ID"));
				videoJuego.setTitulo(resultSet.getString("titulo"));
				videoJuego.setEdadRecomendada(resultSet.getString("edadRecomendada"));
				videoJuego.setFechaLanzamiento(resultSet.getString("fechaRecomendada")); 
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}

		return Optional.ofNullable(videoJuego);

	}

	public void update(VideoJuego videojuego) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = connection.open(jdbcUrl);
			preparedStatement = conn.prepareStatement("UPDATE videojuegos SET " + "titulo = ?, edadRecomendada = ? , fechaLanzamiento =? ,WHERE ID = ?");

			preparedStatement.setString(1, videojuego.getID());
			preparedStatement.setString(2, videojuego.getTitulo());
			preparedStatement.setString(3, videojuego.getEdadRecomendada());
			preparedStatement.setDate(4,(Date) videojuego.getFechaLanzamiento()); 
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}
	}

	public List<VideoJuego> listAllVideoJuegos() {
		List<VideoJuego> videojuegos = new ArrayList<VideoJuego>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			conn = connection.open(jdbcUrl);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM videojuegos");

			while (resultSet.next()) {
				VideoJuego videoJuego = new VideoJuego();
				videoJuego.setID(resultSet.getString("ID"));
				videoJuego.setTitulo(resultSet.getString("titulo"));
				videoJuego.setEdadRecomendada(resultSet.getString("edadRecomendada"));
				videoJuego.setFechaLanzamiento(resultSet.getString("fechaLanzamiento")); 
				videojuegos.add(videoJuego);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(resultSet);
			connection.close(statement);
			connection.close(conn);
		}

		return videojuegos;
	}

}
