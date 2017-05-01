package se.kth.iv1350.model;

/**
 * Created by User on 2017-05-01.
 */
public class Inspection {

    private int cost;
    private String description;

    /**
     * Creates a new instance of Inspection.
     * @param cost  The cost of the inspection.
     * @param description  A description of the inspection.
     */
    public Inspection(int cost, String description) {
        this.cost = cost;
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Inspection))
            return false;
        Inspection otherInspection = (Inspection) obj;
        if (otherInspection.getCost() == this.cost && otherInspection.getDescription() == this.description)
            return true;
        return false;
    }

    public int getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }
}
