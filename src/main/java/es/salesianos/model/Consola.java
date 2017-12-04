package es.salesianos.model;

public class Consola {

	private String ID;//lo pongo como string para que lo coja el assembler
	private String nombre;
	private String empresa;
	private Empresa empresas = new Empresa();
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Empresa getEmpresas() {
		return empresas;
	}
	public void setEmpresas(Empresa empresas) {
		this.empresas = empresas;
	}

	
}
