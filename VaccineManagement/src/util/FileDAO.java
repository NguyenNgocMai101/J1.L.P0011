/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import data.Injection;
import data.Student;
import data.Vaccine;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileDAO {
    public static ArrayList<Vaccine> readFileVaccine(String fileName) {
        ArrayList<Vaccine> vc = new ArrayList<>();
        FileReader f = null;
        BufferedReader r = null;
        String line = "";
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                return null;
            }
            f = new FileReader(file);
            r = new BufferedReader(f);
            while (true) {
                line = r.readLine();
                if (line == null)
                    break;
                String[] arr = line.split(";");
                vc.add(new Vaccine(arr[0], arr[1]));
            }
            f.close();
            r.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return vc;
    }

    public static ArrayList<Student> readFileStudent(String fileName) {
        ArrayList<Student> st = new ArrayList<>();
        FileReader fr = null;
        BufferedReader r = null;
        String line = "";
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                return null;
            }
            fr = new FileReader(file);
            r = new BufferedReader(fr);
            while (true) {
                line = r.readLine();
                if (line == null)
                    break;
                String[] arr = line.split(";");

                st.add(new Student(arr[0], arr[1]));
            }
            fr.close();
            r.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return st;
    }

    public static ArrayList<Injection> readFileInjection(String fileName) {
        ArrayList<Injection> inj = new ArrayList<>();
        FileReader f = null;
        BufferedReader r = null;
        String line = "";
        try {
            f = new FileReader(fileName);
            r = new BufferedReader(f);
            line = r.readLine();
            while (true) {
                line = r.readLine();
                if (line == null)
                    break;
                String[] arr = line.split("[|]");
                inj.add(new Injection(arr[0].trim(), arr[1].trim(), arr[2].trim(), arr[3].trim(), arr[4].trim(),
                        arr[5].trim(), arr[6].trim()));

            }
            f.close();
            r.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return inj;
    }

}
