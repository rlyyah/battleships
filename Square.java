public class Square{

    private Integer xPos;
    private Integer yPos;
    private Boolean isHit;
    private Boolean isShip;

    public void mark(){
        this.isHit = true;
    }

    public void makeShip(){

        // TODO:
        //      ships cannot overlap eachother
        //      ships cannot touch another ship
        //      ships cannot hang of the map

        this.isShip = true;
    }

    public Square(Integer yPos, Integer xPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.isHit = false;
        this.isShip = false;
    }

    public String toString(){

        // TODO:
        //      DIFFERENT COLORS EG.: Ocean O-blue, Ship S-Orange, Hit(missed) X-white, Hit(not missed) X-Red

        // String square = "Y:" + String.valueOf(this.yPos) + " | X:" + String.valueOf(this.xPos) + " | " + String.valueOf(isHit);
        String square = "O";
        if(isShip){
            square = "S";
        }
        if(isHit){
            square = "X";
        }
        return square;
    }

}