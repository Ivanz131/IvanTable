package net.ivanz.DataTable.Models;

import java.io.Serializable;
import java.util.List;

public class DayInfo implements Serializable {
    public List<String> dayStatus;

    public DayInfo(){}

    public DayInfo(List<String> dayStatus) {
        this.dayStatus = dayStatus;
    }

    public List<String> getDayStatus() {
        return dayStatus;
    }

    public void setDayStatus(List<String> dayStatus) {
        this.dayStatus = dayStatus;
    }
}
