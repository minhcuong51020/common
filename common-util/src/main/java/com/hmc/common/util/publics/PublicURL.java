package com.hmc.common.util.publics;

import java.util.ArrayList;
import java.util.List;

public class PublicURL {

    private static List<String> urls;

    static {
        urls = new ArrayList<>();
        urls.add("**/register");
        urls.add("**/login");
        urls.add("**/logout");
    }

    public static List<String> getUrls() {
        return urls;
    }

}
