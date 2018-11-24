package InterfaceView;

import businessPack.Heros.Huebr;
import businessPack.Heros.Lapa;
import businessPack.Heros.Lenin;
import businessPack.Heros.Sheriff;
import businessPack.Heros.Wizard;
import businessPack.Player;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.util.Duration;


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

    Image myImage;
    ImageView myImageView;
    int count = 0;
    Image[] perso = new Image[5];
    String[] heroNames = new String[5];
    Player p1,p2;
    String name;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        String pathMusic = "InterfaceView/Sounds/";
//        musicas.add(new MediaPlayer(new Media(getClass().getResource("MUSICA HUE HUE BR.mp3").toString())));
//        musicas.add(new MediaPlayer(new Media(getClass().getResource("Lapa.mp3").toString())));
//        musicas.add(new MediaPlayer(new Media(getClass().getResource("URSS.mp3").toString())));
//        musicas.add(new MediaPlayer(new Media(getClass().getResource("Mago.mp3").toString())));
//        musicas.add(new MediaPlayer(new Media(getClass().getResource("Pistoleiro.mp3").toString())));
//        
//        musicaAtual = musicas.get(count);
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
        musicaAtual.stop();
        if(count == 0){
            count = 4;
        }else{
            count--;
        }
//        musicaAtual = musicas.get(count);
//        musicaAtual.setStartTime(Duration.ZERO);
//        musicaAtual.isAutoPlay();
//        musicaAtual.play();
        heroName.setText(heroNames[count]);
        characterSelection.setGraphic(new ImageView(perso[count]));
    }
    @FXML
    public void onSetaClickDir(MouseEvent event){
        musicaAtual.stop();
        if(count == 4){
            count = 0;
        }else{
            count++;
        }
//        musicaAtual = musicas.get(count);
//        musicaAtual.setStartTime(Duration.ZERO);
//        musicaAtual.isAutoPlay();
//        musicaAtual.play();
        heroName.setText(heroNames[count]);
        characterSelection.setGraphic(new ImageView(perso[count]));
    }
    @FXML
    public void onClickButton(MouseEvent e){
        switch(count){
            case 0:
                name = "Hue";
                if(p1 != null){
                    p2 = new Player(-1, new Huebr(), 2);
                }else{
                    p1 = new Player(1, new Huebr(), 1);
                } 
                break;
            case 1:
                name = "Lapa";
                   if(p1 != null){
                    p2 = new Player(-1, new Lapa(), 2);
                }else{
                    p1 = new Player(1, new Lapa(), 1);
                } 
                break;
            case 2:
                name = "Czar";
                   if(p1 != null){
                    p2 = new Player(-1, new Lenin(), 2);
                }else{
                    p1 = new Player(1, new Lenin(), 1);
                } 
                break;
            case 3:
                name = "Mago";   if(p1 != null){
                    p2 = new Player(-1, new Wizard(), 2);
                }else{
                    p1 = new Player(1, new Wizard(), 1);
                } 
                break;
            case 4:
                name = "Pistoleiro";
                   if(p1 != null){
                    p2 = new Player(-1, new Sheriff(), 2);
                }else{
                    p1 = new Player(1, new Sheriff(), 1);
                } 
                break;
        }
        //funcao para pegar o player
        
    }
    public String getName(){
        return name;
    }
}
