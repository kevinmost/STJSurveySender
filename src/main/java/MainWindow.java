import javax.swing.*;
import java.awt.*;

/**
 * @author          kevin
 * @dateCreated     2/26/14
 */
public class MainWindow extends JFrame{

    // Metadata for this program
    public static final String APPLICATION                  =   "Survey Sender";
    public static final String AUTHOR                       =   "Kevin Most";
    public static final String VERSION                      =   "0.0.1";

    public static final String JPANEL_INFO_LABEL            =   "The following surveys have been detected within the database and need to be emailed";
    public static final String[] JPANEL_TABLE_COLUMN_LABELS =   {"Event Name", "Professor(s)", "Status"};


    // Top-level window
    public static JFrame window;

    public MainWindow() {
        // Calls the JFrame constructor and passes a title to it
        super(APPLICATION + " v" + VERSION + ". Author: " + AUTHOR);
        window = this;

        // Sets JPanel to native look-and-feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException |UnsupportedLookAndFeelException| InstantiationException | IllegalAccessException e) {
            System.err.println("Could not set system look and feel");
        }

        // Creates regular, bold, and italic fonts
        Font regularFont = UIManager.getDefaults().getFont("Label.font");
        Font boldFont = regularFont.deriveFont(Font.BOLD);
        Font italicFont = regularFont.deriveFont(Font.ITALIC);

        // Individual GUI panes
        JPanel mainPanel = new JPanel();

        // Setting individual pane layouts
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Add the info label to the panel
        mainPanel.add(new JLabel(JPANEL_INFO_LABEL));

        // Console output




        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocation(100,100);
        this.pack();
        this.setVisible(true);
        this.setResizable(true);
    }
}
