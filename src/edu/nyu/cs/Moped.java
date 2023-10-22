package edu.nyu.cs;

import java.util.Arrays;

/**
 * A virtual moped, roaming the streets of New York.
 * The signatures of a few methods are given and must be completed and used as indicated.
 * Create as many additional properties or methods as you want, as long as the given methods behave as indicated in the instructions.
 * Follow good object-oriented design, especially the principles of abstraction (i.e. the black box metaphor) and encapsulation (i.e. methods and properties belonging to specific objects), as we have learned them.
 * The rest is up to you.
 */
public class Moped {

    private String orientation = "south";

    /**
     * Sets the orientation of the moped to a particular cardinal direction.
     * @param orientation A string representing which cardinal direction at which to set the orientation of the moped.  E.g. "north", "south", "east", or "west".
     */
    public void setOrientation(String orientation) {
        this.orientation=orientation;

    }
    
    /**
     * Returns the current orientation of the moped, as a lowercase String.
     * E.g. "north", "south", "east", or "west".
     * @return The current orientation of the moped, as a lowercase String.
     */
    public String getOrientation() {
        return this.orientation.toLowerCase();        
    }

    /**
     * Prints the current location, by default exactly following the format:
     *      Now at 12th St. and 5th Ave, facing South.
     *
     * If the current location is associated with location-based advertising, this method should print exactly following format:
     *      Now at 12th St. and 4th Ave, facing West.  Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?
     * 
     * Note that the suffixes for the numbers must be correct: i.e. the "st" in "1st", "nd" in "2nd", "rd" in "3rd", "th" in "4th", etc, must be correct.
     */
    public void printLocation() {
        if (this.getLocation()[0]%10==1) {
            System.out.printf("Now at %sst St. ",this.getLocation()[0]);
        }
        else if (this.getLocation()[0]%10==2) {
            System.out.printf("Now at %snd St. ",this.getLocation()[0]);
        }
        else if (this.getLocation()[0]%10==3) {
            System.out.printf("Now at %srd St. ",this.getLocation()[0]);
        }
        else {
            System.out.printf("Now at %sth St. ",this.getLocation()[0]);
        }
        if (this.getLocation()[1]%10==1) {
            System.out.printf("and %sst Ave, ",this.getLocation()[1]);
        }
        else if (this.getLocation()[1]%10==2) {
            System.out.printf("and %snd Ave, ",this.getLocation()[1]);
        }
        else if (this.getLocation()[1]%10==3) {
            System.out.printf("and %srd Ave, ",this.getLocation()[1]);
        }
        else {
            System.out.printf("and %sth Ave, ",this.getLocation()[1]);
        }
        if (this.getOrientation().equals("north")) {
            System.out.print("facing North. \n");
        }
        if (this.getOrientation().equals("west")) {
            System.out.print("facing West. \n");
        }
        if (this.getOrientation().equals("south")) {
            System.out.print("facing South. \n");
        }
        if (this.getOrientation().equals("east")) {
            System.out.print("facing East. \n");
        }
        if (this.getLocation()[0]==79 && this.getLocation()[1]==8) {
            System.out.println("Welcome to American Museum of Natural History!\n");
        }
        if (this.getLocation()[0]==74 && this.getLocation()[1]==1) {
            System.out.println("Welcome to Memorial Sloan Kettering!\n");
        }
        if (this.getLocation()[0]==56 && this.getLocation()[1]==3) {
            System.out.println("Welcome to Tina's Cuban Cuisine!\n");
        }
        if (this.getLocation()[0]==12 && this.getLocation()[1]==4) {
            System.out.println("Welcome to The Strand!\n");
        }
    }

    
    private String direction = "straight";

    public void setDirection(String direction) {
        this.direction=direction;
    }

