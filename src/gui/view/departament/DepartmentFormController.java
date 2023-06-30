package gui.view.departament;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constrains;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable{
	
	private Department entity;
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private Label msgError;
	
	@FXML
	private Button btnSave;
	
	@FXML
	private Button btnCancel;
	
	public void onSaveAction() {
		System.out.println("Save");
	}
	
	public void onCancelAction() {
		System.out.println("Cancel");		
	}	
	
	public void setDepartment(Department entity) {
		this.entity = entity;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeNodes();
		
	}
	
	private void initializeNodes() {
		Constrains.setTextFieldInteger(txtId);
		Constrains.setTextFieldMaxLength(txtName, 30);
	}
	
	public void updateFormdata() {
		if(entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}

}
