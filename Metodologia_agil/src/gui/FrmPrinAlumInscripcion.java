package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import clases.Inscripcion;
import clases.Notas;
import clases.ProgramacionHorarioDet;
import clases.Seccion;
import mantenimientos.GestionInscripcion;
import mantenimientos.GestionNotas;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Button;

public class FrmPrinAlumInscripcion extends JInternalFrame implements ActionListener, KeyListener,MouseListener{

	private JDesktopPane desktopPane;
	private JFrame frame;
	private JPanel contentPane;
	
	private JScrollPane scrollPanehorario;
	private DefaultTableModel modeloHorario;
	private JTable tblHorario_1;
	
	private JScrollPane scrollPanePago;
	private DefaultTableModel modeloPago;
	private JTable tblPago;
	private JLabel lblRecibo;
	private JTextField txtRecibo;
	private JComboBox cboFormaPago;
	private JPanel panelCurso;
	private JLabel lblEscogiElCurso;
	private JLabel lblCurso;
	private JLabel lblDictadaEnLa;
	private JLabel lblSeccion;
	private JLabel lblPorElDocente;
	private JLabel lbldocente;
	JTextField txtcodigoDetalle;
	private JLabel lblTieneUnCosto;
	JLabel lblCosto;
	
	double montoCurso = 0.0;
	double montoPagado=0.0;
	String usuarioLogueado="";
	
