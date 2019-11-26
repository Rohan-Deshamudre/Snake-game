package gui.controller;

import database.DBconnect;
import gui.AlertBox;
import gui.MainRunner;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;


public class LoginController {


    /**
     * when you click register button, move to register page.
     * @throws IOException IOexception thrown for null file.
     */
    public void clickRegister() throws IOException {
        final URL url = new File("src/main/resources/fxml/register.fxml").toURI().toURL();
        final Parent parentRegister = FXMLLoader.load(url);

        Scene registerScene = new Scene(parentRegister);
        MainRunner.stage.setScene(registerScene);
    }

    @FXML
    public TextField loginusername;
    public TextField loginpassword;
    public TextField registerusername;
    public TextField registerpassword;
    public TextField confirmpassword;


    public String getLoginusername() {

        return loginusername.getText();
    }

    public String getLoginpassword() {

        return loginpassword.getText();
    }

    public String getRegisterusername() {
        return registerusername.getText();
    }

    public String getRegisterpassword() {
        return registerpassword.getText();
    }

    public String getConfirmpassword() {
        return confirmpassword.getText();
    }

    /**
     * This method checks if the login was successful.
     */
    public void login() {
        try {
            DBconnect database = new DBconnect();
            if (getLoginusername().equals("") || getLoginpassword().equals("")) {
                System.out.println("LOGIN UNSUCCESSFUL");
                AlertBox.display("One or multiple fields have not been filled in!",
                        "Empty field(s)");
            } else if (database.loginData(getLoginusername(), getLoginpassword())) {
                System.out.println("LOGIN SUCCESSFUL");
                AlertBox.display("You are logged in!", "Success");
            } else {
                AlertBox.display("Wrong username/password combination. Please try again.",
                    "Something went wrong");
                System.out.println("LOGIN UNSUCCESSFUL");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method checks if the user gets registered into the database.
     */
    public void register() {
        try {
            DBconnect database = new DBconnect();
            if (!getRegisterpassword().equals(getConfirmpassword())) {
                AlertBox.display("Passwords do not match!", "Something went wrong");
                System.out.println("REGISTRATION UNSUCCESSFUL");
            } else if (getRegisterusername().equals("")
                    || getRegisterpassword().equals("") || getConfirmpassword().equals("")) {
                AlertBox.display("One or multiple fields have not been filled in!",
                        "Empty field(s)");
                System.out.println("REGISTRATION UNSUCCESSFUL");
            } else if (database.registerUser(getRegisterusername(), getRegisterpassword())) {
                AlertBox.display("Successfully registered.", "Success");
                System.out.println("REGISTRATION SUCCESSFUL");
            } else {
                AlertBox.display("Username already taken!", "Something went wrong");
                System.out.println("REGISTRATION UNSUCCESSFUL");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
