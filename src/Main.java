import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/*
 * 
 * @author Samuel Walton
 * 
 * */

public class Main extends Application {
	
	private Stage window;
	private Scene scene;
	private BorderPane root = new BorderPane();
	TextField result;

	private static ArrayList<Items> list  = new ArrayList<Items>();
	
	
	//window title
	private static String  TITLE = "Valencia Sandwich Shop";
	ListView listView,listView2;
	double totalprice;
	int a = 0;
	
	public static void main(String[] args) throws FileNotFoundException { launch(args);
	
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	    window =  primaryStage;

	    addPricesToItems();
	   
	   
	    root.setLeft(leftBox());
	    root.setRight(RightBox());
	    root.setBottom(BottomBox());
	    root.setTop(TopBox());
	        
	    scene = new Scene(root,800,500);
	    window.setScene(scene);
	    window.setResizable(true);
	    window.setTitle(TITLE);
	    window.setResizable(false);
	    window.show();

	    
	
	    }
	

	
	 VBox leftBox(){
		
		 VBox topBar = new VBox();
		 topBar.setStyle("-fx-background-color:#fff;");
		 topBar.setPrefWidth(400);
		 topBar.setPadding(new Insets(10));
		 topBar.setSpacing(20);
		 
		 
	 	Label title1 = new Label("Choose Sandwich Ingredient");
		title1.setStyle("-fx-text-fill:#000;-fx-background-color:#fff;-fx-border-radius:5px;-fx-background-radius:5px;-fx-font-weight:bold;");
		title1.setFont(Font.font(17));
		topBar.getChildren().add(title1);
		 
		 ArrayList<String> list1 = new ArrayList<String>();
		 
		 for (int i = 0; i < list.size(); i++) {
			 list1.add(list.get(i).getIngredientName());
		  }
		 
		 
		 listView = new ListView();
		 for (int i = 0; i < list1.size(); i++) {
			 listView.getItems().add(list1.get(i));
		  }
		 
		 
		
		 topBar.getChildren().add(listView);
		 
		 
		 CheckBox box1 = new CheckBox("Optional: Tomato");
		 topBar.getChildren().add(box1);
                 
                 CheckBox box2 = new CheckBox("Optional:Lettuce");
		 topBar.getChildren().add(box2);
                 
                 CheckBox box3 = new CheckBox("Optional: Bacon");
		 topBar.getChildren().add(box3);
		 
		 
		 
		 box1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				
				
				
				if(a == 0) {
					
					
					totalprice += 2.50;
					
					
					DecimalFormat df = new DecimalFormat("#.00");
					
					result.setText("$"+df.format(totalprice));
					
					a = 1;
					
				}else {
					
					a = 0;
					
				}
				
				
				
			}
		});
		 
		
		return topBar;
	}
	 
	 
	 VBox RightBox(){
			
		 
		 
		 VBox topBar = new VBox();
		 topBar.setPrefWidth(400);
		 topBar.setStyle("-fx-background-color:#fff;");
		 topBar.setPadding(new Insets(10));
		 topBar.setSpacing(20);
		 
		 
	 	Label title1 = new Label("Choose Sandwich Bread");
		title1.setStyle("-fx-text-fill:#000;-fx-background-color:#fff;-fx-border-radius:5px;-fx-background-radius:5px;-fx-font-weight:bold;");
		title1.setFont(Font.font(17));
		topBar.getChildren().add(title1);
		 
		 ArrayList<String> list1 = new ArrayList<String>();
		 
		 for (int i = 0; i < list.size(); i++) {
			 list1.add(list.get(i).getBreadTypes());
		  }
		 
		 
		 listView2 = new ListView();
		 listView2.setPrefHeight(215);
		 for (int i = 0; i < list1.size(); i++) {
			 listView2.getItems().add(list1.get(i));
		  }
		 
		 
		 
		
		 
		 
		 topBar.getChildren().add(listView2);
		 
		
		return topBar;
	}
	

	 
	 VBox BottomBox(){
			
	 VBox topBar = new VBox();
	 topBar.setStyle("-fx-background-color:#fff;");
	 topBar.setPadding(new Insets(10));
	 topBar.setSpacing(20);
	 topBar.setAlignment(Pos.CENTER);
	 
		 
	 	Button choose = new Button("Submit");
		choose.setStyle("-fx-padding:5 48 5 48;-fx-background-color:#f1f1f1;-fx-font-weight:bold;-fx-border-color:#C0C0C0;-fx-border-width:1px;-fx-border-radius:5;");
		choose.setCursor(Cursor.HAND);
		topBar.getChildren().add(choose);
		
		
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
	
		
		Label title1 = new Label("Price:");
		title1.setStyle("-fx-text-fill:#000;-fx-background-color:#fff;-fx-border-radius:5px;-fx-background-radius:5px;-fx-font-weight:bold;");
		title1.setFont(Font.font(17));
		hb.getChildren().add(title1);
		
		result = new TextField();
		result.setPrefWidth(250);
		result.setPrefHeight(30);
		hb.getChildren().add(result);
		
		
		topBar.getChildren().add(hb);
		
	choose.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				
				
				
				boolean listRight = listView.getSelectionModel().isEmpty();
				boolean listLeft = listView2.getSelectionModel().isEmpty();
				
				
				if(listRight || listLeft) {
					
					new Alert(AlertType.INFORMATION,"Please Select Any ingredient and Bread Type").show();
					
				}else {
					
					String ingredient = (String) listView.getSelectionModel().getSelectedItem();
					String breadtype = (String) listView2.getSelectionModel().getSelectedItem();
					double ingPrice = 0, breadPrice = 0;
					
					for (int i = 0; i < list.size(); i++) {
						if(list.get(i).getIngredientName().equals(ingredient)) {
							ingPrice = list.get(i).getIngredientPrice();
						}else continue;
					}
					
					for (int i = 0; i < list.size(); i++) {
						if(list.get(i).getBreadTypes().equals(breadtype)) {
							breadPrice = list.get(i).getBreadPrice();
						}else continue;
					}
					
					DecimalFormat df = new DecimalFormat("#.00");
					
					totalprice = (ingPrice + breadPrice );
					
					System.out.println(ingredient + " , "+ df.format(totalprice));
					
					result.setText("$"+ totalprice);
					
					
				}
				
				
			}
		});
		
		 
		
		return topBar;
	}
	
	 
	 VBox TopBox(){
			
		 VBox topBar = new VBox();
		 topBar.setStyle("-fx-background-color:#fff;");
		 topBar.setPadding(new Insets(10));
		 topBar.setSpacing(0);
		
		 
		
		Label title1 = new Label("Valencia");
		title1.setStyle("-fx-text-fill:#e75480;-fx-background-color:#fff;-fx-border-radius:5px;-fx-background-radius:5px;-fx-font-weight:bold;");
		title1.setFont(Font.font(22));
		topBar.getChildren().add(title1);
		
		Label title12 = new Label("Sandwich Shop");
		title12.setStyle("-fx-text-fill:#ffbf00;-fx-background-color:#fff;-fx-border-radius:5px;-fx-background-radius:5px;-fx-font-weight:bold;");
		title12.setFont(Font.font(22));
		topBar.getChildren().add(title12);
		
		
		
		return topBar;
	}

	void addPricesToItems() {
		
		
		list.add(new Items("Chicken", 12.00, "White Bread", 8.00));
		list.add(new Items("Cheese", 8.00, "Whole Wheat Bread", 9.00));
		list.add(new Items("Turkey", 9.00, "Ciabatta", 11.00));
		list.add(new Items("Beef", 11.00, "Beigel", 8.50));
		
		
		
	}

	

	
}