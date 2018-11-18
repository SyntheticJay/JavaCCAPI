package me.jay.types;

/**
 * @author Jay L, 2018
 *
 * Used to represent the types of ID's used in the PS3
 * - IDPS  -> PS3 ID
 * - PSID -> Playstation ID
 */
public enum IDTypes {
    IDPS(0),
    PSID(1);

    int code;

    IDTypes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
