import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 * @dateCreated 2/27/14
 */
public class ExcelInstance {
    // Template file
    Workbook template;
    Sheet templateSheet;

    // Mapping for excel cells to Access columns
    Map<Integer[], Integer> templateMap = new HashMap<>(); // Key == {excelRow, excelColumn}. Value == accessColumn

    public ExcelInstance() {
        // Initialize the template file
        try {
            template = Workbook.getWorkbook(new File(""));
            templateSheet = template.getSheet(0);
        } catch (IOException | BiffException e) {
            JOptionPane.showMessageDialog(null, "Excel template file is either malformed or missing, please verify its integrity", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Init
        String currentCell;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                currentCell = templateSheet.getCell(i,j).getContents();
                if (currentCell.matches("\\${\\d{1,}}")) { // TODO: Proper regex

                }
            }
        }
    }


}
