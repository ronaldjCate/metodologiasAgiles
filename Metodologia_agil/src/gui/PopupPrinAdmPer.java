package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.toedter.calendar.JDateChooser;

import clases.Perfil;
import clases.Persona;
import mantenimientos.GestionAdministrador;
import mantenimientos.GestionPersona;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



public class PopupPrinAdmPer extends JInternalFrame implements ActionListener,MouseListener{

	private JFrame frame;
	
	String descripcionTipo="";
	String descripcionSexo="";

	private JPanel contentPane;
	private JButton btnDatosPersonales;
	JButton btndpRegistrar;
	
	private JDateChooser dpfechanacimiento;
	
	private JLabel lblNombreCompleto;
	private JLabel lblApellidoCompleto;
	private JLabel lblFechaNacimiento;
	private JLabel lblDni;
	private JLabel lblNmeroDeTelfono;
	private JLabel lblSexo;
	private JLabel lblCorreoElectrnico;

	
	private JTextField txtdpnombrecompleto;
	private JTextField txtdpapellidocompleto;
	private JTextField txtdpdni;
	private JTextField txtdpnumerotelf;
	private JTextField txtdpcorreoelectronico;

	
	private JPanel paneldatospersonales;	
	private JPanel panellogueado;
	private JLabel lblSexo_1;
	private JComboBox cboSexo;
	private JLabel lblTipo;
	private JComboBox cboTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopupPrinAdmPer window = new PopupPrinAdmPer();
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
	public PopupPrinAdmPer() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 542);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		btnDatosPersonales = new JButton("DATOS PERSONALES");
		btnDatosPersonales.setForeground(Color.BLUE);
		btnDatosPersonales.setBackground(Color.WHITE);
		btnDatosPersonales.setBounds(0, 0, 815, 23);
		contentPane.add(btnDatosPersonales);
		
		paneldatospersonales = new JPanel();
		paneldatospersonales.setBackground(Color.WHITE);
		paneldatospersonales.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255)), "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, Color.blue));
		paneldatospersonales.setBounds(27, 34, 746, 393);
		contentPane.add(paneldatospersonales);
		paneldatospersonales.setLayout(null);
		
		btndpRegistrar = new JButton("");
		btndpRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarpersona();
			}
		});
		btndpRegistrar.setIcon(new ImageIcon(PopupPrinAdmCurso.class.getResource("/imagenes/guardar.png")));
		btndpRegistrar.setBackground(Color.WHITE);
		btndpRegistrar.setContentAreaFilled(false);
		btndpRegistrar.setBorderPainted(false);
		btndpRegistrar.setBorder(null);
		btndpRegistrar.setBounds(10, 341, 371, 41);
		paneldatospersonales.add(btndpRegistrar);
		
		lblNombreCompleto = new JLabel("NOMBRE COMPLETO");
		lblNombreCompleto.setBounds(131, 36, 129, 14);
		paneldatospersonales.add(lblNombreCompleto);
		
		lblApellidoCompleto = new JLabel("APELLIDO COMPLETO");
		lblApellidoCompleto.setBounds(131, 70, 129, 14);
		paneldatospersonales.add(lblApellidoCompleto);
		
		txtdpapellidocompleto = new JTextField();
		txtdpapellidocompleto.setBounds(286, 67, 309, 20);
		paneldatospersonales.add(txtdpapellidocompleto);
		txtdpapellidocompleto.setColumns(10);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(131, 136, 129, 14);
		paneldatospersonales.add(lblDni);
		
		txtdpdni = new JTextField();
		txtdpdni.setBounds(286, 133, 309, 20);
		paneldatospersonales.add(txtdpdni);
		txtdpdni.setColumns(10);
		
		txtdpnombrecompleto = new JTextField();
		txtdpnombrecompleto.setBounds(286, 33, 309, 20);
		paneldatospersonales.add(txtdpnombrecompleto);
		txtdpnombrecompleto.setColumns(10);
		
		lblFechaNacimiento = new JLabel("FECHA NACIMIENTO");
		lblFechaNacimiento.setBounds(131, 105, 129, 14);
		paneldatospersonales.add(lblFechaNacimiento);
		
		dpfechanacimiento = new JDateChooser();
		dpfechanacimiento.setBounds(286, 98, 309, 20);
		paneldatospersonales.add(dpfechanacimiento);
		
		lblNmeroDeTelfono = new JLabel("NRO TELÉFONO");
		lblNmeroDeTelfono.setBounds(131, 172, 129, 14);
		paneldatospersonales.add(lblNmeroDeTelfono);
		
		txtdpnumerotelf = new JTextField();
		txtdpnumerotelf.setBounds(286, 169, 309, 20);
		paneldatospersonales.add(txtdpnumerotelf);
		txtdpnumerotelf.setColumns(10);
		
		lblCorreoElectrnico = new JLabel("CORREO ELECTR\u00D3NICO");
		lblCorreoElectrnico.setBounds(131, 215, 145, 14);
		paneldatospersonales.add(lblCorreoElectrnico);
		
		txtdpcorreoelectronico = new JTextField();
		txtdpcorreoelectronico.setBounds(286, 212, 309, 20);
		paneldatospersonales.add(txtdpcorreoelectronico);
		txtdpcorreoelectronico.setColumns(10);
		
		lblSexo_1 = new JLabel("SEXO");
		lblSexo_1.setBounds(131, 254, 46, 14);
		paneldatospersonales.add(lblSexo_1);
		
		cboSexo = new JComboBox();
		cboSexo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "F", "M"}));
		cboSexo.addItemListener(event -> {
	    	if (event.getStateChange() == ItemEvent.SELECTED) {
	        	//txtperiodo.setText(event.getItem().toString());
	    		descripcionSexo=(event.getItem().toString());
	        	//listadomatricula();
	        }
	    });
		cboSexo.setBounds(286, 251, 309, 20);
		paneldatospersonales.add(cboSexo);
		
		lblTipo = new JLabel("TIPO");
		lblTipo.setBounds(131, 284, 46, 14);
		paneldatospersonales.add(lblTipo);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(286, 286, 309, 20);
		cboTipo.addItemListener(event -> {
	    	if (event.getStateChange() == ItemEvent.SELECTED) {
	        	//txtperiodo.setText(event.getItem().toString());
	        	descripcionTipo=(event.getItem().toString());
	        	//listadomatricula();
	        }
	    });
		paneldatospersonales.add(cboTipo);
		
		btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(PopupPrinAdmCurso.class.getResource("/imagenes/salir.png")));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setBorder(null);
		btnSalir.setBounds(376, 341, 360, 41);
		paneldatospersonales.add(btnSalir);
		
		panellogueado = new JPanel();
		panellogueado.setBackground(Color.WHITE);
		panellogueado.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255)), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.blue));
		panellogueado.setBounds(20, 438, 785, 63);
		contentPane.add(panellogueado);
		panellogueado.setLayout(null);
		llenacombo();
		
	}
	GestionAdministrador ga = new GestionAdministrador();
	 GestionPersona gp = new GestionPersona();
	 private JButton btnSalir;

	
	String leerdpfechanac(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(dpfechanacimiento.getDate());		
	}	
	
	void registrarpersona(){
			
		  String nombre, apellido, sexo, fechaNacimiento, correo,numeroTelefono,dniPersona,tb_tipo_descripcion;
		  
		  nombre=txtdpnombrecompleto.getText(); 
		  apellido=txtdpapellidocompleto.getText();
		  sexo=descripcionSexo;
		  fechaNacimiento=leerdpfechanac();
		  correo=txtdpcorreoelectronico.getText();
		  numeroTelefono=txtdpnumerotelf.getText();
		  dniPersona=txtdpdni.getText();
		  tb_tipo_descripcion=descripcionTipo;
		  
		  Persona p = new Persona();
			 
		  	 p.setNombre(nombre);
			 p.setApellido(apellido);
			 p.setSexo(sexo);
			 p.setFechaNacimiento(fechaNacimiento);
			 p.setCorreo(correo);
			 p.setNumeroTelefono(numeroTelefono);
			 p.setDniPersona(dniPersona);
			 p.setTb_tipo_descripcion(tb_tipo_descripcion);
			 
			 int ok = gp.RegistrarPersona(p);
			 if(ok==0){
				 JOptionPane.showMessageDialog(null, "Error al Registrar");
			 }else{
				 JOptionPane.showMessageDialog(null, "Registrado correctamente");
				 limpiar();
			 }
		  
	}
	
	void limpiar(){
		txtdpnombrecompleto.setText(""); 
		  txtdpapellidocompleto.setText("");
		  cboSexo.setSelectedIndex(0);
		  dpfechanacimiento.setCalendar(null);
		  txtdpcorreoelectronico.setText("");
		  txtdpnumerotelf.setText("");
		  txtdpdni.setText("");
		  cboTipo.setSelectedIndex(0);
	}
	
	void llenacombo(){		
		ArrayList<Perfil> lista = ga.listadoPerfil();
		cboTipo.addItem("Seleccione");
		for (Perfil t : lista) {
			cboTipo.addItem(t.getDescripcion());			
		}		
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
