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
    static Quiz TheQuiz;
    public static QuizWindow QuizWindow;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Quiz Reader
        QuizReader MYReader = new QuizReader();
        MYReader.ParseFile();
        MYReader.build();
        TheQuiz = MYReader.ToQuiz();
        TheQuiz.NextQuestion();
        QuizGameSingleton.QuizWindow = new QuizWindow();
        QuizGameSingleton.QuizWindow.setVisible(true);
        
        
        
    }
    
}
