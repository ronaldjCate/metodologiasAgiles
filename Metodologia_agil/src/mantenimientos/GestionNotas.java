package mantenimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Inscripcion;
import clases.Notas;
import interfaces.InterfacesNotas;
import util.MySQLConexion;

public class GestionNotas implements InterfacesNotas{

	@Override
	public ArrayList<Notas> listadocursoInscritos(String usuario) {
		// TODO Auto-generated method stub
		ArrayList<Notas>lista = new ArrayList<>();		
		ResultSet rs = null;		
		Connection con = null;		
		CallableStatement cstm=null;		
		try {
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_listarHorariosProfe(?)}");			
			cstm.setString(1,usuario);
			rs=cstm.executeQuery();			
			while(rs.next()){
				Notas p = new Notas();				

				p.setCodCurso(rs.getString(1));
				p.setCurso(rs.getString(2));
				p.setCodSeccion(rs.getString(3));
				p.setSeccion(rs.getString(4));
				p.setAula(rs.getString(5));
				p.setCodDocente(rs.getString(6));
				p.setDocente(rs.getString(7));

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
	public int RegistrarNota(Notas s) {
		// TODO Auto-generated method stub

		int rs=0;
		Connection con=null;		
		CallableStatement cstm=null;
		
		try {
			con =MySQLConexion.getConexion();
			String sql ="{call usp_registrarNota(?,?,?,?,?,?,?,?,?,?)}";
			cstm =con.prepareCall(sql);
			
			cstm.setString(1, s.getCurso());			
			cstm.setString(2, s.getSeccion());
			cstm.setString(3, s.getUsuAlumno());
			cstm.setString(4, s.getPeriodo());
			cstm.setDouble(5, s.getNt1());
			cstm.setDouble(6, s.getNt2());
			cstm.setDouble(7, s.getNt3());
			cstm.setDouble(8, s.getNt4());
			cstm.setDouble(9, s.getPromedio());
			cstm.setString(10, s.getEstado());
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
	public ArrayList<Notas> listadoalumnos(String curso,String periodo,String seccion) {
		// TODO Auto-generated method stub
		
		ArrayList<Notas>lista=new ArrayList<>();
		
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "{call usp_listarnotasregistradas(?,?,?)}";	
		   pst = con.prepareStatement(sql);
		   pst.setString(1, curso);
		   pst.setString(2, seccion);
		   pst.setString(3, periodo);		   
		   rs=pst.executeQuery();   
		   while (rs.next()){
			   Notas t = new Notas();
			   t.setCurso(rs.getString(1));			   
			   t.setUsuAlumno(rs.getString(2));
			   t.setAlumno(rs.getString(3));
			   t.setPromedio(rs.getDouble(4));
			   lista.add(t);
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
		  try {
		      if (pst != null) pst.close();
		      if (con != null) con.close();
		   } catch (SQLException e) {
		      System.out.println("Error al cerrar ");
		   }
		}
		
		return lista;
	}
	
	@Override
	public int actualizar(Notas c) {
		// TODO Auto-generated method stub
		int rs=0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="{call usp_actualizarNotas(?,?,?,?,?,?,?,?,?,?)}"; 
				pst = con.prepareStatement(sql);			
					pst.setString(1, c.getUsuAlumno());
					pst.setString(2,c.getCurso());
					pst.setString(3,c.getSeccion());
					pst.setString(4,c.getPeriodo());			
					pst.setDouble(5, c.getNt1());
					pst.setDouble(6, c.getNt2());
					pst.setDouble(7, c.getNt3());
					pst.setDouble(8, c.getNt4());
					pst.setDouble(9, c.getPromedio());
					pst.setString(10, c.getEstado());
				rs=pst.executeUpdate();
			
		} catch(Exception e){
			System.out.println("Error en la sentencia " +e.getMessage());
		}finally{
			try{
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}catch(SQLException e){
				System.out.println("Error al cerrar");
			}
		}	
		return rs;
	}
	
	@Override
	public ArrayList<Notas> buscardetallecurso(String usu,String curso, String sec, String periodo) {
		// TODO Auto-generated method stub
		ArrayList<Notas>lista = new ArrayList<>();		
		ResultSet rs = null;		
		Connection con = null;		
		CallableStatement cstm=null;		
		try {
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_listarnotasalumno(?,?,?,?)}");
			cstm.setString(1,usu);
			cstm.setString(2,curso);
			cstm.setString(3,sec);
			cstm.setString(4,periodo);
			rs=cstm.executeQuery();			
			while(rs.next()){
				Notas p = new Notas();				
					p.setNt1(rs.getDouble(1));
					p.setNt2(rs.getDouble(2));
					p.setNt3(rs.getDouble(3));
					p.setNt4(rs.getDouble(4));
					p.setPromedio(rs.getDouble(5));
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
	public ArrayList<Notas> listadocursoNota(String usuario, String periodo) {
		// TODO Auto-generated method stub
		ArrayList<Notas>lista = new ArrayList<>();		
		ResultSet rs = null;		
		Connection con = null;		
		CallableStatement cstm=null;		
		try {
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_listarMatriculaNota(?,?)}");			
			cstm.setString(1,usuario);
			cstm.setString(2,periodo);
			rs=cstm.executeQuery();			
			while(rs.next()){
				Notas p = new Notas();				

				p.setCodCurso(rs.getString(1));
				p.setCurso(rs.getString(2));
				p.setCodSeccion(rs.getString(3));				

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
	public ArrayList<Notas> listadocombo() {
		// TODO Auto-generated method stub
		ArrayList<Notas>lista=new ArrayList<>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "select distinct(periodo) from tb_pagoinscripcion order by periodo desc;"; // sentencia sql
	
		   pst = con.prepareStatement(sql);		   
		   rs = pst.executeQuery();
		   
		   while (rs.next()){
			   Notas t = new Notas();
			   t.setPeriodo(rs.getString(1));
			   lista.add(t);
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
		  try {
		      if (pst != null) pst.close();
		      if (con != null) con.close();
		   } catch (SQLException e) {
		      System.out.println("Error al cerrar ");
		   }
		}
		return lista;
	}

}
