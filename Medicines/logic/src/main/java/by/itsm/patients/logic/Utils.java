package by.itsm.patients.logic;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class Utils {


    public static boolean isPhone(String phone) {

        boolean ok = isNotEmptyOrNull(phone);
        return ok;
    }


    public static boolean isProductName(String productName) {
        boolean ok = isNotEmptyOrNull(productName);
        return ok;
    }

    public static boolean isNotEmptyOrNull(String productName) {

        return !(productName == null || "".equals(productName));

    }

    public static boolean isNonPositive(int id) {
        return id <= 0;
    }


    public static boolean isNotStatusId(int id) {
        return id < 0;
    }

    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {

        LocalDateTime localDate = LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault());

        return null;
    }
    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {

        LocalTime time = localDateTime.toLocalTime();

        Instant instant = time.atDate(localDateTime.toLocalDate())
                .atZone(ZoneId.systemDefault())
                .toInstant();
        return Date.from(instant);
    }

    public static String get_SHA_512_SecurePassword(String passwordToHash, String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }


}
