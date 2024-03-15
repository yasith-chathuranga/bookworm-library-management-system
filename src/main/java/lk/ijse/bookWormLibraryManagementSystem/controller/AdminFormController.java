package lk.ijse.bookWormLibraryManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminFormController {

    public TextField txtName;
    public TextField txtPassword;
    public Button btnConform;
    public AnchorPane root;

    private String name="yasith";
    private String password="1234";

    public void conform_OnAction(ActionEvent actionEvent) throws IOException {

        String userPass=txtPassword.getText ();
        String userName=txtName.getText ();
        if (userName.equals (name) && userPass.equals (password)){
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("/view/BranchesForm.fxml"));
            Parent load= fxmlLoader.load();
            BranchesFormController controller=fxmlLoader.getController();
            root.getChildren().clear();
            root.getChildren().add(load);

        }else{
            new Alert(Alert.AlertType.ERROR, "INVALID ADMIN ATHUENTICATION").show ();
            txtPassword.clear ();
            txtName.clear ();
        }

    }

}
