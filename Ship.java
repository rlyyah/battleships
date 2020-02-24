import java.util.LinkedList;
import java.util.List;

public class Ship {

    private Character dimension;
    private Integer type;
    private Integer xStart;
    private Integer yStart;
    private List<Square> shipPositions;

    public Ship(Integer y, Integer x, Integer type, Character dimension){
        this.yStart = y;
        this.xStart = x;
        this.type = type;
        this.dimension = dimension;
        shipPositions = new LinkedList<>();
    }

    public void makeShip(Square s){
        shipPositions.add(s);
    }

}