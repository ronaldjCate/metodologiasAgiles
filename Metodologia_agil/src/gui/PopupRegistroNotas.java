package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import calculos.AcademiaBiblica;

import clases.Notas;
import mantenimientos.GestionNotas;

public class PopupRegistroNotas extends JInternalFrame{
	
	private JPanel contentPane;
	private JPanel panelregnotas;
	
	private JTextField txtnota1;
	private JTextField txtnota2;
	private JTextField txtnota3;
	private JTextField txtnota4;
	private JTextField txtpromedio;
	private JLabel lblNota1;
	private JLabel lblNota2;
	private JLabel lblNota3;
	private JLabel lblNota4;
	private JLabel lblPromedio;
	
	private JLabel lblEstado;
	JLabel lblLblestado;
	private JLabel lblRegistroDeNotas;
	JLabel lblcodmiembro;
	JLabel lblnombrealumno;
	
	private JButton btnCalcularPromedio;
	

	private JPanel panelusuariolog;
	JLabel lblcodusuario;
	JLabel lblnombreusuario;
	JLabel lblLblcodacceso;
	
	private JLabel lblCodAlumno;
	private JLabel lblCurso;
	JLabel lblLblcurso;
	private JLabel lblNivel;
	JLabel lblLblnivel;
	private JLabel lblPeriodo;
	JLabel lblLblperiodo;
	private JLabel label;

