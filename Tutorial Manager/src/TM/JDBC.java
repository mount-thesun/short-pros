package TM;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class JDBC {
    
    final private String url = "jdbc:mysql://127.0.0.1:3306/tutorial";
    final private String username = "User";
    final private String password = "World2day!";
    
    /* Queries */
    // Login  
    private String selectAdmin = "SELECT * FROM ADMIN WHERE username=? AND password=?";
    private String selectTutor = "SELECT ORGANISATION FROM TUTOR WHERE username=? AND password=?";
    private String openStudent = "SELECT ID FROM STUDENT WHERE name=? AND phone=?";
    // Registration & updation
    private String insertTutor = "INSERT INTO TUTOR VALUES (?,?,?,?,?,?)";
    private String updateTutor = "UPDATE TUTOR SET username=?,password=? WHERE username=?";
    private String deleteTutor = "DELETE FROM TUTOR WHERE USERNAME=?";
    // Students
    private String insertStudent = "INSERT INTO STUDENT(organisation,name,class,phone,joining_date,fee) VALUES "
            + "(?,?,?,?,?,?)";
    private String updateStudent = "UPDATE STUDENT SET name=?,phone=?,class=?,joining_date=?,fee=? "
            + "WHERE ID=?";
    private String deleteStudent = "DELETE FROM STUDENT WHERE ID=?";
    private String deletePay = "delete from payment where id=?";
    private String deleteAttn = "delete from attendance where id=?";
    private String deleteAllStudent = "DELETE FROM STUDENT WHERE ORGANISATION=?";
    private String selectStudent = "SELECT ID,NAME,CLASS,PHONE, date_format(joining_date, '%d-%m-%y') JOINED_ON, FEE FROM STUDENT "
            + "WHERE ORGANISATION=?";
    private String selectClassID = "SELECT ID FROM STUDENT WHERE ORGANISATION=? AND CLASS=?";
    // Attendance
    private String addPresence = "INSERT INTO ATTENDANCE VALUES (?,?,TRUE)";
    private String selectAttendance = "SELECT ID,NAME,CLASS,PRESENT FROM STUDENT NATURAL JOIN ATTENDANCE "
            + "WHERE day=? AND ID in ("+selectClassID+")";
    private String allPresent = "UPDATE ATTENDANCE SET PRESENT=TRUE WHERE day=? AND ID IN ("
            + selectClassID +")";
    private String setPresence = "UPDATE ATTENDANCE SET presenT=? WHERE day=? AND ID=?";
    // Payments
    private String addPay = "INSERT INTO PAYMENT VALUES (?,?,FALSE)";
    private String selectPay = "SELECT ID,NAME,CLASS,MONTH,PAID FROM STUDENT NATURAL JOIN PAYMENT "
            + "WHERE paid=false AND ID IN ("+selectClassID+")";
    private String setPay = "UPDATE PAYMENT SET PAID=? WHERE due_month=? AND ID=?";
    private String subtotal = "SELECT SUM(FEE) FROM STUDENT NATURAL JOIN PAYMENT WHERE ORGANISATION=? "
            + "AND month=? AND class=? AND PAID=TRUE";
    private String total = "SELECT SUM(FEE) FROM STUDENT NATURAL JOIN PAYMENT WHERE ORGANISATION=? "
            + "AND month=? AND PAID=TRUE";
    // Features
    private String addMessage = "INSERT INTO MESSAGES VALUES (?,?,CURRENT_TIMESTAMP(),?,?)";
    private String addFeed = "INSERT INTO FEEDBACK VALUES (?,CURRENT_TIMESTAMP(),? )";
    // Student Front  
    private String selectMessage = "SELECT Sender,Sent,Info Message FROM MESSAGES "
            + "WHERE organisation= (select organisation from student where id=?) "
            + "AND class= (select class from student where id=?)";
    private String detail = "SELECT * from STUDENT WHERE ID=?";
    private String attend = "select date_format(day,'%d %M %Y') DAY ,Present from attendance where id=?";
    private String percent = "select avg(present) from attendance where id=?";
    // Admin Front
    private String selectFeed = "SELECT * FROM FEEDBACK";
    private String selectOrganisation = "SELECT DISTINCT ORGANISATION,COUNT(username) TUTORS FROM TUTOR "
            + "group by organisation "
            + "having count(username)>0;";
    private String selectTutors = "SELECT * FROM TUTOR";
    
    private PreparedStatement statement;
    private Connection connect;
    
    public JDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, username, password);
        }
        catch(ClassNotFoundException | SQLException e) {
            throwError(e); 
        }
    }
    
    public static void throwError(Exception e) {
        JOptionPane.showMessageDialog(null, e, "Sorry!", JOptionPane.ERROR_MESSAGE );   
    }
    
    public boolean verifyAdmin(User u) throws Exception {
        try {
            statement = connect.prepareStatement(selectAdmin);
            statement.setString(1, u.name);
            statement.setString(2, u.password);
            ResultSet r = statement.executeQuery();
            if(r.next()) {
                User.interrupt( "WELCOME BACK "+ u.name.toUpperCase() +" !");
                return true;
            }
            else 
                User.interrupt("Invalid Username / Password");
        }
        catch(SQLException e) {
            throwError(e);
        }
        return false;
    }
    
    public String verifyTutor(User u) throws Exception {
        try {
            statement = connect.prepareStatement(selectTutor);
            statement.setString(1, u.name);
            statement.setString(2, u.password);
            ResultSet r = statement.executeQuery();
            if(r.next()) {
                u.org = r.getString(1);
                User.interrupt("WELCOME "+u.name.toUpperCase()+" !");
                return selectOrganisation;   
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid Username / Password", "Message", JOptionPane.WARNING_MESSAGE);
                return "";
            }
        }
        catch(SQLException e) {
            return "";
        }
    }
    
    public void register(Tutor t) {
        try {
            statement = connect.prepareStatement(insertTutor);
            statement.setString(1, t.organisation);
            statement.setString(2, t.username);
            statement.setString(3, t.password);
            statement.setString(4, t.name);
            statement.setString(5, t.phone);
            statement.setString(6, t.mail);
            int rows = statement.executeUpdate();
            if(rows>0) 
                User.interrupt("New User added successfully!");
        }
        catch(SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Username already exists!", "Message", JOptionPane.WARNING_MESSAGE );
        }
        catch(SQLException e) {
            throwError(e); 
        }
    }
    
    public void updateTutor(String oldUser, String user, String pass) {
        try {
            statement = connect.prepareStatement(updateTutor);
            statement.setString(1, user);
            statement.setString(2, pass);
            statement.setString(3, oldUser);
            int rows = statement.executeUpdate();
            if(rows>0)
                User.interrupt("Updated successfully!");
        }
        catch(SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Username already exists!", "Message", JOptionPane.WARNING_MESSAGE );
        }
        catch(SQLException e) {
            throwError(e); 
        }
    }    
    
    public void deleteAccount(String user) {
        try {
            statement = connect.prepareStatement(deleteTutor);
            statement.setString(1, user);
            int rows = statement.executeUpdate();
            if(rows>0) 
                User.interrupt("Your account has been Deleted.");
            else
                User.interrupt("No such account found.");
        }
        catch(SQLException e) {
            throwError(e); 
        }
    }
    
    public void addStudent(Student s) {
        try {
            statement = connect.prepareStatement(insertStudent);
            statement.setString(1, s.organisation);
            statement.setString(2, s.name);
            statement.setInt(3, s.standard);
            statement.setString(4, s.phone);
            statement.setDate(5, new Date(s.dateLong) );   //default constructor in sql.Date
            statement.setInt(6, s.fee);
            int rows = statement.executeUpdate();
            if(rows>0)
                User.interrupt("New Student added successfully!");
        }
        catch(SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Record already exists!", "Message", JOptionPane.WARNING_MESSAGE );
        }
        catch(SQLException e) {
            throwError(e); 
        }
    }
    
    public void updateStudent(Student s) {
        try {
            statement = connect.prepareStatement(updateStudent);
            statement.setString(1, s.name);
            statement.setString(2, s.phone);
            statement.setInt(3, s.standard);
            statement.setDate(4, new Date(s.dateLong) );
            statement.setInt(5, s.fee);
            statement.setString(6, s.organisation);
            statement.setInt(7, s.ID);
            int rows = statement.executeUpdate();
            if(rows>0)
                User.interrupt("Student updated successfully!");
            else
                User.interrupt("No such record found.");
        }
        catch(SQLException e) {
            throwError(e); 
        }
    }
    
    public void deleteStudent(Student s) {
        try {
            statement = connect.prepareStatement(deleteAttn);
            statement.setInt(1, s.ID);
            statement.executeUpdate();
            
            statement = connect.prepareStatement(deletePay);
            statement.setInt(1, s.ID);
            statement.executeUpdate();
            
            statement = connect.prepareStatement(deleteStudent);
            statement.setInt(1, s.ID);
            int rows = statement.executeUpdate();
            if(rows>0)
                User.interrupt("Student deleted.");
            else
                User.interrupt("No such record found.");
        }
        catch(SQLException e) {
            throwError(e); 
        }
    }
    
    public void deleteAll(String org) {
        try {
            statement = connect.prepareStatement("delete from attendance where id in (SELECT ID FROM STUDENT WHERE ORGANISATION=?);" );
            statement.setString(1, org);
            statement.executeUpdate();
            
            statement = connect.prepareStatement("delete from payment where id in (SELECT ID FROM STUDENT WHERE ORGANISATION=?);" );
            statement.setString(1, org);
            statement.executeUpdate();
            
            statement = connect.prepareStatement(deleteAllStudent);
            statement.setString(1, org);
            int rows = statement.executeUpdate();
            if(rows>0) 
                User.interrupt("Students have been Deleted.");
            else
                User.interrupt("No student found.");
        }
        catch(SQLException e) {
            throwError(e); 
        }
    }
    
    public JTable showStudent(String org){
        try {
            statement = connect.prepareStatement(selectStudent);
            statement.setString(1, org);
            ResultSet r = statement.executeQuery();
            JTable table = new JTable();
            table.setModel( DbUtils.resultSetToTableModel(r) );
            return table;
        }
        catch(SQLException e) {
            throwError(e); 
            return null;
        }
    }
    
    public JTable showAttend(Student s) {
        try {
            statement = connect.prepareStatement(selectAttendance);
            statement.setDate(1, new Date(s.dateLong) );
            statement.setString(2, s.organisation);
            statement.setInt(3, s.standard);
            ResultSet r = statement.executeQuery();
            
            if(r.next()==false) {
                fill(s,addPresence);
                r = statement.executeQuery();
            }
            JTable table = new JTable();
            table.setModel( DbUtils.resultSetToTableModel(r) );
            return table;
        }
        catch(SQLException e) {
            throwError(e); 
            return null;
        }
    }
    
    private void fill(Student s, String query) throws SQLException {
        statement = connect.prepareStatement(selectClassID);
        statement.setString(1, s.organisation);
        statement.setInt(2, s.standard);
        ResultSet rs = statement.executeQuery();
        IDList id = new IDList();
        while( rs.next() ) {
            id.insert(rs.getInt(1));
        }
        statement = connect.prepareStatement(query);
        for(int i=0; i<id.n; i++) {
            statement.setInt(1, id.store[i]);
            statement.setDate(2, new Date(s.dateLong) );
            statement.addBatch();
        }
        statement.executeBatch();
        //throwError();(null, "Records have been created.");
    }
    
    public void makeAllPresent(Student s) {
        try {
            statement = connect.prepareStatement(allPresent);
            statement.setDate(1, new Date(s.dateLong) );
            statement.setString(2, s.organisation);
            statement.setInt(3, s.standard);
            statement.executeUpdate();
        }
        catch(SQLException e) {
            throwError(e); 
        }
    }
    
    public void updatePresence(Student s) {
        try {
            statement = connect.prepareStatement(setPresence);
            statement.setBoolean(1, s.present);
            statement.setDate(2, new Date(s.dateLong) );
            statement.setInt(3, s.ID);
            statement.executeUpdate();
        }
        catch(SQLException e) {
            throwError(e); 
        }
    }
    
    public JTable showPay(Student s){
        try {
            statement = connect.prepareStatement(selectPay);
            statement.setString(1, s.organisation);
            statement.setInt(2, s.standard);
            ResultSet r = statement.executeQuery();
            
            if(r.next()==false) {
                fill(s.organisation,s.month,addPay);
                r = statement.executeQuery();
            }
            JTable table = new JTable();
            table.setModel( DbUtils.resultSetToTableModel(r) );
            return table;
        }
        catch(SQLException e) {
            throwError(e); 
            return null;
        } 
    }
    
    private void fill(String org, String date, String query) throws SQLException {
        statement = connect.prepareStatement("SELECT ID FROM STUDENT WHERE ORGANISATION=?");
        statement.setString(1, org);
        ResultSet rs = statement.executeQuery();
        IDList id = new IDList();
        while( rs.next() ) {
            id.insert(rs.getInt(1));
        }
        statement = connect.prepareStatement(query);
        for(int i=0; i<id.n; i++) {
            statement.setInt(1, id.store[i]);
            statement.setString(2, date);
            statement.addBatch();
        }
        statement.executeBatch();
    }
    
     public void updatePay(Student s) {
        try {
            statement = connect.prepareStatement(setPay);
            statement.setBoolean(1, s.paid);
            statement.setString(2, s.month);
            statement.setInt(3, s.ID);
            statement.executeUpdate();
        }
        catch(SQLException e) {
            throwError(e); 
        }
    }
     
    public int getSubTotal(Student s) {
        try {
            statement = connect.prepareStatement(subtotal);
            statement.setString(1, s.organisation);
            statement.setString(2, s.month);
            statement.setInt(3, s.standard);
            ResultSet r = statement.executeQuery();
            if(r.next())
                return r.getInt(1);
        }
        catch(SQLException e) {
            throwError(e); 
        }
        return 0;
    }
    
    public int getTotal(Student s) {
        try {
            statement = connect.prepareStatement(total);
            statement.setString(1, s.organisation);
            statement.setString(2, s.month);
            ResultSet r = statement.executeQuery();
            if( r.next() )
                return r.getInt(1);
        }
        catch(SQLException e) {
            throwError(e); 
        }
        return 0;
    }
    
     
    public boolean message(String org, String sender, String msg, int std ) {
        try {
            statement = connect.prepareStatement(addMessage);
            statement.setString(1,org);
            statement.setString(2,sender);
            statement.setString(3,msg);
            statement.setInt(4,std);
            statement.executeUpdate();
            return true;
        }
        catch(SQLException e) {
            throwError(e); 
            return false;
        }
    }
    
    public boolean feed(String sender, String msg ) {
        try {
            statement = connect.prepareStatement(addFeed);
            statement.setString(1,sender);
            statement.setString(2,msg);
            statement.executeUpdate();
            return true;
        }
        catch(SQLException e) {
            throwError(e); 
            return false;
        }
    }
    
    public JTable view(JTable table, String who) {
        try {
            Statement s = connect.createStatement();
            ResultSet r;
            switch (who) {
                case "org":
                    r= s.executeQuery(selectOrganisation);
                    break;
                case "tutor":
                    r = s.executeQuery(selectTutors);
                    break;
                default:
                    r = s.executeQuery(selectFeed);
                    break;
            }
            table.setModel( DbUtils.resultSetToTableModel(r) );
            return table;
        }
        catch(SQLException e) {
            throwError(e); 
            return null;
        }
    }
    
    public JTable removeTutor(JTable table, String user) {
        try {
            statement = connect.prepareStatement(deleteTutor);
            statement.setString(1, user);
            int rows = statement.executeUpdate();
            if(rows>0) {
                User.interrupt("Tutor has been removed.");
                statement = connect.prepareStatement(selectStudent);
                statement.setString(1, user);
                ResultSet r = statement.executeQuery();
                table.setModel( DbUtils.resultSetToTableModel(r) );
            }
            else
                User.interrupt("No such tutor found.");
            return table;
        }
        catch(SQLException e) {
            throwError(e); 
            return null;
        }
    }
    
    public int verifyStudent(User u) {
        try {
            statement = connect.prepareStatement(openStudent);
            statement.setString(1, u.name);
            statement.setString(2, u.password);
            ResultSet r = statement.executeQuery();
            if(r.next()) {
                int ID = r.getInt(1);
                User.interrupt( "WELCOME LEARNER "+u.name.toUpperCase()+" !");
                return ID;   
            }
            else 
                JOptionPane.showMessageDialog(null, "Invalid Username / Password", "Message", JOptionPane.WARNING_MESSAGE);
        }
        catch(SQLException e) {
            throwError(e); 
        }
        return 0;
    }
    
    public String viewDetail(int id) {
        try {
            statement = connect.prepareStatement(detail);
            statement.setInt(1, id);
            ResultSet r = statement.executeQuery();
            String text="";
            while(r.next()) {
                text+="  ID: "+r.getInt("id")
                        +"   Organisation: "+r.getString("organisation").toUpperCase()
                        +"   Name: "+r.getString("name").toUpperCase()
                        +"   Class "+r.getInt("class")
                        +"   Contact: "+r.getString("phone")
                        +"\n Joined on "+r.getDate("date_joined")
                        +"\n Rs."+r.getInt("fee");
            }
            statement = connect.prepareStatement(percent);
            statement.setInt(1, id);
            r = statement.executeQuery();
            if(r.next())
                text += "\n Percentage: "+r.getFloat(1)*100;
            return text;
        }
        catch(SQLException e) {
            throwError(e); 
            return null;
        }
    }
    
    public JTable viewMessage(JTable table, int id) {
        try {
            statement = connect.prepareStatement(selectMessage);
            statement.setInt(1, id);
            statement.setInt(2, id);
            ResultSet r = statement.executeQuery();
            table.setModel( DbUtils.resultSetToTableModel(r) );
            return table;
        }
        catch(SQLException e) {
            throwError(e); 
            return null;
        }
    }
    
    public JTable viewAttend(JTable table, int id) {
        try {
            statement = connect.prepareStatement(attend);
            statement.setInt(1, id);
            ResultSet r = statement.executeQuery();
            table.setModel( DbUtils.resultSetToTableModel(r) );
            return table;
        }
        catch(SQLException e) {
            throwError(e); 
            return null;
        }
}
}

class IDList {
    int n=0, count=5;
    int[] store = new int[count];
    
    public void insert(int id) {
        if(n<count)
            store[n++] = id;
        else {
            count+=2;
            int[] temp = new int[count];
            System.arraycopy(store, 0, temp, 0, store.length);
            store=temp;
        }
    }
}