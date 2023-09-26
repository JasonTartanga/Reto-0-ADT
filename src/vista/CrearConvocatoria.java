package vista;

import clases.Convocatoria;
import controlador.Controlador;
import excepciones.ErrCrear;

public class CrearConvocatoria extends javax.swing.JDialog {

    private Controlador controlador;

    public CrearConvocatoria(java.awt.Frame parent, boolean modal, Controlador controlador) {
        super(parent, modal);
        this.controlador = controlador;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblConvocatoria = new javax.swing.JLabel();
        txtConvocatoria = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblCurso = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        btnCrear = new excepciones.Button();
        btnLimpiar = new excepciones.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(48, 51, 53));

        fondo.setBackground(new java.awt.Color(49, 51, 53));

        lblTitulo.setBackground(new java.awt.Color(227, 227, 227));
        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(227, 227, 227));
        lblTitulo.setText("CREAR CONVOCATORIA");

        lblId.setBackground(new java.awt.Color(227, 227, 227));
        lblId.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(227, 227, 227));
        lblId.setText("Id:");

        lblConvocatoria.setBackground(new java.awt.Color(227, 227, 227));
        lblConvocatoria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblConvocatoria.setForeground(new java.awt.Color(227, 227, 227));
        lblConvocatoria.setText("Convocatoria");

        lblDescripcion.setBackground(new java.awt.Color(227, 227, 227));
        lblDescripcion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(227, 227, 227));
        lblDescripcion.setText("Descripcion");

        lblFecha.setBackground(new java.awt.Color(227, 227, 227));
        lblFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(227, 227, 227));
        lblFecha.setText("Fecha");

        lblCurso.setBackground(new java.awt.Color(227, 227, 227));
        lblCurso.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCurso.setForeground(new java.awt.Color(227, 227, 227));
        lblCurso.setText("Curso");

        btnCrear.setBackground(new java.awt.Color(227, 227, 227));
        btnCrear.setBorder(null);
        btnCrear.setText("Crear");
        btnCrear.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(227, 227, 227));
        btnLimpiar.setBorder(null);
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId)
                    .addComponent(lblFecha)
                    .addComponent(lblCurso)
                    .addComponent(lblConvocatoria)
                    .addComponent(lblDescripcion))
                .addGap(36, 36, 36)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtConvocatoria, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(txtId)
                    .addComponent(txtDescripcion)
                    .addComponent(txtFecha)
                    .addComponent(txtCurso))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addContainerGap(65, Short.MAX_VALUE)
                        .addComponent(lblTitulo)))
                .addGap(51, 51, 51))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(30, 30, 30)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addGap(40, 40, 40)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConvocatoria)
                    .addComponent(txtConvocatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurso)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        try {
            Convocatoria conv = new Convocatoria();

            conv.setId(Integer.parseInt(txtId.getText()));
            conv.setConvocatoria(txtConvocatoria.getText());
            conv.setDescripcion(txtDescripcion.getText());
            conv.setFecha(txtFecha.getText());
            conv.setCurso(txtCurso.getText());

            controlador.crearConvocatoria(conv);

        } catch (ErrCrear ex) {
            ex.mostrarError();
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        txtConvocatoria.setText("");
        txtDescripcion.setText("");
        txtFecha.setText("");
        txtCurso.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private excepciones.Button btnCrear;
    private excepciones.Button btnLimpiar;
    private javax.swing.JPanel fondo;
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
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
