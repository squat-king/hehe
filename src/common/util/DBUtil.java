package common.util;

import com.attendance.bean.UserBean;

import java.util.HashMap;
import java.util.Map;


public class DBUtil {
    public static Map<String, UserBean> userMap = new HashMap<String, UserBean>();
    static {
        addUser(new UserBean("00000001","admin","123",true));

    }
    private static void addUser(UserBean user) {
        userMap.put(user.getE_NO(),user);
    }

}