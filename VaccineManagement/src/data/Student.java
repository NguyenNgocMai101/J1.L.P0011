package data;

public class Student {
    private String sID;
    private String sName;

    public Student() {
    }

    public Student(String sID, String sName) {
        this.sID = sID;
        this.sName = sName;
    }

    public String getsID() {
        return sID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void output() {
        System.out.printf("|%-10s|%-20s|", sID, sName);
    }

    @Override
    public String toString() {
        return sID + ";" + sName + "\n";
    }

    public String toString2() {
        return String.format("|%-10s|%-20s|", sID, sName);
    }
}
