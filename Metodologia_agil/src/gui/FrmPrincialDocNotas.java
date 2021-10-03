package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import clases.Notas;
import mantenimientos.GestionNotas;



public class FrmPrincialDocNotas extends JInternalFrame implements ActionListener, KeyListener,MouseListener{

	private JFrame frame;
	private JDesktopPane desktopPane;
	private JPanel contentPane;
	
	private JPanel panel;
	private JLabel lblCicloAcadmico;
	private JComboBox<String> cbocicloacademico;
	
	private JScrollPane scrollPaneMatricula;
	private JTable tblMatricula;
	private DefaultTableModel modeloMatricula;
	
	private JScrollPane scrollPaneMatriculadet;
	private JTable tblMatriculadet;
	private DefaultTableModel modeloMatriculadet;
	
	JTextField txtusuarioPrincipal;
	
	private JLabel lblListadoDeAlumnos;
	private JLabel lblcurso;
	private JLabel lblDe;
	private JLabel lblnivel;
	private JLabel lblEnEl;
	private JLabel lblperiodo;
	
	private JCheckBox chckbxSeleccionarParaRegistrar;
	
	private JPanel panel_1;
	private JLabel lblUsuario;
	JLabel Lblcodusuario;
	private JLabel lblNombreUsuario;
	JLabel lblLblnombreusuariolog;
	JLabel lblCodacceso;

	private JButton btnSalir;
	
