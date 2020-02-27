package gt.edu.umg.main;

import gt.edu.umg.maping.Persona;
import gt.edu.umg.operations.Operations;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Walter Castro
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Operations opt = new Operations();
        //Persona p1 = new Persona(3,"Astrid","Luquez");
        ArrayList<Persona> listado = opt.selectData();
        
        for (Persona persona : listado) {
            System.out.println(persona.toString());
        }
        
        //opt.insertData(p1);
        //opt.updateData(3, "Astrid", "Castro");
        //opt.deleteData(3);
        
    }
}
