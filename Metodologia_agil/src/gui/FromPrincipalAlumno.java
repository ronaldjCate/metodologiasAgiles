package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FromPrincipalAlumno extends JFrame implements ActionListener{

private JFrame frame;
	
	private JPanel contentPane;
	JTextField txtusuariologin;
	JTextField txtcodusuariologin;
	JTextField txtnombrelogin;
	JTextField txtidtbpersona;
	private JMenuBar menuBar;
	private JDesktopPane desktopPane;
	
	JTextField txtidtbacceso;
	private JButton btnMatricula;
	private JButton btnConsultaHorariosMatriculados;
	private JButton btnHorariosDisponibles;
	private JButton btnModificarDatosPersonales;
	private JButton btnSalir;
	private JButton btnReporte;
	private JButton btnCursoRecomendado;
	JTextField txtusuarioPrincipal;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromPrincipalAlumno frame = new FromPrincipalAlumno();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FromPrincipalAlumno() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FromPrincipalAlumno.class.getResource("/imagenes/upc.png")));
		
		getContentPane().setLayout(null);
		setTitle("UNIVERSIDAD PERUANA DE CIENCIAS APLICADAS ® >>> SISTEMA DE CONTROL DE MATRICULA ® >>> ALUMNO");
		//setIconImage(new ImageIcon("imagenes/loginiacm.jpg").getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		try{
			desktopPane = new JDesktopPane(){
			Image img = javax.imageio.ImageIO.read(
					 new java.net.URL(getClass().getResource("/imagenes/fondo.JPG"),"fondo.JPG"));
			  public void paintComponent(Graphics g){
				  super.paintComponent(g);
				  if(img != null) g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				  else g.drawString("Image not found", 100, 100);	  
			     }
			};
			}
			catch(IOException e){
				 e.printStackTrace();
			}
			
			contentPane.add(desktopPane, BorderLayout.CENTER);
			desktopPane.setLayout(null);
			
			btnMatricula = new JButton("Inscripci\u00F3n");
			btnMatricula.addActionListener(this);
			btnMatricula.setForeground(Color.RED);
			btnMatricula.setBackground(Color.WHITE);
			btnMatricula.setBounds(0, -1, 248, 76);
			desktopPane.add(btnMatricula);
			
			btnConsultaHorariosMatriculados = new JButton("Cursos Matriculados");
			btnConsultaHorariosMatriculados.setForeground(Color.RED);
			btnConsultaHorariosMatriculados.addActionListener(this);
			btnConsultaHorariosMatriculados.setBackground(Color.WHITE);
			btnConsultaHorariosMatriculados.setBounds(0, 71, 248, 76);
			desktopPane.add(btnConsultaHorariosMatriculados);
			
			btnHorariosDisponibles = new JButton("Horarios Disponibles");
			btnHorariosDisponibles.addActionListener(this);
			btnHorariosDisponibles.setForeground(Color.RED);
			btnHorariosDisponibles.setBackground(Color.WHITE);
			btnHorariosDisponibles.setBounds(0, 146, 248, 76);
			desktopPane.add(btnHorariosDisponibles);
			
			btnModificarDatosPersonales = new JButton("Datos Personales");
			btnModificarDatosPersonales.setForeground(Color.RED);
			btnModificarDatosPersonales.setBackground(Color.WHITE);
			btnModificarDatosPersonales.setBounds(0, 221, 248, 76);
			desktopPane.add(btnModificarDatosPersonales);
			
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(this);
			btnSalir.setForeground(Color.RED);
			btnSalir.setBackground(Color.WHITE);
			btnSalir.setBounds(0, 371, 248, 76);
			desktopPane.add(btnSalir);
			
			btnReporte = new JButton("Reporte");
			btnReporte.setVisible(false);
			btnReporte.addActionListener(this);
			btnReporte.setForeground(Color.RED);
			btnReporte.setBackground(Color.WHITE);
			btnReporte.setBounds(0, 471, 248, 76);
			desktopPane.add(btnReporte);
			
			btnCursoRecomendado = new JButton("Curso Recomendado");
			btnCursoRecomendado.addActionListener(this);
			btnCursoRecomendado.setForeground(Color.RED);
			btnCursoRecomendado.setBackground(Color.WHITE);
			btnCursoRecomendado.setBounds(0, 296, 248, 76);
			desktopPane.add(btnCursoRecomendado);
			
			txtusuarioPrincipal = new JTextField();
			txtusuarioPrincipal.setVisible(false);
			txtusuarioPrincipal.setBounds(276, 27, 86, 20);
			desktopPane.add(txtusuarioPrincipal);
			txtusuarioPrincipal.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 507);
		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnSalir){
			actionperformedbtnSalir();
		}
		if(arg0.getSource()==btnHorariosDisponibles){
			actionperformedbtnHor(arg0);
		}
		if(arg0.getSource()==btnCursoRecomendado){
			actionperformedbtnCursoRecomendado(arg0);
		}
		if(arg0.getSource()==btnMatricula){
			actionperformedbtnMatricula(arg0);
		}
		if(arg0.getSource()==btnConsultaHorariosMatriculados){
			actionperformedbtnConsultaHorariosMatriculados(arg0);
		}
		if(arg0.getSource()==btnReporte) {
			Report_certificado rc= new Report_certificado();
			desktopPane.add(rc);
		}
	}
	
	private void actionperformedbtnConsultaHorariosMatriculados(ActionEvent arg0) {
		// TODO Auto-generated method stub
		FrmPrincipalAlumCursosMatriculados cur = new FrmPrincipalAlumCursosMatriculados();		
		desktopPane.add(cur);
		
		Dimension desktopSize=desktopPane.getSize();
		Dimension FrameSize= cur.getSize();
		cur.setLocation((desktopSize.width-FrameSize.width)/2, 1/(desktopSize.height-FrameSize.height/1));
		cur.setVisible(true);
		cur.txtusuarioPrincipal.setText(txtusuarioPrincipal.getText());
		cur.listar();
	}

	private void actionperformedbtnMatricula(ActionEvent arg0) {
		// TODO Auto-generated method stub
		FrmPrinAlumInscripcion cur = new FrmPrinAlumInscripcion();		
		desktopPane.add(cur);
		
		Dimension desktopSize=desktopPane.getSize();
		Dimension FrameSize= cur.getSize();
		cur.setLocation((desktopSize.width-FrameSize.width)/2, 1/(desktopSize.height-FrameSize.height/1));
		cur.setVisible(true);
		cur.txtusuarioPrincipal.setText(txtusuarioPrincipal.getText());
	}

	private void actionperformedbtnCursoRecomendado(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		FromPrincipalAlumCursoRecomendado cur = new FromPrincipalAlumCursoRecomendado();		
		desktopPane.add(cur);
		
		Dimension desktopSize=desktopPane.getSize();
		Dimension FrameSize= cur.getSize();
		cur.setLocation((desktopSize.width-FrameSize.width)/2, 1/(desktopSize.height-FrameSize.height/1));
		cur.setVisible(true);
		
	}

	private void actionperformedbtnHor(ActionEvent arg0) {
		// TODO Auto-generated method stub
		FromPrincipalAlumHoraDisponible cur = new FromPrincipalAlumHoraDisponible();		
		desktopPane.add(cur);
		
		Dimension desktopSize=desktopPane.getSize();
		Dimension FrameSize= cur.getSize();
		cur.setLocation((desktopSize.width-FrameSize.width)/2, 1/(desktopSize.height-FrameSize.height/1));
		cur.setVisible(true);
	}

	private void actionperformedbtnSalir() {
		// TODO Auto-generated method stub
		dispose();
		Login l = new Login();
		l.setVisible(true);
	}

}
