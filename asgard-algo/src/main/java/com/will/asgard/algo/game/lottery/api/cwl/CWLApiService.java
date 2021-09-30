package com.will.asgard.algo.game.lottery.api.cwl;

import com.will.asgard.common.util.GsonUtil;
import com.will.asgard.common.util.HttpUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @Description 中国福利彩票api接口
 * @Author maolingwei
 * @Date 2021-09-10 9:58 下午
 * @Version 1.0
 **/
@Service
public class CWLApiService {

    public CWLResp searchResultByIssueCount(String name, int issueCount) {
        String url = CWLUtil.searchByIssueCountUrl(name, issueCount);
        String resp = HttpUtil.httpGet(url, CWLUtil.headers);
//        System.out.println(resp);
        if (StringUtils.isNotEmpty(resp)) {
            return GsonUtil.fromJson(resp, CWLResp.class);
        }
        return null;
    }

    public CWLResp searchResultByIssueNumber(String name, String issueStart, String issueEnd) {
        String url = CWLUtil.searchByIssueNumberUrl(name, issueStart, issueEnd);
        String resp = HttpUtil.httpGet(url, CWLUtil.headers);
//        System.out.println(resp);
        if (StringUtils.isNotEmpty(resp)) {
            return GsonUtil.fromJson(resp, CWLResp.class);
        }
        return null;
    }

    public CWLResp searchResultByDate(String name, String dayStart, String dayEnd) {
        String url = CWLUtil.searchByDateUrl(name, dayStart, dayEnd);
        String resp = HttpUtil.httpGet(url, CWLUtil.headers);
//        System.out.println(resp);
        if (StringUtils.isNotEmpty(resp)) {
            return GsonUtil.fromJson(resp, CWLResp.class);
        }
        return null;
    }
}
