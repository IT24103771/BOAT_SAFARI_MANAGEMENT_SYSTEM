package SE.BOAT.SAFARI.Venue;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name; // e.g., "Sunset Island"

    @Column(nullable = true)
    private String description; // optional details

    @Column(nullable = true)
    private String location; // optional location info
}
