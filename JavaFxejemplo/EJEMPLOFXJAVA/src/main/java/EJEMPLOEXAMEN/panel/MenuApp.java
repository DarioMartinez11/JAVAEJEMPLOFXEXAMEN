package EJEMPLOEXAMEN.panel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;

public class MenuApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear la barra de menú
        MenuBar menuBar = new MenuBar();

        // Crear los menús
        Menu archivoMenu = new Menu("Archivo");
        MenuItem cargarItem = new MenuItem("Cargar");
        MenuItem salirItem = new MenuItem("Salir");
        archivoMenu.getItems().addAll(cargarItem, new SeparatorMenuItem(), salirItem);

        Menu componentesMenu = new Menu("Componentes");
        MenuItem tarjetasGraficasItem = new MenuItem("Tarjetas gráficas");
        MenuItem microprocesadoresItem = new MenuItem("Microprocesadores");
        MenuItem memoriaItem = new MenuItem("Memoria");
        componentesMenu.getItems().addAll(tarjetasGraficasItem, microprocesadoresItem, memoriaItem);

        Menu ayudaMenu = new Menu("Ayuda");
        MenuItem acercaDeItem = new MenuItem("Acerca de");
        MenuItem contactoItem = new MenuItem("Contacto");
        ayudaMenu.getItems().addAll(acercaDeItem, contactoItem);

        menuBar.getMenus().addAll(archivoMenu, componentesMenu, ayudaMenu);

        // Crear el TabPane
        TabPane tabPane = new TabPane();

        // Crear la pestaña para la lista de elementos
        Tab listaTab = new Tab("Lista de Elementos");
        TableView<String> tablaElementos = new TableView<>();
        listaTab.setContent(tablaElementos);

        // Crear la pestaña para el detalle de elementos
        Tab detalleTab = new Tab("Detalle");
        TextArea detalleTextArea = new TextArea();
        detalleTab.setContent(detalleTextArea);

        tabPane.getTabs().addAll(listaTab, detalleTab);

        // Crear la VBox para los componentes y los botones "Editar" y "Mostrar"
        VBox componentsBox = new VBox();
        componentsBox.getChildren().add(new Label("Nombre de los componentes"));
        Button editarButton = new Button("Editar");
        Button mostrarButton = new Button("Mostrar");
        
        // Crear el Slider
        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(50);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(25);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(10);
        
        // Crear el Label para mostrar el valor seleccionado del slider
        Label sliderValueLabel = new Label("Barra: " + slider.getValue());
        
        // Configurar el evento del slider para actualizar el Label
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            sliderValueLabel.setText("Barra: " + newValue.intValue());
        });

        componentsBox.getChildren().addAll(editarButton, mostrarButton, slider, sliderValueLabel);

        // Ajustar el tamaño del TabPane
        tabPane.setMinHeight(550);

        // Crear el diseño principal
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(tabPane);
        root.setLeft(componentsBox); // Agregar la VBox a la izquierda

        // Configurar el evento del botón "Editar"
        editarButton.setOnAction(e -> {
            // Crear una nueva pestaña para el formulario
            Tab formularioTab = new Tab("Editar");
            // Crear y agregar el formulario al contenido de la pestaña
            VBox formularioVBox = new VBox();
            formularioVBox.getChildren().add(new Label("Formulario de edición"));
            formularioTab.setContent(formularioVBox);
            // Agregar la nueva pestaña al TabPane
            tabPane.getTabs().add(formularioTab);
            // Seleccionar la nueva pestaña
            tabPane.getSelectionModel().select(formularioTab);
        });

        // Configurar el evento del botón "Mostrar"
        mostrarButton.setOnAction(e -> {
            // Crear una nueva ventana emergente
            Stage popupStage = new Stage();
            popupStage.setTitle("Datos del componente editado");

            // Crear y configurar un Label con los datos del componente editado
            Label datosLabel = new Label("Datos del componente editado...");
            datosLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: blue;");

            // Configurar la escena de la ventana emergente
            VBox popupRoot = new VBox(datosLabel);
            Scene popupScene = new Scene(popupRoot, 400, 300);

            // Configurar la ventana emergente
            popupStage.initOwner(primaryStage); // Hacer que la ventana emergente sea modal
            popupStage.setScene(popupScene);
            popupStage.show();
        });

        // Configurar el evento del menú "Salir"
        salirItem.setOnAction(e -> primaryStage.close());

        // Configurar el evento del menú "Cargar"
        cargarItem.setOnAction(e -> {
            // Aquí se cargarían los componentes
            System.out.println("Cargando componentes...");
        });

        // Configurar los eventos de los menús de componentes
        tarjetasGraficasItem.setOnAction(e -> {
            // Aquí se filtrarían y mostrarían solo las tarjetas gráficas
            System.out.println("Mostrar tarjetas gráficas");
        });

        microprocesadoresItem.setOnAction(e -> {
            // Aquí se filtrarían y mostrarían solo los microprocesadores
            System.out.println("Mostrar microprocesadores");
        });

        memoriaItem.setOnAction(e -> {
            // Aquí se filtrarían y mostrarían solo las memorias
            System.out.println("Mostrar memorias");
        });

        // Configurar la escena
        Scene scene = new Scene(root, 800, 600);

        // Configurar el escenario
        primaryStage.setTitle("Aplicación con Barra de Menú y Pestañas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
