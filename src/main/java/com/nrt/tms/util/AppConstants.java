package com.nrt.tms.util;

import lombok.Getter;

public class AppConstants {

    @Getter
    public enum Status {
        MOB("MOB"),
        WEB("WEB");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        // Add a static method to get Status from String
        public static Status fromValue(String value) {
            for (Status status : values()) {
                if (status.getValue().equalsIgnoreCase(value)) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Unknown Status value: " + value);
        }
    }
}

