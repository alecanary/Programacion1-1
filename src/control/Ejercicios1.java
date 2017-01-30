package control;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import modelo.Estudiante;
import modelo.Intento;
import modelo.Persona;

public class Ejercicios1 {
	private Scanner teclado= new Scanner(System.in);

	public static void main(String[] args) {
		// Ejercicios2 ej2 = new Ejercicios2();
		// ej2.insertarEnPersonas();
		// ej2.recorrerListaPersonas2();
		// ej2.recorrerMatrizPersonas();
		// ej2.convertirArrayEnArrayList();
		// ej2.pruebaMapaPersonas();
		// ej2.recorrerMapa();
		Ejercicios1 ej1 = new Ejercicios1();
		ej1.menu("\t  MANTENIMIENTO DE PERSONAS");
		System.out.println("FIN DEL MANTENIMIENTO.");
	}

	public void menu(String titulo) {
		 Ejercicios2 ej2 = new Ejercicios2();
		 ej2.insertarEnPersonas();
		for (;;) {
			System.out.println(titulo);
			System.out.println("\t\t1. Listar todas las personas");
			System.out.println("\t\t2. Crear una persona");
			System.out.println("\t\t3. Modificar datos de una persona");
			System.out.println("\t\t4. Borrar una personas");
			System.out.println("\t\t0. Salir del programa");
			
			String tecleado = teclado.nextLine();
			try {
				int opcion = Integer.parseInt(tecleado);
				switch (opcion) {
				case 1:
					ej2.recorrerListaPersonas2();
					break;
				case 2:
					ej2.crearPersona();
					break;
				case 3:
					modificarPersona();
					break;
				case 4:
					borrarPersona();
					break;
				case 0:
					return;

				default:
					break;
				}
			} catch (NumberFormatException e) {

			}
			// salida del break
		}

	}
	
	
	
	public void modificarPersona(){
		System.out.println("\t modificarPersona");
	}
	public void borrarPersona(){
		System.out.println("\t borrarPersona");
	}

	public String[] ordenaListaCaracteres(String[] palabra) {
		for (int i = 0; i < palabra.length - 1; i++) {
			for (int j = i + 1; j < palabra.length; j++) {
				if (palabra[i].compareTo(palabra[j]) > 0) // hay que permutar
				{
					String aux = palabra[i];
					palabra[i] = palabra[j];
					palabra[j] = aux;
				}
			}
		}

		return palabra;

	}

	public int calculaSaldoFinal(int[] movimientoCuenta, int saldoInicial) {
		int saldoFinal = saldoInicial;
		for (int i = 0; i < movimientoCuenta.length; i++) {
			saldoFinal += movimientoCuenta[i];
		}

		return saldoFinal;

	}

