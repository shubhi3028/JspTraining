package utils;

import java.util.UUID;

public class JspUtils {
    public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
