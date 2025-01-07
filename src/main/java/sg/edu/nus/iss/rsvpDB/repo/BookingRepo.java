package sg.edu.nus.iss.rsvpDB.repo;

import static sg.edu.nus.iss.rsvpDB.repo.Queries.*;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import sg.edu.nus.iss.rsvpDB.model.Booking;

@Repository
public class BookingRepo {

    @Autowired
    private JdbcTemplate template;

    public List<Booking> getAll() {
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_ALL);
        List<Booking> results = new LinkedList<>();
        while (rs.next()) {
            results.add(Booking.toBooking(rs));
        }
        return results;
    }

    public Booking save(Booking booking) {
        template.update(
            SQL_INSERT_INTO,
            booking.getEmail(),
            booking.getPhone(),
            booking.getConfirmDate(),
            booking.getComments()
        );

        return booking;
    }
}
