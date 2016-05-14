package RobotUI;

/**
 *
 * @author Aastha Dixit, and Keerthi Bala Sundram - The UIPresentation class is the presentation tier of the
 * Robot Application. This class controls the drawings, rendering of graphical
 * elements of the application. This class is also the started class for the
 * Robot application.
 *
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class UIPresentation extends javax.swing.JFrame implements KeyListener {

    RobotLogic roboLogic; //instance variable of the RobotLogic Class
    RobotClass robot = new RobotClass(); // instance variable of the Robot Entity class

    // The image to be displayed in the camera is taken via an InputStream. The image is placced inside
    //the project folder.
    InputStream in = getClass().getResourceAsStream("/RobotUI/minion.jpeg");
    //The (x,y) - center coordinates of the circle and radius are defined here. 
    static int x = 140, y = 235, radius = 20;
    // This is the x,y values used for capturing the camera image resize.
    int dx = 30, dy = 60;

    static UIPresentation ui; //instance variable of this class used for dislaying the presentation
    // the below variables are used for representing x,y co-ordinates to the the Robot's nose line.
    static int x1 = x + radius / 2, y1 = y + radius / 2, x2 = x + radius / 2, y2 = y - radius + 3;
    static int sx3 = 730;
    static int sy3 = 220;
    static int sx4 = 720;
    static int sy4 = 240;
    static int sx5 = 720;
    static int sy5 = 200;
    static int sx1 = 620;
    static int sy1 = 220;
    static int sx2 = 700;
    static int sy2 = 220;

    BufferedImage bufImg; //Instance for setting buffered image

    int clawFlag = 0; //this variable acts as a flag for open/closing of the Robot's claw
    static int theta = 180; // default value of the Robot's rotation angle
    Image image; // temporary variable used for converting Buffered Images rotation
    int tempPress = 0; // this variable acts as a flag for displaying/hiding room temprature
    int rotateR = 0, rotateL = 0; // flag to indicate/stop left-right rotation of the Robot
    static int fbFlag = 0; // flag for storing the forward/backward key press
    static int lrFlag = 1; // flag for storing the current rotationary path of the Robot

    public UIPresentation() throws IOException {

        initComponents();
        robot.setForward(false);
        robot.setBackward(false);
        robot.setSpeed("Medium");
        robot.setLrToggle(1);
        robot.setlHand(0);
        robot.setrHand(0);
        robot.setlClaw(false);
        robot.setrClaw(false);
        robot.setCapture(false);
        addKeyListener(this);
        setFocusable(true);
        armSlider.setMaximum(90);
        armSlider.setValue(0);
        roboLogic = new RobotLogic();
        bufImg = ImageIO.read(in);
        image = bufImg.getScaledInstance(display.getWidth() - 10, display.getHeight() - 10, Image.SCALE_SMOOTH);

    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        //drawing code for the Robot's Top View goes here
        g.setColor(Color.red);
        g.drawLine(x1, y1, x2, y2);
        g.setColor(Color.BLACK);
        g.fillOval(x, y, radius, radius);

        //code for side view of the Robot  begins here
        g.fillOval(600, 150, 30, 30);
        g.fillRect(600, 180, 30, 100);
        g.fillRoundRect(600, 280, 40, 20, 5, 5);
        g.setColor(Color.RED);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(620, 220, sx2, sy2);
        g.setColor(Color.RED);
        g.fillOval(sx2 - 8, sy2 - 8, 15, 15);

        //code for opening/closing of claw goes below
        if (clawFlag == 1) {

            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine(sx2, sy2, sx3, sy3);
            g2d.drawLine(sx2, sy2, sx4, sy4);
            g2d.drawLine(sx2, sy2, sx5, sy5);

        }
        //cursor is in default mode
        setCursor(new Cursor(0));

        //code for display of camera image goes here
        display.setBounds(10, 30, image.getWidth(this) + 10, image.getHeight(this) + 10);
        display.setIcon(new ImageIcon(image));
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        canvas1 = new java.awt.Canvas();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jBackward = new javax.swing.JToggleButton();
        jForward = new javax.swing.JToggleButton();
        tempBtn = new javax.swing.JButton();
        clawBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        speed = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        armSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        left = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        brake = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        rightBtn = new javax.swing.JToggleButton();
        leftBtn = new javax.swing.JToggleButton();
        jPanel6 = new javax.swing.JPanel();
        display = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        org.jdesktop.layout.GroupLayout jFrame1Layout = new org.jdesktop.layout.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Side View"));
        jPanel4.setMaximumSize(new java.awt.Dimension(12, 29));

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 302, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 279, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Robot Application");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 841, 725));
        setMaximumSize(new java.awt.Dimension(841, 725));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Control Panel"));
        jPanel1.setMaximumSize(new java.awt.Dimension(498, 347));

        jBackward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RobotUI/down3.PNG"))); // NOI18N
        jBackward.setToolTipText("Toggles robot in reverse direction until stopped by pressing the key again.");
        jBackward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBackwardMousePressed(evt);
            }
        });
        jBackward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackwardActionPerformed(evt);
            }
        });

        jForward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RobotUI/up3.PNG"))); // NOI18N
        jForward.setToolTipText("Toggles robot forward until stopped by pressing the key again.");
        jForward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jForwardMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jForwardMousePressed(evt);
            }
        });
        jForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jForwardActionPerformed(evt);
            }
        });
        jForward.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jForwardKeyPressed(evt);
            }
        });

        tempBtn.setText("Temperature");
        tempBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempBtnActionPerformed(evt);
            }
        });

        clawBtn.setText("Claw Open/Close");
        clawBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clawBtnActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Speed"));

        speed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                speedStateChanged(evt);
            }
        });

        jLabel2.setText("Fast");

        jLabel1.setText("Slow");

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel2))
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(0, 2, Short.MAX_VALUE)
                        .add(speed, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(speed, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Arm Movement"));

        armSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                armSliderMouseDragged(evt);
            }
        });

        jLabel3.setText("0");

        jLabel4.setText("90");

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel7Layout.createSequentialGroup()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(armSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .add(jPanel7Layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel4)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel7Layout.createSequentialGroup()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(armSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        left.setText("Left");

        jLabel6.setText("Right");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Forward");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Reverse");

        brake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RobotUI/Stop.PNG"))); // NOI18N
        brake.setToolTipText("STOPS robot movement.");
        brake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brakeActionPerformed(evt);
            }
        });

        rightBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RobotUI/right3.PNG"))); // NOI18N
        rightBtn.setToolTipText("Rotates robot in the right direction until stopped by pressing the key again.");
        rightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightBtnActionPerformed(evt);
            }
        });

        leftBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RobotUI/left3.PNG"))); // NOI18N
        leftBtn.setToolTipText("Rotates robot in left direction until stopped by pressing the key again.");
        leftBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftBtnActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(58, 58, 58)
                        .add(tempBtn, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(51, 51, 51)
                        .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 201, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(96, 96, 96)
                                .add(jLabel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(70, 70, 70))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(100, 100, 100)
                                .add(jLabel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .add(65, 65, 65))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel1Layout.createSequentialGroup()
                                        .add(38, 38, 38)
                                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(jPanel1Layout.createSequentialGroup()
                                                .add(0, 0, Short.MAX_VALUE)
                                                .add(jBackward, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                            .add(jPanel1Layout.createSequentialGroup()
                                                .add(left, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                .add(leftBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(brake, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                    .add(jPanel1Layout.createSequentialGroup()
                                        .add(120, 120, 120)
                                        .add(jForward, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .add(4, 4, 4)
                                .add(rightBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .add(34, 34, 34)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(clawBtn, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(12, 12, 12)))))
                .add(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(clawBtn, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 87, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jForward, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(6, 6, 6)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(brake, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(leftBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                                        .add(left, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                        .add(1, 1, 1)))
                                .add(2, 2, 2))
                            .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, rightBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .add(5, 5, 5)
                        .add(jBackward, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(56, 56, 56)))
                .add(19, 19, 19)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tempBtn, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(25, 25, 25))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Camera"));
        jPanel6.setMaximumSize(new java.awt.Dimension(298, 173));
        jPanel6.setMinimumSize(new java.awt.Dimension(298, 173));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        display.setToolTipText("Resize image by dragging from the bottom right corner.");
        display.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                displayMouseMoved(evt);
            }
        });
        display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                displayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                displayMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                displayMouseReleased(evt);
            }
        });
        jPanel6.add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 30, 178, 130));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Robot Movement", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Top View"));
        jPanel3.setMaximumSize(new java.awt.Dimension(376, 308));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Side View"));

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 274, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 305, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Robot User Interface");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     This method contains the logic for display of the current room temperature.
     This method invokes the currentTemperature method of the RoboLogic Class
    
     */
    private void tempBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempBtnActionPerformed
        if (tempPress == 0) {
            tempPress = 1;

            jLabel9.setText("Current Temperature: " + roboLogic.currentTemperature());

        } else {
            tempPress = 0;
            jLabel9.setText("");
        }
        repaint();
    }//GEN-LAST:event_tempBtnActionPerformed

    private void jForwardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jForwardMousePressed

    }//GEN-LAST:event_jForwardMousePressed

    private void jBackwardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackwardMousePressed

    }//GEN-LAST:event_jBackwardMousePressed


    private void jForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jForwardActionPerformed
