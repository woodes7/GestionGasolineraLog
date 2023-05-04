package apliacacion.entidades;

public class Gasolinera {

	public Gasolinera(int id, String fecha, double litros, double importe) {
		super();
		this.id = id;
		this.litros = litros;
		this.importe = importe;
		this.fechaRepostaje = fecha;
	}

	public Gasolinera() {
		super();
	}

	public Gasolinera(int id, String fecha, double litros, double importe, Factura factura) {
		super();
		this.id = id;
		this.litros = litros;
		this.importe = importe;
		this.fechaRepostaje = fecha;
		this.factura = factura;
	}

	// Atributos
	private int id = 0;

	private double litros = 0;

	private double importe = 0;

	private String fechaRepostaje = "aaaaaaaaaaaa";

	private Factura factura;

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getFechaRepostaje() {
		return fechaRepostaje;
	}

	public void setFechaRepostaje(String fechaRepostaje) {
		this.fechaRepostaje = fechaRepostaje;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "Gasolinera [id=" + id + ", litros=" + litros + ", importe=" + importe + ", fechaRepostaje="
				+ fechaRepostaje + "]";
	}

}
