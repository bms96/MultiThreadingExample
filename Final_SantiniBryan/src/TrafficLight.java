public class TrafficLight implements Runnable{



    private final int yPosition;
    private String lightStatus;
    private final String lightNumber;

    public TrafficLight(int yPosition, String lightStatus, String lightNumber) {

        this.yPosition = yPosition;
        this.lightStatus = lightStatus;
        this.lightNumber = lightNumber;
    }

    public int getYPosition() {
        return yPosition;
    }

    public String getLightStatus() {
        return lightStatus;
    }

    public String getLightNumber() {
        return lightNumber;
    }

    @Override
    public void run() {
        while(true) {
            if (this.lightStatus.equals("GREEN")) {
                try {
                    Thread.sleep(3000);
                    this.lightStatus = "YELLOW";
                    System.out.println("Traffic Light " + lightNumber + " is YELLOW");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else if (this.lightStatus.equals("YELLOW")) {
                try {
                    Thread.sleep(2000);
                    this.lightStatus = "RED";
                    System.out.println("Traffic Light " + lightNumber + " is RED");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else if (this.lightStatus.equals("RED")) {
                try {
                    Thread.sleep(10000);
                    this.lightStatus = "GREEN";
                    System.out.println("Traffic Light " + lightNumber + " is GREEN");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
