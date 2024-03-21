package es.iesjandula.coches.xml.hello_word;

public class Alumnoo implements Comparable<Alumnoo>{
	
	private String nombre;
	private int edad;
	private double calificacion;
	private boolean unidadesPendientes;
	
	public Alumnoo() {
		super();
	}

	public Alumnoo(String nombre, int edad, double calificacion, boolean unidadesPendientes) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.calificacion = calificacion;
		this.unidadesPendientes = unidadesPendientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public boolean isUnidadesPendientes() {
		return unidadesPendientes;
	}

	public void setUnidadesPendientes(boolean unidadesPendientes) {
		this.unidadesPendientes = unidadesPendientes;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", calificacion=" + calificacion
				+ ", unidadesPendientes=" + unidadesPendientes + "]";
	}
	@Override
	public int compareTo(Alumnoo o) {
		
		return  (int) (this.getCalificacion()-o.getCalificacion());
	}

}
