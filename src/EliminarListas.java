import java.awt.Frame;
import javax.swing.JOptionPane;

public class EliminarListas extends javax.swing.JDialog {

    private Recetas[] listas;
    
    public EliminarListas(Frame parent, boolean modal, Recetas[] listas) {
        super(parent, modal);
        this.listas = listas;
        initComponents();
        prepararLista();
        setVisible(true);

    }

    public void prepararLista() {        
        for (int i = 0; i < listas.length; i++) {
            try {
                this.jTextArea1.append("   "+(i + 1) + ".- " + listas[i].getNombre()+"\n\n");
            } catch (NullPointerException e) {
                System.out.println(i);
                break;
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar una lista");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setText("Recetas disponibles");

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Inserte la lista que desea eliminar"));
        int op2 = JOptionPane.showConfirmDialog(this, "¿Está seguro de proceder?", "Eliminar lista", JOptionPane.YES_NO_OPTION);
        
        if (op2 == 0 ) {
            if (listas[opcion-1]!= null) {
                listas[opcion-1] = null;
                Recetas[] listasNuevo = new Recetas[listas.length];
                int cont1 = 0;
                int cont2 = 0;
                do {
                    if (listas[cont1] != null) {
                        listasNuevo[cont2] = listas[cont1];
                        cont2++;
                    }
                    cont1++;
                }while (cont1 < listas.length);
//                FrameInicial.instancia.setListas(listasNuevo);
                JOptionPane.showMessageDialog (null, "La lista ha sido eliminada del catálogo");
                this.setVisible(false);
                for (int i = 0; i < listasNuevo.length; i++) {
                    System.out.println(listasNuevo);
                }

            }else {
                JOptionPane.showMessageDialog (this, "La opción seleccionada es inválida");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
