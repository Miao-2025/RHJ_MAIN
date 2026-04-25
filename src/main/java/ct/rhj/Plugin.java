package ct.rhj;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Plugin {
    public String name;
    public MAP MAP = new MAP();
    public List<Code> codes=new CopyOnWriteArrayList<>();


    public String getName() {
        return name;
    }


    // codes字段的 Getter
    public List<Code> getCodes() {
        return codes;
    }

    public static class Code {
        public String getId() {
            return id;
        }
        String id;
        _cmd[] Commands;
        public int size(){
            return Commands.length;
        }
        // id字段的 Getter

    }
}
