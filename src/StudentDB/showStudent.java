package StudentDB;
import ChainedList.ChainedList;
import ChainedList.Item;
import FileIO.CSV;
import Models.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.table.*;

/**
 *
 * @author Administrator
 */
public class showStudent extends javax.swing.JFrame {

    /**
     * Creates new form showSchueler
     */
    public showStudent() {
        initComponents();
        jTable1.setAutoCreateRowSorter(rootPaneCheckingEnabled);
        clearTable();
        try {
            fillTable();
        } catch (IOException ex) {
            Logger.getLogger(showStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lernende GIBS Solothurn");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "Benutzername", "Name", "Vorname", "Klasse 1", "Klasse 2"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton1)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rows = jTable1.getRowCount();
        ArrayList<Student> students = new ArrayList<>();
        for(int row = 0; row < rows;row++){
            Student student = new Student();
            student.setBenutzername((String) jTable1.getValueAt(row,0));
            student.setName((String) jTable1.getValueAt(row,1));
            student.setVorname((String) jTable1.getValueAt(row,2));
            student.setKlasse1((String) jTable1.getValueAt(row,3));
            student.setKlasse2((String) jTable1.getValueAt(row,4));
            students.add(student);
        }
        try {
            CSV.write(students, "schueler.csv", ";", "Benutzername;Name;Vorname;Klasse1;Klasse2");
        } catch (IOException ex) {
            Logger.getLogger(showStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(showStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch(Exception e) { }
                new showStudent().setVisible(true);
            }
        });
    }

    void clearTable() {
        DefaultTableModel tmodel = (DefaultTableModel) jTable1.getModel();
        int rowCount = tmodel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tmodel.removeRow(i);
        }
    }

    void fillTable() throws IOException {
        ChainedList schuelerListe = CSV.read("src/schueler.csv");
        DefaultTableModel tmodel = (DefaultTableModel) jTable1.getModel();
        try {
            Item s = schuelerListe.firstItem();

            tmodel.addRow(((Student)s.getObj()).toArray());

            while((s = s.getNext()) != null){
                tmodel.addRow(((Student)s.getObj()).toArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}