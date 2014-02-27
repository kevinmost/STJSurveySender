import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import javax.swing.*;
import java.io.File;

/**
 * @author          kevin
 * @dateCreated     2/26/14
 */
public class SurveySender {


    // The configuration file that holds all of our metadata
    static XMLConfiguration configuration;

    public static void main(String[] args) {
        // Initialize the XML configuration
        initializeConfiguration();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //

                // Display the window
                new MainWindow();
            }
        });
    }

    public static void initializeConfiguration() {
        try {
            configuration = new XMLConfiguration(new File("SurveySender.config"));
        } catch (ConfigurationException e) {
            JOptionPane.showMessageDialog(null, "SurveySender.config is either missing or malformed. Please restore this file before using this utility.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    public static XMLConfiguration getConfiguration() {
        return configuration;
    }
}