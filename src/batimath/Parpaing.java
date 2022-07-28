/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batimath;

/**
 *
 * @author Karl
 */
public class Parpaing {
    private int lp; // La longueur du parpaing
    private int hp;  // la hauteur
    private int ep;  // l'epaisseur du parpaing
    private int typeP;

    public int getLp() {
        return lp;
    }

    public void setLp(int Lp) {
        this.lp = Lp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public int getTypeP() {
        return typeP;
    }

    public void setTypeP(int typeP) {
        this.typeP = typeP;
    }

    public Parpaing(int typeP) {
        this.typeP = typeP;

        if(typeP == 10){
           lp = 50;
           hp = 20;
           ep = 10;
        }else if( typeP == 20){
           lp = 50;
           hp = 20;
           ep = 20;
        }else if( typeP == 15){
           lp = 50;
           hp = 20;
           ep = 15;
        }else if( typeP == 25){
           lp = 50;
           hp = 20;
           ep = 25;
        }
    }
    
    public double Rembour(int typeP){
        if(typeP == 10){
           return 8;
        }else if( typeP == 20){
           return 22.5;
        }else if( typeP == 15){
           return 15;
        }else if( typeP == 25){
          return 0;
        }
        return 0;
    
    }

}
