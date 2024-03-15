package lk.ijse.bookWormLibraryManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bookWormLibraryManagementSystem.bo.custom.UserBo;
import lk.ijse.bookWormLibraryManagementSystem.bo.impl.UserBoImpl;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;

import java.io.IOException;
import java.util.List;

public class LoginFormController {
    public AnchorPane root;
    public AnchorPane mainPain;
    public AnchorPane subPain;
    public TextField txtUsername;
    public PasswordField txtPasswordField;
    public TextField txtPassword;
    public Button btnLogin;
    public CheckBox chkBox;

    UserBo userBo=new UserBoImpl();

    public void login_OnAction(ActionEvent actionEvent) throws IOException {
        if (checkUserDetail ()){

            Stage stage= (Stage) root.getScene ().getWindow ();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashBoardForm.fxml"))));
        }else {
            new Alert(Alert.AlertType.ERROR, "INVALID USERNAME OR PASSWORD").show ();
            txtPassword.clear ();
            txtUsername.clear ();
        }
    }

    private boolean checkUserDetail() {
        String userName = txtUsername.getText ();
        String pass=txtPassword.getText ();

        List<UserDto> userList = userBo.loadAll ();

        for (UserDto dto : userList) {
            if(dto.getUserName ().equals (userName) && dto.getPassword ().equals (pass)){
                return true;
            }
        }
        return false;
    }

    public void txtPasswordKeyRelasedOnAction(KeyEvent keyEvent) {
        String text = txtPasswordField.getText();
        txtPassword.setText(text);
    }

    public void chkOnAction(ActionEvent actionEvent) {

        boolean selected = chkBox.isSelected();
        txtPassword.setVisible(true);
    }

    public void showPassword_Released(KeyEvent keyEvent) {
        String text = txtPassword.getText();
        txtPasswordField.setText(text);
    }
}
