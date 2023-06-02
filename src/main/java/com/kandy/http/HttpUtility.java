package com.kandy.http;

import com.kandy.Kandy;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
class HttpUtility {
    public String getUserAgentString(final List<String> userAgentExtensions) {
        StringBuilder userAgentString = new StringBuilder();
        userAgentString.append("kandy-java/")
                .append(Kandy.VERSION)
                .append(" (")
                .append(Kandy.OS_NAME)
                .append(" ")
                .append(Kandy.OS_ARCH)
                .append(") ")
                .append("java/")
                .append(Kandy.JAVA_VERSION);

        if (userAgentExtensions != null && !userAgentExtensions.isEmpty()) {
            userAgentExtensions.stream().forEach(userAgentExtension -> {
                userAgentString.append(" ");
                userAgentString.append(userAgentExtension);
            });
        }

        return userAgentString.toString();
    }

    public String getUserAgentString(final List<String> userAgentExtensions, final boolean isCustomClient) {
        return isCustomClient ? getUserAgentString(userAgentExtensions) + " custom"
                : getUserAgentString(userAgentExtensions);
    }
}
