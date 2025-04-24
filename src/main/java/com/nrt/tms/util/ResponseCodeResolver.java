package com.nrt.tms.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static com.nrt.tms.util.ResponseKeys.UNKNOWN;

@Component
@RequiredArgsConstructor
public class ResponseCodeResolver {
    private final MessageSource messageSource;

    public ResponseCode get(String key) {
        String raw = messageSource.getMessage("response." + key, null, Locale.getDefault());
        if (raw.contains("|")) {
            String[] split = raw.split("\\|", 2);
            return new ResponseCode(split[0], split[1]);
        }
        return new ResponseCode("response." + UNKNOWN, "No message found for key: " + key);
    }
}