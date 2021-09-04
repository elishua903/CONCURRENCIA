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
import java.util.ArrayList;

import javax.swing.*;

public class CVistaRetiros extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton btnRetirar,btnSalir,btnLimpiar, btnInformacion;
	private JLabel lblChequera, lblCantidad,lblUser, lblImagen, lblCajero;
	private JTextField txtCantidad;
	private JComboBox<String> cmbChequera;
	private ImageIcon imagen;
	private Icon icono;
	String usuario ="", contrasenia="";

	
	

	public CVistaRetiros(String user, String password)
	{
		 usuario = user;
		 contrasenia = password;
		 
		
	        
		 this.setTitle("LOGIN");//TITULO A LA PANTALLA
		 this.setSize(600,350);//TAMAÑO DE LA PANTALLA
		 this.setIconImage(Toolkit.getDefaultToolkit().getImage("LOGO_TEC_PNG_OK.png"));//LOGO DE LA INTERFAZ
		 this.setLocationRelativeTo(null);//PANTALLA CENTRADA
		 this.setLayout(null);//SIN LAYOUT
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);//QUE AL CERRAR LA VENTANA SE FINALICE LA EJECUCION
		 this.setResizable(false);
		 ObjetosInterfaz();
		 ObtenerCheques();
		 
		 
		 
			 
	}
	
	
	
	private void ObjetosInterfaz() 
	{
		
		
		
		 
		 
		//ETIQUETA CHEQUERA
		 lblChequera = new JLabel();
		 lblChequera.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
		 lblChequera.setText("N° CUENTA");
		 lblChequera.setBounds(40,80,250,20);
		 add(lblChequera);

		 //CAJA DE TEXTO CHEQUERA
		 cmbChequera = new JComboBox();
		 cmbChequera.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
		 cmbChequera.setBounds(150,80,150,20);
		 add(cmbChequera);		
		
		 //ETIQUETA CANTIDAD
		 lblCantidad = new JLabel();
		 lblCantidad.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
		 lblCantidad.setText("CANTIDAD");
		 lblCantidad.setBounds(40,160,250,20);
		 add(lblCantidad);
		 
		 //CAJA DE TEXTO CANTIDAD
		 txtCantidad = new JTextField();
		 txtCantidad.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
		 txtCantidad.setBounds(150,160,150,20);
		 add(txtCantidad);
		 txtCantidad.addKeyListener((KeyListener) new KeyListener(){
			 
			 public void keyTyped(KeyEvent e)
			  
			 {
				 char car = e.getKeyChar();
				 if(Character.isDigit(car)){

				 }else{
				 e.consume();
				 getToolkit().beep();
				 }
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
	
		
		//ETIQUETA IMAGEN 
		 lblImagen = new JLabel("");
		 lblImagen.setBounds(40,10,35,35);
		 imagen = new ImageIcon("USER.png");
		 icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
		 lblImagen.setIcon(icono);
		 add(lblImagen);
		 
		//ETIQUETA USUARIO
		 lblUser = new JLabel();
		 lblUser.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
		 lblUser.setText(usuario);
		 lblUser.setBounds(80,20,250,20);
		 add(lblUser);
		 		 
		//BOTON ACEPTAR
		 btnRetirar = new JButton();
		 btnRetirar.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
		 btnRetirar.setText("RETIRAR");
		 btnRetirar.setBounds(170,250,120,30);
		 btnRetirar.setCursor(new Cursor(HAND_CURSOR));
		 btnRetirar.setFocusable(false);
		 add(btnRetirar);
		 btnRetirar.addActionListener(this);
		 
		 
		 //BOTON LIMPIAR
		 btnLimpiar = new JButton();
		 btnLimpiar.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
		 btnLimpiar.setText("LIMPIAR");
		 btnLimpiar.setBounds(300,250,120,30);
		 btnLimpiar.setCursor(new Cursor(HAND_CURSOR));
		 btnLimpiar.setFocusable(false);
		 add(btnLimpiar);
		 btnLimpiar.addActionListener(this);
		 
		 
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
		 
		 
		//ETIQUETA IMAGEN CAJERO 
		 lblCajero = new JLabel("");
		 lblCajero.setBounds(335,60,210,150);
		 imagen = new ImageIcon("CAJERO.png");
		 icono = new ImageIcon(imagen.getImage().getScaledInstance(lblCajero.getWidth(), lblCajero.getHeight(), Image.SCALE_DEFAULT));
		 lblCajero.setIcon(icono);
		 add(lblCajero);
		 

	}
	


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String resultado = ""; 
		String cuenta = "";
		String cantidad = "";
		if (e.getSource() == btnRetirar) 
		{

            cuenta= cmbChequera.getSelectedItem().toString();
			cantidad = txtCantidad.getText();

            if ((cuenta.equals("*-SELECCIONE-*") || cantidad.isEmpty())) 
            {
            	
                JOptionPane.showMessageDialog(null, "Seleccione una CUENTA o ingrese una CANTIDAD");

            } 
            else 
            {
            	if(Integer.parseInt(cantidad) <= 0 )
            	{
            		JOptionPane.showMessageDialog(null, "Ingrese una CANTIDAD VALIDA");
            	}
            	else
            	{
            		Conexion conectar = new Conexion(usuario, Encrypt.deecnode(contrasenia));
                    java.sql.Connection cn = conectar.connect();

                    if (cn != null) 
                    {

                        

                        try 
                        {
                        	
                            long time_start, time_end;
                            time_start = System.currentTimeMillis();
                            
                            for (int i = 0; i < 100; i++) 
                            {
                                resultado = conectar.storeProcedure(cuenta, Integer.parseInt(cantidad));
                                System.out.println("Transacion No.: " + (i+1));
                            }
                            
                            time_end = System.currentTimeMillis();
                            System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
                            cn.close();
                            JOptionPane.showMessageDialog(null, resultado);
                            

                        } 
                        catch (SQLException ex) 
                        {
                        	JOptionPane.showMessageDialog(null, "Error al RETIRAR");

                        }

                    }
                    else
                    {
                    	
                    	Limpiar();
                    	JOptionPane.showMessageDialog(null, "No es posible realizar RETIRAR en estos momentos, intente mas tarde.");
                    	
                    }
            	}
            	    	
            	
            }
            
            	 

            
        }

		
		if(e.getSource()==btnInformacion) 
		{
			
			JOptionPane.showMessageDialog(null, "PROGRAMA REALIZADO POR LOS ALUMNOS: \nBLANCO RAMIREZ ELISEO \nCALDERON PEÑA DAVID ALONSO \nGAMEZ CARRAZCO JOSUE RAZIEL \nLOPEZ MAYA ANA KAREN \nTORTOLEDO RODRIGUEZ KEVIN ANDRES");
		
		}
		
		if(e.getSource()==btnLimpiar)
		{
			Limpiar();
		}
		
		if(e.getSource()==btnSalir) 
		{
			
			System.exit(0);
			
		}
		
		
	}
	
	
	
	public void Limpiar()
	{
		cmbChequera.setSelectedIndex(0);
		txtCantidad.setText("");
	}
	
	
	
	
	public void ObtenerCheques()
	{
		 Conexion conectar = new Conexion(usuario, Encrypt.deecnode(contrasenia));
         java.sql.Connection cn = conectar.connect();
	     
         if (cn != null) 
         {
		    cmbChequera.removeAllItems();
		    cmbChequera.addItem("*-SELECCIONE-*");
	        ArrayList<String> lista = new ArrayList<String>();
	        lista = Conexion.llenar_combo(cn);
	        for(int i = 0; i<lista.size();i++){
	        	cmbChequera.addItem(lista.get(i));
	        }
	        
	        try 
            {

                cn.close();

            } 
            catch (SQLException ex) 
            {
            	
                System.out.println("Error al conectar " + ex);

            }

        }
	}
	
	

	
}

