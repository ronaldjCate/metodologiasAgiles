package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.ProgramacionHorarioDet;
import mantenimientos.GestionInscripcion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class PopupPagoTarjeta extends JInternalFrame implements ActionListener,MouseListener {

	private JFrame frame;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JTextField txtNombreTarjeta;
	private JTextField txtNroTarjeta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton button;
	JLabel lblLblmonto;
	JPanel panelVisa;
	JPanel panelPaypal;
	private JPanel panel;
	private JLabel lblNombreDeLa;
	private JLabel lblNewLabel;
	private JLabel lblFechaDeVencimiento;
	private JLabel lblCvv;
	private JLabel lblSeleccionaTuPais;
	private JButton btnPagarMatricula;
	
	private JLabel label_1;
	private JLabel lblPrecioDelCurso;
	private JLabel lblTotal;
	private JLabel label;
	private JLabel label_2;
	private JLabel labelP_2;
	private JButton buttonP;
	private JButton buttonC;
	JLabel lblLblmontoP;
	private JLabel lblS;
	private JLabel lblholaDeNuevo;
	private JLabel lblLblusuariopaypal;
	private JLabel lblnoEresT;
	private JLabel lblPagarCon;
	private JLabel lblSaldoPaypal;
	JLabel lblLblmontoP2;
	private JButton btnPagarAhora;
	private JButton btnNewButton;
	private JButton btnSalir;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopupPagoTarjeta window = new PopupPagoTarjeta();
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
	public PopupPagoTarjeta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cursos Recomendados");
		setBounds(100, 100, 685, 450);
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
		}
		catch(IOException e){
		 e.printStackTrace();
		}
			
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		
		panelVisa = new JPanel();
		panelVisa.setBackground(Color.WHITE);
		panelVisa.setVisible(false);
		panelVisa.setBounds(28, 11, 599, 388);
		desktopPane.add(panelVisa);
		panelVisa.setLayout(null);
		
		
	
		
		
		lblNombreDeLa = new JLabel("NOMBRE DE LA TARJETA");
		lblNombreDeLa.setBounds(47, 89, 146, 14);
		panelVisa.add(lblNombreDeLa);
		
		txtNombreTarjeta = new JTextField();
		txtNombreTarjeta.setBounds(47, 114, 242, 20);
		panelVisa.add(txtNombreTarjeta);
		txtNombreTarjeta.setColumns(10);
		
		lblNewLabel = new JLabel("N\u00DAMERO EN LA TARJETA");
		lblNewLabel.setBounds(47, 149, 258, 14);
		panelVisa.add(lblNewLabel);
		
		txtNroTarjeta = new JTextField();
		txtNroTarjeta.setBounds(47, 174, 242, 20);
		panelVisa.add(txtNroTarjeta);
		txtNroTarjeta.setColumns(10);
		
		lblFechaDeVencimiento = new JLabel("FECHA DE VENCIMIENTO");
		lblFechaDeVencimiento.setBounds(47, 208, 152, 14);
		panelVisa.add(lblFechaDeVencimiento);
		
		textField = new JTextField();
		textField.setBounds(47, 235, 135, 20);
		panelVisa.add(textField);
		textField.setColumns(10);
		
		lblCvv = new JLabel("CVV");
		lblCvv.setBounds(203, 210, 65, 14);
		panelVisa.add(lblCvv);
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 235, 86, 20);
		panelVisa.add(textField_1);
		textField_1.setColumns(10);
		
		lblSeleccionaTuPais = new JLabel("SELECCIONA TU PAIS");
		lblSeleccionaTuPais.setBounds(47, 273, 194, 14);
		panelVisa.add(lblSeleccionaTuPais);
		
		textField_2 = new JTextField();
		textField_2.setBounds(47, 298, 242, 20);
		panelVisa.add(textField_2);
		textField_2.setColumns(10);
		
		
		panel = new JPanel();
		panel.setBounds(328, 85, 228, 233);
		panelVisa.add(panel);
		panel.setLayout(null);
		
		
		
		lblPrecioDelCurso = new JLabel("PRECIO DEL CURSO");
		lblPrecioDelCurso.setBounds(27, 68, 140, 14);
		panel.add(lblPrecioDelCurso);
		
		lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(27, 132, 46, 14);
		panel.add(lblTotal);
		
		lblLblmonto = new JLabel("lblmonto");
		lblLblmonto.setForeground(Color.RED);
		lblLblmonto.setBounds(81, 132, 46, 14);
		panel.add(lblLblmonto);
		
		label = new JLabel("______________________________________");
		label.setForeground(Color.BLUE);
		label.setBounds(0, 181, 242, 14);
		panel.add(label);
		
		label_1 = new JLabel("______________________________________");
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(0, 30, 242, 14);
		panel.add(label_1);
		
		btnPagarMatricula = new JButton("Pagar Matricula");
		btnPagarMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Transacción realizada correctamente");
			}
		});
		btnPagarMatricula.setBackground(Color.BLUE);
		btnPagarMatricula.setForeground(Color.WHITE);
		btnPagarMatricula.setBounds(136, 343, 153, 23);
		panelVisa.add(btnPagarMatricula);
		
		label_2 = new JLabel("____________________________________________________________________________________________________");
		label_2.setForeground(Color.BLUE);
		label_2.setBounds(0, 55, 600, 14);
		panelVisa.add(label_2);
		
		button = new JButton("");
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		button.setIcon(new ImageIcon(PopupPagoTarjeta.class.getResource("/imagenes/tarjeta.png")));
		button.setBounds(10, 0, 479, 69);
		panelVisa.add(button);
		
		btnNewButton = new JButton("Salir");
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(315, 343, 165, 23);
		panelVisa.add(btnNewButton);
		
		lblCostocurso = new JLabel("New label");
		lblCostocurso.setBounds(213, 273, 46, 14);
		lblCostocurso.setVisible(false);
		panelVisa.add(lblCostocurso);
		
		
		
		panelPaypal = new JPanel();
		panelPaypal.setBackground(Color.WHITE);
		panelPaypal.setVisible(false);
		panelPaypal.setBounds(28, 11, 599, 388);
		desktopPane.add(panelPaypal);
		panelPaypal.setLayout(null);
		
		labelP_2 = new JLabel("____________________________________________________________________________________________________");
		labelP_2.setForeground(Color.BLUE);
		labelP_2.setBounds(0, 55, 600, 14);
		panelPaypal.add(labelP_2);
		
		buttonP = new JButton("");
		buttonP.setContentAreaFilled(false);
		buttonP.setBorderPainted(false);
		buttonP.setBorder(null);
		buttonP.setBackground(Color.WHITE);
		buttonP.setIcon(new ImageIcon(PopupPagoTarjeta.class.getResource("/imagenes/paypal2.png")));
		buttonP.setBounds(22, 0, 109, 69);
		panelPaypal.add(buttonP);
		
		buttonC = new JButton("");
		buttonC.setContentAreaFilled(false);
		buttonC.setBorderPainted(false);
		buttonC.setBorder(null);
		buttonC.setBackground(Color.WHITE);
		buttonC.setIcon(new ImageIcon(PopupPagoTarjeta.class.getResource("/imagenes/caroo.jpg")));
		buttonC.setBounds(391, 11, 47, 41);
		panelPaypal.add(buttonC);
		
		lblLblmontoP = new JLabel("lblMonto");
		lblLblmontoP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLblmontoP.setBounds(448, 13, 85, 39);
		panelPaypal.add(lblLblmontoP);
		
		lblS = new JLabel("S/");
		lblS.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblS.setBounds(543, 11, 46, 41);
		panelPaypal.add(lblS);
		
		lblholaDeNuevo = new JLabel("\u00A1Hola de nuevo, ");
		lblholaDeNuevo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblholaDeNuevo.setBounds(42, 98, 177, 46);
		panelPaypal.add(lblholaDeNuevo);
		
		lblLblusuariopaypal = new JLabel("lblusuarioPaypal");
		lblLblusuariopaypal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLblusuariopaypal.setBounds(211, 107, 154, 28);
		panelPaypal.add(lblLblusuariopaypal);
		
		lblnoEresT = new JLabel("\u00BFNo eres t\u00FA?");
		lblnoEresT.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblnoEresT.setForeground(Color.BLUE);
		lblnoEresT.setBounds(391, 107, 141, 28);
		panelPaypal.add(lblnoEresT);
		
		lblPagarCon = new JLabel("Pagar con");
		lblPagarCon.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblPagarCon.setForeground(Color.GRAY);
		lblPagarCon.setBounds(43, 155, 223, 57);
		panelPaypal.add(lblPagarCon);
		
		lblSaldoPaypal = new JLabel("Saldo PayPal");
		lblSaldoPaypal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSaldoPaypal.setBounds(42, 227, 163, 28);
		panelPaypal.add(lblSaldoPaypal);
		
		lblLblmontoP2 = new JLabel("lblMonto");
		lblLblmontoP2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLblmontoP2.setBounds(400, 222, 85, 39);
		panelPaypal.add(lblLblmontoP2);
		
		btnPagarAhora = new JButton("Pagar ahora");
		btnPagarAhora.addActionListener(this);
		btnPagarAhora.setBackground(Color.BLUE);
		btnPagarAhora.setForeground(Color.WHITE);
		btnPagarAhora.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPagarAhora.setBounds(42, 272, 477, 52);
		panelPaypal.add(btnPagarAhora);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBackground(Color.BLUE);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalir.setBounds(42, 332, 477, 45);
		panelPaypal.add(btnSalir);
	}

	/**
	 * Initialize the contents of the frame.
	 */



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
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnPagarAhora){
			actionPerformedbtnPagarAhora();
		}
	}
	

	
	String leercosto(){
		return lblCostocurso.getText();
	}
	JLabel lblCostocurso;
	
	private void actionPerformedbtnPagarAhora() {
		// TODO Auto-generated method stub
		double costo=0.0; 
		costo= Double.parseDouble(""+leercosto());
		calcular(costo);
	}
	
	Date d = new Date();
	Calendar c = new GregorianCalendar();
	String valor ="";
	void calculocomporbante(){
		
		
		
		int h, m, s;
		
		h =c.get(Calendar.HOUR_OF_DAY);
		m = c.get(Calendar.MINUTE);
		s = c.get(Calendar.SECOND);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdfm = new SimpleDateFormat("MM");
		
		valor=(sdf.format(d)+sdfm.format(d)+h+m+s);
	}
	
	
	int valorPa=0;
	
	double calcular(double precio){
		double montoPay = Double.parseDouble(lblLblmontoP.getText());
		montoPay=montoPay-precio;
		lblLblmontoP.setText(""+montoPay);
		lblLblmontoP2.setText(""+montoPay);
		JOptionPane.showMessageDialog(null, "Transacción realizada correctamente");		
		valorPa=1;
		return montoPay;
	}


}
