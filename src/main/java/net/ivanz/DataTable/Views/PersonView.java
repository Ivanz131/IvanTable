package net.ivanz.DataTable.Views;

import net.ivanz.DataTable.Models.ColumnModel;
import net.ivanz.DataTable.Models.Person;
import net.ivanz.DataTable.Services.PersonService;
import org.primefaces.event.CellEditEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "dtPersonView")
@ViewScoped
public class PersonView implements Serializable {
    private List<String> dates;
    private List<Person> personList;
    private List<ColumnModel> columns;

    @ManagedProperty("#{personService}")
    private PersonService personService;

    @PostConstruct
    public void init() {
        dates = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            if (i < 9) dates.add("0" + (i + 1) + ".06");
            else dates.add((i + 1) + ".06");
        }
        personList = personService.createPersons();
        columns = new ArrayList<ColumnModel>();
        for (int i = 0; i < 30; i++) {
            columns.add(new ColumnModel(dates.get(i),i+""));
        }
    }

    public List<String> getDates() {
        return dates;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public List<ColumnModel> getColumns() {
        return columns;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public void onCellEdit(CellEditEvent event){
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
