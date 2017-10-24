
import java.io.Serializable;

public class Coche2 implements Serializable{//SIempre hay que poner Serializable cuando un objeto se pone en un fichero.

	private String mat;
	private int precio;
	public Coche2(String mat, int precio) {
		super();
		this.mat = mat;
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Coche [mat=" + mat + "]";
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
		
		
		
	}
	

