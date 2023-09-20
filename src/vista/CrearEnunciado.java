/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import clases.Dificultad;
import clases.Enunciado;
import controlador.Controlador;
import excepciones.ErrCrear;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jnafilechooser.api.JnaFileChooser;

/**
 *
 * @author Jason.
 */
public class CrearEnunciado extends javax.swing.JDialog {

    private Controlador con;
    private String ruta = "";

    /**
     * Creates new form CrearEnunciado
     */
    public CrearEnunciado(java.awt.Frame parent, boolean modal, Controlador con) {
        super(parent, modal);
        initComponents();
        this.con = con;
        txtNivel.setSelectedIndex(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngDisponible = new javax.swing.ButtonGroup();
        fondo = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lbl1 = new javax.swing.JLabel();
        lblDisponible = new javax.swing.JLabel();
        txtNivel = new javax.swing.JComboBox<>();
        rdbtnSi = new javax.swing.JRadioButton();
        rdbtnNo = new javax.swing.JRadioButton();
        lblRuta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(49, 51, 53));

        lblId.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(227, 227, 227));
        lblId.setText("ID:");

        txtId.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblDescripcion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(227, 227, 227));
        lblDescripcion.setText("Descripcion:");

        txtDescripcion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lbl1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbl1.setForeground(new java.awt.Color(227, 227, 227));
        lbl1.setText("Nivel:");

        lblDisponible.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblDisponible.setForeground(new java.awt.Color(227, 227, 227));
        lblDisponible.setText("Disponible:");

        txtNivel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alta", "Media", "Baja" }));

        rdbtnSi.setBackground(fondo.getBackground());
        btngDisponible.add(rdbtnSi);
        rdbtnSi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rdbtnSi.setForeground(new java.awt.Color(227, 227, 227));
        rdbtnSi.setText("Si");

        rdbtnNo.setBackground(fondo.getBackground());
        btngDisponible.add(rdbtnNo);
        rdbtnNo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rdbtnNo.setForeground(new java.awt.Color(227, 227, 227));
        rdbtnNo.setText("No");

        lblRuta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblRuta.setForeground(new java.awt.Color(227, 227, 227));
        lblRuta.setText("Ruta:");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(227, 227, 227));
        jLabel1.setText("CREAR ENUNCIADO");

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                                .addComponent(lblId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescripcion)
                                    .addComponent(lbl1)
                                    .addComponent(lblRuta)
                                    .addComponent(lblDisponible))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(fondoLayout.createSequentialGroup()
                                        .addComponent(rdbtnSi)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rdbtnNo))
                                    .addComponent(txtDescripcion)
                                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(25, 25, 25))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl1))
                .addGap(45, 45, 45)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtnSi)
                    .addComponent(rdbtnNo)
                    .addComponent(lblDisponible))
                .addGap(43, 43, 43)
                .addComponent(lblRuta)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutaActionPerformed
        JnaFileChooser ch = new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);

        if (action) {
            ruta = ch.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(this, "Ruta seleccionada correctamente", "", 3);
        }
    }//GEN-LAST:event_btnRutaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtId.setText("");
        txtDescripcion.setText("");
        txtNivel.setSelectedIndex(-1);
        rdbtnSi.setSelected(false);
        rdbtnNo.setSelected(false);
        ruta = "";
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        if (this.validarDatos()) {
            try {
                Enunciado enunciado = new Enunciado();
                enunciado.setId(Integer.parseInt(txtId.getText()));
                enunciado.setDescripcion(txtDescripcion.getText());

                enunciado.setDisponible(rdbtnSi.isSelected());
                enunciado.setRuta(ruta);

                switch (txtNivel.getSelectedIndex()) {
                    case 0:
                        enunciado.setNivel(Dificultad.ALTA);
                        break;
                    case 1:
                        enunciado.setNivel(Dificultad.MEDIA);
                        break;
                    case 2:
                        enunciado.setNivel(Dificultad.BAJA);
                        break;
                    default:
                        System.out.println("Seleciona un nivel --> " + txtNivel.getSelectedIndex());
                }

                con.crearEnunciado(enunciado);
                btnLimpiarActionPerformed(evt);

            } catch (ErrCrear ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    public boolean validarDatos() {
        boolean valido = true;

        try {
            Integer.parseInt(txtId.getText());

        } catch (NumberFormatException e) {
            valido = false;
            System.out.println("Eso no es un numero");
        }

        if (txtNivel.getSelectedIndex() == -1) {
            valido = false;
            System.out.println("Elige un nivel");
        }

        if (!rdbtnSi.isSelected() == !rdbtnNo.isSelected()) {
            valido = false;
            System.out.println("Es disponible?");
        }

        return valido;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngDisponible;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDisponible;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JRadioButton rdbtnNo;
    private javax.swing.JRadioButton rdbtnSi;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JComboBox<String> txtNivel;
    // End of variables declaration//GEN-END:variables
}
