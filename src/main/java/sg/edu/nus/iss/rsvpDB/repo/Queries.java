package sg.edu.nus.iss.rsvpDB.repo;

public class Queries {

    public static final String SQL_INSERT_INTO =
        """
            INSERT INTO booking (email, phone, confirmDate, comments) VALUES (?, ?, ?, ?);
        """;

    public static final String SQL_SELECT_ALL =
        """
            select * from booking;
        """;
}
