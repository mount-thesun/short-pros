package TM;

import java.util.Date;
import javax.swing.JOptionPane;

public class Student {
    String organisation, name, phone;
    int ID, standard, fee;
    Date date;
    long dateLong; 
    String month;
    boolean present, paid;
}

class NoIdException extends Exception {
    public NoIdException() {
        JOptionPane.showMessageDialog(null, "ID has not been entered.", "Message", JOptionPane.UNDEFINED_CONDITION);
    }
}