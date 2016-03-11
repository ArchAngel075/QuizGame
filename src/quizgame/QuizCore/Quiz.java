/*

 */
package quizgame.QuizCore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import quizgame.QuizGameSingleton;
import quizgame.QuizWindow;

/**
 *
 * @author Jaco Kotzé
 */
public class Quiz {
  public int Score = 0;
  List<Question> Questions = new ArrayList<>();
  Iterator<Question> QuestionIterator;
  Question CurrentQuestion;
  
  
  
  public boolean isPlainQuestion(){
      return (CurrentQuestion.isPlainQuestion());
  }
  
  public int GetNumQuestions(){
      return Questions.size();
  }
  
  public void AddQuestion(Question Que){
      Questions.add(Que);
  }
  
  public boolean HasNextQuestion(){
      return QuestionIterator.hasNext();
  }
  
  public Question NextQuestion(){
      return (CurrentQuestion = QuestionIterator.next());
  }
  
  public boolean IsCorrectAnswer(String Input){
      return (CurrentQuestion.IsCorrectAnswer(Input));
  }
  
  public String GetOnCorrectReply(){
      return (CurrentQuestion.getCorrectReply());
  }
  
  public String GetOnWrongReply(){
      return (CurrentQuestion.getWrongReply());
  }
  
  public String GetQuestion(){
      return (CurrentQuestion.getQuestion());
  }
  
  public List<String> GetMultiChoiceAnswersGiven(){
      return (CurrentQuestion.getMultiChoiceAnswersGiven());
  }

    public void InitQuiz() {
        QuestionIterator = Questions.iterator();
    }
  
}
