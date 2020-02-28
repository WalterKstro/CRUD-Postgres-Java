package gt.edu.umg.main;

import gt.edu.umg.connect.Connect;
import gt.edu.umg.maping.Persona;
import gt.edu.umg.operations.Operations;
import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author Walter Castro
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        
        Connection con = Connect.getConnection();
        
        if( con.getAutoCommit()) {
            con.setAutoCommit(false);
        }
        Operations opt = new Operations(con);
        
        try{
            opt.updateData(3, "Gabriela", "Luquez");
            opt.insertData(new Persona(4, "Diego", "Antonio"));
        
           con.commit();
        }catch(SQLException e){
            try{
                e.printStackTrace();
                con.rollback();
                System.out.println("Realizando Callback a las transacciones");
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
    }
}
