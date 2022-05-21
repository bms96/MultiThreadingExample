import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class GUI extends JFrame implements Runnable{

    int count = 0;
    // Function Panel
   Calendar calender;
   SimpleDateFormat timeFormat;
   JLabel timeLabel;
   String time;
   String status;

    BufferedImage blankLight = ImageIO.read(new File("images/blankLight.png"));
    BufferedImage redLight = ImageIO.read(new File("images/redLight.png"));
    BufferedImage yellowLight = ImageIO.read(new File("images/yellowLight.png"));
    BufferedImage greenLight = ImageIO.read(new File("images/greenLight.png"));

    JLabel blankLightLabel = new JLabel(new ImageIcon(blankLight));
    JLabel redLightLabel = new JLabel(new ImageIcon(redLight));
    JLabel yellowLightLabel = new JLabel(new ImageIcon(yellowLight));
    JLabel greenLightLabel = new JLabel(new ImageIcon(greenLight));

    JLabel light1 = new JLabel("Light 1:");
    JLabel light1Status = new JLabel("STATUS");


    JLabel light2 = new JLabel("Light 2:");
    JLabel light2Status = new JLabel("STATUS");

    JLabel light3 = new JLabel("Light 3:");
    JLabel light3Status = new JLabel("STATUS");

    JLabel outputNotificationLabel = new JLabel("Output is in the console. Car distance and km/hr is calculated and reported every 250 meters");



    JLabel light1Image = new JLabel(new ImageIcon(blankLight));
    JLabel light2Image;
    JLabel light3Image;

    private static final JButton startBtn = new JButton("Start");
    private static final JButton pauseBtn = new JButton("Pause");
    private static final JButton stopBtn = new JButton("Stop");

    public GUI() throws InterruptedException, IOException {
        outputNotificationLabel.setVisible(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        timeLabel = new JLabel();

        // Function Panel
        JPanel functionPanel = new JPanel();
        functionPanel.setBackground(Color.lightGray);
        functionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        functionPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        pauseBtn.setEnabled(false);
        stopBtn.setEnabled(false);

        startBtn.addActionListener(e -> {

            outputNotificationLabel.setVisible(true);

            TrafficLight light1 = new TrafficLight(1000, "GREEN", "1");
            Thread light1Thread = new Thread(light1);


            TrafficLight light2 = new TrafficLight(2000, "YELLOW", "2");
            Thread light2Thread = new Thread(light2);


            TrafficLight light3 = new TrafficLight(3000, "RED", "3");
            Thread light3Thread = new Thread(light3);


            Car car1 = new Car("1", light1, light2, light3);
            Thread car1Thread = new Thread(car1);

            Car car2 = new Car("2", light1, light2, light3);
            Thread car2Thread = new Thread(car2);

            Car car3 = new Car("3", light1, light2, light3);
            Thread car3Thread = new Thread(car3);

            light1Thread.start();
            light2Thread.start();
            light3Thread.start();

            car1Thread.start();
            System.out.println("Car 1 has entered the scene");

            car2Thread.start();
            System.out.println("Car 2 has entered the scene");

            car3Thread.start();
            System.out.println("Car 3 has entered the scene");

            startBtn.setEnabled(false);
//            pauseBtn.setEnabled(true);
            stopBtn.setEnabled(true);

        });





        functionPanel.add(timeLabel);
        functionPanel.add(startBtn);
        functionPanel.add(pauseBtn);
        functionPanel.add(stopBtn);

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                if(count / 2 == 0) {
//                    functionPanel.add(blankLightLabel);
//                } else if (count / 3 == 0) {
//                    functionPanel.remove(blankLightLabel);
//                    functionPanel.add(redLightLabel);
//                }
//                System.out.println("Hello");
//
//                count++;
            }
        });


        stopBtn.addActionListener(e -> {
            System.exit(0);
        });

        // Scene Panel
        JPanel scenePanel = new JPanel();
        scenePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        scenePanel.add(blankLightLabel);
        scenePanel.add(redLightLabel);
        scenePanel.add(yellowLightLabel);
        scenePanel.add(greenLightLabel);

        scenePanel.add(light1);
        scenePanel.add(light1Status);


//        scenePanel.add(light1Image);
        scenePanel.add(light2);
        scenePanel.add(light2Status);

        scenePanel.add(light3);
        scenePanel.add(light3Status);

        scenePanel.add(outputNotificationLabel);


        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(functionPanel,BorderLayout.NORTH);
        this.add(scenePanel,BorderLayout.CENTER);

        this.setTitle("Traffic Light Simulator");

        this.setVisible(true);

        setTime();
    }

    public void setTime() throws InterruptedException {
        while(true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            Thread.sleep(1000);
        }
    }
    public void setLightStatus(TrafficLight light) {

        while (true) {
            if (light.getLightStatus().equals("RED")) {
                light1Status.setText("RED");
            }

            if (light1Status.getText().equals("RED")) {
                light1Status.setText("GREEN");
            }


            light1Status.setText("YELLOW");


            light1Status.setText("RED");
        }


    }

    public void setLight() throws InterruptedException, IOException {
        while(true) {

            light1Image.setIcon(new ImageIcon(blankLight));
            Thread.sleep(1000);
            light1Image.setIcon(new ImageIcon(redLight));
            Thread.sleep(1000);
            light1Image.setIcon(new ImageIcon(greenLight));
            Thread.sleep(1000);
        }
    }

    @Override
    public void run() {
    }
}
