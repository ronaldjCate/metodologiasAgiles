package gui;

import java.awt.EventQueue;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

import javax.swing.JInternalFrame;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

public class Report_certificado extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final File mensaje_uno = null;
	private static final Map<String, Object> values = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report_certificado frame = new Report_certificado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Report_certificado() {
		super("CERTIFICADO",true,true,true);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		
		Connection con = null;
		try{
			/*
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/upc_sistema_control?useSSL=false","root","mysql"); 
			JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile
					("F:\\Profesion\\upc\\metodología ágil\\reporte_v2\\reportprinter\\src\\main\\resources\\report\\Flower_Landscape.jasper");
			JasperPrint jp = JasperFillManager.fillReport(jr, null,con);
			getContentPane().add(new JRViewer(jp));
			*/
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/upc_sistema_control"; 
			// 192.168.1.35
			String usr = "root"; 
			String psw = "mysql"; 
			con = DriverManager.getConnection(url,usr,psw); 
			JRDataSource vacio = new JREmptyDataSource(1);
			
			String path="F:\\Profesion\\upc\\metodologiaagil\\reporte\\reportprinter\\src\\main\\resources\\report\\Flower_Landscape.jasper";
			
			JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(path);
			
			//JasperReport reporte = (JasperReport) JRLoader.loadObject(mensaje_uno);
			//JasperPrint print = JasperFillManager.fillReport(jr, values, vacio );
			
			//JasperFillManager.fillReport(jr, values, vacio);

			JasperPrint jp = JasperFillManager.fillReport(jr, values,vacio);
			/*
			JasperViewer view = new JasperViewer(jp,false);
			view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			view.setVisible(true);
			*/
			getContentPane().add(new JRViewer(jp));
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(0);
		}

	}

}
