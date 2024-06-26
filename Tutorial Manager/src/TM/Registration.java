package TM;

import java.awt.*;
import javax.swing.*;

public class Registration extends JFrame {

        Image image = Toolkit.getDefaultToolkit().getImage("Universe.png");
        JDBC data = new JDBC();
        Tutor tutor = new Tutor();
        
    /**
     * Creates new form Registration
     */
    public Registration() {
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
        labUser = new javax.swing.JLabel();
        labPassword = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        labPhone = new javax.swing.JLabel();
        labRegistration = new javax.swing.JLabel();
        buttonRegister = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        labName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        labEmail = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        labOrganisation = new javax.swing.JLabel();
        txtOrganisation = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(image);
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);

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

        labUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labUser.setText("New username");

        labPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labPassword.setText("New password");

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        labPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labPhone.setText("Mobile number");

        labRegistration.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labRegistration.setText("Create Account");

        buttonRegister.setBackground(new java.awt.Color(153, 102, 255));
        buttonRegister.setText("REGISTER");
        buttonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });

        buttonCancel.setBackground(new java.awt.Color(153, 102, 255));
        buttonCancel.setText("CANCEL");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        labName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labName.setText("Name");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        labEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labEmail.setText("Email ID");

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        txtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailActionPerformed(evt);
            }
        });

        labOrganisation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labOrganisation.setText("Name of Organisation");

        txtOrganisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrganisationActionPerformed(evt);
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
                        .addGap(164, 164, 164)
                        .addComponent(labRegistration))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labPhone)
                                    .addComponent(labName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labEmail)
                                    .addComponent(labOrganisation, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(labPassword)
                                        .addComponent(labUser)))
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonCancel)
                                .addGap(38, 38, 38)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOrganisation, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(buttonRegister)))))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labRegistration)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labEmail)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labOrganisation)
                    .addComponent(txtOrganisation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonRegister))
                .addGap(26, 26, 26))
            .addComponent(panelSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // On ENTER key press
        txtPassword.grabFocus();
    }//GEN-LAST:event_txtUserActionPerformed

    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
        getDetails();
        if(tutor.username.isEmpty())
            JOptionPane.showMessageDialog(this, "Enter an username");
        else if(tutor.password.isEmpty())
            JOptionPane.showMessageDialog(this, "Enter a password");
        else if(tutor.organisation.isEmpty())
            JOptionPane.showMessageDialog(this, "Enter the Organisation name");
        else if(tutor.name.isEmpty())
            JOptionPane.showMessageDialog(this, "Enter your name");
        else if(tutor.phone.isEmpty())
            JOptionPane.showMessageDialog(this, "Enter your mobile number");
        else if( new User().isValidPhone(tutor.phone) == false)
            JOptionPane.showMessageDialog(this, "Invalid mobile number");
        else {
            data.register(tutor);
            dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Do you really want to cancel?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if( JOptionPane.YES_OPTION == result) {
            dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        txtPhone.grabFocus();
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        txtMail.grabFocus();
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailActionPerformed
        txtOrganisation.grabFocus();
    }//GEN-LAST:event_txtMailActionPerformed

    private void txtOrganisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrganisationActionPerformed
        txtUser.grabFocus();
    }//GEN-LAST:event_txtOrganisationActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JLabel labEmail;
    private javax.swing.JLabel labName;
    private javax.swing.JLabel labOrganisation;
    private javax.swing.JLabel labPassword;
    private javax.swing.JLabel labPhone;
    private javax.swing.JLabel labRegistration;
    private javax.swing.JLabel labUser;
    private javax.swing.JPanel panelSide;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrganisation;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    private void getDetails() {
        tutor.name = txtName.getText();
        tutor.phone = txtPhone.getText();
        tutor.mail = txtMail.getText();
        tutor.username = txtUser.getText();
        tutor.password = String.valueOf( txtPassword.getPassword() );
        tutor.organisation = txtOrganisation.getText();
    }
    
}