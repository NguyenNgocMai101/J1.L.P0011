/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

public class Injection {
    private String InjectionID;
    private String studentID;
    private String firstPlace, firstDate;
    private String secondPlace, secondDate;
    private String vaccineID;

    public Injection(String InjectionID, String studentID, String firstPlace, String firstDate, String secondPlace,
            String secondDate, String vaccineID) {
        this.InjectionID = InjectionID;
        this.studentID = studentID;
        this.firstPlace = firstPlace;
        this.firstDate = firstDate;
        this.secondPlace = secondPlace;
        this.secondDate = secondDate;
        this.vaccineID = vaccineID;
    }

    public String getInjectionID() {
        return InjectionID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFirstPlace() {
        return firstPlace;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public String getSecondPlace() {
        return secondPlace;
    }

    public String getSecondDate() {
        return secondDate;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setFirstPlace(String firstPlace) {
        this.firstPlace = firstPlace;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public void setSecondPlace(String secondPlace) {
        this.secondPlace = secondPlace;
    }

    public void setSecondDate(String secondDate) {
        this.secondDate = secondDate;
    }

    @Override
    public String toString() {
        return String.format("%-10s|%-10s|%-15s|%-10s|%-15s|%-10s|%-10s|\n", InjectionID, studentID, firstPlace,
                firstDate, secondPlace, secondDate, vaccineID);
    }

    public void output1() {
        System.out.printf("|%-10s", InjectionID);
    }

    public void output2() {
        System.out.printf("%-15s|%-10s|%-15s|%-10s", firstPlace, firstDate, secondPlace, secondDate);
    }

}
