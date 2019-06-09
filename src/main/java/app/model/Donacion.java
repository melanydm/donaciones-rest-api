package app.model;

import org.springframework.data.annotation.Id;

public class Donacion {
	
	@Id
	private String id;
	private String transaccionId;
	private String fecha;
	private float monto;
	public enum moneda {
		Pesos,
		Dólares
	}
	private String usuario;
	private String moneda;
	
	public Donacion() {

	}

	public Donacion(String transaccionId, String fecha, String monto, String moneda, String usuario) {
		this.transaccionId = transaccionId;
		this.fecha = fecha;
		this.monto = Float.valueOf(monto.trim()).floatValue();
		this.usuario = usuario;
		this.moneda = moneda;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTransaccionId() {
		return transaccionId;
	}

	public void setTransaccionId(String transaccionId) {
		this.transaccionId = transaccionId;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}


}
