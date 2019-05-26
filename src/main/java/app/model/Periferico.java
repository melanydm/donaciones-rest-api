package app.model;

import org.springframework.data.annotation.Id;

public class Periferico {

	@Id
	private String id;
	private String nombre;
	private String password;

	public Periferico() {

	}

	public Periferico(String nom, String pass) {
		this.nombre = nom;
		this.password = pass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
