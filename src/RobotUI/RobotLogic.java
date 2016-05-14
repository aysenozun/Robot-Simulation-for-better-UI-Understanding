package RobotUI;

import static RobotUI.UIPresentation.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

/**
 *
 * @author Keerthi Bala Sundram & Aastha Dixit : The RobotLogic Class represents the Business Tier Class, and
 * contains for the movement of the robot, and control panel actions of the
 * application.
 */
public class RobotLogic {

    /*SPEED variable controls the speed of the robot. The value of this variable indicates the speed of the robot ranging
     from 0 to 100.*/
    int SPEED = 50;

    RobotLogic() {
    }

    /*  
     currentTemperature method generates a random room temperature and passes the value in a String format
     to the calling function.
     */
    public String currentTemperature() {

        double random = (Math.random() * 10) + 70;
        String tempVal = String.valueOf(random);
        tempVal = tempVal.substring(0, 5);
        return tempVal;
    }

    /*
     brake method controls the movement of the robot 
     by stopping all the timers responsible  for movement of Robot.
     */
    public void brake() {
        if (f.isRunning()) {
            f.stop();
        }
        if (b.isRunning()) {
            b.stop();
        }

        fbFlag = 0;
    }

    /*
     armSliderLogic method controls the arm movement. Based on the arm slider in the control panel,
     the value is fetched, and passed to this method via a static variable(theta). Based on the theta
     value, the arm is moved 0-90degrees
     */
    public void armSliderLogic() {

        theta += 90;

        sx2 = (int) (sx1 + 80 * Math.sin(Math.toRadians(theta)));
        sy2 = (int) (sy1 + 80 * Math.cos(Math.toRadians(theta)));
        sx3 = (int) (sx1 + 100 * Math.sin(Math.toRadians(theta)));
        sy3 = (int) (sy1 + 100 * Math.cos(Math.toRadians(theta)));
        theta += 400;
        sx4 = (int) (sx2 + 25 * Math.sin(Math.toRadians(theta)));
        sy4 = (int) (sy2 + 25 * Math.cos(Math.toRadians(theta)));

        theta -= 260;
        sx5 = (int) (sx2 - 25 * Math.sin(Math.toRadians(theta)));
        sy5 = (int) (sy2 - 25 * Math.cos(Math.toRadians(theta)));

        ui.repaint();

    }
    /*
     * Speed method controls the speed of the robot. Obtains the slider value of the speed
     * from the control panel, and based on the slider value the delay of the timer is adjusted which in turn controls 
     * the speed of the robot.
     */

    public void speed(int speedvalue) {

        SPEED = 101 - speedvalue;
        f.setDelay(SPEED);
        b.setDelay(SPEED);
    }

