import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler; 
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;

import java.awt.List;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;


public class JavaFXTemplate extends Application {
	MyButton[][] arr = new MyButton[4][4];
	int[] findzero = new int[2];
	String c = new String();
	String[] a = new String[16];
	int[] corr = new int[2];
	int go = 0;
	
	//make a string arrays of string for puzzlechoice. 
	// I have decided to split all of them into rows and columns this way its easier for use to see what is going on. 
	String[][] puzzlechoice = 
			{{"2","3","4","6","7","9","10","11","12","13","14","15","","1","5","8"},
			{"4","5","7","8","10","11","13","14","15","1","2","6","9","3","","12"},
			{"","7","8","10","13","14","15","3","2","8","1","4","6","9","11","5","12"},
			{"13","14","15","","6","9","5","3","2","1","7","8","4","10","11","12"},
			{"15","13","12","9","8","7","5","1","4","","14","6","10","11","3","2"},
			{"","5","4","3","2","1","6","9","10","11","12","13","14","15","7","8"},
			{"5","6","7","9","8","10","11","13","14","15","","3","2","1","12","4"},
			{"3","4","6","7","9","10","11","12","14","15","","2","8","5","13","1"},
			{"6","4","2","8","10","11","1","5","7","9","3","14","12","13","","15"},
			{"8","9","11","12","13","15","","6","7","1","2","3","5","10","14","4"}};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to Puzzle 15");
		//Scene One the intro to the game. 
		Button starter = new Button();
		
		//Creating a Button
		//customizing the start button. 
		 Image img = new Image("Picture1.png");
	     ImageView graphic = new ImageView(img);
	      graphic.setFitHeight(80);
	      graphic.setPreserveRatio(true);
	      
	    
	      //Setting the location of the button
	      starter.setTranslateX(200);
	      starter.setTranslateY(20);
	      //Setting the size of the button
	      starter.setPrefSize(10, 10);
	      //Setting a graphic to the button
	      starter.setGraphic(graphic);
		
	      //creating a label to store in the board image
	      Label x = new Label();
	      Image img2 = new Image("Capture3.png");
		  ImageView graphic2 = new ImageView(img2);
		  graphic2.setFitHeight(650);
		  graphic2.setPreserveRatio(true);
		  x.setGraphic(graphic2);    
	      
	    //borderpane setting.       
		BorderPane border = new BorderPane();
		border.setCenter(x);
		border.setTop(starter);
		border.setStyle("-fx-background-Color:Green;");
		
			
		//Scene Two the actual game.
		//must contain a reverse button a new game button and two buttons to solve the puzzle plus a menubar.
		//be advice this scene is a lot tricky because the option they chose must reflect the grid not just printing it
		//out.Plus we must convert what ever the array of strings chosen to ints array.
		
		
		//Menu items for option button 
		MenuItem option1 = new MenuItem("A* Option One");
		MenuItem option2 = new MenuItem("A* Option Two");
		MenuItem option3 = new MenuItem("Exit");
		MenuItem option4 = new MenuItem("New Game");
		MenuItem option5 = new MenuItem("Give Up");
		
		//once option3 has been selected its time to close.
		option3.setOnAction((ActionEvent e)->{System.exit(0);});
		
		//For option1 and option2 set on actions.
		option1.setOnAction(event1);
		option2.setOnAction(event2);
		
		//list of list the manubar  is Game Menu. 
		MenuBar L1 = new MenuBar();
		L1.setTranslateX(200);
		L1.setTranslateY(200);
		
		
		Menu L2 = new Menu("A* Solver");
		Menu L3 = new Menu();
		Menu L4 = new Menu();
		
		
      //creating a label to store in for reverse
      
      Image img3 = new Image("Picture4.png");
	  ImageView graphic4 = new ImageView(img3);
	  graphic4.setFitHeight(80);
	  graphic4.setPreserveRatio(true); 
	  L3.setGraphic(graphic4);
	  
	//creating a label to store 
      Image img4 = new Image("Picture5.png");
	  ImageView graphic5 = new ImageView(img4);
	  graphic5.setFitHeight(80);
	  graphic5.setPreserveRatio(true); 
	  L4.setGraphic(graphic5);
		
		
	L2.getItems().addAll(option1,option2);
	L4.getItems().addAll(L2,option5,option3,option4);
	L1.getMenus().addAll(L3,L4);
	Group root = new Group(L1);
	
		
		BorderPane border2 = new BorderPane();
		GridPane grid = addGrid();
	
