package com.swu.ai.service.Impl;

import com.swu.ai.Result.CompanyInfoTableColumn;
import com.swu.ai.util.TableUtil;
import com.swu.ai.dao.CompanyInputDao;
import com.swu.ai.dao.CompanyInputDictDao;
import com.swu.ai.dao.FigureDictDao;
import com.swu.ai.entity.CompanyInput;
import com.swu.ai.entity.CompanyInputDict;
import com.swu.ai.entity.FigureDict;
import com.swu.ai.request.CompanyInputReq;
import com.swu.ai.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mhp
 * @date 2019/3/3 22:19
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyInputDao companyDao;
    @Autowired
    CompanyInputDictDao companyInputDictDao;
    @Autowired
    FigureDictDao figureDictDao;

    @Override
    public boolean insertCompanyInfo(List<CompanyInput> list) {
        return companyDao.insertCompanyInfo(list);
    }

    @Override
    public List<CompanyInput> findAllCompanyInput() {
        return companyDao.findAllCompanyInput();
    }

    @Override
    public List<CompanyInput> findCompanyInputByReq(CompanyInputReq companyInputReq) {
        return companyDao.findCompanyInputByReq(companyInputReq);
    }

    @Override
    public CompanyInfoTableColumn getCompanyInfoTableColumn() {
        final int HEAD_NUM = 6;
        List<String> fields = TableUtil.getFieldNames(CompanyInput.class);
        Map<String, String> map = getCompanyInfoDictMap();
        List<String> titles = new ArrayList<>(fields.size());
        for (String field : fields) {
            titles.add(map.get(field));
        }
        List<String> headFields = new ArrayList<>(HEAD_NUM);
        List<String> headTitles = new ArrayList<>(HEAD_NUM);
        for (int i = 0; i < HEAD_NUM; i++) {
            headFields.add(fields.get(0));
            headTitles.add(titles.get(0));
            fields.remove(0);
            titles.remove(0);
        }
        List<FigureDict> figureV1DictList = figureDictDao.findFigureDictByLevel(1);
        List<String> firstRowTitle = new ArrayList<>(figureV1DictList.size());
        List<Integer> firstRowLength = new ArrayList<>(figureV1DictList.size());
        for (int i = 0; i < figureV1DictList.size(); i++) {
            firstRowTitle.add(figureV1DictList.get(i).getFigureName());
            firstRowLength.add(figureV1DictList.get(i).getSubFigureNum());
        }
        List<FigureDict> figureV2DictList = figureDictDao.findFigureDictByLevel(2);
        List<String> secondRowTitle = new ArrayList<>(figureV2DictList.size());
        List<Integer> secondRowLength = new ArrayList<>(figureV2DictList.size());
        for (int i = 0; i < figureV2DictList.size(); i++) {
            secondRowTitle.add(figureV2DictList.get(i).getFigureName());
            secondRowLength.add(figureV2DictList.get(i).getSubFigureNum());
        }
        CompanyInfoTableColumn companyInfoTableColumn = new CompanyInfoTableColumn();
        companyInfoTableColumn.setFields(fields);
        companyInfoTableColumn.setTitles(titles);
        companyInfoTableColumn.setHeadField(headFields);
        companyInfoTableColumn.setHeadTitles(headTitles);
        companyInfoTableColumn.setFirstRowTitles(firstRowTitle);
        companyInfoTableColumn.setFirstRowLength(firstRowLength);
        companyInfoTableColumn.setSecondRowTitles(secondRowTitle);
        companyInfoTableColumn.setSecondRowLength(secondRowLength);
        return companyInfoTableColumn;
    }

    private Map<String, String> getCompanyInfoDictMap() {
        List<CompanyInputDict> list = companyInputDictDao.findAllCompanyInputDict();
        Map<String, String> map = new HashMap<>(list.size());
        for (CompanyInputDict companyInputDict : list) {
            map.put(companyInputDict.getName(), companyInputDict.getValue());
        }
        return map;
    }
}
