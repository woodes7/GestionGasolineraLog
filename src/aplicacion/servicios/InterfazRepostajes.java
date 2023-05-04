package aplicacion.servicios;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import apliacacion.entidades.Gasolinera;
import apliacacion.entidades.Factura;

/**
 * Interfaz que define los métodos que dan servicio a la gestión de repostajes
 * 
 * @author woodes7
 *
 */
public interface InterfazRepostajes {

	/**
	 * Actualiza la lista de repostajes con el nuevo repostaje normal
	 * 
	 * @param listaAntiguaRepostaje lista actual
	 * @return lista actualizada
	 */
	public List<Gasolinera> addRepostajeNormal(List<Gasolinera> listaRepostajes, File archivo);

	/**
	 * Actualiza la lista de repostajes con el nuevo repostaje con factura
	 * 
	 * @param listaAntiguaRepostaje lista actual
	 * @return lista actualizada
	 */

	public List<Gasolinera> addRepostajeFactura(List<Gasolinera> listaRepostajes, File archivo);

	/**
	 * Listar todos los Repostajes
	 * 
	 * @param listaRepostaje
	 */
	public void ListarTodosRepostajes(List<Gasolinera> listaRepostajes, File archivo);

	/**
	 * Modificar un Repostaje de la listaRepostajes
	 * 
	 * @param listRepostajes
	 */
	public List<Gasolinera> ModifiacarRepostaje(List<Gasolinera> listaRepostajes, File archivo);

	/**
	 * Borrar un repostaje de la listaRepostaje
	 * 
	 * @param listaRepostaje
	 */
	public List<Gasolinera> borrarRepostaje(List<Gasolinera> listaRepostajes, File archivo);

	public void AbrirFichero(File archivo, String mensaje);

	public void CerrarFichero(FileWriter fichero);
}