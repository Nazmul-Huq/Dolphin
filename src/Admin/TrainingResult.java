package Admin;

/**
 * written by Nazmul
 */
public class TrainingResult {

    private int swimmerId;
    private int swimmingDisciplineId;
    private int result;

    public TrainingResult(int swimmerId, int swimmingDisciplineId, int result) {
        this.swimmerId = swimmerId;
        this.swimmingDisciplineId = swimmingDisciplineId;
        this.result = result;
    }

    public int getSwimmerId() {
        return swimmerId;
    }

    public void setSwimmerId(int swimmerId) {
        this.swimmerId = swimmerId;
    }

    public int getSwimmingDisciplineId() {
        return swimmingDisciplineId;
    }

    public void setSwimmingDisciplineId(int swimmingDisciplineId) {
        this.swimmingDisciplineId = swimmingDisciplineId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }



    @Override
    public String toString() {
        return swimmerId + "," + swimmingDisciplineId + "," + result;
    }
}