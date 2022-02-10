import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String kind;
    private Long totalItems;
    Object[] items;
   // private String items[];

}

