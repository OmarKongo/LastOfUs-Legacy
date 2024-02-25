package view;




import java.awt.Point;
import java.util.ArrayList;













import model.characters.Character;
import model.characters.Hero;
import model.characters.Zombie;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.Cell;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;
import model.characters.*;

import com.sun.prism.paint.Color;

import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GameGUI extends Application implements EventHandler<ActionEvent>{
	private int HeroID;
	Hero hero=null;
	Image icon =new Image("/images/logo2.jpg");
	Image cover=new Image("/images/c6.jpg");
	Image BILL = new Image("/images/BILL.png");  
	Image BILLF = new Image("/images/BILL F.png");
	Image DAVID = new Image("/images/DAVID.png");
	Image DAVIDF = new Image("/images/DAVID F.png");
	Image ELLIE = new Image("/images/ELLIE WILLIAMS.png");
	Image ELLIEF = new Image("/images/ELLIE WILLIAMS F.png");
	Image HENRY = new Image("/images/HENRY BURELL.png");
	Image HENRYF = new Image("/images/HENRY BURELL F.png");  
	Image JOEL = new Image("/images/JOEL MILLER .png");
	Image JOELF = new Image("/images/JOEL MILLER F.png");
	Image RILEY = new Image("/images/RILEY ABEL.png");
	Image RILEYF = new Image("/images/RILEY ABEL F.png");
	Image TESS = new Image("/images/TESS.png");
	Image TESSF = new Image("/images/TESS F.png");
	Image TOMMY = new Image("/images/TOMMY MILLER.png");
	Image TOMMYF = new Image("/images/TOMMY MILLER F.png");
	Image cover2=new Image("/images/c2.jpg");
	Image cover3=new Image("/images/c3.jpg");
	//////////
	Image BILLS = new Image("/images/BILLS.png");
	Image DAVIDS = new Image("/images/DAVIDS.png");
	Image ELLIES = new Image("/images/ELLIES.png");	
	Image HENRYS = new Image("/images/HENRYS.png"); 
	Image JOELS = new Image("/images/JOELS.png");
	Image RILEYS = new Image("/images/RILEYS.png");
	Image TESSS = new Image("/images/TESSS.png");
	Image TOMMYS = new Image("/images/TOMMYS.png");
	
	/////////
	ImageView iv10 = new ImageView(JOELS);
	ImageView iv11 = new ImageView(ELLIES);
	ImageView iv12 = new ImageView(TESSS);	
	ImageView iv13 = new ImageView(RILEYS); 
	ImageView iv14=  new ImageView(TOMMYS);
	ImageView iv15 = new ImageView(BILLS);
	ImageView iv16 = new ImageView(DAVIDS);
	ImageView iv17 = new ImageView(HENRYS);
	ImageView selectedHero=new ImageView(new Image("/images/selected.jpg"));
	
	boolean flag=false;boolean flag2=false;
	ToggleGroup TG=new ToggleGroup();
	Group g=new Group();
	/////
	boolean lock=false;
	ArrayList<HeroButton> HBS=new ArrayList<HeroButton>();
	ArrayList<heroID> HeroButtons=new ArrayList<heroID>();
	ArrayList<Button> nearbyButtons =new ArrayList<Button>();
	Image emptyCellImage = new Image("/images/empty.jpeg");//(assume m3aya swr)
	Image emptyCellVisibleImage = new Image("/images/VisibleEmptyCell.jpeg");
	Image heroImage = new Image("/images/EllieP.png");
	Image zombieImage = new Image("/images/Zombie.jpeg");
	Image vaccineImage = new Image("/images/vaccine.jpg");
	Image supplyImage = new Image("/images/supply.jpg");
	GridPane gridPane = new GridPane();
	ArrayList <Hero> gg=Game.availableHeroes;
	Button [][]buttonsArray=new Button[15][15];
	
	/////heros' faces
	Image JoelP=new Image("/images/JoelP.png");Image TommyP=new Image("/images/TommyP.png");
	Image EllieP=new Image("/images/EllieP.png");Image BillP=new Image("/images/billP.png");
	Image TessP=new Image("/images/TessP.png");Image DavidP=new Image("/images/DavidP.png");
	Image RileyP=new Image("/images/RileyP.png");Image HenryP=new Image("/images/HenryP.png");

	private Button button;
     ImageView close=new ImageView("/images/stop.png");
	public Stage window; Scene scene1,scene2,scene3;
	Button b=new Button("PLAY");

	ImageView cure =new ImageView("/images/cure.png");
	ImageView attack=new ImageView("/images/Attack.png");
	ImageView useSpecial=new ImageView("/images/Special.png");
	ImageView endTurn =new ImageView("/images/End .png");
	DropShadow shadow = new DropShadow();
	Label name=new Label("");
	Label type=new Label("");
	Label Hp=new Label("");
	Label AttackDmg=new Label("");
	Label Actions=new Label("");
	Label supp=new Label("");
	Label vacc=new Label("");
	
	 
   
	public static void main(String[]args){	
		launch(args);

	}
	Cell[][] board =Game.map;
//	public void addMap(){
//		
//		for(int i=0;i<15;i++){
//			int x=14;
//			for(int j=14;j>=0;j--){
//				
//			   board[x--][j]=Game.map[i][j];
//			 //System.out.print(board[14-j][i]+" //"+"("+i+" "+(14-i)+"//");
//			   
//			}
//		}
//	}


	@Override
	public void start(Stage stage) throws Exception {
		System.out.print(2);
		window=stage;
		Group sp=new Group();
		
		// cover2.setFitHeight(1000);cover2.setFitWidth(1500);
		//cover2.fitHeightProperty().bind(stage.heightProperty());
		//cover2.fitWidthProperty().bind(stage.widthProperty());
		ImageView ivC= new ImageView(cover);
		ImageView ivv= new ImageView(new Image("/images/TEXTC.png"));
		sp.getChildren().addAll(ivC,b,ivv);
		ivC.fitHeightProperty().bind(stage.heightProperty());
		ivC.fitWidthProperty().bind(stage.widthProperty());
		//  ivC.setFitWidth(1500);
		Scene scene1 =new Scene(sp,1500,900);
		
		stage.setTitle("Last of Us - Legacy");
		stage.getIcons().add(icon);

		//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		// ImageView iv=new ImageView(img);


      //  window.setOnCloseRequest(e -> closeProgram());
		//b.setMinSize(200,100);
		b.setPrefSize(200,50);
		//b.setWrapText(false);
		b.setStyle("-fx-background-color: PeachPuff");
		b.setStyle("-fx-base: mistyrose;");
		b.setFont(new Font(40));
		//StackPane.setAlignment(b,Pos.BOTTOM_RIGHT);
		b.setAlignment(Pos.CENTER);
		b.setLayoutX(700);
		b.setLayoutY(500);
		ivv.setLayoutX(450);
		ivv.setLayoutY(300);
		b.setMaxSize(200,50);


		b.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				b.setStyle("-fx-background-color: MediumTurquoise");
				b.setEffect(shadow);
			}
		});
		/*  b.addEventHandler(MouseEvent.MOUSE_CLICKED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			        	  //b.setStyle("-fx-background-color: MediumTurquoise");
			            //b.setEffect(shadow);
			          System.out.print(2);
			          }
			        });*/
		b.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				b.setStyle("-fx-background-color: PeachPuff");
				b.setEffect(null);
			}
		});

		
		stage.setScene(scene1);
		stage.show();
		/////////////////SCENE 2
		/////////////////////////////////////////////////////
		//////////////////////////////////////////////////////

		//GridPane root = new GridPane();
		//root.getChildren().add(cover2);
        StackPane cc=new StackPane();
        
		// TODO Auto-generated method stub  
		BackgroundImage bImg = new BackgroundImage(cover2,
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		Background bGround = new Background(bImg);
		ImageView ic =new ImageView(cover2);
		cc.getChildren().add(ic);
		ic.fitWidthProperty().bind(window.widthProperty());;
		ic.fitHeightProperty().bind(window.heightProperty());
		//ic.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
		//g.getChildren().add(cc);
        Group g2=new Group();
        ImageView c=new ImageView(cover2);
        g2.getChildren().add(c);
        c.fitWidthProperty().bind(stage.widthProperty());
        c.fitHeightProperty().bind(stage.heightProperty());
		ImageView HeroChosen =new ImageView();
		ImageView Entry=new ImageView(new Image("/images/entry2.jpg"));
		//Entry.setLayoutX(800);Entry.setLayoutY(700);;
		//g2.getChildren().add(Entry);
		Entry.setLayoutX(1150);Entry.setLayoutY(300);
		HeroChosen.setLayoutX(1160);HeroChosen.setLayoutY(400);;
		//g2.getChildren().add(root);
		ImageView select= new ImageView("/images/selectHero.png");
		select.setLayoutX(1200);select.setLayoutY(100);
	//	root.setHgap(40);
		//root.setVgap(30);
		//select.setPrefSize(200,200);
		//select.setFont(new Font(20));
		//select.setMaxSize(220,220);

		//HeroChosen.setLayoutX(700);HeroChosen.setLayoutY(100);

		//  ((HBox) root).setSpacing(40);
		// Button b=new Button();
    
		// b.setPrefSize(50,50);
		// b.setMaxSize(30,30);
		ImageView iv1=new ImageView(BILL);
	 iv1.setLayoutX(300);iv1.setLayoutY(-50);
		ImageView iv2=new ImageView(DAVID);
		iv2.setLayoutX(280);iv2.setLayoutY(300);
		ImageView iv3=new ImageView(ELLIE);
		iv3.setLayoutX(850);iv3.setLayoutY(50);

		ImageView iv4=new ImageView(HENRY);
		iv4.setLayoutX(1);iv4.setLayoutY(400);
		ImageView iv5=new ImageView(JOEL);
		iv5.setLayoutX(555);iv5.setLayoutY(300);
		ImageView iv6=new ImageView(RILEY);
		iv6.setLayoutX(840);iv6.setLayoutY(300);
		ImageView iv7=new ImageView(TESS);
		iv7.setLayoutX(10);iv7.setLayoutY(50);
		ImageView iv8=new ImageView(TOMMY);
		iv8.setLayoutX(590);iv8.setLayoutY(50);

         g2.getChildren().addAll(iv1,iv2,iv3,iv4,iv5,iv6,iv7,Entry,select,iv8,HeroChosen);
		//root.setMaxSize(100,100);
		//Game.loadHeroes("Heroes.csv");
		select.setDisable(true);

		iv1.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				//b.setStyle("-fx-background-color: MediumTurquoise");
				//b.setEffect(shadow);
				HeroChosen.setImage(BILLF);
				select.setDisable(false);
				flag=true;
				HeroID=5;
			}
		});
		iv1.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				//b.setStyle("-fx-background-color: MediumTurquoise");
				//b.setEffect(shadow);
				iv1.setImage(new Image("/images/BILL F.png"));
				//System.out.print(2);
			}
		});

		iv1.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				//b.setStyle("-fx-background-color: MediumTurquoise");
				//b.setEffect(shadow);
				iv1.setImage(new Image("/images/BILL.png"));
				//System.out.print(2);
			}
		});


		iv2.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				//b.setStyle("-fx-background-color: MediumTurquoise");
				//b.setEffect(shadow);
				HeroChosen.setImage(DAVIDF);
				select.setDisable(false);
				flag=true;
				HeroID=6;
			}
		});
		iv2.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				//b.setStyle("-fx-background-color: MediumTurquoise");
				//b.setEffect(shadow);
				iv2.setImage(new Image("/images/DAVID F.png"));
				//System.out.print(2);
			}
		});

		iv2.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				//b.setStyle("-fx-background-color: MediumTurquoise");
				//b.setEffect(shadow);
				iv2.setImage(new Image("/images/DAVID.png"));
				//System.out.print(2);
			}
		});



		iv3.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				HeroChosen.setImage(ELLIEF);
				select.setDisable(false);
				flag=true;
				HeroID=1;

			}
		});
		iv3.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				iv3.setImage(new Image("/images/ELLIE WILLIAMS F.png"));

			}
		});

		iv3.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				iv3.setImage(new Image("/images/ELLIE WILLIAMS.png"));

			}
		});


		iv4.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				HeroChosen.setImage(HENRYF);
				select.setDisable(false);
				flag=true;
				HeroID=7;
			}
		});
		iv4.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				iv4.setImage(new Image("/images/HENRY BURELL F.png"));

			}
		});

		iv4.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				iv4.setImage(new Image("/images/HENRY BURELL.png"));

			}
		});



		iv5.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				HeroChosen.setImage(JOELF);
				select.setDisable(false);
				flag=true;
				HeroID=0;
			}
		});
		iv5.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				iv5.setImage(new Image("/images/JOEL MILLER F.png"));

			}
		});

		iv5.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				iv5.setImage(new Image("/images/JOEL MILLER .png"));

			}
		});



		iv6.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				HeroChosen.setImage(RILEYF);
				select.setDisable(false);
				flag=true;
				HeroID=3;
			}
		});
		iv6.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				iv6.setImage(new Image("/images/RILEY ABEL F.png"));

			}
		});

		iv6.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				iv6.setImage(new Image("/images/RILEY ABEL.png"));

			}
		});



		iv7.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				HeroChosen.setImage(TESSF);
				select.setDisable(false);
				flag=true;
				HeroID=2;
			}
		});
		iv7.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				iv7.setImage(new Image("/images/TESS F.png"));

			}
		});

		iv7.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				iv7.setImage(new Image("/images/TESS.png"));

			}
		});



		iv8.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				HeroChosen.setImage(TOMMYF);
				select.setDisable(false);
				flag=true;
				HeroID=4;

			}
		});
		iv8.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				iv8.setImage(new Image("/images/TOMMY MILLER F.png"));

			}
		});

		iv8.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				iv8.setImage(new Image("/images/TOMMY MILLER.png"));

			}
		});
		Scene scene2 = new Scene(g2,1500,900); 
		;
		b.setOnAction(e -> window.setScene(scene2));

         

        close.setLayoutX(1350);
        close.setLayoutY(20);
        //close.setPrefSize(100,50);
        close.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				window.close();

			}
		});
        ImageView c2=new ImageView(cover3);
        g.getChildren().add(c2);
        c2.fitWidthProperty().bind(stage.widthProperty());
        c2.fitHeightProperty().bind(stage.heightProperty());
        g.getChildren().add(close);
        //close.setDisable(true);
		useSpecial.setDisable(true);
		cure.setDisable(true);
		attack.setDisable(true);
		endTurn.setDisable(true);
		g.getChildren().addAll(iv10,iv11,iv12,iv13,iv14,iv15,iv16,iv17,selectedHero);
		g.getChildren().addAll(name,type,Hp,AttackDmg,Actions,supp,vacc);
		iv10.setLayoutX(1320);iv10.setLayoutY(300);
		iv17.setLayoutX(1160);iv17.setLayoutY(300);
		iv11.setLayoutX(1320);iv11.setLayoutY(490);
		iv16.setLayoutX(1160);iv16.setLayoutY(490);
		iv12.setLayoutX(1320);iv12.setLayoutY(680);
		iv15.setLayoutX(1160);iv15.setLayoutY(680);
		iv13.setLayoutX(1320);iv13.setLayoutY(110);
		iv14.setLayoutX(1160);iv14.setLayoutY(110);
		selectedHero.setLayoutX(935);selectedHero.setLayoutY(500);
	//	((Region) useSpecial).setPrefSize(140,100);
		useSpecial.setLayoutX(950);useSpecial.setLayoutY(100);g.getChildren().add(useSpecial);
		//attack.setPrefSize(50,50);
		attack.setLayoutX(980);
		attack.setLayoutY(300);
		g.getChildren().add(attack);
		//cure.setPrefSize(50,50);
     //   cure.setStyle();
		//endTurn.setPrefSize(50,50);
		endTurn.setLayoutX(970);
		endTurn.setLayoutY(200);
	     //root.setTranslateX(150);
	     //root.setTranslateY(100);
	     
		g.getChildren().add(endTurn);
		//cure.setAlignment(Pos.TOP_LEFT);
		gridPane.setAlignment(Pos.CENTER_LEFT);
		g.getChildren().add(cure);
		cure.setLayoutX(985);
		//gridPane.setTranslateX(30);
		cure.setLayoutY(400);
		//gridPane.setMaxSize(500,500);
		g.getChildren().add(gridPane);
	     
		Scene scene3 = new Scene(g,1500,900);

          //window.g
		// gridPane.add(cure,0,4);
		select.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				setID();
				
				Hero hero=Game.availableHeroes.get(HeroID);
				Game.startGame(hero);
				addButtons();
			//	addMap();
				//TG.getToggles().add(button);
				
				name.setText("Name : "+hero.getName());name.setLayoutX(970);name.setLayoutY(540);name.setTextFill(javafx.scene.paint.Color.WHITESMOKE);
				type.setText("Type : "+hero.getClass().getSimpleName());type.setLayoutX(970);type.setLayoutY(560);type.setTextFill(javafx.scene.paint.Color.WHITESMOKE);
				Hp.setText("CurrentHp : "+hero.getCurrentHp());Hp.setLayoutX(970);Hp.setLayoutY(660);Hp.setTextFill(javafx.scene.paint.Color.WHITESMOKE);
				AttackDmg.setText("AttackDmg : "+hero.getAttackDmg());AttackDmg.setLayoutX(970);AttackDmg.setLayoutY(580);AttackDmg.setTextFill(javafx.scene.paint.Color.WHITESMOKE);
				Actions.setText("Actions Available : "+hero.getActionsAvailable());Actions.setLayoutX(970);Actions.setLayoutY(600);Actions.setTextFill(javafx.scene.paint.Color.WHITESMOKE);
				supp.setText("Supplies : " +hero.getSupplyInventory().size());supp.setLayoutX(970);supp.setLayoutY(620);supp.setTextFill(javafx.scene.paint.Color.WHITESMOKE);
				vacc.setText("Vaccines : "+hero.getVaccineInventory().size());vacc.setLayoutX(970);vacc.setLayoutY(640);vacc.setTextFill(javafx.scene.paint.Color.WHITESMOKE);
				SetAvailable();
				//updateMap();
                  // updateNearbyButtons();
				window.setScene(scene3);	  

			}
		});


		// select.setOnAction(e -> window.setScene(scene3));	
		////////////////////////////////////////////////////
		/////////////////////////////////////////////////////
		///////////////////////////// SCENE 3
		gridPane.setAlignment(Pos.CENTER);
		Image img=new Image("/images/empty.jpeg");
          //gridPane.setLayoutX(70);gridPane.setLayoutY(0);
		//gridPane.setMaxSize(150,150);
		Game.loadHeroes("Heroes.csv");
		g.getChildren().add(l);
		//          button.addEventHandler(MouseEvent.MOUSE_CLICKED,
		//        	        new EventHandler<MouseEvent>() {
		//        	          @Override
		//        	          public void handle(MouseEvent e) {
		//        	        	  
		//        	        	  button.setSelected(true);
		//        	          }
		//        	        });
		//         
		//Button attack=new Button("Attack");
		//addB.getChildren().add(attack);
		//attack.setAlignment(Pos.CENTER_LEFT);
		// attack.setPrefSize(100,100);
		//attack.setFont();
		//gridPane.setAlignment(Pos.CENTER);
		//int x = 0,y=0;
		// ImageView iv=new ImageView();
		// Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds(); 
	      //  stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);  
	        //stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 4);   
		//gridPane.setMinSize(500,500);
        iv1.setTranslateY(100);
        iv2.setTranslateY(100);
        iv5.setTranslateY(100);
        iv6.setTranslateY(100);
       // gridPane.setTranslateX(80);
      // gridPane.setTranslateY(80);

		cure.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				// Hero h=getHero(HB,button);
				setTarget(h);

				//updateMap();
				// h.getVaccineInventory().add(new Vaccine());
				try {
					//updateMap();
					h.cure();
					updateMap();
					if(h!=null){
					name.setText("Name : "+h.getName());
					type.setText("Type : "+h.getClass().getSimpleName());
					Hp.setText("CurrentHp : "+h.getCurrentHp());
					Actions.setText("Actions Available : "+h.getActionsAvailable());
					supp.setText("Supplies : " +h.getSupplyInventory().size());
					vacc.setText("Vaccines : "+h.getVaccineInventory().size());

					AttackDmg.setText("AttackDmg : "+h.getAttackDmg());
					}
					//useSpecial.setDisable(true);
					//attack.setDisable(true);
					//cure.setDisable(true);
					//endTurn.setDisable(true);
					//System.out.print(Game.checkWin());

				} catch (NoAvailableResourcesException e1) {
					AlertBox.display("exception","No resources");
				} catch (InvalidTargetException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					AlertBox.display("exception","invalid");
				} catch (NotEnoughActionsException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					AlertBox.display("exception","actions");
				}
				if(Game.checkWin()){
					AlertBox.display("Congrats","You Won!!!!!!!!");
					 close.setDisable(false);
						useSpecial.setDisable(true);
						cure.setDisable(true);
						attack.setDisable(true);
						endTurn.setDisable(true);
						lock=true;
				}
				else
					if(Game.checkGameOver()){
						if(h!=null && h.getCurrentHp()==0)
							updateMap();
					AlertBox.display("Game Over","You LOST ):");
					close.setDisable(false);
					useSpecial.setDisable(true);
					cure.setDisable(true);
					attack.setDisable(true);
					endTurn.setDisable(true);
					lock=true;
					
				}
				flag2=true;
				if(h!=null && h.getCurrentHp()==0)
					updateMap();
				
				//updateMap();
				//updateVisibleCells();
				//System.out.print(Game.checkWin());
			}
		});

		attack.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				// Hero h=getHero(HB,button);
				setTarget(h);

				//updateMap();
				//h.getVaccineInventory().add(new Vaccine());
				try {
					//updateMap();
					h.attack();
					updateMap();
					if(h!=null){
					name.setText("Name : "+h.getName());
					type.setText("Type : "+h.getClass().getSimpleName());
					Hp.setText("CurrentHp : "+h.getCurrentHp());
					Actions.setText("Actions Available : "+h.getActionsAvailable());
					supp.setText("Supplies : " +h.getSupplyInventory().size());
					vacc.setText("Vaccines : "+h.getVaccineInventory().size());

					AttackDmg.setText("AttackDmg : "+h.getAttackDmg());
					}
					//System.out.print(Game.checkWin());

				} catch (NotEnoughActionsException e1) {
					AlertBox.display("Exception","Not Enough Actions");
				} catch (InvalidTargetException e1) {
					AlertBox.display("Exception",e1.getMessage());
				}
				if(Game.checkWin()){
					AlertBox.display("Congrats","You Won!!!!!!!!");
					 close.setDisable(false);
						useSpecial.setDisable(true);
						cure.setDisable(true);
						attack.setDisable(true);
						endTurn.setDisable(true);
						lock=true;
				}
				else if(Game.checkGameOver()){
					if(h!=null && h.getCurrentHp()==0)
						updateMap();
					AlertBox.display("Game Over","You LOST ):");
					close.setDisable(false);
					useSpecial.setDisable(true);
					cure.setDisable(true);
					attack.setDisable(true);
					endTurn.setDisable(true);
					lock=true;
					
				}
				if(h!=null && h.getCurrentHp()==0)
					updateMap();
				//updateVisibleCells();
			}
		});
		useSpecial.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if(h instanceof Medic)
					getCharAdjcent2(h);
				
				try {
					//updateMap();
					h.useSpecial();
					updateMap();
					if(h!=null){
						
					name.setText("Name : "+h.getName());
					type.setText("Type : "+h.getClass().getSimpleName());
					Hp.setText("CurrentHp : "+h.getCurrentHp());
					Actions.setText("Actions Available : "+h.getActionsAvailable());
					supp.setText("Supplies : " +h.getSupplyInventory().size());
					vacc.setText("Vaccines : "+h.getVaccineInventory().size());

					AttackDmg.setText("AttackDmg : "+h.getAttackDmg());
					}if(Game.checkWin()){
						AlertBox.display("Congrats","You Won!!!!!!!!");
						 close.setDisable(false);
							useSpecial.setDisable(true);
							cure.setDisable(true);
							attack.setDisable(true);
							endTurn.setDisable(true);
							lock=true;
					}
					else	if(Game.checkGameOver()){
						if(h!=null && h.getCurrentHp()==0)
							updateMap();
						AlertBox.display("Game Over","You LOST ):");
						close.setDisable(false);
						useSpecial.setDisable(true);
						cure.setDisable(true);
						attack.setDisable(true);
						endTurn.setDisable(true);
						lock=true;
						
					}
					System.out.print(Game.checkWin());
				} catch (NoAvailableResourcesException e1) {
					AlertBox.display("exception","No Available Rescources Exception");
				} catch (InvalidTargetException e1) {
					AlertBox.display("exception","Invalid target");

				}
				if(h!=null && h.getCurrentHp()==0)
					updateMap();
			//,	updateMap();
			}
		});

		endTurn.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				// Hero h=getHero(HB,button);
				//setTarget(h);

				//updateMap();
				//h.getVaccineInventory().add(new Vaccine());
				try {
					Game.endTurn();
					updateMap();
					if(Game.checkWin()){
						AlertBox.display("Congrats","You Won!!!!!!!!");
						 close.setDisable(false);
							useSpecial.setDisable(true);
							cure.setDisable(true);
							attack.setDisable(true);
							endTurn.setDisable(true);
							lock=true;
					}
					else if(Game.checkGameOver()){
						AlertBox.display("Game Over","You LOST ):");
						close.setDisable(false);
						useSpecial.setDisable(true);
						cure.setDisable(true);
						attack.setDisable(true);
						endTurn.setDisable(true);
					}
					
					//updateMap();
					if(h!=null){
					name.setText("Name : "+h.getName());
					type.setText("Type : "+h.getClass().getSimpleName());
					Hp.setText("CurrentHp : "+h.getCurrentHp());
					Actions.setText("Actions Available : "+h.getActionsAvailable());
					supp.setText("Supplies : " +h.getSupplyInventory().size());
					vacc.setText("Vaccines : "+h.getVaccineInventory().size());

					AttackDmg.setText("AttackDmg : "+h.getAttackDmg());
					}
					//System.out.print(Game.checkWin());

				} catch (NotEnoughActionsException e1) {
					AlertBox.display("Exception","Not Enough Actions");
				} catch (InvalidTargetException e1) {
					AlertBox.display("Exception","Invalid attack");
				}


				if(h!=null && h.getCurrentHp()==0)
					updateMap();
			}
		});



	}
	public boolean  exist(Hero h){
		for(int i=0;i<HBS.size();i++){
			Hero x=HBS.get(i).getHero();
			if(x.getName().equals(h.getName()))
				return true;
		}
		return false;
		
	}
	Button s;
	public void addButtons(){
		
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				//button = new Button("");
				ImageView imageView = new ImageView(emptyCellImage);
				 s=new Button("");
			//	s.setMaxSize(40,40);
				//board[i][j]=Game.map[i][j];
				 //System.out.print("("+i+" "+j+" ");
				Cell cell = board[i][j];
                //Button BS=buttonsArray[i][j];
                //s.setMaxSize(60,60);
				 s.setMinWidth(50);s.setPrefWidth(60);
	   	           s.setMinHeight(50);s.setPrefHeight(60);
	   	        imageView.setImage(emptyCellImage);
	           	
				
				s.setOnKeyPressed(keyPressed);

				


				s.setOnAction(MouseClicked);
				//button.setOnKeyPressed(keyPressed);

				if (cell.isVisible() && cell instanceof CharacterCell && ((CharacterCell)cell).getCharacter() instanceof Hero) {		
							HB=new HeroButton((Hero)((CharacterCell)cell).getCharacter(),s);
							HBS.add(HB);
							
							int x=getId((Hero) ((CharacterCell)cell).getCharacter());
							imageView.setImage(getPhoto(x));
							
						}   
					else
						if(cell.isVisible() && cell instanceof CharacterCell && ((CharacterCell)cell).getCharacter() instanceof Zombie)
							imageView.setImage(zombieImage);
					else
						if(cell.isVisible() && cell instanceof CharacterCell && ((CharacterCell)cell).getCharacter()==null)
							imageView.setImage(emptyCellVisibleImage);
					else
						if(cell.isVisible() && cell instanceof CollectibleCell && ((CollectibleCell)cell).getCollectible() instanceof Supply)
							imageView.setImage(supplyImage);
					else
						if(cell.isVisible() && cell instanceof CollectibleCell && ((CollectibleCell)cell).getCollectible() instanceof Vaccine)
							imageView.setImage(vaccineImage);
						
				    else
				    	if(cell.isVisible() && cell instanceof TrapCell)
				    		imageView.setImage(emptyCellVisibleImage);
						  
		    buttonsArray[i][j]=s;
			s.setGraphic( imageView );
				imageView .fitWidthProperty().bind(s.widthProperty());
				imageView .fitHeightProperty().bind(s.heightProperty());
				gridPane.add(s,i,14-j, 1, 1);
				
			}
		}
		updateMap();
		
		
	}
	
	
	
	
	public void getCharAdjcent2(Hero h){
		  // ArrayList<Character>Chars=new ArrayList<Character>(); 
		   for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					int adjacentX = h.getLocation().x + i;
					int adjacentY = h.getLocation().y + j;
					if ((i == 0 && j == 0) || adjacentX<0 || adjacentY<0 || adjacentX>14 || adjacentY>14) {
						// Skip the character's location and out-of-bounds cells
						continue;
					}
					if(Game.map[adjacentX][adjacentY] instanceof CharacterCell && ((CharacterCell)Game.map[adjacentX][adjacentY]).getCharacter()!=null && ((CharacterCell)Game.map[adjacentX][adjacentY]).getCharacter() instanceof Hero){
						h.setTarget((((CharacterCell)Game.map[adjacentX][adjacentY]).getCharacter()));
					}
					
				}}
		  
		   
			
	   }
	public int getId(Hero h){
		for(int i=0;i<HeroButtons.size();i++){
			Hero h2=HeroButtons.get(i).hero;
			if(h2==null)
				System.out.print(HeroButtons.size());
			if(h.getName().equals(h2.getName()))
				return HeroButtons.get(i).getID();
		}
		return 6;

	}


	public void setTarget(Hero h){

		//  Hero h=getHero();	

		int X=h.getLocation().x;int Y=h.getLocation().y;
		for (int xC = -1; xC <= 1; xC++) {
			for (int yC = -1; yC <= 1; yC++) {
				int adjacentX = X + xC;
				int adjacentY = Y + yC;
				if ( (xC==0 & yC==0) || adjacentX<0 || adjacentY<0 || adjacentX>14 || adjacentY>14) 
					// Skip the character's location and out-of-bounds cells
					continue;
				if((board[adjacentX][adjacentY] instanceof CharacterCell && ((CharacterCell)board[adjacentX][adjacentY]).getCharacter() instanceof Zombie)){
					//System.out.print(((CharacterCell)board[adjacentX][adjacentY]).getCharacter());
					
					h.setTarget(((CharacterCell)board[adjacentX][adjacentY]).getCharacter());
					board[adjacentX][adjacentY].setVisible(true);
				}
			}}}


	public Hero  getHero(HeroButton T,Button b){
		int Counter=0;
		for(int i=0;i<HBS.size();i++){
			Counter++;
			HeroButton H=HBS.get(i);
			//System.out.println(H.getBot() +" ========="+b);
			//System.out.println(H.getHero() +" ========="+b);
			//System.out.print(H+"zzzzzzzzz"+HBS.size()+H.getBot().getId());
			if(b.equals(H.getBot()))
				return H.getHero();
		}
		return null;

	}
	//public Button  getHero(HeroButton T,Button b){
	//for(int i=0;i<HBS.size();i++){

	//}

	//}
	@Override
	public void handle(ActionEvent event) {
		//if(event.getSource()==b)
		//window.setScene(scene2);


	}
	public void setID(){
		String s="iv";int n=10;
		for(int i=0;i<Game.availableHeroes.size();i++){
			Hero h=Game.availableHeroes.get(i);
			//System.out.print(h.getName());
			heroID HI=new heroID(h,i,i);
			HeroButtons.add(HI);
			n++;
			//System.out.print(HI.hero.getName());
		}
	}
	Label l=new Label();



	private Image getPhoto(int x) {
		// TODO Auto-generated method stub
		Image hero = null;
		if(x==0)
			hero=JoelP;
		else
			if(x==1)
				hero=EllieP;
			else
				if(x==2)
					hero=TessP;
				else
					if(x==3)
						hero=RileyP;
					else
						if(x==4)
							hero=TommyP;
						else
							if(x==5)
								hero=BillP;
							else
								if(x==6)
									hero=DavidP;
								else
									hero=HenryP;

		return hero;
	}
	public void SetAvailable(){
		for(int i=0;i<Game.heroes.size();i++){
			Hero h =Game.heroes.get(i);
			getPhotoM(getId(h));
		}
	}
	private void getPhotoM(int x) {
		// TODO Auto-generated method stub
		Image hero = null;
		if(x==0){
			hero=JOELS;
			iv10.setVisible(true);
		}
		else
			if(x==1){
				hero=ELLIES;
				iv11.setVisible(true);
			}
			else
				if(x==2){
					hero=TESSS;
					iv12.setVisible(true);
				}
				else
					if(x==3){
						hero=RILEYS;
						iv13.setVisible(true);
					}else
						if(x==4){
							hero=TOMMYS;
							iv14.setVisible(true);
						}else
							if(x==5){
								hero=BILLS;
								iv15.setVisible(true);
							}else
								if(x==6){
									hero=DAVIDS;
									iv16.setVisible(true);
								}else{
									hero=HenryP;
									iv17.setVisible(true);
								}

		
	}



