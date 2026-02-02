/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Pejj
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();

            if (con == null) {
                JOptionPane.showMessageDialog(null, "Failed to connect to database!");
                return;
            }

            st = con.createStatement();

            // Create student table
          st.executeUpdate("CREATE TABLE IF NOT EXISTS student ("
    + "id BIGINT PRIMARY KEY, "
    + "name VARCHAR(100) NOT NULL, "
    + "gender VARCHAR(10), "
    + "strand VARCHAR(50) CHECK (strand IN ('STEM','HUMSS','ABM','TVL-ICT','TVL-AUTO','TVL-HE')), "
    + "grade VARCHAR(10), "
    + "section VARCHAR(50), "
    + "height DOUBLE NOT NULL, "
    + "weight DOUBLE NOT NULL, "
    + "classification VARCHAR(30)"
    + ")");



            System.out.println("Student table created successfully!");
            JOptionPane.showMessageDialog(null, "Student table setup complete!");

        } catch (SQLException ex) {
            System.err.println("SQL Error: " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
