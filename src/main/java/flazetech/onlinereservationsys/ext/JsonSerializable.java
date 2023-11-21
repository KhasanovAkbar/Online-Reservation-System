package flazetech.onlinereservationsys.ext;

import flazetech.onlinereservationsys.utils.JsonUtil;

public interface JsonSerializable {
    //
    default String toJson() {
        return JsonUtil.toJson(this);
    }

    default String toPrettyJson() {
        return JsonUtil.toPrettyJson(this);
    }
}
