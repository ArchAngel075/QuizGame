/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame.QuizCore;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arch
 */
public class Question {
    List<String> AnswersAccepted;
    List<String> MultiChoiceAnswersGiven;
    String CorrectReply;
    String WrongReply;
    String Question;
    

    public Question(List<String> AnswersAccepted, List<String> MultiChoiceAnswersGiven, String CorrectReply, String WrongReply, String Question) {
        this.AnswersAccepted = AnswersAccepted;
        this.MultiChoiceAnswersGiven = MultiChoiceAnswersGiven;
        this.CorrectReply = CorrectReply;
        this.WrongReply = WrongReply;
        this.Question = Question;
    }

    public List<String> getMultiChoiceAnswersGiven() {
        return MultiChoiceAnswersGiven;
    }
    
    public boolean isPlainQuestion() {
        return (MultiChoiceAnswersGiven == null);
    }
    

    public String getCorrectReply() {
        return CorrectReply;
    }

    public String getWrongReply() {
        return WrongReply;
    }

    public String getQuestion() {
        return Question;
    }

    boolean IsCorrectAnswer(String Input) {
        return (AnswersAccepted.contains(Input));
    }
}