		border2.setTop(root);
		border2.setCenter(grid);
		border2.setStyle("-fx-background-Image: url(Picture6.png);");
		
		
		Scene scene2 = new Scene(border2, 1000,1000);
		primaryStage.setScene(scene2);
		primaryStage.show();
		
		//Scene three congrats for solving the puzzle.
		//must display some kind of message that states you win and ask them do you want to play again?
		//the player must either click exit button for no or new game button for yes. We can decided if the 
		//new game button goes to the first scene or just takes them back to the second scene. 
		
		BorderPane border3 = new BorderPane();
		border3.setStyle("-fx-background-Image: url(Capture.png);");
		
		
		Button exitor = new Button();
		Button new_game = new Button();
		
		  
		//making the graphic for exitor
		Image imga = new Image("Picture2.png");
		  ImageView graphica = new ImageView(imga);
		  graphica.setFitHeight(80);
		  graphica.setPreserveRatio(true); 
		  new_game.setGraphic(graphica);
		  
		//making the graphic for new_game. 
	      Image imgs = new Image("Picture3.png");
		  ImageView graphics = new ImageView(imgs);
		  graphics.setFitHeight(80);
		  graphics.setPreserveRatio(true); 
		  exitor.setGraphic(graphics);
		
		//using a VBox to store in the menus
		VBox a = new VBox();
		a.getChildren().addAll(new_game,exitor);
		
		//placing the VBox a into the borderPane
		border3.setTop(a);
				
		//exiting the game 
		exitor.setOnAction((ActionEvent e)->{System.exit(0);});
		
		Scene scene3 = new Scene(border3, 1000,1000);
		primaryStage.setScene(scene3);
		primaryStage.show();
		
		
		//Scene four you failed scene
		//Same as congrats must have would you like to play again displayed with the either an exit for no 
		// or an new game button for yes. 
		BorderPane border4 = new BorderPane();
		border4.setStyle("-fx-background-Image: url(Capture2.png);");
		
		
		Button exitor2 = new Button();
		Button new_game2 = new Button();
		
		  
		//making the graphic for exitor
		  ImageView graphica1 = new ImageView(imga);
		  graphica1.setFitHeight(80);
		  graphica1.setPreserveRatio(true); 
		  new_game2.setGraphic(graphica1);
		  
		//making the graphic for new_game. 
		  ImageView graphics1 = new ImageView(imgs);
		  graphics1.setFitHeight(80);
		  graphics1.setPreserveRatio(true); 
		  exitor2.setGraphic(graphics);
		
		//using a VBox to store in the menus
		VBox a1 = new VBox();
		a1.getChildren().addAll(new_game2,exitor2);
		
		//placing the VBox a into the borderPane
		border4.setTop(a1);
				
		//exiting the game 
		exitor2.setOnAction((ActionEvent e)->{System.exit(0);});
		
		Scene scene4 = new Scene(border4, 1000,1000);
		primaryStage.setScene(scene4);
		primaryStage.show();
		
		
		starter.setOnAction(e->primaryStage.setScene(scene2));
		
		//for scene one the starter scene
		Scene scene = new Scene(border, 700,700);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		option5.setOnAction(e->primaryStage.setScene(scene4));
		
		Thread t = new Thread(()-> {A_IDS_A_15solver ids = new A_IDS_A_15solver();});
		t.start();
		
		//set all the new games
		//if a player wins 
		new_game.setOnAction( __ ->
	    {
	    	//you would have to double click either the new_game or exit button in order for them to work. 
	    	eventa(primaryStage, new_game,scene4);
	      } );
		

		
		option4.setOnAction( __ ->
	    {
	    	arr = new MyButton[4][4];
			GridPane grid2 = addGrid();
			border2.setCenter(grid2);

			Scene scene7 = new Scene(border2, 700,700);
	        primaryStage.setScene(scene7);
	        primaryStage.show();
	      } );
		
