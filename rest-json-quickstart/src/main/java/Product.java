import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "product", schema="product")
public class Product extends PanacheEntityBase {

    @Id
    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "category")
    public String category;

    @Column(name = "price")
    public Double price;
    @Column(name = "stock")
    public Integer stock;

    public Product(Integer stock, String name, String description, String category, Double price) {
        this.stock = stock;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }
}