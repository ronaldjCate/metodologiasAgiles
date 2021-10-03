package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;


import javax.swing.JButton;




public class FromPrincipalAdministrador extends JFrame implements ActionListener{

	private JFrame frame;
	
	private JPanel contentPane;
	JTextField txtusuariologin;
	JTextField txtcodusuariologin;
	JTextField txtnombrelogin;
	JTextField txtidtbpersona;
	private JMenuBar menuBar;
	private JDesktopPane desktopPane;
	
	JTextField txtidtbacceso;
	private JButton btnRegistrarCursos;
	private JButton btnRegistrarPersonas;
	private JButton btnSeccion;
	private JButton btnSalir;
	private JButton btnProgramarHora;
	private JButton btnOfertaLaboral;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromPrincipalAdministrador frame = new FromPrincipalAdministrador();
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
	public FromPrincipalAdministrador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FromPrincipalAdministrador.class.getResource("/imagenes/upc.png")));
		
		getContentPane().setLayout(null);
		setTitle("UNIVERSIDAD PERUANA DE CIENCIAS APLICADAS ® >>> SISTEMA DE CONTROL DE MATRICULA ® >>> METODOLOGÍA ÁGIL");
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
			
			btnRegistrarCursos = new JButton("CURSOS");
			btnRegistrarCursos.addActionListener(this);
			btnRegistrarCursos.setForeground(Color.RED);
			btnRegistrarCursos.setBackground(Color.WHITE);
			btnRegistrarCursos.setBounds(0, -1, 248, 76);
			desktopPane.add(btnRegistrarCursos);
			
			btnRegistrarPersonas = new JButton("PERSONAS");
			btnRegistrarPersonas.addActionListener(this);
			btnRegistrarPersonas.setForeground(Color.RED);
			btnRegistrarPersonas.setBackground(Color.WHITE);
			btnRegistrarPersonas.setBounds(0, 71, 248, 76);
			desktopPane.add(btnRegistrarPersonas);
			
			btnSeccion = new JButton("SECCI\u00D3N");
			btnSeccion.addActionListener(this);
			btnSeccion.setForeground(Color.RED);
			btnSeccion.setBackground(Color.WHITE);
			btnSeccion.setBounds(0, 146, 248, 76);
			desktopPane.add(btnSeccion);
			
			btnSalir = new JButton("SALIR");
			btnSalir.addActionListener(this);
			btnSalir.setForeground(Color.RED);
			btnSalir.setBackground(Color.WHITE);
			btnSalir.setBounds(0, 371, 248, 76);
			desktopPane.add(btnSalir);
			
			btnProgramarHora = new JButton("PROGRAMAR CURSOS");
			btnProgramarHora.addActionListener(this);
			btnProgramarHora.setForeground(Color.RED);
			btnProgramarHora.setBackground(Color.WHITE);
			btnProgramarHora.setBounds(0, 221, 248, 76);
			desktopPane.add(btnProgramarHora);
			
			btnOfertaLaboral = new JButton("OFERTA LABORAL");
			btnOfertaLaboral.setBounds(0, 294, 248, 76);
			btnOfertaLaboral.setForeground(Color.RED);
			btnOfertaLaboral.setBackground(Color.WHITE);
			btnOfertaLaboral.addActionListener(this);
			desktopPane.add(btnOfertaLaboral);
		
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
		if(arg0.getSource()==btnRegistrarCursos){
			actionperformedbtnRegistrarCursos(arg0);
		}
		if(arg0.getSource()==btnRegistrarPersonas){
			actionperformedbtnRegistrarPersona(arg0);
		}
		if(arg0.getSource()==btnSeccion){
			actionperformedbtnRegistrarSeccion(arg0);
		}
		if(arg0.getSource()==btnProgramarHora){
			actionperformedbtnProgramaHor(arg0);
		}
		if(arg0.getSource()==btnOfertaLaboral){
			actionperformedbtnOfertaLaboral(arg0);
		}
	}

	private void actionperformedbtnOfertaLaboral(ActionEvent arg0) {
		// TODO Auto-generated method stub
		FromPrincipalAdmOfertaLab cur = new FromPrincipalAdmOfertaLab();		
		desktopPane.add(cur);
		
		Dimension desktopSize=desktopPane.getSize();
		Dimension FrameSize= cur.getSize();
		cur.setLocation((desktopSize.width-FrameSize.width)/2, 1/(desktopSize.height-FrameSize.height/1));
		cur.setVisible(true);
	}

	private void actionperformedbtnProgramaHor(ActionEvent arg0) {
		// TODO Auto-generated method stub
		FromPrincipalAdmProgHor cur = new FromPrincipalAdmProgHor();		
		desktopPane.add(cur);
		
		Dimension desktopSize=desktopPane.getSize();
		Dimension FrameSize= cur.getSize();
		cur.setLocation((desktopSize.width-FrameSize.width)/2, 1/(desktopSize.height-FrameSize.height/1));
		cur.setVisible(true);
	}

	private void actionperformedbtnRegistrarSeccion(ActionEvent arg0) {
		FromPrinAdmSec cur = new FromPrinAdmSec();		
		desktopPane.add(cur);
		
		Dimension desktopSize=desktopPane.getSize();
		Dimension FrameSize= cur.getSize();
		cur.setLocation((desktopSize.width-FrameSize.width)/2, 1/(desktopSize.height-FrameSize.height/1));
		cur.setVisible(true);
	}

	private void actionperformedbtnRegistrarPersona(ActionEvent arg0) {
		// TODO Auto-generated method stub
		FrmPrinAdmPers cur = new FrmPrinAdmPers();		
		desktopPane.add(cur);
		
		Dimension desktopSize=desktopPane.getSize();
		Dimension FrameSize= cur.getSize();
		cur.setLocation((desktopSize.width-FrameSize.width)/2, 1/(desktopSize.height-FrameSize.height/1));
		cur.setVisible(true);
	}

	private void actionperformedbtnRegistrarCursos(ActionEvent arg0) {
		// TODO Auto-generated method stub
		FrmPrinAdmCurso cur = new FrmPrinAdmCurso();		
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