		//if they give up.
		new_game2.setOnAction( __ ->
	    {
	    	//you would have to double click either the new_game or exit button in order for them to work.
	    	eventa(primaryStage, new_game2,scene4);
	      });

	}
	//creating the game grid. 
		public GridPane addGrid() {
			GridPane new_grid = new GridPane();
			Random rand = new Random();
			int r = rand.nextInt(10);
			int q = 0;
			
			
			//Event handler must be completed later. 
			EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					
					MyButton temp = (MyButton)e.getSource();
					int xa = GridPane.getRowIndex(temp);
					int ya = GridPane.getColumnIndex(temp);
					//System.out.println("the value for xa: " + xa+" the value for ya: "+ya);
					GameLogic head = new GameLogic(xa,ya);
					
					//creating the array that will be updated any time something gets moved 
					
					if (go == 0) {a = head.isValid(xa, ya, puzzlechoice[r]);go++;}//this is used to when the eventhandlers for solutions 1 or 2 get selected.}
					else {a = head.isValid(xa, ya, a);}
					String[][] b = new String[4][4];
					
					//corr = head.getCordinates();//stores the new location that needs to be changed on the grid
					String temp1 = arr[xa][ya].getText();
					
					int t = 0;
					
					//this will repopulate the  grid with new text changes. 
					for (int g = 0; g < 4; g++) {for(int d = 0; d < 4; d++) {arr[d][g].setText(a[t]);t++;}}
					t = 0;
					for (int g = 0; g < 4; g++) {for(int d = 0; d < 4; d++) {a[t] = arr[g][d].getText();t++;}}
					//arr[xa][ya].setText("");
					//arr[corr[0]][corr[1]].setText(temp1);
					//new_grid.add(arr[xa][ya], xa,ya);
					
				}
			};
			
			//creating grid
			for(int x = 0; x < 4; x++) {
				for(int y = 0; y < 4; y++) {
					MyButton b1 = new MyButton(x,y);
					
					// c = c + " " + puzzlechoice[r][q];
					b1.setMinSize(150,150);
					b1.setStyle("-fx-background-color:lightblue; -fx-border-color:black;");
					
					b1.setText(puzzlechoice[r][q]);q++;
					b1.setDisable(false);
					
					//this variables will help keep track on where is zero located. 
					b1.setOnAction(event);
					arr[x][y] = b1;
					new_grid.add(arr[x][y], x,y);
				}
				
			}
			
			return new_grid;
		}
		
		//Event handler must be completed later. 
		EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {}
		};
		
		//Event handler must be completed later. 
		EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {}
		};
		//Event handler must be completed later. 
		public void eventa(Stage primaryStage, Button newgame,Scene Giveup) {
		
		
			newgame.setOnAction((ActionEvent e)->{
				arr = new MyButton[4][4];
				GridPane grid2 = addGrid();
				BorderPane b4 = new BorderPane();
				b4.setCenter(grid2);
				
				//Menu items for option button 
				MenuItem option1a = new MenuItem("A* Option One");
				MenuItem option2a = new MenuItem("A* Option Two");
				MenuItem option3a = new MenuItem("Exit");
				MenuItem option4a = new MenuItem("New Game");
				MenuItem option5a = new MenuItem("Give Up");
				
				//option5a.setOnAction(e->primaryStage.setScene(Giveup));
				
				//once option3 has been selected its time to close.
				//option3a.setOnAction((ActionEvent e)->{System.exit(0);});
				
				//For option1 and option2 set on actions.
				option1a.setOnAction(event1);
				option2a.setOnAction(event2);
				
				//list of list the manubar  is Game Menu. 
				MenuBar L1a = new MenuBar();
				L1a.setTranslateX(200);
				L1a.setTranslateY(200);
				
				
				Menu L2a = new Menu("A* Solver");
				Menu L3a = new Menu();
				Menu L4a = new Menu();
				
				
				
		      //creating a label to store in for reverse
		      Image img3a = new Image("Picture4.png");
			  ImageView graphic4a = new ImageView(img3a);
			  graphic4a.setFitHeight(80);
			  graphic4a.setPreserveRatio(true); 
			  L3a.setGraphic(graphic4a);
			  
			//creating a label to store in for reverse
		      Image img4a = new Image("Picture5.png");
			  ImageView graphic5a = new ImageView(img4a);
			  graphic5a.setFitHeight(80);
			  graphic5a.setPreserveRatio(true); 
			  L4a.setGraphic(graphic5a);
				
				
			L2a.getItems().addAll(option1a,option2a);
			L4a.getItems().addAll(L2a,option5a,option3a,option4a);
			L1a.getMenus().addAll(L3a,L4a);
			Group roota = new Group(L1a);
			
			
			b4.setTop(roota);
			
			b4.setStyle("-fx-background-Image: url(Picture6.png);");
				Scene scene8 = new Scene(b4, 700,700);
		        primaryStage.setScene(scene8);
		        primaryStage.show();
			
			
			});
		}
		void drop(Stage primaryStage, Button newgame,Scene Giveup) {
				
				newgame.setOnAction(e->primaryStage.setScene(Giveup));}
			
		
		

}