	String descripcionPeriodo="";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincialDocNotas window = new FrmPrincialDocNotas();
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
	public FrmPrincialDocNotas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mantenimiento de Personas");
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
		
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW));
		panel.setBackground(Color.WHITE);
		panel.setBounds(22, 23, 793, 264);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		lblCicloAcadmico = new JLabel("Ciclo Acad\u00E9mico");
		lblCicloAcadmico.setBounds(34, 39, 108, 14);
		panel.add(lblCicloAcadmico);
		
		cbocicloacademico = new JComboBox<String>();
		cbocicloacademico.setBounds(148, 36, 140, 20);
		cbocicloacademico.addItemListener(event -> {
		    	if (event.getStateChange() == ItemEvent.SELECTED) {
		        	//txtperiodo.setText(event.getItem().toString());
		        	descripcionPeriodo=(event.getItem().toString());
		        	listarPagoInscripcion();
		        }
		    });
		panel.add(cbocicloacademico);
		
		
		scrollPaneMatricula = new JScrollPane();
		scrollPaneMatricula.setBounds(25, 83, 310, 160);
		panel.add(scrollPaneMatricula);
		
		tblMatricula = new JTable();
		tblMatricula = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){
				 return false;
			 }
		 };
		 tblMatricula.addMouseListener(this);				
		scrollPaneMatricula.setViewportView(tblMatricula);		
		
		modeloMatricula= new DefaultTableModel();
		modeloMatricula.addColumn("ID CURSO");
		modeloMatricula.addColumn("CURSO");
		modeloMatricula.addColumn("SECCION");
		tblMatricula.setModel(modeloMatricula);
		
		
		scrollPaneMatriculadet = new JScrollPane();
		scrollPaneMatriculadet.setBounds(365, 82, 380, 160);
		panel.add(scrollPaneMatriculadet);
		
		tblMatriculadet = new JTable();
		tblMatriculadet = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){
				 return false;
			 }
		 };
		 tblMatriculadet.addMouseListener(this);				
		scrollPaneMatriculadet.setViewportView(tblMatriculadet);		
		
		modeloMatriculadet= new DefaultTableModel();
		modeloMatriculadet.addColumn("CURSO");
		modeloMatriculadet.addColumn("ID ALUMNO");
		modeloMatriculadet.addColumn("ALUMNO");
		modeloMatriculadet.addColumn("PROMEDIO");
		modeloMatriculadet.addColumn("ESTADO");
		tblMatriculadet.setModel(modeloMatriculadet);
		
		txtusuarioPrincipal = new JTextField();
		txtusuarioPrincipal.setVisible(false);
		txtusuarioPrincipal.setBounds(254, 8, 56, 20);
		panel.add(txtusuarioPrincipal);
		txtusuarioPrincipal.setColumns(10);
		
		lblListadoDeAlumnos = new JLabel("Listado de Alumnos Matriculados en el curso de");
		lblListadoDeAlumnos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListadoDeAlumnos.setForeground(Color.BLUE);
		lblListadoDeAlumnos.setBounds(365, 11, 290, 14);
		lblListadoDeAlumnos.setVisible(false);
		panel.add(lblListadoDeAlumnos);
		
		lblcurso = new JLabel("New label");
		lblcurso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblcurso.setForeground(Color.RED);
		lblcurso.setBounds(646, 10, 133, 14);
		lblcurso.setVisible(false);
		panel.add(lblcurso);
		
		lblDe = new JLabel("en la Secci\u00F3n");
		lblDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDe.setForeground(Color.BLUE);
		lblDe.setBounds(365, 29, 101, 14);
		panel.add(lblDe);
		
		lblnivel = new JLabel("New label");
		lblnivel.setForeground(Color.RED);
		lblnivel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnivel.setBounds(476, 29, 75, 14);
		panel.add(lblnivel);
		
		lblEnEl = new JLabel("en el Periodo");
		lblEnEl.setForeground(Color.BLUE);
		lblEnEl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnEl.setBounds(569, 29, 98, 14);
		panel.add(lblEnEl);
		
		lblperiodo = new JLabel("New label");
		lblperiodo.setForeground(Color.RED);
		lblperiodo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblperiodo.setBounds(664, 29, 119, 14);
		panel.add(lblperiodo);
		
		chckbxSeleccionarParaRegistrar = new JCheckBox("Seleccionar para Registrar Nota");
		chckbxSeleccionarParaRegistrar.setBackground(Color.WHITE);
		chckbxSeleccionarParaRegistrar.addActionListener(this);
		chckbxSeleccionarParaRegistrar.setBounds(365, 49, 290, 23);
		panel.add(chckbxSeleccionarParaRegistrar);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(22, 313, 793, 75);
		desktopPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblUsuario = new JLabel("Usuario ");
		lblUsuario.setBounds(46, 32, 78, 14);
		panel_1.add(lblUsuario);
		
		Lblcodusuario = new JLabel("lblusuario");
		Lblcodusuario.setForeground(Color.BLUE);
		Lblcodusuario.setBounds(146, 32, 134, 14);
		panel_1.add(Lblcodusuario);
		
		lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setBounds(283, 32, 108, 14);
		panel_1.add(lblNombreUsuario);
		
		lblLblnombreusuariolog = new JLabel("lblnombreusuariolog");
		lblLblnombreusuariolog.setForeground(Color.BLUE);
		lblLblnombreusuariolog.setBounds(404, 32, 172, 14);
		panel_1.add(lblLblnombreusuariolog);
		
		lblCodacceso = new JLabel("codacceso");
		lblCodacceso.setVisible(false);
		lblCodacceso.setBounds(554, 32, 100, 14);
		panel_1.add(lblCodacceso);
		
		btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(FrmPrincialDocNotas.class.getResource("/imagenes/salir.png")));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(675, 16, 55, 40);
		panel_1.add(btnSalir);
		
		llenacombo();
		visiblealumnos(false);
		
	}
	
	GestionNotas gr = new GestionNotas();
	
	
	void listarPagoInscripcion(){
		String usuarioLogueado=txtusuarioPrincipal.getText();
		String periodo = descripcionPeriodo;
		System.out.println(usuarioLogueado);
		ArrayList<Notas>lista=gr.listadocursoNota(usuarioLogueado,periodo);
		if(lista==null){
			System.out.println("nada");
		}else{
			modeloMatricula.setRowCount(0);
			for(Notas p:lista){
				Object[]fila={
						p.getCodCurso(),
						p.getCurso(),
						p.getCodSeccion()
				}; modeloMatricula.addRow(fila);
			}
		}
	}
	
	void visiblealumnos(boolean t){
		lblListadoDeAlumnos.setVisible(t);
		lblcurso.setVisible(t);
		lblDe.setVisible(t);
		lblnivel.setVisible(t);
		lblEnEl.setVisible(t);
		lblperiodo.setVisible(t);
		chckbxSeleccionarParaRegistrar.setVisible(t);
	}
	
	void llenacombo(){
		ArrayList<Notas> lista = gr.listadocombo();
		cbocicloacademico.addItem("Seleccione");
		for (Notas t : lista) {
			cbocicloacademico.addItem(t.getPeriodo());				
		}	
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	void visiblenotas(boolean t){
		
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
		if(chckbxSeleccionarParaRegistrar.isSelected()==false){
			if(e.getClickCount()==2){
				lblcurso.setText(tblMatricula.getValueAt(tblMatricula. getSelectedRow(),1).toString());
				lblperiodo.setText(descripcionPeriodo);
				lblnivel.setText(tblMatricula.getValueAt(tblMatricula. getSelectedRow(),2).toString());
				visiblealumnos(true);
				listadoalumnosmatriculados();
				
			}
		}
		if(chckbxSeleccionarParaRegistrar.isSelected()==true){
			if(e.getClickCount()==2){				
				
				PopupRegistroNotas rgn= new PopupRegistroNotas();
				rgn.lblcodusuario.setText(""+Lblcodusuario.getText());
				rgn.lblnombreusuario.setText(lblLblnombreusuariolog.getText());
				rgn.lblLblcodacceso.setText(""+lblCodacceso.getText());
				rgn.lblLblcurso.setText(""+lblcurso.getText());
				rgn.lblLblperiodo.setText(""+lblperiodo.getText());
				rgn.lblLblnivel.setText(""+lblnivel.getText());
				desktopPane.add(rgn);
				Dimension desktopSize=desktopPane.getSize();
				Dimension FrameSize= rgn.getSize();
				rgn.setLocation((desktopSize.width-FrameSize.width)/2, 1/(desktopSize.height-FrameSize.height/1));
				rgn.setVisible(true);				
				visiblenotas(true);
				rgn.lblcodmiembro.setText(tblMatriculadet.getValueAt(tblMatriculadet. getSelectedRow(),1).toString());
				rgn.lblnombrealumno.setText(tblMatriculadet.getValueAt(tblMatriculadet. getSelectedRow(),2).toString());
				chckbxSeleccionarParaRegistrar.setSelected(false);
				rgn.mostrarnotasdetalle();
				
			}
		}
		
	}
	
	double nota=0;
	String situacion="";
	
	void listadoalumnosmatriculados(){
		String curso=lblcurso.getText();
		String periodo=lblperiodo.getText();
		String seccion =lblnivel.getText();
		ArrayList<Notas>lista=gr.listadoalumnos(curso, periodo, seccion);
		if(lista==null){
			
		}else{
			modeloMatriculadet.setRowCount(0);
			for(Notas p:lista){
				
				nota = Double.parseDouble(""+p.getPromedio());
				
				if(nota>=13){		 
					situacion="Aprobado";
				}else if(nota>0 && nota <=12){
					situacion="Desaprobado";
				}else{
					situacion="Sin Nota";
				}
				Object[]fila={
						p.getCurso(),
						p.getUsuAlumno(),
						
						p.getAlumno(),
						nota,
						situacion
				}; modeloMatriculadet.addRow(fila);
			}
			CorNaLinha();
		}
	}

	String CLASS= "";
	String CLASS2="";

	public void CorNaLinha(){
		CLASS = "Aprobado";
		CLASS2="Desaprobado";
		tblMatriculadet.setDefaultRenderer(Object.class,new DefaultTableCellRenderer(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean
					 hasFocus, int row, int column){;
					JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
					
					Color c = Color.GREEN;
					Object texto = table.getValueAt(row,4);
					if(texto != null && CLASS.equals(texto.toString()))
						c = Color.BLUE;
					else if(texto != null && CLASS2.equals(texto.toString()))
						c = Color.RED;
					
					label.setForeground(c);
					tblMatriculadet.setSelectionForeground(Color.blue);
					
					return label;
			}
		});
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
		
	}

}
