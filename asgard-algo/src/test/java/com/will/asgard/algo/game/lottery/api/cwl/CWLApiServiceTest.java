package com.will.asgard.algo.game.lottery.api.cwl;

import com.will.asgard.common.util.GsonUtil;

import org.junit.Test;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-10 10:18 下午
 * @Version 1.0
 **/
public class CWLApiServiceTest {

    private CWLApiService service = new CWLApiService();

    @Test
    public void testSearchByIssueCount() {
        String name = CWLConstant.nameSsq;
        int issueCount = 30;
        CWLResp resp = service.searchResultByIssueCount(name, issueCount);
        System.out.println(GsonUtil.toJson(resp));
    }

    @Test
    public void testSearchByIssueNumber() {
        String name = CWLConstant.nameSsq;
        String issueStart = "2021001";
        String issueEnd = "2021020";
        CWLResp resp = service.searchResultByIssueNumber(name, issueStart, issueEnd);
        System.out.println(GsonUtil.toJson(resp));
    }

    @Test
    public void testSearchByDate() {
        String name = CWLConstant.nameSsq;
        String dayStart = "2021-01-01";
        String dayEnd = "2021-08-20";
        CWLResp resp = service.searchResultByDate(name, dayStart, dayEnd);
        System.out.println(GsonUtil.toJson(resp));
    }
}