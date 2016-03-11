/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Arch
 */
public class QuizWindow extends javax.swing.JFrame {

    /**
     * Creates new form QuizWindow
     */
    JPanel QPanel = null;

    public QuizWindow() {
        initComponents();
        System.out.println(GetNextQuestionAndUpdate());
    }
    
    public void GiveAnswer(String Ans){
        if(QuizGameSingleton.TheQuiz.IsCorrectAnswer(Ans)){
            OnCorrectQuestion();
        } else {
            OnWrongQuestion();
        }
        if(QuizGameSingleton.TheQuiz.HasNextQuestion()){
            QuizGameSingleton.TheQuiz.NextQuestion();
            GetNextQuestionAndUpdate();
        } else {
            JOptionPane.showMessageDialog(this, "Completed Quiz! \nGot : " + QuizGameSingleton.TheQuiz.Score + " out of " + QuizGameSingleton.TheQuiz.GetNumQuestions());
            System.exit(0);
        }
    }
    
    public void OnCorrectQuestion(){
        JOptionPane.showMessageDialog(this, QuizGameSingleton.TheQuiz.GetOnCorrectReply());
        QuizGameSingleton.TheQuiz.Score++;
    }
    
    public void OnWrongQuestion(){
       JOptionPane.showMessageDialog(this, QuizGameSingleton.TheQuiz.GetOnWrongReply()); 
    }

    public boolean GetNextQuestionAndUpdate() {
        if (QPanel != null) {
            this.remove(QPanel);
        }
        //TODO Add code that fetches Multi/Plain-choice panel here
        QPanel = GetPanel();
        if(QPanel != null){
            this.add(QPanel);
            QPanel.setBounds(0, 15, 508, 258);
            this.validate();
        }
        
        return (QPanel != null);
    }

    public JPanel GetPanel() {
        JPanel outPanel = null;
        if (IsPlainQuestion()) {
            System.out.println("is plain");
            PlainChoicePanel PlainQuestionPanel = new PlainChoicePanel();
            PlainQuestionPanel.QuestionAsked_lbl.setText(QuizGameSingleton.TheQuiz.GetQuestion());

            outPanel = PlainQuestionPanel;
        } else {
            System.out.println("is NOT plain");
            MultiChoicePanel MultiChoicePanel = new MultiChoicePanel();
            MultiChoicePanel.QuestionAsked_lbl.setText(QuizGameSingleton.TheQuiz.GetQuestion());
            for(String givenChoice : QuizGameSingleton.TheQuiz.GetMultiChoiceAnswersGiven()){
                MultiChoicePanel.AnswerChoice.add(givenChoice);
            }
            outPanel = MultiChoicePanel;
        }
        System.out.println("GetPanel() Resulted in :" + outPanel);
        return outPanel;
    }

    public boolean IsPlainQuestion() {
        return QuizGameSingleton.TheQuiz.isPlainQuestion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Score_Lbl = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Score_Lbl.setText("Score = " + QuizGameSingleton.TheQuiz.Score);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(539, Short.MAX_VALUE)
                .addComponent(Score_Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(Score_Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(426, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label Score_Lbl;
    // End of variables declaration//GEN-END:variables
}