    public String getDirection() {
        return this.direction;
    }
    /**
     * Handles the command, `go left`.
     * Moves the moped one block to the left, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goLeft() {
        if(this.getOrientation().equals("north")) {
            if (this.getDirection().equals("straight")) {
                this.setOrientation("west");
            }
            else {
                this.setOrientation("east");
            }
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[1]+=1;
            if ( 1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>0) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        } 
        else if(this.getOrientation().equals("west")) {
            if (this.getDirection().equals("straight")) {
                this.setOrientation("south");
            }
            else {
                this.setOrientation("north");
            }
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[0]=newLocation[0]-1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>0) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        }
        else if(this.getOrientation().equals("south")) {
            if (this.getDirection().equals("straight")) {
                this.setOrientation("east");
            }
            else {
                this.setOrientation("west");
            }
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[1]+=-1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>0) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        }
        else if (this.getOrientation().equals("east")) {
            if (this.getDirection().equals("straight")) {
                this.setOrientation("north");}
            else {
                this.setOrientation("south");
            }
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[0]+=1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>0) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        }
    }

    /**
     * Handles the command, `go right`.
     * Moves the moped one block to the right, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goRight() {
        if(this.getOrientation().equals("north")) {
            if (this.getDirection().equals("straight")) {
                this.setOrientation("east");
            }
            else {
                this.setOrientation("west");
            }
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[1]+=-1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>0) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        } 
        else if(this.getOrientation().equals("west")) {
            if (this.getDirection().equals("straight")) {
                this.setOrientation("north");
            }
            else {
                this.setOrientation("south");
            }
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[0]+=1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>0) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        }
        else if(this.getOrientation().equals("south")) {
            if (this.getDirection().equals("straight")) {
                this.setOrientation("west");
            }
            else {
                this.setOrientation("east");
            }
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[1]+=1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>0) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        }
        else if (this.getOrientation().equals("east")) {
            if (this.getDirection().equals("straight")) {
                this.setOrientation("south");
            }
            else {
                this.setOrientation("north");
            }
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[0]+=-1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>0) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        }
    }

    /**
     * Handles the command,`straight on`.
     * Moves the moped one block straight ahead.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goStraight() {
        this.setDirection("straight");
        if(this.getOrientation().equals("north")) {
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[0]+=1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>=5) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        } 
        else if(this.getOrientation().equals("west")) {
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[1]+=1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>=5) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        }
        else if(this.getOrientation().equals("south")) {
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[0]+=-1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>=5) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        }
        else if (this.getOrientation().equals("east")) {
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[1]+=-1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>=5) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        }
    }

    /**
     * Handles the command,`back up`.
     * Moves the moped one block backwards, but does not change the cardinal direction the moped is facing.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goBackwards() {
        this.setDirection("back");
        if(this.getOrientation().equals("north")) {
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[0]=newLocation[0]-1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>=0) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        } 
        if(this.getOrientation().equals("west")) {
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[1]=newLocation[1]-1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>0) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        }
        if(this.getOrientation().equals("south")) {
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[0]=newLocation[0]+1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>0) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        }
        if (this.getOrientation().equals("east")) {
            int[] newLocation=Arrays.copyOf(this.getLocation(),2);
            newLocation[1]=newLocation[1]+1;
            if (1<=newLocation[0] && newLocation[0]<=200 && 1<=newLocation[1] && newLocation[1]<=10 && this.getGasLevel()>0) {
                this.setLocation(newLocation);
                this.setGasLevel(this.getGasLevel()-5);
            }
        }
    }
    private int gaslevel = 100;
    public void setGasLevel(int gaslevel) {
        this.gaslevel=gaslevel;
    }

    /**
     * Handles the command,`how we doin'?`.
     * This method must not print anything.
     * @return The current gas level, as an integer from 0 to 100.
     */
    public int getGasLevel() {
        return this.gaslevel;
    }

    /**
     * Prints the current gas level, by default exactly following the format:
     *      The gas tank is currently 85% full.
     *
     * If the moped is out of gas, this method should print exactly following format:
     *      We have run out of gas.  Bye bye!
     */
    public void printGasLevel() {
        if (this.getGasLevel()>0) {
            System.out.printf("The gas tank is currently %s% full\n",this.getGasLevel());
        }
        if (this.getGasLevel()==0) {
            System.out.println("We have run out of gas. Bye bye!\n");
        }
    }

    /**
     * Handles the command, `fill it up`.
     * This method must not print anything.
     * Fills the gas level to the maximum.
     */
    public void fillGas() {
        this.setGasLevel(100);
    }

    /**
     * Handles the command, `park`.
     * This causes the program to quit.  
     * You can use System.exit(0); to cause a program to quit with status code 0, which indicates a normal graceful exit. 
     * (In case you were wondering, status code 1 represents quitting as a result of an error of some kind).
     */
    public void park() {
        System.out.println("We have parked.");
        // System.exit(0);
    }

    /**
     * Handles the command, `go to Xi'an Famous Foods`
     * Causes the moped to self-drive, block-by-block, to 8th Ave. and 15th St.
     * Consumes gas with each block, and doesn't move unless there is sufficient gas, as according to the instructions.
     */
    public void goToXianFamousFoods() {
        while (this.getLocation()[1]<8) {
            if (this.getGasLevel()<=10) {
                this.fillGas();
            }
            this.setOrientation("west");
            this.goStraight();
            this.printLocation();
        }
        while (this.getLocation()[1]>8) {
            if (this.getGasLevel()<=10) {
                this.fillGas();
            }
            this.setOrientation("east");
            this.goStraight();
            this.printLocation();
        }
        while (this.getLocation()[0]<15) {
            if (this.getGasLevel()<=10) {
                this.fillGas();
            }
            this.setOrientation("north");
            this.goStraight();
            this.printLocation();
        }
        while (this.getLocation()[0]>15) {
            if (this.getGasLevel()<=10) {
                this.fillGas();
            }
            this.setOrientation("south");
            this.goStraight();
            this.printLocation();
        }
        System.out.println("We have reached Xi'an Famous Foods.  Enjoy your noodles.");
    }
    

    /**
     * Generates a string, containing a list of all the user commands that the program understands.
     * @return String containing commands that the user can type to control the moped.
     */
    public String getHelp() {
        String allcommands="go left, go right, straight on, back up, how we doin'?, fill it up, park, go to Xi'an Famous Foods, help";
        return allcommands; // placeholder only... delete this!        
    }

    private int[] location = {10,5};
    /**
     * Sets the current location of the moped.
     * @param location an int array containing the new location at which to place the moped, in the order {street, avenue}.
     */
    public void setLocation(int[] location) {
         this.location = location;

    }

    /**
     * Gets the current location of the moped.
     * @return The current location of the moped, as an int array in the order {street, avenue}.
     */
    public int[] getLocation() {
        return this.location;
    }

}
