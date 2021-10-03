package clases;

public class ProgramacionHorario {
	
	public int idasociacion,usucreacion,activo;
	public String periodo,fechainicio,fechafin,tipohorario,nivel,grado;
	
	
	
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public int getIdasociacion() {
		return idasociacion;
	}
	public void setIdasociacion(int idasociacion) {
		this.idasociacion = idasociacion;
	}
	public int getUsucreacion() {
		return usucreacion;
	}
	public void setUsucreacion(int usucreacion) {
		this.usucreacion = usucreacion;
	}
	public String getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}
	public String getFechafin() {
		return fechafin;
	}
	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}
	public String getTipohorario() {
		return tipohorario;
	}
	public void setTipohorario(String tipohorario) {
		this.tipohorario = tipohorario;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}

}
