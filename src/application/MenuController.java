package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import util.CompilerController;

public class MenuController implements Initializable {
	// Controller da tela de interação com o usuário.
	@FXML
	MenuBar menuBar = new MenuBar();
	@FXML
	Menu menuFile = new Menu();
	@FXML
	MenuItem menuItemNew = new MenuItem();
	@FXML
	MenuItem menuItemOpen = new MenuItem();
	@FXML
	MenuItem menuItemSave = new MenuItem();
	@FXML
	MenuItem menuItemClose = new MenuItem();
	@FXML
	Menu menuTools = new Menu();
	@FXML
	MenuItem menuItemCompile = new MenuItem();
	@FXML
	MenuItem menuItemSaveAndCompile = new MenuItem();
	@FXML
	MenuItem menuItemDebug = new MenuItem();
	@FXML
	TabPane tabPanePrograms = new TabPane();
	@FXML
	TabPane tabPaneInformation = new TabPane();
	@FXML
	Tab tabLog = new Tab();
	@FXML
	AnchorPane anchorPaneLog = new AnchorPane();
	@FXML
	ListView<String> listViewLog = new ListView<String>();
	@FXML
	Tab tabConsole = new Tab();
	@FXML
	AnchorPane anchorPaneConsole = new AnchorPane();
	@FXML
	ListView<String> listViewConsole = new ListView<String>();
	@FXML
	Tab tabDebug = new Tab();
	@FXML
	AnchorPane anchorDebug = new AnchorPane();
	@FXML
<<<<<<< HEAD
	ListView<String> listViewDebug = new ListView<String>();
=======
	ListView listViewDebug = new ListView();
	int newFileCounter;
>>>>>>> origin/master

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	// Seleciona um arquivo do tipo .lalg para reproduzir visualmente.
	@FXML
	public void menuOpenOnAction() {
		File file;
		FileChooser fileChooser = new FileChooser();
		ExtensionFilter extentFilter = new FileChooser.ExtensionFilter("Linguagem LALG", "*.lalg");
		fileChooser.setTitle("LALG");
		fileChooser.getExtensionFilters().add(extentFilter);
		file = fileChooser.showOpenDialog(null);

		if (file != null) {
			TextArea textArea;
			Tab tab;

			textArea = new TextArea();

			tab = new Tab();

			textArea.setOnKeyPressed(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					if (!tab.getText().contains("*")) {
<<<<<<< HEAD
						String aux = tab.getText();//TÁ USANDO ESSA MERDA?
						// tab.setText("*" + aux);
=======
						String aux = tab.getText();
						tab.setText("*" + aux);
>>>>>>> origin/master
					}
				}

			});

			tab.setId(file.toString());
			tab.setText(file.getName());
			tab.setContent(textArea);
			tab.setClosable(true);
			tab.setOnCloseRequest(new EventHandler<Event>() {
				@Override
				public void handle(Event t) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setHeaderText("This file could've been changed.");
					alert.setContentText("Would you like to save " + "changes?");

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						try {
							FileWriter fileWriter = new FileWriter(file);
							fileWriter.write(textArea.getText());
							fileWriter.close();
						} catch (IOException ex) {
						}
					} else {
						t.consume();
					}
				}
			});

			this.tabPanePrograms.getTabs().add(tab);
			this.tabPanePrograms.getSelectionModel().select(tab);
			this.tabPanePrograms.setTabClosingPolicy(TabClosingPolicy.SELECTED_TAB);

			try {
				textArea.setText(new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// novo programa
	@FXML
	public void menuNewOnAction() {
		TextArea textArea;
		Tab tab;

		textArea = new TextArea();
		textArea.setId("newTextArea");

		tab = new Tab();
		tab.setText("*New File "+ ++newFileCounter+".lalg");
		tab.setId("0");
		tab.setContent(textArea);
		tab.setClosable(true);
		tab.setOnCloseRequest(new EventHandler<Event>() {
			@Override
			public void handle(Event t) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText("This file could've been changed.");
				alert.setContentText("Would you like to save " + "changes?");

				// Optional<ButtonType> result = alert.showAndWait();
				// if (result.get() == ButtonType.OK) {
				// try {
				// FileWriter fileWriter = new FileWriter(file);
				// fileWriter.write(textArea.getText());
				// fileWriter.close();
				// } catch (IOException ex) {
				// }
				// } else {
				// t.consume();
				// }
			}
		});

		this.tabPanePrograms.getTabs().add(tab);
		this.tabPanePrograms.getSelectionModel().select(tab);
		this.tabPanePrograms.setTabClosingPolicy(TabClosingPolicy.SELECTED_TAB);

		textArea.setText("");

	}

	// Salvar arquivo
	public void menuSaveOnAction() {
		
		TextArea textArea = (TextArea) this.tabPanePrograms.
				getSelectionModel().getSelectedItem().getContent();
		//TA USANDO ESSA MERDA DE CIMA TB??

		File file = new File(this.tabPanePrograms.getSelectionModel().getSelectedItem().getId());
		
		if (!this.tabPanePrograms.getSelectionModel().getSelectedItem().getId().equals("0")) {
			FileWriter fileWriter;
			try {
				fileWriter = new FileWriter(file);
				fileWriter.write(textArea.getText());
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		
		else{

			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("LALG files (*.lalg)", "*.lalg");
			fileChooser.setInitialFileName(this.tabPanePrograms.getSelectionModel().getSelectedItem().getText().substring(1));
			fileChooser.getExtensionFilters().add(extFilter);
			file = fileChooser.showSaveDialog(null);
			
			FileWriter fileWriter;

			try {
				fileWriter = new FileWriter(file);
				fileWriter.write(textArea.getText());
				fileWriter.close();
			} catch (IOException ex) {
			}
		}
		this.tabPanePrograms.getSelectionModel().getSelectedItem().setText(file.getName());
		this.tabPanePrograms.getSelectionModel().getSelectedItem().setId(file.toString());
	}

	// fecha o programa.
	@FXML
	public void menuCloseOnAction() {
		Platform.exit();
	}
	
	@FXML
	public void menuCompileOnAction(){
		TextArea textArea = (TextArea)this.tabPanePrograms.
			getSelectionModel().getSelectedItem().getContent();
		List<String> tokens = CompilerController.getInstance().
				getTokens(textArea.getText());
		ObservableList<String> observableListTokens;
		observableListTokens = FXCollections.observableArrayList();
		observableListTokens.addAll(tokens);
		listViewConsole.setItems(observableListTokens);
	}
}