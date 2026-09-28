/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.vetcontrol.Views;

import com.mycompany.vetcontrol.DAO.HistorialClinicoDAO;
import com.mycompany.vetcontrol.DAO.MascotaDAO;
import com.mycompany.vetcontrol.DAO.VeterinarioDAO;
import com.mycompany.vetcontrol.Modelo.HistorialClinicoModel;
import com.mycompany.vetcontrol.Modelo.MascotaModel;
import com.mycompany.vetcontrol.Modelo.UsuarioModel;
import com.mycompany.vetcontrol.Modelo.VeterinarioModel;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andy-
 */
public class FrmHistorialClinico extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmHistorialClinico.class.getName());
    private UsuarioModel usuarioSesion;
    
    private final HistorialClinicoDAO daoHistorial = new HistorialClinicoDAO();
    private String[] columnas = {"ID Historial", "ID Mascota", "ID Veterinario", "fecha Atención", "diagnostico", "tratamiento", "vacunas"};

    
    /**
     * Creates new form FrmHistorialClinico
     */
    public FrmHistorialClinico(UsuarioModel usuarioLogueado) {
        initComponents();
         this.usuarioSesion = usuarioLogueado;
         
         DefaultTableModel model = new DefaultTableModel (columnas, 0);
         TblHistorial.setModel(model);
        
        //Configuramos el renderizador visual para que muestre el nombre del cliente dueño
         cmbIdMascota.setRenderer(new DefaultListCellRenderer() {
             @Override
             public Component getListCellRendererComponent(JList<?> list, Object value, 
                     int index, boolean isSelected, boolean cellHasFocus) {
                 super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                 // Evaluamos si el objeto dentro de la celda es de tu clase clienteModel
                 if (value instanceof MascotaModel) {
                     MascotaModel mascota = (MascotaModel) value;
                     setText(mascota.getNombre()); 
                 }
                 return this;
             }
         });
          cargarMascotasCombo();
        
        
        //Configuramos el renderizador visual para que muestre el nombre del cliente dueño
         cmbIdVeterinario.setRenderer(new DefaultListCellRenderer() {
             @Override
             public Component getListCellRendererComponent(JList<?> list, Object value, 
                     int index, boolean isSelected, boolean cellHasFocus) {
                 super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                 // Evaluamos si el objeto dentro de la celda es de tu clase clienteModel
                 if (value instanceof VeterinarioModel) {
                     VeterinarioModel veterinario = (VeterinarioModel) value;
                     setText(veterinario.getNombre()); 
                 }
                 return this;
             }
         });
           cargarVeterinariosCombo();
           cargarHistorial();

   }
    
        
    
         
         private void cargarMascotasCombo(){
             
               try {
                 MascotaDAO mascotaDao = new MascotaDAO();
                 DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
                 for (MascotaModel m : mascotaDao.listar()) {
                     modeloCombo.addElement(m); 
                 
                 }
                 cmbIdMascota.setModel(modeloCombo);
               
               } catch (java.sql.SQLException ex) {
                   JOptionPane.showMessageDialog(this, "Error al cargar Mascota desde el DAO: " + ex.getMessage());
               }
               
         }
         
         private void cargarVeterinariosCombo(){
             
             try {
                 VeterinarioDAO veteDao = new VeterinarioDAO();
                 DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
                 for (VeterinarioModel v : veteDao.listar()) {
                     modeloCombo.addElement(v); 
                 }
                 cmbIdVeterinario.setModel(modeloCombo);
             } catch (java.sql.SQLException ex) {
                 JOptionPane.showMessageDialog(this, "Error al cargar veterinarios desde el DAO: " + ex.getMessage());
             }
         }
         
         
         private void cargarHistorial(){
             
              try{
                      // iniciamos la tabla
                  DefaultTableModel modeloHistorial = new DefaultTableModel(columnas, 0);
                  // traemos la lista desde CitaDAO
                
                  List<HistorialClinicoModel> lista = daoHistorial.listar();
                  
                  for (HistorialClinicoModel h: lista){
                      Object[] rowData ={
                          h.getIdHistorial(),
                          h.getIdMascota(),
                          h.getIdVeterinario(),
                          h.getFechaAtencion(),
                          h.getDiagnostico(),
                          h.getTratamiento(),
                          h.getVacunas(),
                   
                      };
                      
                      modeloHistorial.addRow(rowData);
                  }
                  TblHistorial.setModel(modeloHistorial);
                  
                  TblHistorial.getColumnModel().getColumn(0).setPreferredWidth(50);
                  TblHistorial.getColumnModel().getColumn(1).setPreferredWidth(80);
                  TblHistorial.getColumnModel().getColumn(2).setPreferredWidth(80);
                  TblHistorial.getColumnModel().getColumn(3).setPreferredWidth(80);
                  TblHistorial.getColumnModel().getColumn(4).setPreferredWidth(80);
                  TblHistorial.getColumnModel().getColumn(5).setPreferredWidth(80);
                  TblHistorial.getColumnModel().getColumn(6).setPreferredWidth(80);
              
              
              } catch (java.sql.SQLException e) {
                  
                  JOptionPane.showMessageDialog(this, "Error al cargar la tabla: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jpCeleste = new javax.swing.JPanel();
        lblCitas = new javax.swing.JLabel();
        lblEspecie = new javax.swing.JLabel();
        lblDiagonostico = new javax.swing.JLabel();
        lblIdMascota = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblHistorial = new javax.swing.JTable();
        cmbIdVeterinario = new javax.swing.JComboBox<>();
        txtFechaAtencion = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        lblDiagonostico1 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtATratamiento = new javax.swing.JLabel();
        lblIdVeterinario = new javax.swing.JLabel();
        cmbIdMascota = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDiagnostico = new javax.swing.JTextArea();
        btnGuardar1 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtVacunas = new javax.swing.JTextArea();
        txtATratamiento1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtTratamiento = new javax.swing.JTextArea();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpCeleste.setBackground(java.awt.SystemColor.activeCaption);

        lblCitas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCitas.setForeground(new java.awt.Color(0, 0, 0));
        lblCitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCitas.setText("Historial Clínico");

        lblEspecie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEspecie.setForeground(new java.awt.Color(0, 0, 0));
        lblEspecie.setText("Formulario de Consulta");

        lblDiagonostico.setForeground(new java.awt.Color(0, 0, 0));
        lblDiagonostico.setText("Diagnóstico:");

        lblIdMascota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdMascota.setForeground(new java.awt.Color(0, 0, 0));
        lblIdMascota.setText("Id Macota:");

        TblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "IdMascota", "IdVeterinario", "Fecha Atención", "Diagnóstico", "Tratamiento", "Vacunas"
            }
        ));
        jScrollPane1.setViewportView(TblHistorial);

        cmbIdVeterinario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);

        lblDiagonostico1.setForeground(new java.awt.Color(0, 0, 0));
        lblDiagonostico1.setText("Diagnóstico:");

        lblFecha.setForeground(new java.awt.Color(0, 0, 0));
        lblFecha.setText("Fecha Atención:");

        txtATratamiento.setForeground(new java.awt.Color(0, 0, 0));
        txtATratamiento.setText("Tratamiento:");

        lblIdVeterinario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdVeterinario.setForeground(new java.awt.Color(0, 0, 0));
        lblIdVeterinario.setText("IdVeterinario");

        cmbIdMascota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDiagnostico.setColumns(20);
        txtDiagnostico.setRows(5);
        jScrollPane3.setViewportView(txtDiagnostico);

        btnGuardar1.setText("Guardar");
        btnGuardar1.addActionListener(this::btnGuardar1ActionPerformed);

        btnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        txtVacunas.setColumns(20);
        txtVacunas.setRows(5);
        jScrollPane4.setViewportView(txtVacunas);

        txtATratamiento1.setForeground(new java.awt.Color(0, 0, 0));
        txtATratamiento1.setText("Vacunas:");

        txtTratamiento.setColumns(20);
        txtTratamiento.setRows(5);
        jScrollPane5.setViewportView(txtTratamiento);

        javax.swing.GroupLayout jpCelesteLayout = new javax.swing.GroupLayout(jpCeleste);
        jpCeleste.setLayout(jpCelesteLayout);
        jpCelesteLayout.setHorizontalGroup(
            jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCelesteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(584, 584, 584))
            .addGroup(jpCelesteLayout.createSequentialGroup()
                .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCelesteLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCelesteLayout.createSequentialGroup()
                                .addComponent(lblEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)
                                .addComponent(lblCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpCelesteLayout.createSequentialGroup()
                                .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDiagonostico, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpCelesteLayout.createSequentialGroup()
                                        .addComponent(lblIdMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbIdMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(33, 33, 33)
                                .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpCelesteLayout.createSequentialGroup()
                                        .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtATratamiento)
                                            .addComponent(lblIdVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbIdVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpCelesteLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42)
                                .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpCelesteLayout.createSequentialGroup()
                                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFechaAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpCelesteLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtATratamiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jpCelesteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCelesteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpCelesteLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(lblDiagonostico1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(734, Short.MAX_VALUE)))
        );
        jpCelesteLayout.setVerticalGroup(
            jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCelesteLayout.createSequentialGroup()
                .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCelesteLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lblEspecie))
                    .addGroup(jpCelesteLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdMascota)
                    .addComponent(lblIdVeterinario)
                    .addComponent(lblFecha)
                    .addComponent(cmbIdMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbIdVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiagonostico)
                    .addComponent(txtATratamiento)
                    .addComponent(txtATratamiento1))
                .addGap(9, 9, 9)
                .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jpCelesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpCelesteLayout.createSequentialGroup()
                    .addGap(215, 215, 215)
                    .addComponent(lblDiagonostico1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(516, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCeleste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCeleste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try{
            //saber que fila tocó el usuario
            int filaSeleccionada = TblHistorial.getSelectedRow();

            // Validación para fila cuando el usuario seleccione la cita a eliminar
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un registro de historial de la tabla.");
                return;
            }

            //Leemos el número de la columna 0 directamente de la pantalla
            int idHistorialReal = (int) TblHistorial.getValueAt(filaSeleccionada, 0);

            // Llama al DAO y eliminar en la base de datos
          
            daoHistorial.eliminar(idHistorialReal);
            JOptionPane.showMessageDialog(this, "¡Cita eliminada!");
            cargarHistorial();
        }catch (java.sql.SQLException e) {

            JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        // TODO add your handling code here:
        
        try{
            Object mascotaSeleccionada = cmbIdMascota.getSelectedItem();
            Object veterinarioSeleccionado = cmbIdVeterinario.getSelectedItem();
            
            String fechaStr= txtFechaAtencion.getText().trim();
            String diagnostico = txtDiagnostico.getText().trim();
            String tratamiento = txtVacunas.getText().trim();
            String vacunas = txtVacunas.getText().trim();
            
            
            if(mascotaSeleccionada==null){
                JOptionPane.showMessageDialog(this,"debe seleccionar un paciente de la lista");
                return;
            }
             if(veterinarioSeleccionado==null){
                JOptionPane.showMessageDialog(this,"debe seleccionar el Dr.veterinario");
                return;
             }
             if(fechaStr.isBlank()){
                JOptionPane.showMessageDialog(this,"La fecha de atencion es obligatoria");
                return;
             }
             if(diagnostico.isBlank()){
                JOptionPane.showMessageDialog(this,"El diagnóstico médico es obligatorio");
                return;
             }
              if(tratamiento.isBlank()){
                JOptionPane.showMessageDialog(this,"El tratamiento asignado es obligatorio");
                return;
              }
               if(vacunas.isBlank()){
                JOptionPane.showMessageDialog(this,"Las vacunas de la mascota es obligatorio");
                return;
               }
               
              //Covertir los String a formato de tiempo en java
                java.time.LocalDate fechaTransformada =java.time.LocalDate.parse(txtFechaAtencion.getText().trim());
                
                 
                //Convertimos los objetos genéricos de los combos a tus modelos reales
                MascotaModel mascotaReal = (MascotaModel) mascotaSeleccionada; 
                VeterinarioModel veterinarioReal = (VeterinarioModel) veterinarioSeleccionado;
                
               
                
                HistorialClinicoModel h = new HistorialClinicoModel();
                h.setIdMascota(mascotaReal.getIdMascota());
                h.setIdVeterinario(veterinarioReal.getIdVeterinario());
                h.setFechaAtencion(fechaTransformada);
                h.setDiagnostico(diagnostico);
                h.setTratamiento(tratamiento);
                h.setTratamiento(vacunas);
                
                daoHistorial.insertar(h);
                
                JOptionPane.showMessageDialog(this, "Historial clinico registrado con éxito");
                //cargamos la tabla
                cargarHistorial();
                
               //limpiamos los canpos
                txtFechaAtencion.setText(""); 
                txtDiagnostico.setText(""); 
                txtTratamiento.setText(""); 
                txtVacunas.setText("");
             
             
        }catch (java.time.format.DateTimeParseException e) { 
            JOptionPane.showMessageDialog(this, "Use el formato de fecha YYYY-MM-DD (Ej: 2026-03-15).", "Formato Incorrecto", javax.swing.JOptionPane.ERROR_MESSAGE); 
        } catch (java.sql.SQLException e) { 
            JOptionPane.showMessageDialog(this, "Error en Aiven Cloud: " + e.getMessage(), "Error SQL", javax.swing.JOptionPane.ERROR_MESSAGE); 
        } 


    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
         FrmMenu frmMenu =new FrmMenu();
         frmMenu.setVisible(true);
         dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmHistorialClinico(new UsuarioModel()).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblHistorial;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbIdMascota;
    private javax.swing.JComboBox<String> cmbIdVeterinario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jpCeleste;
    private javax.swing.JLabel lblCitas;
    private javax.swing.JLabel lblDiagonostico;
    private javax.swing.JLabel lblDiagonostico1;
    private javax.swing.JLabel lblEspecie;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIdMascota;
    private javax.swing.JLabel lblIdVeterinario;
    private javax.swing.JLabel txtATratamiento;
    private javax.swing.JLabel txtATratamiento1;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JTextField txtFechaAtencion;
    private javax.swing.JTextArea txtTratamiento;
    private javax.swing.JTextArea txtVacunas;
    // End of variables declaration//GEN-END:variables
}
