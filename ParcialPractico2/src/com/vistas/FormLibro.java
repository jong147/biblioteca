/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.vistas;
import com.dao.LibroDAO;
import com.dao.CategoriaDAO;
import com.dao.AutorDAO;
import com.modelo.Libro;
import com.modelo.Categoria;
import com.modelo.Autor;
import com.utilidades.ComboBoxCategoria;
import com.utilidades.ComboBoxAutor;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Rogelio Mejía, Kevin Uribe, Jong Yang, Gerson González
 */
public class FormLibro extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormLibro
     */
    CategoriaDAO categoriaDAO = new CategoriaDAO();
    AutorDAO autorDAO = new AutorDAO();
    LibroDAO libroDAO = new LibroDAO();
    public FormLibro() {
        initComponents();
        comboCategoria();
        comboAutor();
        llenarTabla();
    }

    public void comboCategoria(){
        ArrayList<Categoria> listCategorias = categoriaDAO.mostrarCategoria();
        DefaultComboBoxModel<ComboBoxCategoria> modelo = new DefaultComboBoxModel();
        for (Categoria c : listCategorias){
        modelo.addElement(new ComboBoxCategoria(c.getIdCategoria(),c.getNombreCategoria()));
        }
        cbCategoria.setModel(modelo);
    }
    
    public void comboAutor(){
        ArrayList<Autor> listAutores = autorDAO.mostrarAutor();
        DefaultComboBoxModel<ComboBoxAutor> modelo = new DefaultComboBoxModel();
        for (Autor a : listAutores){
        modelo.addElement(new ComboBoxAutor(a.getIdAutor(),a.getNombreAutor()));
        }
        cbAutor.setModel(modelo);
    }
    
    public void llenarTabla(){
        ArrayList<Libro> listLibros = libroDAO.mostrarLibro();
        String[] encabezados = {"Id","Libro","Descripción","Stock","Stock Mínimo","Categoria","Autor"};
        DefaultTableModel modeloTabla = new DefaultTableModel(null, encabezados);
        for (Libro li: listLibros){
            Object[] data = {li.getIdLibro(),li.getTitulo(),
            li.getDescripcion(),li.getStock(),li.getStockMinimo(),li.getNombreCategoria(),li.getNombreAutor()};
            modeloTabla.addRow(data);
            }
        tblLibros.setModel(modeloTabla);
    }
        
    public Libro capturar(){
            int idLibro = Integer.parseInt(txtIdLibro.getText());
            String titulo = txtTitulo.getText();
            String descripcion = txtDescripcion.getText();
            int stock = Integer.parseInt(txtStock.getText());
            int stockMinimo = Integer.parseInt(txtStockMinimo.getText());
            
            String categoria = cbCategoria.getSelectedItem().toString();
            int idCategoria = 0;
            for (int i = 0; i < cbCategoria.getItemCount(); i++) {
                String nombreC = cbCategoria.getItemAt(i).getValor();
                if (categoria.equals(nombreC)) {
                    idCategoria = cbCategoria.getItemAt(i).getCodigo();
                }
            }
            
            String autor = cbAutor.getSelectedItem().toString();
            int idAutor = 0;
            for (int i = 0; i < cbAutor.getItemCount(); i++) {
                String nombreA = cbAutor.getItemAt(i).getValor();
                if (autor.equals(nombreA)) {
                    idCategoria = cbAutor.getItemAt(i).getIdAutor();
                }
            }
            
            Libro li = new Libro();
            li.setIdLibro(idLibro);
            li.setTitulo(titulo);
            li.setDescripcion(descripcion);
            li.setStock(stock);
            li.setStockMinimo(stockMinimo);
            li.setIdCategoria(idCategoria);
            li.setIdAutor(idAutor);
            return li;
    }
    
    public void limpiar(){
        txtIdLibro.setText("0");
        txtTitulo.setText("");
        txtDescripcion.setText("");
        txtStock.setText("");
        txtStockMinimo.setText("");
        cbCategoria.setSelectedIndex(0);
        cbAutor.setSelectedIndex(0);
    }
    
    public void llenarFormulario(){
        int row = tblLibros.getSelectedRow();
        String idLibro = tblLibros.getValueAt(row, 0).toString();
        String titulo = tblLibros.getValueAt(row, 1).toString();
        String descripcion = tblLibros.getValueAt(row, 2).toString();
        String stock = tblLibros.getValueAt(row, 3).toString();
        String stockMinimo = tblLibros.getValueAt(row, 4).toString();
        String nombreCategoria = tblLibros.getValueAt(row, 5).toString();
        String nombreAutor = tblLibros.getValueAt(row, 6).toString();
        
        txtIdLibro.setText(idLibro);
        txtTitulo.setText(titulo);
        txtDescripcion.setText(descripcion);
        txtStock.setText(stock);
        txtStockMinimo.setText(stockMinimo);
        cbCategoria.getModel().setSelectedItem(nombreCategoria);
        cbAutor.getModel().setSelectedItem(nombreAutor);
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
        jLabel2 = new javax.swing.JLabel();
        txtIdLibro = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        cbAutor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtStockMinimo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();

        setTitle("Datos Libros");

        jLabel1.setText("Codigo");

        jLabel2.setText("Título");

        txtIdLibro.setEditable(false);
        txtIdLibro.setText("0");

        jLabel3.setText("Stock");

        jLabel4.setText("Categoría");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tblLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLibros);

        jLabel5.setText("Autor");

        jLabel6.setText("Stock Mínimo");

        jLabel7.setText("Descripción");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIdLibro, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                            .addComponent(txtStock))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(30, 30, 30))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtStockMinimo)
                                            .addComponent(cbCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(9, 9, 9))
                                    .addComponent(jLabel5))))
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnCerrar)
                    .addComponent(btnEliminar))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int res = libroDAO.insertarLibro(capturar());
        if (res!=0) {
            JOptionPane.showMessageDialog(null, "Se agregó el libro exitosamente.");
            llenarTabla();
            limpiar();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
         if (tblLibros.getSelectedRow() != -1) {//verificar si se ha seleccionado
            int res = libroDAO.modificarLibro(capturar());
            if (res != 0) {
                JOptionPane.showMessageDialog(null, "Se modificó el libro exitosamente.");
                llenarTabla();
                limpiar();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tblLibros.getSelectedRow() != -1) {//verificar si se ha seleccionado
            int resp = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar?", "Eliminar registro", 0);
            if (JOptionPane.OK_OPTION == resp) {
                int res = libroDAO.eliminarLibro(capturar());
                if (res != 0) {
                    JOptionPane.showMessageDialog(null, "Se eliminó el libro exitosamente.");
                    llenarTabla();
                    limpiar();
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void tblLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibrosMouseClicked
        llenarFormulario();
    }//GEN-LAST:event_tblLibrosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<com.utilidades.ComboBoxAutor> cbAutor;
    private javax.swing.JComboBox<com.utilidades.ComboBoxCategoria> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdLibro;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtStockMinimo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
