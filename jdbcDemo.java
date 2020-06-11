package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
jdbc快速入门
 */
public class jdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        /*
        这下面的代码和注册驱动的代码作用是一致的
        com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(driver);
        */
        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1","root","13254");
        //4.定义sql语句
        String sql = "update stu set sname='wjn' where age = 5";
        //5.获取执行sql对象 Statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();
    }
}
