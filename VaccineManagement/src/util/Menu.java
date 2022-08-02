package util;

import java.util.ArrayList;
import util.Inputter;

public class Menu {
    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public void addNewOption(String newOption) {
        if (optionList.equals(newOption))
            System.out.println("Can not add this option !");
        else
            optionList.add(newOption);

    }

    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There is no item in the menu !");
            return;
        }
        for (int i = 0; i < 50; i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.println(menuTitle);
        for (String x : optionList)
            System.out.println(x);
        for (int i = 0; i < 50; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public int getChoice() {
        int maxOption = optionList.size();
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg = "You are required to choose the option 1.." + maxOption;
        return Inputter.getAnInteger(inputMsg, errorMsg, 1, maxOption);
    }

}
