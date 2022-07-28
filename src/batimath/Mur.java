 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batimath;

/**
 *
 * @author Karl
 */
public class Mur {
    
    private double Lm; // La longueur du mur
    private double Hm;  // la hauteur du mur

    public Mur(double lm, double hm){
        this.Hm = hm;
        this.Lm = lm;
    }
    public double getLm() {
        return Lm;
    }

    public void setLm(int Lm) {
        this.Lm = Lm;
    }

    public double getHm() {
        return Hm;
    }

    public void setHm(int Hm) {
        this.Hm = Hm;
    }

    public int nbrePaL(Parpaing p){
        return (int) (this.Lm / p.getHp());
    }

    public int nbrePal(Parpaing p){
        return (int) (this.Hm / p.getLp());
    }

    public double Vbeton(double eb, double ep, double hp, Parpaing p){
        return (this.nbrePaL(p) * this.nbrePal(p) * p.Rembour(p.getTypeP()) + ((this.Hm/25)+ 1 )*eb*ep*this.Lm + (this.Lm/55 - 2)*eb*hp*this.Hm )*0.001;
    }

    public double Vmortier(double em){
        return (this.Hm * this.Lm * em);
    }

    public int prixParpaing(int prix, int n){
        return n * prix;
    }

    public int prixCiment(int prix, int n){
        return (n/50) * prix;
    }
 
    public int prixSable(int prix, int n){
        return (n/1000) * prix;
    }
   
    public int prixEau(int prix, int n){
        return n * prix;
    }
   
    public int prixGravier(int prix, int n){
        return (n/1000) * prix;
    }
 }
