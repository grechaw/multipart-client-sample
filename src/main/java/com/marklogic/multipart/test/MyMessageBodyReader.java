package com.marklogic.multipart.test;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
public class MyMessageBodyReader implements MessageBodyReader<InputStream> {
    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return true;
    }
    
    public InputStream readFrom(Class<InputStream> type,
    		Type genericType, Annotation[] annotations,
    		MediaType mediaType, MultivaluedMap<String,String> httpHeaders, InputStream entityStream) {
    	return entityStream;
    }

}
