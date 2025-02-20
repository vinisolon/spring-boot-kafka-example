package com.vinisolon.app.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonConverterUtil {

    public static <T> String toJson(T obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new InternalError("Error converting OBJECT to JSON");
        }
    }

    public static <T> T toClazz(Object value, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(String.valueOf(value), clazz);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new InternalError("Error mapping JSON to CLASS");
        }
    }

}
