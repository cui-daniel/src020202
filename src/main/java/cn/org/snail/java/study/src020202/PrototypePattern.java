package cn.org.snail.java.study.src020202;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class PrototypePattern implements Cloneable, Serializable {
    private String name;
    private String[] parameters;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return deepClone();
        } catch (Exception e) {
            throw new CloneNotSupportedException();
        }
    }

    public PrototypePattern deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(out);
        oout.writeObject(this);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream oin = new ObjectInputStream(in);
        return (PrototypePattern) oin.readObject();
    }


    public PrototypePattern shallowClone() {
        PrototypePattern result = new PrototypePattern();
        result.name = name;
        result.parameters = parameters;
        return result;
    }

    public static PrototypePattern parse(JSONObject json) {
        PrototypePattern result = new PrototypePattern();
        result.name = json.getString("name");
        JSONArray array = json.getJSONArray("parameters");
        result.parameters = new String[array.size()];
        for (int i = 0; i < result.parameters.length; i++) {
            result.parameters[i] = array.getString(i);
        }
        return result;
    }
}
