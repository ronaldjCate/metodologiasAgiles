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




public class FromPrincipalAdmProgHor extends JInternalFrame implements ActionListener, KeyListener,MouseListener {

	private JFrame frame;
	
	String descripcionnive="";
	String descripciongrado="";
	String descripcionDia="";
	String descripcionTurno="";
	String descripcionDocente="";
	String descripcionSeccion="";
	String descripcionCurso="";
	
	private JPanel contentPane;
	private JComboBox<String> cboturno;
	private JButton btnSalir;
	private JButton btnRegistrar;
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
	private JTextField txthorainicio;
	private JTextField txthorafin;
	private JPanel panelSeccion;
	private JPanel panelcursos;
	private JPanel panelturnos;
	private JPanel paneldocentes;
	private JPanel panel_3;
	private JDateChooser calendarinicio;
	private JDateChooser calendarfin;
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
	
	private JTextField txttdescripcionhorario;
	private JComboBox<String> cbodia;
	private JLabel lblNivel;
	private JComboBox<String> cbonivel;
	private JLabel lblGrado;
	private JComboBox<String> cbogrado;
	private JTextField txtcodhorario;
	private JButton btnRegistrarCurso;
	private JTextField txtperiodo;
	private JPanel paneldetallelistado;
	private JPanel paneldetalle;
	private JTextField txtprecio;
	private JLabel lbldia;
	private JLabel lblHorarioFin;
	private JLabel lblHorario;
	private JLabel lblDocente;
	private JLabel lblCodSeccion;
	private JLabel lblCurso;
	private JLabel lblPeriodo;
	private JLabel lblTurno;
	private JLabel lblTipoHor;
	private JButton btnnuevo;
	JTextField txtcodacceso;
	private JComboBox cboDocente;
	private JComboBox cboSeccion;
	private JComboBox cboCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromPrincipalAdmProgHor window = new FromPrincipalAdmProgHor();
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
	public FromPrincipalAdmProgHor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Programación de Horarios");
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
		
