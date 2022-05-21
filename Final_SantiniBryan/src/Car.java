public class Car implements Runnable {

    private int yPosition = 0;
    private double speed = 25;
    private final String carNumber;
    TrafficLight light1;
    TrafficLight light2;
    TrafficLight light3;

    public Car(String carNumber, TrafficLight light1, TrafficLight light2, TrafficLight light3) {
        this.carNumber = carNumber;
        this.light1 = light1;
        this.light2 = light2;
        this.light3 = light3;
    }


    @Override
    public void run() {

//        TrafficLight light1 = new TrafficLight(1000, "GREEN", "1");
//        Thread light1Thread = new Thread(light1);
//        light1Thread.start();
//
//
//        TrafficLight light2 = new TrafficLight(2000, "YELLOW", "2");
//        Thread light2Thread = new Thread(light2);
//        light2Thread.start();
//
//
//        TrafficLight light3 = new TrafficLight(3000, "RED", "3");
//        Thread light3Thread = new Thread(light3);
//        light3Thread.start();

        while (true) {
            yPosition+= speed;
//            System.out.println("Car # " + this.carNumber + " is at " + this.yPosition + " meters");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                if (distanceToLight(light1) == 0 && light1.getLightStatus().equals("RED")) {
                    this.stop(light1);
                } else if (distanceToLight(light2) == 0 && light2.getLightStatus().equals("RED")) {
                    this.stop(light2);
                } else if (distanceToLight(light3) == 0 && light3.getLightStatus().equals("RED")) {
                    this.stop(light3);
                } else {
                    this.go();
                }

                if (this.yPosition >= 4000) {
                    System.out.println("Car " + carNumber + " has made it through the city");
                    this.yPosition = 0;
                    run();
                    break;
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }


        }

    }
    public void stop(TrafficLight light) {
        this.speed = 0;
        int kph = kphCalc(this.speed);
        System.out.println("Car # " + this.carNumber + " has/is stopped at light "
                            + light.getLightNumber() + " (" + kph + "km/hr)") ;
    }

    public int kphCalc(double speed) {
        double kphCalc = speed * (18.0/5.0);

        return (int)kphCalc;
    }

    public void go() {

        this.speed = 25;
        int kph = kphCalc(this.speed);
        if (yPosition % 250 == 0) {
            System.out.println("Car # " + this.carNumber + " is at " + this.yPosition + " meters" + " (" + kph + "km/hr)");
        }
    }

    public int distanceToLight(TrafficLight light) {

        return light.getYPosition() - this.yPosition;
        }

    }

