package flazetech.onlinereservationsys.model.enums;

public enum SeatType {
    //
    STANDARD("Standard Seat"),
    PREMIUM("Premium Seat"),
    BUSINESS_CLASS("Business Class Seat"),
    VIP("VIP/Executive Seat");

    private final String displayName;

    SeatType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
