
package businessPack;
import extras.BlockState;
import extras.Who;
import javafx.scene.image.Image;
import extras.Vetor;
import javafx.scene.image.ImageView;

public class Block extends ImageView {
    //atributos>>
    private Piece piece;
    private Vetor vetor;
    private Image myImg;
    private final Image greenBlock = new Image("InterfaceView/imagens/blocoVerde.png", 62, 62, false, false );
    private final Image redBlock = new Image("InterfaceView/imagens/blocoVermelho.png", 62, 62, false, false );
    //private Image imgBlock;
    //construtor>>
    public Block(Piece piece, int x, int y, int color) { //0-white 1-black
        this.piece = piece;
        vetor = new Vetor(x, y);
        if(color == 0) {
            myImg = new Image("InterfaceView/imagens/blocoBranco.png", 62, 62, false, false);
        } else {
            myImg = new Image("InterfaceView/imagens/blocoPreto.png", 62, 62, false, false);
        }
        this.setImage(myImg);
    }
    //metodos>>
    public boolean isEmpty(){
        return piece == null;
    }
    //getset>>
    public Vetor getVetor(){
        return vetor;
    }
    public Piece getPiece(){
        return piece;
    }
    public void setPiece(Piece p){
        this.piece = p;
    }
    public BlockState getBlockState(Player playerLooking) {
        if(piece != null) {
            if(playerLooking.getPlayingTurn() == 1) {
                return piece.getPlayer() == Who.player2 ? BlockState.Friend : BlockState.Enemy;
            } else {
                return piece.getPlayer() == Who.player1 ? BlockState.Enemy : BlockState.Friend;
            }
        }
        return BlockState.Empty;
    }

    /**
     *
     * @param color 0 for green 1 for red
     * @param playerLooking
     */
    public void colorChange(int color, Player playerLooking) { //0-Green 1-red
        BlockState bs = getBlockState(playerLooking);
        if(bs == BlockState.Friend) return;
        if(color == 0) {
            this.setImage(greenBlock);
        } else {
            this.setImage(redBlock);
        }
    }
    public void colorDefault() {
        this.setImage(myImg);
    }
}