	private JButton btnRegistrarNota;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopupRegistroNotas frame = new PopupRegistroNotas();
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
	public PopupRegistroNotas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 386);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		panelregnotas = new JPanel();
		panelregnotas.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW));
		panelregnotas.setBackground(Color.WHITE);
		panelregnotas.setBounds(10, 11, 373, 264);
		contentPane.add(panelregnotas);
		panelregnotas.setLayout(null);
		
		txtnota1 = new JTextField();
		txtnota1.setBounds(111, 97, 56, 20);
		panelregnotas.add(txtnota1);
		txtnota1.setColumns(10);
		
		txtnota2 = new JTextField();
		txtnota2.setBounds(111, 129, 56, 20);
		panelregnotas.add(txtnota2);
		txtnota2.setColumns(10);
		
		txtnota3 = new JTextField();
		txtnota3.setBounds(235, 99, 56, 20);
		panelregnotas.add(txtnota3);
		txtnota3.setColumns(10);
		
		txtnota4 = new JTextField();
		/*
		txtnota4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				mostrarcalculoprome(true);
			}
		});
		*/
		txtnota4.setBounds(236, 129, 54, 20);
		panelregnotas.add(txtnota4);
		txtnota4.setColumns(10);
		
		lblNota1 = new JLabel("Nota 1");
		lblNota1.setBounds(53, 100, 67, 14);
		panelregnotas.add(lblNota1);
		
		lblNota2 = new JLabel("Nota 2");
		lblNota2.setBounds(53, 132, 67, 14);
		panelregnotas.add(lblNota2);
		
		lblNota3 = new JLabel("Nota 3");
		lblNota3.setBounds(177, 102, 67, 14);
		panelregnotas.add(lblNota3);
		
		lblNota4 = new JLabel("Nota 4");
		lblNota4.setBounds(177, 134, 67, 14);
		panelregnotas.add(lblNota4);
		
		lblPromedio = new JLabel("Promedio");
		lblPromedio.setBounds(81, 170, 77, 14);
		panelregnotas.add(lblPromedio);
		
		txtpromedio = new JTextField();
		txtpromedio.setEditable(false);
		txtpromedio.setBounds(156, 167, 67, 20);
		panelregnotas.add(txtpromedio);
		txtpromedio.setColumns(10);
		
		btnCalcularPromedio = new JButton("");
		btnCalcularPromedio.setIcon(new ImageIcon(PopupRegistroNotas.class.getResource("/imagenes/update.png")));
		btnCalcularPromedio.setBackground(Color.WHITE);
	
			btnCalcularPromedio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					calcularpromedio();
				
				}
			});
		
		btnCalcularPromedio.setBounds(237, 165, 48, 23);
		panelregnotas.add(btnCalcularPromedio);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(82, 196, 67, 14);
		panelregnotas.add(lblEstado);
		
		lblLblestado = new JLabel("lblestado");
		lblLblestado.setForeground(Color.BLUE);
		//lblLblestado.setText("Sin Nota Registrado");
		lblLblestado.setBounds(158, 196, 161, 14);
		panelregnotas.add(lblLblestado);
		
		lblRegistroDeNotas = new JLabel("Registro de Notas del Alumno");
		lblRegistroDeNotas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistroDeNotas.setForeground(Color.BLUE);
		lblRegistroDeNotas.setBounds(10, 11, 234, 14);
		panelregnotas.add(lblRegistroDeNotas);
		
		lblcodmiembro = new JLabel("lblcodalumno");
		lblcodmiembro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblcodmiembro.setForeground(Color.BLUE);
		lblcodmiembro.setBounds(109, 36, 94, 14);
		panelregnotas.add(lblcodmiembro);
		
		lblnombrealumno = new JLabel("New label");
		lblnombrealumno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnombrealumno.setForeground(Color.BLUE);
		lblnombrealumno.setBounds(207, 11, 156, 14);
		panelregnotas.add(lblnombrealumno);
		
		lblCodAlumno = new JLabel("COD ALUMNO");
		lblCodAlumno.setBounds(20, 36, 100, 14);
		panelregnotas.add(lblCodAlumno);
		
		lblCurso = new JLabel("CURSO");
		lblCurso.setBounds(21, 61, 67, 14);
		panelregnotas.add(lblCurso);
		
		lblLblcurso = new JLabel("lblcurso");
		lblLblcurso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLblcurso.setForeground(Color.BLUE);
		lblLblcurso.setBounds(81, 61, 126, 14);
		panelregnotas.add(lblLblcurso);
		
		lblNivel = new JLabel("NIVEL");
		lblNivel.setBounds(224, 36, 56, 14);
		panelregnotas.add(lblNivel);
		
		lblLblnivel = new JLabel("lblNivel");
		lblLblnivel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLblnivel.setForeground(Color.BLUE);
		lblLblnivel.setBounds(284, 36, 98, 14);
		panelregnotas.add(lblLblnivel);
		
		lblPeriodo = new JLabel("PERIODO");
		lblPeriodo.setBounds(222, 61, 56, 14);
		panelregnotas.add(lblPeriodo);
		
		lblLblperiodo = new JLabel("lblperiodo");
		lblLblperiodo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLblperiodo.setForeground(Color.BLUE);
		lblLblperiodo.setBounds(282, 61, 95, 14);
		panelregnotas.add(lblLblperiodo);
		
		label = new JLabel("--------------------------------------------------------------------");
		label.setBounds(44, 78, 280, 14);
		panelregnotas.add(label);
		
		btnRegistrarNota = new JButton("Registrar Nota");
		btnRegistrarNota.setBackground(Color.WHITE);
		btnRegistrarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actulizarnotas();
			}
		});
		btnRegistrarNota.setBounds(121, 224, 130, 23);
		panelregnotas.add(btnRegistrarNota);
		
		panelusuariolog = new JPanel();
		panelusuariolog.setBackground(Color.WHITE);
		panelusuariolog.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN));
		panelusuariolog.setBounds(10, 286, 373, 59);
		contentPane.add(panelusuariolog);
		panelusuariolog.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 22, 60, 14);
		panelusuariolog.add(lblUsuario);
		
		lblcodusuario = new JLabel("New label");
		lblcodusuario.setBounds(72, 22, 91, 14);
		panelusuariolog.add(lblcodusuario);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(182, 22, 60, 14);
		panelusuariolog.add(lblNombre);
		
		lblnombreusuario = new JLabel("New label");
		lblnombreusuario.setBounds(246, 22, 108, 14);
		panelusuariolog.add(lblnombreusuario);
		
		lblLblcodacceso = new JLabel("lblcodacceso");
		lblLblcodacceso.setBounds(152, 38, 91, 14);
		lblLblcodacceso.setVisible(false);
		panelusuariolog.add(lblLblcodacceso);
		
		btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(PopupRegistroNotas.class.getResource("/imagenes/salir.png")));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(316, 9, 47, 41);
		panelusuariolog.add(btnSalir);
		
		
		
	//	mostrarcalculoprome(false);
	}
	
	GestionNotas grn = new GestionNotas();
	Notas rn = new Notas();
	AcademiaBiblica ab = new AcademiaBiblica();
	
	void actulizarnotas(){
		
		rn.setUsuAlumno(leercodmiembro());
		rn.setCurso(leercurso());
		rn.setSeccion(leernivel());
		rn.setPeriodo(leerperiodo());		
		rn.setNt1(leernota1());
		rn.setNt2(leernota2());
		rn.setNt3(leernota3());
		rn.setNt4(leernota4());
		rn.setPromedio(leerpromedio());
		rn.setEstado(leerestado());
		ab.actualizarnota(rn);
		
	}
	String leerestado(){
	 return lblLblestado.getText();
	}

	void estadonotalumno(){
		if(leerpromedio()>=13){
			lblLblestado.setText("Aprobado");
		}else if(leerpromedio()>0.0 && leerpromedio()<13){
			lblLblestado.setText("Desaprobado");
		}else if(leerpromedio()==0.0){
			lblLblestado.setText("Sin Nota Registrado");
		}
		
	}
	
	void mostrarnotasdetalle(){
		
		
			
			String nombrecurso = lblLblcurso.getText();
			String nombrenivel = lblLblnivel.getText();
			String nombreperiodo = lblLblperiodo.getText();
			String nombrecodalumno = lblcodmiembro.getText();
	
			ArrayList<Notas>lista=grn.buscardetallecurso(nombrecodalumno,nombrecurso, nombrenivel,nombreperiodo);		
			
			for(Notas p :lista){
						//codigo=p.getCodcurso();
						txtnota1.setText(""+p.getNt1());
						txtnota2.setText(""+p.getNt2());
						txtnota3.setText(""+p.getNt3());
						txtnota4.setText(""+p.getNt4());
						txtpromedio.setText(""+p.getPromedio());
			}
			estadonotalumno();
			
			
		}
	
	void calcularpromedio(){	
		
		
		 
		rn.setNt1(leernota1());
		rn.setNt2(leernota2());
		rn.setNt3(leernota3());
		rn.setNt4(leernota4());
		double promedio =ab.calcularpromedio(rn);
		txtpromedio.setText(""+promedio);
		if(promedio>=13){
			lblLblestado.setText("Aprobado");
		}else{
			lblLblestado.setText("Desaprobado");
		}
		
		
	}
	
	
	String leercurso(){
		return lblLblcurso.getText();
	}
	String leernivel(){
		return lblLblnivel.getText();
	}
	String leerperiodo(){
		return lblLblperiodo.getText();
	}

	String leercodmiembro(){
		return lblcodmiembro.getText();
	}
	double leernota1(){
		return Double.parseDouble(txtnota1.getText()); 
	}
	double leernota2(){
		return Double.parseDouble(txtnota2.getText()); 
	}
	double leernota3(){
		return Double.parseDouble(txtnota3.getText()); 
	}
	double leernota4(){
		return Double.parseDouble(txtnota4.getText()); 
	}
	double leerpromedio(){
		return Double.parseDouble(txtpromedio.getText()); 
	}
}
