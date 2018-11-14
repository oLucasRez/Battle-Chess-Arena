package businessPack;

import businessPack.Heros.Lapa;
import businessPack.Heros.Lenin;
import businessPack.Heros.Sheriff;
import businessPack.Heros.Wizard;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Default.DefaultTower;
import businessPack.Pieces.Lapa.LapaTower;
import businessPack.Pieces.Tower;
import extras.PlayerPiece;
import static extras.PlayerPiece.Player1;
import static extras.PlayerPiece.Player2;
import javafx.scene.image.Image;

public class MainTeste {
    public static void main(String[] args) {
        //Pegando imagens
        Image sheriffImage = null;
        Image leninImage = null;
        //Criando os players
        Player p1 = new Player(1, new Sheriff(sheriffImage), 1,Player1);
        Player p2 = new Player(-1, new Lenin(leninImage), 2,Player2);
        //Cirando os personagens dos players
        Lapa lapa = new Lapa(null);
        Wizard wizard = new Wizard(null);
        //Criando o tabuleiro
        Table table = new Table(8, 8, p1, p2);
        System.out.println("as");
        Tower t = new Tower(PlayerPiece.Player1, TypeHero.lapa, 5, 5, 2, 3, null, new DefaultTower());
        table.getTable()[2][3] = new Block(t, 2, 3);
        Bishop b = new Bishop(PlayerPiece.Player2, TypeHero.wizard, 5, 5, 2, 1, null);
        table.getTable()[2][1] = new Block(b, 2, 1);
        Bishop b2 = new Bishop(PlayerPiece.Player2, TypeHero.wizard, 5, 5, 6, 3, null);
        table.getTable()[6][3] = new Block(b2, 6, 3);
        Bishop b1 = new Bishop(PlayerPiece.Player1, TypeHero.lapa, 5, 5, 0, 3, null);
        table.getTable()[0][3] = new Block(b1, 0, 3);
        t.checkMove(table);
        
    }
}