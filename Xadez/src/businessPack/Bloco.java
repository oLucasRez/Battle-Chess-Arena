
package businessPack;

import com.sun.javafx.geom.Vec2d;
import javafx.scene.image.Image;


public class Bloco {

    Piece myPiece;
    Vec2d pos;
    Image imageBloco;

    public Bloco() {
        myPiece = null;
    }
// test
    public Bloco(Piece p) {
        myPiece = p;
    } 
    
    public boolean CheckEmpty(){
        return myPiece == null;
    }

    public Image getMyImage(Image imageBloco){
        return imageBloco;
    }
}
