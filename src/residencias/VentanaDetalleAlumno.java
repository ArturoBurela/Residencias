/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencias;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author burela
 */
public class VentanaDetalleAlumno extends javax.swing.JFrame {
    
    Alumno alumno;
    ArrayList<String> horasEntrada;
    ArrayList<String> califs;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciasPU");
    EntityManager em = emf.createEntityManager();
    List<Habitacion> habitaciones;
    List<Horasentrada> horasEntradas;
    List<Calificacion> calificaciones;
    ArrayList numerosHabitaciones;
    String selectedHabitacion;
    String[] entradas;
    String[] cals;

    /**
     * Creates new form VentanaDetalleAlumno
     * @param a
     */
    public VentanaDetalleAlumno(Alumno a) {
        alumno = a;
        selectedHabitacion = null;
        horasEntrada = new ArrayList();
        TypedQuery<Horasentrada> consultaEntradas = em.createNamedQuery("Horasentrada.findAll", Horasentrada.class);
        horasEntradas = consultaEntradas.getResultList();
        horasEntradas.forEach((temp) -> {
            horasEntrada.add(temp.getFecha().toString());
            System.out.print(temp);
        });
        entradas = new String[horasEntrada.size()];
        for (int i=0; i<entradas.length; i++){
            entradas[i] = horasEntrada.get(i);
        }
        TypedQuery<Habitacion> consultaHabitaciones = em.createNamedQuery("Habitacion.findAll", Habitacion.class);
        habitaciones = consultaHabitaciones.getResultList();
        numerosHabitaciones = new ArrayList();
        habitaciones.forEach((temp) -> {
            numerosHabitaciones.add(temp.getNumero());
        });
        TypedQuery<Calificacion> consultaCal = em.createNamedQuery("Calificacion.findAll", Calificacion.class);
        calificaciones = consultaCal.getResultList();
        cals = new String[calificaciones.size()];
        califs = new ArrayList();
        calificaciones.forEach((temp) -> {
           califs.add(temp.getIdMateria() + "                           " + temp.getCalificacion());
        });
        for (int i=0; i<cals.length; i++){
            cals[i] = califs.get(i);
        }
        initComponents();
    }

    private VentanaDetalleAlumno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    VentanaDetalleAlumno(VentanaDetalleAlumno x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(720, 480));

        jLabel1.setText(alumno.getNombre() + " " + alumno.getApellidoPaterno() + " " + alumno.getApellidoMaterno());

        jLabel2.setText("Habitación:");

        jLabel3.setText("Entradas al edifcio");

        jLabel4.setText("Perfil Psicológico");

        jLabel5.setText("Perfil Médico");

        jLabel6.setText("Seguimiento Académico");

        jButton1.setText("Dar de Baja");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Asignar Habitación");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cargar");

        jButton4.setText("Cargar");

        jButton5.setText("Contacto");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = entradas;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = cals;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList3);

        jLabel7.setText(selectedHabitacion);

        jButton6.setText("Crear Reporte");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel8.setText(alumno.getMatricula() + ", " + alumno.getCarrera() + ", " + alumno.getEstatus());

        jLabel9.setText("Disciplina deportiva: " + alumno.getDisciplinaDeportiva() + ", Estado de procedencia:  " + alumno.getEstadoProcedencia());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addComponent(jLabel6)
                            .addComponent(jButton6))
                        .addGap(0, 342, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton3)
                    .addComponent(jLabel5)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        ventanaContacto x = new ventanaContacto(alumno.getEmail());
        x.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        ventanaReportes x = new ventanaReportes(alumno.getNombre(), alumno.getEmail(), alumno.getIdAlumno());
        x.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int n = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar este alumno");
        System.out.println(n);
        if(n == 0){
            em.getTransaction().begin();
                try {
                    em.detach(alumno);
                    if (!em.contains(alumno)) {
                        alumno = em.merge(alumno);
                    }
                    em.remove(alumno);
                    em.getTransaction().commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    em.getTransaction().rollback();
                    JOptionPane.showMessageDialog(null, "Error de conexión");
                } finally {
                    em.close();
                    JOptionPane.showMessageDialog(null, "Alumno eliminado con éxito");
                    dispose();
                }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Object[] possibilities = new Object[habitaciones.size()];
        possibilities = numerosHabitaciones.toArray(possibilities);  
        Integer i = (Integer) JOptionPane.showOptionDialog(null,
                null,  "ShowInputDialog",   
                JOptionPane.PLAIN_MESSAGE, 1, null, possibilities, 0);
        System.out.print(i);
        AlumnohasHabitacion j = new AlumnohasHabitacion();
        j.setAlumno(alumno);
        j.setHabitacion(habitaciones.get(i));
        j.setComentarios("ok");
        em.getTransaction().begin();
                try {
                    em.detach(j);
                    if (!em.contains(j)) {
                        j = em.merge(j);
                    }
                    em.remove(j);
                    em.getTransaction().commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    em.getTransaction().rollback();
                    JOptionPane.showMessageDialog(null, "Error de conexión");
                } finally {
                    em.close();
                    JOptionPane.showMessageDialog(null, "Habitación asignada con éxito");
                    selectedHabitacion = String.valueOf(habitaciones.get(i).getNumero());
                    jLabel7.setText(selectedHabitacion);
                }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaDetalleAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDetalleAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDetalleAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDetalleAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDetalleAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
