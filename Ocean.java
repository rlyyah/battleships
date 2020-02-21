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

    public String toString(){
        StringBuffer sb = new StringBuffer();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWSYZ";
        
        //HERE COMES A B C... TOP NOTATION
        sb.append("  ");
        for(int i=0;i<width;i++){
            sb.append(" "+ String.valueOf(alphabet.charAt(i)));
        }
        sb.append("\n");
        
        for(int i=0;i<height;i++){
            
            if(String.valueOf(i+1).length()>1){
                sb.append(String.valueOf(i+1) + " ");
            }else{
                sb.append(" " + String.valueOf(i+1) + " ");
            }
            for(int j=0;j<width;j++){
                sb.append(ocean.get(i+j).toString());
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}