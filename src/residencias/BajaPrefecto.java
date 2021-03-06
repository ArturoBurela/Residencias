/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencias;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author gutz
 */
public class BajaPrefecto extends javax.swing.JFrame {
    ArrayList<String> prefecListArray;//horas Entrada
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciasPU");
    EntityManager em = emf.createEntityManager();
    
    List<Prefecto> prefectList;//horasEntradas
    String selectedPrefecto;
    String[] prefectos;//entradas
    /**
     * Creates new form BajaPrefecto
     */
    public BajaPrefecto() {
        selectedPrefecto = null;
        prefecListArray = new ArrayList(); 
        //TypedQuery<Prefecto> consultaPrefectos = em.createNamedQuery("Prefecto.findByNomina()", Prefecto.class);
        
        TypedQuery<Prefecto> consultaPrefectos = em.createNamedQuery("Prefecto.findAll", Prefecto.class);
        prefectList = consultaPrefectos.getResultList();
        prefectList.forEach((temp) -> {
            prefecListArray.add(temp.getNombre());
            System.out.print(temp);
        });
        prefectos = new String[prefecListArray.size()];
        for (int i=0; i<prefectos.length; i++){
            prefectos[i] = prefecListArray.get(i);
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nomina = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nomina1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Consulta y Baja Prefectos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 20, -1, -1));

        jButton1.setText("Baja");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        jLabel5.setText("Nomina");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        nomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nominaActionPerformed(evt);
            }
        });
        getContentPane().add(nomina, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 189, -1));

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 209, 227, 25));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = prefectos;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 80, 371, 165));

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        jLabel6.setText("Nomina");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        nomina1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomina1ActionPerformed(evt);
            }
        });
        getContentPane().add(nomina1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 189, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:Baja
        TypedQuery<Prefecto> consultaPrefectos = em.createNamedQuery("Prefecto.findByNomina", Prefecto.class);
        consultaPrefectos.setParameter("nomina",nomina1.getText());
        Prefecto selectedPrefectoEl;
        System.out.print(consultaPrefectos.getResultList().get(0));
        selectedPrefectoEl =consultaPrefectos.getResultList().get(0);
        
        int n = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar este Prefecto");
        System.out.println(n);
        if(n == 0){
            em.getTransaction().begin();
                try {
                    em.detach(selectedPrefectoEl);
                    if (!em.contains(selectedPrefectoEl)) {
                        selectedPrefectoEl = em.merge(selectedPrefectoEl);
                    }
                    em.remove(selectedPrefectoEl);
                    em.getTransaction().commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    em.getTransaction().rollback();
                    JOptionPane.showMessageDialog(null, "Error de conexión");
                } finally {
                    em.close();
                    JOptionPane.showMessageDialog(null, "Prefecto eliminado con éxito");
                    dispose();
                }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nominaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nominaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here: BUSCAR
        TypedQuery<Prefecto> consultaPrefectos = em.createNamedQuery("Prefecto.findByNomina()", Prefecto.class);
        consultaPrefectos.setParameter("nomina",nomina.getText());
        prefectList.forEach((temp) -> {
            prefecListArray.add(temp.getNombre());
            System.out.print(temp);
        });
        prefectos = new String[prefecListArray.size()];
        for (int i=0; i<prefectos.length; i++){
            prefectos[i] = prefecListArray.get(i);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nomina1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomina1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomina1ActionPerformed

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
            java.util.logging.Logger.getLogger(BajaPrefecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BajaPrefecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BajaPrefecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BajaPrefecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BajaPrefecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomina;
    private javax.swing.JTextField nomina1;
    // End of variables declaration//GEN-END:variables
}