		panelturnos = new JPanel();
		panelturnos.setBackground(Color.GRAY);
		panelturnos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Turnos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 51, 255)));
		panelturnos.setBounds(10, 11, 340, 188);
		contentPane.add(panelturnos);
		panelturnos.setLayout(null);
		
		calendarinicio = new JDateChooser();
		calendarinicio.setBounds(10, 34, 95, 20);
		panelturnos.add(calendarinicio);
		
		calendarfin = new JDateChooser();
		calendarfin.setBounds(115, 34, 95, 20);
		panelturnos.add(calendarfin);
		
		lblTipoHor = new JLabel("TIPO HOR");
		lblTipoHor.setForeground(Color.ORANGE);
		lblTipoHor.setBounds(10, 127, 78, 14);
		panelturnos.add(lblTipoHor);
		
		txttdescripcionhorario = new JTextField();
		txttdescripcionhorario.setText("Curso Libre");
		txttdescripcionhorario.setEditable(false);
		txttdescripcionhorario.setBounds(78, 124, 228, 20);		
		panelturnos.add(txttdescripcionhorario);
		txttdescripcionhorario.setColumns(10);
		
		lblNivel = new JLabel("Nivel");
		lblNivel.setForeground(Color.ORANGE);
		lblNivel.setBounds(10, 65, 52, 14);
		panelturnos.add(lblNivel);
		
		cbonivel = new JComboBox<String>();
		cbonivel.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione", "B\u00E1sico", "Intermedio", "Avanzado"}));
		cbonivel.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
            	descripcionnive=event.getItem().toString(); 
            }
        });
		cbonivel.setBounds(78, 62, 228, 20);
		panelturnos.add(cbonivel);
		
		lblGrado = new JLabel("Grado");
		lblGrado.setForeground(Color.ORANGE);
		lblGrado.setBounds(10, 96, 46, 14);
		panelturnos.add(lblGrado);
		
		cbogrado = new JComboBox<String>();
		cbogrado.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione", "Secci\u00F3n 1", "Secci\u00F3n 2", "Secci\u00F3n 3", "Secci\u00F3n 4"}));
		cbogrado.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
            	descripciongrado=event.getItem().toString();
            }
        });
		cbogrado.setBounds(78, 93, 228, 20);
		panelturnos.add(cbogrado);
		
		lblFIni = new JLabel("F INI");
		lblFIni.setForeground(Color.ORANGE);
		lblFIni.setBounds(10, 18, 65, 14);
		panelturnos.add(lblFIni);
		
		lblFFin = new JLabel("F FIN");
		lblFFin.setForeground(Color.ORANGE);
		lblFFin.setBounds(115, 18, 60, 14);
		panelturnos.add(lblFFin);
		
		btnRegistrar = new JButton("");
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setBorder(null);
		btnRegistrar.setEnabled(false);
		btnRegistrar.setBounds(169, 153, 171, 30);
		panelturnos.add(btnRegistrar);
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrar.setIcon(new ImageIcon(FromPrincipalAdmProgHor.class.getResource("/imagenes/guardar.png")));
		
		lblPeriodo = new JLabel("PERIODO");
		lblPeriodo.setForeground(Color.ORANGE);
		lblPeriodo.setBounds(220, 18, 86, 14);
		panelturnos.add(lblPeriodo);
		
		txtperiodo = new JTextField();
		txtperiodo.setBackground(Color.WHITE);
		txtperiodo.setForeground(Color.MAGENTA);
		txtperiodo.setBounds(220, 34, 86, 20);
		panelturnos.add(txtperiodo);
		txtperiodo.setColumns(10);
		
		btnnuevo = new JButton("");
		btnnuevo.setContentAreaFilled(false);
		btnnuevo.setBorderPainted(false);
		btnnuevo.setBorder(null);
		btnnuevo.setIcon(new ImageIcon(FromPrincipalAdmProgHor.class.getResource("/imagenes/agregar.png")));
		btnnuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnRegistrar.setEnabled(true);
				limpiarcabecera();
				limpiardetalle();
				deshabilitarcabecera(true);
				deshabilitardetalle(false);
				muestraFecha();
				
			}
		});
		btnnuevo.setBackground(Color.WHITE);
		btnnuevo.setBounds(0, 152, 171, 30);
		panelturnos.add(btnnuevo);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 51, 255)));
		panel_3.setBounds(374, 525, 650, 51);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////
		
		btnSalir = new JButton("");
		btnSalir.setBounds(564, -13, 86, 85);
		panel_3.add(btnSalir);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setBorder(null);
		btnSalir.setIcon(new ImageIcon(FromPrincipalAdmProgHor.class.getResource("/imagenes/salir.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		panelListado = new JPanel();
		panelListado.setForeground(Color.BLACK);
		panelListado.setBackground(Color.GRAY);
		panelListado.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panelListado.setBounds(374, 11, 650, 235);
		contentPane.add(panelListado);
		panelListado.setLayout(null);
		
		
		scrollPanehorario = new JScrollPane();
		scrollPanehorario.setBounds(32, 32, 593, 181);
		panelListado.add(scrollPanehorario);
		
		tblHorario = new JTable();
		tblHorario_1 = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){
				 return false;
			 }
		 };
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
		
		paneldetalle = new JPanel();
		paneldetalle.setForeground(Color.RED);
		paneldetalle.setBackground(Color.GRAY);
		paneldetalle.setEnabled(false);
		paneldetalle.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalle", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		paneldetalle.setBounds(10, 205, 340, 378);
		contentPane.add(paneldetalle);
		paneldetalle.setLayout(null);		
		
		lbldia = new JLabel("DIA");
		lbldia.setForeground(Color.ORANGE);
		lbldia.setBounds(10, 29, 52, 14);
		paneldetalle.add(lbldia);
		
		cbodia = new JComboBox<String>();
		cbodia.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
            	descripcionDia=event.getItem().toString(); 
            }
        });
		cbodia.setBounds(83, 28, 228, 20);
		paneldetalle.add(cbodia);
		cbodia.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccionar", "Lunes", "Martes", "Mi\u00E9rcoles", "Jueves", "Viernes", "S\u00E1bado", "Domingo"}));
		
		lblHorario = new JLabel("HORARIO INIC");
		lblHorario.setForeground(Color.ORANGE);
		lblHorario.setBounds(10, 116, 78, 14);
		paneldetalle.add(lblHorario);
		
		txthorainicio = new JTextField();
		txthorainicio.setBounds(98, 113, 60, 20);
		paneldetalle.add(txthorainicio);
		txthorainicio.setColumns(10);
		
		lblHorarioFin = new JLabel("HORARIO FIN");
		lblHorarioFin.setForeground(Color.ORANGE);
		lblHorarioFin.setBounds(162, 116, 78, 14);
		paneldetalle.add(lblHorarioFin);
		
		txthorafin = new JTextField();
		txthorafin.setBounds(250, 113, 60, 20);
		paneldetalle.add(txthorafin);
		txthorafin.setColumns(10);
		
		btnRegistrarCurso = new JButton("");
		btnRegistrarCurso.setContentAreaFilled(false);
		btnRegistrarCurso.setBorderPainted(false);
		btnRegistrarCurso.setBorder(null);
		btnRegistrarCurso.setIcon(new ImageIcon(FromPrincipalAdmProgHor.class.getResource("/imagenes/guardar.png")));
		btnRegistrarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrardetallehorario();
			}
		});
		btnRegistrarCurso.setBackground(Color.WHITE);
		btnRegistrarCurso.setBounds(115, 333, 80, 38);
		paneldetalle.add(btnRegistrarCurso);
		
		paneldocentes = new JPanel();
		paneldocentes.setBackground(Color.GRAY);
		paneldocentes.setForeground(Color.BLACK);
		paneldocentes.setBounds(10, 153, 320, 55);
		paneldetalle.add(paneldocentes);
		
		paneldocentes.setBorder(new TitledBorder(null, "Docente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 51, 255)));
		paneldocentes.setLayout(null);
		
		lblDocente = new JLabel("DOCENTE");
		lblDocente.setForeground(Color.ORANGE);
		lblDocente.setBounds(10, 24, 78, 14);
		paneldocentes.add(lblDocente);
		
		cboDocente = new JComboBox();
		cboDocente.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
            	descripcionDocente=(event.getItem().toString());
            }
        });
		cboDocente.setBounds(86, 21, 197, 20);
		paneldocentes.add(cboDocente);
		
		panelSeccion = new JPanel();
		panelSeccion.setBackground(Color.GRAY);
		panelSeccion.setForeground(Color.BLACK);
		panelSeccion.setBounds(10, 219, 320, 55);
		paneldetalle.add(panelSeccion);
		panelSeccion.setBorder(new TitledBorder(null, "Seccion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 51, 204)));
		panelSeccion.setLayout(null);
		////////////////////////////////////////////////////
		////////////////////////////////////////////////////
		////////////////////////////////////////////////////
		
		
		lblCodSeccion = new JLabel("SECCION");
		lblCodSeccion.setForeground(Color.ORANGE);
		lblCodSeccion.setBounds(10, 27, 78, 14);
		panelSeccion.add(lblCodSeccion);
		
		cboSeccion = new JComboBox();
		cboSeccion.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
            	descripcionSeccion=(event.getItem().toString());
            }
        });
		cboSeccion.setBounds(85, 21, 199, 20);
		panelSeccion.add(cboSeccion);
		
		panelcursos = new JPanel();
		panelcursos.setBackground(Color.GRAY);
		panelcursos.setForeground(Color.BLACK);
		panelcursos.setBounds(10, 280, 320, 50);
		paneldetalle.add(panelcursos);
		panelcursos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Curso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 51, 255)));
		panelcursos.setLayout(null);
		
		lblCurso = new JLabel("CURSO");
		lblCurso.setForeground(Color.ORANGE);
		lblCurso.setBounds(10, 23, 67, 14);
		panelcursos.add(lblCurso);
		
		cboCurso = new JComboBox();
		cboCurso.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
            	descripcionCurso=(event.getItem().toString());
            }
        });
		cboCurso.setBounds(87, 20, 197, 20);
		panelcursos.add(cboCurso);
		
		lblTurno = new JLabel("TURNO");
		lblTurno.setForeground(Color.ORANGE);
		lblTurno.setBounds(10, 73, 46, 14);
		paneldetalle.add(lblTurno);
		
		cboturno = new JComboBox<String>();
		cboturno.setBounds(83, 70, 228, 20);
		paneldetalle.add(cboturno);
		cboturno.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
            	descripcionTurno=(event.getItem().toString());
            }
        });
		cboturno.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccionar", "1-Ma\u00F1ana", "2-Tarde", "3-Noche"}));
		
		paneldetallelistado = new JPanel();
		paneldetallelistado.setForeground(Color.BLACK);
		paneldetallelistado.setBorder(new TitledBorder(null, "Detalle", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		paneldetallelistado.setBackground(Color.GRAY);
		paneldetallelistado.setBounds(374, 269, 650, 245);
		contentPane.add(paneldetallelistado);
		paneldetallelistado.setLayout(null);
		
		scrollPanehorariodet = new JScrollPane();
		scrollPanehorariodet.setBounds(32, 32, 592, 181);
		paneldetallelistado.add(scrollPanehorariodet);
		
		tblHorariodet = new JTable();
		tblHorariodet_1 = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){
				 return false;
			 }
		 };
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
		
		
		llenacomboDocente();
		llenacomboSeccion();
		llenacomboCursos();
	}
	
	ProgramacionHorario acsd = new ProgramacionHorario();
	GestionProgHorarios gcsd = new GestionProgHorarios();
	private JLabel lblFIni;
	private JLabel lblFFin;
	
	void llenacomboDocente(){		
		ArrayList<Persona> lista = gcsd.listadoDocenteCombo();
		cboDocente.addItem("Seleccione");
		for (Persona t : lista) {
			cboDocente.addItem(t.getNombreDni());			
		}		
	}
	
	void llenacomboSeccion(){		
		ArrayList<Seccion> lista = gcsd.listadoSeccionCombo();
		cboSeccion.addItem("Seleccione");
		for (Seccion t : lista) {
			cboSeccion.addItem(t.getNombreSeccion());			
		}		
	}
	
	void llenacomboCursos(){		
		ArrayList<Cursos> lista = gcsd.listadoCursoCombo();
		cboCurso.addItem("Seleccione");
		for (Cursos t : lista) {
			cboCurso.addItem(t.getNombrecurso());			
		}		
	}
	
	
	void limpiarcabecera(){
		calendarinicio.setCalendar(null);
		calendarfin.setCalendar(null);
		txtperiodo.setText("");		
	
		cbonivel.setSelectedIndex(0);
		cbogrado.setSelectedIndex(0);
	}
	
	void listarprogramacion(){
		String idseleccionado = txttdescripcionhorario.getText();
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
		calendarfin.setEnabled(t);
		calendarinicio.setEnabled(t);
		txtperiodo.setEditable(false);		
		cbonivel.setEnabled(t);
		cbogrado.setEnabled(t);		

		lblFFin.setEnabled(t);
		lblFIni.setEnabled(t);
		lblHorarioFin.setEnabled(t);
		lblHorario.setEnabled(t);
		lblPeriodo.setEnabled(t);
		lblTipoHor.setEnabled(t);		
		lblNivel.setEnabled(t);
		lblGrado.setEnabled(t);
	}
	
	void muestraFecha() {
		
		// 1. Capturar la fecha del sistema		
		Date fecha = new Date(); // fecha y hora
		Date fecha2 = new Date();
		// 2. poner la fecha en el txt
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdfm = new SimpleDateFormat("MM");
		txtperiodo.setText("UPC"+sdf.format(fecha)+sdfm.format(fecha2));
	}
	
	void limpiardetalle(){
		
		cbodia.setSelectedIndex(0);		
		cboturno.setSelectedIndex(0);
		txthorafin.setText("");
		txthorainicio.setText("");	
		cboDocente.setSelectedIndex(0);
		cboSeccion.setSelectedIndex(0);
		cboCurso.setSelectedIndex(0);				
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
	

	String leerfechaini(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(calendarinicio.getDate());
	}
	String leerfechafin(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(calendarfin.getDate());
	}
	String leerperiodo(){
		return txtperiodo.getText();
	}
	String leertipohorario(){
		return txttdescripcionhorario.getText(); 
	}
	
	int leercodusuario(){
		return Integer.parseInt(txtcodacceso.getText());
	}
	
	void registrar(){
			
		String periodo,finicio,ffin,nivel,grado;
		
		periodo=leerperiodo();
		finicio=leerfechaini();
		ffin=leerfechafin();
		nivel=descripcionnive;
		grado=descripciongrado;
		
		
		acsd.setPeriodo(periodo);
		acsd.setFechainicio(finicio);
		acsd.setFechafin(ffin);		
		acsd.setNivel(nivel);
		acsd.setGrado(grado);							
		
		GestionProgHorarios gcsd = new GestionProgHorarios();
		int ok = gcsd.registrar(acsd);
		if(ok==0){
			System.out.println("Error al registrar");
		}else{
			JOptionPane.showMessageDialog(null, "Registrado Correctamente");
		}
		txtcodhorario.setText(""+gcsd.buscarultcodhorario());
		panelListado.setEnabled(true);
		listarprogramacion();
		deshabilitardetalle(true);
		deshabilitarcabecera(false);
		btnRegistrar.setEnabled(false);
	}
	
	void deshabilitardetalle(boolean t){
		paneldetalle.setEnabled(t);
		paneldocentes.setEnabled(t);
		panelSeccion.setEnabled(t);
		panelcursos.setEnabled(t);
		lbldia.setEnabled(t);
		
		lblHorario.setEnabled(t);
		lblHorarioFin.setEnabled(t);
		lblDocente.setEnabled(t);	
		lblCodSeccion.setEnabled(t);
		lblCurso.setEnabled(t);
		lblTurno.setEnabled(t);
		cbodia.setEnabled(t);	
		cboturno.setEnabled(t);
		
		txthorafin.setEnabled(t);
		txthorainicio.setEnabled(t);	
		btnRegistrarCurso.setEnabled(t);
		
		cboDocente.setEnabled(t);
		cboSeccion.setEnabled(t);
		cboCurso.setEnabled(t);
		
	}
	
	
	int leercoddia(){
		return cbodia.getSelectedIndex();
	}	
	
	int leercodturno(){
		return cboturno.getSelectedIndex();
	}	
	int leercodHorario(){
		return Integer.parseInt(txtcodhorario.getText());
	}
	
	void registrardetallehorario(){
		//double precio;
		String coddocente,codseccion,codcurso;
		String dia,horaini,horafin,descriturno;
		int idtb_progHorario;
		
		idtb_progHorario=leercodHorario();
		dia = descripcionDia;						
		descriturno=descripcionTurno;
		horaini=txthorainicio.getText();
		horafin=txthorafin.getText();
		coddocente=descripcionDocente;
		codseccion = descripcionSeccion;
		codcurso=descripcionCurso;
		System.out.println("codigo Hora:"+idtb_progHorario+" "+"dia:"+dia+" "+"turno:"+descriturno+" "+"Hora inicio:"+horaini);
		System.out.println("Hora Fin:"+horafin+" "+"Docente:"+coddocente+" "+"codseccion:"+codseccion+" "+"codcurso:"+codcurso);
		
		
		ProgramacionHorarioDet d = new ProgramacionHorarioDet();
		
		d.setCodasocurdos(idtb_progHorario);
		d.setSeccion(codseccion);
		d.setCurso(codcurso);
		d.setDocente(coddocente);
		d.setHoraini(horaini);
		d.setHorafin(horafin);
		d.setDiainicio(dia);
		d.setTutnomatricula(descriturno);							
		
		GestionProgHorarios det = new GestionProgHorarios();
		int ok = det.registrardetalle(d);
		if(ok==0){
			System.out.println("Error al Registrar los cursos");
		}else{
			JOptionPane.showMessageDialog(null, "Horario Registrado correctamente");	
			modeloHorariodet.setRowCount(0);
		}
		limpiardetalle();							
																		
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
				limpiarcabecera();
				limpiardetalle();
				cboturno.setEnabled(true);
				btnRegistrar.setEnabled(false);
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
