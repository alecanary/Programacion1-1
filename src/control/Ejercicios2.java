package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.sun.javafx.scene.traversal.SubSceneTraversalEngine;

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
		// Criterios de validacion del nif
		// tener 9 caracteres

		// los 8 primeros deben ser numeros y el ultimo caracter una letra
		if (!nif.matches("[0-9]{8}[a-zA-Z]{1}")) {
			System.out.println("NIF erroneo");
			return "";
		}
		// la letra debe obtenerse a partir de un algoritmo en funcion de los
		// digitos
		else if (!validaLetraNif(nif)) {
			System.out.println("NIF erroneo, letra mal");
			return "";
		}

		return nif;
	}

	private boolean validaLetraNif(String nif) {
		// extraer y convertir el numero del nif
		// extraer la letra
		int numeroNif = Integer.parseInt(nif.substring(0, 8));
		char letraNif = nif.substring(8).toUpperCase().charAt(0);

		String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
		if (NIF_STRING_ASOCIATION.charAt(numeroNif % 23) == letraNif) {
			return true;
		}
		return false;
	}

	public char validaSexo(String sexo) {
		if (sexo.length() != 1 || !sexo.matches("[mMfF]")) {
			System.out.println("Sexo incorrecto");
			return 0;
		}

		return sexo.charAt(0);
	}

	public int validaFecha(String fecha) {
		// validar AAAA posterior a 1900 y anterior a la actualidad
		// MM entre 01 y 12
		// DD depende del mes
		int year, mes, dia;
		int[] diasMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (fecha.length() != 8)
			return -1;
		try {
			year = Integer.parseInt(fecha.substring(4, 8));
			mes = Integer.parseInt(fecha.substring(2, 4));
			dia = Integer.parseInt(fecha.substring(0, 2));
		} catch (NumberFormatException e) {
			System.out.println("Formato de fecha INCORRECTO");
			return -1;
		}
		if (mes < 1 || mes > 12)
			return -1;
		if (dia < 1 || dia > diasMes[mes - 1])
			return -1;

		Date fActual = new Date(); // fecha de hoy
		Date fechaTecleada = new Date(year - 1900, mes, dia);
		if (year < 1900 || fechaTecleada.after(fActual))
			return -1;

		return Integer.parseInt(fecha);
	}

	public void borrarPersona() { // se valida el ID

		String tecleado = null;
		do { // lectura por teclado del id de la persona a borrar de la
				// lista
			try {
				error = false;
				System.out.println("Introduzca ID de la persona (1-" + personas.size() + ") o q|Q para volver");
				tecleado = teclado.nextLine();
				if(tecleado.compareToIgnoreCase("q") ==0)
					return;
				if (Integer.parseInt(tecleado) < 1 || Integer.parseInt(tecleado) > personas.size())
					error = true;
			} catch (NumberFormatException e) {
				error = true;
			}
		} while (error);
		// pedir confirmacion de borrado
		System.out.println("¿Está realmente SEGURO  de eliminar de la lista a "
				+ personas.get(Integer.parseInt(tecleado) - 1).getNombre() + "? (ENTER para confirmar)");

		String borrarSiNo = teclado.nextLine();
		System.out.println("tecleado : " + borrarSiNo);
		if (borrarSiNo.equals("")) {
			System.out
					.println("Borrando a " + personas.get(Integer.parseInt(tecleado) - 1).getNombre() + " de la lista");
			personas.remove(Integer.parseInt(tecleado) - 1);

		} else
			System.out.println("Eliminación cancelada por el usuario");
	}

	public void borrarPersonaNif() { // se valida el Nif

		String tecleado = null;
		do { // lectura por teclado del nif de la persona a borrar de la
				// lista

			error = false;
			System.out.println("Introduzca NIF de la persona (xxxxxxxxZ) o q|Q para volver");
			tecleado = teclado.nextLine();
			if(tecleado.compareToIgnoreCase("q") ==0)
				return;
			if (validaNif(tecleado).equals(""))
				error = true;

		} while (error);

		// ¿existe el nif en la lista?
		if (existeEnLaListaNIF(tecleado)) {

			System.out.println("¿Está realmente SEGURO  de eliminar de la lista a la persona cuyo NIF es "
					+ tecleado + "? (ENTER para confirmar)");

			String borrarSiNo = teclado.nextLine();
			System.out.println("tecleado : " + borrarSiNo);
			if (borrarSiNo.equals("")) {
				System.out.println(
						"Borrando a " + tecleado + " de la lista");
				personas.remove(getIdFromNif(tecleado));

			} else
				System.out.println("Eliminación cancelada por el usuario");
		}else
			System.out.println("Este NIF no existe en la lista");
	}

	public void crearPersona() {
		do { // lectura por teclado y validacion de los datos

			error = false;
			System.out.println(
					"Introduzca datos de la nueva persona(nif#nombre#sexo(M|F)#fecha(DDMMAAAA)), o q|Q para volver");
			String tecleado = teclado.nextLine();
			if(tecleado.compareToIgnoreCase("q") ==0)
				return;
			String[] campos = tecleado.split("#");
			if (campos.length != 4) {
				System.out.println("NUMERO DE PARAMETROS DEBE SER 4 \n");
				error = true;
				continue;
			}
			if (validaNif(campos[0]).equals("") || validaSexo(campos[2]) == 0 || validaFecha(campos[3]) == -1) // hay
																												// al
																												// menos
																												// un
																												// error
			{
				error = true;
				System.out.println("HAY AL MENOS 1 DATO ERRONEO");

			} else // datos validos
			{
				if (!existeEnLaListaNIF(campos[0]))
					crearPersonaInsertarLista(tecleado);
				else
					System.out.println("Alta duplicada Nif:" + campos[0]);
			}
		} while (error);
		System.out.println("DATOS CORRECTOS, SE CREA EL OBJETO Y SE AÑADE...");

		// Crear objeto persona con los datos validados.
		// lo añadimos al final a la lista
	}

	public boolean existeEnLaListaNIF(String nif) {

		for (Persona persona : personas) {
			if (persona.getNif().equals(nif))
				return true;

		}
		return false;
	}
	public int getIdFromNif(String nif){
		for (int i = 0; i < personas.size(); i++) {
			if(personas.get(i).getNif().compareToIgnoreCase(nif)==0)
				return i;
				
		}
		return 0;
		
	}

	private void crearPersonaInsertarLista(String tecleado) {
		String[] campos = tecleado.split("#");
		Persona persona = new Persona(campos[0], campos[1], campos[2].charAt(0), Integer.parseInt(campos[3]));
		personas.add(persona);
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

		personas.add(new Persona("45343671E", "Maria", 'F', 19980929));
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
		System.out.println("\tID \tNIF \t\tNombre \t\t Fecha de Nacimiento \t Sexo");
		int contador = 1;
		for (Persona persona : personas)
			if (persona != null) {
				System.out.println("\t" + (contador++) + "\t" + persona.getNif() + "\t" + persona.getNombre() + "\t\t  "
						+ persona.getFecha() + "\t\t  " + persona.getSexo());

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