package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import mantenimientos.GestionNotas;

import clases.Inscripcion;
import clases.Notas;
import javax.swing.JButton;

public class FromPrincipalDocHorarios extends JInternalFrame implements ActionListener, KeyListener,MouseListener{

	private JFrame frame;
	private JDesktopPane desktopPane;
	private JPanel contentPane;
	
	JTextField txtusuarioPrincipal;

	private JScrollPane scrollPaneHorario;
	private DefaultTableModel modeloHorario;
	private JTable tblHorario;
	
	//String usuarioLogueado="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromPrincipalDocHorarios window = new FromPrincipalDocHorarios();
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
	public FromPrincipalDocHorarios() {
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
		
	
		
		txtusuarioPrincipal = new JTextField();
		txtusuarioPrincipal.setVisible(false);
		desktopPane.setLayout(null);
		txtusuarioPrincipal.setBounds(63, 479, 86, 20);
		desktopPane.add(txtusuarioPrincipal);
		txtusuarioPrincipal.setColumns(10);
		
		
		scrollPaneHorario = new JScrollPane();
		scrollPaneHorario.setBounds(69,32, 902, 402);
		desktopPane.add(scrollPaneHorario);
		
	
		tblHorario = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){
				 return false;
			 }
		 };
		 tblHorario.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		 tblHorario.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, Color.RED, Color.RED, Color.RED));
		 tblHorario.setForeground(Color.ORANGE);
		 tblHorario.setBackground(new Color(128, 128, 128));
		 tblHorario.addMouseListener(this);
		 tblHorario.setFillsViewportHeight(true);
		 scrollPaneHorario.setViewportView(tblHorario);
		
		modeloHorario= new DefaultTableModel();		
		modeloHorario.addColumn("ID CURSO");
		modeloHorario.addColumn("CURSO");
		modeloHorario.addColumn("ID SECCIÓN");
		modeloHorario.addColumn("SECCIÓN");
		modeloHorario.addColumn("TIPO");
		modeloHorario.addColumn("ID DOCENTE");
		modeloHorario.addColumn("DOCENTE");
		tblHorario.setModel(modeloHorario);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 
			}
		});
		btnSalir.setBounds(354, 536, 89, 23);
		desktopPane.add(btnSalir);
		
		listarPagoInscripcion();
	}

	GestionNotas gs = new GestionNotas(); 
	private JButton btnSalir;
	
	
	//System.out.println(usuarioLogueado);
	
	void listarPagoInscripcion(){
		String usuarioLogueado=txtusuarioPrincipal.getText();
		System.out.println(usuarioLogueado);
		ArrayList<Notas>lista=gs.listadocursoInscritos(usuarioLogueado);
		if(lista==null){
			System.out.println("nada");
		}else{
			modeloHorario.setRowCount(0);
			for(Notas p:lista){
				Object[]fila={
						p.getCodCurso(),
						p.getCurso(),
						p.getCodSeccion(),
						p.getAula(),
						p.getSeccion(),
						p.getCodDocente(),
						p.getDocente()
				}; modeloHorario.addRow(fila);
			}
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
