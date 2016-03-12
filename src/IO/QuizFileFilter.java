/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import Utils.Utils;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
 *
 * @author Arch
 */
public class QuizFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return false;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals("txt") || extension.equals("quiz")) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "Quiz Files";
    }
}
