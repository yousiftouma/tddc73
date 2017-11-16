package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;


public class Main extends Application {

    private Scene scene;
    private Stage stage;
    private ImageView imageView;
    private FileChooser fileChooser;

    private int baseFitHeight;
    private int scaleValue;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Starkaste, snyggaste och smartaste STABEN");

        scene = new Scene(new Group());
        scene.setRoot(root);

        fileChooser = new FileChooser();
        stage = primaryStage;

        Image image1 = new Image(Main.class.getResourceAsStream("Andreas.png"));
        imageView = (ImageView) scene.lookup("#boxImage");
        imageView.setPreserveRatio(true);
        imageView.setImage(image1);
        baseFitHeight = 400;
        imageView.setFitHeight(baseFitHeight);

        primaryStage.setFullScreen(true);

        setButtonListeners();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setButtonListeners(){
        Button rotateClockwise = (Button) scene.lookup("#rotateCW");
        Button rotateCounterClockwise = (Button) scene.lookup("#rotateCCW");
        Button scaleUp = (Button) scene.lookup("#scaleUp");
        Button scaleDown = (Button) scene.lookup("#scaleDown");
        Button loadImage = (Button) scene.lookup("#loadImage");

        rotateClockwise.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rotateImageView(5);
            }
        });

        rotateCounterClockwise.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rotateImageView(-5);
            }
        });

        scaleUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scaleImageView(10);
            }
        });

        scaleDown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scaleImageView(-10);
            }
        });

        loadImage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = fileChooser.showOpenDialog(stage);
                if (file != null){
                    try {
                        imageView.setImage(new Image(file.toURI().toURL().toExternalForm()));
                        scaleValue = 0;
                        imageView.setRotate(0);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void rotateImageView(int degreesToRotate){
        imageView.setRotate(imageView.getRotate() + degreesToRotate);
    }


    private void scaleImageView(int scaleValue){
        this.scaleValue += scaleValue;
        imageView.setFitHeight(baseFitHeight + this.scaleValue);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
