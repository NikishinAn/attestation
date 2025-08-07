package attestation.attestation01;
import java.util.Arrays;
import java.util.Objects;


public class Person {

    //Private поля
    private String name;
    private int money;
    //массив объектов типа Продукт
    private Product[] bagproducts = new Product[0];

    //конструктор
    public Person(String name, int money){
        setName(name);
        setMoney(money);
    }

    //геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        this.name = name;
    }


    public int getMoney() {
        return money;
    }


    public void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.money = money;
    }

    public Product[] getBagOfProducts() {
        return bagproducts;
    }

    public boolean canBuy(Product product) {
        return money >= product.getPrice();
    }

    public void buyProduct(Product product) {
        if (!canBuy(product)) {
            System.out.println(name + " не может позволить себе " + product.getProduct_name());
            return;
        }

        money = money - product.getPrice();
        bagproducts = Arrays.copyOf(bagproducts, bagproducts.length + 1);
        bagproducts[bagproducts.length - 1] = product;
        System.out.println(name + " купил " + product.getProduct_name());
    }


    //переопределение equals() и hashcode()
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return money == person.money &&
                Objects.equals(name, person.name) &&
                Arrays.equals(bagproducts, person.bagproducts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, money);
        return result;
    }
    // генерация toString
    @Override
    public String toString() {
        if (bagproducts.length == 0) {
            return name + " - Ничего не куплено";
        }
        return name + " купил: " + Arrays.toString(bagproducts);
    }

}