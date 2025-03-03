package java_17.jdbc_practice.src;

import java.sql.*;

public class JdbcToDoList {

    public static void main(String[] args) throws Exception {
        final String URL = "jdbc:mysql://localhost:3306/griegLyricPieces_2";
        final String USER = "pj";
        final String PASSWORD = "passwordA1!";

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from pieces");
            int id_num;
            int op_num;
            int year_complete;
            String dedication;
            int total_pieces;

            while (resultSet.next()) {
                id_num = resultSet.getInt("id_num");
                op_num = resultSet.getInt("op_num");
                year_complete = resultSet.getInt("year_complete");
                dedication = resultSet.getString("dedication");
                total_pieces = resultSet.getInt("total_pieces");
                System.out.printf("%n\t%n\t%n\t%s\t%n\n", id_num, op_num, year_complete, dedication, total_pieces);
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}