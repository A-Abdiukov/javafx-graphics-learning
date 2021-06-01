/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guichatapplication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Chat_Server extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chatbot server");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Chat server is running. Please do not close this window, unless you wish to terminate chat server");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static ServerSocket ss;
    private static Socket s;
    private static DataInputStream din;
    private static DataOutputStream dout;

    public Chat_Server() {
        initComponents();
    }

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
            java.util.logging.Logger.getLogger(Chat_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat_Server().setVisible(true);
            }
        });
        String msgIn = "";
        try {
            ss = new ServerSocket(3333);
            s = ss.accept();
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            while (!msgIn.equals("exit")) {
                msgIn = din.readUTF();
                jTextArea1.setText(jTextArea1.getText().trim() + "\n" + msgIn);
                Reply(msgIn);
            }

        } catch (Exception e) {

        }
    }

    private static void Reply(String msgIn) {

        try {
            dout.writeUTF(ProcessInput(msgIn));
        } catch (Exception e) {
        }
    }

    private static String ProcessInput(String msgIn) {

        //converting to lower case
        msgIn = msgIn.toLowerCase();

        if (msgIn.contains("help")) {
            return "Hello. I am a smart bot. I support the following commands : "
                    + "hello, hi, how are you?, what is going on?, what is the time?,"
                    + "what is today's date?, what's current time?, what is your name?   ";
        } else if (msgIn.contains("hi") || msgIn.contains("hello")) {
            return ("Hello There, kind person. Hope you are having a fanstastic day!");
        } else if (msgIn.contains("are you") || msgIn.contains("r u")) {
            switch ((int) (Math.random() * 2 + 1)) {
                case 1:
                    return "I'm doing well,thanks!";
                case 2:
                    return "Not too bad, handsome ;) ";
            }
        } else if ((msgIn.contains("what") || (msgIn.contains("wass")))
                && (msgIn.contains("up")
                || msgIn.contains("doing")
                || msgIn.contains("going"))) {
            return "Im just talking to u! u should know this .. lol";
        } else if (msgIn.contains("time")) {
            LocalTime now = LocalTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = now.format(myFormatObj);
            return "Here is the current time :" + formattedDate;
        } else if (msgIn.contains("date") || msgIn.contains("today")) {
            return "Today is (year-month-day) : " + LocalDate.now();
        } else if (msgIn.contains("name")) {
            return "My name is John. But my friends call me \'John the best\'. I like databases!";
        }
        return "I do not understand what you have typed. Sorry : ( . If you need assistance, type \'help\'";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
