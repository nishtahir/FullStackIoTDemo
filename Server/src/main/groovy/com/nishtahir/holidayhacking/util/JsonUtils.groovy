package com.nishtahir.holidayhacking.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.nishtahir.holidayhacking.model.Device


class JsonUtils {

    /**
     * Converts object to JSON notation
     * @param data
     * @return String representation of JSON object
     */
    public static String dataToJson(data) {
        try {
            StringWriter writer = new StringWriter()
            new ObjectMapper().writeValue(writer, data);
            return writer.toString();
        } catch (IOException e) {

        }
    }

    public static Device jsonToDevice(String json) {
        return new ObjectMapper().readValue(json);
    }
}
