package net.ivanz.DataTable.Services;

import net.ivanz.DataTable.Models.Person;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ManagedBean(name = "personService")
@ApplicationScoped
public class PersonService {

    private final static String[] FIO;

    private final static String[][] dayStatus;

    static {
        FIO = new String[10];
        for (int i = 0; i < 10; i++) {
            FIO[i] = "FIO" + i;
        }
        Random RND = new Random();
        dayStatus = new String[10][30];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 30; j++) {
                if (RND.nextBoolean()) dayStatus[i][j] = "W";
                else dayStatus[i][j] = "H";
            }
        }
    }

    public List<Person> createPersons(){
        List<Person> people = new ArrayList<Person>();
        for (int i = 0; i < 10; i++) {
            people.add(new Person(FIO[i], dayStatus[i]));
        }

        return people;
    }

    public static String[] getFIO() {
        return FIO;
    }

    public static String[][] getDayStatus() {
        return dayStatus;
    }
}
