import cat.institutmvm.project.entities.Posidonia;
import cat.institutmvm.project.entities.Tiburon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;

public class Formulari extends JFrame {
    private JPanel form;
    private JLabel especie;
    private JLabel habitat;
    private JTextField textespecie;
    private JTextField texthab;
    private JLabel profundidad;
    private JSpinner numprofun;
    private JLabel dirviento;
    private JComboBox dir;
    private JLabel numenb;
    private JSpinner spirnumemb;
    private JLabel temp;
    private JLabel cebo;
    private JTextField texttemp;
    private JTextField textcebo;
    private JLabel sexo;
    private JComboBox gender;
    private JLabel parasito;
    private JComboBox parasit;
    private JLabel anzuelos;
    private JComboBox anz;
    private JLabel numanzuelos;
    private JSpinner numanz;
    private JButton aceptarButton;
    private JButton totalexemplars;
    private JButton profmitja;
    private JButton midamax;
    private JButton midamin;
    private JButton sortirbo;
    private JLabel tipo;
    private JTextField texttipo;


    public Formulari() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("FORMULARI");
        setContentPane(form);
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardardadestib();
                guardardadespos();

            }
        });
        sortirbo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                
            }
        });
        totalexemplars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mostraexemplars();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        profmitja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    profundidadmitja();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        midamax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    midamaxima();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        midamin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    midaminima();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    private void guardardadespos() {
        String especie = textespecie.getText();
        String habitat = texthab.getText();
        String tipo=texttipo.getText();
        posidonia = guardarposdb(especie,habitat,tipo);
    }
    public Posidonia posidonia;
    private Posidonia guardarposdb(String especie, String habitat, String tipo) {
        Tiburon tiburon =null;
        Connection conn = null;
        PreparedStatement pstatement = null;
        ResultSet rs = null;
        String server = "mysql-oumaima.alwaysdata.net";
        String bbdd = "oumaima_dbproject";
        String user = "oumaima";
        String password = "oumamvm15";
        String sql;

        try {
            conn = DriverManager.getConnection(server + bbdd, user, password);

            sql = "SELECT * FROM especiesmarinas";

            pstatement = conn.prepareStatement(sql);
            rs = pstatement.executeQuery();
            rs.close();
            pstatement.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return posidonia;

    }

 //Guardar dades del formulari per als taurons.
    private void guardardadestib() {
        String especie = textespecie.getText();
        String habitat = texthab.getText();
        String dirviento = dir.getSelectedItem().toString();
        String cebo = textcebo.getText();
        String sexo= gender.getSelectedItem().toString();
        boolean parasito= parasit.getAutoscrolls();
        boolean anzuelos= anz.getAutoscrolls();
        int numanzuelos= numanz.getComponentCount();
        String temp=texttemp.getText();
        int numemb = spirnumemb.getComponentCount();
        tiburon = guardartibdb(especie,habitat,dirviento,cebo,sexo,parasito,anzuelos,numanzuelos, Integer.parseInt(temp));
    }

    public Tiburon tiburon;
    private Tiburon guardartibdb(String especie,String habitat,String dirviento, String cebo, String sexo,boolean parasito, boolean anzuelos,int numanzuelos,int temp){
        Tiburon tiburon =null;
        Connection conn = null;
        PreparedStatement pstatement = null;
        ResultSet rs = null;
        String server = "mysql-oumaima.alwaysdata.net";
        String bbdd = "oumaima_dbproject";
        String user = "oumaima";
        String password = "oumamvm15";
        String sql;

        try {
            conn= DriverManager.getConnection(server + bbdd, user, password);

            sql = "Insert into ";

            pstatement = conn.prepareStatement(sql);
            rs = pstatement.executeQuery();

            rs.close();
            pstatement.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tiburon;

    }


    //Mostrar els exemplars totals
    private void mostraexemplars() throws SQLException {
        Connection conn = null;
        PreparedStatement pstatement = null;
        ResultSet rs = null;
        String server = "mysql-oumaima.alwaysdata.net";
        String bbdd = "oumaima_dbproject";
        String user = "oumaima";
        String password = "oumamvm15";
        String sql;

        try {
            conn = DriverManager.getConnection(server + bbdd, user, password);

            sql = "select especie, count(especie) from especiesmarinas group by especie;";
            pstatement = conn.prepareStatement(sql);
            rs = pstatement.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("Especie: %s", rs.getString(1)));
                System.out.println(String.format("Número d'exemplars: %d", rs.getInt(2)));
                System.out.println(String.format("----------------------------"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs.close();
        pstatement.close();
        conn.close();

    }


    //Mostrar la mitjana de profunditat.
    private void profundidadmitja() throws SQLException {
        Connection conn = null;
        PreparedStatement pstatement = null;
        ResultSet rs = null;
        String server = "mysql-oumaima.alwaysdata.net";
        String bbdd = "oumaima_dbproject";
        String user = "oumaima";
        String password = "oumamvm15";
        String sql;

        try {
            conn = DriverManager.getConnection(server + bbdd, user, password);

            sql = "select  avg(profundidad) from especiesmarinas;";
            pstatement = conn.prepareStatement(sql);
            rs = pstatement.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("Profunditat mitjana: %d", rs.getString(1)));
                System.out.println(String.format("----------------------------"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs.close();
        pstatement.close();
        conn.close();

    }

    //Mostrar mida maxima.

    private void midamaxima() throws SQLException {
        Connection conn = null;
        PreparedStatement pstatement = null;
        ResultSet rs = null;
        String server = "mysql-oumaima.alwaysdata.net";
        String bbdd = "oumaima_dbproject";
        String user = "oumaima";
        String password = "oumamvm15";
        String sql;

        try {
            conn = DriverManager.getConnection(server + bbdd, user, password);

            sql = "select  max(profundidad) from especiesmarinas;";
            pstatement = conn.prepareStatement(sql);
            rs = pstatement.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("Profunditat màxima: %d", rs.getString(1)));
                System.out.println(String.format("----------------------------"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs.close();
        pstatement.close();
        conn.close();
    }



    //Mostrar mida minima.

    private void midaminima() throws SQLException {
        Connection conn = null;
        PreparedStatement pstatement = null;
        ResultSet rs = null;
        String server = "mysql-oumaima.alwaysdata.net";
        String bbdd = "oumaima_dbproject";
        String user = "oumaima";
        String password = "oumamvm15";
        String sql;

        try {
            conn = DriverManager.getConnection(server + bbdd, user, password);

            sql = "select  min(profundidad) from especiesmarinas;";
            pstatement = conn.prepareStatement(sql);
            rs = pstatement.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("Profunditat mínima: %d", rs.getString(1)));
                System.out.println(String.format("----------------------------"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs.close();
        pstatement.close();
        conn.close();
    }

}

