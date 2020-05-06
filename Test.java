import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test<dataSource> {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();        ///先声明一个对象，程序集的
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/test2?" +
                "characterEncoding=utf8&&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("bk0467BKR");
        Connection connection = dataSource.getConnection();     //建立连接
//        String sql= "insert into account values('陈董'，1000000000)";
        String sql= "insert into account values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);  //辅助拼装
        statement.setString(1,"陈董");
        statement.setInt(2,200000000);
        System.out.println(statement);
         int ret=  statement.executeUpdate();
        System.out.println(ret);
        statement.close();
        connection.close();
    }
}