    /*Below Timer b - is for controlling the actions of the Robot's backward movement.
     The timer uses the SPEED variable and lrFlag, fbFlag variables.
     */
    Timer b = new Timer(SPEED, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (f.isRunning()) {
                f.stop();
            }
            //The Robot has 8 defined rotationary paths(in backward motion), and logic for each path goes here
            switch (lrFlag) {
                case 5:

                    if (y > 110) {

                        y--;
                        y1--;
                        y2--;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;

                case 6:

                    if (y > 110 && x < 460) {
                        x++;
                        x1++;
                        x2++;
                        y--;
                        y1--;
                        y2--;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;

                case 7:
                    if (x < 460) {
                        x++;
                        x1++;
                        x2++;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;
                case 8:
                    if (x < 460 && y < 340) {
                        x++;
                        x1++;
                        x2++;
                        y++;
                        y1++;
                        y2++;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;
                case 1:
                    if (y < 340) {
                        y++;
                        y1++;
                        y2++;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;
                case 2:
                    if (y < 340 && x > 50) {
                        y++;
                        y1++;
                        y2++;
                        x--;
                        x1--;
                        x2--;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;

                case 3:
                    if (x > 50) {
                        x--;
                        x1--;
                        x2--;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;
                case 4:
                    if (y > 110 && x > 50) {
                        x--;
                        x1--;
                        x2--;
                        y--;
                        y1--;
                        y2--;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
    );
    /*Below Timer f - is for controlling the actions of the Robot's forward movement.
     The timer uses the SPEED variable and lrFlag, fbFlag variables.
     */
    Timer f = new Timer(SPEED, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (b.isRunning()) {
                b.stop();
            }
            //The Robot has 8 defined rotationary paths(in backward motion), and logic for each path goes here
            switch (lrFlag) {
                case 1:

                    if (y > 110) {

                        y--;
                        y1--;
                        y2--;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;

                case 2:

                    if (y > 110 && x < 460) {
                        x++;
                        x1++;
                        x2++;
                        y--;
                        y1--;
                        y2--;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;

                case 3:
                    if (x < 460) {
                        x++;
                        x1++;
                        x2++;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;
                case 4:
                    if (x < 460 && y < 340) {
                        x++;
                        x1++;
                        x2++;
                        y++;
                        y1++;
                        y2++;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;
                case 5:
                    if (y < 340) {
                        y++;
                        y1++;
                        y2++;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;
                case 6:
                    if (y < 340 && x > 50) {
                        y++;
                        y1++;
                        y2++;
                        x--;
                        x1--;
                        x2--;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;

                case 7:
                    if (x > 50) {
                        x--;
                        x1--;
                        x2--;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;
                case 8:
                    if (y > 110 && x > 50) {
                        x--;
                        x1--;
                        x2--;
                        y--;
                        y1--;
                        y2--;
                        ui.repaint();
                    } else {
                        if (f.isRunning()) {
                            f.stop();
                        }
                    }
                    break;
                default:
                    break;
            }
        }

    }
    );

    /*
     The resize method is used for resizing the given image according to the given width, and height.
     The method uses Graphics class.
     The method accepts Image which has to be resized, height and width as its parameters and returns
     a rotated Buffered Image
     */
    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    /*
     The method contains logic for right,left turns of the robot. It also sets the movement of the robot
     in appropriate direction indicated by the flags for forward and backward movement of the robot.
     */
    public void common() {
        ui.repaint();

//The swtich case handles the 8 rotatory movements of the robot. It sets the co-ordinates for the nose of the robot,
// to simulate the robot movement.
        switch (lrFlag) {

            case 1:
                x1 = x + radius / 2;
                y1 = y + radius / 2;
                x2 = x + radius / 2;
                y2 = y - radius + 3;
                if (fbFlag == 1) {
                    if (b.isRunning()) {
                        b.stop();
                    }
                    f.start();

                } else if (fbFlag == 2) {
                    if (f.isRunning()) {
                        f.stop();
                    }
                    b.start();
                }

                break;

            case 2:
                x1 = x + radius / 2;
                y1 = y + radius / 2;
                x2 = x + 3 * radius / 2 - 3;
                y2 = y - radius / 2 + 3;
                if (fbFlag == 1) {
                    if (b.isRunning()) {
                        b.stop();
                    }
                    f.start();

                } else if (fbFlag == 2) {
                    if (f.isRunning()) {
                        f.stop();
                    }
                    b.start();
                }

                break;

            case 3:
                x1 = x + radius / 2;
                y1 = y + radius / 2;
                x2 = x + 2 * radius - 3;
                y2 = y + radius / 2;
                if (fbFlag == 1) {
                    if (b.isRunning()) {
                        b.stop();
                    }
                    f.start();

                } else if (fbFlag == 2) {
                    if (f.isRunning()) {
                        f.stop();
                    }
                    b.start();
                }
                break;

            case 4:
                x1 = x + radius / 2;
                y1 = y + radius / 2;
                x2 = x + 3 * radius / 2 - 3;
                y2 = y + 3 * radius / 2 - 3;
                if (fbFlag == 1) {
                    if (b.isRunning()) {
                        b.stop();
                    }
                    f.start();

                } else if (fbFlag == 2) {
                    if (f.isRunning()) {
                        f.stop();
                    }
                    b.start();
                }
                break;
            case 5:
                x1 = x + radius / 2;
                y1 = y + radius / 2;
                x2 = x + radius / 2;
                y2 = y + 2 * radius - 3;
                if (fbFlag == 1) {
                    if (b.isRunning()) {
                        b.stop();
                    }
                    f.start();

                } else if (fbFlag == 2) {
                    if (f.isRunning()) {
                        f.stop();
                    }
                    b.start();
                }
                break;

            case 6:
                x1 = x + radius / 2;
                y1 = y + radius / 2;
                x2 = x - radius / 2 + 3;
                y2 = y + 3 * radius / 2 - 3;
                if (fbFlag == 1) {
                    if (b.isRunning()) {
                        b.stop();
                    }
                    f.start();

                } else if (fbFlag == 2) {
                    if (f.isRunning()) {
                        f.stop();
                    }
                    b.start();
                }
                break;
            case 7:
                x1 = x + radius / 2;
                y1 = y + radius / 2;
                x2 = x - radius + 3;
                y2 = y + radius / 2;
                if (fbFlag == 1) {

                    if (b.isRunning()) {
                        b.stop();
                    }
                    f.start();

                } else if (fbFlag == 2) {
                    if (f.isRunning()) {
                        f.stop();
                    }
                    //       f.stop();
                    b.start();
                }
                break;

            case 8:
                x1 = x + radius / 2;
                y1 = y + radius / 2;
                x2 = x - radius / 2 + 3;
                y2 = y - radius / 2 - 3;
                if (fbFlag == 1) {

                    if (b.isRunning()) {
                        b.stop();
                    }
                    f.start();

                } else if (fbFlag == 2) {
                    if (f.isRunning()) {
                        f.stop();
                    }
                    //       f.stop();
                    b.start();
                }
                break;

        }
    }
}
