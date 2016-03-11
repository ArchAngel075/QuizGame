/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame;

import IO.QuizReader;
import java.util.ArrayList;
import java.util.List;
import quizgame.QuizCore.Question;
import quizgame.QuizCore.Quiz;

/**
 *
 * @author Arch
 */
public class QuizGameSingleton {
    static Quiz TheQuiz = new Quiz();
    static QuizWindow QuizWindow;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> Answers = new ArrayList<>();
        Answers.add("42");
        
        List<String> AnswersGiven = new ArrayList<>();
        AnswersGiven.add("42");
        AnswersGiven.add("What?");
        AnswersGiven.add("no");
        TheQuiz.AddQuestion( new Question (Answers, null, "YOU ARE ABSOLUTELY FUCKING RIGHT", "no", "life the universe..."));
        
        TheQuiz.AddQuestion( new Question (Answers, AnswersGiven, "yes", "no", "life the universe..."));
        TheQuiz.InitQuiz();
        TheQuiz.NextQuestion();
        // TODO code application logic here
        //QuizWindow = new QuizWindow();
        //QuizWindow.setVisible(true);
        
        //Quiz Reader debug :
        QuizReader MYReader = new QuizReader();
        MYReader.ParseFile();
        MYReader.build();
        
    }
    
}
