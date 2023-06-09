/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import entities.Client;
import javax.swing.JOptionPane;
import services.ClientService;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ep
 */
public class ClientForm extends javax.swing.JInternalFrame {
    
    private ClientService cs;
    private DefaultTableModel model;
    private static int id;
    private boolean test = false;

    /**
     * Creates new form ClientForm
     */
    public ClientForm() {
        initComponents();
        cs=new ClientService();
        model=(DefaultTableModel)listeClients.getModel();
        load();
    }
    
    private void load(){
        model.setRowCount(0);
        for(Client c:cs.findAll()){
            model.addRow(new Object[]{
                c.getId(),
                c.getNom(),
                c.getPrenom(),
                c.getTel(),
                c.getEmail(),
            }
                    );
        }
        test = false;
    }
   
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomtxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        prenomtxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        teltxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailtxt = new javax.swing.JTextField();
        ajouterClient = new javax.swing.JButton();
        modifierClient = new javax.swing.JButton();
        supprimerClient = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeClients = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestion des clients");

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nouveau Client", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12))); // NOI18N

        jLabel1.setText("Nom:");

        jLabel2.setText("Prenom:");

        jLabel3.setText("Téléphone:");

        jLabel4.setText("Email:");

        ajouterClient.setText("Ajouter");
        ajouterClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterClientActionPerformed(evt);
            }
        });

        modifierClient.setText("Modifier");
        modifierClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierClientActionPerformed(evt);
            }
        });

        supprimerClient.setText("Supprimer");
        supprimerClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prenomtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(emailtxt)
                    .addComponent(nomtxt)
                    .addComponent(teltxt))
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(supprimerClient)
                        .addComponent(ajouterClient, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(modifierClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(ajouterClient))
                    .addComponent(nomtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(prenomtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(teltxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(modifierClient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supprimerClient)
                        .addContainerGap())))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des clients", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12))); // NOI18N

        listeClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nom", "Prenom", "Tél", "Email"
            }
        ));
        listeClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeClientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listeClients);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterClientActionPerformed
        String nom=nomtxt.getText();
        String prenom=prenomtxt.getText();
        String tel=teltxt.getText();
        String email=emailtxt.getText();
        
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        
        if (nom.equals("") | prenom.equals("")  | tel.equals("") | email.equals(""))
            JOptionPane.showMessageDialog(this, "Il faut remplir tous les champs ", "WARNING!", JOptionPane.WARNING_MESSAGE);
        else if (!email.matches(EMAIL_REGEX)) {
            JOptionPane.showMessageDialog(this, "Format d'email n'est pas valide", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }
        else if(cs.create(new Client(nom,prenom,tel,email)))  {
            JOptionPane.showMessageDialog(this, "Client bien ajouté");
            nomtxt.setText("");
            prenomtxt.setText("");
            teltxt.setText("");
            emailtxt.setText("");
        }
        load();
    }//GEN-LAST:event_ajouterClientActionPerformed

    private void modifierClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierClientActionPerformed
       if(test) {
            String nom=nomtxt.getText();
            String prenom=prenomtxt.getText();
            String tel=teltxt.getText();
            String email=emailtxt.getText();
            if (nom.equals("") | prenom.equals("")  | tel.equals("") | email.equals(""))
                JOptionPane.showMessageDialog(this, "Il faut remplir tous les champs ", "WARNING!", JOptionPane.WARNING_MESSAGE);
            else {
                Client c=cs.findById(id);
                c.setNom(nom);
                c.setPrenom(prenom);
                c.setTel(tel);
                c.setEmail(email);
                int reponse=JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment modifier le client");
                if(reponse==0){
                    if(cs.update(c))
                        JOptionPane.showMessageDialog(this, "Client bien modifié");
                }
            }
            nomtxt.setText("");
            prenomtxt.setText("");
            teltxt.setText("");
            emailtxt.setText("");
            load();
        }
    }//GEN-LAST:event_modifierClientActionPerformed

    private void listeClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeClientsMouseClicked
        test = true;
        id=Integer.parseInt(model.getValueAt(listeClients.getSelectedRow(), 0).toString());
        nomtxt.setText(model.getValueAt(listeClients.getSelectedRow(), 1).toString());
        prenomtxt.setText(model.getValueAt(listeClients.getSelectedRow(), 2).toString());
        teltxt.setText(model.getValueAt(listeClients.getSelectedRow(), 3).toString());
        emailtxt.setText(model.getValueAt(listeClients.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_listeClientsMouseClicked

    private void supprimerClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerClientActionPerformed
         if (test){
           int reponse=JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer le client");
           if(reponse==0){
                if(cs.delete(cs.findById(id)))
                    JOptionPane.showMessageDialog(this, "client bien supprimé");
           }
           nomtxt.setText("");
           prenomtxt.setText("");
           teltxt.setText("");
           emailtxt.setText("");
           load();
       }
    }//GEN-LAST:event_supprimerClientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterClient;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listeClients;
    private javax.swing.JButton modifierClient;
    private javax.swing.JTextField nomtxt;
    private javax.swing.JTextField prenomtxt;
    private javax.swing.JButton supprimerClient;
    private javax.swing.JTextField teltxt;
    // End of variables declaration//GEN-END:variables
}
