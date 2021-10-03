package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.border.TitledBorder;


import clases.Inscripcion;
import clases.ProgramacionHorarioDet;
import mantenimientos.GestionInscripcion;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PopupPagoDetalle extends JInternalFrame implements ActionListener,MouseListener{

	private JFrame frame;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JPanel panelSeccion;
	private JPanel panelCurso;
	private JPanel panelPersona;
	private JLabel lblCreditoParametro;
	private JLabel lblCursoParamento;
	private JLabel lblCodigoCursoParametro;
	private JLabel lblPrecioParametro;
	private JLabel lbltiposeccionParametro;
	private JLabel lblcantidaminSeccionParametro;
	private JLabel lblCantidadMaxParametro;
	private JLabel lblnombrePersonaParametro;
	private JLabel lblapellidoparametro;
	private JLabel lblcorreoparametro;
	private JLabel lblseccionParametro;
	private JLabel lblcodigoseccionParametro;
	private JLabel lblTipo;
	JTextField txtcodDet;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopupPagoDetalle window = new PopupPagoDetalle();
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
	public PopupPagoDetalle() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cursos Recomendados");
		setBounds(100, 100, 506, 450);
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
		
		panelCurso = new JPanel();
		panelCurso.setForeground(Color.BLUE);
		panelCurso.setBackground(new Color(255, 255, 255));
		panelCurso.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0), new Color(255, 0, 0), new Color(255, 0, 0)), "Curso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCurso.setBounds(24, 26, 430, 96);
		desktopPane.add(panelCurso);
		panelCurso.setLayout(null);
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setBounds(26, 28, 62, 14);
		panelCurso.add(lblCurso);
		
		lblCursoParamento = new JLabel("New label");
		lblCursoParamento.setForeground(Color.BLUE);
		lblCursoParamento.setBounds(83, 28, 101, 14);
		panelCurso.add(lblCursoParamento);
		
		JLabel lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(194, 28, 74, 14);
		panelCurso.add(lblCodigo);
		
		lblCodigoCursoParametro = new JLabel("New label");
		lblCodigoCursoParametro.setForeground(Color.BLUE);
		lblCodigoCursoParametro.setBounds(299, 28, 121, 14);
		panelCurso.add(lblCodigoCursoParametro);
		
		JLabel lblCrdito = new JLabel("CR\u00C9DITO");
		lblCrdito.setBounds(24, 59, 64, 14);
		panelCurso.add(lblCrdito);
		
		lblCreditoParametro = new JLabel("New label");
		lblCreditoParametro.setForeground(Color.BLUE);
		lblCreditoParametro.setBounds(83, 59, 101, 14);
		panelCurso.add(lblCreditoParametro);
		
		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setBounds(194, 59, 74, 14);
		panelCurso.add(lblPrecio);
		
		lblPrecioParametro = new JLabel("New label");
		lblPrecioParametro.setForeground(Color.BLUE);
		lblPrecioParametro.setBounds(299, 59, 108, 14);
		panelCurso.add(lblPrecioParametro);
		
		txtcodDet = new JTextField();
		txtcodDet.setVisible(false);
		txtcodDet.setBounds(204, 40, 86, 20);
		panelCurso.add(txtcodDet);
		txtcodDet.setColumns(10);
		
		panelPersona = new JPanel();
		panelPersona.setForeground(Color.BLUE);
		panelPersona.setBackground(new Color(255, 255, 255));
		panelPersona.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0), new Color(255, 0, 0), new Color(255, 0, 0)), "Persona", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPersona.setBounds(24, 140, 430, 86);
		desktopPane.add(panelPersona);
		panelPersona.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(20, 22, 114, 14);
		panelPersona.add(lblNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(20, 47, 102, 14);
		panelPersona.add(lblApellido);
		
		JLabel lblCorreo = new JLabel("CORREO");
		lblCorreo.setBounds(196, 22, 91, 14);
		panelPersona.add(lblCorreo);
		
		lblnombrePersonaParametro = new JLabel("New label");
		lblnombrePersonaParametro.setForeground(Color.BLUE);
		lblnombrePersonaParametro.setBounds(88, 22, 98, 14);
		panelPersona.add(lblnombrePersonaParametro);
		
		lblapellidoparametro = new JLabel("New label");
		lblapellidoparametro.setBounds(88, 47, 98, 14);
		lblapellidoparametro.setForeground(Color.BLUE);
		panelPersona.add(lblapellidoparametro);
		
		lblcorreoparametro = new JLabel("New label");
		lblcorreoparametro.setBounds(257, 22, 125, 14);
		lblcorreoparametro.setForeground(Color.BLUE);
		panelPersona.add(lblcorreoparametro);
		
		panelSeccion = new JPanel();
		panelSeccion.setForeground(Color.BLUE);
		panelSeccion.setBackground(new Color(255, 255, 255));
		panelSeccion.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0), new Color(255, 0, 0), new Color(255, 0, 0)), "Secci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSeccion.setBounds(24, 241, 430, 127);
		desktopPane.add(panelSeccion);
		panelSeccion.setLayout(null);
		
		JLabel lblSeccion = new JLabel("SECCION");
		lblSeccion.setBounds(25, 31, 90, 14);
		panelSeccion.add(lblSeccion);
		
		JLabel lblCodigo_1 = new JLabel("CODIGO");
		lblCodigo_1.setBounds(25, 62, 90, 14);
		panelSeccion.add(lblCodigo_1);
		
		lblTipo = new JLabel("TIPO");
		
		lblTipo.setBounds(25, 100, 80, 14);
		panelSeccion.add(lblTipo);
		
		JLabel lblCantidadMin = new JLabel("CANTIDAD MIN");
		lblCantidadMin.setBounds(205, 31, 110, 14);
		panelSeccion.add(lblCantidadMin);
		
		JLabel lblCantidadMax = new JLabel("CANTIDAD MAX");
		lblCantidadMax.setBounds(205, 62, 110, 14);
		panelSeccion.add(lblCantidadMax);
		
		lblseccionParametro = new JLabel("New label");
		lblseccionParametro.setForeground(Color.BLUE);
		lblseccionParametro.setBounds(84, 31, 46, 14);
		panelSeccion.add(lblseccionParametro);
		
		lblcodigoseccionParametro = new JLabel("New label");
		lblcodigoseccionParametro.setForeground(Color.BLUE);
		lblcodigoseccionParametro.setBounds(84, 62, 111, 14);
		panelSeccion.add(lblcodigoseccionParametro);
		
		lbltiposeccionParametro = new JLabel("New label");
		lbltiposeccionParametro.setForeground(Color.BLUE);
		lbltiposeccionParametro.setBounds(84, 100, 111, 14);
		panelSeccion.add(lbltiposeccionParametro);
		
		lblcantidaminSeccionParametro = new JLabel("New label");
		lblcantidaminSeccionParametro.setForeground(Color.BLUE);
		lblcantidaminSeccionParametro.setBounds(303, 31, 110, 14);
		panelSeccion.add(lblcantidaminSeccionParametro);
		
		lblCantidadMaxParametro = new JLabel("New label");
		lblCantidadMaxParametro.setForeground(Color.BLUE);
		lblCantidadMaxParametro.setBounds(303, 62, 110, 14);
		panelSeccion.add(lblCantidadMaxParametro);
		
		btnSalir = new JButton("");
		btnSalir.setBounds(365, 376, 89, 23);
		btnSalir.setForeground(Color.BLUE);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setBorder(null);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(PopupPagoDetalle.class.getResource("/imagenes/salir.png")));
		desktopPane.add(btnSalir);
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	GestionInscripcion gs = new GestionInscripcion();
	private JButton btnSalir;
	
	
	
	
	
	void mostrarcamposdetalle()throws ParseException{
		
		int idseleccionado = Integer.parseInt(txtcodDet.getText());	

		ArrayList<Inscripcion>lista=gs.buscarhorarioInscripcion(idseleccionado);		
		
		for(Inscripcion p :lista){
					//codigo=p.getCodcurso();
					
					lblCursoParamento.setText(p.getDescripcioCurso());
					lblCodigoCursoParametro.setText(p.getCodigoCurso());
					lblCreditoParametro.setText(""+p.getCreditoCurso());
					lblPrecioParametro.setText(""+p.getCostoCurso());
					
					lblseccionParametro.setText(p.getDescripcioSeccion());
					lblcodigoseccionParametro.setText(p.getCodigoSeccion());
					lbltiposeccionParametro.setText(p.getTipoSeccion());
					lblcantidaminSeccionParametro.setText(""+p.getCantMin());
					lblCantidadMaxParametro.setText(""+p.getCantMax());
					
					lblnombrePersonaParametro.setText(p.getNombrePersona());
					lblapellidoparametro.setText(p.getApellidoPersona());
					lblcorreoparametro.setText(p.getCorreoPersona());
					
					
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
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		dispose();
	}
}
