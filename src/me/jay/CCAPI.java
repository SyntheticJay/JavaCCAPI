package me.jay;

import me.jay.types.BuzzerType;
import me.jay.types.IDTypes;
import me.jay.types.NotifyIcon;
import me.jay.types.led.LEDColor;
import me.jay.types.led.LEDStatus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @author Jay L, 2018
 * @author Zerotica - Some code.
 */
public class CCAPI implements ICCAPI {
    /**
     * Raw Variables
     */
    private String ip;
    private boolean isConnected;

    /**
     * Logger
     */
    private Logger logger = Logger.getLogger("CCAPI");

    /**
     * Constructor
     */
    public CCAPI() {
        this.isConnected = false;
    }

    /**
     * Implemented from {@link ICCAPI}
     * @param ip IP to PS3
     * @return
     */
    @Override
    public boolean connect(String ip) {
        this.ip = ip;
        this.isConnected = true;
        logger.info("Connected! IP: " + ip);
        return true;
    }

    /**
     * Implemented from {@link ICCAPI}
     * @return
     */
    @Override
    public boolean attach() {
        return false;
    }

    /**
     * Implemented from {@link ICCAPI}
     * @param type Type of Buzz
     */
    @Override
    public void ringBuzzer(BuzzerType type) {
        logger.info("Sending Buzz Request to " + ip + " with type " + type.toString());
        sendCommand("ringbuzzer", false, "type=" + type.getCode());
    }

    /**
     * Implemented from {@link ICCAPI}
     * @param msg Messgae
     * @param icon Icon {@link me.jay.types.NotifyIcon}
     */
    @Override
    public void notify(String msg, NotifyIcon icon) {
        logger.info("Sending Notify request to " + ip + " with message " + msg + " and icon " + icon.toString());
        sendCommand("notify", false, "id=" + icon.getCode(), "msg=" + msg);
    }

    /**
     * Implemented from {@link ICCAPI}
     * @param color Color {@link me.jay.types.led.LEDColor}
     */
    @Override
    public void changeLEDColor(LEDColor color, LEDStatus status) {
        logger.info("Sending LED Colour Change to " + ip + " with color " + color.toString());
        sendCommand("setconsoleled", false, "color=" + color.getCode(), "status=" + status.getCode());
    }

    /**
     * Implemented from {@link ICCAPI}
     * @param consoleid Console ID
     */
    @Override
    public void setBootCID(String consoleid) {
        logger.info("Sending CID Change to " + ip + " with PSID " + consoleid);
        sendCommand("setbootconsoleids", false, "type=" + IDTypes.IDPS.getCode(), "on=1", "id=" + consoleid);
    }

    /**
     * Implemented from {@link ICCAPI}
     */
    @Override
    public void resetBootCID() {
        logger.info("Sending CID reset to ip " + ip);
        sendCommand("setbootconsoleids", false, "type=" + IDTypes.IDPS.getCode(), "on=0", "id=NULL");
    }

    /**
     * Implemented from {@link ICCAPI}
     * @param psid PSID
     */
    @Override
    public void setBootPSID(String psid) {
        logger.info("Sending PSID change to " + ip + " with PSID " + psid);
        sendCommand("setbootconsoleids", false, "type=" + IDTypes.PSID.getCode(), "on=1", "id=" + psid);
    }

    /**
     * Implemented from {@link ICCAPI}
     */
    @Override
    public void resetBootPSID() {
        logger.info("Resetting Boot PSID on ip " + ip);
        sendCommand("setbootconsoleids", false, "type=" + IDTypes.PSID.getCode(), "on=0", "id=NULL");
    }

    /**
     * Return's the PS3's IP.
     * @return
     */
    public String getIP() {
        return ip;
    }

    /**
     * Send's the PS3 a command
     * @param command Command to send
     * @param args Arguments
     * @param isVoid determine's if the command is a void.
     * @return Returns the response
     */
    public String sendCommand(String command, boolean isVoid, String... args) {
        //if ps3 isn't connected
        if (!this.isConnected) {
            return "NOT CONNECTED.";
        }
        //define our URL
        URL url;
        try {
            //if argument's aren't empty
            if(args != null) {
                //our StringBuffer for parameters
                StringBuffer params = new StringBuffer();
                //our parameter count
                int pCount = 0;

                //iterate through each argument in the args list
                for(String arg : args) {
                    //if argument's length is greater than 1 element
                    if(args.length > 1) {
                        //if the parameter count is 0
                        if(pCount == 0) {
                            //append the argument
                            params.append(arg);
                        }else{
                            //append the argument with a & at the start.
                            params.append("&").append(arg);
                        }
                        //increment the parameter counter.
                        pCount++;
                    }else{
                        //append the argument.
                        params.append(arg);
                    }
                }
                //instantiate URL with command and arguments
                url = new URL("http://" + ip + ":6333/ccapi/" + command + "?" + params.toString());
            }else{
                //since no argument's have been specified, just send the command.
                url = new URL("http://" + ip + ":6333/ccapi/" + command);
            }
            //if void is true in parameters
            if(isVoid) {
                //return nothing.
                return null;
            }
            //define our HTTP Url Connection object cast to openConnection();
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            //define our reader to pass in the input stream from our url connection
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            //our string buffer which will hold the response sent by the PS3
            StringBuffer response = new StringBuffer();

            //iterate through each line from the reader
            String line;
            while((line = reader.readLine()) != null) {
                //append the line to the response.
                response.append(line);
            }
            //close the stream
            reader.close();

            //return the response
            return response.toString();
        }catch(Exception e) {
            throw new RuntimeException("Failed to send request!");
        }
    }
}
