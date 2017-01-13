package modelo;

import java.util.Date;

import control.Humano;

public class Persona implements Humano {

	private String nif;
	private String nombre;
	private char sexo; 
	private String fecha;
	
	public Persona(String nif, String nombre, char sexo, String fecha) {
	    super();
		this.nif = nif;
		this.nombre = nombre;
		this.sexo = sexo;
		this.fecha = fecha;
	}

	public Persona() {
		super();
		this.nif = "123456789K";
		this.nombre = "anonimo";
		this.sexo = 'M';
		this.fecha = "19930623";
		// TODO Auto-generated constructor stub
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNif() {
		return nif;
	}

	public String getNombre() {
		return nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public String getFecha() {
		return fecha;
	}

	@Override
	public void caminar(int numPasos) {
		// TODO Auto-generated method stub
		System.out.println("caminando " + numPasos + "pasos" );

	}

	@Override
	public int dormir(int numHoras) {
		// TODO Auto-generated method stub
		return numHoras;
	}
}
