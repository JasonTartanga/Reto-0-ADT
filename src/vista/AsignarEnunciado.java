/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import clases.Convocatoria;
import clases.Enunciado;
import clases.UnidadDidactica;
import controlador.Controlador;
import excepciones.ErrConsultar;
import excepciones.ErrCrear;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jason.
 */
public class AsignarEnunciado extends javax.swing.JDialog {

    private Controlador controlador;
    private List<Convocatoria> convocatorias;
    private List<Enunciado> enunciados;

    /**
     * Creates new form AsignarUnidad
     */
    public AsignarEnunciado(java.awt.Frame parent, boolean modal, Controlador controlador) {
        super(parent, modal);
        initComponents();
        this.controlador = controlador;

        try {
            enunciados = controlador.listarEnunciados();
            convocatorias = controlador.listarConvocatorias();

            for (Convocatoria convocatoria : convocatorias) {
                cbConvocatoria.addItem(convocatoria.getId() + "");
            }

            for (Enunciado enunciado : enunciados) {
                cbEnunciado.addItem(enunciado.getId() + "");
            }
            cbConvocatoria.setSelectedIndex(-1);
            cbEnunciado.setSelectedIndex(-1);

        } catch (ErrConsultar ex) {
            ex.mostrarError();
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

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblConvocatoria = new javax.swing.JLabel();
        cbConvocatoria = new javax.swing.JComboBox<>();
        lblEnunciado = new javax.swing.JLabel();
        cbEnunciado = new javax.swing.JComboBox<>();
        btnAsignar = new excepciones.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(49, 51, 53));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(227, 227, 227));
        lblTitulo.setText("ASIGNAR ENUNCIADO A CONVOCATORIA");

        lblConvocatoria.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblConvocatoria.setForeground(new java.awt.Color(227, 227, 227));
        lblConvocatoria.setText("Unidad didactica:");

        cbConvocatoria.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        lblEnunciado.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblEnunciado.setForeground(new java.awt.Color(227, 227, 227));
        lblEnunciado.setText("Enunciado:");

        cbEnunciado.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        btnAsignar.setText("Asignar");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblConvocatoria)
                                    .addComponent(lblEnunciado))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEnunciado, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbConvocatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTitulo)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnunciado)
                    .addComponent(cbEnunciado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbConvocatoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConvocatoria))
                .addGap(97, 97, 97)
                .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        try {
            int convocatoria = convocatorias.get(cbConvocatoria.getSelectedIndex()).getId();
            int enunciado = enunciados.get(cbEnunciado.getSelectedIndex()).getId();
            controlador.asignarUnidad(convocatoria, enunciado);
        } catch (ErrCrear ex) {
            ex.mostrarError();
        }
    }//GEN-LAST:event_btnAsignarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private excepciones.Button btnAsignar;
    private javax.swing.JComboBox<String> cbConvocatoria;
    private javax.swing.JComboBox<String> cbEnunciado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConvocatoria;
    private javax.swing.JLabel lblEnunciado;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
