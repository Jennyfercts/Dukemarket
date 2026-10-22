package connection;

import static com.mysql.cj.conf.PropertyKey.USER;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Gerencia a conexão com o banco de dados. Possui as instruções necessárias para conectar ao banco.
 * @author sesi2dia
 */
public class MySQLConnection {
    
    // define as strings de conexão com o banco.
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://172.16.0.30:3306/jennyfer_dukemarket";
    
    private static final String USER = "jennyfer";
    private static final String PASS = "2diSenai";
    


/*
* Cria a conexão com o banco de dados MySQL.
* @return
*/
public static Connection getConnection(){
    try {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    } catch(SQLExeption ex){
        throw new RuntimeException("Erro na conexao com o banco de dados. Verifique!", ex);
    } catch (ClassNotFoundException ex){
        throw new RuntimeException("Falha na carga do Driver", ex);
    }
}


/*
* Fecha a conexao com o DB
* @param conn Connection a ser fechada
*/
public static void closeConnection(Connection conn){
    try{
        if (conn != null){
            conn.close();
    } catch(SQLException ex){
                Logger.getLogger(
                    MySQLConnection.class.getName().log(Level.SEVERE, null, ex));
                }
    }
}
}