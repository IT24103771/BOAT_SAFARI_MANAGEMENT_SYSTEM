package SE.BOAT.SAFARI.Schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/times")
public class TimeSlotController {

    @Autowired
    private TimeSlotService timeSlotService;

    @GetMapping
    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotService.getAllSlots();
    }

    @PostMapping
    public TimeSlot createTimeSlot(@RequestBody TimeSlot slot) {
        return timeSlotService.saveTimeSlot(slot);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimeSlot(@PathVariable int id) {
        timeSlotService.deleteTimeSlot(id);
        return ResponseEntity.noContent().build();
    }
}
