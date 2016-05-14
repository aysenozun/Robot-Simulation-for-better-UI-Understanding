package RobotUI;

/**
 *
 * @author Keerthi Bala Sundram, Aastha Dixit - The RobotClass is an entity class that holds the attributes
 * of the Robot
 */
public class RobotClass {

    //Attributes of robot are declared as member variables here
    boolean forward;
    boolean backward;
    String speed;
    int lrToggle;
    int lHand;
    int rHand;
    boolean lClaw;
    boolean rClaw;
    boolean capture;

    //Getter & Setter Methods for the attributes are declared below
    public boolean isForward() {
        return forward;
    }

    public void setForward(boolean forward) {
        this.forward = forward;
    }

    public boolean isBackward() {
        return backward;
    }

    public void setBackward(boolean backward) {
        this.backward = backward;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public int getLrToggle() {
        return lrToggle;
    }

    public void setLrToggle(int lrToggle) {
        this.lrToggle = lrToggle;
    }

    public int getlHand() {
        return lHand;
    }

    public void setlHand(int lHand) {
        this.lHand = lHand;
    }

    public int getrHand() {
        return rHand;
    }

    public void setrHand(int rHand) {
        this.rHand = rHand;
    }

    public boolean islClaw() {
        return lClaw;
    }

    public void setlClaw(boolean lClaw) {
        this.lClaw = lClaw;
    }

    public boolean isrClaw() {
        return rClaw;
    }

    public void setrClaw(boolean rClaw) {
        this.rClaw = rClaw;
    }

    public boolean isCapture() {
        return capture;
    }

    public void setCapture(boolean capture) {
        this.capture = capture;
    }

    boolean setForward() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
