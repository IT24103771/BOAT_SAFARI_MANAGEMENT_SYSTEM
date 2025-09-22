package SE.BOAT.SAFARI.Venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    // Add a new venue
    public Venue saveVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    // Get all venues
    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    // Get venue by ID
    public Venue getVenueById(int id) {
        return venueRepository.findById(id).orElse(null);
    }

    // Update venue
    public Venue updateVenue(int id, Venue venue) {
        Optional<Venue> existing = venueRepository.findById(id);
        if (existing.isPresent()) {
            Venue v = existing.get();
            v.setName(venue.getName());
            v.setDescription(venue.getDescription());
            v.setLocation(venue.getLocation());
            return venueRepository.save(v);
        }
        return null;
    }

    // Delete venue
    public boolean deleteVenue(int id) {
        if (venueRepository.existsById(id)) {
            venueRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
