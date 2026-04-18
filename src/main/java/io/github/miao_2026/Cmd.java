package io.github.miao_2026;

public abstract class Cmd {
    public String id;
    public abstract void apply(MAP mp, Value[] values) ;
    public Cmd(String id){
        this.id=id;
        PluginManager.cmds.add(this);
    }
}
