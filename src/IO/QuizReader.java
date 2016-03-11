/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import quizgame.QuizCore.Question;
import quizgame.QuizCore.Quiz;

/**
 *
 * @author Arch
 *
 * Reads a text file and imports all questions.
 */
public class QuizReader {

    public String ReadOut = null;
    public String QuizFileName;
    List<String> DataBlocks = new ArrayList<>();
    List<QuizDataQuestion> Questions;

    public void ParseFile() {
        // The name of the file to open.
        QuizFileName = "myQuiz.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files.
            FileReader fileReader
                    = new FileReader(QuizFileName);

            // wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                if (ReadOut == null) {
                    ReadOut = line;
                } else {
                    ReadOut += "\n" + line;
                }
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + QuizFileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + QuizFileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

    public int GetClosingBracket(String str, int closedIndex) {
        int countOpenBrackets = 0;
        int indexOpenBracket = -1;
        int currentIndexFrom = 0;
        boolean isSearching = true;
        while (isSearching && (indexOpenBracket = str.indexOf("{", currentIndexFrom)) > -1) {
            currentIndexFrom = indexOpenBracket + 1;
            countOpenBrackets++;
            if (closedIndex == countOpenBrackets) {
                isSearching = false;
            }
        }
        return indexOpenBracket;
    }

    public void build() {
        boolean isBuilding = true;
        int index = -1;

        boolean isBuildingQuestion = false;
        int IndexOfQuestionStart = -1;
        boolean isBuilingBlock = false;

        Questions = new ArrayList<>();
        String NextCharacter = null;
        while (isBuilding) {
            index++;
            if (index == ReadOut.length()) {
                isBuilding = false;
                break;
            } else {
                NextCharacter = ReadOut.substring(index, index + 1);
            }

            if ("{".equals(NextCharacter) && !isBuildingQuestion) {
                isBuildingQuestion = true;
                IndexOfQuestionStart = index;
                //non bundled data :
                int indexCorrectReplyStart = ReadOut.indexOf("CorrectReply='",IndexOfQuestionStart)+"CorrectReply='".length();
                String CorrectReply = ReadOut.substring(indexCorrectReplyStart,ReadOut.indexOf("'",indexCorrectReplyStart));
                
                int indexWrongReplyStart = ReadOut.indexOf("WrongReply='",IndexOfQuestionStart)+"WrongReply='".length();
                String WrongReply = ReadOut.substring(indexWrongReplyStart,ReadOut.indexOf("'",indexWrongReplyStart));
                
                int indexQuestionStart = ReadOut.indexOf("Question='",IndexOfQuestionStart)+"Question='".length();
                String Question = ReadOut.substring(indexQuestionStart,ReadOut.indexOf("'",indexQuestionStart));
                Questions.add(new QuizDataQuestion());
                Questions.get(Questions.size() - 1).CorrectReply = CorrectReply;
                Questions.get(Questions.size() - 1).WrongReply = WrongReply;
                Questions.get(Questions.size() - 1).Question = Question;
                Questions.get(Questions.size() - 1).indexStarts = index;
            } else if ("{".equals(NextCharacter) && isBuildingQuestion && !isBuilingBlock) {
                isBuilingBlock = true;

                QuizDataBlock Qblock = new QuizDataBlock();
                
                //iterate backwards until we get the name of variable :
                boolean isBuildingVariableName = true;
                int iindex = index-1;
                while(isBuildingVariableName){
                   iindex--; 
                   String substr = ReadOut.substring(iindex, iindex +1);
                   if(iindex == 0 || "\n".equals(substr) || substr.isEmpty() || java.lang.Character.isWhitespace(substr.charAt(0))){
                       Qblock.BlockName = ReadOut.substring(iindex + 1 , index - 1);
                       Qblock.indexStarts = iindex+1;
                       isBuildingVariableName = false;
                   }
                }
                Questions.get(Questions.size() - 1).Blocks.add(Qblock);
            } else if ("}".equals(NextCharacter) && isBuildingQuestion && !isBuilingBlock) {
                Questions.get(Questions.size() - 1).indexEnds = index;
                Questions.get(Questions.size() - 1).data = ReadOut.substring(
                        Questions.get(Questions.size() - 1).indexStarts,
                        Questions.get(Questions.size() - 1).indexEnds+1);
                isBuildingQuestion = false;
            } else if ("}".equals(NextCharacter) && isBuildingQuestion && isBuilingBlock) {
                Questions.get(Questions.size() - 1).LastBlock().indexEnds = index;
                Questions.get(Questions.size() - 1).LastBlock().data = ReadOut.substring(
                        Questions.get(Questions.size() - 1).LastBlock().indexStarts,
                        Questions.get(Questions.size() - 1).LastBlock().indexEnds+1);
                isBuilingBlock = false;
            }
            
        }
        for(QuizDataQuestion Question : Questions){
            for(QuizDataBlock Block : Question.Blocks){
                Block.parse();
            }    
        }
    }
    
    public Quiz ToQuiz(){
//        
        Quiz TheQuiz = new Quiz();
        
        for(QuizDataQuestion Question : Questions){
            TheQuiz.AddQuestion( new Question (Question.getAnswersAcceptedProperty(), Question.getMultiChoiceAnswersGivenProperty(), Question.CorrectReply, Question.WrongReply, Question.Question));
        }
        TheQuiz.InitQuiz();
        return TheQuiz;
    }

}
