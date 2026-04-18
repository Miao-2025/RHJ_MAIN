package io.github.miao_2026;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class MAP {
    public final Map<String, Value> vs = new ConcurrentSkipListMap<>();

    // 保持原有方法
    public boolean hasKey(String key) {
        return vs.containsKey(key);
    }
    public Value get(String get){
        return vs.get(get)==null ? new Value("String","null"):vs.get(get);
    }

    // 新增 set 方法：用于设置键值对
    public void set(String key, Value value) {
        vs.put(key, value);
    }

    // 如果需要设置整个 Map 实例（需移除 final 修饰符）
    // public void setMap(Map<String, Val> newMap) {
    //     this.vs = newMap;
    // }
}
