public class Square{

    private Integer xPos;
    private Integer yPos;
    private Boolean isHit;
    private Boolean isShip;

    public void mark(){
        isHit = true;
    }

    public Square(Integer xPos, Integer yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public String toString(){

        String square = "O";
        
        return square;
    }

}