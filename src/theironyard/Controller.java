package theironyard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
        ObservableList<Contact> contact = FXCollections.observableArrayList();

    @FXML
    ListView list;
    @FXML
    TextField text;
    @FXML
    TextField text1;
    @FXML
    TextField text2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contact);

    }
    public void addContact(){
        contact.add(new Contact(text.getText(), text1.getText(), text2.getText()));
        text.setText("");
        text1.setText("");
        text2.setText("");
    }
    public void removeContact(){
        Contact contact1 = (Contact) list.getSelectionModel().getSelectedItem();
        contact.remove(contact1);
    }
}
