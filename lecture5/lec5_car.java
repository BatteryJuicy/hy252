package lec5;

class car1{
    double speed;
}
class car2{
    private double speed;
    public void setSpeed(double newSp)
    {
        if(newSp < 0)
        {
            throw new Error("negative speed");
        }
        else{
            speed = newSp;
        }
    }
    public double getSpeed()
    {
        return(speed);
    }
}

public class lec5_car {
    public static void main(String[] args) {
        car1 c1 = new car1();
        c1.speed = 80;
        System.out.println("Car1 speed: " + c1.speed);

        car2 c2 = new car2();
        c2.setSpeed(-80);
        System.out.println("Car2 speed: " + c2.getSpeed());
    }
}