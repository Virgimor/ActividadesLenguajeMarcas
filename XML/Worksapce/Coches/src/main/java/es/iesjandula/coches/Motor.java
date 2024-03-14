package es.iesjandula.coches;

public class Motor {
	
	private int caballos;
	private String tipo;
	
	
	public Motor() {
		super();
	}

	public Motor(int caballos, String tipo) {
		super();
		this.caballos = caballos;
		this.tipo = tipo;
	}

	public int getCaballos() {
		return this.caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Motor [caballos=" + caballos + ", tipo=" + tipo + "]";
	}

}
