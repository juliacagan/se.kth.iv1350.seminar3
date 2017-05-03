package se.kth.iv1350.model;

/**
 * Created by User on 2017-05-01.
 */
public class InspectionList {

    private Inspection[] inspections;
    private int currentIndex;
    private int numberOfInspections;

    /**
     * Creates a new instance of InspectionList.
     * @param inspections an array of inspections.
     */
    public InspectionList(Inspection[] inspections) {
        this.inspections = inspections;
        currentIndex = 0;
        numberOfInspections = inspections.length;
    }

    public void setInspections(Inspection[] inspections) {
        this.inspections = inspections;
    }

    /**
     * Resets the <code>currentIndex</code> to zero.
     */
    public void resetCurrentIndex(){
        this.currentIndex = 0;
    }

    /**
     *
     * @return true if there exists another inspection on the list, false otherwise.
     */
    public boolean hasNext(){
        return currentIndex < numberOfInspections;
    }

    /**
     * Fetches the next inspection on the list.
     * @return the next inspection.
     */
    public Inspection getNextInspection() {
        try{
            return inspections[currentIndex++];
        } catch (Exception e){
            System.out.println(e);
            return null;
        }

    }
}
