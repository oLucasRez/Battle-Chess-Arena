
package businessPack.Pieces.EnemyLenin;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;
import businessPack.Pieces.Interfaces.IMovement;
public class EnemyPeonLenin implements IMovement{

    Player playing;
    
    public EnemyPeonLenin(Player playing){
        this.playing = playing;
    }

    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        ArrayList<Block> vector;
        vector = new ArrayList<>();
        //vector.add(null);
        return vector;
    }
}
