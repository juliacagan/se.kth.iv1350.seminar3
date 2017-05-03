package se.kth.iv1350.model;

/**
 * Created by User on 2017-05-01.
 */
public class Display {
    private int currentNumber;

    /**
     * Creates a new instance of Display. Sets the current display number to zero.
     */
    public Display() {
        this.currentNumber = 0;
    }

    /**
     * Increments the current number on the display
     */
    void displayNextNumber(){
        this.currentNumber++;
        display();
    }

    /**
     * A dummy implementation writing out the current display number to the standard output
     */
    private void display(){
        System.out.println("Display: Updating display number: " + this.currentNumber);
    }
}
