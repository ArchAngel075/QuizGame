/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
            //System.out.println(ReadOut);
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
        System.out.println("buildDataBlocks()");
        //System.out.println(ReadOut);
        System.out.println();

        boolean isBuilding = true;
        int index = -1;

        boolean isBuildingQuestion = false;
        boolean isBuilingBlock = false;

        List<QuizDataQuestion> Questions = new ArrayList<>();
        String NextCharacter = null;
        System.out.println("length :" + ReadOut.length());
        while (isBuilding) {
            index++;
            //System.out.println("index :" + index);
            if (index == ReadOut.length()) {
                isBuilding = false;
                System.out.println("DONE BUILDING!");
            } else {
                NextCharacter = ReadOut.substring(index, index + 1);
                if (!"\n".equals(NextCharacter)) {
                    System.out.println("NextCharacter :" + NextCharacter);
                }
            }

            if ("{".equals(NextCharacter) && !isBuildingQuestion) {
                isBuildingQuestion = true;
                Questions.add(new QuizDataQuestion());
                Questions.get(Questions.size() - 1).indexStarts = index;
                System.out.println();
                System.out.println("Build Question");
                System.out.println();
            } else if ("{".equals(NextCharacter) && isBuildingQuestion && !isBuilingBlock) {
                isBuilingBlock = true;

                QuizDataBlock Qblock = new QuizDataBlock();
                
                //iterate backwards until we get the name of variable :
                boolean isBuildingVariableName = true;
                int iindex = index-1;
                while(isBuildingVariableName == true){
                   iindex--; 
                   String substr = ReadOut.substring(iindex, iindex +1);
                   if(iindex == 0 || "\n".equals(substr) || substr.isEmpty() || java.lang.Character.isWhitespace(substr.charAt(0))){
                       Qblock.BlockName = ReadOut.substring(iindex + 1 , index - 1);
                       System.out.println();
                       Qblock.indexStarts = iindex+1;
                       isBuildingVariableName = false;
                   }
                }
                Questions.get(Questions.size() - 1).Blocks.add(Qblock);
                System.out.println();
                System.out.println("Build Block");
                System.out.println();
            } else if ("}".equals(NextCharacter) && isBuildingQuestion && !isBuilingBlock) {
                Questions.get(Questions.size() - 1).indexEnds = index;
                Questions.get(Questions.size() - 1).data = ReadOut.substring(
                        Questions.get(Questions.size() - 1).indexStarts,
                        Questions.get(Questions.size() - 1).indexEnds+1);
                isBuildingQuestion = false;
                System.out.println();
                System.out.println("QUIZ DATA:");
                System.out.println(Questions.get(Questions.size() - 1).data);
                System.out.println("--------------------------------");
                System.out.println();
            } else if ("}".equals(NextCharacter) && isBuildingQuestion && isBuilingBlock) {
                Questions.get(Questions.size() - 1).LastBlock().indexEnds = index;
                Questions.get(Questions.size() - 1).LastBlock().data = ReadOut.substring(
                        Questions.get(Questions.size() - 1).LastBlock().indexStarts,
                        Questions.get(Questions.size() - 1).LastBlock().indexEnds+1);
                isBuilingBlock = false;
                System.out.println();
                System.out.println("BLOCK DATA:");
                System.out.println(Questions.get(Questions.size() - 1).LastBlock().data);
                System.out.println("--------------------------------");
                System.out.println();
            }

        }
        //find a potential open block :

    }

}
