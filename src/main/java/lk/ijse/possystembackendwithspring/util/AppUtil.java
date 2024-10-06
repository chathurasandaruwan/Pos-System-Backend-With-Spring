package lk.ijse.possystembackendwithspring.util;

import java.util.UUID;

public class AppUtil {
    public static String generateCustomerId() {
        return "C00-"+ UUID.randomUUID();
    }
    public static String generateItemId() {
        return "I00-"+ UUID.randomUUID();
    }
}
