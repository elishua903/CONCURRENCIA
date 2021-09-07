package CUENTA;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.*;

public class CVistaLogin extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton btnAceptar,btnSalir, btnInformacion;
	private JLabel lblUser, lblPassword, lblImagen;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private ImageIcon imagen;
	private Icon icono;

	
	

	public CVistaLogin()
	{
		 this.setTitle("INICIO DE SESIÓN");//TITULO A LA PANTALLA
		 this.setSize(600,350);//TAMAÑO DE LA PANTALLA
		 this.setIconImage(Toolkit.getDefaultToolkit().getImage("LOGO_TEC_PNG_OK.png"));//LOGO DE LA INTERFAZ
		 this.setLocationRelativeTo(null);//PANTALLA CENTRADA
		 this.setLayout(null);//SIN LAYOUT
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);//QUE AL CERRAR LA VENTANA SE FINALICE LA EJECUCION
		 this.setResizable(false);
		 ObjetosInterfaz();
		 
		 
			 
	}
	
	
	
	private void ObjetosInterfaz() 
	{
		
		 //ETIQUETA USUARIO
		 lblUser = new JLabel();
		 lblUser.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
		 lblUser.setText("USUARIO");
		 lblUser.setBounds(40,80,250,20);
		 add(lblUser);
		 
		 //CAJA DE TEXTO USUARIO
		 txtUser = new JTextField();
		 txtUser.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
		 txtUser.setBounds(150,80,150,20);
		 add(txtUser);
		 txtUser.addKeyListener((KeyListener) new KeyListener(){
			 
			 public void keyTyped(KeyEvent e)
			  
			 {
				 char c=e.getKeyChar();
				 
				 if(Character.isLowerCase(c))
				 {
					 String cad=(""+c).toUpperCase();
					 c=cad.charAt(0);
					 e.setKeyChar(c);
				 }
				 
				 if (txtUser.getText().length()== 10)
			  
			      e.consume();
			 
			 }

			@Override
			public void keyPressed(KeyEvent e) 
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		 });
	
		 
		 
		//ETIQUETA CONTRASEÑA
		 lblPassword = new JLabel();
		 lblPassword.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
		 lblPassword.setText("CONTRASEÑA");
		 lblPassword.setBounds(40,160,250,20);
		 add(lblPassword);

		 //CAJA DE TEXTO PASSWORD
		 txtPassword = new JPasswordField();
		 txtPassword.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
		 txtPassword.setBounds(150,160,150,20);
		 add(txtPassword);
		 txtPassword.addKeyListener((KeyListener) new KeyListener(){
			 
			 public void keyTyped(KeyEvent e)
			  
			 {if (txtPassword.getText().length()== 3)
			  
			      e.consume();
			 }

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		 
		//ETIQUETA IMAGEN 
		 lblImagen = new JLabel("");
		 lblImagen.setBounds(320,30,200,200);
		 imagen = new ImageIcon("USER.png");
		 icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
		 lblImagen.setIcon(icono);
		 add(lblImagen);
		 		 
		//BOTON ACEPTAR
		 btnAceptar = new JButton();
		 btnAceptar.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
		 btnAceptar.setText("ACEPTAR");
		 btnAceptar.setBounds(300,250,120,30);
		 btnAceptar.setCursor(new Cursor(HAND_CURSOR));
		 btnAceptar.setFocusable(false);
		 add(btnAceptar);
		 btnAceptar.addActionListener(this);
		 
		 
		//BOTON SALIR
		 btnSalir = new JButton();
		 btnSalir.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
		 btnSalir.setText("SALIR");
		 btnSalir.setBounds(430,250,120,30);
		 btnSalir.setCursor(new Cursor(HAND_CURSOR));
		 btnSalir.setFocusable(false);
		 add(btnSalir);
		 btnSalir.addActionListener(this);
		 
				 
		//BOTON INFROMACION
		 btnInformacion = new JButton();
		 btnInformacion.setBounds(530,10,25,25);
		 imagen = new ImageIcon("INFORMACION.png");
		 icono = new ImageIcon(imagen.getImage().getScaledInstance(btnInformacion.getWidth(), btnInformacion.getHeight(), Image.SCALE_DEFAULT));
		 btnInformacion.setIcon(icono);
		 btnInformacion.setBorder(null);
		 btnInformacion.setBackground(Color.WHITE);
		 btnInformacion.setCursor(new Cursor(HAND_CURSOR));
		 btnInformacion.setFocusable(false);
		 btnInformacion.setFocusPainted(false);
		 btnInformacion.setContentAreaFilled (false);
		 add(btnInformacion);
		 btnInformacion.addActionListener(this);
		 
		 
		
	

	}
	


	public void Limpiar()
	{
		txtUser.setText("");
		txtPassword.setText("");
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String usuario = "";
		String password = "";
		if (e.getSource() == btnAceptar) 
		{

            usuario = txtUser.getText();
	 		password= txtPassword.getText();

            if ((password.isEmpty() || usuario.isEmpty())) 
            {
            	
                JOptionPane.showMessageDialog(null, "Ingrese su nombre de usuario y contraseña");

            } 
            else 
            {
            	    	
            	Conexion conectar = new Conexion(usuario, password);
                java.sql.Connection cn = conectar.connect();

                if (cn != null) 
                {

                    JOptionPane.showMessageDialog(null, "Conectado");
                    dispose();
                    
                    CVistaRetiros app = new CVistaRetiros(usuario,password);
            		app.setVisible(true);

                    try 
                    {
                    	
                        cn.close();

                    } 
                    catch (SQLException ex) 
                    {
                    	
                        System.out.println("Error al conectar " + ex);

                    }

                }
                else
                {
                	
                	Limpiar();
                	JOptionPane.showMessageDialog(null, "No es posible realizar la conexión.\nVerifique su usuario y contraseña");
                	
                }
             }
            
            	 

            
        }

		
		if(e.getSource()==btnInformacion) 
		{
			
			JOptionPane.showMessageDialog(null, "PROGRAMA REALIZADO POR LOS ALUMNOS: \nBLANCO RAMÍREZ ELISEO \nCALDERÓN PEÑA DAVID ALONSO \nGÁMEZ CARRASCO JOSUÉ RAZIEL \nLÓPEZ MAYA ANA KAREN \nTORTOLEDO RODRÍGUEZ KEVIN ANDRÉS");
		
		}
		if(e.getSource()==btnSalir) 
		{
			
			System.exit(0);
			
		}
		
	}
	
	

	
}

