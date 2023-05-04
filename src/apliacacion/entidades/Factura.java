package apliacacion.entidades;

public class Factura{				

	
	public Factura() {

	}

	public Factura(String dni, String matricula) {
		super();
		this.dni = dni;
		this.matricula = matricula;
	}

	//Atributos
	private String dni = "aaaaaaaaa";
	

	private String matricula = "aaaaaa";

	//Getters & Setters
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Factura [dni=" + dni + ", matricula=" + matricula + "]";
	}
	
}
