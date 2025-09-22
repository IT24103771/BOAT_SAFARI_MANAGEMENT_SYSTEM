package SE.BOAT.SAFARI.BoatManagement;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private String boatType; // e.g., Luxury, Standard, Fishing, Speed
}
