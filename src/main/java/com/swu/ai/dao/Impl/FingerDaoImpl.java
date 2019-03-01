package com.swu.ai.dao.Impl;

import com.swu.ai.dao.FingerDao;
import com.swu.ai.entity.FingerResultV0;
import com.swu.ai.mapper.FingerResultV0Mapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * -------------------------------------------------
 *
 * @ Author  :       彭健彪
 * @ date    :       2019/3/1 20:48
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */
@Service
public class FingerDaoImpl implements FingerDao {
    @Resource
    FingerResultV0Mapper fingerResultV0Mapper;

    @Override
    public List<FingerResultV0> findAllResultByCondition(Integer year, String periodType, String denominatorType, Long companyId, String companyPlate) {
        Condition condition = new Condition(FingerResultV0.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("denominatorType", denominatorType);
        criteria.andEqualTo("year", year);
        criteria.andEqualTo("periodType", periodType);
        if (companyId != -1) {
            criteria.andEqualTo("companyId", companyId);

        }
        if (!companyPlate.equals("all")) {
            criteria.andEqualTo("companyPlate", companyPlate);
        }
        return fingerResultV0Mapper.selectByCondition(condition);
    }
}
