package lk.ijse.possystembackendwithspring.util;

import java.util.UUID;

public class AppUtil {
    public static String generateCustomerId() {
        return "CID-"+ UUID.randomUUID();
    }
    public static String generateItemId() {
        return "IID-"+ UUID.randomUUID();
    }
    public static String generateOrderId() {
        return "OID-"+ UUID.randomUUID();
    }
}
