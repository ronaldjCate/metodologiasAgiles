package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import java.awt.Color;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class FrmVideo extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	
	private final JFXPanel jfxPanel = new JFXPanel();
	private JButton btnSalir;
	
	public FrmVideo(){
		initComponents();
		
		createScence();		
		setTitle("Clase Grabada");		
		setResizable(false);
		setLocationRelativeTo(null);
		panel.setLayout(new BorderLayout());
		panel.add(jfxPanel,BorderLayout.CENTER);
		
		btnSalir = new JButton("");
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setBorder(null);
		btnSalir.setIcon(new ImageIcon(FromPrincipalAlumHoraDisponible.class.getResource("/imagenes/salir.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(259, 384, 89, 23);
		contentPane.add(btnSalir);
		this.setLocationRelativeTo(null);
		
	}
	
	private void createScence(){
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				File file = new File("F:\\Profesion\\upc\\metodologiaagil\\video\\Scrum.mp4");
				MediaPlayer oracleVid = new MediaPlayer(new Media(file.toURI().toString()));
			jfxPanel.setScene(new Scene(new Group(new MediaView(oracleVid))));
			oracleVid.setVolume(0.7);
			oracleVid.setCycleCount(MediaPlayer.INDEFINITE);
			oracleVid.play();
			}			
		});
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 644, 360);
		contentPane.add(panel);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVideo frame = new FrmVideo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
