package SE.BOAT.SAFARI.Schedule;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String time; // e.g. "08:00 AM", "10:30 AM", "02:00 PM"
}
