package com.bravo.johny.jsonserver.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

import java.net.URL;

public class CommonUtils {
    public static <T> String getJsonSchemaStringFromPojo(Class<T> cls) {
        ObjectMapper mapper = new ObjectMapper();
        JsonSchemaGenerator schemaGen = new JsonSchemaGenerator(mapper);
        JsonSchema schema = null;
        String schemaString = null;
        try {
            schema = schemaGen.generateSchema(cls);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }
        try {
            schemaString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return schemaString;
    }

    public static URL getFileURLForJsonResource(String fileName) {
        return CommonUtils.class
                .getClassLoader()
                .getResource(fileName);
    }
}
