import FileIO.PDFHelper;
import Filters.DisplayInfoFilter;
import core.DImage;
import processing.core.PImage;

import javax.swing.*;
import java.io.File;

public class OpticalMarkReaderMain {

    /* =====================================================================
    |  This will NOT display anything.  Run VisualFilterTest for that.
    |
    |  This is for batch processing ALL the pdf pages to putout csv files.
    ==================================================================== */

    public static void main(String[] args) {
        // --------- example code -------------------
        String pathToPdf = fileChooser();
        System.out.println("Loading pdf at " + pathToPdf);

        PImage in = PDFHelper.getPageImage("assets/OfficialOMRSampleDoc.pdf",1);
        DImage img = new DImage(in);       // you can make a DImage from a PImage

        System.out.println("Running filter on page 1....");

        // EXAMPLE filter that outputs information instead of displaying things
        DisplayInfoFilter filter = new DisplayInfoFilter();
        String imageinfo = filter.getInfo(img);

        System.out.println(imageinfo);
        // -----------------------------------------

        /* ===========================================
        REPLACE the above code with new code that will...
        (1).  Load the pdf
        (2).  Loop over all of its pages
        (3).  Create a DImage from each page and process its pixels
        (4).  Output 2 csv files
        ===============================================
         */

    }

    private static String fileChooser() {
        String userDirLocation = System.getProperty("user.dir");
        File userDir = new File(userDirLocation);
        JFileChooser fc = new JFileChooser(userDir);
        int returnVal = fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        return file.getAbsolutePath();
    }
}
