package com.will.asgard.algo.game.lottery.api.cwl;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-10 10:01 下午
 * @Version 1.0
 **/
public class CWLUtil {

    public static final Map<String, String> headers;
    static {
        headers = new HashMap<>();
        headers.put("Referer", "http://www.cwl.gov.cn");
    }

    private static String generateSearchUrl(String name) {
        return CWLConstant.searchUrlV2 + "?name=" + name;
    }

    public static String searchByIssueCountUrl(String name, int issueCount) {
        return generateSearchUrl(name) + "&issueCount=" + issueCount;
    }

    public static String searchByIssueNumberUrl(String name, String issueStart, String issueEnd) {
        return generateSearchUrl(name) + "&issueStart=" + issueStart + "&issueEnd=" + issueEnd;
    }

    public static String searchByDateUrl(String name, String dayStart, String dayEnd) {
        return generateSearchUrl(name) + "&dayStart=" + dayStart + "&dayEnd=" + dayEnd;
    }

    public static String concatenateUrl(String suffix) {
        return CWLConstant.domain + suffix;
    }
}
