package es.iesjandula.coches;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Motor m1 = new Motor(100, "Gasolina");
		Coche c1 = new Coche("Tucson", "Hyundai", m1, 1000);
		
		System.out.println(m1.getCaballos());

	}

}
