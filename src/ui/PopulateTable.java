package ui;
/** 
* @author: jan 
* @date: 2018年5月22日 上午12:02:06 
*/
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PopulateTable {
    private final SimpleIntegerProperty count;
    private final SimpleStringProperty name;
    private final SimpleStringProperty date;
    public PopulateTable(int count, String name, String date) {
        super();
        this.count = new SimpleIntegerProperty(count);
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleStringProperty(date);
    }
    public int getCount() {
        return count.get();
    }
    public String getName() {
        return name.get();
    }
    public String getDate() {
        return date.get();
    }
}
