package aplicacion.controladores;

import aplicacion.servicios.ImplMenu;
import aplicacion.servicios.ImplRepostajes;
import aplicacion.servicios.InterfazMenu;
import aplicacion.servicios.InterfazRepostajes;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Util.Mensajes;
import apliacacion.entidades.Gasolinera;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mensajes mensajes = new Mensajes();
		InterfazRepostajes intR = new ImplRepostajes(mensajes);
		InterfazMenu intM = new ImplMenu();

		List<Gasolinera> listRepostajes = new ArrayList<>();

		Boolean cerrarMenu = false;
		File archivo = new File("C:\\Users\\pablo\\OneDrive\\Escritorio\\Logs.txt");

		Scanner entradaOpcion = new Scanner(System.in);
		try {
			int opcion;
			while (!cerrarMenu) {
				// Mostramos el menú
				intM.mostrarMenu();
				System.out.println("Introduza la opción deseada: ");
				opcion = entradaOpcion.nextInt();
				System.out.println("[INFO] - Has seleccionado la opcion " + opcion);

				switch (opcion) {
				case 0:
					cerrarMenu = true;
					break;
				case 1:
					listRepostajes = intR.addRepostajeNormal(listRepostajes, archivo);
					break;
				case 2:
					listRepostajes = intR.addRepostajeFactura(listRepostajes, archivo);
					break;
				case 3:
					intR.ListarTodosRepostajes(listRepostajes, archivo);

					break;
				case 4:
					listRepostajes = intR.ModifiacarRepostaje(listRepostajes, archivo);

					break;
				case 5:
					listRepostajes = intR.borrarRepostaje(listRepostajes, archivo);

					break;
				default:
				}
			}
		} catch (InputMismatchException e) {

			intR.AbrirFichero(archivo, mensajes.getFormatoERR());
		} catch (Exception e) {
			System.out.println("Se produjo un error" + e.getMessage());
		}
	}

}
