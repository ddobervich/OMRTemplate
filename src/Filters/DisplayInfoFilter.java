package Filters;

import Interfaces.PixelFilter;
import core.DImage;

import java.sql.SQLOutput;

public class DisplayInfoFilter implements PixelFilter {
    public DisplayInfoFilter() {
        System.out.println("Filter running...");
    }

    @Override
    public DImage processImage(DImage img) {
        short[][] grid = img.getBWPixelGrid();

        // NOTHING TO VIEW
        // Instead do all the filtering inside getInfo so we can return a String

        return img;
    }

    // You can do all the image filtering here.  Instead of returning a Dimage
    // output a String with the information you care about.
    public String getInfo(DImage img) {
        short[][] grid = img.getBWPixelGrid();

        String output = "";
        output += "Image is " + grid.length + " by "+ grid[0].length;

        int blackCount = 0;
        int whiteCount = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] < 10) blackCount++;
                if (grid[r][c] > 240) whiteCount++;
            }
        }

        output += " with " + blackCount + " nearly black pixels and " + whiteCount + " nearly white pixels\n";
        output += "----------------------------------------\n";
        output += "If you want, you could output information to a file instead of printing it.\n";

        return output;
    }
}

