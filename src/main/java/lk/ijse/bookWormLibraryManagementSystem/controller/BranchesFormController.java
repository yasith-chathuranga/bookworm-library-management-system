package lk.ijse.bookWormLibraryManagementSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bookWormLibraryManagementSystem.bo.custom.BranchesBo;
import lk.ijse.bookWormLibraryManagementSystem.bo.impl.BranchesBOImpl;
import lk.ijse.bookWormLibraryManagementSystem.dto.BranchesDto;
import lk.ijse.bookWormLibraryManagementSystem.entity.Branches;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BranchesFormController {

    public TextField txtbId;
    public TextField txtName;
    public TextField txtLocastion;
    public ComboBox cmbStatus;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnDelete;
    public TableView tblMain;
    public TableColumn tblId;
    public TableColumn tblNmae;
    public TableColumn tblLocation;
    public TableColumn tblStatus;
    BranchesBo branchesBo=new BranchesBOImpl();
    public void initialize(){
        tblId.setCellValueFactory(new PropertyValueFactory<>("brId"));
        tblNmae.setCellValueFactory(new PropertyValueFactory<>("bname"));
        tblLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        tblStatus.setCellValueFactory(new PropertyValueFactory<>("bstatus"));

        try {

            ArrayList<BranchesDto> branch = branchesBo.getAllBranches();

            tblMain.setItems(FXCollections.observableArrayList(branch.stream().map(br -> {
                return new BranchesDto(
                        br.getBrId(),
                        br.getBname(),
                        br.getLocation(),
                        br.getBstatus()

                );
            }).collect(Collectors.toList())));

        }catch (Exception e){
            System.out.println(e);
        }

      setStatus();
    }

    private void setStatus() {
            ObservableList<String> data = FXCollections.observableArrayList ("Open", "Close");
            cmbStatus.setItems (data);


    }


    public void save_OnAction(ActionEvent actionEvent) {
        boolean validate = validateBranches();
        if (validate) {
            branchesBo.saveBranches(new BranchesDto(
                    txtbId.getText(),
                    txtName.getText(),
                    txtLocastion.getText(),
                    cmbStatus.getValue().toString()

            ));

            new Alert(Alert.AlertType.CONFIRMATION, "Branch Added Successfully").show();
            clearText();

            initialize();
        } else {
            new Alert(Alert.AlertType.ERROR, "ENTER RIGHT DETAILS..!").show();
        }
    }

    private void clearText() {
        txtbId.clear();
        txtName.clear();
        txtLocastion.clear();
    }

    public void update_OnAction(ActionEvent actionEvent) {
       branchesBo.updateBranches(new BranchesDto(
               txtbId.getText(),
               txtName.getText(),
               txtLocastion.getText(),
               cmbStatus.getValue().toString()
        ));

        new Alert(Alert.AlertType.CONFIRMATION,"Branch Updated Successfully").show();


        initialize();
    }

    public void delete_OnAction(ActionEvent actionEvent) {
        branchesBo.deleteBranch(new Branches(
                txtbId.getText(),
                txtName.getText(),
                txtLocastion.getText(),
                cmbStatus.getValue().toString()
        ));

        new Alert(Alert.AlertType.CONFIRMATION,"Branch Delete Successfully").show();


        initialize();
    }

    private boolean validateBranches() {
        String id_value=txtbId.getText();
        Pattern complie=Pattern.compile("[B][0-9]{3}");
        Matcher matcher=complie.matcher(id_value);
        boolean matches=matcher.matches();
        if (!matches){
            new Alert(Alert.AlertType.ERROR,"INVALID BRANCH ID").show();
            return  false;
        }
        String location=txtLocastion.getText();
        Pattern compile1 = Pattern.compile("[A-Za-z]{4,}");
        Matcher matcher1=compile1.matcher(location);
        boolean isAddress=matcher1.matches();
        if (!isAddress){
            new Alert(Alert.AlertType.ERROR,"WRONG ADDRSS TYPE").show();
        }
        String nameText=txtName.getText();
        boolean isnameValid= Pattern.compile("[A-Za-z]{3,}").matcher(nameText).matches();

        if (!isnameValid){
            new Alert(Alert.AlertType.ERROR,"WRONG NAME TYPE").show();
        }

        return true;

    }

}
