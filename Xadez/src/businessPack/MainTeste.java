package businessPack;

import businessPack.Heros.Lapa;
import businessPack.Heros.Lenin;
import businessPack.Heros.Sheriff;
import businessPack.Heros.Wizard;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Default.DefaultTower;
import businessPack.Pieces.Lapa.LapaTower;
import businessPack.Pieces.Tower;
import javafx.scene.image.Image;

public class MainTeste {
    public static void main(String[] args) {
        //Pegando imagens
        Image lapaImage = null;
        Image leninImage = null;
        //Criando os players

        Player p1 = new Player(1, new Sheriff(), 1, "1");
        Player p2 = new Player(-1, new Lenin(), 2, "2");
        //Cirando os personagens dos players
        Lapa lapa = new Lapa();
        Lenin lenin = new Lenin();
        //Criando o tabuleiro
        Table table = new Table(8, 8, p1, p2);
        
        Tower t = new Tower(p1.getWho(), TypeHero.lapa, 2, 3);
        //table.getTable()[2][3] = new Block(t, 2, 3);
        Bishop b = new Bishop(p2.getWho(), TypeHero.wizard, 2, 1);
        //table.getTable()[2][1] = new Block(b, 2, 1);
        Bishop b2 = new Bishop(p2.getWho(), TypeHero.wizard, 6, 3);
        //table.getTable()[6][3] = new Block(b2, 6, 3);
        Bishop b1 = new Bishop(p1.getWho(), TypeHero.lapa, 0, 3);
        //table.getTable()[0][3] = new Block(b1, 0, 3);
        t.checkMove(table);
        
    }
}