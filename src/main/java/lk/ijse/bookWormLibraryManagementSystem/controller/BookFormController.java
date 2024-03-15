package lk.ijse.bookWormLibraryManagementSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bookWormLibraryManagementSystem.bo.custom.BookBo;
import lk.ijse.bookWormLibraryManagementSystem.bo.impl.BookBoImpl;
import lk.ijse.bookWormLibraryManagementSystem.dto.BookDto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookFormController {
    public TextField txtID;//751 684
    public TextField txtTitle;
    public TextField txtAuthor;
    public TextField txtGenre;
    public ComboBox cmbStatus;
    public TableView tblLMainBook;
    public TableColumn tblID;
    public TableColumn tblTitle;
    public TableColumn tblAuthor;
    public TableColumn tblGenre;
    public TableColumn tblStatus;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnDelete;

    BookBo bookBo=new BookBoImpl();

    public void initialize(){
        tblID.setCellValueFactory (new PropertyValueFactory<>("bId"));
        tblTitle.setCellValueFactory (new PropertyValueFactory<> ("title"));
        tblAuthor.setCellValueFactory (new PropertyValueFactory<> ("author"));
        tblGenre.setCellValueFactory (new PropertyValueFactory<> ("genre"));
        tblStatus.setCellValueFactory (new PropertyValueFactory<> ("status"));

        loadAllBooks();
        setStatus();
    }

    private void setStatus() {
        ObservableList<String> data = FXCollections.observableArrayList ("AVALILABLE", "NOTAVALAIBLE");
        cmbStatus.setItems (data);
    }

    private void loadAllBooks() {
        try {
            List allBook = bookBo.loadAll ();
            ObservableList observableList = FXCollections.observableArrayList (allBook);
            tblLMainBook.setItems (observableList);

        } catch (Exception e) {
            System.out.println (e);
        }
    }

    public void save_OnAction(ActionEvent actionEvent) {

        String bookId = txtID.getText();
        String title = txtTitle.getText();
        String author = txtAuthor.getText();
        String genre = txtGenre.getText();
        String status = cmbStatus.getValue().toString();
        boolean isSaved = validateBook();
        if (isSaved) {
            BookDto bookdto = new BookDto(
                    bookId,
                    title,
                    author,
                    genre,
                    status
            );

            try {

                List<BookDto> allBooks = bookBo.loadAll();

                if (checkduplicate()) {

                    bookBo.saveBook(bookdto);
                    loadAllBooks();
                    setBookId();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
         new Alert(Alert.AlertType.ERROR,"ENTER RIGHT DETAIL..!").show();
        }
    }

    private void setBookId() {
    }

    private boolean checkduplicate() {
        String bookId = txtID.getText ();
        List<BookDto> allBooks = bookBo.loadAll ();
        for (BookDto books : allBooks) {
            if (bookId.equals (books.getBId())) {
                new Alert(Alert.AlertType.ERROR, "This ID Already Taken").show ();
                return false;
            }
        }
        return true;
    }

    public void update_OnAction(ActionEvent actionEvent) {

        BookDto bookdto = new BookDto (
              txtID.getText(),
                txtTitle.getText (),
                txtAuthor.getText (),
                txtGenre.getText(),
                cmbStatus.getValue().toString()

        );

        boolean isUpdate = bookBo.updateBook (bookdto);

        if (isUpdate) {
            new Alert (Alert.AlertType.INFORMATION, " Update Complete...!").show ();
           // tblRoom.getItems ().clear ();
            clearDataText();
            loadAllBooks();
            setBookId ();
        } else {
            new Alert (Alert.AlertType.ERROR, "Something went Wrong").show ();
        }
    }

    private void clearDataText() {
        txtID.clear();
        txtTitle.clear();
        txtAuthor.clear();
        txtGenre.clear();

    }

    public void deleteOn_Action(ActionEvent actionEvent) {
        BookDto bookdto = new BookDto (
                txtID.getText (),
                txtTitle.getText (),
                txtAuthor.getText (),
                txtGenre.getText(),
                cmbStatus.getValue().toString()
        );

        boolean isDeleted = bookBo.deleteBook (bookdto);

        if (isDeleted) {
            new Alert (Alert.AlertType.INFORMATION, "Book Delete Success..!").show ();
            tblLMainBook.getItems ().clear ();
            clearDataText ();
            loadAllBooks ();
            setBookId ();
        } else {
            new Alert (Alert.AlertType.ERROR, "Something went Wrong").show ();
        }

    }

    private boolean validateBook() {
        String id_value = txtID.getText();
        Pattern complie = Pattern.compile("[B][0-9]{3}");
        Matcher matcher = complie.matcher(id_value);
        boolean matches = matcher.matches();
        if (!matches){
            new Alert(Alert.AlertType.ERROR,"INVALID BOOK ID").show();
            return  false;
        }
        String title=txtTitle.getText();
        Pattern compile1 = Pattern.compile("[A-Za-z]{4,}");
        Matcher matcher1 = compile1.matcher(title);
        boolean isAddress = matcher1.matches();
        if (!isAddress){
            new Alert(Alert.AlertType.ERROR,"WRONG ADDRESS TYPE").show();
        }
        String nameText = txtAuthor.getText();
        boolean isnameValid = Pattern.compile("[A-Za-z]{3,}").matcher(nameText).matches();

        if (!isnameValid){
            new Alert(Alert.AlertType.ERROR,"WRONG NAME TYPE").show();
        }

        return true;

    }

}