//On pressing the forwad button, the flag is set to 1
        if (fbFlag == 0 || fbFlag == 2) {
            fbFlag = 1;
            roboLogic.common();
        } else {
            fbFlag = 0;
        }


    }//GEN-LAST:event_jForwardActionPerformed


    private void jForwardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jForwardMouseClicked

    }//GEN-LAST:event_jForwardMouseClicked

    private void jBackwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackwardActionPerformed
        //On pressing the backward button, the flag is set to 2

        if (fbFlag == 0 || fbFlag == 1) {
            fbFlag = 2;
            roboLogic.common();
        } else {
            fbFlag = 0;
        }
    }//GEN-LAST:event_jBackwardActionPerformed

    /*
     The below method stops all the timers that are responsible for the robots movement.
     There are 4 timers for controlling the robot.
     */
    private void brakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brakeActionPerformed

        roboLogic.brake();
        if (l.isRunning()) {
            l.stop();
        }
        if (r.isRunning()) {
            r.stop();
        }


    }//GEN-LAST:event_brakeActionPerformed
    /*
     This method sets the speed of the Robot according to the speed of the slider
     */
    private void speedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_speedStateChanged

        int speedvalue = speed.getValue();//gets the value of the speed slider from the control panel
        roboLogic.speed(speedvalue); // calls the speed method of the RobotLogic class


    }//GEN-LAST:event_speedStateChanged

    private void jForwardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jForwardKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jForwardKeyPressed
    /*
     This method sets the arm to a particular angle according to the value of the arm slider 
     */

    private void armSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_armSliderMouseDragged

        theta = armSlider.getValue(); //gets the value of the slider's value
        roboLogic.armSliderLogic(); //calls the arm slider logic function in the RobotLogic class

    }//GEN-LAST:event_armSliderMouseDragged
    /*
     This method controls the opening and closing of the claws
     */
    private void clawBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clawBtnActionPerformed
        // TODO add your handling code here:

        if (clawFlag == 1) {
            clawFlag = 0;
        } else {
            clawFlag = 1;
        }

        repaint();

    }//GEN-LAST:event_clawBtnActionPerformed

    private void displayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayMouseReleased

        //c,y coordinates of the mouse click
        dx = evt.getX();
        dy = evt.getY();

        //restricts the camera image to a specific dimension
        if (dx > 273) {
            dx = 273;
        }
        if (dy > 290) {
            dy = 290;
        }

        image = bufImg.getScaledInstance(dx - 10, dy - 10, Image.SCALE_SMOOTH); //the image is resized using an inbuilt function
        repaint();

    }//GEN-LAST:event_displayMouseReleased

    private void displayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayMouseEntered
        // the cursor is set to resize mode on entering the panel
        setCursor(new Cursor(5));

    }//GEN-LAST:event_displayMouseEntered

    private void displayMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayMouseMoved
        // TODO add your handling code here:


    }//GEN-LAST:event_displayMouseMoved

    private void displayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayMouseExited
        // the cursor is set to default mode on exiting the panel
        setCursor(new Cursor(0));
    }//GEN-LAST:event_displayMouseExited

    /*
     This method rotates the Robot to the left direction. 
     */
    private void leftBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftBtnActionPerformed
        if (rotateR == 0) {
            rotateR = 1;

            l.stop();
            r.start();
        } else {
            rotateR = 0;
            r.stop();
        }
    }//GEN-LAST:event_leftBtnActionPerformed
    /*
     This method rotates the Robot to the right direction. 
     */
    private void rightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightBtnActionPerformed
        if (rotateL == 0) {
            rotateL = 1;
            r.stop();
            l.start();
        } else {
            rotateL = 0;
            l.stop();
        }

    }//GEN-LAST:event_rightBtnActionPerformed
   // Timer for left movement of the Robot
    Timer l = new Timer(200, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (lrFlag != 8) {
                lrFlag++;
            } else {
                lrFlag = 1;
            }
            roboLogic.common();
        }
    });