int n=0;
	public void updateMap() {
		board =Game.map;
		iv10.setVisible(false);
		iv17.setVisible(false);
	     iv11.setVisible(false);
		iv16.setVisible(false);
		iv12.setVisible(false);
		iv15.setVisible(false);
		iv13.setVisible(false);
		iv14.setVisible(false);
		HBS=new ArrayList<HeroButton>();
		///System.out.print(HBS.size()+"/");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				Cell cell = board[i][j];
                //Button BS=buttonsArray[i][j];
               // buttonsArray[i][j].setMaxSize(40,40);
                //buttonsArray[i][j].setPrefSize(30,30);

				//ImageView imageView = new ImageView();
				ImageView imageView = new ImageView(emptyCellImage);
				buttonsArray[i][j].setOnKeyPressed(keyPressed);

				


				buttonsArray[i][j].setOnAction(MouseClicked);
				//button.setOnKeyPressed(keyPressed);

				if (cell.isVisible() && cell instanceof CharacterCell && ((CharacterCell)cell).getCharacter() instanceof Hero) {		
//			       
//				if(n++==0)
//					updateButton(hero,buttonsArray[i][j]);
//				else
//					updateButton(h,buttonsArray[i][j]);
//				if(!exist(h)){
					HB=new HeroButton((Hero)((CharacterCell)cell).getCharacter(),buttonsArray[i][j]);
							HBS.add(HB);
				
							int x=getId((Hero) ((CharacterCell)cell).getCharacter());
							imageView.setImage(getPhoto(x));
							

						}   
					else
						if(cell.isVisible() && cell instanceof CharacterCell && ((CharacterCell)cell).getCharacter() instanceof Zombie)
							imageView.setImage(zombieImage);
					else
						if(cell.isVisible() && cell instanceof CharacterCell && ((CharacterCell)cell).getCharacter()==null)
							imageView.setImage(emptyCellVisibleImage);
					else
						if(cell.isVisible() && cell instanceof CollectibleCell && ((CollectibleCell)cell).getCollectible() instanceof Supply)
							imageView.setImage(supplyImage);
					else
						if(cell.isVisible() && cell instanceof CollectibleCell && ((CollectibleCell)cell).getCollectible() instanceof Vaccine)
							imageView.setImage(vaccineImage);
						
				    else
				    	if(cell.isVisible() && cell instanceof TrapCell)
				    		imageView.setImage(emptyCellVisibleImage);
						  
				
				buttonsArray[i][j].setGraphic( imageView );
				imageView .fitWidthProperty().bind(buttonsArray[i][j].widthProperty());
				imageView .fitHeightProperty().bind(buttonsArray[i][j].heightProperty());
				
				//gridPane.add(buttonsArray[i][j],i,j, 1, 1);
				

						}}
		      SetAvailable();
	//	updateVisibleCells();
		//updateNearbyButtons();

	}

	private void updateButton(Hero h2, Button button2) {
		for(int i=0;i<HBS.size();i++){
		     HeroButton H=HBS.get(i);
		     if(h2.getName().equals(H.getHero()))
		    	 H.setBot(button2);
		}
		
	}
	HeroButton HB=new HeroButton(new Fighter("",2,2,2),new Button());
	
	public void updateVisibleCells(){
		for(int i=0;i<Game.heroes.size();i++){
			Hero h=Game.heroes.get(i);
            
			int X=h.getLocation().x;int Y=h.getLocation().y;
			for (int xC = -1; xC <=1; xC++) {
				for (int yC = -1; yC <= 1; yC++) {
					
					ImageView imageView = new ImageView(emptyCellVisibleImage);
					button = new Button("");
					button.setPrefSize(30,30);
					imageView .setPreserveRatio(true);
					button.setMinWidth(65);button.setPrefWidth(65);
					button.setMinHeight(65);button.setPrefHeight(65);
					button.setOnAction(MouseClicked);
					button.setOnKeyPressed(keyPressed);
					int adjacentX = xC+X;
					int adjacentY = yC+Y;
					if ( (adjacentX==X & adjacentY==Y) || adjacentX<0 || adjacentY<0 || adjacentX>14 || adjacentY>14) 
						// Skip the character's location and out-of-bounds cells
						continue;
					Cell cell=board[adjacentX][adjacentY];
					nearbyButtons.add(button);
					if(( cell instanceof CharacterCell && ((CharacterCell) cell).getCharacter()==null) || cell instanceof TrapCell)
						imageView.setImage(emptyCellVisibleImage);
						
						
						else if (cell instanceof CharacterCell &&((CharacterCell) cell).getCharacter() instanceof Zombie) 
							imageView.setImage(zombieImage);
							
						else
							if(cell instanceof CharacterCell &&((CharacterCell) cell).getCharacter() instanceof Hero){
								int x=getId((Hero) ((CharacterCell) cell).getCharacter());
								imageView.setImage(getPhoto(x));

								HB=new HeroButton((Hero) ((CharacterCell) cell).getCharacter(),button);
								HBS.add(HB);
							}
								

						
					
						 		
				else if (cell instanceof CollectibleCell &&((CollectibleCell)cell).getCollectible() instanceof Supply) 
					 imageView.setImage(supplyImage);
				 else 
					 if(cell instanceof CollectibleCell &&((CollectibleCell)cell).getCollectible() instanceof Vaccine)
						 imageView.setImage(vaccineImage);
					
					button.setGraphic( imageView );
					imageView .fitWidthProperty().bind(button.widthProperty());
					imageView .fitHeightProperty().bind(button.heightProperty());
					gridPane.add(button,adjacentX,adjacentY, 1, 1);


				}}}
		//addHeroes();
		//updateNearbyButtons();


	}
	public void updateNearbyButtons(){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				ImageView imageView = new ImageView(emptyCellVisibleImage);
				button = new Button("");
				button.setPrefSize(30,30);
				imageView .setPreserveRatio(true);
				button.setMinWidth(65);button.setPrefWidth(65);
				button.setMinHeight(65);button.setPrefHeight(65);
				
				Cell cell=board[i][j];
				if(cell.isVisible() && cell instanceof CharacterCell && ((CharacterCell)cell).getCharacter()==null){
					imageView.setImage(emptyCellVisibleImage);
					button.setGraphic(imageView);
					imageView .fitWidthProperty().bind(button.widthProperty());
					imageView .fitHeightProperty().bind(button.heightProperty());
					gridPane.add(button,i,j, 1, 1);
					}
				
				else
					if(cell.isVisible() && cell instanceof CharacterCell && ((CharacterCell)cell).getCharacter() instanceof Zombie){
						imageView.setImage(zombieImage);
				button.setGraphic(imageView);
				imageView .fitWidthProperty().bind(button.widthProperty());
				imageView .fitHeightProperty().bind(button.heightProperty());
				gridPane.add(button,i,j, 1, 1);}
					else
						if(cell.isVisible() && cell instanceof CollectibleCell && ((CollectibleCell)cell).getCollectible() instanceof Supply){
							imageView.setImage(zombieImage);
							button.setGraphic(imageView);
							imageView .fitWidthProperty().bind(button.widthProperty());
							imageView .fitHeightProperty().bind(button.heightProperty());
							gridPane.add(button,i,j, 1, 1);}
						else
							if(cell.isVisible() && cell instanceof CollectibleCell && ((CollectibleCell)cell).getCollectible() instanceof Supply){
								imageView.setImage(zombieImage);
								button.setGraphic(imageView);
								imageView .fitWidthProperty().bind(button.widthProperty());
								imageView .fitHeightProperty().bind(button.heightProperty());
								gridPane.add(button,i,j, 1, 1);
								}
					
					
				}
			}
	}
	public void addHeroes(){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				ImageView imageView = new ImageView();
				button = new Button("");
				button.setPrefSize(30,30);
				imageView .setPreserveRatio(true);
				button.setMinWidth(65);button.setPrefWidth(65);
				button.setMinHeight(65);button.setPrefHeight(65);
				
				Cell cell=board[i][j];
				if(cell instanceof CharacterCell &&((CharacterCell) cell).getCharacter() instanceof Hero){
					int x=getId((Hero) ((CharacterCell) cell).getCharacter());
					imageView.setImage(getPhoto(x));
					button.setGraphic( imageView );
					imageView .fitWidthProperty().bind(button.widthProperty());
					imageView .fitHeightProperty().bind(button.heightProperty());
					gridPane.add(button,i,j, 1, 1);
				
			}
		}
	}
	}

	private EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {
 
		@Override
		public void handle(KeyEvent e) {
              int curr = 0;		
                    if(!lock){
                    	
			if(e.getCode().equals(KeyCode.W) ||e.getCode().equals(KeyCode.UP)){
				try {
					 curr=h.getCurrentHp();
					h.move(Direction.UP);
					 
					updateMap();
					//updateNearbyButtons();
					
				} catch (MovementException e1) {
					AlertBox.display("exception","Invalid movement");
					//e1.printStackTrace();
				} catch (NotEnoughActionsException e1) {
					// TODO Auto-generated catch block
					AlertBox.display("exception","Actions");
				}
			}
			else
				if(e.getCode().equals(KeyCode.S) || e.getCode().equals(KeyCode.DOWN)){
					try {
						 curr=h.getCurrentHp();
						h.move(Direction.DOWN);
						updateMap();
					//	updateNearbyButtons();
					} catch (MovementException e1) {
						// TODO Auto-generated catch block
						AlertBox.display("exception","Invalid movement");
					} catch (NotEnoughActionsException e1) {
						// TODO Auto-generated catch block
						AlertBox.display("exception","Actions");
					}
				}
				else if(e.getCode().equals(KeyCode.D)||e.getCode().equals(KeyCode.RIGHT)){
					try {
						 curr=h.getCurrentHp();
						h.move(Direction.RIGHT);
						updateMap();
						//updateNearbyButtons();
					} catch (MovementException e1) {
						// TODO Auto-generated catch block
						AlertBox.display("exception","Invalid movement");
					} catch (NotEnoughActionsException e1) {
						// TODO Auto-generated catch block
						AlertBox.display("exception","Actions");
					}
				}
				else
					if(e.getCode().equals(KeyCode.A) || e.getCode().equals(KeyCode.LEFT)){
						try {
							 curr=h.getCurrentHp();
							h.move(Direction.LEFT);
							updateMap();
						//	updateNearbyButtons();
						} catch (MovementException e1) {
							// TODO Auto-generated catch block
							AlertBox.display("exception","Invalid movement");
						} catch (NotEnoughActionsException e1) {
							// TODO Auto-generated catch block
							AlertBox.display("exception","Actions");
						}
					}
			l.setLayoutX(1500);l.setLayoutY(110);
			//HB.setBot(b);
			//h = getHero(HB,b);
			if(curr>h.getCurrentHp()){
				AlertBox.display("TrapCell","Your Current Hp decreas");
			}
			Hp.setText("CurrentHp : "+h.getCurrentHp());
			Actions.setText("Actions Available : "+h.getActionsAvailable());
			supp.setText("Supplies : " +h.getSupplyInventory().size());
			vacc.setText("Vaccines : "+h.getVaccineInventory().size());
			//updateMap();
		//	updateNearbyButtons();
		}}		
	};
	Hero h;
	private EventHandler<ActionEvent> MouseClicked = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent e) {
             if(!lock){  
			Button b=(Button) e.getSource();
            try{ 
			l.setLayoutX(1500);l.setLayoutY(110);
			//HB.setBot(b);
			h = getHero(HB,b);
			name.setText("Name : "+h.getName());
			type.setText("Type : "+h.getClass().getSimpleName());
			Hp.setText("CurrentHp : "+h.getCurrentHp());
			Actions.setText("Actions Available : "+h.getActionsAvailable());
			supp.setText("Supplies : " +h.getSupplyInventory().size());
			vacc.setText("Vaccines : "+h.getVaccineInventory().size());

			AttackDmg.setText("AttackDmg : "+h.getAttackDmg());
			
			
			//updateMap();		
			useSpecial.setDisable(false);
			attack.setDisable(false);
			cure.setDisable(false);
			endTurn.setDisable(false);
		}catch(Exception e1){
			AlertBox.display("Exception"," CANNOT BE CONTROLLED");
			
		}
            }
		}
	};
}
class HeroButton{
	Hero hero;
	Button bot;
	public Button getBot() {
		return this.bot;
	}
	public void setBot(Button bot) {
		this.bot = bot;
	}
	public Hero getHero() {
		return this.hero;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	HeroButton(Hero h,Button b){
		hero=h;
		bot=b;
	}
}
class heroID{
	int ID;
	Hero hero;
	
	int ID2;
	public Hero getHero() {
		return this.hero;
	}
	heroID(Hero h,int x,int y){
		ID=x;
		hero=h;
		ID2=y;
		
		// boto=b;
	}
	public int getID() {
		return this.ID;
	}
	public int getID2() {
		return ID2;
	}
	public void setID(int iD) {
		ID = iD;
	}

}


