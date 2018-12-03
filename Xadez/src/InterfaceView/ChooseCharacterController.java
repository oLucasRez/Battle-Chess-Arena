package InterfaceView;

import businessPack.Heros.Huebr;
import businessPack.Heros.Lapa;
import businessPack.Heros.Lenin;
import businessPack.Heros.Sheriff;
import businessPack.Heros.Wizard;
import businessPack.Player;
import static businessPack.TypeHero.huebr;
import static businessPack.TypeHero.lapa;
import static businessPack.TypeHero.lenin;
import static businessPack.TypeHero.sheriff;
import static businessPack.TypeHero.wizard;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;


//String musicURL = "src/testemedia/dancing.mp3";
//Media media = new Media(getClass().getResource("dancing.mp3").toString());
//MediaPlayer starter = new MediaPlayer(media);

public class ChooseCharacterController implements Initializable {
    
    ArrayList<MediaPlayer> musicas = new ArrayList<>();  
    MediaPlayer musicaAtual;
    
    @FXML
    Button setaEsq;
    @FXML
    Button setaDir;
    @FXML
    Button characterSelection;
    @FXML
    Text heroName;
    @FXML
    AnchorPane background;
    @FXML
    TextField names1;
    @FXML
    Text PlayerName1;
    @FXML
    Text PlayerName2;
    @FXML
    Text HeroPlayer1;
    @FXML
    Text HeroPlayer2;
    
    private Stage primaryStage;

