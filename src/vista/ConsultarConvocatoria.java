package vista;

import clases.Convocatoria;
import controlador.Controlador;
import excepciones.ErrConsultar;
import java.util.List;
import javax.swing.JFrame;

public class ConsultarConvocatoria extends javax.swing.JDialog {

//    public ConsultarConvocatoria() {
//        initComponents();
//    }
    private Controlador controlador;

    private List<Convocatoria> convocatorias;

    public ConsultarConvocatoria(JFrame parent, boolean b, Controlador controlador) {
        super(parent, b);
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
                cbIds.addItem(conv.getId() + "");
            }

        } catch (ErrConsultar ex) {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(49, 51, 53));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
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

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(lblId)
                        .addGap(88, 88, 88)
                        .addComponent(cbIds, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitulo)
                .addGap(50, 50, 50)
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
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
