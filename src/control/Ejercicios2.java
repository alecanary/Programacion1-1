package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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
		Persona p1 = new Persona("45343352F", "Pedro", 'M', "19930623");
		personas.add(p1);

		personas.add(new Persona("45777352X", "Maria", 'F', "19980929"));
		
		//////////////////////////// añadir entre pedro y maria
		personas.add(1, new Persona("45777300L", "Juan", 'M', "19981229"));
		
		////////////////////////////////borrar a pedro
		personas.remove(0);
		
		////////////////////////////cambiar a Juan por Paco
		personas.set(0, new Persona("45777300L", "Paco", 'M', "19981229"));
		
		/////////////////////////////Convertir un ArrayList a array
		Object[] arrayPersonas = (Object[]) personas.toArray();
		for (Object persona : arrayPersonas)
			System.out.println(((Persona) persona).getNombre());
	}

	public void recorrerListaPersonas() { // bucle clasico
		for (int i = 0; i < personas.size(); i++)
			System.out.println(personas.get(i).getNombre());
	}

	public void recorrerListaPersonas2() { // bucle abreviado
		for (Persona persona : personas)
			System.out.println(persona.getNombre());
	}

	public void recorrerListaPersonas3() { // con un iterador
		Iterator<Persona> iteradorLista = personas.iterator();
		while (iteradorLista.hasNext()) {
			Persona persona = (Persona) iteradorLista.next();
			// Procesar persona
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