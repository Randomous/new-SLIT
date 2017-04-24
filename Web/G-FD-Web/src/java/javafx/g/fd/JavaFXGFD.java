/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.g.fd;

import InputAndResponses.Start;
import WebInput.Input;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Tor Borgen <Tor Borgen at CastleDev>
 */
public class JavaFXGFD extends Application {
    public Start startRef;
    public Input inputter;
    
    @Override
    public void start(Stage primaryStage) {
        //Initialise the refs needed
        startRef = new Start();
        inputter = new Input();
        
        //Creating a grid for form
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        //Create the scene
        Scene scene = new Scene(grid, 700, 500);
        //Creating new VBox for layout of text
        VBox layout = new VBox(25); 
        
        //Set content variables
        Text scenetitle = new Text(startRef.printWelcome());
        scenetitle.setId("scenetitle");
        Label gamer = new Label("Enter the command or gamer");
        
        //Creating new HBox container for autowrapping of text
        HBox container = new HBox(scenetitle);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(10));
        
        //Adding the scenetitle to layout and set wrapping
        layout.getChildren().add(scenetitle);
        scenetitle.wrappingWidthProperty().bind(scene.widthProperty().subtract(15));
        
        //Adding scenetitle to HBox for rezizing
        HBox.setHgrow(scenetitle, Priority.ALWAYS);
        BorderPane pane = new BorderPane();
        pane.setCenter(container);
        
        //Input text field
        TextField inputText = new TextField();
        
        //Setup the grid positions layout
        grid.add(scenetitle,0,0,2,1);
        grid.add(gamer,0,1);
        grid.add(inputText,1,1);
        grid.setGridLinesVisible(false);
        
        //Creating button and positioning it in layout
        Button btn = new Button("Search");
        HBox hdBtn = new HBox(10);
        hdBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hdBtn.getChildren().add(btn);
        grid.add(hdBtn,1,4);
        
        //Setting actiontarget
        final Text actiontarget = new Text();
        grid.add(actiontarget,1,6);
        
        //using lamda expressions. Instead of overriding inner classes
        btn.setOnAction(event ->
        {
           //actiontarget.setFill(Color.WHITE);
           //actiontarget.setText("Search intialized");
           inputter.setName(inputText.getText());
           
           actiontarget.setText(inputter.getName());
           actiontarget.setId("actiontarget");
      
        });
        
        scene.getStylesheets().add(JavaFXGFD.class.getResource("css/javaFxStyling.css").toExternalForm());
        primaryStage.setTitle("G-FD Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
    
}
