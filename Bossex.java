package BusinessGenie.app.Bossex;

import BusinessGenie.app.Bossex.Api.ApiAccessor;
import BusinessGenie.app.Bossex.Models.UsersModel;
import BusinessGenie.app.Bossex.Services.UniversalUtility;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;

public class Bossex extends Application {
    public static  String driverClass;
    public static  String apiUrl;
    public static  String user;
    public static  String password;
    public static String baseURL;
    public static UsersModel userDetails;
    public static String appTitle;
    public static Scene[] scene;
    final static DecimalFormat df = new DecimalFormat("#.##");
    public static UniversalUtility universalUtility;
    public static boolean[] permission=new boolean[5];
    public static TabPane masterTabPane;
    public static ApiAccessor apiAccessor;
    void initialise() {
        universalUtility=new UniversalUtility();
        driverClass="com.mysql.jdbc.Driver";
        apiUrl="jdbc:mysql://localhost:3306/Bossex?characterEncoding=latin1";
        user="BossexClient";
        password="businessGenie9@gmail.com";
        baseURL= "/BusinessGenie/app/Bossex/";
        appTitle="Bossex : ";
        //apiAccessor=new ApiAccessor();
    }
    @Override
    public void start(Stage stage) {
        initialise();
        final ImageView imv = new ImageView();
        Image image1 = new Image(getClass().getResource(Bossex.baseURL+"Resources/BossexSplashScreen.png").toExternalForm());
        imv.setImage(image1);
        StackPane root1 = new StackPane();
        root1.getChildren().add(imv);
        Scene scene1 = new Scene(root1, image1.getWidth(), image1.getHeight(), Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene1);
        stage.centerOnScreen();
        stage.show();
        FadeTransition ft = new FadeTransition(Duration.millis(700), imv);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(2000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            initialiseScenes();
                            //the login page is opened by this code.
                            Parent root = null;
                            try {
                                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Bossex.baseURL + "Views/LoginPage/LoginPage.fxml")));
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null,e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
                            }
                            Stage stage1=new Stage();
                            stage1.setTitle(appTitle+"Login");
                            stage1.setScene(Bossex.scene[0]);
                            stage1.show();
                            stage.close();
                        }
                    });
                }catch(InterruptedException n){
                    JOptionPane.showMessageDialog(null,n.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
                }
            }
        }.start();
    }
    void initialiseScenes() {
        try {
            scene = new Scene[10];
            scene[0] = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Bossex.baseURL + "Views/LoginPage/LoginPage.fxml"))));
            scene[1] = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Bossex.baseURL + "Views/MasterPage/MasterPage.fxml"))));
            scene[2] = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Bossex.baseURL + "Views/SettingsPage/SettingsPage.fxml"))));

            /*scene[3] = new Scene(FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/SalesManager/SalesManagementPage.fxml")));
            scene[4] = new Scene(FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/ReportManager/ReportManagementPage.fxml")));
            scene[5] = new Scene(FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/InventoryManager/InventoryManagementPage.fxml")));
            scene[6] = new Scene(FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/UserManager/UserManagementPage.fxml")));
            scene[7] = new Scene(FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/UserManager/CreateUserPage.fxml")));
            scene[8] = new Scene(FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/CustomerManager/CustomerManagementPage.fxml")));
            scene[9] = new Scene(FXMLLoader.load(getClass().getResource(Bossex.baseURL+"Views/Fxmls/SalesManager/ShowPreviousBills.fxml")));*/
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {launch(args);}
}
