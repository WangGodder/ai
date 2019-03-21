package com.swu.ai.service.Impl;

import com.swu.ai.dao.Impl.CompanyInputDaoImpl;
import com.swu.ai.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * @author: godder
 * @date: 2019/3/9
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CompanyServiceImpl.class)
public class CompanyServiceImplTest {
    @Autowired
    private CompanyServiceImpl service;

    @Test
    public void getCompanyInfoTableColumn() {
        System.out.println(service.getCompanyInfoTableColumn());
    }
}