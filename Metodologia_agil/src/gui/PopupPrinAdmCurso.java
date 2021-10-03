package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import clases.Cursos;
import clases.DetCursos;
import mantenimientos.GestionCursos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PopupPrinAdmCurso extends JInternalFrame implements ActionListener,MouseListener{

	private JFrame frame;
	private JPanel contentPane;
	
	private JButton btnDatosPersonales;//CURSO	
	private JPanel paneldatospersonales;//CURSO
	private JLabel lblDescripcion;
	private JLabel lblCodigoCurso;
	private JLabel lblCrditos;
	private JLabel lblPrecio;
	private JTextField txtdescripcion;
	private JTextField txtcodigocurso;
	private JTextField txtcreditos;
	private JTextField txtPrecio;
	JButton btndpRegistrar;
	
	private JButton btndfCargar;
	private JButton btndfatras;
	
	//////////////////////////////////////////////////////////////////////
	
	private JButton btnDatosFamiliares;//FORMULA DE CALIFICACION
	private JPanel paneldatosfamiliare;;//FORMULA DE CALIFICACION	

	private JScrollPane scrollPaneDatosfamiliares;
	private JTable tblDatosfamiliares;
	private DefaultTableModel modeloDatosfamiliares;
	
	int ultimoCodigoCurso=0;
	private JLabel lblNewLabel;
	private JLabel lblPesos;
	private JTextField txtdescripcion2;
	private JTextField txtPesos;
	private JButton btnCargar;
	
	private JScrollPane scrollPaneFormula;
	JTable tblFormula;
	private DefaultTableModel modeloFormula;
	private JButton btnSalir;
	private JButton btnNewButton;
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopupPrinAdmCurso window = new PopupPrinAdmCurso();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PopupPrinAdmCurso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 542);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnDatosPersonales = new JButton("CURSOS");
		btnDatosPersonales.setForeground(Color.BLUE);
		btnDatosPersonales.setBackground(Color.WHITE);
		btnDatosPersonales.setBounds(0, 0, 401, 23);
		contentPane.add(btnDatosPersonales);
		
		/////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////
		
		
		
		paneldatospersonales = new JPanel();
		paneldatospersonales.setBackground(Color.WHITE);
		paneldatospersonales.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255)), "Registro de Cursos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.blue));
		paneldatospersonales.setBounds(10, 56, 367, 393);
		contentPane.add(paneldatospersonales);
		paneldatospersonales.setLayout(null);
		
		
		lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setBounds(145, 88, 147, 14);
		paneldatospersonales.add(lblDescripcion);
		
		txtdescripcion = new JTextField();
		txtdescripcion.setBounds(68, 113, 224, 20);
		paneldatospersonales.add(txtdescripcion);
		txtdescripcion.setColumns(10);
		
		lblCodigoCurso = new JLabel("CODIGO CURSO");
		lblCodigoCurso.setBounds(145, 28, 137, 14);
		paneldatospersonales.add(lblCodigoCurso);
		
		txtcodigocurso = new JTextField();
		txtcodigocurso.setBounds(68, 57, 224, 20);
		paneldatospersonales.add(txtcodigocurso);
		txtcodigocurso.setColumns(10);
		
		lblCrditos = new JLabel("CR\u00C9DITOS");
		lblCrditos.setBounds(145, 144, 103, 14);
		paneldatospersonales.add(lblCrditos);
		
		txtcreditos = new JTextField();
		txtcreditos.setBounds(68, 169, 224, 20);
		paneldatospersonales.add(txtcreditos);
		txtcreditos.setColumns(10);
		
		lblPrecio = new JLabel("PRECIO");
		lblPrecio.setBounds(145, 200, 103, 14);
		paneldatospersonales.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(68, 225, 224, 20);
		paneldatospersonales.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btndpRegistrar = new JButton("");
		btndpRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarcurso();
			}
		});
		btndpRegistrar.setIcon(new ImageIcon(PopupPrinAdmCurso.class.getResource("/imagenes/guardar.png")));
		btndpRegistrar.setBackground(Color.WHITE);
		btndpRegistrar.setContentAreaFilled(false);
		btndpRegistrar.setBorderPainted(false);
		btndpRegistrar.setBorder(null);
		btndpRegistrar.setBounds(10, 341, 347, 41);
		paneldatospersonales.add(btndpRegistrar);
		
		
		
		/////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////
				
		

		
		btnDatosFamiliares = new JButton("FORMULA DE CALIFICACIÓN");
		btnDatosFamiliares.setForeground(Color.BLUE);
		btnDatosFamiliares.setEnabled(false);
		btnDatosFamiliares.setBackground(Color.WHITE);
		btnDatosFamiliares.setBounds(0, 22, 401, 23);
		contentPane.add(btnDatosFamiliares);
		
		btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(271, 478, 89, 23);
		contentPane.add(btnSalir);
		btnSalir.setIcon(new ImageIcon(PopupPrinAdmCurso.class.getResource("/imagenes/cerrar.png")));
		btnSalir.setBackground(Color.WHITE);
		
		
	
		paneldatosfamiliare = new JPanel();
		paneldatosfamiliare.setBackground(Color.WHITE);
		paneldatosfamiliare.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255)), "Formula de califición", TitledBorder.LEADING, TitledBorder.TOP, null, Color.blue));
		paneldatosfamiliare.setBounds(37, 56, 323, 411);
		contentPane.add(paneldatosfamiliare);
		paneldatosfamiliare.setVisible(false);
		paneldatosfamiliare.setLayout(null);
		
		
		
		lblNewLabel = new JLabel("DESCRIPCION");
		lblNewLabel.setBounds(111, 30, 127, 14);
		paneldatosfamiliare.add(lblNewLabel);
		
		lblPesos = new JLabel("PESOS");
		lblPesos.setBounds(122, 87, 112, 14);
		paneldatosfamiliare.add(lblPesos);
		
		txtdescripcion2 = new JTextField();
		txtdescripcion2.setBounds(65, 56, 176, 20);
		paneldatosfamiliare.add(txtdescripcion2);
		txtdescripcion2.setColumns(10);
		
		txtPesos = new JTextField();
		txtPesos.setBounds(65, 110, 173, 20);
		paneldatosfamiliare.add(txtPesos);
		txtPesos.setColumns(10);
		
		btnCargar = new JButton("");
		btnCargar.setIcon(new ImageIcon(PopupPrinAdmCurso.class.getResource("/imagenes/guardar.png")));
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarcursodet();
			}
		});
		btnCargar.setBounds(254, 109, 38, 23);
		paneldatosfamiliare.add(btnCargar);
		

		 scrollPaneFormula = new JScrollPane();
		 scrollPaneFormula.setBounds(50, 150, 200, 190);
		 paneldatosfamiliare.add(scrollPaneFormula);
		 
		 
		    
		 tblFormula = new JTable();
		 tblFormula = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){				
				 return false;
			 }
			
		 };
		 tblFormula.addMouseListener(this);
		 
		 tblFormula.setForeground(Color.blue);
		 tblFormula.setBackground(Color.lightGray);
		 scrollPaneFormula.setViewportView(tblFormula);              
		    
		    
		 modeloFormula= new DefaultTableModel();
		 modeloFormula.addColumn("DESCRIPCION");
		 modeloFormula.addColumn("PESOS");
		 tblFormula.setModel(modeloFormula);
		 
		 btndfatras = new JButton("");
		 btndfatras.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		paneldatospersonales.setVisible(true);
		 		paneldatosfamiliare.setVisible(false);
		 	}
		 });
		 btndfatras.setBounds(31, 364, 89, 23);
		 paneldatosfamiliare.add(btndfatras);
		 btndfatras.setIcon(new ImageIcon(PopupPrinAdmCurso.class.getResource("/imagenes/atras.png")));
		 btndfatras.setBackground(Color.WHITE);
		 
		 
	}
	
	
	String leerdescripcion(){
		return txtdescripcion.getText();
	}
	String leercodigoCurso(){
		return txtcodigocurso.getText();
	}
	int leerCredito(){
		return Integer.parseInt(txtcreditos.getText());
	}
	double leerCosto(){
		return Double.parseDouble(txtPrecio.getText());
	}
	
	
	
	void registrarcurso(){
		int credito;
		String nombre,codigoCurso;
		double precio;		
		
		nombre=leerdescripcion();
		codigoCurso=leercodigoCurso();
		credito=leerCredito();
		precio =leerCosto();
		System.out.println("Datos:"+nombre+codigoCurso+credito+precio);
		
		Cursos c= new Cursos();
		c.setDescripcion(nombre);
		c.setCodigoCurso(codigoCurso);
		c.setCredito(credito);									
		c.setCosto(precio);
		
		GestionCursos gc = new GestionCursos();
		int ok =gc.RegistrarCurso(c);
		if(ok==0){
			System.out.println("Error al registrar");
		}else{
			JOptionPane.showMessageDialog(null, "Registrado correctamente");				
			paneldatospersonales.setVisible(false);
			paneldatosfamiliare.setVisible(true);
			btnDatosPersonales.setEnabled(false);
			btnDatosFamiliares.setEnabled(true);
			btnDatosFamiliares.setForeground(Color.BLUE);
			btnDatosFamiliares.setBackground(Color.WHITE);
			ultimoCodigoCurso=gc.buscarultcoCurso();
			System.out.println("último código:"+ultimoCodigoCurso);
		}
		limpiar();		
			
	}
	

	void registrarcursodet(){
		int tb_cursos_idtb_cursos;
		double pesos;
		String descripcion;
		
		
		tb_cursos_idtb_cursos=Integer.parseInt(""+ultimoCodigoCurso);
		pesos=Double.parseDouble(""+txtPesos.getText());
		descripcion=txtdescripcion2.getText();
		System.out.println("Peso:"+pesos+"Descripcion:"+descripcion+"idtCurso:"+tb_cursos_idtb_cursos);
		
		DetCursos c= new DetCursos();
		c.setPesos(pesos);
		c.setDescripcion(descripcion);		
		c.setIdCurso(tb_cursos_idtb_cursos);									
		
		GestionCursos gc = new GestionCursos();
		int ok =gc.RegistrarDetCurso(c);
		if(ok==0){
			System.out.println("Error al registrar");
		}else{
			JOptionPane.showMessageDialog(null, "Registrado correctamente");				
			paneldatospersonales.setVisible(false);
			paneldatosfamiliare.setVisible(true);
			btnDatosPersonales.setEnabled(false);
			btnDatosFamiliares.setEnabled(true);
			btnDatosFamiliares.setForeground(Color.BLUE);
			btnDatosFamiliares.setBackground(Color.WHITE);
			ultimoCodigoCurso=gc.buscarultcoCurso();
			System.out.println("último código:"+ultimoCodigoCurso);
		}
		limpiardet();
		listar();
			
	}
	

	void listar(){
		GestionCursos gs = new GestionCursos();
		ArrayList<DetCursos>lista=gs.listadocursodet(ultimoCodigoCurso);
		if(lista==null){
			
		}else{
			modeloFormula.setRowCount(0);
			for(DetCursos p:lista){
				
				Object[]fila={
						p.getDescripcion(),
						p.getPesos()				
				}; modeloFormula.addRow(fila);
			}
		}
	}
	
	
	void limpiardet(){
		txtPesos.setText("");		
		txtdescripcion2.setText("");

	}
	
	void limpiar(){
		txtdescripcion.setText("");		
		txtcreditos.setText("");
		txtcodigocurso.setText("");
		txtPrecio.setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