    Image myImage;
    ImageView myImageView;
    int count = 0,cont = 0;
    Image[] perso = new Image[5];
    String[] heroNames = new String[5];
    Player p1,p2;
    String name1 = "player1",name2 = "player2";
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        // TODO
        int resX = 446;
        int resY = 336;
        perso[0] = new Image("InterfaceView/Personagens/huehuebr-01.png",resX, resY, false, false);
        heroNames[0] = "Huehue br";
        perso[1] = new Image("InterfaceView/Personagens/lapa-01.png",resX, resY, false, false);
        heroNames[1] = "Lapa";
        perso[2] = new Image("InterfaceView/Personagens/lenin-01.png",resX, resY, false, false);
        heroNames[2] = "Czar Nicolau II";
        perso[3] = new Image("InterfaceView/Personagens/omago-01.png", resX, resY, false, false);
        heroNames[3] = "The Wizard";
        perso[4] = new Image("InterfaceView/Personagens/pistoleiro-01.png",resX, resY, false, false);
        heroNames[4] = "Gunslinger";
        myImage = new Image("InterfaceView/setaesq.png");
        myImageView = new ImageView(myImage);
        setaEsq.setGraphic(myImageView);
        myImage = new Image("InterfaceView/setadir.png");
        myImageView = new ImageView(myImage);
        setaDir.setGraphic(myImageView);
        characterSelection.setGraphic(new ImageView(perso[0]));
        
    }
      @FXML
    public void onSetaClickEsq(MouseEvent event) {
        //musicaAtual.stop();
        if(count == 0){
            count = 4;
        }else{
            count--;
        }
//        musicaAtual = musicas.get(count);;;
//        musicaAtual.setStartTime(Duration.ZERO);
//        musicaAtual.isAutoPlay();
//        musicaAtual.play();
        heroName.setText(heroNames[count]);
        characterSelection.setGraphic(new ImageView(perso[count]));
    }
    @FXML
    public void onSetaClickDir(MouseEvent event){

        if(count == 4){
            count = 0;
        }else{
            count++;
        }
//        musicaAtual = musicas.get(count);
//        musicaAtual.setStartTime(Duration.ZERO);
//        musicaAtual.isAutoPlay();
//        musicaAtual.play();
//        heroName.setText(heroNames[count]);
        characterSelection.setGraphic(new ImageView(perso[count]));
    }
    @FXML
    public void onClickButton(MouseEvent e){
        switch(count){
            case 0:
                //name = "Hue";
                if(p1 != null){
                    if(p1.getHero().getHeroType() != huebr){
                        p2 = new Player(-1, new Huebr(), 2,name2);
                        HeroPlayer2.setText("Huebr");
                    }else{
                        
                        JOptionPane.showMessageDialog(null, "personagem ja selecionado");

                    } 
                }else{
                    p1 = new Player(1, new Huebr(), 1, name1);
                    HeroPlayer1.setText("Huebr");
                } 
                break;
            case 1:
                //name = "Lapa";
                   if(p1 != null){
                    if(p1.getHero().getHeroType() != lapa){
                        p2 = new Player(-1, new Lapa(), 2,name2);
                        HeroPlayer2.setText("Lapa");
                    }else{
                        JOptionPane.showMessageDialog(null, "personagem ja selecionado");

                    }
                }else{
                     p1 = new Player(1, new Lapa(), 1, name1);
                     HeroPlayer1.setText("Lapa");
                } 
                break;
            case 2:
                //name = "Czar";
                   if(p1 != null){
                        if(p1.getHero().getHeroType() != lenin){
                            p2 = new Player(-1, new Lenin(), 2,name2);
                            HeroPlayer2.setText("Lenin");
                        }else{
                        JOptionPane.showMessageDialog(null, "personagem ja selecionado");

                    }
                }else{
                         p1 = new Player(1, new Lenin(), 1, name1);
                         HeroPlayer1.setText("Lenin");
                } 
                break;
            case 3:
                //name = "Mago"; 
                if(p1 != null){
                   if(p1.getHero().getHeroType() != wizard){
                        p2 = new Player(-1, new Wizard(), 2,name2);
                        HeroPlayer2.setText("Wizard");
                    }else{
                        JOptionPane.showMessageDialog(null, "personagem ja selecionado");

                    }
                }else{
                        p1 = new Player(1, new Wizard(), 1, name1);
                        HeroPlayer1.setText("Wizard");
                } 
                break;
            case 4:
                //name = "Pistoleiro";
                   if(p1 != null){
                   if(p1.getHero().getHeroType() != sheriff){
                        p2 = new Player(-1, new Sheriff(), 2,name2);
                        HeroPlayer2.setText("Sheriff");
                    }else{
                        JOptionPane.showMessageDialog(null, "personagem ja selecionado");
                    }
                }else{
                        p1 = new Player(1, new Sheriff(), 1, name1);
                        HeroPlayer1.setText("Sheriff");
                } 
                break;
        }
        //funcao para pegar o player
        if(p1 != null && p2 != null){
            primaryStage = (Stage) background.getScene().getWindow();
            LoadScene("Game8x8.fxml");
            primaryStage.close();   
        }
    }
      private void LoadScene(String sceneName){
        try{
            System.out.println("loading");
            FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneName));
            Parent rooter = loader.load();
            GameCtrl gameCtrl = loader.getController();
            gameCtrl.gameCtrl(p1, p2);
            Scene eltonJhon = new Scene(rooter);
            Stage stage = new Stage();
            
            stage.setTitle("Choose Your Character!");
            stage.setScene(eltonJhon);
            stage.show();
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a janela");
            System.out.println("Nao foi possível abrir a janela");
            e.printStackTrace();
        }
    }
      @FXML
      public void onEnterClick(KeyEvent e){
          if(e.getCode() == KeyCode.ENTER){
              if(cont == 0){
                if("".equals(names1.getText())){
                   System.out.println(name1);
                   cont++;
                }else{
                  name1 = names1.getText();
                  System.out.println(name1);
                  PlayerName1.setText(name1);
                  cont++;
                }     
              }else{
                  if("".equals(names1.getText())){
                   System.out.println(name2);
              }else{
                  name2 = names1.getText();
                  System.out.println(name2);
                  PlayerName2.setText(name2);
              }
              }
              
          }
      }
}
