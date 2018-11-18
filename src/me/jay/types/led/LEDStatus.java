package me.jay.types.led;

/**
 * @author Jay L, 2018
 *
 * Used to represent the status's of the PS3'S light emitting diode.
 * {@link me.jay.CCAPI#changeLEDColor(LEDColor, LEDStatus)}
 */
public enum LEDStatus {
    OFF(0),
    ON(1),
    BLINKING(2);

    int code;

    LEDStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
