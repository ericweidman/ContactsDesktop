package theironyard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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
    public void addContact() throws IOException {
        if(!text.getText().equals("") && !text1.getText().equals("") && !text2.getText().equals("")) {
            contact.add(new Contact(text.getText(), text1.getText(), text2.getText()));
            text.setText("");
            text1.setText("");
            text2.setText("");
            jsonSave(contact);
        }
    }
    public void removeContact() throws IOException {
        Contact contact1 = (Contact) list.getSelectionModel().getSelectedItem();
        contact.remove(contact1);
        jsonSave(contact);

    }
    public static void jsonSave(ObservableList<Contact> contact) throws IOException {
        JsonSerializer s = new JsonSerializer();
        String json = s.include("*").serialize(contact);

        File fileName = new File("contacts.json");
        FileWriter fw = new FileWriter(fileName);
        fw.write(json);
        fw.close();
    }
    public static void jsonLoad(){
        Scanner s = new Scanner("contacts.json");
        s.useDelimiter("\\Z");
        String contents = s.next();
        JsonParser parser = new JsonParser();
        Contact contact = parser.parse(contents, Contact.class);
    }

}
