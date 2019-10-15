package common.util;

import com.attendance.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DBUtil {
    public static Map<String, User> userMap = new HashMap<String, User>();
    static {
        addUser(new User("siki","123",10,"男",true));
        addUser(new User("123","123",10,"男",true));

    }
    private static void addUser(User user) {
        userMap.put(user.getUsername(), user);
    }

}