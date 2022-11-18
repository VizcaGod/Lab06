package domain;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AManufacturing{
    static private final int SIZE=50;
    private final Thing[][] lattice;

    public AManufacturing() {
        lattice=new Thing[SIZE][SIZE];
        for (int r=0;r<SIZE;r++){
            for (int c=0;c<SIZE;c++){
                lattice[r][c]=null;
            }
        }
        someThings();
    }

    public int  getSize(){
        return SIZE;
    }

    public Thing getThing(int r,int c){
        return lattice[r][c];
    }

    public void setThing(int r, int c, Thing e){
        lattice[r][c]=e;
    }

    public void someThings(){
        Rfplicbte t1 = new Rfplicbte(this,19,23, true);
        Rfplicbte t2 = new Rfplicbte(this,18,19, true);
        
    }
    /**
     *
     */
    public int neighborsActive(int r, int c){
        int num=0;
        for(int dr=-1; dr<2;dr++){
            for (int dc=-1; dc<2;dc++){
                if ((dr!=0 || dc!=0) && inLattice(r+dr,c+dc) &&
                (lattice[r+dr][c+dc]!=null) &&  (lattice[r+dr][c+dc].isActive())) num++;
            }
        }
        return (inLattice(r,c) ? num : 0);
    }

    public boolean isEmpty(int r, int c){
        return (inLattice(r,c) && lattice[r][c]==null);
    }    

    public boolean inLattice(int r, int c){
        return ((0<=r) && (r<SIZE) && (0<=c) && (c<SIZE));
    }


    public void ticTac(){
        for (Thing[] item : lattice) {
            for (Thing thing : item) {
                if (thing != null) {
                    thing.decide();
                }
            }
        }
        for (Thing[] value : lattice) {
            for (Thing thing : value) {
                if (thing != null) {
                    thing.faseOne();
                }
            }
        }
        for (Thing[] things : lattice) {
            for (Thing thing : things) {
                if (thing != null) {
                    thing.faseTwo();
                }
            }
        }
        for (Thing[] things : lattice) {
            for (Thing thing : things) {
                if (thing != null) {
                    thing.faseThree();
                }
            }
        }
        for (Thing[] things : lattice) {
            for (Thing thing : things) {
                if (thing != null) {
                    thing.change();
                }
            }
        }
    }

}
