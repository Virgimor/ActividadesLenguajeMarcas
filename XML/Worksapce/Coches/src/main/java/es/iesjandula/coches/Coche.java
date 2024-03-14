package es.iesjandula.coches;

public class Coche
{
	
	private String modelo;
	private String marca;
	private Motor motor;
	private int kilometros;
	
	public Coche() 
	{
		//Constructor vacio
	}
	public Coche(String modelo, String marca, Motor motor, int kilometros) 
	{
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.motor = motor;
		this.kilometros = kilometros;
	}
	public String getModelo() 
	{
		return this.modelo;
	}
	public void setModelo(String modelo) 
	{
		this.modelo = modelo;
	}
	public String getMarca() 
	{
		return this.marca;
	}
	public void setMarca(String marca) 
	{
		this.marca = marca;
	}
	public Motor getMotor() 
	{
		return this.motor;
	}
	public void setMotor(Motor motor) 
	{
		this.motor = motor;
	}
	public int getKilometros() 
	{
		return this.kilometros;
	}
	public void setKilometros(int kilometros) 
	{
		this.kilometros = kilometros;
	}
	@Override
	public String toString() {
		return "Coche [modelo=" + modelo + ", marca=" + marca + ", motor=" + motor + ", kilometros=" + kilometros + "]";
	}
}
