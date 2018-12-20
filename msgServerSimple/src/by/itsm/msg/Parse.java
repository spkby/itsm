package by.itsm.msg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {

    private final String name;
    private final String msg;

    private static int NAME_ID = 0;
    private static int MSG_ID = 1;

    private static int GROUP_ID_NAME = 2;
    private static int GROUP_ID_MSG = 4;

    private static String PATTERN_VALIDATION
            = "(\\{\\s?\"name\"\\s?:\\s?\\\")(.+)(\\\"\\s?\\,\\s?\"message\"\\s?:\\s?\\\")(.+)(\\\"\\s?\\}$)";

    public Parse(String json) {

        String[] parsedJson = parse(json);

        this.name = parsedJson[NAME_ID];
        this.msg = parsedJson[MSG_ID];
    }

    private static String[] parse(String json) {

        String name = "";
        String msg = "";

        Pattern pattern = Pattern.compile(PATTERN_VALIDATION);
        Matcher matcher = pattern.matcher(json);

        if(matcher.find()){
            name = matcher.group(GROUP_ID_NAME);
            msg = matcher.group(GROUP_ID_MSG).trim();
        }

        return new String[]{name, msg};
    }

    public String getName() {
        return name;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Parse{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
