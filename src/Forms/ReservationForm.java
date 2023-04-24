
package Forms;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import entities.Chambre;
import entities.Client;
import entities.Reservation;
import java.io.FileNotFoundException;
import java.util.Date;

import javax.swing.table.DefaultTableModel;
import services.ChambreService;
import services.ClientService;
import services.ReservationService;

public class ReservationForm extends javax.swing.JInternalFrame {
    
    
    
    ClientService cs = new ClientService();
    ChambreService chs = new ChambreService();
    ReservationService rs = new ReservationService();
    private DefaultTableModel model;
    private static int id;
    int i = 0;
    
    public ReservationForm() {
        initComponents();
        model = (DefaultTableModel)listeReservations.getModel();
        loadClients();
        loadChambres();
        load();
        listeClients.setSelectedIndex(-1);
        listeChambres.setSelectedIndex(-1);
    }
    
    private void load() {
        model.setRowCount(0);
        for(Reservation r:rs.findAll()) {
            model.addRow(new Object[]{
            r.getId(),
            r.getClient(),
            r.getChambre(),
            r.getDateDebut(),
            r.getDateFin()
            }
                );
        }
    }
    private void loadClients() {
        for(Client c:cs.findAll()){
            listeClients.addItem(c);
        }
    }
    
    private void loadChambres() {
        for(Chambre ch:chs.findAll()){
            listeChambres.addItem(ch);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        listeClients = new javax.swing.JComboBox();
        listeChambres = new javax.swing.JComboBox();
        dateDebut = new com.toedter.calendar.JDateChooser();
        dateFin = new com.toedter.calendar.JDateChooser();
        ajouter = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        pdf = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeReservations = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(51, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nouvelle reservation ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N

        jLabel1.setText("Client");

        jLabel2.setText("Chambre");

        jLabel3.setText("Date de debut");

        jLabel4.setText("Date de fin");

        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        modifier.setText("Modifier");
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        pdf.setText("Generer PDF");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateDebut, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(dateFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listeChambres, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(listeClients, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(supprimer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modifier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ajouter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pdf))
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(listeClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajouter))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(listeChambres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(modifier)
                        .addGap(18, 18, 18)
                        .addComponent(supprimer)
                        .addGap(18, 18, 18)
                        .addComponent(pdf)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des reservations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N

        listeReservations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Client", "Chambre", "Date de debut", "Date de fin"
            }
        ));
        listeReservations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeReservationsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listeReservations);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(287, 287, 287))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        int answer = JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer la reservation?");
        if (answer == 0) {
            if (rs.delete(rs.findById(id))) {
                JOptionPane.showMessageDialog(this, "Reservation supprimée");
                load();
            }
            listeClients.setSelectedIndex(-1);
            listeChambres.setSelectedIndex(-1);
            dateDebut.setDate(null);
            dateFin.setDate(null);
            load();
        }
    }//GEN-LAST:event_supprimerActionPerformed

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        int count = -1;
        
        Client c = (Client) listeClients.getSelectedItem();
        Chambre ch = (Chambre) listeChambres.getSelectedItem();
        Date dateD = (Date) dateDebut.getDate();
        Date dateF = (Date) dateFin.getDate();
        
        if (listeClients.getSelectedIndex() == -1 | listeChambres.getSelectedIndex() == -1 | dateD == null | dateF == null) {
            JOptionPane.showMessageDialog(this, "Il faut remplir tous les champs ", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }
        else {
            for(Reservation r:rs.findAll()) {
                if(ch.getId() == r.getChambre().getId()) {
                    count ++;
                    if ((dateD.after(r.getDateFin()) && dateF.before(r.getDateDebut())) && (dateD.before(dateF))) {
                        if(rs.create(new Reservation(c, ch, dateD, dateF))){
                            JOptionPane.showMessageDialog(this, "Reservation bien terminée");
                        }
                        listeClients.setSelectedIndex(-1);
                        listeChambres.setSelectedIndex(-1);
                        dateDebut.setDate(null);
                        dateFin.setDate(null);
                        load();
                    }
                else 
                    JOptionPane.showMessageDialog(this, "Echec de reservation ", "WARNING!", JOptionPane.WARNING_MESSAGE);
                }
            }

            if (count == -1) {
                if ((dateD.before(dateF))) {
                    if(rs.create(new Reservation(c, ch, dateD, dateF))){
                    JOptionPane.showMessageDialog(this, "Reservation bien terminée");
                    }
                    listeClients.setSelectedIndex(-1);
                    listeChambres.setSelectedIndex(-1);
                    dateDebut.setDate(null);
                    dateFin.setDate(null);
                    load();
                }
                else 
                    JOptionPane.showMessageDialog(this, "Echec de reservation ", "WARNING!", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        
        //String tel=teltxt.getText();
        //Date db = (Date) ddebut.getDate();
//        do{
//            JOptionPane.showMessageDialog(this, "Il faut remplir les champs");
//            code=codetxt.getText();
//            libelle=libelletxt.getText();
//        }while (code != "" & libelle != "");
        
        //if (tel.equals(""))
        //        JOptionPane.showMessageDialog(this, "Il faut entrer le telephone ", "WARNING!", JOptionPane.WARNING_MESSAGE);
        
        //else 
    }//GEN-LAST:event_ajouterActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        Client c = (Client) listeClients.getSelectedItem();
        Chambre ch = (Chambre) listeChambres.getSelectedItem();
        Date dateD = (Date) dateDebut.getDate();
        Date dateF = (Date) dateFin.getDate();

        int confirm = JOptionPane.showConfirmDialog(this, "Voulez-vous modifier la reservation?");
        if(confirm == 0){
            Reservation r = rs.findById(id);
            r.setClient(c);
            r.setChambre(ch);
            r.setDateDebut(dateD);
            r.setDateFin(dateF);
            if(rs.update(r)){
                JOptionPane.showMessageDialog(this, "Reservation bien modifiée");
                listeClients.setSelectedIndex(-1);
                listeChambres.setSelectedIndex(-1);
                dateDebut.setDate(null);
                dateFin.setDate(null);
                load();
            } else{
                JOptionPane.showMessageDialog(this, "Echec de modification ", "WARNING!", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        
        
        /*int count = -1;
        
        Client c = (Client) listeClients.getSelectedItem();
        Chambre ch = (Chambre) listeChambres.getSelectedItem();
        Date dateD = (Date) dateDebut.getDate();
        Date dateF = (Date) dateFin.getDate();
        
        Reservation r = rs.findById(id);
        r.setClient(c);
        r.setChambre(ch);
        r.setDateDebut(dateD);
        r.setDateFin(dateF);
        */
        
        /*if (listeClients.getSelectedIndex() == -1 | listeChambres.getSelectedIndex() == -1 | dateD == null | dateF == null) {
            JOptionPane.showMessageDialog(this, "Il faut remplir tous les champs ", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }
        else {
            for(Reservation r:rs.findAll()) {
                if (r.getId() != id) {
                if(ch.getId() == r.getChambre().getId()) {
                    count ++;
                    if (!((dateD.after(r.getDateFin()) || dateF.before(r.getDateDebut())) && (dateD.before(dateF)))) {
                        int answer = JOptionPane.showConfirmDialog(this, "voulez-vous modifier cette Reservation ?");
                        if (answer == 0) {
                            if (rs.update(r)) {
                                JOptionPane.showMessageDialog(this, "Reservation bien modifiée");
                            }
                        }
                        listeClients.setSelectedIndex(-1);
                        listeChambres.setSelectedIndex(-1);
                        dateDebut.setDate(null);
                        dateFin.setDate(null);
                        load();
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Cette chambre est deja reservée dans cette période ", "WARNING!", JOptionPane.WARNING_MESSAGE);
                    }
                }
                }
            }
            if (count == -1) {
                if (rs.update(r)) {
                    JOptionPane.showMessageDialog(this, "Reservation bien modifiée");
                }
                listeClients.setSelectedIndex(-1);
                listeChambres.setSelectedIndex(-1);
                dateDebut.setDate(null);
                dateFin.setDate(null);
                load();
            }
        }*/
    }//GEN-LAST:event_modifierActionPerformed

    private void listeReservationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeReservationsMouseClicked
       id=Integer.parseInt(model.getValueAt(listeReservations.getSelectedRow(), 0).toString());
       listeClients.getModel().setSelectedItem(rs.findById(id).getClient());
       listeChambres.getModel().setSelectedItem(rs.findById(id).getChambre());
       dateDebut.setDate(rs.findById(id).getDateDebut());
       dateFin.setDate(rs.findById(id).getDateFin());
       
//listeCategories.getModel().setSelectedItem(chs.findById(id).getCategorie());
       
    }//GEN-LAST:event_listeReservationsMouseClicked

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
        
        String path = "E:\\4IIR\\JAVA\\miniProjet\\NetBeans\\PDF";
        Document doc = new Document();
        try{
            i++;
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\Reservations.pdf" + (i)));
            doc.open();
            PdfPTable tbl = new PdfPTable(5);
            tbl.addCell("ID");
            tbl.addCell("Client");
            tbl.addCell("Chambre");
            tbl.addCell("DateDeDebut");
            tbl.addCell("DateDeFin");
            for(int i =0; i<listeReservations.getRowCount(); i++){
                String id = listeReservations.getValueAt(i, 0).toString();
                String Client = listeReservations.getValueAt(i, 1).toString();
                String Chambre = listeReservations.getValueAt(i, 2).toString();
                String DateD = listeReservations.getValueAt(i, 3).toString();
                String DateF = listeReservations.getValueAt(i, 4).toString();
                tbl.addCell(id);
                tbl.addCell(Client);
                tbl.addCell(Chambre);
                tbl.addCell(DateD);
                tbl.addCell(DateF);
            }
                doc.add(tbl);
                JOptionPane.showMessageDialog(this, "Document génerer");
                doc.close();
            }catch(DocumentException e){
                JOptionPane.showMessageDialog(this, "Erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Ce chemin n'existe pas", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private com.toedter.calendar.JDateChooser dateDebut;
    private com.toedter.calendar.JDateChooser dateFin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox listeChambres;
    private javax.swing.JComboBox listeClients;
    private javax.swing.JTable listeReservations;
    private javax.swing.JButton modifier;
    private javax.swing.JButton pdf;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables
}
