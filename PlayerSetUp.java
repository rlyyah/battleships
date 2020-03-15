import java.util.HashMap;
import java.util.Map;

public class PlayerSetUp {

    // TODO:
    // DIVIDE IT INTO SEPERATE CLASSES,
    // USE NOTEPAD/.TXT FILE TO DISPLAY INSTRUCTIONS
    //

    public PlayerSetUp(){
    prepareMap();
        
    }
    private Ocean prepareMap(){

    // TODO:
    // DIVIDE IT INTO SEPERATE CLASSES,
    // USE NOTEPAD/.TXT FILE TO DISPLAY INSTRUCTIONS
    //  THIS NEEDS TO BE CHANGED IF MAP IS GOING TO BE BIGGER THAN 10X10


        Helpers.print("WELCOME TO THE BATTLESHIP GAME!");
        Helpers.print("SET UP YOUR 5 SHIPS AND PREPARE FOR THE BATTLE!");
        Helpers.print("YOU CAN PLACE YOUR SHIPS VERTICALLY OR HORIZONTALLY");
        Helpers.print("THE 5 SHIPS ARE:");
        Helpers.print("CARRIER(5), BATTLESHIP(4), CRUISER(3), SUBMARINE(3) AND DESTROYER(2)");
        Helpers.print("YOU SETS SHIPS BY ENTER SHIP'S NAME, ANSWER A QUESTION IF ITS HORIZONTALL");
        Helpers.print("AND GIVE THE STARTING POSITION");

        
        Map<String,Integer> shipNames = new HashMap<>();
        Ocean playerOcean = new Ocean();

        shipNames.put("carrier", 5);
        shipNames.put("battleship", 4);
        shipNames.put("cruiser", 3);
        shipNames.put("submarine", 3);
        shipNames.put("destroyer", 2);
        Boolean keepAsking =true;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWSYZ";
        alphabet = alphabet.toLowerCase();
        alphabet = alphabet.substring(0, playerOcean.getWidth());
        
        while(keepAsking){
            
            String usrInput = "";
            String usrDimension = "";
            String shipName = "";
            String position = "";
            Integer xPos;
            Integer yPos;
            Integer shipLength = 0;
            Character dimension = 'q';
            Boolean askForShip = true;
            Helpers.print("Avaible ships:");
            for(String shipKind: shipNames.keySet()){
                System.out.print(shipKind + " (" + String.valueOf(shipNames.get(shipKind)) + "), ");
            }
            Helpers.print("");

            while(askForShip){
                Helpers.print("Provide ship name");

                usrInput = Helpers.getInput();
                usrInput = usrInput.toLowerCase();

                if(shipNames.containsKey(usrInput)){
                    shipName = usrInput;
                    shipLength = shipNames.get(shipName);
                    askForShip = false;
                }
            }
            Boolean askForDimension = true;
            while(askForDimension){
                Helpers.print("Provide ship divemnsion v - vertical, h - horizontal");
                
                usrDimension = Helpers.getInput();
                usrDimension = usrDimension.toLowerCase();
                dimension = usrDimension.charAt(0);

                if(dimension == 'v' || dimension == 'h'){
                    askForDimension = false;
                }
            }

            Boolean askForPosition = true;
            while(askForPosition){

                Helpers.print("Provide coordinations for you ship eg. A5");
                position = Helpers.getInput();

                if(position.length() == 2){
                    position = position.toLowerCase();
                    if(alphabet.contains(String.valueOf(position.charAt(0)))){
                        xPos = alphabet.indexOf(String.valueOf(position.charAt(0)));
                        yPos = Integer.parseInt(String.valueOf(position.charAt(1))) - 1;
                        System.out.println("X: " + xPos + "Y: " + yPos);
                        if(yPos>=0 && yPos<11){
                            if(playerOcean.addShip(yPos, xPos, shipLength, dimension)){
                                askForPosition = false;
                            }
                        }
                    }
                    //  THIS NEEDS TO BE CHANGED IF MAP IS GOING TO BE BIGGER THAN 10X10
                }else if(position.length() == 3){
                    position = position.toLowerCase();
                    if(alphabet.contains(String.valueOf(position.charAt(0)))){
                        xPos = alphabet.indexOf(String.valueOf(position.charAt(0)));
                        yPos = 9;
                        if(yPos>0 && yPos<11){
                            if(playerOcean.addShip(yPos, xPos, shipLength, dimension)){
                                askForPosition = false;
                            }
                        }
                    }

                }


            }

            shipNames.remove(shipName);
            
            Helpers.print(playerOcean.toString());

            if(shipNames.isEmpty()){
                keepAsking = false;
            }

        
        }

        return playerOcean;
        
    
    }




}