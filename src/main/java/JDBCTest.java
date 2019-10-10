import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {
    public static void main (String[] args)  throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ssmdemo";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
            String sql = "select * from tb_user where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("user_name"));
                System.out.println(resultSet.getString("password"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getInt("age"));
                System.out.println(resultSet.getInt("sex"));
                System.out.println(resultSet.getDate("birthday"));
            }
        } finally {
            if (resultSet!=null){
                resultSet.close();
            }
            if (preparedStatement!=null){
                preparedStatement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
    }
}
