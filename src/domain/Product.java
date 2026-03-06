package domain;

public class Product {

    private Long idProduct;
    private String name;
    private String description;
    private Double price;

    public Product(Long idProduct, String name, String description, Double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getIdProduct() { return this.idProduct; }

    public String getName(){
        return this.name;
    }

    public Double getPrice(){
        return this.price;
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString(){
        return "Product {"+ " \n" +
                " id=" + this.idProduct + ", \n" +
                " nome=" + this.name + ", \n" +
                " description=" + this.description + ", \n" +
                " price=" + this.price + ", \n" +
                " }";
    }
}
