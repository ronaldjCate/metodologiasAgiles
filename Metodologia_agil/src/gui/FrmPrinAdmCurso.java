package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import clases.Cursos;
import mantenimientos.GestionCursos;



public class FrmPrinAdmCurso extends JInternalFrame implements ActionListener,MouseListener{

	private JFrame frame;
	private JDesktopPane desktopPane;
	private JPanel contentPane;
	
	private JScrollPane scrollPanePersona;
	JTable tblPersona;
	private DefaultTableModel modeloPersona;
	
	private JButton btnBtnnuevo;
	private JButton btnSalir;
	private JButton btnRefrescar;
	private JTextField txtautocompleteapellido;
	private JTextField txtautocompletedni;
	private JLabel lblBuscadorDePersona;
	private JLabel lblBuscadorDePersonadni;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrinAdmCurso window = new FrmPrinAdmCurso();
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
	public FrmPrinAdmCurso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mantenimiento de Cursos");
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
		 modeloPersona.addColumn("NOMBRE");
		 modeloPersona.addColumn("CODIGO");
		 modeloPersona.addColumn("CRÉDITO");	
		 modeloPersona.addColumn("COSTO");	
		 tblPersona.setModel(modeloPersona);
		
		 
		 btnBtnnuevo = new JButton("");
		 btnBtnnuevo.addActionListener(this);
		 btnBtnnuevo.setBackground(Color.WHITE);
		 btnBtnnuevo.setIcon(new ImageIcon(FrmPrinAdmCurso.class.getResource("/imagenes/nuevo.png")));
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
		 btnSalir.setIcon(new ImageIcon(FrmPrinAdmCurso.class.getResource("/imagenes/salir.png")));
		 btnSalir.setBounds(727, 584, 337, 45);
		 desktopPane.add(btnSalir);
		 
		 btnRefrescar = new JButton("");
		 btnRefrescar.setBackground(Color.WHITE);
		 btnRefrescar.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
		  		listar();
		 }
		 });
		 btnRefrescar.setIcon(new ImageIcon(FrmPrinAdmCurso.class.getResource("/imagenes/update.png")));
		 btnRefrescar.setBounds(350, 584, 379, 45);
		 desktopPane.add(btnRefrescar);
		 
		 txtautocompleteapellido = new JTextField();
		 txtautocompleteapellido.addKeyListener(new KeyAdapter() {		 
			 TableRowSorter<DefaultTableModel> trs;
			@Override			
		 	public void keyTyped(KeyEvent arg0) {		 				 		
		 		
		 		txtautocompleteapellido.addKeyListener(new KeyAdapter() {
		 			
		 			@Override
		 			public void keyReleased(KeyEvent e) {
		 				// TODO Auto-generated method stub
		 				trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtautocompleteapellido.getText(),2));
		 			}		 			
				});
		 		trs = new  TableRowSorter<DefaultTableModel>(modeloPersona);
		 		tblPersona.setRowSorter(trs);
		 	}
		 });
		 txtautocompleteapellido.setBounds(215, 21, 216, 20);
		 desktopPane.add(txtautocompleteapellido);
		 txtautocompleteapellido.setColumns(10);
		 
		 
		 
		 lblBuscadorDePersona = new JLabel("Buscador de Curso x Nombre");
		 lblBuscadorDePersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblBuscadorDePersona.setForeground(Color.BLUE);
		 lblBuscadorDePersona.setBounds(23, 21, 182, 14);
		 desktopPane.add(lblBuscadorDePersona);
		 
		 listar();
	
	}
	
	void listar(){
		GestionCursos gs = new GestionCursos();
		ArrayList<Cursos>lista=gs.listado();
		if(lista==null){
			
		}else{
			modeloPersona.setRowCount(0);
			for(Cursos p:lista){
				
				Object[]fila={
						p.getDescripcion(),
						p.getCodigoCurso(),
						p.getCredito(),
						p.getCosto()					
				}; modeloPersona.addRow(fila);
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PopupPrinAdmCurso pr = new PopupPrinAdmCurso();
		desktopPane.add(pr);

		Dimension desktopSize=desktopPane.getSize();
		Dimension FrameSize= pr.getSize();
		pr.setLocation((desktopSize.width-FrameSize.width)/2, 1/(desktopSize.height-FrameSize.height/1));
		pr.setVisible(true);
	}

}
