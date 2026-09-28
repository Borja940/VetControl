/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.vetcontrol.Views;

import com.mycompany.vetcontrol.DAO.CitaDAO;
import com.mycompany.vetcontrol.DAO.MascotaDAO;
import com.mycompany.vetcontrol.DAO.VeterinarioDAO;
import com.mycompany.vetcontrol.Modelo.CitaModel;

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
public class FrmCitas extends javax.swing.JFrame {
    
    private UsuarioModel usuarioSesion;
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmCitas.class.getName()); 
    private final CitaDAO dao = new CitaDAO();
    private String[] columnas = {"idCita", "idMascota", "fecha", "hora", "idVeterinario", "motivo"};
    
     
     
    
    public FrmCitas(UsuarioModel usuarioLogueado) {
        initComponents();
        this.usuarioSesion = usuarioLogueado;
       
        
        DefaultTableModel model = new DefaultTableModel (columnas, 0);
        TblCitas.setModel(model);
        
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
                 JOptionPane.showMessageDialog(this, "Error al cargar Mascota " + ex.getMessage());
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
                 JOptionPane.showMessageDialog(this, "Error al cargar veterinarios " + ex.getMessage());
             }
             cargarCitasTabla();
         }
         
          private void cargarCitasTabla(){
              
              try{
                      // iniciamos la tabla
                  DefaultTableModel modeloCitas = new DefaultTableModel(columnas, 0);
                  // traemos la lista desde CitaDAO
                  CitaDAO CitaDAO = new CitaDAO();
                  List<CitaModel> lista = CitaDAO.listar();
                  
                  for (CitaModel c: lista){
                      Object[] rowData ={
                          c.getIdCita(),
                          c.getIdMascota(),
                          c.getFecha(),
                          c.getHora(),
                          c.getIdVeterinario(),
                          c.getMotivo(),
                    
                      };
                      
                      modeloCitas.addRow(rowData);
                  }
                  TblCitas.setModel(modeloCitas);
                  
                  TblCitas.getColumnModel().getColumn(0).setPreferredWidth(50);
                  TblCitas.getColumnModel().getColumn(1).setPreferredWidth(80);
                  TblCitas.getColumnModel().getColumn(2).setPreferredWidth(80);
                  TblCitas.getColumnModel().getColumn(3).setPreferredWidth(80);
                  TblCitas.getColumnModel().getColumn(4).setPreferredWidth(80);
                  TblCitas.getColumnModel().getColumn(5).setPreferredWidth(80);
              
              } catch (java.sql.SQLException e) {
                  
                  JOptionPane.showMessageDialog(this, "Error al cargar la tabla: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
              }
          }

         

                
    /**
     * Creates new form FrmCitas
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        lblCitas = new javax.swing.JLabel();
        lblMotivo = new javax.swing.JLabel();
        txtMotivoConsulta = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        lblVeterinario = new javax.swing.JLabel();
        lblIdMascota = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        cmbIdMascota = new javax.swing.JComboBox();
        txtHora = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblCitas = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        cmbIdVeterinario = new javax.swing.JComboBox();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(java.awt.SystemColor.activeCaption);

        lblCitas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCitas.setForeground(new java.awt.Color(0, 0, 0));
        lblCitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCitas.setText("Citas");

        lblMotivo.setForeground(new java.awt.Color(0, 0, 0));
        lblMotivo.setText("Motivo Consulta:");

        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 0));
        lblFecha.setText("Fecha:");

        lblVeterinario.setForeground(new java.awt.Color(0, 0, 0));
        lblVeterinario.setText("Veterinario:");

        lblIdMascota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdMascota.setForeground(new java.awt.Color(0, 0, 0));
        lblIdMascota.setText("Macota:");

        lblHora.setForeground(new java.awt.Color(0, 0, 0));
        lblHora.setText("Hora:");

        cmbIdMascota.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        TblCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "IdCita", "IdMascota", "Fecha", "Hora", "Motivo Consulta", "Veterinario"
            }
        ));
        jScrollPane2.setViewportView(TblCitas);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(this::btnRegistrarActionPerformed);

        btnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        cmbIdVeterinario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(lblIdMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbIdMascota, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(lblMotivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMotivoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbIdVeterinario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                        .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(lblCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblIdMascota)
                        .addComponent(lblFecha)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbIdMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHora)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMotivoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMotivo)
                            .addComponent(lblVeterinario)
                            .addComponent(cmbIdVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        
        try {
                // Extraer los IDs ocultos de JComboBox de forma segura
                Object mascotaSeleccionada = cmbIdMascota.getSelectedItem(); 
                Object veterinarioSeleccionado = cmbIdVeterinario.getSelectedItem();
                
                //declaramos las variables
                String motivo = txtMotivoConsulta.getText().trim();
                String fechaStr = txtHora.getText().trim(); // Suponiendo que ingresan "YYYY-MM-DD"
                String horaStr = txtHora.getText().trim(); // suponiendo que ingresan " 13:30:00"
                
                //validaciones
                if (mascotaSeleccionada == null) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar una mascota.");
                    return;
                }
                if (veterinarioSeleccionado == null) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un veterinario.");
                    return;
                }
                if (fechaStr.isBlank()){
                    JOptionPane.showMessageDialog(this, "La fecha es obligatoria.");
                    return;
                }
                 if (horaStr.isBlank()) {
                    JOptionPane.showMessageDialog(this, "La hora  es obligatoria.");
                    return;
                    
                }
                if (motivo.isBlank()) {
                    JOptionPane.showMessageDialog(this, "El motivo de consulta es obligatorio.");
                    return;
                }
                
                //Covertir los String a formato de tiempo en java
                java.time.LocalDate fechaTransformada =java.time.LocalDate.parse(txtFecha.getText().trim());
                java.time.LocalTime horaTransformada =java.time.LocalTime.parse(txtHora.getText().trim());
        
               
                //Convertimos los objetos genéricos de los combos a tus modelos reales
                MascotaModel mascotaReal = (MascotaModel) mascotaSeleccionada; 
                VeterinarioModel veteReal = (VeterinarioModel) veterinarioSeleccionado;
                
                
                CitaDAO citaDao = new CitaDAO();
                
                //  Validación de citas cruzadas
                
                if (citaDao.existeCitaCruzada(fechaTransformada,java.sql.Time.valueOf(horaTransformada),veteReal.getIdVeterinario())) {
            JOptionPane.showMessageDialog(this, "¡Error! El veterinario ya tiene una cita agendada para esa fecha y hora.", "verifique la cita", 
                    JOptionPane.ERROR_MESSAGE);
            return; // Detiene el registro por completo, no permite que se ejecute el insert
        }
                //armar el objeto e insertat
                
                CitaModel c = new CitaModel();
                c.setFecha(fechaTransformada);
                c.setHora(horaTransformada);
                c.setMotivo(motivo);
                c.setIdMascota(mascotaReal.getIdMascota());
                c.setIdVeterinario(veteReal.getIdVeterinario());
                
                citaDao.insertar(c);
                
                JOptionPane.showMessageDialog(this, "Cita registrada con éxito");
                txtMotivoConsulta.setText(""); 
                txtFecha.setText(""); 
                txtHora.setText("");
                
                cargarCitasTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en el formato de datos o conexión: " + e.getMessage());
    }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try{    
            //saber que fila tocó el usuario
        int filaSeleccionada = TblCitas.getSelectedRow();
        
        // Validación para fila, si no se seleccionó nada
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita de la tabla.");
            return;
        }
        
        //Leemos el número de la columna 0 directamente de la pantalla
        int idCitaReal = (int) TblCitas.getValueAt(filaSeleccionada, 0);
        
        // Llama al DAO y eliminar en la base de datos
        CitaDAO citaDao = new CitaDAO();
        citaDao.eliminar(idCitaReal); 
        
        JOptionPane.showMessageDialog(this, "¡Cita eliminada!");
        cargarCitasTabla(); 
        }catch (java.sql.SQLException e) {
            
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
    }

    }//GEN-LAST:event_btnEliminarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FrmCitas((new UsuarioModel())).setVisible(true));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblCitas;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox cmbIdMascota;
    private javax.swing.JComboBox cmbIdVeterinario;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCitas;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblIdMascota;
    private javax.swing.JLabel lblMotivo;
    private javax.swing.JLabel lblVeterinario;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMotivoConsulta;
    // End of variables declaration//GEN-END:variables
}