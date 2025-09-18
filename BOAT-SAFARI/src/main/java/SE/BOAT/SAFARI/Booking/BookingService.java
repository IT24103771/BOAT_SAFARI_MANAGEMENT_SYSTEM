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
    BookingRepository bookingRepository;

    // Save a new booking
    public Booking saveBooking(Booking booking) {
        return (Booking) bookingRepository.save(booking);
    }

    // Get bookings with optional filters (name, email, date)
    public List<Booking> getBookings(String name, String email, String date) {
        Specification<Booking> spec = null;

        if (name != null && !name.isEmpty()) {
            spec = (spec == null ? nameEquals(name) : spec.and(nameEquals(name)));
        }

        if (email != null && !email.isEmpty()) {
            spec = (spec == null ? emailEquals(email) : spec.and(emailEquals(email)));
        }

        if (date != null && !date.isEmpty()) {
            spec = (spec == null ? dateEquals(date) : spec.and(dateEquals(date)));
        }

        return spec == null ? bookingRepository.findAll() : bookingRepository.findAll(spec);
    }

    // Update booking by ID
    public Booking updateBooking(int id, Booking booking) {
        Optional<Booking> existingBooking = bookingRepository.findById(id);
        if (existingBooking.isPresent()) {
            Booking b = existingBooking.get();
            b.setName(booking.getName());
            b.setEmail(booking.getEmail());
            b.setSafariDate(booking.getSafariDate());
            b.setPassengers(booking.getPassengers());
            b.setBoatType(booking.getBoatType());
            return (Booking) bookingRepository.save(b);
        }
        return null; // or throw an exception if not found
    }

    // Delete booking by ID
    public boolean deleteBooking(int id) {
        Optional<Booking> existingBooking = bookingRepository.findById(id);
        if (existingBooking.isPresent()) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Specifications for dynamic filtering
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
}
