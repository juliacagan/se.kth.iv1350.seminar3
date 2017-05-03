package se.kth.iv1350.model;

/**
 * Created by User on 2017-05-01.
 */
public class InspectionList {

    private Inspection[] inspections;
    private int currentIndex;
    private int numberOfInspections;

    /**
     * Set the inspection list and initializes iterator
     * @param inspections an <code>Inspection</code> array
     */
    public void setInspections(Inspection[] inspections) {
        this.inspections = inspections;
        currentIndex = 0;
        numberOfInspections = inspections.length;
    }

    /**
     * Updates the list without resetting the iterator
     * @param inspections the updated list
     */
    public void updatesCurrentList(Inspection[] inspections){
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
