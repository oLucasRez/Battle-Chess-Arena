package businessPack.Pieces;

import businessPack.Piece;
import businessPack.Pieces.Default.DefaultKing;
import businessPack.Pieces.Sheriff.SheriffKing;
import businessPack.Pieces.Wizard.WizardKing;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import businessPack.TypePiece;
import extras.Pistol;
import extras.Who;
import javafx.scene.image.Image;
import businessPack.Pieces.Interfaces.IMovement;

public class King extends Piece {
    //atributos>>
    //construtor>>
    public King(Who who, TypeHero tpHero, int x, int y) {
        super(who, tpHero, x, y);
        hp = 18;
        damage = 1;
        strategy = getHeroStrategy();//new DefaultKing(player);
        tpPiece = TypePiece.king;
        pieceName = "Rei";
        maxHp = hp;
        updateImage();
    }
//    public King(Player pPiece, TypeHero tpHero, int x, int y, ItypeKing tpKing) {
//        super(pPiece, tpHero, x, y);
//        hp = 18;
//        this.tpKing = tpKing;
//        updateImage();
//    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay!=null) freeWay.clear();
        table.clearTrend();
        freeWay = strategy.IcheckMove(table, vetor);
        updateHitWay();
    }
    @Override
    public IMovement getHeroStrategy() {
        switch(tpHero) {
            case sheriff:
                shoot = new SheriffKing(Players.getPlayer(player));
                return new DefaultKing(Players.getPlayer(player));
            case wizard:
                return new WizardKing();
            default:
                return new DefaultKing(Players.getPlayer(player));
        }
    }
    //getset>>
    public void setTypeKing(IMovement tpKing){//muda o comportamento do checkMove()
        strategy = tpKing;
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "King.png", widhtImg, heightImg, false, false));
    }
}