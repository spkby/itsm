package by.itsm.msg.core;

import by.itsm.msg.dto.Request;
import by.itsm.msg.dto.Response;

public interface RequestProcessor {
    Response process(Request request);

    boolean accept(Request request);
}
