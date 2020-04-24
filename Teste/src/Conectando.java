import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Conectando {
	
	private static final String USER = "richard";
	private static final String PASS = "102030Zabbix";
	private static final String URL  = "jdbc:mysql://192.168.2.89:3306/zabbix";
	private ArrayList<String> resultado = new ArrayList<String>();
	
	
	
	public Conectando(String query) {
   
   Connection conn = null;
   Statement stmt = null;
   try{
     
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(URL,USER,PASS);

      stmt = conn.createStatement();
   
      ResultSet rs = stmt.executeQuery(query);

      
      while( rs.next()){
    	  
    	  
    	  String resul01 = rs.getString("name");
    	  String resul02 = rs.getString("sendto");
    	  
    	  
    	 resultado.add(resul01);
    	 resultado.add(resul02);       
      } 
      
  
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
    
      se.printStackTrace();
   }catch(Exception e){
  
      e.printStackTrace();
   }finally{
  
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   System.out.println("A conexão foi finalizada!");
   
}



	public ArrayList<String> getResultado() {
		return resultado;
	}



	public void setResultado(ArrayList<String> resultado) {
		this.resultado = resultado;
	}
	
}