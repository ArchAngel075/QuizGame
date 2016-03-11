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
    List<String> ParsedData;
    public boolean isParsed = false;
    
    
    public void parse(){
        boolean isParsing = true;
        boolean isBuildingVariable = false;
        int index = -1;
        int startIndex = -1;
        String NextCharacter = null;
        
        while (isParsing) {
            index++;
            if (index == data.length()) {
                isParsing = false;
                break;
            } else {
                NextCharacter = data.substring(index, index + 1);
            }
            if ("'".equals(NextCharacter) && !isBuildingVariable) {
                isBuildingVariable = true;
                startIndex = index+1;
            } else if("'".equals(NextCharacter) && isBuildingVariable) {
                isBuildingVariable = false;
                String substr = data.substring(startIndex,index);
                if(ParsedData == null){
                    ParsedData = new ArrayList<>();
                }
                ParsedData.add(substr);
            }
        }
        isParsed = true;
    }
}
