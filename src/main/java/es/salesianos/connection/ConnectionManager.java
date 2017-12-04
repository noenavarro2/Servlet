package es.salesianos.connection;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import es.salesianos.model.Consola;

public interface ConnectionManager {
	
	public Connection open(String jdbcUrl);
	
	public void close(Connection conn);

	void insert(Consola user);

	Optional<Consola> search(Consola user);

	void update(Consola user);

	List<Consola> listAllUsers();

}
