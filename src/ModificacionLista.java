
import javax.swing.*;


public class ModificacionLista extends javax.swing.JDialog {

    private Recetas laLista;
    private PasosdeRecetas[] nodos;
    
    public ModificacionLista(java.awt.Frame parent, boolean modal, Recetas laLista) {
        super(parent, modal);
        this.laLista = laLista;
        initComponents();
        mostrarLista();
        setVisible(true);
    }

    public void mostrarLista() {
        this.jLabel1.setText(laLista.getNombre());
        nodos = laLista.getEstructura();
        PasosdeRecetas nodoInicial = nodos[0];
        PasosdeRecetas otroNodo = nodoInicial;
        int contador = 0;
        do {
            this.jTextArea1.append("  "+(contador+1)+".- "+otroNodo.getInfor());
            this.jTextArea1.append("\n\n");
            contador++;
            otroNodo = otroNodo.getLiga();
        }while (otroNodo != null);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista actual");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("jLabel1");

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Modificar paso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar paso");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Nuevo paso antes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Nuevo paso despues");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int paso = Integer.parseInt (JOptionPane.showInputDialog("Inserte el paso a modificar"));
        if (nodos[paso-1] != null) {
            String nuevoInfor = JOptionPane.showInputDialog("Inserte la información a cambiar\n\nInformación anterior: "+nodos[paso-1].getInfor()+"\n\n");
            nodos[paso-1].setInfor(nuevoInfor);
            JOptionPane.showMessageDialog(null,"Informacion modificada");
            this.dispose();
        }else {
            JOptionPane.showMessageDialog (null, "El paso seleccionado no existe");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int paso = Integer.parseInt (JOptionPane.showInputDialog("Inserte el paso a eliminar"));
        if (paso == 1) {
            nodos[paso-1].setInfor(null);
            nodos[paso-1].setLiga(null);
            nodos[paso-1] = null;
            PasosdeRecetas []listaNueva = new PasosdeRecetas [nodos.length];
            int cont1 = 0;
            int cont2 = 0;
            do {
                if (nodos[cont1] != null) {
                    listaNueva[cont2] = nodos[cont1];
                    cont2++;
                }
                cont1++;
            }while (cont1 < nodos.length);
            laLista.setNodoEstructura(listaNueva);
            JOptionPane.showMessageDialog(null,"Nodo Eliminado");
            this.dispose();
            return;
        }

        if (paso == nodos.length) {
            nodos[paso-2].setLiga(null);
            nodos[paso-1].setInfor(null);
            nodos[paso-1].setLiga(null);
            nodos[paso-1] = null;
            PasosdeRecetas []listaNueva = new PasosdeRecetas [nodos.length];
            int cont1 = 0;
            int cont2 = 0;
            do {
                if (nodos[cont1] != null) {
                    listaNueva[cont2] = nodos[cont1];
                    cont2++;
                }
                cont1++;
            }while (cont1 < nodos.length);
            laLista.setNodoEstructura(listaNueva);
            JOptionPane.showMessageDialog(null,"Nodo Eliminado");
            this.dispose();
            return;
        }

        if (nodos[paso-1] != null) {
            nodos[paso-1].setInfor(null);
            nodos[paso-2].setLiga(nodos[paso]);
            nodos[paso-1].setLiga(null);
            nodos[paso-1] = null;
            PasosdeRecetas []listaNueva = new PasosdeRecetas [nodos.length];
            int cont1 = 0;
            int cont2 = 0;
            do {
                if (nodos[cont1] != null) {
                    listaNueva[cont2] = nodos[cont1];
                    cont2++;
                }
                cont1++;
            }while (cont1 < nodos.length);
            laLista.setNodoEstructura(listaNueva);
            JOptionPane.showMessageDialog(null,"Nodo Eliminado");
            this.dispose();
        }else {
            JOptionPane.showMessageDialog (null, "El paso seleccionado no existe");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int paso = Integer.parseInt (JOptionPane.showInputDialog("Inserte donde desea agregar un nodo antes"));
        if (paso == 1) {
            String infor = JOptionPane.showInputDialog(null, "Ingrese la nueva informacion") ;
            PasosdeRecetas unNodo = new PasosdeRecetas (infor);
            PasosdeRecetas []listaNueva = new PasosdeRecetas [nodos.length+1];
            listaNueva[0] = unNodo;
            for (int i = 1; i < listaNueva.length; i++) {
                listaNueva[i] = nodos[i-1];
            }
            listaNueva[0].setLiga(listaNueva[1]);
            laLista.setNodoEstructura(listaNueva);
            JOptionPane.showMessageDialog(null,"Nodo Insertado");
            this.dispose();
            return;
        }

        if (paso == nodos.length) {
            String infor = JOptionPane.showInputDialog(null, "Ingrese la nueva informacion") ;
            PasosdeRecetas unNodo = new PasosdeRecetas (infor);
            PasosdeRecetas []listaNueva = new PasosdeRecetas [nodos.length+1];
            for (int i = 0; i < nodos.length; i++) {
                    listaNueva[i] = nodos[i];
            }
            listaNueva[listaNueva.length-2] = unNodo;
            listaNueva[listaNueva.length-1] = nodos[nodos.length-1];
            for (int i = 0; i < (listaNueva.length-1); i++) {
                listaNueva[i].setLiga(listaNueva[i+1]);
            }
            listaNueva[listaNueva.length-1].setLiga(null);
            laLista.setNodoEstructura(listaNueva);
            JOptionPane.showMessageDialog(null,"Nodo Insertado");
            this.dispose();
            return;
        }
        if (nodos[paso-1] != null) {
            String infor = JOptionPane.showInputDialog(null, "Ingrese la nueva informacion") ;
            PasosdeRecetas unNodo = new PasosdeRecetas (infor);
            PasosdeRecetas []listaNueva = new PasosdeRecetas [nodos.length+1];
            for (int i = 0; i < (paso-1); i++) {
                listaNueva[i] = nodos[i];
                System.out.println("COPIANDO "+listaNueva[i]);
            }
            listaNueva[paso-1] = unNodo;
            for (int i = (paso); i < listaNueva.length; i++) {
                listaNueva[i] = nodos[i-1];
                
            }
            listaNueva[paso].setLiga(listaNueva[paso+1]);
            PasosdeRecetas nodoInicial = listaNueva[0];

            for (int i = 0; i < (listaNueva.length-1); i++) {
                listaNueva[i].setLiga(listaNueva[i+1]);
            }
            listaNueva[listaNueva.length-1].setLiga(null);

            do {
                System.out.println("MIRA  "+nodoInicial.getInfor());
                nodoInicial = nodoInicial.getLiga();
            }while (nodoInicial !=  null);
            laLista.setNodoEstructura(listaNueva);
            JOptionPane.showMessageDialog(null,"Nodo Insertado");
            this.dispose();
            return;
        }else {
            JOptionPane.showMessageDialog (null, "El paso seleccionado no existe");
        }

        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int paso = Integer.parseInt (JOptionPane.showInputDialog("Inserte donde desea agregar un nodo despues"));
        if (paso == 1) {
            String infor = JOptionPane.showInputDialog(null, "Ingrese la nueva informacion") ;
            PasosdeRecetas unNodo = new PasosdeRecetas (infor);
            PasosdeRecetas []listaNueva = new PasosdeRecetas [nodos.length+1];
            listaNueva[0] = nodos[0];
            listaNueva[1] = unNodo;
            for (int i = 2; i < listaNueva.length; i++) {
                listaNueva[i] = nodos[i-1];
            }
            listaNueva[0].setLiga(listaNueva[1]);
            listaNueva[1].setLiga(listaNueva[2]);
            laLista.setNodoEstructura(listaNueva);
            JOptionPane.showMessageDialog(null,"Nodo Insertado");
            this.dispose();
            return;
        }
        if (paso == nodos.length) {
            String infor = JOptionPane.showInputDialog(null, "Ingrese la nueva informacion") ;
            PasosdeRecetas unNodo = new PasosdeRecetas (infor);
            PasosdeRecetas []listaNueva = new PasosdeRecetas [nodos.length+1];
            listaNueva[listaNueva.length-1] = unNodo;
            listaNueva[listaNueva.length-2] = nodos[nodos.length-1];
            for (int i = 0; i < (listaNueva.length-2); i++) {
                listaNueva[i] = nodos[i];
            }
            listaNueva[listaNueva.length-2].setLiga(listaNueva[listaNueva.length-1]);
            listaNueva[listaNueva.length-1].setLiga(null);
            laLista.setNodoEstructura(listaNueva);
            JOptionPane.showMessageDialog(null,"Nodo Insertado");
            this.dispose();
            return;
        }// TODO add your handling code here:

        if (nodos[paso-1] != null) {
            String infor = JOptionPane.showInputDialog(null, "Ingrese la nueva informacion") ;
            PasosdeRecetas unNodo = new PasosdeRecetas (infor);
            PasosdeRecetas []listaNueva = new PasosdeRecetas [nodos.length+1];
            for (int i = 0; i < (paso); i++) {
                listaNueva[i] = nodos[i];
            }
            listaNueva[paso] = unNodo;
            for (int i = (paso+1); i < listaNueva.length; i++) {
                listaNueva[i] = nodos[i-1];
            }
            listaNueva[paso].setLiga(listaNueva[paso+1]);
            PasosdeRecetas nodoInicial = listaNueva[0];

            for (int i = 0; i < (listaNueva.length-1); i++) {
                listaNueva[i].setLiga(listaNueva[i+1]);
            }
            listaNueva[listaNueva.length-1].setLiga(null);

            do {
                System.out.println("MIRA  "+nodoInicial.getInfor());
                nodoInicial = nodoInicial.getLiga();
            }while (nodoInicial !=  null);
            laLista.setNodoEstructura(listaNueva);
            JOptionPane.showMessageDialog(null,"Nodo Insertado");
            this.dispose();
            return;
        }else {
            JOptionPane.showMessageDialog (null, "El paso seleccionado no existe");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
