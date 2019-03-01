package com.swu.ai.service.Impl;

import com.swu.ai.dao.FingerDao;
import com.swu.ai.entity.FingerResultV0;
import com.swu.ai.service.FingerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * -------------------------------------------------
 *
 * @ Author  :       彭健彪
 * @ date    :       2019/3/1 20:47
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */
@Service
public class FingerServiceImpl implements FingerService {
    @Resource
    private FingerDao fingerDao;

    @Override
    public List<FingerResultV0> getFingerResult(Integer year, String periodType, String denominatorType, Long companyId, String companyPlate){
        return fingerDao.findAllResultByCondition(year, periodType, denominatorType, companyId, companyPlate);

    }
}
