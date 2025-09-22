package SE.BOAT.SAFARI.Admin;

import SE.BOAT.SAFARI.Booking.Booking;
import SE.BOAT.SAFARI.Booking.BookingService;
import SE.BOAT.SAFARI.BoatManagement.Boat;
import SE.BOAT.SAFARI.BoatManagement.BoatService;
import SE.BOAT.SAFARI.Schedule.TimeSlot;
import SE.BOAT.SAFARI.Schedule.TimeSlotService;
import SE.BOAT.SAFARI.Registration.User;
import SE.BOAT.SAFARI.Registration.UserService;
import SE.BOAT.SAFARI.Venue.Venue;
import SE.BOAT.SAFARI.Venue.VenueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired private BookingService bookingService;
    @Autowired private BoatService boatService;
    @Autowired private TimeSlotService timeSlotService;
    @Autowired private UserService userService;
    @Autowired private VenueService venueService;

    public AdminData getAdminDashboardData() {
        List<Booking> bookings = bookingService.getBookings(null, null, null, null);
        List<Boat> boats = boatService.getBoats();
        List<TimeSlot> slots = timeSlotService.getAllSlots();
        List<User> users = userService.getUsers();
        List<Venue> venues = venueService.getAllVenues();

        return new AdminData(bookings, boats, slots, users, venues);
    }

    public static class AdminData {
        private List<Booking> bookings;
        private List<Boat> boats;
        private List<TimeSlot> slots;
        private List<User> users;
        private List<Venue> venues;

        public AdminData(List<Booking> bookings, List<Boat> boats, List<TimeSlot> slots,
                         List<User> users, List<Venue> venues) {
            this.bookings = bookings;
            this.boats = boats;
            this.slots = slots;
            this.users = users;
            this.venues = venues;
        }

        public List<Booking> getBookings() { return bookings; }
        public List<Boat> getBoats() { return boats; }
        public List<TimeSlot> getSlots() { return slots; }
        public List<User> getUsers() { return users; }
        public List<Venue> getVenues() { return venues; }
    }
}
