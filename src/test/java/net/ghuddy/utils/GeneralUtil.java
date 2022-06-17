package net.ghuddy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GeneralUtil {
    public static String getNationalId() {
        String nationalId = "";
        nationalId = "19711072" + (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        if (nationalId.length() > 17) {
            nationalId = nationalId.substring(0, 17);
        }

        return nationalId;
    }

    public static String getTinNumber() {
        String tinNumber = "";
        tinNumber = "197" + (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        if (tinNumber.length() > 12) {
            tinNumber = tinNumber.substring(0, 12);
        }

        return tinNumber;
    }

    public static String getPassportNo() {
        String passportNo = "";
        passportNo = "A2" + (long) Math.floor(Math.random() * 9_000_000L) + 1_000_000L;
        if (passportNo.length() > 9) {
            passportNo = passportNo.substring(0, 9);
        }

        return passportNo;
    }

    public static String getSmartCardId() {
        String smartCardId = "";
        smartCardId = "197" + (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        if (smartCardId.length() > 10) {
            smartCardId = smartCardId.substring(0, 10);
        }

        return smartCardId;
    }


    public static int getRandomNumber(int max) {
        return 1 + (int) (Math.random() * ((max - 1) + 1));
    }

    public static String getRandomNumber(long max, long min) {
        return String.valueOf(min + (long) (Math.random() * ((max - min) + 1)));
    }

    public static String getBirthYear(int min, int max) {
        return String.valueOf(min + (int) (Math.random() * ((max - min) + 1)));
    }

    public static String getAssetID() {
        return "FA" + new Random().nextInt(1000);
    }

    public static String getMobileNumber() {
        int num1, num2, num3; //3 numbers in operator code
        int lastSixDigit;
        Random generator = new Random();
        //Operator code number; Will not print 8 or 9
        num2 = generator.nextInt(9); //randomize to 8 becuase 0 counts as a number in the generator
        num3 = generator.nextInt(9);

        lastSixDigit = generator.nextInt(99999999) + 10000000;
        String mobileNumber = "";
        mobileNumber = "017" + num2 + "" + num3 + "" + lastSixDigit;
        if (mobileNumber.length() > 11) {
            mobileNumber = mobileNumber.substring(0, 11);
        } else if (mobileNumber.length() < 11) {
            mobileNumber = "01911" + (long) Math.floor(Math.random() * 9_000_000L) + 1_000_000L;
            if (mobileNumber.length() > 11) {
                mobileNumber = mobileNumber.substring(0, 11);
            }
        }

        return mobileNumber;
    }

    public static Double getInstallmentAmount(Double amount) {
        return (amount * 0.054);
    }


    public static String getFutureDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, days);  // number of days to add
        return sdf.format(c.getTime());
    }

    public static String getPastDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, -days);  // number of days to add
        return sdf.format(c.getTime());
    }

    public static String getSaltString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public static <T extends Enum<?>> T getRandomEnum(Class<T> clazz) {
        return clazz.getEnumConstants()[new Random().nextInt(clazz.getEnumConstants().length)];
    }

    public static <T extends Comparable<T>> T getRandomListItem(List<T> clazz) {
        return clazz.get(new Random().nextInt(clazz.size()));
    }

    public static void main(String[] args) throws ParseException {

        String businessDate = DatabaseUtil.getOfficeWideBusinessDate("1134");
//        LocalDateTime datetime = LocalDateTime.parse(businessDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(businessDate);
        String newstring = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println(newstring); // 2011-01-18
        System.out.println("National Id " + GeneralUtil.getNationalId().length());
    }
}
