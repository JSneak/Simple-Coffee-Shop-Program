import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CoffeeShop extends Application {
	
	Button btn_Order;
	Button btn_checkout;
	
	CheckBox chk_Cream;
	CheckBox chk_ExtraShot;
	CheckBox chk_HotSauce;
	CheckBox chk_Sugar;
	CheckBox chk_Tapioca;
	
	/* The Order Builder class */
	BuildOrder order;
	
	Image header;
	Image middle;
	Image footer;
	Image img_hotSauce;
	Image img_extraShot;
	Image img_sugar;
	
	Label lbl_cream;
	Label lbl_tapioca;
	Label additions;
	
	ImageView iv_hotsauce;
	ImageView iv_extrashot;
	ImageView iv_sugar;
	
	ListView<String> purchaseInfo;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Sean's Coffee");
				
		setupImages();
		setupMiscAdditions();
		Group root = new Group(setupHeader(), setupMiddle(), setupFooter(), setupCheckBoxLabel() ,setupMenu(),setupButtons(), setupReceipt(), iv_hotsauce, iv_extrashot, iv_sugar,lbl_tapioca, lbl_cream);  
		
		Scene scene = new Scene(root,450,750);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public ImageView setupHeader() throws Exception {
		header = new Image(new FileInputStream("/Users/jsneak/Desktop/CS342/Images/header.png"));
		
		//Setting the image view 
		ImageView headerView = new ImageView(header);
		
		headerView.setX(0); 
		headerView.setY(0); 
		
		return headerView;
	}
	
	public ImageView setupMiddle() throws Exception {
		middle = new Image(new FileInputStream("/Users/jsneak/Desktop/CS342/Images/itemView.png"));
		
		//Setting the image view 
		ImageView middleView = new ImageView(middle);
		
		middleView.setX(0); 
		middleView.setY(50); 
		
		return middleView;
	}
	
	public ImageView setupFooter() throws Exception {
		footer = new Image(new FileInputStream("/Users/jsneak/Desktop/CS342/Images/Footer.png"));
		
		//Setting the image view 
		ImageView footerView = new ImageView(footer);
		
		footerView.setX(0); 
		footerView.setY(700); 
		
		return footerView;
	}
	
	public void setupImages() throws Exception {
		img_hotSauce = new Image(new FileInputStream("/Users/jsneak/Desktop/CS342/Images/hotSauce.png"));
		img_extraShot = new Image(new FileInputStream("/Users/jsneak/Desktop/CS342/Images/extrashot.png"));
		img_sugar = new Image(new FileInputStream("/Users/jsneak/Desktop/CS342/Images/sugar.png"));
	}
	
	public GridPane setupMenu() {
		
		
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	updateMiddle();
            } 
        }; 
		
		chk_Cream = new CheckBox("Cream");
		chk_Cream.setOnAction(event);
		chk_ExtraShot = new CheckBox("Extra Shot");
		chk_ExtraShot.setOnAction(event);
		chk_HotSauce = new CheckBox("Hot Sauce");
		chk_HotSauce.setOnAction(event);
		chk_Sugar = new CheckBox("Sugar");
		chk_Sugar.setOnAction(event);
		chk_Tapioca = new CheckBox("Tapioca");
		chk_Tapioca.setOnAction(event);
		
		
		GridPane root = new GridPane();
		
		root.setPadding(new Insets(20));
		root.setHgap(25);
		root.setVgap(15);

		root.add(chk_Cream, 0, 1);
		root.add(chk_ExtraShot, 1,1);
		root.add(chk_HotSauce, 2, 1);
		root.add(chk_Sugar, 0, 2);
		root.add(chk_Tapioca, 1, 2);
		
		GridPane.setHalignment(chk_Cream, HPos.LEFT);
		GridPane.setHalignment(chk_ExtraShot, HPos.LEFT);
		GridPane.setHalignment(chk_HotSauce, HPos.LEFT);
		GridPane.setHalignment(chk_Sugar, HPos.LEFT);
		GridPane.setHalignment(chk_Tapioca, HPos.LEFT);
		
		root.setLayoutX(0);
		root.setLayoutY(420);
		return root;
		
	}
	
	public GridPane setupCheckBoxLabel() {
		additions = new Label("Choose additional sides:");
		
		GridPane root = new GridPane();
		root.setPadding(new Insets(20));
		root.setHgap(25);
		root.setVgap(15);
		
		root.add(additions, 0,0);
		
		GridPane.setHalignment(additions, HPos.LEFT);
		root.setLayoutX(0);
		root.setLayoutY(400);
		
		return root;
	}
	
	public void setupMiscAdditions() {

		lbl_cream = new Label ("* Cream has been added");
		lbl_tapioca = new Label("* Tapioca has been added");
		
		lbl_tapioca.setLayoutX(0);
		lbl_tapioca.setLayoutY(380);
		
		lbl_cream.setLayoutX(0);
		lbl_cream.setLayoutY(360);
		
		lbl_tapioca.setVisible(false);
		lbl_cream.setVisible(false);
		
		iv_hotsauce = new ImageView(img_hotSauce);
		iv_extrashot = new ImageView(img_extraShot);
		iv_sugar = new ImageView(img_sugar);
		
		iv_hotsauce.setX(20); 
		iv_hotsauce.setY(190); 
		
		iv_extrashot.setX(360);
		iv_extrashot.setY(220);
		
		iv_sugar.setX(80);
		iv_sugar.setY(250);
		
		
		iv_hotsauce.setVisible(false);
		iv_extrashot.setVisible(false);
		iv_sugar.setVisible(false);

	}
	
	public GridPane setupButtons() {
		
		btn_Order = new Button("Delete Order");
		btn_Order.setOnAction(e->deleteOrder());
		btn_checkout = new Button("Checkout");
		btn_checkout.setOnAction(e->handleOrder());
		
		GridPane root = new GridPane();
		root.setPadding(new Insets(20));
		root.setHgap(25);
		root.setVgap(15);
		
	 	root.add(btn_Order, 0, 3);
		root.add(btn_checkout, 1, 3);
		GridPane.setHalignment(chk_Cream, HPos.RIGHT);
		GridPane.setHalignment(chk_ExtraShot, HPos.RIGHT);
		
		root.setLayoutX(0);
		root.setLayoutY(580);
		
		return root;
	}
	
	public BorderPane setupReceipt() {
		
		purchaseInfo = new ListView<String>();
		purchaseInfo.setPrefWidth(400);
		purchaseInfo.setPrefHeight(100);
		
		BorderPane infoPane = new BorderPane();
		infoPane.setPadding(new Insets(20));
		
		infoPane.setCenter(purchaseInfo);
		
		infoPane.setLayoutX(0);
		infoPane.setLayoutY(500);
		
		return infoPane;
	}
	
	public void handleOrder() {
		
		/* Handle the disable */
		chk_HotSauce.setDisable(true);
		chk_ExtraShot.setDisable(true);
		chk_Sugar.setDisable(true);
		chk_Tapioca.setDisable(true);
		chk_Cream.setDisable(true);
	
		order = new BuildOrder();
		
		if(chk_HotSauce.isSelected()) {
			order.addHotSauce();
		}
		if(chk_ExtraShot.isSelected()) {
			order.addExtraShot();
		}
		if(chk_Sugar.isSelected()) {
			order.addSugar();
		}
		if(chk_Tapioca.isSelected()) {
			order.addTapioca();
		}
		if(chk_Cream.isSelected()) {
			order.addCream();
		}
		
		double cost = order.getOrder().makeCoffee();
		String receipt = order.getOrder().printCost();
//		System.out.println(receipt);
		purchaseInfo.getItems().add(receipt);
		purchaseInfo.getItems().add("Total: " + String.format("%.2f",cost));
		
		btn_Order.setText("Order Again");
		btn_checkout.setDisable(true);
	}
	
	public void deleteOrder() {
		chk_HotSauce.setDisable(false);
		chk_ExtraShot.setDisable(false);
		chk_Sugar.setDisable(false);
		chk_Tapioca.setDisable(false);
		chk_Cream.setDisable(false);
		
		
		
		purchaseInfo.getItems().clear();
		btn_Order.setText("Delete Order");
		btn_checkout.setDisable(false);
		
		chk_HotSauce.setSelected(false);
		chk_ExtraShot.setSelected(false);
		chk_Sugar.setSelected(false);
		chk_Tapioca.setSelected(false);
		chk_Cream.setSelected(false);
		updateMiddle();
	}

	public void updateMiddle() {
		iv_hotsauce.setVisible(chk_HotSauce.isSelected());
		iv_extrashot.setVisible(chk_ExtraShot.isSelected());
		iv_sugar.setVisible(chk_Sugar.isSelected());
		lbl_tapioca.setVisible(chk_Tapioca.isSelected());
		lbl_cream.setVisible(chk_Cream.isSelected());
	}
	
}
