package lec7;

class lec7{
    public static void main(String[] args){
        Company google = new Company();
        google.name = "Google";

        Company microsoft = new Company();
        microsoft.name = "Microsoft";
        Company companySomething = new Company();

        Contract c1 = new Contract();

        c1.seller = google;
        c1.buyer = microsoft;
        c1.Product = companySomething;
    }
}

abstract class Actor(
        String name = "φυσικο ή νομικο προσοπο"
)
class Person extends Actor{
    Person(){
        name = "Thanopoulos"
    }
}

class Company extends Actor implements Agatho{
    Company(){

    }
    public String getName() return name;
    public souble getPrice() return 0;
}

//an abstract way to define methods that will be overwritten by the class the implements it.
interface Product{
    //public method by default (only in interfaces).
    String getName();
    double getPrice();
}

class car implements Product{
    Actor owner;
    String model = "ferraririri";
    public String getName() return model;
    public double getPice() return -1.0;
}

class House implements Product{
    Actor owner;
    String address;
}

class Contract{
    Actor seller;
    Actor buyer;

}