	String descripcionFormaPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrinAlumInscripcion window = new FrmPrinAlumInscripcion();
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
	public FrmPrinAlumInscripcion() {
		
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
		
		/*
		panel = new JPanel();
		panel.setBounds(32, 69, 980, 493);
		contentPane.add(panel);
		panel.setLayout(null);
		*/
		
		scrollPanehorario = new JScrollPane();
		scrollPanehorario.setBounds(32, 152, 253, 251);
		desktopPane.add(scrollPanehorario);
		
	
		tblHorario_1 = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){
				 return false;
			 }
		 };
		tblHorario_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		tblHorario_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		 tblHorario_1.setForeground(Color.ORANGE);
		 tblHorario_1.setBackground(new Color(128, 128, 128));
		 tblHorario_1.addMouseListener(this);
		 tblHorario_1.setFillsViewportHeight(true);
		scrollPanehorario.setViewportView(tblHorario_1);
		
		modeloHorario= new DefaultTableModel();		
		modeloHorario.addColumn("ID");
		modeloHorario.addColumn("CURSO");
		modeloHorario.addColumn("SECCION");
		modeloHorario.addColumn("DOCENTE");
		tblHorario_1.setModel(modeloHorario);
		
		
		
		scrollPanePago = new JScrollPane();
		scrollPanePago.setBounds(692, 152, 333, 251);
		desktopPane.add(scrollPanePago);
		
	
		tblPago = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){
				 return false;
			 }
		 };
		 tblPago.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		 tblPago.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		 tblPago.setForeground(Color.ORANGE);
		 tblPago.setBackground(new Color(128, 128, 128));
		 tblPago.addMouseListener(this);
		 tblPago.setFillsViewportHeight(true);
		 scrollPanePago.setViewportView(tblPago);
		
		modeloPago= new DefaultTableModel();		
		modeloPago.addColumn("CURSO");
		modeloPago.addColumn("SECCIÓN");
		modeloPago.addColumn("DOCENTE");
		modeloPago.addColumn("FORMA PAGO");
		modeloPago.addColumn("RECIBO");
		modeloPago.addColumn("MONTO");
		tblPago.setModel(modeloPago);
		
		panelCurso = new JPanel();
		panelCurso.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		panelCurso.setBackground(Color.LIGHT_GRAY);
		panelCurso.setBounds(315, 90, 346, 149);
		panelCurso.setVisible(false);
		desktopPane.add(panelCurso);
		panelCurso.setLayout(null);
		
		lblEscogiElCurso = new JLabel("Escogi\u00F3 el curso");
		lblEscogiElCurso.setBounds(20, 11, 130, 14);
		panelCurso.add(lblEscogiElCurso);
		
		lblCurso = new JLabel("New label");
		lblCurso.setVisible(false);
		lblCurso.setForeground(Color.RED);
		lblCurso.setBounds(138, 11, 198, 14);
		panelCurso.add(lblCurso);
		
		lblDictadaEnLa = new JLabel("dictada en la secci\u00F3n");
		lblDictadaEnLa.setBounds(20, 36, 141, 14);
		panelCurso.add(lblDictadaEnLa);
		
		lblSeccion = new JLabel("New label");
		lblSeccion.setForeground(Color.RED);
		lblSeccion.setVisible(false);
		lblSeccion.setBounds(172, 36, 164, 14);
		panelCurso.add(lblSeccion);
		
		lblPorElDocente = new JLabel("por el docente");
		lblPorElDocente.setBounds(20, 61, 130, 14);
		panelCurso.add(lblPorElDocente);
		
		lbldocente = new JLabel("New label");
		lbldocente.setForeground(Color.RED);
		lbldocente.setVisible(false);
		lbldocente.setBounds(160, 61, 176, 14);
		panelCurso.add(lbldocente);
		
		txtcodigoDetalle = new JTextField();
		txtcodigoDetalle.setBounds(250, 111, 86, 20);
		txtcodigoDetalle.setVisible(false);
		panelCurso.add(txtcodigoDetalle);
		txtcodigoDetalle.setColumns(10);
		
		lblTieneUnCosto = new JLabel("tiene un costo de");
		lblTieneUnCosto.setBounds(20, 86, 122, 14);
		panelCurso.add(lblTieneUnCosto);
		
		lblCosto = new JLabel("New label");
		lblCosto.setVisible(false);
		lblCosto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCosto.setForeground(Color.RED);
		lblCosto.setBounds(158, 86, 122, 14);
		panelCurso.add(lblCosto);

		
		btnpopuo = new JButton("Ver Detalle");	
		btnpopuo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnpopuo.setVisible(false);
		btnpopuo.setForeground(Color.BLUE);
		btnpopuo.setContentAreaFilled(false);
		btnpopuo.setBorderPainted(false);
		btnpopuo.setBorder(null);
		btnpopuo.setBackground(Color.WHITE);
		btnpopuo.addActionListener(this);
		btnpopuo.setBounds(105, 111, 149, 23);
		panelCurso.add(btnpopuo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(315, 250, 346, 153);
		desktopPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		panel_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblFormaDePago = new JLabel("Forma de Pago");
		lblFormaDePago.setBounds(25, 41, 101, 14);
		panel_1.add(lblFormaDePago);
		
		cboFormaPago = new JComboBox();
		cboFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Visa Tarjeta D\u00E9bito", "Visa Tarjeta Cr\u00E9dito", "Paypal"}));
		cboFormaPago.setBounds(136, 38, 164, 20);
		cboFormaPago.addItemListener(event -> {
		    	if (event.getStateChange() == ItemEvent.SELECTED) {
		        	//txtperiodo.setText(event.getItem().toString());
		    		descripcionFormaPago=(event.getItem().toString());
		        	//listadomatricula();
		        }
		    });
		panel_1.add(cboFormaPago);
		
		lblRecibo = new JLabel("Recibo");
		lblRecibo.setBounds(25, 69, 89, 14);
		panel_1.add(lblRecibo);
		
		txtRecibo = new JTextField();
		txtRecibo.setBounds(136, 66, 164, 20);
		txtRecibo.setEditable(false);
		panel_1.add(txtRecibo);
		txtRecibo.setColumns(10);
		
		btnPagoInscripcon = new JButton("Pagar");
		btnPagoInscripcon.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPagoInscripcon.setForeground(Color.BLUE);
		btnPagoInscripcon.setContentAreaFilled(false);
		btnPagoInscripcon.setBorderPainted(false);
		btnPagoInscripcon.addActionListener(this);
		btnPagoInscripcon.setBorder(null);
		btnPagoInscripcon.setBackground(Color.WHITE);
		btnPagoInscripcon.setEnabled(false);		
		btnPagoInscripcon.setBounds(52, 119, 89, 23);
		panel_1.add(btnPagoInscripcon);
		
		txtusuarioPrincipal = new JTextField();
		txtusuarioPrincipal.setVisible(false);
		txtusuarioPrincipal.setBounds(227, 97, 86, 20);
		panel_1.add(txtusuarioPrincipal);
		txtusuarioPrincipal.setColumns(10);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setBounds(25, 10, 46, 14);
		panel_1.add(lblPeriodo);
		
		txtxPeriodo = new JTextField();
		txtxPeriodo.setEditable(false);
		txtxPeriodo.setBounds(136, 7, 164, 20);
		panel_1.add(txtxPeriodo);
		txtxPeriodo.setColumns(10);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalir.setBounds(193, 120, 89, 23);
		btnSalir.setForeground(Color.BLUE);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.addActionListener(this);
		btnSalir.setBorder(null);
		btnSalir.setBackground(Color.WHITE);
		panel_1.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	
		
		listarCursoInscripcion();
		calculocomporbante();
		muestraFecha();
		
	}
	
	void muestraFecha() {
		
		// 1. Capturar la fecha del sistema		
		Date fecha = new Date(); // fecha y hora
		Date fecha2 = new Date();
		// 2. poner la fecha en el txt
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdfm = new SimpleDateFormat("MM");
		txtxPeriodo.setText("P"+sdf.format(fecha)+sdfm.format(fecha2));
	}
	
	GestionInscripcion gs = new GestionInscripcion();
	GestionNotas gt = new GestionNotas();
	
	Date d = new Date();
	Calendar c = new GregorianCalendar();
	
	Inscripcion ins = new Inscripcion();
	Notas nt = new Notas();
	
	private JButton btnpopuo;
	private JButton btnAbrir;
	private JButton btnPagoInscripcon;
	JTextField txtusuarioPrincipal;
	private JTextField txtxPeriodo;
	private JButton btnSalir;

	/**
	 * Initialize the contents of the frame.
	 */

	void calculocomporbante(){
		
		int h, m, s;
		
		h =c.get(Calendar.HOUR_OF_DAY);
		m = c.get(Calendar.MINUTE);
		s = c.get(Calendar.SECOND);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdfm = new SimpleDateFormat("MM");
		
		txtRecibo.setText(sdf.format(d)+sdfm.format(d)+h+m+s);
	}
	void listarCursoInscripcion(){
		
		ArrayList<ProgramacionHorarioDet>lista=gs.listadogeneralInscripcionCursos();
		if(lista==null){
			
		}else{
			modeloHorario.setRowCount(0);
			for(ProgramacionHorarioDet p:lista){
				Object[]fila={
						p.getCodasodet(),
						p.getCurso(),
						p.getSeccion(),
						p.getDocente()
				}; modeloHorario.addRow(fila);
			}
		}
	}
			
	void listarPagoInscripcion(){
		usuarioLogueado=txtusuarioPrincipal.getText();
		ArrayList<Inscripcion>lista=gs.listadoPagoInscripcion(usuarioLogueado);
		if(lista==null){
			
		}else{
			modeloPago.setRowCount(0);
			for(Inscripcion p:lista){
				Object[]fila={
						p.getCodigoCurso(),
						p.getDescripcioSeccion(),
						p.getNombrePersona(),
						p.getFormaPago(),
						p.getRecibo(),
						p.getMontoPagado()
				}; modeloPago.addRow(fila);
			}
		}
	}
	
	void pagarCurso(){
		
		//lblCosto
		montoCurso=Double.parseDouble(lblCosto.getText());
		double monto = Double.parseDouble(""+lblCosto.getText());
		String curso = lblCurso.getText();
		String seccion = lblSeccion.getText();
		String usuario = txtusuarioPrincipal.getText();
		String recibo = txtRecibo.getText();
		String docente = lbldocente.getText();
		String periodo = txtxPeriodo.getText();
		
		if(cboFormaPago.getSelectedIndex()>0){
		try {
			montoPagado=Double.parseDouble(""+lblCosto.getText());
			
			
				ins.setFormaPago(descripcionFormaPago);
				ins.setMontoPagado(monto);
				ins.setDescripcioCurso(curso);
				ins.setDescripcioSeccion(seccion);
				ins.setUsuarioLogueado(usuario);
				ins.setRecibo(recibo);
				ins.setNombrePersona(docente);
				ins.setPeriodo(periodo);
				
				gs.RegistrarPagoInscripcion(ins);
				
				nt.setCurso(curso);
				nt.setSeccion(seccion);
				nt.setUsuAlumno(usuario);
				nt.setPeriodo(periodo);
				nt.setNt1(0.0);
				nt.setNt2(0.0);
				nt.setNt3(0.0);
				nt.setNt4(0.0);
				nt.setPromedio(0.0);
				nt.setEstado("Sin Nota");
				gt.RegistrarNota(nt);
			
				
				
				//JOptionPane.showMessageDialog(null, "Registrado correctamente");
							
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese el monto");
		}
		}else{
			JOptionPane.showMessageDialog(null, "Ingrese la forma de pago");
		}
		listarPagoInscripcion();
		
	}

	void mostrarcamposdetalle(){
		
		int idseleccionado = Integer.parseInt(txtcodigoDetalle.getText());
		
		//String nombredocente = txtdocente.getText();

		ArrayList<ProgramacionHorarioDet>lista=gs.buscarhorariomatricula(idseleccionado);		
		
		for(ProgramacionHorarioDet p :lista){
					//codigo=p.getCodcurso();
					lblCosto.setText(""+p.getCosto());
					
		}	
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
		
	}
	
	
	@Override
	public void mouseReleased(MouseEvent arg0) {		
		// TODO Auto-generated method stub
		
		
		tblHorario_1 = (JTable)arg0.getSource();				
		Point point = arg0.getPoint();
		int row = tblHorario_1.rowAtPoint(point);
			if(arg0.getClickCount()==2){
				txtcodigoDetalle.setText(tblHorario_1.getValueAt(tblHorario_1. getSelectedRow(),0).toString());
				//pp.txtcodigoDetalle.setText(tblHorario_1.getValueAt(tblHorario_1. getSelectedRow(),0).toString());
				lblCurso.setVisible(true);
				lblCurso.setText(tblHorario_1.getValueAt(tblHorario_1. getSelectedRow(),1).toString());
				lblSeccion.setVisible(true);
				lblSeccion.setText(tblHorario_1.getValueAt(tblHorario_1. getSelectedRow(),2).toString());
				lbldocente.setVisible(true);
				lbldocente.setText(tblHorario_1.getValueAt(tblHorario_1. getSelectedRow(),3).toString());
				lblCosto.setVisible(true);
				panelCurso.setVisible(true);
				mostrarcamposdetalle();		
				btnpopuo.setVisible(true);
				btnPagoInscripcon.setEnabled(true);
			}
			
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
	public void actionPerformed(ActionEvent arg0)  {
		
		if(arg0.getSource()==btnpopuo){
			try {
				actionperformedbtnpopuo(arg0);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(arg0.getSource()==btnPagoInscripcon){
			try {
				actionperformedbtnPagoInscripcon(arg0);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(arg0.getSource()==btnSalir){
			dispose();
		}
		
	}


	private void actionperformedbtnPagoInscripcon(ActionEvent arg0)  throws ParseException{
		// TODO Auto-generated method stub
		
		
		
		PopupPagoTarjeta cur = new PopupPagoTarjeta();		
		desktopPane.add(cur);
		
		Dimension desktopSize=desktopPane.getSize();
		Dimension FrameSize= cur.getSize();
		cur.setLocation((desktopSize.width-FrameSize.width)/2, 1/(desktopSize.height-FrameSize.height/1));
		cur.setVisible(true);
		if(descripcionFormaPago=="Visa Tarjeta Débito" || descripcionFormaPago=="Visa Tarjeta Crédito"){
			cur.panelVisa.setVisible(true);
			cur.panelPaypal.setVisible(false);
			cur.lblLblmonto.setText(lblCosto.getText());
			pagarCurso();
		}else if(descripcionFormaPago=="Paypal"){
			cur.panelPaypal.setVisible(true);
			cur.panelVisa.setVisible(false);
			cur.lblLblmontoP.setText(""+600);
			cur.lblLblmontoP2.setText(""+600);
			cur.lblCostocurso.setText(lblCosto.getText());
			pagarCurso();
		}else if(descripcionFormaPago=="Seleccione"){						
			JOptionPane.showMessageDialog(null, "Seleccione la forma de Pago");
		}
		System.out.println(cur.lblLblmonto);
	}

	private void actionperformedbtnpopuo(ActionEvent arg0) throws ParseException{
		// TODO Auto-generated method stub
		PopupPagoDetalle cur = new PopupPagoDetalle();		
		desktopPane.add(cur);
		
		Dimension desktopSize=desktopPane.getSize();
		Dimension FrameSize= cur.getSize();
		cur.setLocation((desktopSize.width-FrameSize.width)/2, 1/(desktopSize.height-FrameSize.height/1));
		cur.setVisible(true);
		
		cur.txtcodDet.setText(txtcodigoDetalle.getText());
		cur.mostrarcamposdetalle();
		System.out.println(cur.txtcodDet);
	}
}
