public class StepCounter {
    static int totalStepsAllUsers;
    private int individualSteps;

    public void walk(int steps){
        this.individualSteps=steps;
        totalStepsAllUsers += steps;
    }

    public static void resetGlobalSteps(){
        totalStepsAllUsers=0;
    }

    public int getIndividualSteps(){
        return individualSteps;
    }
}
