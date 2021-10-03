package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.CursoRecomendado;
import clases.Notas;
import clases.OfertaCurso;
import mantenimientos.GestionInscripcion;
import mantenimientos.GestionProgHorarios;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class FrmPrincipalAlumCursosMatriculados extends JInternalFrame implements ActionListener, KeyListener,MouseListener{

	private JFrame frame;
	private JDesktopPane desktopPane;
	private JPanel contentPane;
	
	private JPanel panelListado;
	private JPanel panellistado2;
	
	
	
	private JScrollPane scrolloferta;
	private DefaultTableModel modelooferta;
	private JTable tbloferta;
	
	
	private JScrollPane scrollPanehorario;
	private DefaultTableModel modeloHorario;
	private JTable tblHorario_1;
	JTextField txtusuarioPrincipal;
	private JButton btnSalir;
	private JLabel lblNota1;
	private JLabel lblNota2;
	private JLabel lblNota3;
	private JLabel lblNota4;
	private JLabel lblPromedio;
	private JLabel lblEstado;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtNota4;
	private JTextField txtPromedio;
	private JTextField txtEstado;
	private JTextField txtcurso;
	private JTextField txtseccion;
	private JTextField txtperiodo;
	private JPanel panel3;
	private JButton btnVer;
	private JButton btnVerCertificado;
	private JButton btnNewButton;
	private JButton btnVerClase;
	private JButton btnVerNota;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipalAlumCursosMatriculados window = new FrmPrincipalAlumCursosMatriculados();
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
	public FrmPrincipalAlumCursosMatriculados() {
		
		setTitle("Mantenimiento de Personas");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1081, 664);		
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		try{
			desktopPane = new JDesktopPane(){
			Image img = javax.imageio.ImageIO.read(
					 new java.net.URL(getClass().getResource("/imagenes/usuario_ofi.jpg"),"usuario_ofi.jpg"));
			  public void paintComponent(Graphics g){
				  super.paintComponent(g);
				  if(img != null) g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				  else g.drawString("Image not found", 100, 100);	  
			     }
			};
			desktopPane.setBounds(0, 0, 0, 0);
		}
		catch(IOException e){
		 e.printStackTrace();
		}
		//contentPane.setLayout(null);
			
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		panelListado = new JPanel();
		panelListado.setForeground(Color.BLACK);
		panelListado.setBackground(Color.GRAY);
		panelListado.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		panelListado.setBounds(39, 11, 985, 294);
		desktopPane.add(panelListado);
		panelListado.setLayout(null);
		
		
		
		scrollPanehorario = new JScrollPane();
		scrollPanehorario.setBounds(32, 82, 923, 181);
		panelListado.add(scrollPanehorario);
		
		tblHorario_1 = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){
				 return false;
			 }
		 };
		tblHorario_1.setForeground(Color.ORANGE);
		tblHorario_1.setBackground(Color.GRAY);
		tblHorario_1.addMouseListener(this);
		tblHorario_1.setFillsViewportHeight(true);
		scrollPanehorario.setViewportView(tblHorario_1);
		
		modeloHorario= new DefaultTableModel();		
		modeloHorario.addColumn("CURSO");
		modeloHorario.addColumn("SECCIÓN");
		modeloHorario.addColumn("PERIODO");
		modeloHorario.addColumn("PROMEDIO");
		modeloHorario.addColumn("ESTADO");
		tblHorario_1.setModel(modeloHorario);
		
		txtusuarioPrincipal = new JTextField();
		txtusuarioPrincipal.setBounds(27, 11, 86, 20);
		txtusuarioPrincipal.setVisible(false);
		panelListado.add(txtusuarioPrincipal);
		txtusuarioPrincipal.setColumns(10);
		
		txtcurso = new JTextField();
		txtcurso.setBounds(123, 11, 86, 20);
		txtcurso.setVisible(false);
		panelListado.add(txtcurso);
		txtcurso.setColumns(10);
		
		txtperiodo = new JTextField();
		txtperiodo.setBounds(238, 11, 86, 20);
		txtperiodo.setVisible(false);
		panelListado.add(txtperiodo);
		txtperiodo.setColumns(10);
		
		txtseccion = new JTextField();
		txtseccion.setVisible(false);
		txtseccion.setBounds(339, 11, 86, 20);
		panelListado.add(txtseccion);
		txtseccion.setColumns(10);
		
		
		panellistado2 = new JPanel();
		panellistado2.setVisible(false);
		panellistado2.setForeground(Color.BLACK);
		panellistado2.setBackground(Color.GRAY);
		panellistado2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		panellistado2.setBounds(39, 360, 985, 202);
		desktopPane.add(panellistado2);
		panellistado2.setLayout(null);
		
		

		panel3 = new JPanel();
		panel3.setVisible(false);
		panel3.setBounds(411, 11, 564, 173);
		panellistado2.add(panel3);
		panel3.setLayout(null);
		
		lblNota1 = new JLabel("NOTA 1");
		lblNota1.setForeground(Color.BLUE);
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota1.setBounds(29, 31, 77, 14);
		panellistado2.add(lblNota1);
		
		lblNota2 = new JLabel("NOTA 2");
		lblNota2.setForeground(Color.BLUE);
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota2.setBounds(29, 73, 77, 14);
		panellistado2.add(lblNota2);
		
		lblNota3 = new JLabel("NOTA 3");
		lblNota3.setForeground(Color.BLUE);
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota3.setBounds(180, 34, 77, 14);
		panellistado2.add(lblNota3);
		
		lblNota4 = new JLabel("NOTA 4");
		lblNota4.setForeground(Color.BLUE);
		lblNota4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota4.setBounds(180, 76, 77, 14);
		panellistado2.add(lblNota4);
		
		lblPromedio = new JLabel("PROMEDIO");
		lblPromedio.setForeground(Color.BLUE);
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPromedio.setBounds(29, 118, 109, 14);
		panellistado2.add(lblPromedio);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setForeground(Color.BLUE);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstado.setBounds(29, 147, 109, 14);
		panellistado2.add(lblEstado);
		
		txtNota1 = new JTextField();
		txtNota1.setEditable(false);
		txtNota1.setBounds(97, 30, 57, 20);
		panellistado2.add(txtNota1);
		txtNota1.setColumns(10);
		
		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setEditable(false);
		txtNota2.setBounds(97, 72, 57, 20);
		panellistado2.add(txtNota2);
		
		txtNota3 = new JTextField();
		txtNota3.setColumns(10);
		txtNota3.setEditable(false);
		txtNota3.setBounds(255, 31, 57, 20);
		panellistado2.add(txtNota3);
		
		txtNota4 = new JTextField();
		txtNota4.setColumns(10);
		txtNota4.setEditable(false);
		txtNota4.setBounds(255, 73, 57, 20);
		panellistado2.add(txtNota4);
		
		txtPromedio = new JTextField();
		txtPromedio.setColumns(10);
		txtPromedio.setEditable(false);
		txtPromedio.setBounds(120, 117, 69, 20);
		panellistado2.add(txtPromedio);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setEditable(false);
		txtEstado.setBounds(120, 146, 145, 20);
		panellistado2.add(txtEstado);
		
		
		scrolloferta = new JScrollPane();
		scrolloferta.setBounds(32, 32, 503, 101);
		panel3.add(scrolloferta);
		
		tbloferta = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){
				 return false;
			 }
		 };
		 tbloferta.setForeground(Color.ORANGE);
		 tbloferta.setBackground(Color.GRAY);
		 tbloferta.addMouseListener(this);
		 tbloferta.setFillsViewportHeight(true);
		 scrolloferta.setViewportView(tbloferta);
		
		modelooferta= new DefaultTableModel();		
		modelooferta.addColumn("DESCRIPCION");
		modelooferta.addColumn("EMPRESA");
		modelooferta.addColumn("SUELDO");
		modelooferta.addColumn("MONEDA");		
		tbloferta.setModel(modelooferta);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel3.setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(FrmPrincipalAlumCursosMatriculados.class.getResource("/imagenes/cerrar.png")));
		btnNewButton.setBounds(446, 144, 89, 23);
		panel3.add(btnNewButton);
		
		btnVer = new JButton("");
		btnVer.setBackground(Color.WHITE);
		btnVer.setContentAreaFilled(false);
		btnVer.setBorderPainted(false);
		btnVer.setBorder(null);
		btnVer.setIcon(new ImageIcon(FrmPrincipalAlumCursosMatriculados.class.getResource("/imagenes/buscar.png")));
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarOferta();				
			}
		});
		btnVer.setBounds(312, 86, 89, 37);
		panellistado2.add(btnVer);
		
		btnVerCertificado = new JButton("");
		btnVerCertificado.setBackground(Color.WHITE);
		btnVerCertificado.setContentAreaFilled(false);
		btnVerCertificado.setBorderPainted(false);
		btnVerCertificado.setBorder(null);
		btnVerCertificado.setIcon(new ImageIcon(FrmPrincipalAlumCursosMatriculados.class.getResource("/imagenes/buscar.png")));
		btnVerCertificado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarReporte();
			}
		});
		btnVerCertificado.setBounds(312, 120, 89, 23);
		panellistado2.add(btnVerCertificado);
		
		
		btnSalir = new JButton("");
		btnSalir.setBounds(455, 539, 86, 85);
		desktopPane.add(btnSalir);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setBorder(null);
		btnSalir.setIcon(new ImageIcon(FromPrincipalAlumHoraDisponible.class.getResource("/imagenes/salir.png")));
		
		btnVerClase = new JButton("Ver Clase");
		btnVerClase.setBackground(Color.BLACK);
		btnVerClase.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerClase.setVisible(false);
		btnVerClase.setForeground(Color.WHITE);
		btnVerClase.addActionListener(this);
		btnVerClase.setBounds(39, 333, 488, 23);
		desktopPane.add(btnVerClase);
		
		btnVerNota = new JButton("Ver Nota");
		btnVerNota.setBackground(Color.BLACK);
		btnVerNota.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerNota.setForeground(Color.WHITE);
		btnVerNota.setVisible(false);
		btnVerNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panellistado2.setVisible(true);
			}
		});
		btnVerNota.setBounds(524, 333, 500, 23);
		desktopPane.add(btnVerNota);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
	
		
		
		listar();
	}
	
	
	String leerEstado() {
		return txtEstado.getText();
	}
	
	double leerNota() {
		return Double.parseDouble(txtPromedio.getText());
	}
	
	void mostrarReporte() {
		if(leerNota()<13) {
			JOptionPane.showMessageDialog(null, "Usted no logró la certificación");
		}else if(leerNota()>=13){
			Report_certificado rc= new Report_certificado();
			desktopPane.add(rc);
		}
	}
	
	void mostrarOferta() {		
		if(leerNota()<13 && leerNota()>0.0) {
			JOptionPane.showMessageDialog(null, "Usted no cumple con los requisitos para ver las ofertas laborales");
		}else if(leerNota()==0) {
			JOptionPane.showMessageDialog(null, "Falta obtener el resultado de calificación");
		}else {
		panel3.setVisible(true);
		calcularOferta();
		}
	}
	
	void listar(){
		String usuario = txtusuarioPrincipal.getText();
		GestionInscripcion gts = new GestionInscripcion();
		ArrayList<Notas>lista=gts.listadoCursoMatriculado(usuario);
		if(lista==null){
			
		}else{
			modeloHorario.setRowCount(0);
			for(Notas p :lista){
				Object[]fila={
						p.getCurso(),
						p.getSeccion(),	
						p.getPeriodo(),
						p.getPromedio(),
						p.getEstado()
											
				};modeloHorario.addRow(fila);
			//	txtcodhorario.setText(""+p.getIdasociacion());
			}
		}
	}
	
	void calcularOferta(){
		String cur = txtcurso.getText();
		double nota = Double.parseDouble(txtPromedio.getText());
		
		GestionInscripcion gts = new GestionInscripcion();
		ArrayList<OfertaCurso>lista=gts.listadooferta(nota,cur);
		if(lista==null){
			
		}else{
			modelooferta.setRowCount(0);
			for(OfertaCurso p :lista){
				Object[]fila={
						p.getDescripcion(),
						p.getEmpresa(),	
						p.getSueldo(),
						p.getMoneda()						
											
				};modelooferta.addRow(fila);
			//	txtcodhorario.setText(""+p.getIdasociacion());
			}
		}
	}
	

	void listarDetalle()throws ParseException{
		
		String cur = txtcurso.getText();
		String sec = txtseccion.getText();
		String per = txtperiodo.getText();
		String usu = txtusuarioPrincipal.getText();
		
		GestionInscripcion gts = new GestionInscripcion();
		ArrayList<Notas>lista=gts.listadoDetalleCursoMatriculado(cur,sec,per,usu);
		
			for(Notas p :lista){
						txtNota1.setText(""+p.getNt1());
						txtNota2.setText(""+p.getNt2());
						txtNota3.setText(""+p.getNt3());
						txtNota4.setText(""+p.getNt4());
						txtPromedio.setText(""+p.getPromedio());
						txtEstado.setText(p.getEstado());										
				};					
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2){
			txtcurso.setText(tblHorario_1.getValueAt(tblHorario_1. getSelectedRow(),0).toString());
			txtseccion.setText(tblHorario_1.getValueAt(tblHorario_1. getSelectedRow(),1).toString());
			txtperiodo.setText(tblHorario_1.getValueAt(tblHorario_1. getSelectedRow(),2).toString());
			btnVerClase.setVisible(true);
			btnVerNota.setVisible(true);
			//panellistado2.setVisible(true);
			try {
				listarDetalle();
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnVerClase){
			actionPerformedbtnVerClase();			
		}
	}

	private void actionPerformedbtnVerClase() {
		// TODO Auto-generated method stub
		FrmVideo cur = new FrmVideo();		
		
		cur.setVisible(true);
	}
}
