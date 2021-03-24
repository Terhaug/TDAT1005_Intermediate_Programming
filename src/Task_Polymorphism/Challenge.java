package Task_Polymorphism;

class Car{
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.engine = true;
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine(){
        return "Car -> Start engine";
    }

    public String accelerate(){
        return "Car -> Accelerate";
    }

    public String brake(){
        return "Car -> Brake";
    }
}

class Mitsubishi extends Car{
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Mit -> StartEngine()";
    }

    @Override
    public String accelerate() {
        return "Mit -> Accelerate()";
    }

    @Override
    public String brake() {
        return "Mit -> Brake();";
    }
}

class Holden extends Car{
    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Holden -> StartEngine()";
    }

    @Override
    public String accelerate() {
        return "Holden -> Accelerate()";
    }

    @Override
    public String brake() {
        return "Holden -> Brake();";
    }
}

class Ford extends Car{
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Ford -> StartEngine()";
    }

    @Override
    public String accelerate() {
        return "Ford -> Accelerate()";
    }

    @Override
    public String brake() {
        return "Ford -> Brake();";
    }
}

public class Challenge {
    public static void main(String[] args) {

        Car car = new Car(8,"Base car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Ford ford = new Ford(6, "Falcon");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        Holden holden = new Holden(6, "Strong");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());

    }

}
