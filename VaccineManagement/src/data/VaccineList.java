package data;

import java.io.FileWriter;
import java.util.ArrayList;
import util.FileDAO;
import util.Inputter;
import util.Menu;

public class VaccineList implements List {
    ArrayList<Vaccine> list = new ArrayList();

    public VaccineList() {
        this.readFile();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public String menuVaccine() {
        while (true) {
            Menu menu = new Menu("Choice of the vaccine id :");
            for (int i = 0; i < list.size(); i++) {
                menu.addNewOption((i + 1) + ". " + list.get(i).toString2());
            }
            menu.printMenu();
            int choice = menu.getChoice();
            for (int i = 0; i < list.size(); i++) {
                if ((choice - 1) == i)
                    return list.get(i).getvID();
            }
        }
    }

    public void displayAVaccine(String id) {
        for (Vaccine vaccine : list) {
            if (vaccine.getvID().equalsIgnoreCase(id))
                vaccine.output();
        }
    }

    @Override
    public void display() {
        if (list.isEmpty()) {
            System.out.println("The vaccine list is empty !");
            return;
        }
        for (int i = 0; i < 33; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("|%-10s|%-20s|\n", "VACCINE ID", "VACCINE NAME");
        for (Vaccine vaccine : list) {
            vaccine.output();
            System.out.println();
        }
        for (int i = 0; i < 33; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void readFile() {
        list = FileDAO.readFileVaccine("vaccine.txt");
    }

}
