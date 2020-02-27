package gt.edu.umg.maping;

/**
 *
 * @author Walter Castro
 */
public class Persona {
    private int id_student;
    private String first_name;
    private String last_name;

    /**
     * @return the id_student
     */
    public int getId_student() {
        return id_student;
    }

    public Persona(int id_student, String first_name, String last_name) {
        this.id_student = id_student;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    /**
     * @param id_student the id_student to set
     */
    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "id_student=" + id_student + ", first_name=" + first_name + ", last_name=" + last_name;
    }
    
}
