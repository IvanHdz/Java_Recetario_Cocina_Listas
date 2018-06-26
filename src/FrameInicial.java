import javax.swing.JOptionPane;

public class FrameInicial extends javax.swing.JFrame {

    private static Recetas[] listas;
    private int indiceListas;
    public static FrameInicial instancia;

    public FrameInicial() {
        initComponents();
        setResizable(false);
        this.setBounds(this.getX(), this.getY(), 300,400);
        listas = new Recetas[50];
        indiceListas = 0;
        instancia = this;
        setLocationRelativeTo (null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("\"Recetas de Cocina By Viruz\"");
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jButton3.setText("Eliminar una receta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(20, 140, 182, 41);

        jButton2.setText("Consultar una receta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(20, 80, 182, 41);

        jButton1.setText("Agregar una receta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(20, 20, 180, 42);

        jButton4.setText("Modificar una receta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(20, 200, 182, 41);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(40, 80, 229, 257);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel1.setText("Sistema de listas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 30, 178, 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = JOptionPane.showInputDialog (this,"Inserte el nombre de su receta");
        
        PasosdeRecetas primerNodo = new PasosdeRecetas(null);
        PasosdeRecetas nodoAux = primerNodo;
        PasosdeRecetas otroNodo = primerNodo;
        int contador = 0;
        int respuesta = 0;
        boolean primero = true;
        do {
            String paso = JOptionPane.showInputDialog (this,"Inserte el paso "+(contador+1));
            
            if (primero) {
                primerNodo.setInfor(paso);
                primero = false;
            }else {
                otroNodo = new PasosdeRecetas (paso);
            }
            nodoAux.setLiga(otroNodo);
            nodoAux = otroNodo;
            contador++;
            respuesta = JOptionPane.showConfirmDialog(null, "¿Desea insertar otro paso?","¿Continuar?", JOptionPane.YES_NO_OPTION);
            if (respuesta != 0 && contador == 1) {
                JOptionPane.showMessageDialog(null, "Solamente se pueden ingresar recetas con 2 o mas pasos");
                respuesta = 0;
            }
        }while (respuesta == 0);
        PasosdeRecetas[] elementos = new PasosdeRecetas [contador];
        otroNodo = primerNodo;
        int i = 0;
        do {
            try {
                elementos[i] = otroNodo;
                otroNodo = otroNodo.getLiga();
                System.out.println(otroNodo.getInfor());
                i++;
            }catch (Exception e) {
                
                break;
            }
        }while (otroNodo != null);

        Recetas unaLista = new Recetas (nombre, primerNodo, elementos);
        listas[indiceListas] = unaLista;
        indiceListas++; 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        new ConsultarListas(this, true, this.listas);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new EliminarListas(this, true, this.listas);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new ModificarLista(this, true, this.listas);
    }//GEN-LAST:event_jButton4ActionPerformed

    public void setListas (Recetas[] listas) {
        this.listas = listas;
        for (int i = 0; i < listas.length; i++) {
            if (listas == null) {
                this.indiceListas =i;
                return;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}