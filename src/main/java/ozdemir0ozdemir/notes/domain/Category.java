package ozdemir0ozdemir.notes.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "categories")
@Getter
@Setter
@ToString
class Category implements Serializable {

    @Id
    @SequenceGenerator(name = "categories_id_gen", sequenceName = "categories_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "categories_id_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "category_id")
    private Long categoryId;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "category_name", unique = true)
    private String categoryName;

    // Constructors
    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    // Static Factories
    static Category of(String categoryName){
        return new Category(categoryName);
    }

    static Category of(Category other) {
        return new Category(other.getCategoryName());
    }

}
