package mantenimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.CursoRecomendado;
import clases.Cursos;
import clases.Persona;
import clases.ProgramacionHorario;
import clases.ProgramacionHorarioDet;
import clases.Seccion;
import interfaces.InterfacesPrograHorarios;
import util.MySQLConexion;

public class GestionProgHorarios implements InterfacesPrograHorarios{

	@Override
	public int registrar(ProgramacionHorario t) {
		// TODO Auto-generated method stub
		int rs =0;
		Connection con = null;
		PreparedStatement pst=null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_horarios values (null,?,?,?,?,?,'Curso Libre','SI');";
			pst=con.prepareStatement(sql);
			
			pst.setString(1, t.getFechainicio());
			pst.setString(2, t.getFechafin());	
			pst.setString(3, t.getPeriodo());
			pst.setString(4, t.getNivel());
			pst.setString(5, t.getGrado());			
			
			rs=pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia: "+e.getMessage());
		}finally{
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar");
			}
		}		
		return rs;
	}
	
	@Override
	public int buscarultcodhorario() {
		// TODO Auto-generated method stub
		int data = -1;		
		Connection con = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null;
		
		try {
			con = MySQLConexion.getConexion(); 
			String sql ="{call usp_obtenerultimocodigohorario()}";  
			pstm = con.prepareCall(sql);			
			pstm=con.prepareStatement(sql);						
			rs=pstm.executeQuery();
						
			while(rs.next()){
				
				ProgramacionHorario c = new ProgramacionHorario();
				c.setIdasociacion(rs.getInt("idtb_horarios"));
				data=c.getIdasociacion();
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

	@Override
	public ArrayList<Persona> listadoDocenteCombo() {
		// TODO Auto-generated method stub
		ArrayList<Persona>lista=new ArrayList<>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "{call usp_listarDocenteHorario()}";	
		   pst = con.prepareStatement(sql);
		   
		   rs=pst.executeQuery();   
		   while (rs.next()){
			   Persona t = new Persona();
			   t.setNombreDni(rs.getString(1));
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
	public ArrayList<CursoRecomendado> listadoCursoRecomendado() {
		// TODO Auto-generated method stub
		ArrayList<CursoRecomendado>lista=new ArrayList<>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "{call usp_listadoCursoRecomendado()}";	
		   pst = con.prepareStatement(sql);
		   
		   rs=pst.executeQuery();   
		   while (rs.next()){
			   CursoRecomendado t = new CursoRecomendado();
			   t.setCurso(rs.getString(1));
			   t.setMotivo(rs.getString(2));
			   t.setPuntaje(rs.getInt(3));
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
	public ArrayList<Seccion> listadoSeccionCombo() {
		// TODO Auto-generated method stub
		ArrayList<Seccion>lista=new ArrayList<>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "{call usp_listarNombreSeccion()}";	
		   pst = con.prepareStatement(sql);
		   
		   rs=pst.executeQuery();   
		   while (rs.next()){
			   Seccion t = new Seccion();
			   t.setNombreSeccion(rs.getString(1));
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
	public ArrayList<Cursos> listadoCursoCombo() {
		// TODO Auto-generated method stub
		ArrayList<Cursos>lista=new ArrayList<>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "{call usp_listarNombreCursos()}";	
		   pst = con.prepareStatement(sql);
		   
		   rs=pst.executeQuery();   
		   while (rs.next()){
			   Cursos t = new Cursos();
			   t.setNombrecurso(rs.getString(1));
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
	public ArrayList<ProgramacionHorario> listadogeneralannioescolar(String tipo) {
		// TODO Auto-generated method stub
		ArrayList<ProgramacionHorario>lista = new ArrayList<>();		
		ResultSet rs = null;		
		Connection con = null;		
		CallableStatement cstm=null;
		
		try {
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_listaprogramacionhorario(?)}");			
			cstm.setString(1,tipo);
			rs=cstm.executeQuery();						
			
			while(rs.next()){
				ProgramacionHorario p = new ProgramacionHorario();
				
				p.setIdasociacion(rs.getInt(1));
				p.setTipohorario(rs.getString(2));
				p.setNivel(rs.getString(3));
				p.setGrado(rs.getString(4));
				p.setPeriodo(rs.getString(5));
				p.setFechainicio(rs.getString(6));
				p.setFechafin(rs.getString(7));
				
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
	public int registrardetalle(ProgramacionHorarioDet t) {
		// TODO Auto-generated method stub
		int rs =0;
		Connection con = null;
		PreparedStatement pst=null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_horarioDet values (null,?,'SI',?,?,?,?,?,?,?);";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1, t.getCodasocurdos());
			pst.setString(2, t.getSeccion());
			pst.setString(3,t.getCurso());
			pst.setString(4, t.getDocente());
			pst.setString(5, t.getHoraini());
			pst.setString(6,t.getHorafin());			
			pst.setString(7, t.getDiainicio());
			pst.setString(8, t.getTutnomatricula());			

			rs=pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia: "+e.getMessage());
		}finally{
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar");
			}
		}		
		return rs;
	}
		
	@Override
	public ArrayList<ProgramacionHorarioDet> listadogeneralannioescolardetalle(int idasoci) {
		// TODO Auto-generated method stub
		ArrayList<ProgramacionHorarioDet>lista = new ArrayList<>();		
		ResultSet rs = null;		
		Connection con = null;		
		CallableStatement cstm=null;		
		try {
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_listarProgramacionDet(?)}");			
			cstm.setInt(1,idasoci);
			//cstm.setString(2,niv);
			//cstm.setString(3,grad);
			rs=cstm.executeQuery();			
			while(rs.next()){
				ProgramacionHorarioDet p = new ProgramacionHorarioDet();								
				p.setDiainicio(rs.getString(1));
				p.setHoraini(rs.getString(2));
				p.setHorafin(rs.getString(3));
				p.setSeccion(rs.getString(4));
				p.setCurso(rs.getString(5));
				p.setDocente(rs.getString(6));				
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
