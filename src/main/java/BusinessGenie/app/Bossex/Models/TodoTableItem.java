package BusinessGenie.app.Bossex.Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TodoTableItem {
    private final SimpleStringProperty todoDescription;
    private final SimpleStringProperty date;
    private final SimpleIntegerProperty id;

    public TodoTableItem(String todoDescription, String date, int id) {
        this.todoDescription = new SimpleStringProperty(todoDescription);
        this.date= new SimpleStringProperty(date);
        this.id= new SimpleIntegerProperty(id);
    }

    public String getTodoDescription() {
        return todoDescription.get();
    }
    public void setTodoDescription(String b) {
        todoDescription.set(b);
    }
    public String getDate() {
        return date.get();
    }
    public void setDate(String b) {
        date.set(b);
    }
    public int getId() {
        return id.get();
    }
    public void setId(int a) {
        id.set(a);
    }
}