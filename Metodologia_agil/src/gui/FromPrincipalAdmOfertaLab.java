package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import clases.Cursos;
import clases.Oferta;
import clases.OfertaCurso;
import clases.ProgramacionHorario;
import clases.Seccion;
import mantenimientos.GestionCursos;
import mantenimientos.GestionOferta;
import mantenimientos.GestionProgHorarios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FromPrincipalAdmOfertaLab extends JInternalFrame implements ActionListener, KeyListener,MouseListener{

	private JFrame frame;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JTextField txtdescripcion;
	private JPanel panelOferta;
	private JPanel panelCurso;
	private JLabel lbldescripcion;
	private JButton btnOfertaLaboral;
String descripciongrado="";
	private JScrollPane scrollPaneSeccion;
	private JTable tblSeccion;
	private DefaultTableModel modeloSeccion;
	
	private JScrollPane scrollPaneOfertaCurso;
	private JTable tblOfertaCurso;
	private DefaultTableModel modeloOfertaCurso;
	
	
	private JLabel lblLaOfertaLaboral;
	private JLabel lblOfertaLaboral;
	private JComboBox cboCursos;
	private JLabel lblCursosParaAplicar;
	private JLabel lblSeDebeAprobar;
	
	String descripcionCurso="";
	private JButton btnRegstrar;
	
	String codigo="";
	String descripcion="";
	private JTextField txtcodigoOferta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromPrincipalAdmOfertaLab window = new FromPrincipalAdmOfertaLab();
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
	public FromPrincipalAdmOfertaLab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Registro de Ofertas Laborales");
		setBounds(100, 100, 861, 524);
		
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		try{
		desktopPane = new JDesktopPane(){
		Image img = javax.imageio.ImageIO.read(
				 new java.net.URL(getClass().getResource("/imagenes/fondocolegio.png"),"fondocolegio.png"));
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
		
		JPanel panel = new JPanel();
		panel.setBounds(47, 46, 746, 414);
		panel.setBackground(Color.GRAY);
		panel.setBorder(new LineBorder(Color.BLUE));
		panel.setForeground(Color.RED);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		
		
		panelOferta = new JPanel();
		panelOferta.setBackground(Color.LIGHT_GRAY);
		panelOferta.setBorder(new LineBorder(Color.BLUE, 1, true));
		panelOferta.setVisible(false);
		panelOferta.setForeground(Color.BLUE);
		panelOferta.setBounds(34, 42, 676, 347);
		panel.add(panelOferta);
		panelOferta.setLayout(null);
		
		
		
		txtdescripcion = new JTextField();
		txtdescripcion.setColumns(10);
		txtdescripcion.setBounds(50, 57, 119, 20);
		panelOferta.add(txtdescripcion);
		
		lbldescripcion = new JLabel("Descripci\u00F3n");
		lbldescripcion.setBounds(50, 37, 138, 14);
		panelOferta.add(lbldescripcion);
		
		
		
		btnOfertaLaboral = new JButton("Oferta Laboral");
		btnOfertaLaboral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOferta.setVisible(true);
			}
		});
		btnOfertaLaboral.setBounds(44, 11, 304, 23);
		panel.add(btnOfertaLaboral);
		
		scrollPaneSeccion = new JScrollPane();
		scrollPaneSeccion.setBounds(50, 120, 586, 185);
		panelOferta.add(scrollPaneSeccion);
		
		tblSeccion = new JTable();
		tblSeccion = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){
				 return false;
			 }
		 };
		tblSeccion.addMouseListener(this);				
		scrollPaneSeccion.setViewportView(tblSeccion);		
		
		modeloSeccion= new DefaultTableModel();
		modeloSeccion.addColumn("CÓDIGO");
		modeloSeccion.addColumn("DESCRIPCIÓN");
		modeloSeccion.addColumn("EMPRES");
		modeloSeccion.addColumn("SUELDO");
		modeloSeccion.addColumn("MONEDA");
		tblSeccion.setModel(modeloSeccion);
		
		
		btnRegstrar = new JButton("Regstrar");
		btnRegstrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnRegstrar.setBounds(577, 54, 89, 23);
		panelOferta.add(btnRegstrar);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(224, 37, 46, 14);
		panelOferta.add(lblEmpresa);
		
		JLabel lblSueldoAprox = new JLabel("Sueldo Aprox");
		lblSueldoAprox.setBounds(316, 37, 106, 14);
		panelOferta.add(lblSueldoAprox);
		
		txtempresa = new JTextField();
		txtempresa.setBounds(200, 57, 86, 20);
		panelOferta.add(txtempresa);
		txtempresa.setColumns(10);
		
		txtsueldo = new JTextField();
		txtsueldo.setBounds(310, 57, 86, 20);
		panelOferta.add(txtsueldo);
		txtsueldo.setColumns(10);
		
		lblMoneda = new JLabel("Moneda");
		lblMoneda.setBounds(441, 37, 46, 14);
		panelOferta.add(lblMoneda);
		
		cboMoneda = new JComboBox();
		cboMoneda.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "USD", "PEN"}));
		cboMoneda.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
            	descripciongrado=event.getItem().toString();
            }
        });
		cboMoneda.setBounds(441, 57, 94, 20);
		panelOferta.add(cboMoneda);
		
		JButton btnCursos = new JButton("Cursos");
		btnCursos.setBounds(364, 11, 346, 23);
		panel.add(btnCursos);
		

		panelCurso = new JPanel();
		panelCurso.setBackground(Color.LIGHT_GRAY);
		panelCurso.setBorder(new LineBorder(Color.BLUE, 1, true));
		panelCurso.setVisible(false);
		panelCurso.setForeground(Color.BLUE);
		panelCurso.setBounds(34, 42, 676, 347);
		panel.add(panelCurso);
		panelCurso.setLayout(null);
		
		lblLaOfertaLaboral = new JLabel("La Oferta Laboral");
		lblLaOfertaLaboral.setBounds(27, 44, 149, 14);
		panelCurso.add(lblLaOfertaLaboral);
		
		lblOfertaLaboral = new JLabel("lblOfertaLaboral");
		lblOfertaLaboral.setForeground(Color.RED);
		lblOfertaLaboral.setBounds(196, 44, 111, 14);
		panelCurso.add(lblOfertaLaboral);
		
		lblSeDebeAprobar = new JLabel("se debe aprobar los sisguientes ");
		lblSeDebeAprobar.setBounds(356, 44, 264, 14);
		panelCurso.add(lblSeDebeAprobar);
		
		cboCursos = new JComboBox();
		cboCursos.setBounds(180, 78, 161, 20);
		cboCursos.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
            	descripcionCurso=(event.getItem().toString());
            }
        });
		panelCurso.add(cboCursos);
		
		lblCursosParaAplicar = new JLabel("cursos para aplicar");
		lblCursosParaAplicar.setBounds(27, 81, 161, 14);
		panelCurso.add(lblCursosParaAplicar);
		
		scrollPaneOfertaCurso = new JScrollPane();
		scrollPaneOfertaCurso.setBounds(50, 180, 586, 145);
		panelCurso.add(scrollPaneOfertaCurso);
		
		tblOfertaCurso = new JTable();
		tblOfertaCurso = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){
				 return false;
			 }
		 };
		 tblOfertaCurso.addMouseListener(this);				
		 scrollPaneOfertaCurso.setViewportView(tblOfertaCurso);		
		
		modeloOfertaCurso= new DefaultTableModel();		
		modeloOfertaCurso.addColumn("CURSO");
		modeloOfertaCurso.addColumn("OFERTA");
		modeloOfertaCurso.addColumn("NOTA");
		tblOfertaCurso.setModel(modeloOfertaCurso);
		
		btnRegistrarofercur = new JButton("registrarOfercur");
		btnRegistrarofercur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrardetalle();
			}
		});
		btnRegistrarofercur.setBounds(366, 77, 89, 23);
		panelCurso.add(btnRegistrarofercur);
		
		txtcodigoOferta = new JTextField();
		txtcodigoOferta.setVisible(false);
		txtcodigoOferta.setBounds(34, 11, 86, 20);
		panelCurso.add(txtcodigoOferta);
		txtcodigoOferta.setColumns(10);
		
		lblLaOfertaLaboral_1 = new JLabel("La Oferta Laboral Aplica para Notas Mayores a:");
		lblLaOfertaLaboral_1.setForeground(Color.BLUE);
		lblLaOfertaLaboral_1.setBounds(27, 120, 264, 14);
		panelCurso.add(lblLaOfertaLaboral_1);
		
		txtNotaAplicación = new JTextField();
		txtNotaAplicación.setBounds(281, 117, 86, 20);
		panelCurso.add(txtNotaAplicación);
		txtNotaAplicación.setColumns(10);
		
		listarOferta();
		llenacomboCursos();
	}

	Oferta ofe = new Oferta();
	OfertaCurso ofeCu = new OfertaCurso();
	GestionOferta gofe = new GestionOferta();
	GestionProgHorarios gcsd = new GestionProgHorarios();
	
	private JButton btnRegistrarofercur;
	private JTextField txtempresa;
	private JTextField txtsueldo;
	private JLabel lblMoneda;
	private JComboBox cboMoneda;
	private JLabel lblLaOfertaLaboral_1;
	private JTextField txtNotaAplicación;
	

	void llenacomboCursos(){		
		ArrayList<Cursos> lista = gcsd.listadoCursoCombo();
		cboCursos.addItem("Seleccione");
		for (Cursos t : lista) {
			cboCursos.addItem(t.getNombrecurso());			
		}		
	}
	
	void registrar(){
		String descri = txtdescripcion.getText();
		String empre = txtempresa.getText();
		double sueldo = Double.parseDouble(txtsueldo.getText());
		String moneda = descripciongrado;
		
		ofe.setDescripcion(descri);
		ofe.setEmpresa(empre);
		ofe.setSueldo(sueldo);
		ofe.setMoneda(moneda);
		
		gofe.RegistrarOferta(ofe);
		
		JOptionPane.showMessageDialog(null, "Registrado correctamente");
		
		listarOferta();
		
	}
	

	void registrardetalle(){
		
		String curso = descripcionCurso;
		String oferta = lblOfertaLaboral.getText();
		int idseleccionado = Integer.parseInt(txtcodigoOferta.getText());
		
		ofeCu.setCurso(curso);
		ofeCu.setOferta(oferta);
		ofeCu.setCodigoOferta(idseleccionado);
		ofeCu.setNota(Double.parseDouble(txtNotaAplicación.getText()));
		
		gofe.RegistrarOfertaCurso(ofeCu);
		
		JOptionPane.showMessageDialog(null, "Registrado correctamente");
		
		listarOfertaCurso();
		
	}
	
	void listarOferta(){
		ArrayList<Oferta>lista=gofe.listadoOferta();
		if(lista==null){
			
		}else{
			modeloSeccion.setRowCount(0);
			for(Oferta p:lista){
				Object[]fila={
						p.getCodigo(),
						p.getDescripcion(),
						p.getEmpresa(),
						p.getSueldo(),
						p.getMoneda()
				}; modeloSeccion.addRow(fila);
			}
		}
	}
	

	void listarOfertaCurso(){
		int idseleccionado = Integer.parseInt(txtcodigoOferta.getText());
		
		ArrayList<OfertaCurso>lista=gofe.listadoOfertaCurso(idseleccionado);
		if(lista==null){
			
		}else{
			modeloOfertaCurso.setRowCount(0);
			for(OfertaCurso p :lista){
				Object[]fila={
						
						p.getOferta(),	
						p.getCurso(),
						p.getNota()
				};modeloOfertaCurso.addRow(fila);
				//txtcodhorario.setText(""+p.getIdasociacion());
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		tblSeccion = (JTable)arg0.getSource();
		
		Point point = arg0.getPoint();
		
		int row1 = tblSeccion.rowAtPoint(point);
		


			if(arg0.getClickCount()==2){
				txtcodigoOferta.setText(tblSeccion.getValueAt(tblSeccion. getSelectedRow(),0).toString());
				lblOfertaLaboral.setText(tblSeccion.getValueAt(tblSeccion. getSelectedRow(),1).toString());
				panelOferta.setVisible(false);
				panelCurso.setVisible(true);
				listarOfertaCurso();
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
}

