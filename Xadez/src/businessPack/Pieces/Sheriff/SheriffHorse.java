package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import extras.Pistol;
import java.util.ArrayList;
import businessPack.Pieces.Interfaces.Movement;

public class SheriffHorse implements Movement, Pistol {
    //atributos>>
    Player player;
    int charge = 1;
    //construtor>>
    public SheriffHorse(Player player){
        this.player = player;
    }
    //metodos>>
    @Override
    public boolean Ireaction(Table table, Vetor vetor, Block enemyBlock){
        if(charge != 0){
            for(int iE = vetor.getX() + 1; iE < Table.getM(); iE++){
                if(table.getBlock(iE, vetor.getY()).getBlockState(player) == BlockState.Enemy){
                    table.getBlock(iE, vetor.getY()).hitPiece(charge);
                    break;
                }
            }
            for(int iW = vetor.getX() - 1; iW >= 0; iW--){
                if(table.getBlock(iW, vetor.getY()).getBlockState(player) == BlockState.Enemy){
                    table.getBlock(iW, vetor.getY()).hitPiece(charge);
                    break;
                }
            }
            System.out.println("falou comigo? ¬_¬");
            charge--;
        }else charge = 1;
        return false;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {//implementação do cavalo especial do Sheriff
        ArrayList<Block> freeWay = new ArrayList<>();
        int sinalX = -1, sinalY = -1, valorX = 1, valorY = 2;
        for(int i = 1; i <= 8; i++){
            if(Table.isInside(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY))){
                if(table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getBlockState(player) != BlockState.Friend){
                    freeWay.add(table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)));//adiciona todas as posições válidas
                }
            }
            if(i%4 == 0){ sinalX *= -1; }//***************calculos
            if((i - 1)%2 == 0){ sinalY *= -1; }
            if(i%2 == 0){
                if(valorX == 2){ valorX = 1; valorY = 2; }
                else{ valorX = 2; valorY = 1; }
            }//*******************************************
        }
        for(int i = 2; i <= 8; i += 2){
            if(Table.isInside(Vetor.getTrend(i))){
                table.getBlock(Vetor.getTrend(i)).getVetor().setTrend(i + 4);//apontadores para a origem
            }
        }
        int a = 1;
        boolean findPieceN = false, findPieceS = false, findPieceE = false, findPieceW = false;
        while(a <= 3){//movimentos adicionais do cavalo do Sheriff
            if(Table.isInside(vetor.getX(), vetor.getY() - a)){//norte
                if(!findPieceN){
                    switch(table.getBlock(vetor.getX(), vetor.getY() - a).getBlockState(player)){
                        case Enemy:
                            freeWay.add(table.getBlock(vetor.getX(), vetor.getY() - a));
                            findPieceN = true;
                            break;
                        case Empty:
                            freeWay.add(table.getBlock(vetor.getX(), vetor.getY() - a));
                            break;
                        case Friend:
                            findPieceN = true;
                            break;
                    }
                }
            }
            if(Table.isInside(vetor.getX(), vetor.getY() + a)){//sul
                if(!findPieceS){
                    switch(table.getBlock(vetor.getX(), vetor.getY() + a).getBlockState(player)){
                        case Enemy:
                            freeWay.add(table.getBlock(vetor.getX(), vetor.getY() + a));
                            findPieceS = true;
                            break;
                        case Empty:
                            freeWay.add(table.getBlock(vetor.getX(), vetor.getY() + a));
                            break;
                        case Friend:
                            findPieceS = true;
                            break;
                    }
                }
            }
            if(Table.isInside(vetor.getX() + a, vetor.getY())){//leste
                if(!findPieceE){
                    switch(table.getBlock(vetor.getX() + a, vetor.getY()).getBlockState(player)){
                        case Enemy:
                            freeWay.add(table.getBlock(vetor.getX() + a, vetor.getY()));
                            findPieceE = true;
                            break;
                        case Empty:
                            freeWay.add(table.getBlock(vetor.getX() + a, vetor.getY()));
                            break;
                        case Friend:
                            findPieceE = true;
                            break;
                    }
                }
            }
            if(Table.isInside(vetor.getX() - a, vetor.getY())){//oeste
                if(!findPieceW){
                    switch(table.getBlock(vetor.getX() - a, vetor.getY()).getBlockState(player)){
                        case Enemy:
                            freeWay.add(table.getBlock(vetor.getX() - a, vetor.getY()));
                            findPieceW = true;
                            break;
                        case Empty:
                            freeWay.add(table.getBlock(vetor.getX() - a, vetor.getY()));
                            break;
                        case Friend:
                            findPieceW = true;
                            break;
                    }
                }
            }
            a++;
        }
        return freeWay;
    }
}