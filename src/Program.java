package src;

public class Program {
    public static void main(String[] args) {
        Person tom = new Person();
        tom.displayInfo();

        // изменяем имя и возраст
        tom.name = "Tom";
        tom.age = 34;
        tom.displayInfo();
    }
}
