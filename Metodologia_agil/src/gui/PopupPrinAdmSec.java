package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Seccion;
import mantenimientos.GestionSeccion;



public class PopupPrinAdmSec  extends JInternalFrame implements ActionListener{

	private JFrame frame;
	
private JPanel contentPane;

	String descripcionTipo;
	
	JButton btnRegistrar;
	JButton btneliminar;
	JButton btnactualizar;
	
	private JLabel lblCantidadMin;
	private JTextField txtcantidadminper;
	private JTextField txtcodigoSeccion;
	private JTextField txtcantidadmaxper;
	

	private JLabel lblNombreDeSeccin;
	private JComboBox cboTipo;
	private JPanel panel;
	private JButton btncerrarformulario;
	
	JTextField txtcodseccion;
	JTextField txtcodusuario;
	private JLabel lblCantidadDePersonas;
	private JLabel lbltipo;
	private JLabel lblcodigoSeccion;
	private JTextField txtnomSeccion;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopupPrinAdmSec window = new PopupPrinAdmSec();
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
	public PopupPrinAdmSec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		panel = new JPanel();
		panel.setBounds(26, 27, 359, 318);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNombreDeSeccin = new JLabel("CODIGO SECCI\u00D3N");
		lblNombreDeSeccin.setBounds(35, 73, 138, 14);
		panel.add(lblNombreDeSeccin);
		lblNombreDeSeccin.setForeground(Color.BLUE);
		
		txtcodigoSeccion = new JTextField();
		txtcodigoSeccion.setBounds(150, 70, 166, 20);
		panel.add(txtcodigoSeccion);
		txtcodigoSeccion.setColumns(10);
		
		lbltipo = new JLabel("DISPONIBLE");
		lbltipo.setBounds(35, 111, 105, 14);
		panel.add(lbltipo);
		lbltipo.setForeground(Color.BLUE);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(150, 108, 166, 20);
		cboTipo.addItemListener(event -> {
	    	if (event.getStateChange() == ItemEvent.SELECTED) {
	        	//txtperiodo.setText(event.getItem().toString());
	        	descripcionTipo=(event.getItem().toString());
	        	//listadomatricula();
	        }
	    });
		panel.add(cboTipo);
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Presencial", "Virtual"}));
		
		lblCantidadDePersonas = new JLabel("CANTIDAD MAX");
		lblCantidadDePersonas.setBounds(35, 150, 105, 14);
		panel.add(lblCantidadDePersonas);
		lblCantidadDePersonas.setForeground(Color.BLUE);
		
		txtcantidadmaxper = new JTextField();
		txtcantidadmaxper.setBounds(150, 147, 166, 20);
		panel.add(txtcantidadmaxper);
		txtcantidadmaxper.setColumns(10);
		
		lblCantidadMin = new JLabel("CANTIDAD MIN");
		lblCantidadMin.setBounds(35, 186, 105, 14);
		panel.add(lblCantidadMin);
		lblCantidadMin.setForeground(Color.BLUE);
		
		txtcantidadminper = new JTextField();
		txtcantidadminper.setBounds(150, 183, 166, 20);
		panel.add(txtcantidadminper);
		txtcantidadminper.setColumns(10);
		

		

		
		btnRegistrar = new JButton("");
		btnRegistrar.setBounds(2, 273, 174, 45);
		panel.add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarseccion();
			}
		});
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setIcon(new ImageIcon(PopupPrinAdmSec.class.getResource("/imagenes/guardar.png")));
		
		lblcodigoSeccion = new JLabel("NOMBRE SECCI\u00D3N");
		lblcodigoSeccion.setForeground(Color.BLUE);
		lblcodigoSeccion.setBounds(35, 44, 138, 14);
		panel.add(lblcodigoSeccion);
		
		txtnomSeccion = new JTextField();
		txtnomSeccion.setColumns(10);
		txtnomSeccion.setBounds(150, 41, 166, 20);
		panel.add(txtnomSeccion);
		
		btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setIcon(new ImageIcon(PopupPrinAdmSec.class.getResource("/imagenes/salir.png")));
		btnSalir.setBounds(176, 273, 182, 45);
		panel.add(btnSalir);
	}
	
FromPrinAdmSec fr = new FromPrinAdmSec();

	void registrarseccion(){
		
		String codigo, nombre, tipo;
		int cantMax, cantMin;
		
		nombre =txtnomSeccion.getText();
		codigo=txtcodigoSeccion.getText();
		tipo=descripcionTipo;
		cantMin=Integer.parseInt(txtcantidadminper.getText());
		cantMax=Integer.parseInt(txtcantidadmaxper.getText());
		 
		 Seccion s = new Seccion();
			s.setCodigoSeccion(codigo);
			s.setNom_seccion(nombre);
			s.setTipo(tipo);
			s.setCant_min_pers(cantMin);
			s.setCant_max_pers(cantMax);						
			
			GestionSeccion gs =new GestionSeccion();
			int ok = gs.registrar(s);
			if(ok==0){
				System.out.println("Error al registrar");
			}else{
				JOptionPane.showMessageDialog(null, "Registrado correctamente");
				fr.listar();
			}
			limpiar();
			dispose();
		
	}
	
	void limpiar(){
		txtnomSeccion.setText("");
		txtcodigoSeccion.setText("");
		cboTipo.setSelectedIndex(0);
		txtcantidadminper.setText("");
		txtcantidadmaxper.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
