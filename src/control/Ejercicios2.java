package control;

import java.util.ArrayList;
import java.util.Date;

import modelo.Persona;

public class Ejercicios2 {
	private ArrayList<String> cadenas = new ArrayList<String>();
	private ArrayList<Persona> personas = new ArrayList<Persona>();

	public void insertarEnCadenas() {
		cadenas.add("Paco");
		cadenas.add("Juan");
		cadenas.add("Maria");
		cadenas.add("Carlos");

	}

	public void insertarEnPersonas() {
		Persona p1 = new Persona("45343352F", "Pepe", 'M', "19930623");
		personas.add(p1);
		
		personas.add(new Persona("45777352X", "Carmen", 'F', "19980929"));
	}

	public void recorrerListaPersonas() {
		for (int i = 0; i < personas.size(); i++) {
			System.out.println(personas.get(i).getNombre());
		}
	}
	
	public void recorrerListaPersonas2() {
		for (Persona persona:personas) //bucle abreviado
		{
			System.out.println(persona.getNombre());
		}
	}
	
	
	public ArrayList<String> getCadenas() {
		return cadenas;
	}

	public void setCadenas(ArrayList<String> cadenas) {
		this.cadenas = cadenas;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

}