// Timer for right movement of the Robot
    Timer r = new Timer(200, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (lrFlag != 1) {
                lrFlag--;
            } else {
                lrFlag = 8;
            }
            roboLogic.common();
        }
    });

    public static void main(String args[]) throws IOException {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {

            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx = 0; idx < installedLookAndFeels.length; idx++) {
                if ("Windows".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
            }
            ui = new UIPresentation();
            ui.setVisible(true);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider armSlider;
    private javax.swing.JButton brake;
    private java.awt.Canvas canvas1;
    private javax.swing.JButton clawBtn;
    private javax.swing.JButton display;
    private javax.swing.JToggleButton jBackward;
    private javax.swing.JToggleButton jForward;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel left;
    private javax.swing.JToggleButton leftBtn;
    private javax.swing.JToggleButton rightBtn;
    private javax.swing.JSlider speed;
    private javax.swing.JButton tempBtn;
    // End of variables declaration//GEN-END:variables

    public void keyTyped(KeyEvent e) {
        //  System.out.println("typed");
    }

    public void keyPressed(KeyEvent e) {

        // System.out.println("pressed" + e.getKeyCode());
        int keycode = e.getKeyCode();

        switch (keycode) {
            case 37:

                if (lrFlag != 1) {
                    lrFlag--;
                } else {
                    lrFlag = 8;
                }

                break;

            case 38:

                fbFlag = 1;

                break;
            case 39:
                if (lrFlag != 8) {
                    lrFlag++;
                } else {
                    lrFlag = 1;
                }

                break;

            case 40:
                fbFlag = 2;

                break;
        }
        roboLogic.common();
    }

    public void keyReleased(KeyEvent e) {
        // System.out.println("released");
    }

}
