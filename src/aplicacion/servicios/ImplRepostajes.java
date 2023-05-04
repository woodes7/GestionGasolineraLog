package aplicacion.servicios;

import java.util.Scanner;

import Util.Mensajes;
import apliacacion.entidades.Gasolinera;
import apliacacion.entidades.Factura;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Implementación de la InterfazRepostaje
 * 
 * @author woodes7
 *
 */
public class ImplRepostajes implements InterfazRepostajes {

	private Mensajes mensajes;

	public ImplRepostajes(Mensajes mensajes) {
		this.mensajes = mensajes;
	}

	@Override
	public List<Gasolinera> addRepostajeNormal(List<Gasolinera> listaRepostajes, File archivo) {

		try {
			// TODO Auto-generated method stub
			Scanner valores = new Scanner(System.in);

			int id = calculoNuevoId(listaRepostajes);

			System.out.println("Introduce los litros que quieras repostar: ");
			double litros = valores.nextDouble();
			System.out.println("Introduzca el importe total: ");
			double importe = valores.nextDouble();

			String fecha = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm:ss a").format(LocalDateTime.now());
			Gasolinera gasolinera = new Gasolinera(id, fecha, litros, importe);
			listaRepostajes.add(gasolinera);

			AbrirFichero(archivo, mensajes.getAgregarRepos());
			return listaRepostajes;
		} catch (InputMismatchException e) {

			AbrirFichero(archivo, mensajes.getFormatoERR());
			return listaRepostajes;
		} catch (Exception e) {
			System.out.println("Se produjo un error" + e.getMessage());
			return listaRepostajes;
		}
	}

	/**
	 * Calcular el id del nuevo repostaje
	 * 
	 * @param listaRepostajes lista actual de repostajes
	 * @return id de un nuevo repostaje
	 */
	private int calculoNuevoId(List<Gasolinera> listRepostajes) {
		int auxiliar = 0;

		for (int i = 0; i < listRepostajes.size(); i++) {

			int j = listRepostajes.get(i).getId();
			if (auxiliar < j) {
				auxiliar = j;
			}

		}
		return auxiliar + 1;
	}

	@Override
	public List<Gasolinera> addRepostajeFactura(List<Gasolinera> listaRepostajes, File archivo) {
		// TODO Auto-generated method stub

		try {

			Scanner valores = new Scanner(System.in);

			int id = calculoNuevoId(listaRepostajes);

			System.out.println("Introduce los litros que quieras repostar: ");
			double litros = valores.nextDouble();
			System.out.println("Introduzca el importe total: ");
			double importe = valores.nextDouble();

			String fecha = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm:ss a").format(LocalDateTime.now());

			System.out.println("Introduzca Dni: ");
			String dni = valores.next();
			System.out.println("Introduzca Matricula: ");
			String matricula = valores.next();
			Factura factura = new Factura(dni, matricula);
			Gasolinera gasolinera = new Gasolinera(id, fecha, litros, importe, factura);
			listaRepostajes.add(gasolinera);

			AbrirFichero(archivo, mensajes.getAgregarRepos());
			return listaRepostajes;

		} catch (InputMismatchException e) {

			AbrirFichero(archivo, mensajes.getFormatoERR());
			return listaRepostajes;
		} catch (Exception e) {
			System.out.println("Se produjo un error" + e.getMessage());
			return listaRepostajes;
		}

	}

	@Override
	public void ListarTodosRepostajes(List<Gasolinera> listaRepostajes, File archivo) {

		try {

			for (int i = 0; i < listaRepostajes.size(); i++) {
				System.out.println(listaRepostajes.get(i).toString());
				if (listaRepostajes.get(i).getFactura() != null)
					System.out.println(listaRepostajes.get(i).getFactura().toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

	@Override
	public List<Gasolinera> ModifiacarRepostaje(List<Gasolinera> listaRepostajes, File archivo) {
		// TODO Auto-generated method stub

		try {
			Gasolinera repostajes = new Gasolinera();
			Factura factura = null;
			Scanner valores = new Scanner(System.in);
			int entId = valores.nextInt();
			for (int i = 0; i < listaRepostajes.size(); i++) {
				if (entId == listaRepostajes.get(i).getId()) {

					System.out.println("Introduce los litros que quieras repostar: ");
					double litros = valores.nextDouble();
					System.out.println("Introduzca el importe total: ");
					double importe = valores.nextDouble();
					String fecha = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm:ss a").format(LocalDateTime.now());
					if (listaRepostajes.get(i).getFactura() != null) {
						System.out.println("Introduzca Dni: ");
						String dni = valores.next();
						System.out.println("Introduzca Matricula: ");
						String matricula = valores.next();
						factura = new Factura(dni, matricula);
						repostajes = new Gasolinera(entId, fecha, litros, importe, factura);
					} else
						repostajes = new Gasolinera(entId, fecha, litros, importe);

					listaRepostajes.set(i, repostajes);
				}
			}
			AbrirFichero(archivo, mensajes.getModidificarRepostaje());
			return listaRepostajes;
		} catch (InputMismatchException e) {

			AbrirFichero(archivo, mensajes.getFormatoERR());
			return listaRepostajes;
		} catch (Exception e) {
			System.out.println("Se produjo un error" + e.getMessage());
			return listaRepostajes;
		}
	}

	@Override
	public List<Gasolinera> borrarRepostaje(List<Gasolinera> listaRepostajes, File archivo) {
		// TODO Auto-generated method stub
		try {
			Scanner valores = new Scanner(System.in);
			int entId = valores.nextInt();
			for (int i = 0; i < listaRepostajes.size(); i++) {
				if (entId == listaRepostajes.get(i).getId()) {
					listaRepostajes.remove(listaRepostajes.get(i));
				}
			}
			AbrirFichero(archivo, mensajes.getEliminarRepostaje());
			return listaRepostajes;
		} catch (InputMismatchException e) {

			AbrirFichero(archivo, mensajes.getFormatoERR());
			return listaRepostajes;
		} catch (Exception e) {
			System.out.println("Se produjo un error" + e.getMessage());
			return listaRepostajes;
		}
	}

	public void EscribirFichero(FileWriter fichero, String mensaje) {

		LocalDateTime fechaHoraActual = LocalDateTime.now();
		try {

			PrintWriter pw = new PrintWriter(fichero, true);
			pw.println("[" + fechaHoraActual + "] " + mensaje);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CerrarFichero(fichero);
		}

	}

	@Override
	public void AbrirFichero(File archivo, String mensaje) {

		// Creamos el fr para luego en el try controlar si se abre bien o no
		FileWriter fichero = null;

		try {
			fichero = new FileWriter(archivo, true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		EscribirFichero(fichero, mensaje);
	}

	@Override
	public void CerrarFichero(FileWriter fichero) {

		try {
			// Nuevamente aprovechamos el finally para
			// asegurarnos que se cierra el fichero.
			if (null != fichero)
				fichero.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
