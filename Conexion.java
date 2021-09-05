package CUENTA;
import java.sql.*;
import java.util.ArrayList;

public class Conexion 
{
    String url = "jdbc:sqlserver://25.96.69.6:1433;database=Cuentas",user = "",password =  "";
    static ResultSet resultado=null;
    static PreparedStatement sentencia=null;
    
    public Conexion(String usuario, String contraseña)
    {
    	  user = usuario;
          password = Encrypt.ecnode(contraseña);
    }

    public Connection connect()
    {
        Connection connection = null;
      
        try 
        {
            connection = DriverManager.getConnection(url, user, Encrypt.deecnode(password));
        } 
        catch (Exception e) 
        {
            System.out.println("La conexion fallo");
            return null;
        }
        System.out.println("La conexion tuvo exito");
        return connection; 
    }
    
    
    public static ArrayList<String> llenar_combo(Connection cn)
    {
    	java.sql.Connection conexion = cn;
        ArrayList<String> lista = new ArrayList<String>();
        String q = "SELECT NOCUENTA FROM CHEQUES";
        
        try 
        {
        	sentencia = conexion.prepareStatement(q);
        	resultado = sentencia.executeQuery();
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("No Correcto");
        }
        try {
            while(resultado.next()){
                lista.add(resultado.getString("NOCUENTA"));
            }
        } catch (Exception e) {
        }
        return lista;
    }

 

    public String storeProcedure(String chequera, int retiro){
        try {
            CallableStatement clbleStmt = connect().prepareCall("{call sp_RetirarDinero(?,?)}");
            clbleStmt.setString(1, chequera);
            clbleStmt.setInt(2, retiro);
            clbleStmt.execute();
            System.out.println("Transacion realizada exitosamente!");
            return "Transacion realizada exitosamente!";
        } catch (SQLException e) 
        {
        	System.out.println(e.getMessage()+"");
            return e.getMessage()+"";
        }
    }
    
    
    

    /*
    
create   procedure sp_RetirarDinero @Chequera varchar(50), @Cantidad money as 
        
begin	
                                                                                 
	begin tran
                                                                            
	DECLARE @FONDOS MONEY;
                                                                
	SET @FONDOS = (SELECT importe from cheques WITH (UPDLOCK) where nocuenta = @Chequera);

	PRINT @FONDOS
                                                                         
	if(@FONDOS<@Cantidad)
                                                                 
		BEGIN 
                                                                                
			RAISERROR('Fondos insuficientes',16,1);
                                               
			ROLLBACK TRAN
                                                                         
			RETURN
                                                                                
		END
                                                                                   
	BEGIN TRY
                                                                             
		UPDATE Cheques SET Importe = @FONDOS - @Cantidad where NoCuenta = @Chequera
           
		COMMIT TRAN
                                                                           
		RETURN 
                                                                               
	END TRY
                                                                               
	BEGIN CATCH
                                                                           
		RAISERROR('Algo salio mal.',16,1);
                                                    
		ROLLBACK TRAN
                                                                         
		RETURN
                                                                                
	END CATCH
                                                                             
END
    */
}
