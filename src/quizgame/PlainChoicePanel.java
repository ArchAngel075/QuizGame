/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame;

/**
 *
 * @author Arch
 */
public class PlainChoicePanel extends javax.swing.JPanel {

    /**
     * Creates new form MultiChoicePanel
     */
    public PlainChoicePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _Question_lbl = new java.awt.Label();
        QuestionAsked_lbl = new java.awt.Label();
        AnswerInput_txtField = new java.awt.TextField();
        OK_btn = new java.awt.Button();

        _Question_lbl.setAlignment(java.awt.Label.CENTER);
        _Question_lbl.setBackground(new java.awt.Color(204, 204, 204));
        _Question_lbl.setText("Question :");

        QuestionAsked_lbl.setBackground(new java.awt.Color(204, 204, 204));
        QuestionAsked_lbl.setText("label1");

        AnswerInput_txtField.setText("");

        OK_btn.setBackground(new java.awt.Color(153, 153, 153));
        OK_btn.setForeground(new java.awt.Color(102, 102, 102));
        OK_btn.setLabel("OK");
        OK_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OK_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_Question_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QuestionAsked_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addComponent(AnswerInput_txtField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(220, 220, 220)
                    .addComponent(OK_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(220, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_Question_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(QuestionAsked_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(AnswerInput_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(169, 169, 169)
                    .addComponent(OK_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(44, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OK_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OK_btnActionPerformed
        // TODO add your handling code here:
        QuizGameSingleton.QuizWindow.GiveAnswer(AnswerInput_txtField.getText());
    }//GEN-LAST:event_OK_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField AnswerInput_txtField;
    private java.awt.Button OK_btn;
    public java.awt.Label QuestionAsked_lbl;
    private java.awt.Label _Question_lbl;
    // End of variables declaration//GEN-END:variables
}
