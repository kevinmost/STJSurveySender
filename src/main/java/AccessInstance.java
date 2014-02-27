import com.healthmarketscience.jackcess.*;
import org.apache.commons.configuration.XMLConfiguration;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kevin
 * @dateCreated 2/26/14
 */
public class AccessInstance {
    Database database;

    // Professor name/email data
    Table emailTable;
    Map<String, String> emailMap = new HashMap<>(); // Key == Prof Full Name, Value == Prof Email

    Table surveyTable;
    List<List<String>> surveyList = new ArrayList<>();


    public AccessInstance(XMLConfiguration configuration) {
        // Open the Access database and the tables we need
        try {
            database = DatabaseBuilder.open(new File(configuration.getString("access.metadata.filename")));
            emailTable = database.getTable(configuration.getString("access.metadata.email-table"));
            surveyTable = database.getTable(configuration.getString("access.metadata.survey-table"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: Can't open Access database. Please close any instances you may have open and re-run this program", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Populate the map that contains the professor names and emails
        for (Row row : emailTable) {
            emailMap.put(
                    row.get("Prof Full Name").toString(),
                    row.get("Prof Email").toString()
            );
        }

        // Check each row in the Survey table
        for (Row row : surveyTable) {
            // The current row we are adding to the List
            List<String> currentRow = new ArrayList<>();

            // If the row is not yet emailed, then we add it to our Lists
            if (!(Boolean)row.get("Emailed")) {

                surveyList.add(currentRow);
            }
        }
    }
}
