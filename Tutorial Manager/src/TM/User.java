package TM;

import java.util.regex.*;
import javax.swing.JOptionPane;

public class User {
    String name, password, role, org;
    
    public boolean isEmpty(Object o) {
        return o.equals("");
    }
    
    public static void interrupt(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public boolean isValidPhone(String phone) {
        // [n-m] -> range of the first character 
        // \\d -> digit
        // {N} -> number of digits 
        // $ -> end of sequence
        String format = "[6-9]\\d{9}$";
        Pattern p = Pattern.compile(format);
        Matcher m = p.matcher(phone);
        return m.matches(); //m.find()
    }
}