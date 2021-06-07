package BusinessGenie.app.Bossex.Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;



public class ImportContactsInstructionTemplate
{

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty title;
    //private final SimpleStringProperty subTitle;
    private final SimpleListProperty<String> instructions;

    public ImportContactsInstructionTemplate(int id, String title, ObservableList<String> instructions) {
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        //this.subTitle = new SimpleStringProperty(subTitle);
        this.instructions = new SimpleListProperty<>(instructions);
    }
    public int getId() {
        return id.get();
    }
    public void setID(int b) {
        id.set(b);
    }
    public String getTitle() {
        return title.get();
    }
    public void setTitle(String fName) {
        title.set(fName);
    }
//    public String getSubTitle() {
//        return subTitle.get();
//    }
//    public void setSubTitle(String fName) {
//        subTitle.set(fName);
//    }
    public ObservableList<String> getInstructions() {
        return instructions.get();
    }
    public void setInstructions(ObservableList<String>  fName) {
        instructions.set(fName);
    }
}