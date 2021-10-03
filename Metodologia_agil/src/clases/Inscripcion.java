package clases;

public class Inscripcion {
	
	public int codigoDetalleHorario,cantMax,cantMin,creditoCurso;
	public String periodo,descripcioCurso, codigoCurso,descripcioSeccion,codigoSeccion,tipoSeccion,nombrePersona,apellidoPersona,correoPersona,formaPago,recibo,usuarioLogueado;
	public double costoCurso,montoPagado;
	
	
	
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getUsuarioLogueado() {
		return usuarioLogueado;
	}
	public void setUsuarioLogueado(String usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public String getRecibo() {
		return recibo;
	}
	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}
	public Double getMontoPagado() {
		return montoPagado;
	}
	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}
	public String getDescripcioSeccion() {
		return descripcioSeccion;
	}
	public void setDescripcioSeccion(String descripcioSeccion) {
		this.descripcioSeccion = descripcioSeccion;
	}
	public int getCodigoDetalleHorario() {
		return codigoDetalleHorario;
	}
	public void setCodigoDetalleHorario(int codigoDetalleHorario) {
		this.codigoDetalleHorario = codigoDetalleHorario;
	}
	public int getCantMax() {
		return cantMax;
	}
	public void setCantMax(int cantMax) {
		this.cantMax = cantMax;
	}
	public int getCantMin() {
		return cantMin;
	}
	public void setCantMin(int cantMin) {
		this.cantMin = cantMin;
	}
	public String getDescripcioCurso() {
		return descripcioCurso;
	}
	public void setDescripcioCurso(String descripcioCurso) {
		this.descripcioCurso = descripcioCurso;
	}
	public String getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public int getCreditoCurso() {
		return creditoCurso;
	}
	public void setCreditoCurso(int creditoCurso) {
		this.creditoCurso = creditoCurso;
	}
	public String getCodigoSeccion() {
		return codigoSeccion;
	}
	public void setCodigoSeccion(String codigoSeccion) {
		this.codigoSeccion = codigoSeccion;
	}
	public String getTipoSeccion() {
		return tipoSeccion;
	}
	public void setTipoSeccion(String tipoSeccion) {
		this.tipoSeccion = tipoSeccion;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public String getApellidoPersona() {
		return apellidoPersona;
	}
	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}
	public String getCorreoPersona() {
		return correoPersona;
	}
	public void setCorreoPersona(String correoPersona) {
		this.correoPersona = correoPersona;
	}
	public double getCostoCurso() {
		return costoCurso;
	}
	public void setCostoCurso(double costoCurso) {
		this.costoCurso = costoCurso;
	}

	
	
}
