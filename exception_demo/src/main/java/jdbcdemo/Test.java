package jdbcdemo;

import java.sql.*;


/**
 * 事务的基本用法
 */
public class Test {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.5.12:3306/demodb", "root", "root123");

            conn.setAutoCommit(false); //JDBC中默认是true，自动提交事务</span>

            ps1 = conn.prepareStatement("insert into article (id,title) values (?,?)");//?是占位符
            ps1.setObject(1, 123);
            ps1.setObject(2, "gaibian111");
            ps1.execute();
            System.out.println("插入一个用户张三");

            ps2 = conn.prepareStatement("select * from article");
            ResultSet resultSet = ps2.executeQuery("select * from article");
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
            }

            System.out.println("插入一个用户李四");

            conn.commit();//提交事务
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                conn.rollback();//某一条数据添加失败时，回滚</span>
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps1 != null) {
                    ps1.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
