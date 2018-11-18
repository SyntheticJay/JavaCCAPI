package me.jay.test;

import me.jay.CCAPI;

/**
 * @author Jay L, 2018
 */
public class Test {
    public static void main(String[] args) {
        CCAPI api = new CCAPI();
        api.connect("192.168.0.69");
    }
}
