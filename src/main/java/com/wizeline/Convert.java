package com.wizeline;

public class Convert {

    public static String cidrToMask(String CIDR) {
        try {
            if ( Integer.parseInt(CIDR) < 1 || Integer.parseInt(CIDR) > 32 )
                return "Invalid";
            final int bits = 32 - Integer.parseInt(CIDR);
            //final int mask = (bits == 32) ? 0 : 0xFFFFFFFF - ((1 << bits) - 1); This line could take /0 as 0.0.0.0.
            final int mask = 0xFFFFFFFF - ((1 << bits) - 1);

            return (Integer.toString(mask >> 24 & 0xFF, 10) + "."
                    + Integer.toString(mask >> 16 & 0xFF, 10) + "."
                    + Integer.toString(mask >> 8 & 0xFF, 10) + "."
                    + Integer.toString(mask >> 0 & 0xFF, 10));
            
        } catch (NumberFormatException e) {
                return "Invalid";
        }
    }

    public static String maskToCidr(String x) {
        return x;
    }

    public static Boolean ipv4Validation(String x) {
        return true;
    }
}
