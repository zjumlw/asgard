package com.will.asgard.algo.game.lottery.api.cwl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-09-10 10:58 下午
 * @Version 1.0
 **/
@Service
public class CWLService {

    @Autowired
    private CWLApiService cwlApiService;

    public List<CWLSearchResult> searchResultByIssueCount(String name, int issueCount) {
        CWLResp resp = cwlApiService.searchResultByIssueCount(name, issueCount);
        if (resp.getState() != 0) {
            System.out.println("请求错误，错误信息为：" + resp.getMessage());
        }
        if (!CWLConstant.nameSsq.equals(name)) {
            throw new IllegalArgumentException("尚不支持双色球以外的彩票项目");
        }

        return resp.getResult();
    }

    public List<SsqResult> searchSsqByIssueCount(int issueCount) {
        List<CWLSearchResult> result = searchResultByIssueCount(CWLConstant.nameSsq, issueCount);
        return result.stream()
                .map(CWLConverter::convertToSsqResult)
                .collect(Collectors.toList());
    }
}
