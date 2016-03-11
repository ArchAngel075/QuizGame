/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arch
 */
public class QuizDataQuestion {
    public String data;
    public int indexStarts;
    public int indexEnds;
    public List<QuizDataBlock> Blocks = new ArrayList<>();
    public String CorrectReply;
    public String WrongReply;
    public String Question;
    
    public QuizDataBlock LastBlock(){
        return this.Blocks.get(this.Blocks.size()-1);
    }

    public List<String> getAnswersAcceptedProperty(){
        List<String> out = null;
        for(QuizDataBlock Block : Blocks){
            if("AnswersAccepted".equals(Block.BlockName)){
                out = (Block.ParsedData);
            }
        }
        return out;
    }
    
    public List<String> getMultiChoiceAnswersGivenProperty(){
        List<String> out = null;
        for(QuizDataBlock Block : Blocks){
            if("MultiChoiceAnswersGiven".equals(Block.BlockName)){
                out = (Block.ParsedData);
            }
        }
        return out;
    }
}
