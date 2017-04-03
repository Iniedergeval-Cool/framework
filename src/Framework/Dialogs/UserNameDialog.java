package Framework.Dialogs;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.*;

/**
 * Class UserNameDialog
 *
 * @author Ruben Buisman
 * @version 0.1 (28-03-2017)
 */
public class UserNameDialog extends AbstractDialog{

    private String userName;
    private TextField playerName;

    public void display(){
        super.createDialog("Create username", "Please enter your username:");
        super.createGrid();
        addTextFields();
        createButtons();

        // If closed, set the fields and execute callback.
        super.dialog.showAndWait();
        setUserName(playerName.getText());
        executeCallback();
    }

    public void addTextFields() {
        playerName = new TextField();
        super.grid.add(playerName, 0, 0);
        Platform.runLater(playerName::requestFocus);
    }

    private void createButtons() {
        // Set the button types.
        ButtonType button = new ButtonType("Create", ButtonBar.ButtonData.OK_DONE);
        super.dialog.getDialogPane().getButtonTypes().addAll(button, ButtonType.CANCEL);


        // Enable/Disable connect button depending on whether a ip was entered.
        Node connectButton = dialog.getDialogPane().lookupButton(button);
        connectButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        playerName.textProperty().addListener((observable, oldValue, newValue) -> {
            connectButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);
    }

    private void executeCallback(){
        // Confirm username in terminal
        System.out.println("Send to network: "+ getUserName());
    }


    /*
     * Getters and setters:
     */
    private String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }
}


