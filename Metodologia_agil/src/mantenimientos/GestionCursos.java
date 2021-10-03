package mantenimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import clases.Cursos;
import clases.DetCursos;
import interfaces.InterfacesCursos;
import util.MySQLConexion;

public class GestionCursos implements InterfacesCursos{

	@Override
	public int RegistrarCurso(Cursos s) {
		// TODO Auto-generated method stub

		int rs=0;
		Connection con=null;		
		CallableStatement cstm=null;
		
		try {
			con =MySQLConexion.getConexion();
			String sql ="{call usp_insert_curso(?,?,?,?)}";
			cstm =con.prepareCall(sql);
			
			cstm.setString(1, s.getDescripcion());				
			cstm.setString(2, s.getCodigoCurso());
			cstm.setInt(3, s.getCredito());
			cstm.setDouble(4, s.getCosto());					
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
	public int RegistrarDetCurso(DetCursos s) {
		// TODO Auto-generated method stub
		int rs=0;
		Connection con=null;		
		CallableStatement cstm=null;
		
		try {
			con =MySQLConexion.getConexion();
			String sql ="{call usp_insert_cursodet(?,?,?)}";
			cstm =con.prepareCall(sql);
			cstm.setDouble(1, s.getPesos());
			cstm.setString(2, s.getDescripcion());							
			cstm.setInt(3, s.getIdCurso());				
			
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
	public ArrayList<Cursos> listado(){
		ArrayList<Cursos>lista = new ArrayList<>();
		
		ResultSet rs = null;		
		Connection con = null;
		PreparedStatement pst = null;
		CallableStatement cstm=null;
		try{
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_listacurso()}");
			rs=cstm.executeQuery();			

			while(rs.next()){
				Cursos p = new Cursos();
				p.setDescripcion(rs.getString(1));
				p.setCodigoCurso(rs.getString(2));
				p.setCredito(rs.getInt(3));
				p.setCosto(rs.getDouble(4));				
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
	public ArrayList<DetCursos> listadocursodet(int idcur){
		ArrayList<DetCursos>lista = new ArrayList<>();		
		ResultSet rs = null;		
		Connection con = null;		
		CallableStatement cstm=null;		
		try {
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_listacursodet(?)}");			
			cstm.setInt(1,idcur);

			rs=cstm.executeQuery();			
			while(rs.next()){
				DetCursos p = new DetCursos();				
				p.setDescripcion(rs.getString(1));
				p.setPesos(rs.getDouble(2));
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
	public int buscarultcoCurso() {
		// TODO Auto-generated method stub
		int data = -1;		
		Connection con = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null;
		
		try {
			con = MySQLConexion.getConexion(); 
			String sql ="{call usp_ultimoCodigoCurso()}";  
			pstm = con.prepareCall(sql);			
			pstm=con.prepareStatement(sql);						
			rs=pstm.executeQuery();
						
			while(rs.next()){
				
				Cursos c = new Cursos();
				c.setIdcurso(rs.getInt("MAX(idtb_cursos)"));
				data=c.getIdcurso();
			}						
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {				 
				if (pstm != null)pstm.close();
				if (con != null)con.close(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	

}
