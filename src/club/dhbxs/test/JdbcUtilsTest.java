package club.dhbxs.test;

import club.dhbxs.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author ：zhao-v
 * @date ：Created in 2020/6/27 下午 4:18
 * @description：
 * @version: 1.0
 */
public class JdbcUtilsTest {
    @Test
    public void testJducUtils() {
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.closeConnection(connection);
        }
    }
}
