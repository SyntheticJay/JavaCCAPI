package me.jay.types;

/**
 * @author Jay L, 2018
 *
 * The icons that can be used to represent a notify
 * {@link me.jay.CCAPI#notify(String, NotifyIcon)}
 *
 * I think there's something wrong with this lol, finger is equal to trophy :thinking:
 */
public enum NotifyIcon {
    INFO(0),
    CAUTION(1),
    FRIEND(2),
    SLIDER(3),
    WRONG_WAY(4),
    DIALOG(5),
    DIALOG_SHADOW(6),
    TEXT(7),
    POINTER(8),
    GRAB(9),
    HAND(10),
    PEN(11),
    FINGER(12),
    ARROW(13),
    ARROW_RIGHT(14),
    PROGRESS(15),
    TROPHY_1(16),
    TROPHY_2(17),
    TROPHY_3(18),
    TROPHY_4(19);

    int code;

    NotifyIcon(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
