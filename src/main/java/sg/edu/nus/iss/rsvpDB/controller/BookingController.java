package sg.edu.nus.iss.rsvpDB.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.edu.nus.iss.rsvpDB.model.Booking;
import sg.edu.nus.iss.rsvpDB.services.BookingService;

@RestController
@RequestMapping
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/api/rsvp")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.addBooking(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/api/rsvps")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity(bookings, HttpStatus.OK);
    }
}
