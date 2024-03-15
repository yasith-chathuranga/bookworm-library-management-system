package lk.ijse.bookWormLibraryManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.bookWormLibraryManagementSystem.bo.custom.UserBo;
import lk.ijse.bookWormLibraryManagementSystem.bo.impl.UserBoImpl;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;
import lk.ijse.bookWormLibraryManagementSystem.util.Mail;
import lk.ijse.bookWormLibraryManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.mail.MessagingException;
import java.util.List;

//import static sun.security.krb5.internal.ccache.FileCredentialsCache.checkValidation;

public class UserFormController {

    public TextField txtID;
    public TextField txtUserName;
    public PasswordField txtPassword;
    public PasswordField txtReEnPW;
    public Button btnCreate;
    public TextField txtEmail;

    UserBo userBo=new UserBoImpl();

    public void initialize(){
        setUserId();
    }

    public void create_ONAction(ActionEvent actionEvent) throws MessagingException {
        String pass=txtPassword.getText ();
        String rePass=txtReEnPW.getText ();
        String userId = txtID.getText ();
        String userName = txtUserName.getText ();
        String email=txtEmail.getText ();


        if (checkDuplidate ()){
           // if (checkValidation ()){
                if(pass.equals (rePass)){
                    userBo.saveUser (new UserDto(
                            userId,
                            userName,
                            pass
                    ));
                    new Alert(Alert.AlertType.CONFIRMATION, "USER ACCOUNT CREATED SUCCUSS").show ();
                  Mail.outMail ("YOU ARE A USER IN BOOKWORM LIBRARY",email,"BookWorm");
                    clearFeilds();
                    setUserId ();

                }else {
                    new Alert (Alert.AlertType.ERROR, "Check your Password and Try Again").show ();
                }

    }else{
        new Alert (Alert.AlertType.ERROR, "THIS USER ID ALREADY GET").show ();
        clearFeilds ();
    }
        }
    public String nextUserID() {
        Session session = SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction = session.beginTransaction ();

        Query query = session.createQuery ("select userId from User order by userId desc");

        String nextId = "U001";

        if (query.list ().size () == 0) {
            return nextId;
        } else {
            String id = (String) query.list ().get (0);

            String[] SUs = id.split ("U00");

            for (String a : SUs) {
                id = a;
            }

            int idNum = Integer.valueOf (id);

            id = "U00" + (idNum + 1);

            transaction.commit ();
            session.close ();

            return id;
        }
    }

    private void setUserId() {
        String userID = nextUserID ();
        txtID.setText (userID);
    }

    private void clearFeilds() {
    }


    private boolean checkDuplidate() {
        String userId=txtID.getText ();
        List<UserDto> allRoom = userBo.loadAll ();
        for (UserDto u : allRoom) {
            if (userId.equals (u.getUserId ())){
                return false;
            }
        }
        return  true;

    }
}
