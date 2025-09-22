package SE.BOAT.SAFARI.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking saveBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @GetMapping
    public List<Booking> getBookings(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String venue
    ) {
        return bookingService.getBookings(name, email, date, venue);
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
    }
}
