package domain;
import java.awt.Color;

/**
 * @author Juan Vizcaino
 */
public class Mimo extends Cell{
    private final AManufacturing aManufacturing;
    private final int row;
    private final int column;
    private int n;

    /**
     * Constructor for objects of class Cmimos
     */
    
    public Mimo(AManufacturing am, int row, int column, boolean active){
        super(am,row,column,active);
        aManufacturing=am;
        this.row=row;
        this.column=column;
        color=Color.orange;
        n =0;
    }
    
    @Override
    public void decide(){
        if(aManufacturing.getThing(row-1,column) != null && n == 0){
            nextState=(aManufacturing.getThing(row - 1, column).isActive() ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row-1,column+1)!= null && n == 1){
            nextState=(aManufacturing.getThing(row - 1, column + 1).isActive() ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row,column+1)!= null && n == 2){
            nextState=(aManufacturing.getThing(row, column + 1).isActive() ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row+1,column+1)!= null && n == 3){
            nextState=(aManufacturing.getThing(row + 1, column + 1).isActive() ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row+1,column)!= null && n == 4){
            nextState=(aManufacturing.getThing(row + 1, column).isActive() ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row+1,column-1)!= null && n == 5){
            nextState=(aManufacturing.getThing(row - 1, column - 1).isActive() ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row,column-1)!= null && n == 6){
            nextState=(aManufacturing.getThing(row, column - 1).isActive() ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row-1,column-1)!= null && n == 7){
            nextState=(aManufacturing.getThing(row - 1, column - 1).isActive() ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        if( n == 7){
            n = -1;
        }
        n +=1;
    }

}
