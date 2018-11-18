package me.jay;

import me.jay.types.BuzzerType;
import me.jay.types.NotifyIcon;
import me.jay.types.led.LEDColor;
import me.jay.types.led.LEDStatus;

/**
 * @author Jay L, 2018
 *
 * An interface for the main class to inherit from.
 * Contains all the functions neccessary.
 */
public interface ICCAPI {
    /**
     * Connect's to the PS3
     * @param ip IP to PS3
     * @return True/False
     */
    boolean connect(String ip);

    /**
     * Attach's to the current process on the PS3.
     * @return True/False
     */
    boolean attach();

    /**
     * Uses the PS3'S buzz.
     * @param type Type of Buzz
     */
    void ringBuzzer(BuzzerType type);

    /**
     * Send's a VSH notification to the PS3 using the given Icon
     * @param msg Messgae
     * @param icon Icon {@link me.jay.types.NotifyIcon}
     */
    void notify(String msg, NotifyIcon icon);

    /**
     * Change's the light emitting diode's colour located at the front of the PS3.
     * @param color Color {@link me.jay.types.led.LEDColor}
     * @param status Status {@link me.jay.types.led.LEDStatus}
     */
    void changeLEDColor(LEDColor color, LEDStatus status);

    /**
     * Set's the boot Console ID (CID)
     * @param consoleid Console ID
     */
    void setBootCID(String consoleid);

    /**
     * Reset's the boot Console ID (CID)
     */
    void resetBootCID();

    /**
     * Set Boot PSID
     * @param psid PSID
     */
    void setBootPSID(String psid);

    /**
     * Reset the boot PSID
     */
    void resetBootPSID();
}
