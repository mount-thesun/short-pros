package TM;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Login extends JFrame {

    Image image = Toolkit.getDefaultToolkit().getImage("Universe.png");
    JDBC data = new JDBC();
    User user = new User();
    int id;
        
    /**
     * Creates new form Home
     */
    public Login() {
        initComponents();
        setTitle("Universe Tutorial Manager");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSide = new javax.swing.JPanel();
        labLogin = new javax.swing.JLabel();
        labUser = new javax.swing.JLabel();
        labPassword = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        bttnOk = new javax.swing.JButton();
        labNew = new javax.swing.JLabel();
        comboRole = new javax.swing.JComboBox<>();
        labRole = new javax.swing.JLabel();
        labRegister = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(image);
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(500, 500));

        panelSide.setBackground(new java.awt.Color(153, 0, 255));
        panelSide.setFocusable(false);

        javax.swing.GroupLayout panelSideLayout = new javax.swing.GroupLayout(panelSide);
        panelSide.setLayout(panelSideLayout);
        panelSideLayout.setHorizontalGroup(
            panelSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );
        panelSideLayout.setVerticalGroup(
            panelSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        labLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labLogin.setText("Login");

        labUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labUser.setText("Enter username");

        labPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labPassword.setText("Enter password");

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        bttnOk.setBackground(new java.awt.Color(153, 102, 255));
        bttnOk.setText("OK");
        bttnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnOkActionPerformed(evt);
            }
        });

        labNew.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labNew.setText("New here ?");

        comboRole.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tutor", "Student", "Admin" }));
        comboRole.setToolTipText("");

        labRole.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labRole.setText("Select your role");

        labRegister.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        labRegister.setForeground(new java.awt.Color(255, 0, 0));
        labRegister.setText("REGISTER");
        labRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labRegisterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(labNew)
                        .addGap(18, 18, 18)
                        .addComponent(labRegister))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labUser)
                            .addComponent(labRole)
                            .addComponent(labPassword))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labLogin)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(bttnOk))))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(labLogin)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labRole))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPassword))
                .addGap(18, 18, 18)
                .addComponent(bttnOk)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNew)
                    .addComponent(labRegister))
                .addGap(0, 83, Short.MAX_VALUE))
            .addComponent(panelSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        //when ENTER is pressed
        txtPassword.grabFocus();
    }//GEN-LAST:event_txtUserActionPerformed

    private void bttnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnOkActionPerformed
        try {
            getDetails();    
            if(user.name.isEmpty())
                User.interrupt("Enter the username");
            else if(user.password.isEmpty())
                User.interrupt("Enter the password");
            else
                switch(user.role) {
                    case "Tutor":
                        verifyTutor(); break;
                    case "Admin":
                        verifyAdmin(); break;
                    case "Student":
                        verifyStudent(); break;
                }
            }
            catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                JDBC.throwError(ex);
            }
    }//GEN-LAST:event_bttnOkActionPerformed

    private void labRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labRegisterMouseClicked
        dispose();
        new Registration().setVisible(true);
    }//GEN-LAST:event_labRegisterMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnOk;
    private javax.swing.JComboBox<String> comboRole;
    private javax.swing.JLabel labLogin;
    private javax.swing.JLabel labNew;
    private javax.swing.JLabel labPassword;
    private javax.swing.JLabel labRegister;
    private javax.swing.JLabel labRole;
    private javax.swing.JLabel labUser;
    private javax.swing.JPanel panelSide;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    private void getDetails() {
        user.name = txtUser.getText();
        user.password = String.valueOf( txtPassword.getPassword() );
        user.role = comboRole.getSelectedItem().toString();
    }
    
    private void verifyTutor() throws Exception {
        user.org = data.verifyTutor(user);
        if( !user.org.isEmpty())
            openTutorFront();
    }
    
    private void openTutorFront() {
        dispose();
        TutorFront t = new TutorFront();
        t.setVisible(true);
        t.organisation = user.org;
        t.username = user.name;
    }
    
    private void verifyAdmin() throws Exception {
        if(data.verifyAdmin(user))
            openAdminFront();
    }
    
    private void openAdminFront() {
        dispose();
        new AdminFront().setVisible(true);
    }
    
    private void verifyStudent() throws Exception{
        id = data.verifyStudent(user);
        if(id!=0) 
            openStudentFront();
    }
    
    private void openStudentFront() {
        dispose();
        StudentFront s = new StudentFront();
        s.setVisible(true);
        s.ID = id;
    }
    
}