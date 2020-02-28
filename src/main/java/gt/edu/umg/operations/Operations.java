package gt.edu.umg.operations;

import gt.edu.umg.connect.Connect;
import gt.edu.umg.maping.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Walter Castro
 */
public class Operations {

     private final String INSERT = "INSERT INTO public.students (id_student, first_name, last_name) VALUES  (?,?,?)";
     private final String SELECT = "SELECT id_student, first_name, last_name FROM public.students";
     private final String DELETE = "DELETE FROM public.students WHERE id_student = ?";
     private final String UPDATE = "UPDATE public.students SET first_name=?, last_name=? WHERE id_student = ?";
     
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    
     public Operations() {
    }
    public Operations( Connection con ) {
        this.connection = con;
    } 
    
     
    /**
     * Funcion que inserta a la base de datos
     * @param persona
     * @return
     * @throws SQLException 
     */ 
    public int insertData(Persona persona) throws SQLException {
         int count = 0;
         try {
             connection = this.connection != null ? this.connection : Connect.getConnection();
             statement = connection.prepareStatement(INSERT);
             
             statement.setInt(1, persona.getId_student());
             statement.setString(2, persona.getFirst_name());
             statement.setString(3, persona.getLast_name());
             
             count = statement.executeUpdate();             
             
         }finally{
             Connect.closePreparedStatement(statement);
             if(this.connection == null) {
                 Connect.closeConnection(connection);
             }
             return count;
         }
     }
    
    /**
     * Funcion que actualiza datos en la base de datos
     * @param id
     * @param nombre
     * @param apellido
     * @return
     * @throws SQLException 
     */
    public int updateData( int id, String nombre, String apellido) throws SQLException {
        int count = 0;
         try {
             connection = this.connection != null ? this.connection : Connect.getConnection();
             statement = connection.prepareStatement(UPDATE);
             
             statement.setString(1, nombre);
             statement.setString(2, apellido);
             statement.setInt(3, id);
             
             count = statement.executeUpdate();
             
         }finally {
             Connect.closePreparedStatement(statement);
             if(this.connection == null) {
                 Connect.closeConnection(connection);
             }
         }
         
         return count;
    }
    
    /**
     * Funcion que elimina un registro en la base de datos
     * @param id
     * @return
     * @throws SQLException 
     */
    public int deleteData( int id ) throws SQLException {
        int count = 0;
         try {
             connection = this.connection != null ? this.connection : Connect.getConnection();
             statement = connection.prepareStatement(DELETE);
             
             statement.setInt(1, id);
             
             count = statement.executeUpdate();
             
         }finally {
             Connect.closePreparedStatement(statement);
             if( this.connection == null ) {
                 Connect.closeConnection(connection);
             }
         }
         return count;
    }
    
    /**
     * Funcion que lista todos los registros de la base de datos
     * @return
     * @throws SQLException 
     */
    public ArrayList<Persona> selectData() throws SQLException {
        ArrayList<Persona> registros = new ArrayList<>();
        Persona persona = null;
         try {
             connection = this.connection != null ? this.connection : Connect.getConnection();
             statement = connection.prepareStatement(SELECT);
             result = statement.executeQuery();
             
             while (result.next()) {                 
                 persona = new Persona(result.getInt(1), result.getString(2), result.getString(3));
                 registros.add(persona);
             }
         }finally {
             Connect.closeResultSet(result);
             Connect.closePreparedStatement(statement);
             if(this.connection == null) {
                 Connect.closeConnection(connection);
             }
         }
         return registros;
    }
}
