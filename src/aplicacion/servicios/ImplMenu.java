package aplicacion.servicios;
/**
 * Implementación de la InterfazMenu
 * @author woodes7
 *
 */
public class ImplMenu implements InterfazMenu {

	@Override
	public void mostrarMenu() {
		// TODO Auto-generated method stub
		System.out.println("\t-----Menu-----");
		System.out.println("1. Añadir Repostaje normal");
		System.out.println("2. Añadir Repostaje con Factura");
		System.out.println("3. Lista de repostaje");		
		System.out.println("4. Modificar Repostaje");
		System.out.println("5. Borrar Repostaje");
		System.out.println("0. Salir");
		
	}

	
}
