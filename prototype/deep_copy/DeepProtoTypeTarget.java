package jdp.prototype.deep_copy;

import java.io.Serializable;

public class DeepProtoTypeTarget implements Serializable, Cloneable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String name;


    public DeepProtoTypeTarget(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
