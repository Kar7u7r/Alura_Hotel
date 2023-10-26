package model;

public class GuestBookingPair {
    private Guest guest;
    private Booking booking;

    public GuestBookingPair(Guest guest, Booking booking) {
        this.guest = guest;
        this.booking = booking;
    }

    public Guest getGuest() {
        return guest;
    }

    public Booking getBooking() {
        return booking;
    }
}
