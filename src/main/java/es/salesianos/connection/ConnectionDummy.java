package es.salesianos.connection;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import es.salesianos.model.Consola;

@Component("dummy")
public class ConnectionDummy implements ConnectionManager {

	public Connection open(String jdbcUrl) {
		return null;
	}

	public void close(Connection conn) {

	}

	public void insert(Consola user) {
		System.out.println("insert ficticio");

	}

	public Optional<Consola> search(Consola user) {
		return Optional.empty();
	}

	public void update(Consola user) {

	}

	public List<Consola> listAllUsers() {
		return Collections.EMPTY_LIST;
	}

}
