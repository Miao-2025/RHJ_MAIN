package io.github.miao_2026;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Plugin {
    public String name;
    public MAP MAP = new MAP();
    public List<Code> codes=new CopyOnWriteArrayList<>();


    // MAP字段的 Getter
    public MAP getMAP() {
        return MAP;
    }
    public String getName() {
        return name;
    }


    // codes字段的 Getter
    public List<Code> getCodes() {
        return codes;
    }

    public class Code {
        public String getId() {
            return id;
        }
        String id;
        _cmd[] Commands;

        // id字段的 Getter

        // cmds字段的 Getter
        public _cmd[] getCmds() {
            return Commands;
        }
    }
}
