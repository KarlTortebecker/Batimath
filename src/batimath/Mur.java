
package batimath;

/**
 *
 * @author Karl
 */
public class Mur {
    
    private double Lm; // La longueur du mur
    private double Hm;  // la hauteur du mur

    int Louv = DevisMurController.Louv.stream().mapToInt(Integer::valueOf).sum(); // Pour la somme des longueurs des ouvertures
    int houv = DevisMurController.houv.stream().mapToInt(Integer::valueOf).sum(); // Pour la somme des largeurs des ouvertures

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
        return (int) ((this.Lm - Louv) / p.getHp());
    }

    public int nbrePal(Parpaing p){
        return (int) ((this.Hm - houv) / p.getLp());
    }

    public double Vmortier(double em, double ep, double hp, Parpaing p){
       return ((((this.Hm - houv)/25)+ 1 )*em*ep*(this.Lm - Louv) + ((this.Lm - Louv)/55 - 2)*em*hp*(this.Hm - houv) )*0.001;
    }

    public double VmortierCre(double ec){
        return ((this.Hm - houv) * (this.Lm - Louv) * ec)*0.001;
    }

    public int prixParpaing(int prix, int n){
        return n * prix;
    }

    public int prixCiment(int prix, int n){
        return (int)(Math.ceil(n)/50 * prix);
    }
 
    public double prixSable(int prix, double n){
        return Math.ceil((n/1000.0) * prix);
    }
   
    public int prixEau(int prix, int n){
        return n * prix;
    }
   
    public int prixGravier(int prix, int n){
        return (n/1000) * prix;
    }

    public int prixCarre(int prix, int n){
        return n * prix;
    }

    public double surfaceCarre(double LSc, double lSc){
        return LSc * lSc;
    } 

    public int nbreCarre(double LSc, double lSc, double Lc, double lc){
        return (int)Math.ceil(surfaceCarre(LSc, lSc)/(Lc * lc));
    }

    public int nbreCarton(double LSc, double lSc, double Lc, double lc, double Nc){
        return (int)Math.ceil(nbreCarre(LSc, lSc, Lc, lc)/Nc);
    }
 }
