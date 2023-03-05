import java.util.*;

public class prob17{

    public static String delimit(String string, String start, String end){
        int startIndex = string.indexOf(start);
        int endIndex = string.indexOf(end);
        return string.substring(startIndex+1, endIndex);
    }

    public static String delimit(String string, int startIndex, String end){
        int endIndex = string.indexOf(end);
        return string.substring(startIndex, endIndex);
    }

    public static String delimit(String string, String start, int endIndex){
        int startIndex = string.indexOf(start);
        return string.substring(startIndex+1, endIndex);
    }

    public static class Ship
    {
        String name;
        String type;
        int xCoord;
        int yCoord;

        public Ship(String name, String type, int xCoord, int yCoord){
            this.name = name;
            this.type = type;
            this.xCoord = xCoord;
            this.yCoord = yCoord;
        }

        public String getName(){
            return name;
        }

        public String getType(){
            return type;
        }

        public int getXCoord(){
            return xCoord;
        }

        public int getYCoord(){
            return yCoord;
        }

        public void subtractXCoord(int num){
            xCoord -= num;
        }
        public String toString(){
            return name + " " + type + " " + xCoord + " " + yCoord;
        }
    }
    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());

            for(int testcase = 0; testcase < testCases; testcase++) 
            {
                int shipCases = Integer.parseInt(input.nextLine());
                Ship[] shipList = new Ship[shipCases];

                for (int shipcase = 0; shipcase < shipCases; shipcase++){
                    String data = input.nextLine();

                    String name = delimit(data, 0, "_");
//                    System.out.println(name);

                    String type = delimit(data, "_", ":");
//                    System.out.println(type);

                    int xCoord = Integer.parseInt(delimit(data, ":", ","));
///                    System.out.println(xCoord);

                    int yCoord = Integer.parseInt(delimit(data, ",", data.length()));
//                    System.out.println(yCoord);

                    Ship thing = new Ship(name, type, xCoord, yCoord);
                    shipList[shipcase] = thing;
//                    System.out.println(shipList[shipcase]);
                }
                while(shipList.length > 0){
                    int nearestX = Integer.MAX_VALUE;
                    ArrayList nearestIndexList = new ArrayList();
                    int targetIndex = 0;
                    for (Ship ship: shipList)
                    {
                        if (ship.getXCoord() < nearestX){
                            nearestX = ship.getXCoord();
                        }
                    }
                    for (int i = 0; i<shipList.length; i++){
                        if (shipList[i].getXCoord() == nearestX){
                            nearestIndexList.add(i);
                        }
                    }

                    int biggestYCoord = Integer.MIN_VALUE;
                    for (int y = 0; y<nearestIndexList.size(); y++){
                        int thing = (int) nearestIndexList.get(y);
                        if (shipList[thing].getYCoord() > biggestYCoord){
                            biggestYCoord = shipList[thing].getYCoord();
                        }
                    }
                    
                    for (int i = 0; i<shipList.length; i++){
                        if (shipList[i].getYCoord() == biggestYCoord){
                            targetIndex = i;
                        }
                    }

                    System.out.println("Destroyed Ship: " + 
                    shipList[targetIndex].getName() + " xLoc: " +
                    shipList[targetIndex].getXCoord());

                    if (shipList.length ==1){
                        break;
                    }
                    shipList[targetIndex]=null;
                    for (int i = targetIndex; i<shipList.length-1; i++){
                        shipList[i] = shipList[i+1];
                    }
                    Ship[] newShipList = new Ship[shipList.length -1];
                    for (int i =0; i<newShipList.length; i++){
                        newShipList[i] = shipList[i];
                    }

                    shipList = newShipList;

                    for (Ship ship: shipList){
                        if (ship.getType().equals("A")){
                            ship.subtractXCoord(10);
                        } else if (ship.getType().equals("B")){
                            ship.subtractXCoord(20);
                        } else {
                            ship.subtractXCoord(30);
                        }
                    }
                }


            }

        }
    }
}
