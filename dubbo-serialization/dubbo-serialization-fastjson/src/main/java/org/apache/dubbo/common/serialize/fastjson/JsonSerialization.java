package org.apache.dubbo.common.serialize.fastjson;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.serialize.ObjectInput;
import org.apache.dubbo.common.serialize.ObjectOutput;
import org.apache.dubbo.common.serialize.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JsonSerialization implements Serialization {

    public byte getContentTypeId() {
        return 5;
    }

    public String getContentType() {
        return "text/json";
    }

    public ObjectOutput serialize(URL url, OutputStream output) throws IOException {
        return new JsonObjectOutput(output, url.getParameter("with.class", true));
    }

    public ObjectInput deserialize(URL url, InputStream input) throws IOException {
        return new JsonObjectInput(input);
    }

}