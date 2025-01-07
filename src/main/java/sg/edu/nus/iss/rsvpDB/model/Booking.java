package sg.edu.nus.iss.rsvpDB.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Booking {
    private String email;
    private String phone;
    private String confirmDate;
    private String comments;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getConfirmDate() {
        return confirmDate;
    }
    public void setConfirmDate(String confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public static Booking toBooking(SqlRowSet rs){
        Booking booking = new Booking();
        booking.setEmail(rs.getString("email"));
        booking.setPhone(rs.getString("phone"));
        booking.setConfirmDate(rs.getString("confirmDate"));
        booking.setComments(rs.getString("comments"));
        return booking;
    }
   

    
}
