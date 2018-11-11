package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Peon;
import businessPack.Pieces.Wizard.WizardBishop;
import businessPack.Pieces.Wizard.WizardPeon;
import businessPack.TypeHero;
import javafx.scene.image.Image;

public class Wizard extends Hero {
    
    // atributos
    Image wizardBishop;
    Image wizardPeon;
    Image wizardKing;
    Image wizardQueen;
    Image wizardHorse;
    Image wizardTower;
    
    public Wizard(Image image) {
        super(image);
    }

    @Override
    public void createArmy(Army army, int sentido) {
        for(int k = 0;k<8;k++){
            army.addPiece(new Peon(new WizardPeon(), TypeHero.wizard, k, (int)(3.5 + sentido*2.5), wizardPeon)); //peões
        }
        army.addPiece(new Bishop(new WizardBishop(), TypeHero.wizard, 2, (int)(3.5 + sentido*2.5), wizardBishop));// Bispos 
        army.addPiece(new Bishop(new WizardBishop(), TypeHero.wizard, 5, (int)(3.5 + sentido*2.5), wizardBishop));// Bispos 

        
    }
  
    // contemplar o mago :)
}
