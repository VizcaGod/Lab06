package domain;
import java.awt.Color;

/**
 * Write a description of class Kriptonita here.
 * 
 * @author Juan Vizcaino
 * @version 2.3
 */
public class Kriptonita extends Artefact implements Thing
{
    // instance variables - replace the example below with your own
    private AManufacturing am;
    private int row;
    private int column;
    private boolean active;
    protected char nextState;
    protected Color color;
    /**
     * Constructor for objects of class Kriptonita
     */
    public Kriptonita(AManufacturing am, int row, int column, boolean active){
        this.am = am;
        this.row = row;
        this.column = column;
        state = (active ? Artefact.ACTIVE: Artefact.INACTIVE);
        nextState = (active ? Artefact.ACTIVE: Artefact.INACTIVE);
        am.setThing(row, column, (Thing)this);
        color = color.green;       
    }

    @Override
    public void decide(){
        if(am.neighborsActive(row, column)> 0){
            nextState = Artefact.ACTIVE;
            for(int i = row - 1; i<row+2;i++){
                for(int j = column-1; j<column+2;j++){
                    if(am.inLattice(i,j)&&j<am.getSize()&&(i!=row||j!=column)&&am.getThing(i,j)==null){
                        Kriptonita kryptobro = new Kriptonita(am, i, j, false);
                    }
                }
            }
        }
        else{
            nextState = Artefact.INACTIVE;
        }
    }

    public final void change(){
        step();
        state = nextState;
    }
}
