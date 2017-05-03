package se.kth.iv1350.model;

/**
 * Created by User on 2017-05-01.
 */
public class Garage {
    private Display display;
    private boolean doorOpen;

    public Garage() {
        display = new Display();
    }

    /**
     * Opens the garage door and updates the queue number on the display
     */
    public void nextCustomer(){
        display.displayNextNumber();
        openDoor();
    }

    /**
     * Opens the garage door
     */
    public void openDoor(){
        this.doorOpen = true;
        //Print outs for dummy implementation
        System.out.println("Garage door is open!");
    }

    /**
     * Closes the garage door
     */
    public void closeDoor(){
        this.doorOpen = false;
        //Print outs for dummy implementation
        System.out.println("Garage door is closed!");
    }
}
