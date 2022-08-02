package data;

import java.io.FileWriter;
import java.util.ArrayList;
import util.FileDAO;
import util.Inputter;

public class InjectionList implements List {
    StudentList studentList = new StudentList();
    VaccineList vaccineList = new VaccineList();
    ArrayList<Injection> injectionList = new ArrayList();

    public InjectionList() {
        readFile();
    }

    public void addInjection() {
        String injectionId, fPlace, fDate;
        String sID, vID;
        int pos, pos1;
        int check;
        do {
            do {
                injectionId = Inputter.getString("Please input the injection id : ", "Input invalid !");
                pos = searchID(injectionId);
                if (pos != -1)
                    System.out.println("This injection id has already existed !!");
            } while (pos != -1);
            do {
                sID = studentList.menuStudent();
                pos1 = searchIDStudent(sID);
                if (pos1 != -1)
                    System.out.println("This student has already existed !!");
            } while (pos1 != -1);
            fPlace = Inputter.getPlace("Please input the place of the first injection : ", "Input invalid !");
            fDate = Inputter.getDate("Please input the date of the first injection : ", "Input invalid !");
            vID = vaccineList.menuVaccine();
            injectionList.add(new Injection(injectionId, sID, fPlace, fDate, "null", "null", vID));
            check = Inputter.getYesNo("Do you want to input another injection ? (Yes/No) ",
                    "Please enter Yes/No or Y/N!");
        } while (check == 1);
    }

    public void update() {
        int pos;
        String id;
        if (injectionList.isEmpty()) {
            System.out.println("The injection list is empty. Nothing to update here !");
            return;
        }
        do {
            id = Inputter.getString("Please input the injection id you want to update : ", "Input invalid !");
            pos = searchID(id);
            if (pos == -1)
                System.out.println("The injection has not existed yet !");
        } while (pos == -1);
        if (search(id).getSecondDate().equals("null") && search(id).getSecondPlace().equals("null")) {
            search(id).setSecondPlace(
                    Inputter.getPlace("Please input the place of the second dose of injection : ", "Input invalid !"));
            search(id).setSecondDate(Inputter.getDate1(search(id).getFirstDate()));
            System.out.println("Update the details successfully!");
        } else {
            System.out.println("Student has completed 2 doses of injection !");
        }
    }

    public void infoAInjection(String id) {
        search(id).output1();
        studentList.displayAStudent(search(id).getStudentID());
        search(id).output2();
        vaccineList.displayAVaccine(search(id).getVaccineID());
        System.out.println();
    }

    public void remove() {
        if (injectionList.isEmpty()) {
            System.out.println("The injection list is empty. Nothing to remove !");
            return;
        }
        int check;
        String id = Inputter.getString("Please input the injection id you want to remove : ", "Input invalid!");
        if (searchID(id) == -1)
            System.out.println("The injection has not existed yet !");
        else {
            System.out.println("The injection you want to remove : ");
            infoAInjection(id);
            check = Inputter.getYesNo("Do you want to delete it immediately ?(Yes/No)", "Please enter Yes/No or Y/N!");
            if (check == 1) {
                injectionList.remove(search(id));
                System.out.println("You have removed it successfully !");
            } else {
                System.out.println("Removal has failed !");
            }
        }

    }

    public void searchByStudentID() {
        String id = Inputter.getString("Please input the student's ID : ", "Input invalid !");
        for (Injection injection : injectionList) {
            if (injection.getStudentID().equalsIgnoreCase(id)) {
                infoAInjection(injection.getInjectionID());
                return;
            }
        }
        System.out.println("The student has not been vaccinated. Not found in the list.");
    }

    public Injection search(String id) {
        for (Injection injection : injectionList) {
            if (injection.getInjectionID().equalsIgnoreCase(id))
                return injection;
        }
        return null;
    }

    public int searchID(String id) {
        for (int i = 0; i < injectionList.size(); i++) {
            if (injectionList.get(i).getInjectionID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public int searchIDStudent(String id) {
        for (int i = 0; i < injectionList.size(); i++) {
            if (injectionList.get(i).getStudentID().equalsIgnoreCase(id.replaceAll("\\s\\s+", " "))) {
                return i;
            }
        }
        return -1;
    }

    public void saveFile() {
        try {
            FileWriter fw = new FileWriter("injection.txt");
            fw.write(String.format("%-10s|%-10s|%-15s|%-10s|%-15s|%-10s|%-10s|\n", "ID", "STUDENT_ID", "1ST_PLACE",
                    "1ST_DATE", "2ND_PLACE", "2ND_DATE", "VACCINE_ID"));
            for (Injection in : injectionList) {
                fw.write(in.toString());
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isEmpty() {
        return (studentList.isEmpty() || vaccineList.isEmpty());
    }

    @Override
    public void display() {
        if (injectionList.isEmpty()) {
            System.out.println("The injection list is empty !");
            return;
        }
        int check = 0;
        for (Injection injection : injectionList) {
            if (studentList.search(injection.getStudentID()) != null) {
                check++;
            }
        }
        if (check != 0) {
            for (int i = 0; i < 125; i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.printf("|%-10s|%-10s|%-20s|%-15s|%-10s|%-15s|%-10s|%-10s|%-15s|\n", "ID", "STUDENT_ID",
                    "STUDENT_NAME", "1ST_PLACE", "1ST_DATE", "2ND_PLACE", "2ND_DATE", "VACCINE_ID", "VACCINE_NAME");
            for (int i = 0; i < 125; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        for (Injection injection : injectionList) {
            if (studentList.search(injection.getStudentID()) != null) {
                injection.output1();
                studentList.displayAStudent(injection.getStudentID());
                injection.output2();
                vaccineList.displayAVaccine(injection.getVaccineID());
                System.out.println();
            }
        }
        if (check != 0) {
            for (int i = 0; i < 125; i++) {
                System.out.print("-");
            }
            System.out.println();
        } else {
            System.out.println("The injection list is empty !");
            injectionList.clear();
        }
    }

    @Override
    public void readFile() {
        if (!isEmpty())
            injectionList = FileDAO.readFileInjection("injection.txt");
    }

}