	public int[] sumaFilaMatrizEnteros(int[][] matriz) {
		int[] resultado = new int[matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				resultado[i] += matriz[i][j];
			}
		}
		return resultado;
	}

	public int[] sumaColumnasMatrizEnteros(int[][] matriz) {
		int longitud = 0;

		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i].length > longitud)
				longitud = matriz[i].length;

		}
		int[] resultado = new int[longitud];
		for (int j = 0; j < longitud; j++) {
			for (int i = 0; i < matriz.length; i++) {
				// try {
				if (j < matriz[i].length)
					resultado[j] += matriz[i][j];
				// } catch (ArrayIndexOutOfBoundsException e) {
				// System.out.println(i + ", " + j);

				// }
			}
		}

		return resultado;

	}

	public int sumaMatrizEnteros(int[][] matriz) {
		int suma = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				suma += matriz[i][j];
			}
		}
		return suma;
	}

	public int[] mezclaArraysEnteros(int[] a1, int[] a2) {
		int[] a3 = new int[a1.length + a2.length];
		int i = 0, j = 0, k = 0;
		while (k < a3.length) {

			try {
				if (a1[i] < a2[j]) {
					a3[k] = a1[i];
					i++;
				} else {
					a3[k] = a2[j];
					j++;
				}
				k++;
			} catch (ArrayIndexOutOfBoundsException exepcion) {
				if (i >= a1.length) {
					a1[a1.length - 1] = Integer.MAX_VALUE;
					i--;
				} else if (j >= a2.length) {
					a2[a2.length - 1] = Integer.MAX_VALUE;
					j--;
				}

			}
		}

		return a3;

	}

	public boolean busquedaBinaria(int buscame, int[] enDonde) {
		int min = 0;
		int max = enDonde.length - 1;
		int med;

		while (min <= max) {
			med = min + (max - min) / 2;
			if (enDonde[med] == buscame)
				return true;
			else if (enDonde[med] > buscame)
				max = med - 1;
			else
				min = med + 1;
		}
		return false;

	}

	public void ordenaListaNumerosEnteros(int[] lista) {
		for (int i = 0; i < lista.length - 1; i++) {
			for (int j = i + 1; j < lista.length; j++) {
				if (lista[i] > (lista[j])) // hay que permutar
				{
					int aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
				}
			}
		}

		// return lista;

	}

	// public String[] ordenaListaCadenas(String[] lista) {
	public void ordenaListaCadenas(String[] lista) {
		for (int i = 0; i < lista.length - 1; i++) {
			for (int j = i + 1; j < lista.length; j++) {
				if (lista[i].compareTo(lista[j]) > 0) // hay que permutar
				{
					String aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
				}
			}
		}

		// return lista;

	}

	public int generaAleatorioEntre(int min, int max) {
		/*
		 * int numero = min; int diferencia = max -min; Random rnd = new
		 * Random(); numero += rnd.nextInt(diferencia);
		 */
		return min + new Random().nextInt(max - min);
	}

	public void adivinaNumero() {

		int[] limites = generarIntervalo(); // se piden dos numeros y se genera
		int numeroAdivinar = generaAleatorioEntre(limites[0], limites[1]); // numero
																			// //
																			// adivinar
		jugarAdivinaNumero(numeroAdivinar);
	}

	private void jugarAdivinaNumero(int numeroAdivinar) {
		int contadorIntentos = 0;
		Intento[] intentos = new Intento[200];
		boolean jugando = true;
		do { // bucle del juego

			// validamos el n�mero jugado
			boolean error1 = true;
			int numeroJugado = 0;
			while (error1) {
				try {
					System.out.println("Teclee n�mero entero (Q|q para terminar)");
					Scanner teclado = new Scanner(System.in);
					String numeroTecleado = teclado.nextLine();

					if (numeroTecleado.compareToIgnoreCase("Q") == 0) {
						System.out.println("Fin de la partida . Hasta la pr�xima!");
						System.exit(0);
					}

					numeroJugado = Integer.parseInt(numeroTecleado);
					error1 = false;
				} catch (NumberFormatException e) {
					System.out.println("N�mero incorrecto!");
				}
			}

			// creamos el intento
			Intento intento = new Intento(numeroJugado, new Date());
			// guardamos el intento..
			intentos[contadorIntentos++] = intento;

			// mostrar los intentos hasta ahora ....
			for (int i = 0; i < intentos.length; i++) {

				try {
					System.out.printf("%d. \t%d\t%s\n", i + 1, intentos[i].getNumero(), intentos[i].getFechaHora());
				} catch (NullPointerException e) {
					break;
				}
			}

			// tenemos un n�mero tecleado v�lido
			if (numeroJugado < numeroAdivinar)
				System.out.println("Pruebe un n�mero MAYOR... ");
			else if (numeroJugado > numeroAdivinar)
				System.out.println("Pruebe un n�mero MENOR... ");
			else {
				System.out.println("ENHORABUENA, HA ACERTADO!!... ");
				jugando = false;
			}

		} while (jugando);

	}

	private int[] generarIntervalo() {
		System.out.println("Generacion del numero en un intervalo");
		// bucle validacion
		int min = 0;
		int max = 0;
		boolean error1 = true;
		while (error1) {
			System.out.println("Teclee intervalo (min@max)");
			Scanner teclado = new Scanner(System.in);
			String intervalo = teclado.nextLine();
			String[] limites = intervalo.split("@");
			// validamos que hay dos numeros
			if (limites.length != 2) {
				System.out.println("Teclee dos valores !");
				error1 = true;
				continue;
			}
			try {
				min = Integer.parseInt(limites[0]);
				max = Integer.parseInt(limites[1]);
				if (min >= max) {
					System.out.println("Min < Max !!");
					error1 = true;
					continue;
				}
				// validaci�n superada
				error1 = false;
			} catch (NumberFormatException e) {
				System.out.println("Error de formato !");
				error1 = true;
				continue;
			}
		}
		// System.out.println("validaci�n superada");
		int[] intervalo = new int[2];
		intervalo[0] = min;
		intervalo[1] = max;
		return intervalo;
	}

	public void crearHebras(int cuantas) {
		for (int i = 0; i < cuantas; i++) {
			Thread hebra = new Hebra();
			hebra.setName("Hebra" + i);
			hebra.start();
		}
		System.out.println("creadas las hebras");

	}

	public void convierteAEnteros() {
		// definimos un array de cadenas
		// String[] numeros = new String[15];
		String[] numeros = { "12t3", "650", "78m6", "1", "0987" };
	}

	public void creaListaPersonas() {
		// crea 3 personas
		Persona p1 = new Persona("45627812K", "Carlos", 'M', 19830323);
		Persona p2 = new Persona();
		p2.setNif("44321987H");
		p2.setNombre("Maria");
		p2.setSexo('F');

		Persona p3 = new Persona("41298730L", "Felipe", 'M', 19761203);

		// define el array para 20 personas
		Persona[] listaPersonas = new Persona[20];

		// asigna las personas al array

		listaPersonas[0] = p1;
		listaPersonas[10] = p2;
		listaPersonas[3] = p3;

		// muestra el nombre de las 3 personas
		for (int i = 0; i < listaPersonas.length; i++) {
			try {
				System.out.println(listaPersonas[i].getNombre());
			} catch (NullPointerException exepcion) {
				System.out.println("elemento " + i + " est� null");
			} catch (Exception exepcion) {
				System.out.println("General excepcion");
			}
		}

	}

	public void listarPrimos(int cuantos) {
		// int contador = 0;
		int candidato = 1;
		// while (contador < cuantos) {
		for (int contador = 0; contador < cuantos; contador++) {
			if (esPrimo(candidato))
				System.out.println(candidato);
			candidato++;

		}

	}

	public boolean esPrimo(int numero) {
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				// System.out.println(numero + " NO es primo !!" + i);

				return false;
			}

		}
		// System.out.println(numero + " es primo !!");
		return true;

	}

	public void fibonacci(int n) {
		float a, b, c;
		a = 0;
		b = 1;

		/*
		 * for (int i = 0; i < n; i++) { c=a+b; System.out.print(c + ", "); a=b;
		 * }
		 */
		int i = 0;
		while (i < n) {
			c = a + b;
			System.out.print(c + ", " + "\n");
			a = b;
			b = c;
			i++;
		}

	}

	public int sumaIntervalo(int menor, int mayor) {
		int acum = 0;
		for (int i = menor; i <= mayor; i++)
			acum += i;
		return acum;
	}

	public void mostrarLanzadas(int[] datos, int cuantasLanzadas) {
		for (int i = 0; i < datos.length; i++)
			/*
			 * System.out.println("El n�mero " + (i + 1) + " ha salido " +
			 * datos[i] + " veces(" + ((datos[i]*100)/cuantasLanzadas) + " %)");
			 */
			System.out.printf("El numero %d aparece %d veces (%.2f)\n", (i + 1), datos[i],
					(float) (datos[i] * 100) / cuantasLanzadas);
	}

	public int[] lanzadas(int numLanzadas) {
		int[] resultado = new int[6];
		int numero;
		for (int i = 0; i < numLanzadas; i++) {
			numero = lanzarDado();
			resultado[numero - 1]++;
		}
		return resultado;
	}

	public int lanzarDado() {

		int valor = (int) (1 + Math.random() * 6);
		// System.out.println(valor);
		return valor;

	}

	public void listaNPrimerosEnteros(int n) {
		for (int i = 0; i < n; i++)
			System.out.println(i + 1);

	}

	public void bucleReloj() {
		int h = 0, m = 0, s = 0;
		while (h < 24) // bucle de horas
		{
			m = 0;
			while (m < 60) {
				s = 0;
				while (s < 60) {
					System.out.println(h + " : " + m + " : " + s);
					s++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				m++; // m= m + 1;
			}
			h++;
		}

	}

}
