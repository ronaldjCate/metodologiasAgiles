package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import clases.Cursos;
import clases.Persona;
import clases.ProgramacionHorario;
import clases.ProgramacionHorarioDet;
import clases.Seccion;
import mantenimientos.GestionProgHorarios;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;




public class FromPrincipalAlumHoraDisponible extends JInternalFrame implements ActionListener, KeyListener,MouseListener {

	private JFrame frame;
	
	String descripcionnive="";
	String descripciongrado="";
	String descripcionDia="";
	String descripcionTurno="";
	String descripcionDocente="";
	String descripcionSeccion="";
	String descripcionCurso="";
	
	private JPanel contentPane;
	private JButton btnSalir;
	private DefaultTableModel modeloCurso;
	private DefaultTableModel modeloUsuario;
	private DefaultTableModel modeloSeccion;
	private DefaultTableModel modelohorariom;
	private DefaultTableModel modelohorariot;
	private DefaultTableModel modelohorarion;
	private JTable tblUsuario;
	private JTable tblSeccion;
	private JTable tblCurso;
	private JTable tblHorariom;
	private JTable tblHorariot;
	private JTable tblHorarion;
	private JPanel panel_3;
	private JPanel panelListado;
	private DefaultTableModel modeloApoyo;
	private JTable tblApoyo;
	
	private JScrollPane scrollPanehorario;
	private DefaultTableModel modeloHorario;
	private JTable tblHorario;
	private JTable tblHorario_1;
	
	private JScrollPane scrollPanehorariodet;
	private JTable tblHorariodet;
	private JTable tblHorariodet_1;
	private DefaultTableModel modeloHorariodet;
	private JTextField txtcodhorario;
	private JPanel paneldetallelistado;
	private JTextField txtprecio;
	JTextField txtcodacceso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromPrincipalAlumHoraDisponible window = new FromPrincipalAlumHoraDisponible();
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
	public FromPrincipalAlumHoraDisponible() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Horarios Disponibles");
		setBounds(100, 100, 1064, 623);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tblUsuario = new JTable();
		modeloUsuario= new DefaultTableModel();
		modeloUsuario.addColumn("CODIGO");
		modeloUsuario.addColumn("CARGO");
		modeloUsuario.addColumn("NOMBRE");
		tblApoyo = new JTable();
		modeloApoyo= new DefaultTableModel();
		modeloApoyo.addColumn("CODIGO");
		modeloApoyo.addColumn("CARGO");
		modeloApoyo.addColumn("NOMBRE");
		tblCurso = new JTable();
		modeloCurso= new DefaultTableModel();
		modeloCurso.addColumn("CODIGO");
		modeloCurso.addColumn("NOMBRE");
		modeloCurso.addColumn("Precio");
		tblSeccion = new JTable();
		modeloSeccion= new DefaultTableModel();
		modeloSeccion.addColumn("CODIGO");
		modeloSeccion.addColumn("NOMBRE SECCIÓN");		
		modeloSeccion.addColumn("CANTIDAD MÁX");
		modeloSeccion.addColumn("CANTIDAD MIN");
		tblHorariom = new JTable();
		modelohorariom= new DefaultTableModel();
		modelohorariom.addColumn("HORA INICIO");
		modelohorariom.addColumn("HORA FIN");
		modelohorariom.addRow(new Object[]{"8:00","9:00"});
		modelohorariom.addRow(new Object[]{"9:00","10:00"});
		modelohorariom.addRow(new Object[]{"10:00","11:00"});
		modelohorariom.addRow(new Object[]{"11:00","12:00"});
		modelohorariom.addRow(new Object[]{"12:00","13:00"});
		tblHorariot = new JTable();
		modelohorariot= new DefaultTableModel();
		modelohorariot.addColumn("HORA INCIO");
		modelohorariot.addColumn("HORA FIN");
		modelohorariot.addRow(new Object[]{"13:00","14:00"});
		modelohorariot.addRow(new Object[]{"14:00","15:00"});
		modelohorariot.addRow(new Object[]{"15:00","16:00"});
		modelohorariot.addRow(new Object[]{"16:00","17:00"});
		modelohorariot.addRow(new Object[]{"17:00","18:00"});
		tblHorarion = new JTable();
		modelohorarion= new DefaultTableModel();
		modelohorarion.addColumn("HORA INCIO");
		modelohorarion.addColumn("HORA FIN");
		modelohorarion.addRow(new Object[]{"18:00","19:00"});
		modelohorarion.addRow(new Object[]{"19:00","20:00"});
		modelohorarion.addRow(new Object[]{"20:00","21:00"});
		modelohorarion.addRow(new Object[]{"21:00","22:00"});
		modelohorarion.addRow(new Object[]{"22:00","23:00"});
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		panel_3.setBounds(39, 525, 985, 51);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////
		
