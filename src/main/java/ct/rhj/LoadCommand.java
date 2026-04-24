package ct.rhj;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LoadCommand {
    private static final Pattern VAR_PATTERN = Pattern.compile("&(\\w+)");

    public static void registerAllCommands() {
        registerPrintCommand();
        registerSetCommand();
    }

    /**
     * 从 MAP 中获取变量值，若未定义则返回默认值 {"Type":"String", "v":"NULL"}
     */
    private static Value getValueFromMap(MAP mp, String key) {
        Value value = mp.get(key);
        if (value == null) {
            return new Value("String", "NULL");
        }
        return value;
    }

    /**
     * 解析 Value 对象，若类型为 "Value"，则解析为实际变量值
     */
    private static Value resolveValue(MAP mp, Value value) {
        if ("Value".equals(value.Type)) {
            return getValueFromMap(mp, value.v);
        }
        return value;
    }

    /**
     * 替换字符串中的变量，如 &name 替换为变量值
     */
    private static String replaceVariables(MAP mp, String content) {
        Matcher matcher = VAR_PATTERN.matcher(content);
        StringBuilder buffer = new StringBuilder();

        while (matcher.find()) {
            String varName = matcher.group(1);
            Value varValue = getValueFromMap(mp, varName);
            matcher.appendReplacement(buffer, varValue.getV());
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    /**
     * 注册 print 命令
     */
    private static void registerPrintCommand() {
        new Cmd("print") {
            @Override
            public void apply(MAP mp, Value[] values) {
                StringBuilder output = new StringBuilder();

                for (Value value : values) {
                    value = resolveValue(mp, value);
                    String resolvedContent = replaceVariables(mp, value.getV());
                    output.append(resolvedContent);
                }

                System.out.println(output);
            }
        };
    }

    /**
     * 注册 set 命令
     */
    private static void registerSetCommand() {
        new Cmd("set") {
            @Override
            public void apply(MAP mp, Value[] values) {
                if (values.length < 2) {
                    return;
                }

                String key = values[0].getV();
                Value value = resolveValue(mp, values[1]);
                mp.set(key, value);
            }
        };
    }
}

