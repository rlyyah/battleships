import java.util.LinkedList;
import java.util.List;

public class Ship {

    private Character dimension;
    private Integer type;
    private Integer xStart;
    private Integer yStart;
    private List<Square> shipPositions;
    private Boolean isDead;

    public Ship(Integer y, Integer x, Integer type, Character dimension){
        this.yStart = y;
        this.xStart = x;
        this.type = type;
        this.dimension = dimension;
        shipPositions = new LinkedList<>();
        this.isDead = false;
    }

    public void makeShip(Square s){
        shipPositions.add(s);
    }

    public Boolean checkIfDead(){
        for(Square s: this.shipPositions){
            if(!s.getIsHit()){
                return false;
            }
        }
        return true;
    }

    public List<Square> getShipPositions() {
        return shipPositions;
    }

    public void setShipPositions(List<Square> shipPositions) {
        this.shipPositions = shipPositions;
    }

    public Character getDimension() {
        return dimension;
    }

    public void setDimension(Character dimension) {
        this.dimension = dimension;
    }



}