/*
Bryan Santini
5/9/2022
CMSC 335 Spring

This program uses swing and multithreading to track Car object threads as they interact
with TrafficLight object threads. The Swing GUI should be a visual representation of this,
but I unfortunately could not get it to work in time. The program can be started and
stopped in the GUI, but the output is in the console. There are three Car threads that run
concurrently with three TrafficLight threads.
*/
import java.io.IOException;

public class Main {
    public static void main(String[] args)  throws IOException, InterruptedException{

        new GUI();


//        SwingUtilities.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                try {
//                    new GUI();
//                } catch (InterruptedException | IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Time time = new Time();
//        Thread timeThread = new Thread(time);
//        timeThread.start();



//        System.out.println(time.getTime());
    }
}
