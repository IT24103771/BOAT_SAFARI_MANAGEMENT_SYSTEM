package SE.BOAT.SAFARI.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    // Save a new booking
    @PostMapping
    public Booking saveBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    // Get bookings with optional filters
    @GetMapping
    public List<Booking> getBookings(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String email,
                                     @RequestParam(required = false) String date) {
        return bookingService.getBookings(name, email, date);
    }

    // Update an existing booking
    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    // Delete a booking
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
    }
}
