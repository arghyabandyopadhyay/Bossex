/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessGenie.app.Bossex.Models.Invoice;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Sony
 */
public class Type {
    final SimpleStringProperty name;
    public Type(String hh)
    {
        name = new SimpleStringProperty(hh);
    }

    public String getName() {
        return name.get();
    }
}
