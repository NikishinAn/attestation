package attestation.attestation01;
import java.util.Objects;


public class Product {

    //private поля
    private String product_name;
    private int price;
    //конструктор
    public Product(String product_name,int price){
        setProduct_name(product_name);
        setPrice(price);
    }
    //геттеры и сеттеры
    public String getProduct_name(){
        return product_name;
    }

    public  void setProduct_name(String product_name) {
        if (product_name==null){
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.product_name = product_name;

    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        if (price<0){
            throw new IllegalArgumentException("Стоимость продукта не может быть отрицательной");
        }
        this.price = price;
    }



    //переопределение equals() и hashcode()
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(product_name, product.product_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_name, price);
    }


    @Override
    public String toString() {
        return "Продукт: " + product_name + ", Цена: " + price + " руб.";
    }
}