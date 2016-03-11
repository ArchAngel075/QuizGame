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
public class QuizDataBlock {
    public String data;
    public String BlockName;
    public int indexStarts;
    public int indexEnds;
    List<String> ParsedData = new ArrayList<>();
    public boolean isParsed = false;
    
    
    public void parse(){
        boolean isParsing = true;
        boolean isBuildingVariable = false;
        int index = -1;
        String NextCharacter = null;
        System.out.println("length :" + data.length());
        
        while (isBuilding) {
            index++;
            //System.out.println("index :" + index);
            if (index == data.length()) {
                isBuilding = false;
                System.out.println("DONE BUILDING!");
            } else {
                NextCharacter = ReadOut.substring(index, index + 1);
                if (!"\n".equals(NextCharacter)) {
                    System.out.println("NextCharacter :" + NextCharacter);
                }
            }
            //TODO write code to act on the current sub character
        }
        
    }
    
}
