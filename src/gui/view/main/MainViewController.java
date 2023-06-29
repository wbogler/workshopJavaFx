package gui.view.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import gui.view.departament.DepartamentListController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.service.DepartamentService;

public class MainViewController implements Initializable{
	
	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartament;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onSellerAction");
	}
	
	@FXML
	public void onMenuItemDepartamentAction() {
		loadView("/gui/view/departament/DepartamentView.fxml", (DepartamentListController controller) ->{
			controller.setDepartmentService(new DepartamentService());
			controller.updateTableView();
		});
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/view/about/AboutView.fxml", x -> {});
	}
	

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
	}
	
	private synchronized <T> void loadView(String absolutename, Consumer<T> initializarConsumer) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutename));
			VBox newVbox = loader.load();
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox)((ScrollPane) mainScene.getRoot()).getContent();
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVbox.getChildren());
			
			T controller = loader.getController();
			initializarConsumer.accept(controller);
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(),AlertType.ERROR);
		}
	}

}
