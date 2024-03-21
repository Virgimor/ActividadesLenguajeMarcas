package es.iesjandula.coches.xml.hello_word;
public class Alumno implements Comparable<Alumno>{
 
	private String nombre;
    private int edad;
    private double calificacion;
    private boolean AsignaturasPendientes;
    
    public Alumno(String nombre, int edad, double calificacion, boolean asignaturasPendientes) {
 		super();
 		this.nombre = nombre;
 		this.edad = edad;
 		this.calificacion = calificacion;
 		AsignaturasPendientes = asignaturasPendientes;
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

	public boolean isAsignaturasPendientes() {
		return AsignaturasPendientes;
	}

	public void setAsignaturasPendientes(boolean asignaturasPendientes) {
		AsignaturasPendientes = asignaturasPendientes;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", calificacion=" + calificacion
				+ ", AsignaturasPendientes=" + AsignaturasPendientes + "]";
	}

	@Override
	public int compareTo(Alumno o) {
		// TODO Auto-generated method stub
		return this.getNombre().compareTo(o.getNombre());
	}
    
}