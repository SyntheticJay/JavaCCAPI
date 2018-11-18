package me.jay.types.led;

/**
 * @author Jay L, 2018
 *
 * Used to represent the colours of the LED.
 * {@link me.jay.CCAPI#changeLEDColor(LEDColor, LEDStatus)}
 *
 */
public enum LEDColor {
    RED(0),
    GREEN(1);

    int code;

    LEDColor(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
