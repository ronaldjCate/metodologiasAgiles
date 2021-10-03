  
package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import clases.Acceso;
import clases.Perfil;
import mantenimientos.GestionAdministrador;

/*
import clases.Acceso;
import mantenimientos.GestionAdministrador;
*/


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JComboBox;

public class Login extends JFrame implements ActionListener {

  private JPanel contentPane;
  private JTextField txtusuario;
  private JPasswordField pwdPassword;
  private JComboBox<String> cboPerfil;
  
  private JDesktopPane desktopPane;
  
  String descripcionPerfil;
  
  public static JLabel lblseg;
  
  

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Login frame = new Login();
          frame.setVisible(true);
          
           /*ImageIcon ImageIcon = new ImageIcon("/imagenes/pagos.png");
             Image image = ImageIcon.getImage();
             this.setIconImage(image);*/
             //frame.setSize(500,500);
             frame.setLocationRelativeTo(null);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }   
    });
  }

  /**
   * Create the frame.
   */
  public Login() {
    //setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
    setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagenes/upc.png")));
    setResizable(false);
    
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //setBounds(100, 100, 896, 576);
    setTitle("UNIVERSIDAD PERUANA DE CIENCIAS APLICADAS ® >>> SISTEMA DE CONTROL DE MATRICULA");
    
    getContentPane().setLayout(null);
    setTitle("UNIVERSIDAD PERUANA DE CIENCIAS APLICADAS ® >>> SISTEMA DE CONTROL DE MATRICULA");
    //setIconImage(new ImageIcon("imagenes/loginiacm.jpg").getImage());
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0,0));
    setContentPane(contentPane);
    

    try{
      desktopPane = new JDesktopPane(){
      Image img = javax.imageio.ImageIO.read(
           new java.net.URL(getClass().getResource("/imagenes/upc_login.jpg"),"fondologin.jpg"));
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
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 655, 703);
    
    txtusuario = new JTextField();
    txtusuario.setBackground(Color.LIGHT_GRAY);
    txtusuario.setForeground(Color.RED);
    txtusuario.setFont(new Font("Segoe Print", Font.PLAIN, 20));
    
    txtusuario.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent arg0) {
        int numerocaracteres=8;
          if(txtusuario.getText().length()>=numerocaracteres){
            arg0.consume();
            JOptionPane.showMessageDialog(null, "El DNI tiene solo 8 caracteres");
          }
        char c = arg0.getKeyChar();       
      }
    });
    txtusuario.setBounds(169, 254, 324, 52);
    txtusuario.addActionListener(this);
    desktopPane.add(txtusuario);
    txtusuario.setColumns(10);
    txtusuario.requestFocus();
    
    pwdPassword = new JPasswordField();
    pwdPassword.setBackground(Color.LIGHT_GRAY);
    pwdPassword.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_ENTER) {
           ingresopanelprincipal(); //Método que tienes que crearte
                }       
      }
    });
    pwdPassword.setFont(new Font("Segoe Print", Font.PLAIN, 20));
    pwdPassword.setForeground(Color.RED);
    pwdPassword.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        int numerocaracteres=8;
        if(pwdPassword.getText().length()>=numerocaracteres){
        e.consume();
        JOptionPane.showMessageDialog(null, "La contraseña solo tiene 8 dígitos");
        }
      }
    });
    pwdPassword.setBounds(169, 337, 324, 52);
    desktopPane.add(pwdPassword);
    
 
    
   
    cboPerfil  = new JComboBox<String>();
    cboPerfil.setForeground(Color.RED);
    cboPerfil.setFont(new Font("Segoe Print", Font.PLAIN, 20));
    cboPerfil.setBackground(Color.LIGHT_GRAY);
    cboPerfil.addItemListener(event -> {
    	if (event.getStateChange() == ItemEvent.SELECTED) {
        	//txtperiodo.setText(event.getItem().toString());
        	descripcionPerfil=(event.getItem().toString());
        	//listadomatricula();
        }
    });
    cboPerfil.setBounds(171, 175, 322, 52);
    desktopPane.add(cboPerfil);
    
    btnIngresar = new JButton("Ingresar");
    btnIngresar.setFont(new Font("Segoe Print", Font.PLAIN, 20));
    btnIngresar.addActionListener(this);
    btnIngresar.setForeground(Color.WHITE);
    btnIngresar.setBackground(Color.RED);
    btnIngresar.setBounds(169, 421, 324, 52);
    desktopPane.add(btnIngresar);
    
    llenacombo();
    
    //iniciarTiempo();
   

    //ingreso();    
  }
  
  @Override
  public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub
	  if(arg0.getSource()==btnIngresar){
			actionperformedbtnIngresar();
		}
  }
  
  private void actionperformedbtnIngresar() {
	// TODO Auto-generated method stub
	  ingresopanelprincipal();
}

