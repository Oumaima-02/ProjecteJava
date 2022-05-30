import javax.swing.*;
import java.sql.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame =new Formulari();
                frame.setSize(500, 700);
                frame.setVisible(true);
            }
        });




    }
}
