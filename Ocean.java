import java.util.LinkedList;
import java.util.List;

public class Ocean {
    
    private List<Square> ocean;
    private Integer height = 10;
    private Integer width = 10;
    
    public Ocean(){

        ocean = new LinkedList<Square>();
        
        for(int i = 0;i<height; i++){
            for(int j = 0; j<width; j++){
                
                Square sq = new Square(i,j);
                ocean.add(sq);

            }
        }
    }

    public void addShip(Integer y, Integer x, Integer type, Character dimension){

        Ship ship = new Ship(y, x, type, dimension);

        if(dimension == 'h'){
            for(int i = 0; i < type; i++){
                ocean.get(y*10+x+i).makeShip();
            }
        }else{
            for(int i = 0; i<type; i++){
                ocean.get((y+i)*10+x).makeShip();
            }
        }

    }

    public String quess(int yPos, int xPos){
        String msg = "Miss";
        Integer squareNum = yPos * 10 + xPos;
        ocean.get(squareNum).mark();
        return msg;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWSYZ";
        
        // HERE COMES A B C... TOP(horizontal) NOTATION
        sb.append("  ");
        for(int i=0;i<width;i++){
            sb.append(" "+ String.valueOf(alphabet.charAt(i)));
        }
        sb.append("\n");
        
        for(int i=0;i<height;i++){
            // This one is for the left(vertical) notation 
            if(String.valueOf(i+1).length()>1){
                sb.append(String.valueOf(i+1) + " ");
            }else{
                sb.append(" " + String.valueOf(i+1) + " ");
            }
            for(int j=0;j<width;j++){
                // HERE starts the magic of map creation!
                sb.append(ocean.get(i*10+j).toString());
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    } 
    
    /*public String toString(){
        StringBuffer sb = new StringBuffer();
        for(Square s: ocean){
            sb.append(s.toString());
            sb.append("\n");
        }
        return sb.toString();
    }*/
}