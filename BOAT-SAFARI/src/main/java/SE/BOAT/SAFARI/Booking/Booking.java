package SE.BOAT.SAFARI.Booking;

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

    @Column(name = "boat_type")
    private String boatType;

}
