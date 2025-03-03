// use the following command to run this file
// java -cp ".:../lib/mysql-connector-j-9.2.0.jar" GriegLyricPieces.java

package java_17.jdbc_practice.src;

import java.sql.*;

public class GriegLyricPieces {

    public static void main(String[] args) throws Exception {
        final String URL = "jdbc:mysql://localhost:3306/griegLyricPieces_2";
        final String USER = "pj";
        final String PASSWORD = "passwordA1!";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            statement = connection.createStatement();
            String select = "SELECT *";
            String from = "FROM opusInfo";
            resultSet = statement.executeQuery(
                    select + from);
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
                System.out.printf("%d\t%d\t%d\t%s\t%d\n", id_num, op_num, year_complete, dedication, total_pieces);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            resultSet.close();
            statement.close();
            connection.close();

        }
    }
}