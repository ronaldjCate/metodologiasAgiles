package clases;

public class Cursos {
	
	int idcurso,credito;
	String descripcion, codigoCurso;
	double costo;
	String nombrecurso;
	
	
	public String getNombrecurso() {
		return nombrecurso;
	}
	public void setNombrecurso(String nombrecurso) {
		this.nombrecurso = nombrecurso;
	}
	public int getIdcurso() {
		return idcurso;
	}
	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public int getCredito() {
		return credito;
	}
	public void setCredito(int credito) {
		this.credito = credito;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public boolean validarCosto(double valor){
		if(valor<0){
			return true;
		}
		return false;
	}
	
	

}
