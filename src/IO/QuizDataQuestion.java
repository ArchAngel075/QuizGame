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
    
    public QuizDataBlock LastBlock(){
        return this.Blocks.get(this.Blocks.size()-1);
    }
}
