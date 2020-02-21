public class Ship{

    private Character dimension;
    private Integer type;
    private Integer xStart;
    private Integer yStart;

    public Ship(Integer y, Integer x, Integer type, Character dimension){
        this.yStart = y;
        this.xStart = x;
        this.type = type;
        this.dimension = dimension;
    }

}