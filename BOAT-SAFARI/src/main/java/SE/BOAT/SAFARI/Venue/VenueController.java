package SE.BOAT.SAFARI.Venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping
    public Venue addVenue(@RequestBody Venue venue) {
        return venueService.saveVenue(venue);
    }

    @GetMapping
    public List<Venue> getAllVenues() {
        return venueService.getAllVenues();
    }

    @GetMapping("/{id}")
    public Venue getVenueById(@PathVariable int id) {
        return venueService.getVenueById(id);
    }

    @PutMapping("/{id}")
    public Venue updateVenue(@PathVariable int id, @RequestBody Venue venue) {
        return venueService.updateVenue(id, venue);
    }

    @DeleteMapping("/{id}")
    public void deleteVenue(@PathVariable int id) {
        venueService.deleteVenue(id);
    }
}