GestionAdministrador ga = new GestionAdministrador();
  private JButton btnIngresar;
  
  String  leerusuario(){
    return txtusuario.getText();
  }
  
  String leercontra() {
	  return pwdPassword.getText();
  }
  
	void llenacombo(){		
		ArrayList<Perfil> lista = ga.listadoPerfil();
		cboPerfil.addItem("Seleccione");
		for (Perfil t : lista) {
			cboPerfil.addItem(t.getDescripcion());			
		}		
	}

  void ingresopanelprincipal(){
		String perfil, usuario, clave, contrasenna;
	    int idtb_personas,idtb_acceso;
	    
	    perfil = descripcionPerfil;
	    usuario = txtusuario.getText();
	    contrasenna =pwdPassword.getText();
	    
	    
	    
	        
	    Acceso u = new GestionAdministrador().iniciarsesion(perfil,usuario, contrasenna);	
	    System.out.println("Perfil:"+perfil);
	    
	    if(perfil.equals("Seleccione")){
	    	 JOptionPane.showMessageDialog(null, "Seleccione el tipo de perfil");
	    }else if(leerusuario().isEmpty()){
	    	 JOptionPane.showMessageDialog(null, "Ingrese el usuario");
	    }else if(leercontra().isEmpty()){
	    	 JOptionPane.showMessageDialog(null, "Ingrese la contraseña");
	    }
	    else if(perfil.equals("Administrador")){
 	    	
		      FromPrincipalAdministrador p = new FromPrincipalAdministrador();
		      JOptionPane.showMessageDialog(null, "Bienvenido "+u.getUsuario());
		      p.setVisible(true);
		      perfil=u.getPerfil();
		      usuario=u.getUsuario();
		      contrasenna=u.getContrasenna();
		      p.setExtendedState(JFrame.MAXIMIZED_BOTH);
		      dispose();      	      
		    
	   }else if(perfil.equals("Alumno")){
	    	
		      FromPrincipalAlumno p = new FromPrincipalAlumno();
		      JOptionPane.showMessageDialog(null, "Bienvenido "+u.getUsuario());
		      p.setVisible(true);
		      perfil=u.getPerfil();
		      usuario=u.getUsuario();
		      contrasenna=u.getContrasenna();
		      p.setExtendedState(JFrame.MAXIMIZED_BOTH);
		      dispose();      	      
		      p.txtusuarioPrincipal.setText(txtusuario.getText());
		    
	   }else if(perfil.equals("Docente")){
	    	
		   	FromPrincipalDocente p = new FromPrincipalDocente();
		    JOptionPane.showMessageDialog(null, "Bienvenido "+u.getUsuario());
		    p.setVisible(true);
		    perfil=u.getPerfil();
		    usuario=u.getUsuario();
		    contrasenna=u.getContrasenna();
		    p.setExtendedState(JFrame.MAXIMIZED_BOTH);
		    dispose();      	      
		    p.txtusuarioPrincipal.setText(txtusuario.getText());
		    
	   }
  }

}
