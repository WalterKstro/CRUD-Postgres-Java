package gt.edu.umg.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Walter Castro
 */
public class Connect {
    private static final String URL = "jdbc:postgresql://localhost:5432/jdbc-java";
    
    /**
     * Metodo que crea la conexion a la base de datos
     * @return
     * @throws SQLException 
     */
    public static synchronized Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, "postgres", "admin");
        return connection;
    }

    /**
     * Metodo que cierra la conexion de resulados
     * @param result
     * @throws SQLException 
     */
    public static void closeResultSet( ResultSet result ) throws SQLException {
        result.close();
    }
    /**
     * Metodo que cierra la sentencia SQL
     * @param statement
     * @throws SQLException 
     */
    public static void closePreparedStatement( PreparedStatement statement ) throws SQLException {
        statement.close();
    }
    /**
     * Metodo que cierra la conexion
     * @param connection
     * @throws SQLException 
     */
    public static void closeConnection( Connection connection ) throws SQLException {
        connection.close();
    }
}
