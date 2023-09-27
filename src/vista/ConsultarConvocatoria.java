package vista;

import clases.Convocatoria;
import controlador.Controlador;
import excepciones.ErrConsultar;
import excepciones.ErrExtra;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * Esta ventana permite al usuario buscar los datos de una convocatoria.
 *
 * @author Jason.
 */
public class ConsultarConvocatoria extends javax.swing.JDialog {

    private Controlador controlador;

    private List<Convocatoria> convocatorias;

    /**
     * Crea la ventana ConsultarConvocatoria.
     *
     * @param parent la ventana padre.
     * @param modal si es modal.
     * @param controlador el controlador de la aplicacion.
     */
    public ConsultarConvocatoria(JFrame parent, boolean modal, Controlador controlador) {
        super(parent, modal);
        initComponents();

        this.controlador = controlador;

        txtConvocatoria.setVisible(false);
        txtCurso.setVisible(false);
        txtDescripcion.setVisible(false);
        txtFecha.setVisible(false);
        lblConvocatoria.setVisible(false);
        lblCurso.setVisible(false);
        lblDescripcion.setVisible(false);
        lblFecha.setVisible(false);

        try {
            convocatorias = controlador.listarConvocatorias();

            for (Convocatoria conv : convocatorias) {
                cbIds.addItem(conv.getConvocatoria() + "");
            }

        } catch (ErrConsultar ex) {
            ex.mostrarError();
        } catch (ErrExtra ex) {
            ex.mostrarError();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        cbIds = new javax.swing.JComboBox<>();
        lblConvocatoria = new javax.swing.JLabel();
        txtConvocatoria = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblCurso = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnVolver = new excepciones.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(49, 51, 53));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(227, 227, 227));
        lblTitulo.setText("CONSULTAR CONVOCATORIA");

        lblId.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(227, 227, 227));
        lblId.setText("Id:");

        cbIds.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbIdsItemStateChanged(evt);
            }
        });

        lblConvocatoria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblConvocatoria.setForeground(new java.awt.Color(227, 227, 227));
        lblConvocatoria.setText("Convocatoria");

        lblDescripcion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(227, 227, 227));
        lblDescripcion.setText("Descripcion");

        lblFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(227, 227, 227));
        lblFecha.setText("Fecha");

        lblCurso.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCurso.setForeground(new java.awt.Color(227, 227, 227));
        lblCurso.setText("Curso");

        jSeparator1.setForeground(new java.awt.Color(227, 227, 227));

        btnVolver.setText("<---");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(lblId)
                                .addGap(88, 88, 88)
                                .addComponent(cbIds, 0, 187, Short.MAX_VALUE))
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblConvocatoria)
                                    .addComponent(lblDescripcion)
                                    .addComponent(lblCurso)
                                    .addComponent(lblFecha))
                                .addGap(18, 18, 18)
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCurso)
                                    .addComponent(txtFecha)
                                    .addComponent(txtDescripcion)
                                    .addComponent(txtConvocatoria)))
                            .addComponent(jSeparator1)))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTitulo)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo))
                .addGap(41, 41, 41)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(cbIds, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConvocatoria)
                    .addComponent(txtConvocatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha))
                .addGap(40, 40, 40)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurso))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Si se selecciona una convocatoria muestra todos sus datos.
     *
     * @param evt
     */
    private void cbIdsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbIdsItemStateChanged
        txtConvocatoria.setVisible(true);
        txtCurso.setVisible(true);
        txtDescripcion.setVisible(true);
        txtFecha.setVisible(true);
        lblConvocatoria.setVisible(true);
        lblCurso.setVisible(true);
        lblDescripcion.setVisible(true);
        lblFecha.setVisible(true);

        Convocatoria conv = convocatorias.get(cbIds.getSelectedIndex());

        txtConvocatoria.setText(conv.getConvocatoria());
        txtCurso.setText(conv.getCurso());
        txtDescripcion.setText(conv.getDescripcion());
        txtFecha.setText(conv.getFecha());
    }//GEN-LAST:event_cbIdsItemStateChanged

    /**
     * Vuelve a la ventana inicial.
     *
     * @param evt
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
        VMain vMain = new VMain(controlador);
        vMain.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private excepciones.Button btnVolver;
    private javax.swing.JComboBox<String> cbIds;
    private javax.swing.JPanel fondo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblConvocatoria;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtConvocatoria;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
