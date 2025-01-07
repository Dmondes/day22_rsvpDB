package sg.edu.nus.iss.rsvpDB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.rsvpDB.repo.BookingRepo;
import sg.edu.nus.iss.rsvpDB.model.Booking;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    public Booking addBooking(Booking newBooking) {
        return bookingRepo.save(newBooking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.getAll();
    }
}
