package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import clases.Persona;
import mantenimientos.GestionPersona;


public class FrmPrinAdmPers  extends JInternalFrame implements ActionListener,MouseListener{

	private JDesktopPane desktopPane;
	private JPanel contentPane;
	
	private JScrollPane scrollPanePersona;
	JTable tblPersona;
	private DefaultTableModel modeloPersona;
	
	private JButton btnBtnnuevo;
	private JButton btnSalir;
	private JButton btnRefrescar;

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrinAdmPers window = new FrmPrinAdmPers();
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
	public FrmPrinAdmPers() {
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
		}
		catch(IOException e){
		 e.printStackTrace();
		}
			
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
			
		
		 scrollPanePersona = new JScrollPane();
		 scrollPanePersona.setBounds(23, 52, 1010, 428);
		 desktopPane.add(scrollPanePersona);
		 
		 
		    
		 tblPersona = new JTable();
		 tblPersona = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){				
				 return false;
			 }
			/*
			@SuppressWarnings("unused")
			public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column){
				//tblPersona.getColumnModel().getColumn(0).setCellRenderer(this.setBackground( new Color(0,200,0)));  
			      //return this;			
			}*/
		 };
		 tblPersona.addMouseListener(this);
		 
		 tblPersona.setForeground(Color.blue);
		 tblPersona.setBackground(Color.lightGray);
		 scrollPanePersona.setViewportView(tblPersona);              
		    
		    
		 modeloPersona= new DefaultTableModel();
		 modeloPersona.addColumn("NOMBRES");
		 modeloPersona.addColumn("APELLIDOS");		 
		 modeloPersona.addColumn("SEXO");		
		 modeloPersona.addColumn("DNI");
		 modeloPersona.addColumn("TIPO");
		 tblPersona.setModel(modeloPersona);
		
		 
		 btnBtnnuevo = new JButton("");
		 btnBtnnuevo.addActionListener(this);
		 btnBtnnuevo.setBackground(Color.WHITE);
		 btnBtnnuevo.setIcon(new ImageIcon(FrmPrinAdmPers.class.getResource("/imagenes/nuevo.png")));
		 btnBtnnuevo.setBounds(0, 584, 352, 45);
		 desktopPane.add(btnBtnnuevo);
		    
		 
		 btnSalir = new JButton("");
		 btnSalir.setBackground(Color.WHITE);
		 btnSalir.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
			  		dispose();
			 }
			 });
		 btnSalir.addActionListener(this);
		 btnSalir.setIcon(new ImageIcon(FrmPrinAdmPers.class.getResource("/imagenes/salir.png")));
		 btnSalir.setBounds(727, 584, 337, 45);
		 desktopPane.add(btnSalir);
		 
		 btnRefrescar = new JButton("");
		 btnRefrescar.setBackground(Color.WHITE);
		 btnRefrescar.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
		  		listar();
		 }
		 });
		 btnRefrescar.setIcon(new ImageIcon(FrmPrinAdmPers.class.getResource("/imagenes/update.png")));
		 btnRefrescar.setBounds(350, 584, 379, 45);
		 desktopPane.add(btnRefrescar);
		 
		 listar();
	}
	
	
	void listar(){
		GestionPersona gp = new GestionPersona();
		ArrayList<Persona>lista = gp.listadopersona();
		if(lista==null){
			
		}else{
			modeloPersona.setRowCount(0);
			for (Persona p : lista) {
				Object[]fila={
						p.getNombre(),
						p.getApellido(),
						p.getSexo(),
						p.getDniPersona(),
						p.getTb_tipo_descripcion()						

				};modeloPersona.addRow(fila);
			}
		}
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
		PopupPrinAdmPer pr = new PopupPrinAdmPer();
		desktopPane.add(pr);
		Dimension desktopSize=desktopPane.getSize();
		Dimension FrameSize= pr.getSize();
		pr.setLocation((desktopSize.width-FrameSize.width)/2, 1/(desktopSize.height-FrameSize.height/1));
		pr.setVisible(true);
	}

}