		btnSalir = new JButton("");
		btnSalir.setBounds(764, -18, 86, 85);
		panel_3.add(btnSalir);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setBorder(null);
		btnSalir.setIcon(new ImageIcon(FromPrincipalAlumHoraDisponible.class.getResource("/imagenes/salir.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		panelListado = new JPanel();
		panelListado.setForeground(Color.BLACK);
		panelListado.setBackground(Color.GRAY);
		panelListado.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		panelListado.setBounds(39, 11, 985, 235);
		contentPane.add(panelListado);
		panelListado.setLayout(null);
		
		
		scrollPanehorario = new JScrollPane();
		scrollPanehorario.setBounds(32, 32, 923, 181);
		panelListado.add(scrollPanehorario);
		
		tblHorario = new JTable();
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
		modeloHorario.addColumn("ID");
		modeloHorario.addColumn("TIPO");
		modeloHorario.addColumn("NIVEL");
		modeloHorario.addColumn("GRADO");
		modeloHorario.addColumn("PERIODO");
		modeloHorario.addColumn("FECHA INI");
		modeloHorario.addColumn("FECHA FIN");
		tblHorario_1.setModel(modeloHorario);
		
		txtcodhorario = new JTextField();
		txtcodhorario.setVisible(false);
		txtcodhorario.setBounds(740, 572, 86, 20);
		contentPane.add(txtcodhorario);
		txtcodhorario.setColumns(10);
		
		paneldetallelistado = new JPanel();
		paneldetallelistado.setForeground(Color.BLACK);
		paneldetallelistado.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		paneldetallelistado.setBackground(Color.GRAY);
		paneldetallelistado.setBounds(39, 269, 985, 245);
		contentPane.add(paneldetallelistado);
		paneldetallelistado.setLayout(null);
		
		scrollPanehorariodet = new JScrollPane();
		scrollPanehorariodet.setBounds(32, 32, 923, 181);
		paneldetallelistado.add(scrollPanehorariodet);
		
		tblHorariodet = new JTable();
		tblHorariodet_1 = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){
				 return false;
			 }
		 };
		tblHorariodet_1.setForeground(Color.ORANGE);
		tblHorariodet_1.setBackground(Color.GRAY);
		tblHorariodet_1.addMouseListener(this);
		tblHorariodet_1.setFillsViewportHeight(true);
		scrollPanehorariodet.setViewportView(tblHorariodet_1);
		
		modeloHorariodet= new DefaultTableModel();		
		modeloHorariodet.addColumn("DIA");
		modeloHorariodet.addColumn("HORA INI");
		modeloHorariodet.addColumn("HORA FIN");
		modeloHorariodet.addColumn("SECCIÓN");
		modeloHorariodet.addColumn("CURSO");
		modeloHorariodet.addColumn("DOCENTE");
		tblHorariodet_1.setModel(modeloHorariodet);

		
		txtprecio = new JTextField();
		txtprecio.setVisible(false);
		txtprecio.setBounds(750, 605, 86, 20);
		contentPane.add(txtprecio);
		txtprecio.setColumns(10);
		
		txtcodacceso = new JTextField();
		txtcodacceso.setVisible(false);
		txtcodacceso.setBounds(656, 539, 25, 20);
		contentPane.add(txtcodacceso);
		txtcodacceso.setColumns(10);
		

		listarprogramacion();
		deshabilitarcabecera(false);
		deshabilitardetalle(false);
		

	}
	
	ProgramacionHorario acsd = new ProgramacionHorario();
	GestionProgHorarios gcsd = new GestionProgHorarios();
	
	
	
	void listarprogramacion(){
		String idseleccionado = "Curso Libre";
		GestionProgHorarios gts = new GestionProgHorarios();
		ArrayList<ProgramacionHorario>lista=gts.listadogeneralannioescolar(idseleccionado);
		if(lista==null){
			
		}else{
			modeloHorario.setRowCount(0);
			for(ProgramacionHorario p :lista){
				Object[]fila={
						p.getIdasociacion(),
						p.getTipohorario(),	
						p.getNivel(),
						p.getGrado(),
						p.getPeriodo(),
						p.getFechainicio(),
						p.getFechafin()												
				};modeloHorario.addRow(fila);
				txtcodhorario.setText(""+p.getIdasociacion());
			}
		}
	}
	
	void deshabilitarcabecera(boolean t){
	}
	
	
	
	void listarprogramaciondetalle(){
		int idseleccionado = Integer.parseInt(txtcodhorario.getText());
		GestionProgHorarios gts = new GestionProgHorarios();
		ArrayList<ProgramacionHorarioDet>lista=gts.listadogeneralannioescolardetalle(idseleccionado);
		if(lista==null){
			
		}else{
			modeloHorariodet.setRowCount(0);
			for(ProgramacionHorarioDet p :lista){
				Object[]fila={						
						p.getDiainicio(),
						p.getHoraini(),
						p.getHorafin(),
						p.getSeccion(),
						p.getCurso(),
						p.getDocente()						
				};modeloHorariodet.addRow(fila);
			}
		}
	}
	

	
	
	int leercodusuario(){
		return Integer.parseInt(txtcodacceso.getText());
	}
	
	void deshabilitardetalle(boolean t){
		
	}
	
	
	
	int leercodHorario(){
		return Integer.parseInt(txtcodhorario.getText());
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		tblCurso = (JTable)arg0.getSource();
		tblSeccion = (JTable)arg0.getSource();
		
		Point point = arg0.getPoint();
		int row = tblUsuario.rowAtPoint(point);
		int row1 = tblSeccion.rowAtPoint(point);
		int row2 = tblCurso.rowAtPoint(point);


			if(arg0.getClickCount()==2){
				txtcodhorario.setText(tblHorario_1.getValueAt(tblHorario_1. getSelectedRow(),0).toString());
				listarprogramaciondetalle();
				deshabilitarcabecera(false);
				deshabilitardetalle(true);

			}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Initialize the contents of the frame.
	 */


}
