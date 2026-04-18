package io.github.miao_2026;

public class Value {
    public String Type;
    public String v;

    public String getV() {
        return v;
    }
    public Value(String type, String obj){
        this.Type=type;
        this.v=obj;
    }
}
