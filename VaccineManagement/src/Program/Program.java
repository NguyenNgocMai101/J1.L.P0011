
package Program;

import data.InjectionList;
import util.Menu;

public class Program {
    public static void main(String[] args) {
        InjectionList list = new InjectionList();
        int choice;
        int choice1 = 0;
        Menu menu = new Menu(
                "Welcome to COVID-19 Vaccination Management System - @2021 by < Nguyen Ngoc Mai - HE153105 >");
        menu.addNewOption("1. Show the information of all students who have been injected.");
        menu.addNewOption("2. Add student's vaccine injection information.");
        menu.addNewOption("3. Update the information of student's vaccine injection.");
        menu.addNewOption("4. Delete student's vaccine injection information.");
        menu.addNewOption("5. Search for the injection information by using StudentID.");
        menu.addNewOption("6. Exit the COVID-19 Vaccine Management System.");
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.display();
                    list.saveFile();
                    break;
                case 2:
                    list.addInjection();
                    list.saveFile();
                    break;
                case 3:
                    list.update();
                    list.saveFile();
                    break;
                case 4:
                    list.remove();
                    list.saveFile();
                    break;
                case 5:
                    list.searchByStudentID();
                    break;
                case 6:
                    list.saveFile();
                    System.out.println("You have exited the Vaccination Management System !!! Have a nice day !");
                    break;
            }
        } while (choice <= 5);
    }

}
