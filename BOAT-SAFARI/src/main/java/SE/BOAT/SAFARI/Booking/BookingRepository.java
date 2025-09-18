package SE.BOAT.SAFARI.Booking;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookingRepository<T extends Booking> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<Booking> {
}
