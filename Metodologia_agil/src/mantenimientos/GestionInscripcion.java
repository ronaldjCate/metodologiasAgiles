package mantenimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Cursos;
import clases.Inscripcion;
import clases.Notas;
import clases.OfertaCurso;
import clases.ProgramacionHorarioDet;
import clases.Seccion;
import interfaces.InterfacesInscripcion;
import util.MySQLConexion;

public class GestionInscripcion implements InterfacesInscripcion{

	@Override
	public ArrayList<ProgramacionHorarioDet> listadogeneralInscripcionCursos() {
		// TODO Auto-generated method stub
		ArrayList<ProgramacionHorarioDet>lista = new ArrayList<>();
		
		ResultSet rs = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		CallableStatement cstm=null;
		try{
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_listarCursoInscripcion()}");
			rs=cstm.executeQuery();			

			while(rs.next()){
				ProgramacionHorarioDet p = new ProgramacionHorarioDet();
				p.setCodasodet(rs.getInt(1));
				p.setCurso(rs.getString(2));
				p.setSeccion(rs.getString(3));
				p.setDocente(rs.getString(4));				
				lista.add(p);
			}
						
		}catch(Exception e){
			System.out.println("Error en la sentencia " +e.getMessage());
		}finally{
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar");
			}
		}
		
		return lista;
	}

	@Override
	public ArrayList<ProgramacionHorarioDet> buscarhorariomatricula(int codigo) {
		// TODO Auto-generated method stub
		ArrayList<ProgramacionHorarioDet>lista = new ArrayList<>();		
		ResultSet rs = null;		
		Connection con = null;		
		CallableStatement cstm=null;		
		try {
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_InscripcionCostoCurso(?)}");			
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();			
			while(rs.next()){
				ProgramacionHorarioDet p = new ProgramacionHorarioDet();				

				p.setCosto(rs.getDouble(1));				

				lista.add(p);
			}
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia" + e.getMessage());
		}finally {
			try {
				if(cstm!=null) cstm.close();
				if(con!=null) con.close();
			}catch(Exception e2){
				System.out.println("Error al cerrar");
			}
		}
		return lista;
	}
	
	
	public ArrayList<Inscripcion> buscarhorarioInscripcion(int codigo) {
		// TODO Auto-generated method stub
		ArrayList<Inscripcion>lista = new ArrayList<>();		
		ResultSet rs = null;		
		Connection con = null;		
		CallableStatement cstm=null;		
		try {
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_detalleInscripcion(?)}");			
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();			
			while(rs.next()){
				Inscripcion p = new Inscripcion();								
				p.setDescripcioCurso(rs.getString(1));
				p.setCodigoCurso(rs.getString(2));
				p.setCreditoCurso(rs.getInt(3));
				p.setCostoCurso(rs.getDouble(4));
				p.setDescripcioSeccion(rs.getString(5));
				p.setCodigoSeccion(rs.getString(6));
				p.setTipoSeccion(rs.getString(7));
				p.setCantMin(rs.getInt(8));
				p.setCantMax(rs.getInt(9));
				p.setNombrePersona(rs.getString(10));
				p.setApellidoPersona(rs.getString(11));
				lista.add(p);
			}
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia" + e.getMessage());
		}finally {
			try {
				if(cstm!=null) cstm.close();
				if(con!=null) con.close();
			}catch(Exception e2){
				System.out.println("Error al cerrar");
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Inscripcion> listadoPagoInscripcion(String codigo){
		ArrayList<Inscripcion>lista = new ArrayList<>();
		
		ResultSet rs = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		CallableStatement cstm=null;
		try{
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_listaPagoInscrpcion(?)}");
			cstm.setString(1,codigo);
			rs=cstm.executeQuery();			

			while(rs.next()){
				Inscripcion p = new Inscripcion();
				p.setCodigoCurso(rs.getString(1));
				p.setDescripcioSeccion(rs.getString(2));
				p.setNombrePersona(rs.getString(3));
				p.setFormaPago(rs.getString(4));
				p.setRecibo(rs.getString(5));
				p.setMontoPagado(rs.getDouble(6));
				lista.add(p);
			}
						
		}catch(Exception e){
			System.out.println("Error en la sentencia " +e.getMessage());
		}finally{
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar");
			}
		}
		
		return lista;
	}

	@Override
	public int RegistrarPagoInscripcion(Inscripcion s) {
		// TODO Auto-generated method stub

		int rs=0;
		Connection con=null;		
		CallableStatement cstm=null;
		
		try {
			con =MySQLConexion.getConexion();
			String sql ="{call usp_registrarPago(?,?,?,?,?,?,?,?)}";
			cstm =con.prepareCall(sql);
			
			cstm.setString(1, s.getFormaPago());			
			cstm.setDouble(2, s.getMontoPagado());
			cstm.setString(3, s.getDescripcioCurso());
			cstm.setString(4, s.getDescripcioSeccion());
			cstm.setString(5, s.getUsuarioLogueado());
			cstm.setString(6, s.getRecibo());
			cstm.setString(7, s.getNombrePersona());
			cstm.setString(8, s.getPeriodo());
			rs=cstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia "+e.getMessage());
		}finally{
			try {
				if(cstm!=null) cstm.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar");
			}
		}
		
		return rs;
	}

	
	@Override
	public ArrayList<Notas> listadoCursoMatriculado(String usuario){
		// TODO Auto-generated method stub
		ArrayList<Notas>lista = new ArrayList<>();		
		ResultSet rs = null;		
		Connection con = null;		
		CallableStatement cstm=null;		
		try {
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_listarMAtriculaCurso(?)}");			
			cstm.setString(1,usuario);
			rs=cstm.executeQuery();			
			while(rs.next()){
				Notas p = new Notas();								
				p.setCurso(rs.getString(1));				
				p.setSeccion(rs.getString(2));
				p.setPeriodo(rs.getString(3));
				p.setPromedio(rs.getDouble(4));
				p.setEstado(rs.getString(5));

				lista.add(p);
			}
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia" + e.getMessage());
		}finally {
			try {
				if(cstm!=null) cstm.close();
				if(con!=null) con.close();
			}catch(Exception e2){
				System.out.println("Error al cerrar");
			}
		}
		return lista;
	}
	
	@Override
	public ArrayList<Notas> listadoDetalleCursoMatriculado(String cur, String sec, String per, String usu){
		// TODO Auto-generated method stub
		ArrayList<Notas>lista = new ArrayList<>();		
		ResultSet rs = null;		
		Connection con = null;		
		CallableStatement cstm=null;		
		try {
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_listarDetalleNotaMatriculado(?,?,?,?)}");			
			cstm.setString(1,cur);
			cstm.setString(2,sec);
			cstm.setString(3,per);
			cstm.setString(4,usu);
			rs=cstm.executeQuery();			
			while(rs.next()){
				Notas p = new Notas();								
				p.setNt1(rs.getDouble(1));				
				p.setNt2(rs.getDouble(2));	
				p.setNt3(rs.getDouble(3));	
				p.setNt4(rs.getDouble(4));	
				p.setPromedio(rs.getDouble(5));	
				p.setEstado(rs.getString(6));

				lista.add(p);
			}
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia" + e.getMessage());
		}finally {
			try {
				if(cstm!=null) cstm.close();
				if(con!=null) con.close();
			}catch(Exception e2){
				System.out.println("Error al cerrar");
			}
		}
		return lista;
	}
	
	
	@Override
	public ArrayList<OfertaCurso> listadooferta(double nota, String cur){
		// TODO Auto-generated method stub
		ArrayList<OfertaCurso>lista = new ArrayList<>();		
		ResultSet rs = null;		
		Connection con = null;		
		CallableStatement cstm=null;		
		try {
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_ofertaNotaAprobado(?,?)}");			
			cstm.setDouble(1,nota);
			cstm.setString(2,cur);
			rs=cstm.executeQuery();			
			while(rs.next()){
				OfertaCurso p = new OfertaCurso();								
				p.setNota(rs.getDouble(1));				
				p.setDescripcion(rs.getString(2));	
				p.setEmpresa(rs.getString(3));	
				p.setSueldo(rs.getDouble(4));	
				p.setMoneda(rs.getString(5));	
				p.setCurso(rs.getString(6));

				lista.add(p);
			}
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia" + e.getMessage());
		}finally {
			try {
				if(cstm!=null) cstm.close();
				if(con!=null) con.close();
			}catch(Exception e2){
				System.out.println("Error al cerrar");
			}
		}
		return lista;
	}
}
