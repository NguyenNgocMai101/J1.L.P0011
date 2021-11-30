/**
 *
 * @Made by Nguyen Tien Trung SE161075
 */

package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Inputter {
    public static final int MAX_ELEMENT = 500;
    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty())
                System.out.println(errorMsg);
            else
                return id;
        }
    }

    public static int getYesNo(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            if (id.equalsIgnoreCase("yes") || id.equalsIgnoreCase("y"))
                return 1;
            else {
                if (id.equalsIgnoreCase("no") || id.equalsIgnoreCase("n"))
                    return -1;
                else
                    System.out.println(errorMsg);
            }
        }
    }

    public static String getDate(String inputMsg, String errorMsg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        String dateStr;
        while (true) {
            try {
                dateStr = getString(inputMsg, errorMsg);
                if (sdf.parse(dateStr).compareTo(sdf.parse("01/01/2021")) > 0)
                    return dateStr;
                else
                    System.out.println(errorMsg);
            } catch (ParseException e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int daysBetween(String d1, String d2) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            return (int) ((sdf.parse(d2).getTime() - sdf.parse(d1).getTime()) / ((24 * 60 * 60 * 1000)));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public static String getDate1(String d1) {
        String d2;
        while (true) {
            d2 = getDate("Please input the date of the second dose of injection : ", "Input invalid !");
            int n = daysBetween(d1, d2);
            if (n < 27 || n > 85) {
                System.out.println(
                        "The second dose of COVID-19 vaccination must be given from 4 to 12 weeks after the first dose of injection !");
                System.out.println("Your first dose of vaccination was given on " + d1);
            } else
                return d2;
        }
    }

    public static String getPlace(String inputMsg, String errorMsg) {
        String place;
        int check;
        String form = "HANOI|HAGIANG|CAOBANG|BACKAN|TUYENQUANG|LAOCAI|DIENBIEN|LAICHAU|SONLA|YENBAI|HOABINH|THAINGUYEN|LANGSON|"
                + "QUANGNINH|BACGIANG|PHUTHO|VINHPHUC|BACNINH|HAIDUONG|HAIPHONG|HUNGYEN|THAIBINH|HANAM|"
                + "|NAMDINH|NINHBINH|THANHHOA|NGHEAN|HATINH|QUANGBINH|QUANGTRI|THUATHIENHUE|DANANG|QUANGNAM|QUANGNGAI|BINHDINH|\"\n"
                + "PHUYEN|KHANHHOA|NINHTHUAN|BINHTHUAN|KONTUM|GIALAI|DAKLAK|DAKNONG|LAMDONG|BINHPHUOC|TAYNINH|BINHDUONG|DONGNAI|\"\n"
                + "BARIAVUNGTAU|HOCHIMINH|LONGAN|TIENGIANG|BENTRE|TRAVINH|VINHLONG|DONGTHAP|ANGIANG|KIENGIANG|CANTHO|HAUGIANG|\"\n"
                + "SOCTRANG|BACLIEU|CAMAU\"";
        do {
            place = getString(inputMsg, errorMsg);
            if (form.contains(place.toUpperCase().replaceAll("\\s", "")))
                return place.toUpperCase().replaceAll("\\s\\s+", " ");
            System.out.println("Invalid place !");
        } while (true);

    }

}
