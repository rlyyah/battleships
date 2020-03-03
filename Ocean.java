import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ocean {
    
    private List<Square> ocean;
    private List<Square> unableToBeBuild;
    private List<Ship> shipList;
    private Integer height = 10;
    private Integer width = 10;
    
    public Ocean(){

        ocean = new LinkedList<Square>();
        unableToBeBuild = new LinkedList<>();
        shipList = new LinkedList<>();
        
        for(int i = 0;i<height; i++){
            for(int j = 0; j<width; j++){
                
                Square sq = new Square(i,j);
                ocean.add(sq);

            }
        }
    }

    public String addShip(Integer y, Integer x, Integer type, Character dimension){

        Ship ship = new Ship(y, x, type, dimension);
        List<Square> shipInProgress = new ArrayList<>();
        
        if(dimension == 'h'){
            for(int i = 0; i < type; i++){
                try{
                    shipInProgress.add(ocean.get(y*10+x+i));
                }catch(Exception e){
                    return "Ship cannot be build here!";
                }
                
            }
        }else{
            for(int i = 0; i < type; i++){
                try{
                    shipInProgress.add(ocean.get((y+i)*10+x));
                }catch(Exception e){
                    return "Ship cannot be build here!";
                }
            }
        }

        if(!unableToBeBuild.isEmpty()){
            for(Square s: unableToBeBuild){
                if(shipInProgress.contains(s)){
                    return "Ship cannot be build here"; 
                }
           
            }
        }

        for(Square s: shipInProgress){
            s.makeShip();
            ship.makeShip(s);
            shipList.add(ship);
            // Here comes inability to build over another ship
            unableToBeBuild.add(s);
        }

        List<Square> borders = findAround(ship);
        for(Square s: borders){
            unableToBeBuild.add(s);
        }

        return "Ship has been built";

    }
    
    private List<Square> findAround(Ship ship){
        List<Square> shipBorders = new LinkedList<>();
        Integer index = 0;
        for(Square s: ship.getShipPositions()){

            Integer yPos = s.getyPos();
            Integer xPos = s.getxPos();

            if(ship.getDimension() == 'h'){

                try{
                    if(index == 0){
                        for(int i = -1; i<2;i++){
                            shipBorders.add(ocean.get((yPos+i)*10+xPos-1));
                        }
                    }
                    if(index == ship.getShipPositions().size()-1){
                        for(int i=-1;i<2;i++){
                            shipBorders.add(ocean.get((yPos+i)*10+xPos+1));  
                        }
                    }
                }catch(Exception e){

                }
                try{
                    shipBorders.add(ocean.get((yPos+1)*10+xPos));
                }catch(Exception e){
                    //System.out.println("upper border cannot be build");
                }
                try{
                    shipBorders.add(ocean.get((yPos-1)*10+xPos));
                }catch(Exception e){
                    //System.out.println("lower border cannot be build");
                }

                
                

            }else{

                try{
                    if(index == 0){
                        for(int i = -1; i<2;i++){
                            shipBorders.add(ocean.get((yPos-1)*10+xPos+i));
                        }
                    }
                    if(index == ship.getShipPositions().size()-1){
                        for(int i=-1;i<2;i++){
                            shipBorders.add(ocean.get((yPos+1)*10+xPos+i));  
                        }
                    }
                }catch(Exception e){

                }

                try{
                    shipBorders.add(ocean.get(yPos*10+(xPos-1)));
                }catch(Exception e){

                }
                try{
                    shipBorders.add(ocean.get(yPos*10+(xPos+1)));
                }catch(Exception e){

                }
                
                
            }   
            index++;         
        }
        return shipBorders;

    }


    public String quess(int yPos, int xPos){
        
        String msg = "Miss";
        Integer squareNum = yPos * 10 + xPos;
        Square hit = ocean.get(squareNum);
        
        

        if(hit.mark()){
            // NEXT MOVE
            msg = "HIT!";
            // CHECK IF GUESS MAKES SHIP COLLAPSE ( TURN IT INTO THE FUNCTION )
            for(Ship ship: getShipList()){
                for(Square s: ship.getShipPositions()){
                    if(s.equals(hit)){
                        if(ship.checkIfDead()){
                            List<Square> toBeMarked = findAround(ship);
                            for(Square squareAround: toBeMarked){
                                squareAround.mark();
                            }
                            // WHOLE SHIP IS DEAD -- MAKE X AROUND IT! -- USE OR MAKE FUNCTION TO FIND EVERY SQUARE AROUND SHIP  
                            msg += "WP, YOU KILLED THE WHOLE SHIP!";  
                        }
                    }
                }
            }            
        }else{
            // MOVE NO MORE
        }
        
        
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

    public List<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(List<Ship> shipList) {
        this.shipList = shipList;
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