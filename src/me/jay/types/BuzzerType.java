package me.jay.types;

/**
 * @author Jay L, 2018
 *
 * The types passed in by the ringBuzzer function.
 * {@link me.jay.CCAPI#ringBuzzer(BuzzerType)}
 */
public enum BuzzerType {
    SINGLE(1),
    DOUBLE(2),
    TRIPLE(3),
    CONTINUOUS(0);

    int code;

    BuzzerType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
