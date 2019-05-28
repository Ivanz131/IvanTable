package net.ivanz.DataTable.Models;

import java.util.List;

public class Person {
    public String FIO;
    public String[] dayStatus;

    public Person() {
    }

    public Person(String FIO, String[] dayStatus) {
        this.FIO = FIO;
        this.dayStatus = dayStatus;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String[] getDayStatus() {
        return dayStatus;
    }

    public void setDayStatus(String[] dayStatus) {
        this.dayStatus = dayStatus;
    }
}
