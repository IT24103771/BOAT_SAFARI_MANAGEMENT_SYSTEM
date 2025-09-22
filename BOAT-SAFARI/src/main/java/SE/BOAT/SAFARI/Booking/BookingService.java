package SE.BOAT.SAFARI.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookings(String name, String email, String date, String venueName) {
        Specification<Booking> spec = null;

        if (name != null) spec = (spec == null ? nameEquals(name) : spec.and(nameEquals(name)));
        if (email != null) spec = (spec == null ? emailEquals(email) : spec.and(emailEquals(email)));
        if (date != null) spec = (spec == null ? dateEquals(date) : spec.and(dateEquals(date)));
        if (venueName != null) spec = (spec == null ? venueEquals(venueName) : spec.and(venueEquals(venueName)));

        return spec == null ? bookingRepository.findAll() : bookingRepository.findAll(spec);
    }

    public Booking getBookingById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking updateBooking(int id, Booking booking) {
        Optional<Booking> existingBooking = bookingRepository.findById(id);
        if (existingBooking.isPresent()) {
            Booking b = existingBooking.get();
            b.setName(booking.getName());
            b.setEmail(booking.getEmail());
            b.setSafariDate(booking.getSafariDate());
            b.setPassengers(booking.getPassengers());
            b.setBoat(booking.getBoat());
            b.setTimeSlot(booking.getTimeSlot());
            b.setVenue(booking.getVenue());
            return bookingRepository.save(b);
        }
        return null;
    }

    public boolean deleteBooking(int id) {
        Optional<Booking> existingBooking = bookingRepository.findById(id);
        if (existingBooking.isPresent()) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Specifications for filtering
    private Specification<Booking> nameEquals(String name) {
        return (root, query, builder) -> builder.equal(root.get("name"), name);
    }
    private Specification<Booking> emailEquals(String email) {
        return (root, query, builder) -> builder.equal(root.get("email"), email);
    }
    private Specification<Booking> dateEquals(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return (root, query, builder) -> builder.equal(root.get("safariDate"), localDate);
    }
    private Specification<Booking> venueEquals(String venueName) {
        return (root, query, builder) -> builder.equal(root.get("venue").get("name"), venueName);
    }
}
