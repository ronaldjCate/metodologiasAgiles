package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import java.util.EventObject;

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
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


import clases.Seccion;
import mantenimientos.GestionSeccion;


public class FromPrinAdmSec extends JInternalFrame implements ActionListener, KeyListener, MouseListener,TableCellRenderer,TableCellEditor{

	private JFrame frame;
	
	private JPanel contentPane;
	private JLabel lblcodusuario;	
	private JLabel lblnombreusuario;
	
	private JButton btnNuevo;
	private JButton btnRefrescar;
	private JButton btnSalir;
	
	private JDesktopPane desktopPane;
	
	private JScrollPane scrollPaneSeccion;
	private JTable tblSeccion;
	private DefaultTableModel modeloSeccion;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromPrinAdmSec window = new FromPrinAdmSec();
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
	public FromPrinAdmSec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mantenimiento de Secciones");
		setBounds(100, 100, 861, 524);
		
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		try{
		desktopPane = new JDesktopPane(){
		Image img = javax.imageio.ImageIO.read(
				 new java.net.URL(getClass().getResource("/imagenes/fondocolegio.png"),"fondocolegio.png"));
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
		

		
		
		btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setIcon(new ImageIcon(FromPrinAdmSec.class.getResource("/imagenes/salir.png")));
		btnSalir.setBounds(526, 439, 309, 45);
		desktopPane.add(btnSalir);
		
		scrollPaneSeccion = new JScrollPane();
		scrollPaneSeccion.setBounds(25, 52, 786, 258);
		desktopPane.add(scrollPaneSeccion);
		
		tblSeccion = new JTable();
		tblSeccion = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int colIndex){
				 return false;
			 }
		 };
		tblSeccion.addMouseListener(this);				
		scrollPaneSeccion.setViewportView(tblSeccion);		
		
		modeloSeccion= new DefaultTableModel();
		modeloSeccion.addColumn("CÓDIGO");
		modeloSeccion.addColumn("NOMBRE SECCIÓN");
		modeloSeccion.addColumn("ACTIVO");
		modeloSeccion.addColumn("CANTIDAD MÁX");
		modeloSeccion.addColumn("CANTIDAD MIN");
		tblSeccion.setModel(modeloSeccion);
		
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FromPrinAdmSec.class.getResource("/imagenes/agregar.png")));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(0, 439, 250, 45);
		desktopPane.add(btnNuevo);
		
		btnRefrescar = new JButton("");
		btnRefrescar.setBackground(Color.WHITE);
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		btnRefrescar.setIcon(new ImageIcon(FromPrinAdmSec.class.getResource("/imagenes/update.png")));
		btnRefrescar.setBounds(249, 439, 278, 45);
		desktopPane.add(btnRefrescar);
		listar();
	}

	void listar(){
		GestionSeccion gs = new GestionSeccion();
		ArrayList<Seccion>lista=gs.listado();
		if(lista==null){
			
		}else{
			modeloSeccion.setRowCount(0);
			for(Seccion p:lista){
				Object[]fila={
						p.getCodigoSeccion(),
						p.getNom_seccion(),
						p.getTipo(),
						p.getCant_max_pers(),
						p.getCant_min_pers()
				}; modeloSeccion.addRow(fila);
			}
		}
	}

	@Override
	public void addCellEditorListener(CellEditorListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelCellEditing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(EventObject arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeCellEditorListener(CellEditorListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean shouldSelectCell(EventObject arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stopCellEditing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
			int arg5) {
		// TODO Auto-generated method stub
		return null;
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
		PopupPrinAdmSec pc =  new  PopupPrinAdmSec();
		desktopPane.add(pc);
		
		Dimension desktopSize=desktopPane.getSize();
		Dimension FrameSize= pc.getSize();
		pc.setLocation((desktopSize.width-FrameSize.width), (desktopSize.height-FrameSize.height));
		pc.setVisible(true);
	}

}
