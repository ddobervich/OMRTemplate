import FileIO.PDFHelper;
import Filters.DisplayInfoFilter;
import core.DImage;
import core.DisplayWindow;
import processing.core.PImage;

public class VisualFilterTest {
    public static String currentFolder = System.getProperty("user.dir") + "/";
    public static String pdf_filename = "OfficialOMRSampleDoc.pdf";
    public static String output_name = pdf_filename.substring(0, pdf_filename.length()-4);

    public static void main(String[] args) {
        int pageToDisplay = 1;

        // Convert pageToDisplay into a PImage
        PImage img = PDFHelper.getPageImage("assets/" + pdf_filename,pageToDisplay);

        // Save the PImage to disk
        String save_name = currentFolder + "assets/" + output_name + " page" + pageToDisplay + ".png";
        img.save(save_name);

        // Open a display window for that image
        DisplayWindow.showFor(save_name);
    }
}