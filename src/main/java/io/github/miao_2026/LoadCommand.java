package io.github.miao_2026;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LoadCommand {
    public static void registerPrintCommand() {
        new Cmd("print") {
            @Override
            public void apply(MAP mp, Value[] values)  {

                StringBuilder output = new StringBuilder();

                // 缓存正则编译（性能优化）
                Pattern pattern = Pattern.compile("&(\\w+)");
                String content = "NULL";
                for (Value value : values) {
                    content = value.getV();
                    }
                    Matcher matcher = pattern.matcher(content);
                    StringBuilder buffer = new StringBuilder();
                    while (matcher.find()) {
                        String varName = matcher.group(1);
                        Value varValue = mp.vs.get(varName);

                        if (varValue != null) {
                            matcher.appendReplacement(buffer, varValue.getV());
                        } else {
                            matcher.appendReplacement(buffer, "[变量未定义: " + varName + "]");
                        }
                    }
                    matcher.appendTail(buffer);
                    output.append(buffer);
                System.out.println(output);
            }
        };
    }
}
