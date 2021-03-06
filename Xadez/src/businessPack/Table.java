package businessPack;

import InterfaceView.GameCtrl;
import businessPack.Pieces.Peon;
import extras.Vetor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

public class Table{
    //atributos>>
    private Block[][] table;
    private Block wait; 
    private static int m;
    private static int n;
    Image genericImage;//fiz apenas para não dar conflito nos argumentos que exigem imagens
    GameCtrl gameCtrl;
    //construtor>>
    public Table(int m, int n, Player p1, Player p2){
        this.m = m;
        this.n = n;
        table = new Block[m][n];//m = quantidade de linhas (relaciona-se com i); n = quantidade de colunas (relaciona-se com j)
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //Piece piece, int x, int y, int color
                if((i%2==0 && j%2==0) || (j%2!=0 && i%2!=0)) {
                    table[i][j] = new Block(null, i, j, 0);
                } else {
                    table[i][j] = new Block(null, i, j, 1);
                }
            }
        }
    }
    public void setGameCtrl(GameCtrl gameCtrl) {
        this.gameCtrl = gameCtrl;
    }
    //metodos>>
    public void initTable(Player player1, Player player2) {
        for(int i = 0; i < Table.getM(); i++){
            for(int j = 0; j < Table.getN(); j++){
                if(getBlock(i, j).getPiece() == null){
                    getBlock(i, j).setPiece(player1.getArmy().findPiece(i, j));
                }
                if(getBlock(i, j).getPiece() == null){
                    getBlock(i, j).setPiece(player2.getArmy().findPiece(i, j));
                }
            }
        }
        try {
            putImagesOnTable();
        } catch (NullPointerException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Um erro inesperado ocorreu!", "Erro 001", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void putImagesOnTable() {
        ImageView pieceImage;
        for(int i = 0; i < Table.getM(); i++) {
            for(int j = 0; j < Table.getN(); j++) {
                if(!getBlock(i, j).isEmpty()) {
                    //ImageView barra = new Image("InterfaceView/imagens/barraVerde.png");
                    pieceImage = getBlock(i, j).getPiece();
                    ImageView barraLife = getBlock(i, j).getPiece().getLifeBar();
                    ImageView barraLifeBg = getBlock(i, j).getPiece().getLifeBarBg();
                    ImageView bullet1 = getBlock(i, j).getPiece().getBullet(1);
                    ImageView bullet2 = getBlock(i, j).getPiece().getBullet(2);
                    gameCtrl.addToPiecesPane(pieceImage);
                    gameCtrl.addToPiecesPane(barraLifeBg);
                    gameCtrl.addToPiecesPane(barraLife);
                    if(getBlock(i, j).getPiece().getTpHero() == TypeHero.sheriff){//sheriff bullets
                        switch(getBlock(i, j).getPiece().getTypePiece()){
                            case tower: case horse: case  peon:
                                gameCtrl.addToPiecesPane(bullet1);
                                break;
                            case king:
                                gameCtrl.addToPiecesPane(bullet1);
                                gameCtrl.addToPiecesPane(bullet2);
                        }
                    }
                    //getBlock(i, j).getPiece().bulletViewConfig();
                    getBlock(i, j).getPiece().lifeBarRealocate();
                    pieceImage.setLayoutX((65*i));
                    pieceImage.setLayoutY(-75 + (65*j));
                }
                gameCtrl.addToGrid(gameCtrl.makeBlock(i, j), i, j);
                //pieceImage = null;
            }
        }
    }
    //getset>>    
    /**
     * 
     * @return the 'x' width of the table.
     */
    public static int getM(){
        return m;
    }
    
    /**
     *
     * @return the 'y' height of the table.
     */
    public static int getN(){
        return m;
    }
    
    public Block[][] getTable() {
        return table;
    }
    
    public Block getBlock(int x, int y){
        if(0 <= x && x < m && 0 <= y && y < n){
            return table[x][y];
        }else{
            return null;
        }
    }
    public Block getBlock(Vetor vetor){
        if(vetor.getX() >= 0 && vetor.getX() < m && vetor.getY() >= 0 && vetor.getY() < n){
            return table[vetor.getX()][vetor.getY()];
        }else{
            return null;
        }
    }
    public Block getBlock(Piece piece){
        if(piece.getX() >= 0 && piece.getX() < m && piece.getY() >= 0 && piece.getY() < n){
            return table[(int)piece.getX()][(int)piece.getY()];
        }else{
            return null;
        }
    }
    public void wait(Block block){
        wait = block;
    }
    public static boolean isInside(Vetor vetor){
        return (vetor.getX() >= 0 && vetor.getX() < m && vetor.getY() >= 0 && vetor.getY() < n);
    }
    public static boolean isInside(int x, int y){
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
    public void MovePiece(Vetor piecePos, Vetor pieceDestination) {
        if(getBlock(piecePos).getPiece().getTypePiece() == TypePiece.peon){
            Peon p= (Peon)getBlock(piecePos).getPiece();
            p.setFirstmove(false);
            System.out.println("Peon setado para false");
        }
        Piece tempB = table[piecePos.getX()][piecePos.getY()].getPiece();
        tempB.setVetor(pieceDestination);
        table[piecePos.getX()][piecePos.getY()].setPiece(null);
        table[pieceDestination.getX()][pieceDestination.getY()].setPiece(tempB);
        
    }
    
    public Block callForSheriffKing(){//onde está o SheriffKing?
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!table[i][j].isEmpty() &&                                   //se o bloco não está vazio e
                    table[i][j].getPiece().getTpHero() == TypeHero.sheriff && //pertence ao Sheriff e
                    table[i][j].getPiece().getTypePiece() == TypePiece.king){//é um King
                    return table[i][j];
                }
            }
        }
        return null;//não há SheriffKing
    }
}