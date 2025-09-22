package SE.BOAT.SAFARI.Schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TimeSlotService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public TimeSlot saveTimeSlot(TimeSlot slot) {
        return timeSlotRepository.save(slot);
    }

    public List<TimeSlot> getAllSlots() {
        return timeSlotRepository.findAll();
    }

    public void deleteTimeSlot(int id) {
        timeSlotRepository.deleteById(id);
    }
}
