package modelo;

import control.Humano;

public class Persona implements Humano, Comparable {

	private String nif;
	private String nombre;
	private char sexo;
	private int fecha;

	public Persona(String nif, String nombre, char sexo, int fecha) {
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
		this.fecha = 19930623;
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

	public void setFecha(int fecha) {
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

	public int getFecha() {
		return fecha;
	}

	@Override
	public void caminar(int numPasos) {
		// TODO Auto-generated method stub
		System.out.println("caminando " + numPasos + "pasos");

	}

	@Override
	public int dormir(int numHoras) {
		// TODO Auto-generated method stub
		return numHoras;
	}

	/*@Override
	public int compareTo(Object persona) {
		if (this.nombre.length() > ((Persona) persona).getNombre().length())
			return 1;
		else if (this.nombre.length() > ((Persona) persona).getNombre().length())
			return -1;

		return 0;
	}*/
	
	/*@Override
	public int compareTo(Object o) {
		Persona p = (Persona) o;
		//return this.nombre.compareTo(p.getNombre());
		 if( this.fecha > p.getFecha())
		  return 1;
		 else if( this.fecha < p.getFecha())
			  return -1;
			 return 0;
	}*/
	
	@Override
	public int compareTo(Object o) {
		Persona p = (Persona) o;
		//return this.nombre.compareTo(p.getNombre());
		 if( this.sexo > p.getSexo())
		  return -1;
		 else if( this.sexo < p.getSexo())
			  return 1;
			 return 0;
	}
	
	
}
