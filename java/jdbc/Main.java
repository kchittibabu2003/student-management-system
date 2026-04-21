package jdbc;


import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection con = DBConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Delete Student");   // ✅ added
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter Name: ");
            String name = sc.next();

            PreparedStatement ps = con.prepareStatement("INSERT INTO students(name) VALUES(?)");
            ps.setString(1, name);
            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

        } else if (choice == 2) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }

        } else if (choice == 3) {   // ✅ delete part
            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id=?");
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student ID not found!");
            }
        }
    }
}