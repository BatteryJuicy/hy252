package lec6;

class Animal
{
    protected String sound;
    private int age;
    private int weight;

    Animal(String sound, int age, int weight)
    {
        this.sound = sound;
        this.age = age;
        this.weight = weight;
    }

    void bark()
    {
        System.out.println(this.sound);
    }

    int getAge()
    {
        return this.age;
    }
    int getWeight()
    {
        return this.weight;
    }
}

class Monkey extends Animal
{
    private boolean hungry = false;

    Monkey(String sound, int age, int weight)
    {
        super(sound, age, weight);
    }

    void setHungry(boolean hungry)
    {
        this.hungry = hungry;
    }

    boolean isHungry()
    {
        return this.hungry;
    }
}

class Dog extends Animal
{
    Dog(String sound, int age, int weight)
    {
        super(sound, age, weight);
    }
    void bark()
    {
        System.out.println(this.sound + " " + this.sound + " nigga");
    }
}

public class lec6
{
    public static void main(String[] args)
    {
        Monkey monkey = new Monkey("oua", 10, 20);
        monkey.bark();
        System.out.println(monkey.isHungry());
        monkey.bark();
        monkey.bark();
        System.out.println(" I am " + monkey.getAge() + " and I weigh " + monkey.getWeight());

        Dog doggy = new Dog("gav", 5, 40);

        doggy.bark();

    }
}