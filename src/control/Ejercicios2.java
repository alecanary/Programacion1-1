package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import modelo.Persona;

public class Ejercicios2 {

	HashMap<String, Persona> mPersonas = new HashMap<String, Persona>();

	private ArrayList<String> cadenas = new ArrayList<String>();
	private ArrayList<Persona> personas = new ArrayList<Persona>();
	private ArrayList<Persona> personasFila2 = new ArrayList<Persona>();

	private ArrayList<ArrayList<Persona>> matrizPersonas = new ArrayList<ArrayList<Persona>>();
	private Scanner teclado = new Scanner(System.in);
	private boolean error = true;

	public String validaNif(String nif) {
		return nif;
	}

	public char validaSexo(String sexo) {
		return 'F';
	}

	public int validaFecha(String fecha) {
		return 0;
	}

	public void crearPersona() {
		do { // lectura por teclado y validacion de los datos
			
			error = false;
			System.out.println("Introduzca datos de la nueva persona(nif#nombre#sexo(M|F)#fecha), o q|Q para volver");
			String tecleado = teclado.nextLine();
			String[] campos = tecleado.split("#");
			if (campos.length != 4){
				System.out.println("NUMERO DE PARAMETROS DEBE SER 4 \n");
				error = true;
				continue;
			}
			if (validaNif(campos[0]).equals("") || 
					validaSexo(campos[2]) == 0 || 
					validaFecha(campos[3]) == -1) // hay al menos un error
			{
				error = true;
				System.out.println("HAY AL MENOS 1 DATO ERRONEO");

			}
			else // datos validos
			{
				crearPersonaInsertarLista(tecleado);
			}
		} while (error);
		System.out.println("DATOS CORRECTOS, SE CREA EL OBJETO Y SE AÑADE...");

		// Crear objeto persona con los datos validados.
		// lo añadimos al final a la lista
	}

	private void crearPersonaInsertarLista(String tecleado) {

	}

	public void pruebaMapaPersonas() {
		mPersonas.put("4321243245R", new Persona("4321243245R", "Lucas", 'M', 18991111));
		Persona p = new Persona();
		p.setNif("765431345T");
		p.setNombre("Daniel");
		p.setSexo('F');
		p.setFecha(20000621);
		mPersonas.put(p.getNif(), p);
		mPersonas.put(" ", new Persona());
	}

	public void recorrerMapa() {
		// obtenemos las claves del hashmap
		System.out.println("numero de elementos : " + mPersonas.size());
		Set<String> claves = mPersonas.keySet();
		for (String clave : claves) {
			System.out.println(clave + " => " + mPersonas.get(clave).getNombre());
		}
	}

	public void buscarEnMapa(String[] nifs) {
		for (String nif : nifs) {
			if (mPersonas.containsKey(nif))
				System.out.println("existe nif : " + nif);
			else
				System.out.println("no existe nif : " + nif);

		}
	}

	public void insertarEnCadenas() {
		cadenas.add("Paco");
		cadenas.add("Juan");
		cadenas.add("Maria");
		cadenas.add("Carlos");

	}

	public void insertarEnPersonas() {
		Persona p1 = new Persona("45343352F", "Pedro", 'M', 19930623);
		personas.add(p1);

		personas.add(new Persona("45777352X", "Maria", 'F', 19980929));
		// personas.add(null);
		//////////////////////////// añadir entre pedro y maria
		personas.add(1, new Persona("45777300L", "Juan", 'M', 19911229));

		//////////////////////////////// borrar a pedro
		// personas.remove(0);

		//////////////////////////// cambiar a Juan por Paco
		personas.set(0, new Persona("45777300L", "Paco", 'M', 19981229));

		////////////////////////// Añadir a otra persona
		personas.add(new Persona("45777350G", "Alicia", 'F', 19920219));

		personas.sort(null);

		///////////////////////////// Convertir un ArrayList a array
		/*
		 * Object[] arrayPersonas = (Object[]) personas.toArray(); for (Object
		 * persona : arrayPersonas) System.out.println(((Persona)
		 * persona).getNombre());
		 */

		// Inicializar la matriz de personas
		personasFila2.add(new Persona("45700000Q", "Jorge", 'M', 19780109));
		personasFila2.add(new Persona("45745670M", "Luisa", 'F', 20000111));
		personasFila2.add(new Persona("45745987I", "Fran", 'M', 19990611));
		personasFila2.add(new Persona("45741234B", "Tina", 'F', 20121212));

		matrizPersonas.add(personas);
		matrizPersonas.add(personasFila2);

	}

	public void recorrerMatrizPersonas() {
		for (int i = 0; i < matrizPersonas.size(); i++) {
			for (int j = 0; j < matrizPersonas.get(i).size(); j++) {
				try {
					System.out.print(matrizPersonas.get(i).get(j).getNombre() + ", ");
				} catch (NullPointerException e) {
					System.out.print("null");
				}
			}
			System.out.println();
		}
	}

	public void convertirArrayEnArrayList() {
		Persona[] personas = { new Persona("45745987I", "Fran", 'M', 19990611),
				new Persona("45741234B", "Tina", 'F', 20121212), null };

		this.personas = new ArrayList<Persona>(Arrays.asList(personas));
		System.out.println("DEBUG");
	}

	public void recorrerListaPersonas() { // bucle clasico
		for (int i = 0; i < personas.size(); i++)
			System.out.println(personas.get(i).getNombre());
	}

	public void recorrerListaPersonas2() { // bucle abreviado
		for (Persona persona : personas)
			if (persona != null) {
				System.out.println(
						persona.getNombre() + ", FechaNac: " + persona.getFecha() + ", sexo: " + persona.getSexo());

			} else
				System.out.println("Aqui hay un null");

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