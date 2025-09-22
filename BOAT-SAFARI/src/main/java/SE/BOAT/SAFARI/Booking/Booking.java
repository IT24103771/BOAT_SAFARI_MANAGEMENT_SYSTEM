package SE.BOAT.SAFARI.Booking;

import SE.BOAT.SAFARI.BoatManagement.Boat;
import SE.BOAT.SAFARI.Schedule.TimeSlot;
import SE.BOAT.SAFARI.Venue.Venue;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "safari_date")
    private LocalDate safariDate;

    @Column(nullable = false)
    private int passengers;

    @ManyToOne
    @JoinColumn(name = "boat_id")
    private Boat boat; // link to Boat entity

    @ManyToOne
    @JoinColumn(name = "time_slot_id")
    private TimeSlot timeSlot; // link to TimeSlot entity

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue; // link to Venue entity
}
