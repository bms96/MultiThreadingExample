import javax.swing.*;
import java.util.Calendar;

public class Time implements Runnable{

    private String time;

    @Override
    public void run() {
        while (true) {

            Calendar now = Calendar.getInstance();
            int hour = now.get(Calendar.HOUR);
            int minute = now.get(Calendar.MINUTE);
            int second = now.get(Calendar.SECOND);

            System.out.println(
                    hour + ":" + minute + ":" + second
            );

            String Time = hour + ":" + minute + ":" + second;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public String getTime() {
        return time;
    }
}
