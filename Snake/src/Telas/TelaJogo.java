/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author bruno
 */
public class TelaJogo extends javax.swing.JFrame {
    List<JLabel> cobra = new ArrayList<>();
    List<comida> comida = new ArrayList<>();
    OpcoesTela opTela = new OpcoesTela();
    cobra cb = new cobra();
    int lado = 1;
    Timer loop;

    /**
     * Creates new form TelaJogo2
     */
    public TelaJogo() {
        initComponents();
        JOptionPane.showMessageDialog(null, getSize().getHeight()+"    "+getSize().getWidth());
        setLocationRelativeTo(null);
        loop = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(cobra.size()<2){
                    criacobra();
                }
                movecobra();
                pegacomida();
                if(comida.size()<1){
                    criacomida();
                }
            }
        });
        loop.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==KeyEvent.VK_D && lado!=2){
            lado = 1;
        } else if(evt.getKeyCode()==KeyEvent.VK_A && lado!=1){
            lado = 2;
        } else if(evt.getKeyCode()==KeyEvent.VK_S && lado!=4){
            lado = 3;
        } else if(evt.getKeyCode()==KeyEvent.VK_W && lado!=3){
            lado = 4;
        }
        
    }//GEN-LAST:event_formKeyPressed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJogo().setVisible(true);
            }
        });
    }
    public void criacobra(){
        // x, y, width, height
        
        JLabel novaparte = new JLabel();
//        JOptionPane.showMessageDialog(null, cb.getRed()+" "+cb.getGreen()+" "+cb.getBlue());
        novaparte.setText("<html><body><div style=\"background-color:rgb("+cb.getRed()+", "+cb.getGreen()+", "+cb.getBlue()+"); height:10px; width:10px;\"></div></body></html>");
        if(cobra.size()>0){
            novaparte.setBounds((int) cobra.get(cobra.size()-1).getLocation().getX(), (int) cobra.get(cobra.size()-1).getLocation().getY(), 10, 10);
        }else{
            novaparte.setBounds(0, 0, 10, 10);
        }
        novaparte.requestFocus(false);
        novaparte.setVisible(true);
        cobra.add(novaparte);
        for(JLabel atual : cobra){
            jPanel1.add(atual);
        }
    }
    public void movecobra(){
        for(int t=cobra.size()-1; t>=0 ;t--){
            if(t==0){
                if(cobra.size()>2){
                    morrer();
                }
                switch(lado){
                    case 1:
                        if(cobra.get(t).getLocation().getX()+11>220){
                            cobra.get(t).setLocation(0, (int) cobra.get(t).getLocation().getY());
                        }else{
                            cobra.get(t).setLocation((int) cobra.get(t).getLocation().getX()+11, (int) cobra.get(t).getLocation().getY());
//                            JOptionPane.showMessageDialog(null, cobra.get(t).getLocation().getX());
                        }
                        break;
                    case 2:
                        if(cobra.get(t).getLocation().getX()-11<0){
                            cobra.get(t).setLocation(220, (int) cobra.get(t).getLocation().getY());
                        }else{
                            cobra.get(t).setLocation((int) cobra.get(t).getLocation().getX()-11, (int) cobra.get(t).getLocation().getY());
                        }
                        break;
                    case 3:
                        if(cobra.get(t).getLocation().getY()+11>220){
                            cobra.get(t).setLocation((int) cobra.get(t).getLocation().getX(), 0);
                        }else{
                            cobra.get(t).setLocation((int) cobra.get(t).getLocation().getX(), (int) cobra.get(t).getLocation().getY()+11);
                        }
                        break;
                    case 4:
                        if(cobra.get(t).getLocation().getY()-11<0){
                            cobra.get(t).setLocation((int) cobra.get(t).getLocation().getX(), 220);
                        }else{
                            cobra.get(t).setLocation((int) cobra.get(t).getLocation().getX(), (int) cobra.get(t).getLocation().getY()-11);
                        }
                        break;
                }
            }else{
                cobra.get(t).setLocation((int)cobra.get(t-1).getLocation().getX(), (int)cobra.get(t-1).getLocation().getY());
            }
        }
    }
    
    public void criacomida(){
        // x, y, width, height
        int x=0, y=0, i=0;
        Random gerador = new Random();
        while(i==0){
            x = 11*gerador.nextInt(20);
            y = 11*gerador.nextInt(20);
            i = verificaposicao(x, y);
        }
        comida novacomida = new comida();
        //novacomida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/comida.png")));
        novacomida.setText("<html><body><div style=\"background-color:rgb("+255+", "+0+", "+0+"); height:10px; width:10px;\"></div></body></html>");
        novacomida.setBounds(-1, -1, 10, 10);
        novacomida.requestFocus(false);
        novacomida.setVisible(true);
        comida.add(novacomida);
        for(comida atual : comida){
            jPanel1.add(atual);
            atual.setBounds(x, y, 10, 10);
        }
    }
    
    public int verificaposicao(int x, int y){
        int mudou=0;
        for(int j=0; j<cobra.size(); j++){
            if(cobra.get(j).getLocation().getX()==x && cobra.get(j).getLocation().getY()==y){
                mudou=1;
            }
        }
        if(mudou==0){
            return 1;
        }else{
            return 0;
        }
    }
    
    public void pegacomida(){
        for(comida atual : comida){
            if(atual.getLocation().getX()==cobra.get(0).getLocation().getX() && atual.getLocation().getY()==cobra.get(0).getLocation().getY()){
                comida.remove(atual);
                jPanel1.remove(atual);
                criacobra();
                break;                
            }
        }
    }
    
    public void morrer(){
        for(int t=cobra.size()-1; t>1 ;t--){
            if(cobra.get(t).getLocation().getX()==cobra.get(0).getLocation().getX() && cobra.get(t).getLocation().getY()==cobra.get(0).getLocation().getY()){
                loop.stop();
                JOptionPane.showMessageDialog(null, "Você Morreu!");
                new TelaInicial().setVisible(true);
                dispose();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
