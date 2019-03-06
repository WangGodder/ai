package com.swu.ai.entity;

import javax.persistence.*;

@Table(name = "finger_result_v0")
public class FingerResultV0 {
    private Long id;

    @Column(name = "company_id")
    private Long companyId;

    /**
     * 公司名字
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 公司所属的板块
     */
    @Column(name = "industry")
    private String industry;

    /**
     * 分母类型：mean平均值，max最大值，min最小值，极差值range
     */
    @Column(name = "region")
    private String region;

    private Integer year;

    /**
     * Y整年 Q1 一季度 Q2 二季度 Q3三季度 Q4四季度
     */
    @Column(name = "quarter")
    private Integer quarter;

    /**
     * 综合指数
     */
    @Column(name = "finger_all")
    private Double fingerAll = 0.0;

    /**
     * 一级指标：销售指数
     */
    @Column(name = "finger_sale")
    private Double fingerSale = 0.0;

    /**
     * 二级指标：已开票的收入
     */
    @Column(name = "finger_sale_invoice")
    private Double fingerSaleInvoice = 0.0;

    /**
     * 已开发票的收入-软件产品
     */
    @Column(name = "finger_sale_invoice_soft")
    private Double fingerSaleInvoiceSoft = 0.0;

    /**
     * 已开发票的收入-硬件产品
     */
    @Column(name = "finger_sale_invoice_hard")
    private Double fingerSaleInvoiceHard = 0.0;

    /**
     * 已开发票的收入-咨询服务
     */
    @Column(name = "finger_sale_invoice_consultation")
    private Double fingerSaleInvoiceConsultation = 0.0;

    /**
     * 已开发票的收入-其他
     */
    @Column(name = "finger_sale_invoice_other")
    private Double fingerSaleInvoiceOther = 0.0;

    /**
     * 二级指标：合同确认额
     */
    @Column(name = "finger_sale_contract")
    private Double fingerSaleContract = 0.0;

    /**
     * 三级指标：合同确认额-软件产品
     */
    @Column(name = "finger_sale_contract_soft")
    private Double fingerSaleContractSoft = 0.0;

    /**
     * 三级指标：合同确认额-硬件产品
     */
    @Column(name = "finger_sale_contract_hard")
    private Double fingerSaleContractHard = 0.0;

    /**
     * 三级指标：合同确认额-咨询服务
     */
    @Column(name = "finger_sale_contract_consultation")
    private Double fingerSaleContractConsultation = 0.0;

    /**
     * 三级指标：合同确认额-其他
     */
    @Column(name = "finger_sale_contract_other")
    private Double fingerSaleContractOther = 0.0;

    /**
     * 一级指标：纳税指数
     */
    @Column(name = "finger_tax")
    private Double fingerTax = 0.0;

    /**
     * 二级指标：企业所得税
     */
    @Column(name = "finger_tax_corporate")
    private Double fingerTaxCorporate = 0.0;

    /**
     * 三级指标：企业所得税-应纳税值
     */
    @Column(name = "finger_tax_corporate_taxable")
    private Double fingerTaxCorporateTaxable = 0.0;

    /**
     * 三级指标：企业所得税-税收减免值
     */
    @Column(name = "finger_tax_corporate_relief")
    private Double fingerTaxCorporateRelief = 0.0;

    /**
     * 二级指标：个人所得税
     */
    @Column(name = "finger_tax_individual")
    private Double fingerTaxIndividual = 0.0;

    /**
     * 三级指标：个人所得税-应纳税值
     */
    @Column(name = "finger_tax_individual_taxable")
    private Double fingerTaxIndividualTaxable = 0.0;

    /**
     * 三级指标：个人所得税-税收减免
     */
    @Column(name = "finger_tax_individual_relief")
    private Double fingerTaxIndividualRelief = 0.0;

    /**
     * 二级指标：增值税
     */
    @Column(name = "finger_tax_added")
    private Double fingerTaxAdded = 0.0;

    /**
     * 三级指标：增值税-应纳税值
     */
    @Column(name = "finger_tax_added_taxable")
    private Double fingerTaxAddedTaxable = 0.0;

    /**
     * 三级指标：增值税-税收减免
     */
    @Column(name = "finger_tax_added_relief")
    private Double fingerTaxAddedRelief = 0.0;

    /**
     * 一级指标：融资指数
     */
    @Column(name = "finger_finance")
    private Double fingerFinance = 0.0;

    /**
     * 二级指标：股权类融资
     */
    @Column(name = "finger_finance_stock")
    private Double fingerFinanceStock = 0.0;

    /**
     * 三级指标：股权类融资-风投机构
     */
    @Column(name = "finger_finance_stock_risk")
    private Double fingerFinanceStockRisk = 0.0;

    /**
     * 三级指标：股权类融资-政府企业
     */
    @Column(name = "finger_finance_stock_gov")
    private Double fingerFinanceStockGov = 0.0;

    /**
     * 三级指标：股权类融资-个人
     */
    @Column(name = "finger_finance_stock_person")
    private Double fingerFinanceStockPerson = 0.0;

    /**
     * 二级指标：债务类融资
     */
    @Column(name = "finger_finance_debt")
    private Double fingerFinanceDebt = 0.0;

    /**
     * 三级指标：债务类融资-银行
     */
    @Column(name = "finger_finance_debt_bank")
    private Double fingerFinanceDebtBank = 0.0;

    /**
     * 三级指标：债务类融资-新型贷款机构
     */
    @Column(name = "finger_finance_debt_new")
    private Double fingerFinanceDebtNew = 0.0;

    /**
     * 三级指标：债务类融资-企业拆借
     */
    @Column(name = "finger_finance_debt_lending")
    private Double fingerFinanceDebtLending = 0.0;

    /**
     * 三级指标：债务类融资-个人
     */
    @Column(name = "finger_finance_debt_person")
    private Double fingerFinanceDebtPerson = 0.0;

    /**
     * 一级指标:估值指数
     */
    @Column(name = "finger_valuation")
    private Double fingerValuation = 0.0;

    /**
     * 二级指标：净资产
     */
    @Column(name = "finger_valuation_assets")
    private Double fingerValuationAssets = 0.0;

    /**
     * 三级指标：净资产-流动资产
     */
    @Column(name = "finger_valuation_assets_circulating")
    private Double fingerValuationAssetsCirculating = 0.0;

    /**
     * 三级指标：净资产-非流动资产
     */
    @Column(name = "finger_valuation_assets_uncirculating")
    private Double fingerValuationAssetsUncirculating = 0.0;

    /**
     * 三级指标：净资产-流动负债
     */
    @Column(name = "finger_valuation_assets_debt_circulating")
    private Double fingerValuationAssetsDebtCirculating = 0.0;

    /**
     * 三级指标：净资产-非流动负债
     */
    @Column(name = "finger_valuation_assets_debt_uncirculating")
    private Double fingerValuationAssetsDebtUncirculating = 0.0;

    /**
     * 二级指标：实际估值
     */
    @Column(name = "finger_valuation_actual")
    private Double fingerValuationActual = 0.0;

    /**
     * 三级指标：实际估值-首次融资
     */
    @Column(name = "finger_valuation_actual_first")
    private Double fingerValuationActualFirst = 0.0;

    /**
     * 三级指标：实际估值-最近一次融资估值
     */
    @Column(name = "finger_valuation_actual_latest")
    private Double fingerValuationActualLatest = 0.0;

    /**
     * 三级指标：实际估值-现在准备融资估值
     */
    @Column(name = "finger_valuation_actual_want")
    private Double fingerValuationActualWant = 0.0;

    /**
     * 一级指标：人力资源指数
     */
    @Column(name = "finger_hr")
    private Double fingerHr = 0.0;

    /**
     * 二级指标：兼职员工数
     */
    @Column(name = "finger_hr_partime")
    private Double fingerHrPartime = 0.0;

    /**
     * 三级指标：兼职员工-研发
     */
    @Column(name = "finger_hr_partime_dev")
    private Double fingerHrPartimeDev = 0.0;

    /**
     * 三级指标：兼职员工-管理
     */
    @Column(name = "finger_hr_partime_manage")
    private Double fingerHrPartimeManage = 0.0;

    /**
     * 三级指标：兼职员工-行政
     */
    @Column(name = "finger_hr_partime_admin")
    private Double fingerHrPartimeAdmin = 0.0;

    /**
     * 三级指标：兼职员工-销售
     */
    @Column(name = "finger_hr_partime_saler")
    private Double fingerHrPartimeSaler = 0.0;

    /**
     * 二级指标：全职员工
     */
    @Column(name = "finger_hr_fulltime")
    private Double fingerHrFulltime = 0.0;

    /**
     * 三级指标：全职员工-研发
     */
    @Column(name = "finger_hr_fulltime_dev")
    private Double fingerHrFulltimeDev = 0.0;

    /**
     * 三级指标：全职员工-高管
     */
    @Column(name = "finger_hr_fulltime_senior")
    private Double fingerHrFulltimeSenior = 0.0;

    /**
     * 三级指标：全职员工-行政
     */
    @Column(name = "finger_hr_fulltime_admin")
    private Double fingerHrFulltimeAdmin = 0.0;

    /**
     * 三级指标：全职员工-销售
     */
    @Column(name = "finger_hr_fulltime_saler")
    private Double fingerHrFulltimeSaler = 0.0;

    /**
     * 二级指标：高学历人员
     */
    @Column(name = "finger_hr_educated")
    private Double fingerHrEducated = 0.0;

    /**
     * 三级指标：高学历人员-博士
     */
    @Column(name = "finger_hr_educated_doc")
    private Double fingerHrEducatedDoc = 0.0;

    /**
     * 三级指标：高学历人员-硕士
     */
    @Column(name = "finger_hr_educated_master")
    private Double fingerHrEducatedMaster = 0.0;

    /**
     * 三级指标：高学历人员-学士
     */
    @Column(name = "finger_hr_bachelor")
    private Double fingerHrBachelor = 0.0;

    /**
     * 一级指标：创新指数
     */
    @Column(name = "finger_innovate")
    private Double fingerInnovate = 0.0;

    /**
     * 二级指标：专利申请
     */
    @Column(name = "finger_innovate_patent_apply")
    private Double fingerInnovatePatentApply = 0.0;

    /**
     * 三级指标：专利申请-发明
     */
    @Column(name = "finger_innovate_patent_apply_invention")
    private Double fingerInnovatePatentApplyInvention = 0.0;

    /**
     * 三级指标：专利申请-实用新型
     */
    @Column(name = "finger_innovate_patent_apply_utility")
    private Double fingerInnovatePatentApplyUtility = 0.0;

    /**
     * 三级指标：专利申请-外观设计
     */
    @Column(name = "finger_innovate_patent_apply_appear")
    private Double fingerInnovatePatentApplyAppear = 0.0;

    /**
     * 二级指标：专利授权
     */
    @Column(name = "finger_innovate_patent_grant")
    private Double fingerInnovatePatentGrant = 0.0;

    /**
     * 三级指标：专利授权-发明
     */
    @Column(name = "finger_innovate_patent_grant_invention")
    private Double fingerInnovatePatentGrantInvention = 0.0;

    /**
     * 三级指标：专利授权-实用新型
     */
    @Column(name = "finger_innovate_patent_grant_utility")
    private Double fingerInnovatePatentGrantUtility = 0.0;

    /**
     * 三级指标：专利授权-外观设计
     */
    @Column(name = "finger_innovate_patent_grant_appear")
    private Double fingerInnovatePatentGrantAppear = 0.0;

    /**
     * 二级指标：著作权申请
     */
    @Column(name = "finger_innovate_copyright_apply")
    private Double fingerInnovateCopyrightApply = 0.0;

    /**
     * 三级指标：著作权申请-软件类
     */
    @Column(name = "finger_innovate_copyright_apply_soft")
    private Double fingerInnovateCopyrightApplySoft = 0.0;

    /**
     * 三级指标：著作权申请-非软件类
     */
    @Column(name = "finger_innovate_copyright_apply_unsoft")
    private Double fingerInnovateCopyrightApplyUnsoft = 0.0;

    /**
     * 二级指标：著作权授权
     */
    @Column(name = "finger_innovate_copyright_grant")
    private Double fingerInnovateCopyrightGrant = 0.0;

    /**
     * 三级指标：著作权授权-软件类
     */
    @Column(name = "finger_innovate_copyright_grant_soft")
    private Double fingerInnovateCopyrightGrantSoft = 0.0;

    /**
     * 三级指标：著作权授权-非软件类
     */
    @Column(name = "finger_innovate_copyright_grant_unsoft")
    private Double fingerInnovateCopyrightGrantUnsoft = 0.0;
    /**
     * 二级指标：新产品/服务
     */
    @Column(name = "finger_innovate_new_product")
    private Double fingerInnovateNewProduct = 0.0;

    /**
     * 三级指标：新产品/服务-专利类
     */
    @Column(name = "finger_innovate_new_product_patent")
    private Double fingerInnovateNewProductPatent = 0.0;

    /**
     * 三级指标：新产品/服务-专用技术
     */
    @Column(name = "finger_innovate_new_product_tech")
    private Double fingerInnovateNewProductTech = 0.0;

    /**
     * 三级指标：新产品/服务-商业模式
     */
    @Column(name = "finger_innovate_new_product_bus")
    private Double fingerInnovateNewProductBus = 0.0;

    /**
     * 一级指标：薪酬指数
     */
    @Column(name = "finger_salary")
    private Double fingerSalary = 0.0;

    /**
     * 二级指标：员工工资额
     */
    @Column(name = "finger_salary_staff")
    private Double fingerSalaryStaff = 0.0;

    /**
     * 三级指标：员工工资额-1万元以上
     */
    @Column(name = "finger_salary_staff_up_10")
    private Double fingerSalaryStaffUp10 = 0.0;

    /**
     * 三级指标：员工工资额-5千到1万
     */
    @Column(name = "finger_salary_staff_5_10")
    private Double fingerSalaryStaff510 = 0.0;

    /**
     * 三级指标：员工工资额-5千以下
     */
    @Column(name = "finger_salary_staff_down_5")
    private Double fingerSalaryStaffDown5 = 0.0;

    /**
     * 二级指标：员工贡献率
     */
    @Column(name = "finger_salary_staff_contribution")
    private Double fingerSalaryStaffContribution = 0.0;

    /**
     * 三级指标：员工贡献率-人均销售
     */
    @Column(name = "finger_salary_staff_contribution_meansale")
    private Double fingerSalaryStaffContributionMeansale = 0.0;

    /**
     * 三级指标：员工贡献率-人均纳税
     */
    @Column(name = "finger_salary_staff_contribution_meantax")
    private Double fingerSalaryStaffContributionMeantax = 0.0;

    /**
     * 一级指标：学习指数
     */
    @Column(name = "finger_learn")
    private Double fingerLearn = 0.0;

    /**
     * 二级指标：参加培训的次数
     */
    @Column(name = "finger_learn_train")
    private Double fingerLearnTrain = 0.0;

    /**
     * 三级指标：参加培训的次数-管理类
     */
    @Column(name = "finger_learn_train_manage")
    private Double fingerLearnTrainManage = 0.0;

    /**
     * 三级指标：参加培训的次数-政策法规
     */
    @Column(name = "finger_learn_train_policy")
    private Double fingerLearnTrainPolicy = 0.0;

    /**
     * 三级指标：参加培训的次数-技能类
     */
    @Column(name = "finger_learn_train_skill")
    private Double fingerLearnTrainSkill = 0.0;

    /**
     * 二级指标：接受咨询的次数
     */
    @Column(name = "finger_learn_conslted")
    private Double fingerLearnConslted = 0.0;

    /**
     * 三级指标：接受咨询的次数-管理类
     */
    @Column(name = "finger_learn_conslted_manage")
    private Double fingerLearnConsltedManage = 0.0;

    /**
     * 三级指标：接受咨询的次数-政策法规
     */
    @Column(name = "finger_learn_conslted_policy")
    private Double fingerLearnConsltedPolicy = 0.0;

    /**
     * 三级指标：接受咨询的次数-技能类
     */
    @Column(name = "finger_learn_conslted_skill")
    private Double fingerLearnConsltedSkill = 0.0;

    /**
     * 一级指标：品牌指数
     */
    @Column(name = "finger_brand")
    private Double fingerBrand = 0.0;

    /**
     * 二级指标：企业获奖
     */
    @Column(name = "finger_brand_reward")
    private Double fingerBrandReward = 0.0;

    /**
     * 三级指标：企业获奖-区级
     */
    @Column(name = "finger_brand_reward_area")
    private Double fingerBrandRewardArea = 0.0;

    /**
     * 三级指标：企业获奖-市级
     */
    @Column(name = "finger_brand_reward_city")
    private Double fingerBrandRewardCity = 0.0;

    /**
     * 三级指标：企业获奖-省级
     */
    @Column(name = "finger_brand_reward_province")
    private Double fingerBrandRewardProvince = 0.0;

    /**
     * 三级指标：企业获奖-国家级
     */
    @Column(name = "finger_brand_reward_country")
    private Double fingerBrandRewardCountry = 0.0;

    /**
     * 二级指标：企业认定
     */
    @Column(name = "finger_brand_recognition")
    private Double fingerBrandRecognition = 0.0;

    /**
     * 三级指标：企业认定-区级
     */
    @Column(name = "finger_brand_recognition_area")
    private Double fingerBrandRecognitionArea = 0.0;

    /**
     * 三级指标：企业认定-市级
     */
    @Column(name = "finger_brand_recognition_city")
    private Double fingerBrandRecognitionCity = 0.0;

    /**
     * 三级指标：企业认定-省级
     */
    @Column(name = "finger_brand_recognition_province")
    private Double fingerBrandRecognitionProvince = 0.0;

    /**
     * 三级指标：企业认定-国家级
     */
    @Column(name = "finger_brand_recognition_country")
    private Double fingerBrandRecognitionCountry = 0.0;

    /**
     * 二级指标：人才资助
     */
    @Column(name = "finger_brand_talent")
    private Double fingerBrandTalent = 0.0;

    /**
     * 三级指标：人才资助-区级
     */
    @Column(name = "finger_brand_talent_area")
    private Double fingerBrandTalentArea = 0.0;

    /**
     * 三级指标：人才资助-市级
     */
    @Column(name = "finger_brand_talent_city")
    private Double fingerBrandTalentCity = 0.0;

    /**
     * 三级指标：人才资助-省级
     */
    @Column(name = "finger_brand_talent_province")
    private Double fingerBrandTalentProvince = 0.0;

    /**
     * 三级指标：人才资助-国家级
     */
    @Column(name = "finger_brand_talent_country")
    private Double fingerBrandTalentCountry = 0.0;

    /**
     * 初始化三级指标后，计算所有指标
     */
    public void evaluate() {
        this.fingerSaleInvoice = this.fingerSaleInvoiceSoft * 2 + this.fingerSaleInvoiceHard * 2.5 + this.fingerSaleInvoiceConsultation + this.fingerSaleInvoiceSoft * 0.5;
        this.fingerSaleContract = this.fingerSaleContractSoft * 2 + this.fingerSaleContractHard * 2.5 + this.fingerSaleContractConsultation + this.fingerSaleContractOther * 0.5;
        this.fingerSale = this.fingerSaleInvoice * 5 + this.fingerSaleContract;

        this.fingerTaxCorporate = this.fingerTaxCorporateTaxable + this.fingerTaxCorporateRelief * 2;
        this.fingerTaxIndividual = this.fingerTaxIndividualRelief + this.fingerTaxIndividualRelief * 2;
        this.fingerTaxAdded = this.fingerTaxAddedTaxable + this.fingerTaxAddedRelief * 2;
        this.fingerTax = this.fingerTaxCorporate * 3 + this.fingerTaxIndividual * 2 + this.fingerTaxAdded * 4;

        this.fingerFinanceStock = this.fingerFinanceStockRisk * 3 + this.fingerFinanceStockGov * 2 + this.fingerFinanceStockPerson;
        this.fingerFinanceDebt = this.fingerFinanceDebtBank * 3 + this.fingerFinanceDebtLending * 2 + this.fingerFinanceDebtNew * 2 + this.fingerFinanceDebtPerson;
        this.fingerFinance = this.fingerFinanceStock * 4 + this.fingerFinanceDebt;

        this.fingerValuationAssets = this.fingerValuationAssetsCirculating * 4 + this.fingerValuationAssetsUncirculating * 3 + this.fingerValuationAssetsDebtCirculating * 1 + this.fingerValuationAssetsDebtUncirculating * 2;
        this.fingerValuationActual = this.fingerValuationActualFirst * 2 + this.fingerValuationActualLatest * 3 + this.fingerValuationActualWant * 0.0000001;
        this.fingerValuation = this.fingerValuationAssets * 4 + this.fingerValuationActual;

        this.fingerHrPartime = this.fingerHrPartimeDev + this.fingerHrPartimeManage + this.fingerHrPartimeAdmin + this.fingerHrPartimeSaler;
        this.fingerHrFulltime = this.fingerHrFulltimeDev * 3 + this.fingerHrFulltimeSenior * 4 + this.fingerHrFulltimeAdmin + this.fingerHrFulltimeSaler * 2;
        this.fingerHrEducated = this.fingerHrEducatedDoc * 3 + this.fingerHrEducatedMaster * 2 + this.fingerHrBachelor;
        this.fingerHr = this.fingerHrPartime + this.fingerHrFulltime * 3 + this.fingerHrEducated * 4;

        this.fingerInnovatePatentApply = this.fingerInnovatePatentApplyInvention * 3 + this.fingerInnovatePatentApplyUtility * 2 + this.fingerInnovatePatentApplyAppear;
        this.fingerInnovatePatentGrant = this.fingerInnovatePatentGrantInvention * 3 + this.fingerInnovatePatentGrantUtility * 2 + this.fingerInnovatePatentGrantAppear;
        this.fingerInnovateCopyrightApply = this.fingerInnovateCopyrightApplySoft * 2 + this.fingerInnovateCopyrightApplyUnsoft;
        this.fingerInnovateCopyrightGrant = this.fingerInnovateCopyrightGrantSoft * 2 + this.fingerInnovateCopyrightGrantUnsoft;
        this.fingerInnovateNewProduct = this.fingerInnovateNewProductPatent * 2 + this.fingerInnovateNewProductTech + this.fingerInnovateNewProductBus;
        this.fingerInnovate = this.fingerInnovatePatentApply * 2 + this.fingerInnovatePatentGrant * 4 + this.fingerInnovateCopyrightApply * 2 + this.fingerInnovateCopyrightGrant * 3 + this.fingerInnovateNewProduct * 4;

        this.fingerSalaryStaff = this.fingerSalaryStaffUp10 + this.fingerSalaryStaff510 + this.fingerSalaryStaffDown5;
        this.fingerSalaryStaffContribution = this.fingerSalaryStaffContributionMeansale + this.fingerSalaryStaffContributionMeantax * 2;
        this.fingerSalary = this.fingerSalaryStaff + this.fingerSalaryStaffContribution * 4;

        this.fingerLearnTrain = this.fingerLearnTrainManage + this.fingerLearnTrainPolicy + this.fingerLearnTrainSkill;
        this.fingerLearnConslted = this.fingerLearnConsltedManage + this.fingerLearnTrainPolicy + this.fingerLearnTrainSkill;
        this.fingerLearn = this.fingerLearnTrain * 3 + this.fingerLearnConslted * 4;

        this.fingerBrandReward = this.fingerBrandRewardArea * 1 + this.fingerBrandRewardCity * 2 + this.fingerBrandRewardProvince * 3 + this.fingerBrandRewardCountry * 5;
        this.fingerBrandRecognition = this.fingerBrandRecognitionArea * 1 + this.fingerBrandRecognitionCity * 2 + this.fingerBrandRecognitionProvince * 3 + this.fingerBrandRecognitionCountry * 5;
        this.fingerBrandTalent = this.fingerBrandTalentArea * 1 + this.fingerBrandTalentCity * 2 + this.fingerBrandTalentProvince * 3 + this.fingerBrandTalentCountry * 5;
        this.fingerBrand = this.fingerBrandReward * 2 + this.fingerBrandRecognition * 3 + this.fingerBrandTalent * 2;

        this.fingerAll = this.fingerSale * 5 + this.fingerTax * 2 + this.fingerFinance * 0.5 + this.fingerValuation + this.fingerHr * 3 + this.fingerInnovate * 4 + this.fingerSalary * 2 + this.fingerLearn * 2 + this.fingerBrand * 4;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return company_id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取公司名字
     *
     * @return company_name - 公司名字
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名字
     *
     * @param companyName 公司名字
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }
        public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }
    /**
     * @return year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取综合指数
     *
     * @return finger_all - 综合指数
     */
    public Double getFingerAll() {
        return fingerAll;
    }

    /**
     * 设置综合指数
     *
     * @param fingerAll 综合指数
     */
    public void setFingerAll(Double fingerAll) {
        this.fingerAll = fingerAll;
    }

    /**
     * 获取一级指标：销售指数
     *
     * @return finger_sale - 一级指标：销售指数
     */
    public Double getFingerSale() {
        return fingerSale;
    }

    /**
     * 设置一级指标：销售指数
     *
     * @param fingerSale 一级指标：销售指数
     */
    public void setFingerSale(Double fingerSale) {
        this.fingerSale = fingerSale;
    }

    /**
     * 获取二级指标：已开票的收入
     *
     * @return finger_sale_invoice - 二级指标：已开票的收入
     */
    public Double getFingerSaleInvoice() {
        return fingerSaleInvoice;
    }

    /**
     * 设置二级指标：已开票的收入
     *
     * @param fingerSaleInvoice 二级指标：已开票的收入
     */
    public void setFingerSaleInvoice(Double fingerSaleInvoice) {
        this.fingerSaleInvoice = fingerSaleInvoice;
    }

    /**
     * 获取已开发票的收入-软件产品
     *
     * @return finger_sale_invoice_soft - 已开发票的收入-软件产品
     */
    public Double getFingerSaleInvoiceSoft() {
        return fingerSaleInvoiceSoft;
    }

    /**
     * 设置已开发票的收入-软件产品
     *
     * @param fingerSaleInvoiceSoft 已开发票的收入-软件产品
     */
    public void setFingerSaleInvoiceSoft(Double fingerSaleInvoiceSoft) {
        this.fingerSaleInvoiceSoft = fingerSaleInvoiceSoft;
    }

    /**
     * 获取已开发票的收入-硬件产品
     *
     * @return finger_sale_invoice_hard - 已开发票的收入-硬件产品
     */
    public Double getFingerSaleInvoiceHard() {
        return fingerSaleInvoiceHard;
    }

    /**
     * 设置已开发票的收入-硬件产品
     *
     * @param fingerSaleInvoiceHard 已开发票的收入-硬件产品
     */
    public void setFingerSaleInvoiceHard(Double fingerSaleInvoiceHard) {
        this.fingerSaleInvoiceHard = fingerSaleInvoiceHard;
    }

    /**
     * 获取已开发票的收入-咨询服务
     *
     * @return finger_sale_invoice_consultation - 已开发票的收入-咨询服务
     */
    public Double getFingerSaleInvoiceConsultation() {
        return fingerSaleInvoiceConsultation;
    }

    /**
     * 设置已开发票的收入-咨询服务
     *
     * @param fingerSaleInvoiceConsultation 已开发票的收入-咨询服务
     */
    public void setFingerSaleInvoiceConsultation(Double fingerSaleInvoiceConsultation) {
        this.fingerSaleInvoiceConsultation = fingerSaleInvoiceConsultation;
    }

    /**
     * 获取已开发票的收入-其他
     *
     * @return finger_sale_invoice_other - 已开发票的收入-其他
     */
    public Double getFingerSaleInvoiceOther() {
        return fingerSaleInvoiceOther;
    }

    /**
     * 设置已开发票的收入-其他
     *
     * @param fingerSaleInvoiceOther 已开发票的收入-其他
     */
    public void setFingerSaleInvoiceOther(Double fingerSaleInvoiceOther) {
        this.fingerSaleInvoiceOther = fingerSaleInvoiceOther;
    }

    /**
     * 获取二级指标：合同确认额
     *
     * @return finger_sale_contract - 二级指标：合同确认额
     */
    public Double getFingerSaleContract() {
        return fingerSaleContract;
    }

    /**
     * 设置二级指标：合同确认额
     *
     * @param fingerSaleContract 二级指标：合同确认额
     */
    public void setFingerSaleContract(Double fingerSaleContract) {
        this.fingerSaleContract = fingerSaleContract;
    }

    /**
     * 获取三级指标：合同确认额-软件产品
     *
     * @return finger_sale_contract_soft - 三级指标：合同确认额-软件产品
     */
    public Double getFingerSaleContractSoft() {
        return fingerSaleContractSoft;
    }

    /**
     * 设置三级指标：合同确认额-软件产品
     *
     * @param fingerSaleContractSoft 三级指标：合同确认额-软件产品
     */
    public void setFingerSaleContractSoft(Double fingerSaleContractSoft) {
        this.fingerSaleContractSoft = fingerSaleContractSoft;
    }

    /**
     * 获取三级指标：合同确认额-硬件产品
     *
     * @return finger_sale_contract_hard - 三级指标：合同确认额-硬件产品
     */
    public Double getFingerSaleContractHard() {
        return fingerSaleContractHard;
    }

    /**
     * 设置三级指标：合同确认额-硬件产品
     *
     * @param fingerSaleContractHard 三级指标：合同确认额-硬件产品
     */
    public void setFingerSaleContractHard(Double fingerSaleContractHard) {
        this.fingerSaleContractHard = fingerSaleContractHard;
    }

    /**
     * 获取三级指标：合同确认额-咨询服务
     *
     * @return finger_sale_contract_consultation - 三级指标：合同确认额-咨询服务
     */
    public Double getFingerSaleContractConsultation() {
        return fingerSaleContractConsultation;
    }

    /**
     * 设置三级指标：合同确认额-咨询服务
     *
     * @param fingerSaleContractConsultation 三级指标：合同确认额-咨询服务
     */
    public void setFingerSaleContractConsultation(Double fingerSaleContractConsultation) {
        this.fingerSaleContractConsultation = fingerSaleContractConsultation;
    }

    /**
     * 获取三级指标：合同确认额-其他
     *
     * @return finger_sale_contract_other - 三级指标：合同确认额-其他
     */
    public Double getFingerSaleContractOther() {
        return fingerSaleContractOther;
    }

    /**
     * 设置三级指标：合同确认额-其他
     *
     * @param fingerSaleContractOther 三级指标：合同确认额-其他
     */
    public void setFingerSaleContractOther(Double fingerSaleContractOther) {
        this.fingerSaleContractOther = fingerSaleContractOther;
    }

    /**
     * 获取一级指标：纳税指数
     *
     * @return finger_tax - 一级指标：纳税指数
     */
    public Double getFingerTax() {
        return fingerTax;
    }

    /**
     * 设置一级指标：纳税指数
     *
     * @param fingerTax 一级指标：纳税指数
     */
    public void setFingerTax(Double fingerTax) {
        this.fingerTax = fingerTax;
    }

    /**
     * 获取二级指标：企业所得税
     *
     * @return finger_tax_corporate - 二级指标：企业所得税
     */
    public Double getFingerTaxCorporate() {
        return fingerTaxCorporate;
    }

    /**
     * 设置二级指标：企业所得税
     *
     * @param fingerTaxCorporate 二级指标：企业所得税
     */
    public void setFingerTaxCorporate(Double fingerTaxCorporate) {
        this.fingerTaxCorporate = fingerTaxCorporate;
    }

    /**
     * 获取三级指标：企业所得税-应纳税值
     *
     * @return finger_tax_corporate_taxable - 三级指标：企业所得税-应纳税值
     */
    public Double getFingerTaxCorporateTaxable() {
        return fingerTaxCorporateTaxable;
    }

    /**
     * 设置三级指标：企业所得税-应纳税值
     *
     * @param fingerTaxCorporateTaxable 三级指标：企业所得税-应纳税值
     */
    public void setFingerTaxCorporateTaxable(Double fingerTaxCorporateTaxable) {
        this.fingerTaxCorporateTaxable = fingerTaxCorporateTaxable;
    }

    /**
     * 获取三级指标：企业所得税-税收减免值
     *
     * @return finger_tax_corporate_relief - 三级指标：企业所得税-税收减免值
     */
    public Double getFingerTaxCorporateRelief() {
        return fingerTaxCorporateRelief;
    }

    /**
     * 设置三级指标：企业所得税-税收减免值
     *
     * @param fingerTaxCorporateRelief 三级指标：企业所得税-税收减免值
     */
    public void setFingerTaxCorporateRelief(Double fingerTaxCorporateRelief) {
        this.fingerTaxCorporateRelief = fingerTaxCorporateRelief;
    }

    /**
     * 获取二级指标：个人所得税
     *
     * @return finger_tax_individual - 二级指标：个人所得税
     */
    public Double getFingerTaxIndividual() {
        return fingerTaxIndividual;
    }

    /**
     * 设置二级指标：个人所得税
     *
     * @param fingerTaxIndividual 二级指标：个人所得税
     */
    public void setFingerTaxIndividual(Double fingerTaxIndividual) {
        this.fingerTaxIndividual = fingerTaxIndividual;
    }

    /**
     * 获取三级指标：个人所得税-应纳税值
     *
     * @return finger_tax_individual_taxable - 三级指标：个人所得税-应纳税值
     */
    public Double getFingerTaxIndividualTaxable() {
        return fingerTaxIndividualTaxable;
    }

    /**
     * 设置三级指标：个人所得税-应纳税值
     *
     * @param fingerTaxIndividualTaxable 三级指标：个人所得税-应纳税值
     */
    public void setFingerTaxIndividualTaxable(Double fingerTaxIndividualTaxable) {
        this.fingerTaxIndividualTaxable = fingerTaxIndividualTaxable;
    }

    /**
     * 获取三级指标：个人所得税-税收减免
     *
     * @return finger_tax_individual_relief - 三级指标：个人所得税-税收减免
     */
    public Double getFingerTaxIndividualRelief() {
        return fingerTaxIndividualRelief;
    }

    /**
     * 设置三级指标：个人所得税-税收减免
     *
     * @param fingerTaxIndividualRelief 三级指标：个人所得税-税收减免
     */
    public void setFingerTaxIndividualRelief(Double fingerTaxIndividualRelief) {
        this.fingerTaxIndividualRelief = fingerTaxIndividualRelief;
    }

    /**
     * 获取二级指标：增值税
     *
     * @return finger_tax_added - 二级指标：增值税
     */
    public Double getFingerTaxAdded() {
        return fingerTaxAdded;
    }

    /**
     * 设置二级指标：增值税
     *
     * @param fingerTaxAdded 二级指标：增值税
     */
    public void setFingerTaxAdded(Double fingerTaxAdded) {
        this.fingerTaxAdded = fingerTaxAdded;
    }

    /**
     * 获取三级指标：增值税-应纳税值
     *
     * @return finger_tax_added_taxable - 三级指标：增值税-应纳税值
     */
    public Double getFingerTaxAddedTaxable() {
        return fingerTaxAddedTaxable;
    }

    /**
     * 设置三级指标：增值税-应纳税值
     *
     * @param fingerTaxAddedTaxable 三级指标：增值税-应纳税值
     */
    public void setFingerTaxAddedTaxable(Double fingerTaxAddedTaxable) {
        this.fingerTaxAddedTaxable = fingerTaxAddedTaxable;
    }

    /**
     * 获取三级指标：增值税-税收减免
     *
     * @return finger_tax_added_relief - 三级指标：增值税-税收减免
     */
    public Double getFingerTaxAddedRelief() {
        return fingerTaxAddedRelief;
    }

    /**
     * 设置三级指标：增值税-税收减免
     *
     * @param fingerTaxAddedRelief 三级指标：增值税-税收减免
     */
    public void setFingerTaxAddedRelief(Double fingerTaxAddedRelief) {
        this.fingerTaxAddedRelief = fingerTaxAddedRelief;
    }

    /**
     * 获取一级指标：融资指数
     *
     * @return finger_finance - 一级指标：融资指数
     */
    public Double getFingerFinance() {
        return fingerFinance;
    }

    /**
     * 设置一级指标：融资指数
     *
     * @param fingerFinance 一级指标：融资指数
     */
    public void setFingerFinance(Double fingerFinance) {
        this.fingerFinance = fingerFinance;
    }

    /**
     * 获取二级指标：股权类融资
     *
     * @return finger_finance_stock - 二级指标：股权类融资
     */
    public Double getFingerFinanceStock() {
        return fingerFinanceStock;
    }

    /**
     * 设置二级指标：股权类融资
     *
     * @param fingerFinanceStock 二级指标：股权类融资
     */
    public void setFingerFinanceStock(Double fingerFinanceStock) {
        this.fingerFinanceStock = fingerFinanceStock;
    }

    /**
     * 获取三级指标：股权类融资-风投机构
     *
     * @return finger_finance_stock_risk - 三级指标：股权类融资-风投机构
     */
    public Double getFingerFinanceStockRisk() {
        return fingerFinanceStockRisk;
    }

    /**
     * 设置三级指标：股权类融资-风投机构
     *
     * @param fingerFinanceStockRisk 三级指标：股权类融资-风投机构
     */
    public void setFingerFinanceStockRisk(Double fingerFinanceStockRisk) {
        this.fingerFinanceStockRisk = fingerFinanceStockRisk;
    }

    /**
     * 获取三级指标：股权类融资-政府企业
     *
     * @return finger_finance_stock_gov - 三级指标：股权类融资-政府企业
     */
    public Double getFingerFinanceStockGov() {
        return fingerFinanceStockGov;
    }

    /**
     * 设置三级指标：股权类融资-政府企业
     *
     * @param fingerFinanceStockGov 三级指标：股权类融资-政府企业
     */
    public void setFingerFinanceStockGov(Double fingerFinanceStockGov) {
        this.fingerFinanceStockGov = fingerFinanceStockGov;
    }

    /**
     * 获取三级指标：股权类融资-个人
     *
     * @return finger_finance_stock_person - 三级指标：股权类融资-个人
     */
    public Double getFingerFinanceStockPerson() {
        return fingerFinanceStockPerson;
    }

    /**
     * 设置三级指标：股权类融资-个人
     *
     * @param fingerFinanceStockPerson 三级指标：股权类融资-个人
     */
    public void setFingerFinanceStockPerson(Double fingerFinanceStockPerson) {
        this.fingerFinanceStockPerson = fingerFinanceStockPerson;
    }

    /**
     * 获取二级指标：债务类融资
     *
     * @return finger_finance_debt - 二级指标：债务类融资
     */
    public Double getFingerFinanceDebt() {
        return fingerFinanceDebt;
    }

    /**
     * 设置二级指标：债务类融资
     *
     * @param fingerFinanceDebt 二级指标：债务类融资
     */
    public void setFingerFinanceDebt(Double fingerFinanceDebt) {
        this.fingerFinanceDebt = fingerFinanceDebt;
    }

    /**
     * 获取三级指标：债务类融资-银行
     *
     * @return finger_finance_debt_bank - 三级指标：债务类融资-银行
     */
    public Double getFingerFinanceDebtBank() {
        return fingerFinanceDebtBank;
    }

    /**
     * 设置三级指标：债务类融资-银行
     *
     * @param fingerFinanceDebtBank 三级指标：债务类融资-银行
     */
    public void setFingerFinanceDebtBank(Double fingerFinanceDebtBank) {
        this.fingerFinanceDebtBank = fingerFinanceDebtBank;
    }

    /**
     * 获取三级指标：债务类融资-新型贷款机构
     *
     * @return finger_finance_debt_new - 三级指标：债务类融资-新型贷款机构
     */
    public Double getFingerFinanceDebtNew() {
        return fingerFinanceDebtNew;
    }

    /**
     * 设置三级指标：债务类融资-新型贷款机构
     *
     * @param fingerFinanceDebtNew 三级指标：债务类融资-新型贷款机构
     */
    public void setFingerFinanceDebtNew(Double fingerFinanceDebtNew) {
        this.fingerFinanceDebtNew = fingerFinanceDebtNew;
    }

    /**
     * 获取三级指标：债务类融资-企业拆借
     *
     * @return finger_finance_debt_lending - 三级指标：债务类融资-企业拆借
     */
    public Double getFingerFinanceDebtLending() {
        return fingerFinanceDebtLending;
    }

    /**
     * 设置三级指标：债务类融资-企业拆借
     *
     * @param fingerFinanceDebtLending 三级指标：债务类融资-企业拆借
     */
    public void setFingerFinanceDebtLending(Double fingerFinanceDebtLending) {
        this.fingerFinanceDebtLending = fingerFinanceDebtLending;
    }

    /**
     * 获取三级指标：债务类融资-个人
     *
     * @return finger_finance_debt_person - 三级指标：债务类融资-个人
     */
    public Double getFingerFinanceDebtPerson() {
        return fingerFinanceDebtPerson;
    }

    /**
     * 设置三级指标：债务类融资-个人
     *
     * @param fingerFinanceDebtPerson 三级指标：债务类融资-个人
     */
    public void setFingerFinanceDebtPerson(Double fingerFinanceDebtPerson) {
        this.fingerFinanceDebtPerson = fingerFinanceDebtPerson;
    }

    /**
     * 获取一级指标:估值指数
     *
     * @return finger_valuation - 一级指标:估值指数
     */
    public Double getFingerValuation() {
        return fingerValuation;
    }

    /**
     * 设置一级指标:估值指数
     *
     * @param fingerValuation 一级指标:估值指数
     */
    public void setFingerValuation(Double fingerValuation) {
        this.fingerValuation = fingerValuation;
    }

    /**
     * 获取二级指标：净资产
     *
     * @return finger_valuation_assets - 二级指标：净资产
     */
    public Double getFingerValuationAssets() {
        return fingerValuationAssets;
    }

    /**
     * 设置二级指标：净资产
     *
     * @param fingerValuationAssets 二级指标：净资产
     */
    public void setFingerValuationAssets(Double fingerValuationAssets) {
        this.fingerValuationAssets = fingerValuationAssets;
    }

    /**
     * 获取三级指标：净资产-流动资产
     *
     * @return finger_valuation_assets_circulating - 三级指标：净资产-流动资产
     */
    public Double getFingerValuationAssetsCirculating() {
        return fingerValuationAssetsCirculating;
    }

    /**
     * 设置三级指标：净资产-流动资产
     *
     * @param fingerValuationAssetsCirculating 三级指标：净资产-流动资产
     */
    public void setFingerValuationAssetsCirculating(Double fingerValuationAssetsCirculating) {
        this.fingerValuationAssetsCirculating = fingerValuationAssetsCirculating;
    }

    /**
     * 获取三级指标：净资产-非流动资产
     *
     * @return finger_valuation_assets_uncirculating - 三级指标：净资产-非流动资产
     */
    public Double getFingerValuationAssetsUncirculating() {
        return fingerValuationAssetsUncirculating;
    }

    /**
     * 设置三级指标：净资产-非流动资产
     *
     * @param fingerValuationAssetsUncirculating 三级指标：净资产-非流动资产
     */
    public void setFingerValuationAssetsUncirculating(Double fingerValuationAssetsUncirculating) {
        this.fingerValuationAssetsUncirculating = fingerValuationAssetsUncirculating;
    }

    /**
     * 获取三级指标：净资产-流动负债
     *
     * @return finger_valuation_assets_debt_circulating - 三级指标：净资产-流动负债
     */
    public Double getFingerValuationAssetsDebtCirculating() {
        return fingerValuationAssetsDebtCirculating;
    }

    /**
     * 设置三级指标：净资产-流动负债
     *
     * @param fingerValuationAssetsDebtCirculating 三级指标：净资产-流动负债
     */
    public void setFingerValuationAssetsDebtCirculating(Double fingerValuationAssetsDebtCirculating) {
        this.fingerValuationAssetsDebtCirculating = fingerValuationAssetsDebtCirculating;
    }

    /**
     * 获取三级指标：净资产-非流动负债
     *
     * @return finger_valuation_assets_debt_uncirculating - 三级指标：净资产-非流动负债
     */
    public Double getFingerValuationAssetsDebtUncirculating() {
        return fingerValuationAssetsDebtUncirculating;
    }

    /**
     * 设置三级指标：净资产-非流动负债
     *
     * @param fingerValuationAssetsDebtUncirculating 三级指标：净资产-非流动负债
     */
    public void setFingerValuationAssetsDebtUncirculating(Double fingerValuationAssetsDebtUncirculating) {
        this.fingerValuationAssetsDebtUncirculating = fingerValuationAssetsDebtUncirculating;
    }

    /**
     * 获取二级指标：实际估值
     *
     * @return finger_valuation_actual - 二级指标：实际估值
     */
    public Double getFingerValuationActual() {
        return fingerValuationActual;
    }

    /**
     * 设置二级指标：实际估值
     *
     * @param fingerValuationActual 二级指标：实际估值
     */
    public void setFingerValuationActual(Double fingerValuationActual) {
        this.fingerValuationActual = fingerValuationActual;
    }

    /**
     * 获取三级指标：实际估值-首次融资
     *
     * @return finger_valuation_actual_first - 三级指标：实际估值-首次融资
     */
    public Double getFingerValuationActualFirst() {
        return fingerValuationActualFirst;
    }

    /**
     * 设置三级指标：实际估值-首次融资
     *
     * @param fingerValuationActualFirst 三级指标：实际估值-首次融资
     */
    public void setFingerValuationActualFirst(Double fingerValuationActualFirst) {
        this.fingerValuationActualFirst = fingerValuationActualFirst;
    }

    /**
     * 获取三级指标：实际估值-最近一次融资估值
     *
     * @return finger_valuation_actual_latest - 三级指标：实际估值-最近一次融资估值
     */
    public Double getFingerValuationActualLatest() {
        return fingerValuationActualLatest;
    }

    /**
     * 设置三级指标：实际估值-最近一次融资估值
     *
     * @param fingerValuationActualLatest 三级指标：实际估值-最近一次融资估值
     */
    public void setFingerValuationActualLatest(Double fingerValuationActualLatest) {
        this.fingerValuationActualLatest = fingerValuationActualLatest;
    }

    /**
     * 获取三级指标：实际估值-现在准备融资估值
     *
     * @return finger_valuation_actual_want - 三级指标：实际估值-现在准备融资估值
     */
    public Double getFingerValuationActualWant() {
        return fingerValuationActualWant;
    }

    /**
     * 设置三级指标：实际估值-现在准备融资估值
     *
     * @param fingerValuationActualWant 三级指标：实际估值-现在准备融资估值
     */
    public void setFingerValuationActualWant(Double fingerValuationActualWant) {
        this.fingerValuationActualWant = fingerValuationActualWant;
    }

    /**
     * 获取一级指标：人力资源指数
     *
     * @return finger_hr - 一级指标：人力资源指数
     */
    public Double getFingerHr() {
        return fingerHr;
    }

    /**
     * 设置一级指标：人力资源指数
     *
     * @param fingerHr 一级指标：人力资源指数
     */
    public void setFingerHr(Double fingerHr) {
        this.fingerHr = fingerHr;
    }

    /**
     * 获取二级指标：兼职员工数
     *
     * @return finger_hr_partime - 二级指标：兼职员工数
     */
    public Double getFingerHrPartime() {
        return fingerHrPartime;
    }

    /**
     * 设置二级指标：兼职员工数
     *
     * @param fingerHrPartime 二级指标：兼职员工数
     */
    public void setFingerHrPartime(Double fingerHrPartime) {
        this.fingerHrPartime = fingerHrPartime;
    }

    /**
     * 获取三级指标：兼职员工-研发
     *
     * @return finger_hr_partime_dev - 三级指标：兼职员工-研发
     */
    public Double getFingerHrPartimeDev() {
        return fingerHrPartimeDev;
    }

    /**
     * 设置三级指标：兼职员工-研发
     *
     * @param fingerHrPartimeDev 三级指标：兼职员工-研发
     */
    public void setFingerHrPartimeDev(Double fingerHrPartimeDev) {
        this.fingerHrPartimeDev = fingerHrPartimeDev;
    }

    /**
     * 获取三级指标：兼职员工-管理
     *
     * @return finger_hr_partime_manage - 三级指标：兼职员工-管理
     */
    public Double getFingerHrPartimeManage() {
        return fingerHrPartimeManage;
    }

    /**
     * 设置三级指标：兼职员工-管理
     *
     * @param fingerHrPartimeManage 三级指标：兼职员工-管理
     */
    public void setFingerHrPartimeManage(Double fingerHrPartimeManage) {
        this.fingerHrPartimeManage = fingerHrPartimeManage;
    }

    /**
     * 获取三级指标：兼职员工-行政
     *
     * @return finger_hr_partime_admin - 三级指标：兼职员工-行政
     */
    public Double getFingerHrPartimeAdmin() {
        return fingerHrPartimeAdmin;
    }

    /**
     * 设置三级指标：兼职员工-行政
     *
     * @param fingerHrPartimeAdmin 三级指标：兼职员工-行政
     */
    public void setFingerHrPartimeAdmin(Double fingerHrPartimeAdmin) {
        this.fingerHrPartimeAdmin = fingerHrPartimeAdmin;
    }

    /**
     * 获取三级指标：兼职员工-销售
     *
     * @return finger_hr_partime_saler - 三级指标：兼职员工-销售
     */
    public Double getFingerHrPartimeSaler() {
        return fingerHrPartimeSaler;
    }

    /**
     * 设置三级指标：兼职员工-销售
     *
     * @param fingerHrPartimeSaler 三级指标：兼职员工-销售
     */
    public void setFingerHrPartimeSaler(Double fingerHrPartimeSaler) {
        this.fingerHrPartimeSaler = fingerHrPartimeSaler;
    }

    /**
     * 获取二级指标：全职员工
     *
     * @return finger_hr_fulltime - 二级指标：全职员工
     */
    public Double getFingerHrFulltime() {
        return fingerHrFulltime;
    }

    /**
     * 设置二级指标：全职员工
     *
     * @param fingerHrFulltime 二级指标：全职员工
     */
    public void setFingerHrFulltime(Double fingerHrFulltime) {
        this.fingerHrFulltime = fingerHrFulltime;
    }

    /**
     * 获取三级指标：全职员工-研发
     *
     * @return finger_hr_fulltime_dev - 三级指标：全职员工-研发
     */
    public Double getFingerHrFulltimeDev() {
        return fingerHrFulltimeDev;
    }

    /**
     * 设置三级指标：全职员工-研发
     *
     * @param fingerHrFulltimeDev 三级指标：全职员工-研发
     */
    public void setFingerHrFulltimeDev(Double fingerHrFulltimeDev) {
        this.fingerHrFulltimeDev = fingerHrFulltimeDev;
    }

    /**
     * 获取三级指标：全职员工-高管
     *
     * @return finger_hr_fulltime_senior - 三级指标：全职员工-高管
     */
    public Double getFingerHrFulltimeSenior() {
        return fingerHrFulltimeSenior;
    }

    /**
     * 设置三级指标：全职员工-高管
     *
     * @param fingerHrFulltimeSenior 三级指标：全职员工-高管
     */
    public void setFingerHrFulltimeSenior(Double fingerHrFulltimeSenior) {
        this.fingerHrFulltimeSenior = fingerHrFulltimeSenior;
    }

    /**
     * 获取三级指标：全职员工-行政
     *
     * @return finger_hr_fulltime_admin - 三级指标：全职员工-行政
     */
    public Double getFingerHrFulltimeAdmin() {
        return fingerHrFulltimeAdmin;
    }

    /**
     * 设置三级指标：全职员工-行政
     *
     * @param fingerHrFulltimeAdmin 三级指标：全职员工-行政
     */
    public void setFingerHrFulltimeAdmin(Double fingerHrFulltimeAdmin) {
        this.fingerHrFulltimeAdmin = fingerHrFulltimeAdmin;
    }

    /**
     * 获取三级指标：全职员工-销售
     *
     * @return finger_hr_fulltime_saler - 三级指标：全职员工-销售
     */
    public Double getFingerHrFulltimeSaler() {
        return fingerHrFulltimeSaler;
    }

    /**
     * 设置三级指标：全职员工-销售
     *
     * @param fingerHrFulltimeSaler 三级指标：全职员工-销售
     */
    public void setFingerHrFulltimeSaler(Double fingerHrFulltimeSaler) {
        this.fingerHrFulltimeSaler = fingerHrFulltimeSaler;
    }

    /**
     * 获取二级指标：高学历人员
     *
     * @return finger_hr_educated - 二级指标：高学历人员
     */
    public Double getFingerHrEducated() {
        return fingerHrEducated;
    }

    /**
     * 设置二级指标：高学历人员
     *
     * @param fingerHrEducated 二级指标：高学历人员
     */
    public void setFingerHrEducated(Double fingerHrEducated) {
        this.fingerHrEducated = fingerHrEducated;
    }

    /**
     * 获取三级指标：高学历人员-博士
     *
     * @return finger_hr_educated_doc - 三级指标：高学历人员-博士
     */
    public Double getFingerHrEducatedDoc() {
        return fingerHrEducatedDoc;
    }

    /**
     * 设置三级指标：高学历人员-博士
     *
     * @param fingerHrEducatedDoc 三级指标：高学历人员-博士
     */
    public void setFingerHrEducatedDoc(Double fingerHrEducatedDoc) {
        this.fingerHrEducatedDoc = fingerHrEducatedDoc;
    }

    /**
     * 获取三级指标：高学历人员-硕士
     *
     * @return finger_hr_educated_master - 三级指标：高学历人员-硕士
     */
    public Double getFingerHrEducatedMaster() {
        return fingerHrEducatedMaster;
    }

    /**
     * 设置三级指标：高学历人员-硕士
     *
     * @param fingerHrEducatedMaster 三级指标：高学历人员-硕士
     */
    public void setFingerHrEducatedMaster(Double fingerHrEducatedMaster) {
        this.fingerHrEducatedMaster = fingerHrEducatedMaster;
    }

    /**
     * 获取三级指标：高学历人员-学士
     *
     * @return finger_hr_bachelor - 三级指标：高学历人员-学士
     */
    public Double getFingerHrBachelor() {
        return fingerHrBachelor;
    }

    /**
     * 设置三级指标：高学历人员-学士
     *
     * @param fingerHrBachelor 三级指标：高学历人员-学士
     */
    public void setFingerHrBachelor(Double fingerHrBachelor) {
        this.fingerHrBachelor = fingerHrBachelor;
    }

    /**
     * 获取一级指标：创新指数
     *
     * @return finger_innovate - 一级指标：创新指数
     */
    public Double getFingerInnovate() {
        return fingerInnovate;
    }

    /**
     * 设置一级指标：创新指数
     *
     * @param fingerInnovate 一级指标：创新指数
     */
    public void setFingerInnovate(Double fingerInnovate) {
        this.fingerInnovate = fingerInnovate;
    }

    /**
     * 获取二级指标：专利申请
     *
     * @return finger_innovate_patent_apply - 二级指标：专利申请
     */
    public Double getFingerInnovatePatentApply() {
        return fingerInnovatePatentApply;
    }

    /**
     * 设置二级指标：专利申请
     *
     * @param fingerInnovatePatentApply 二级指标：专利申请
     */
    public void setFingerInnovatePatentApply(Double fingerInnovatePatentApply) {
        this.fingerInnovatePatentApply = fingerInnovatePatentApply;
    }

    /**
     * 获取三级指标：专利申请-发明
     *
     * @return finger_innovate_patent_apply_invention - 三级指标：专利申请-发明
     */
    public Double getFingerInnovatePatentApplyInvention() {
        return fingerInnovatePatentApplyInvention;
    }

    /**
     * 设置三级指标：专利申请-发明
     *
     * @param fingerInnovatePatentApplyInvention 三级指标：专利申请-发明
     */
    public void setFingerInnovatePatentApplyInvention(Double fingerInnovatePatentApplyInvention) {
        this.fingerInnovatePatentApplyInvention = fingerInnovatePatentApplyInvention;
    }

    /**
     * 获取三级指标：专利申请-实用新型
     *
     * @return finger_innovate_patent_apply_utility - 三级指标：专利申请-实用新型
     */
    public Double getFingerInnovatePatentApplyUtility() {
        return fingerInnovatePatentApplyUtility;
    }

    /**
     * 设置三级指标：专利申请-实用新型
     *
     * @param fingerInnovatePatentApplyUtility 三级指标：专利申请-实用新型
     */
    public void setFingerInnovatePatentApplyUtility(Double fingerInnovatePatentApplyUtility) {
        this.fingerInnovatePatentApplyUtility = fingerInnovatePatentApplyUtility;
    }

    /**
     * 获取三级指标：专利申请-外观设计
     *
     * @return finger_innovate_patent_apply_appear - 三级指标：专利申请-外观设计
     */
    public Double getFingerInnovatePatentApplyAppear() {
        return fingerInnovatePatentApplyAppear;
    }

    /**
     * 设置三级指标：专利申请-外观设计
     *
     * @param fingerInnovatePatentApplyAppear 三级指标：专利申请-外观设计
     */
    public void setFingerInnovatePatentApplyAppear(Double fingerInnovatePatentApplyAppear) {
        this.fingerInnovatePatentApplyAppear = fingerInnovatePatentApplyAppear;
    }

    /**
     * 获取二级指标：专利授权
     *
     * @return finger_innovate_patent_grant - 二级指标：专利授权
     */
    public Double getFingerInnovatePatentGrant() {
        return fingerInnovatePatentGrant;
    }

    /**
     * 设置二级指标：专利授权
     *
     * @param fingerInnovatePatentGrant 二级指标：专利授权
     */
    public void setFingerInnovatePatentGrant(Double fingerInnovatePatentGrant) {
        this.fingerInnovatePatentGrant = fingerInnovatePatentGrant;
    }

    /**
     * 获取三级指标：专利授权-发明
     *
     * @return finger_innovate_patent_grant_invention - 三级指标：专利授权-发明
     */
    public Double getFingerInnovatePatentGrantInvention() {
        return fingerInnovatePatentGrantInvention;
    }

    /**
     * 设置三级指标：专利授权-发明
     *
     * @param fingerInnovatePatentGrantInvention 三级指标：专利授权-发明
     */
    public void setFingerInnovatePatentGrantInvention(Double fingerInnovatePatentGrantInvention) {
        this.fingerInnovatePatentGrantInvention = fingerInnovatePatentGrantInvention;
    }

    /**
     * 获取三级指标：专利授权-实用新型
     *
     * @return finger_innovate_patent_grant_utility - 三级指标：专利授权-实用新型
     */
    public Double getFingerInnovatePatentGrantUtility() {
        return fingerInnovatePatentGrantUtility;
    }

    /**
     * 设置三级指标：专利授权-实用新型
     *
     * @param fingerInnovatePatentGrantUtility 三级指标：专利授权-实用新型
     */
    public void setFingerInnovatePatentGrantUtility(Double fingerInnovatePatentGrantUtility) {
        this.fingerInnovatePatentGrantUtility = fingerInnovatePatentGrantUtility;
    }

    /**
     * 获取三级指标：专利授权-外观设计
     *
     * @return finger_innovate_patent_grant_appear - 三级指标：专利授权-外观设计
     */
    public Double getFingerInnovatePatentGrantAppear() {
        return fingerInnovatePatentGrantAppear;
    }

    /**
     * 设置三级指标：专利授权-外观设计
     *
     * @param fingerInnovatePatentGrantAppear 三级指标：专利授权-外观设计
     */
    public void setFingerInnovatePatentGrantAppear(Double fingerInnovatePatentGrantAppear) {
        this.fingerInnovatePatentGrantAppear = fingerInnovatePatentGrantAppear;
    }

    /**
     * 获取二级指标：著作权申请
     *
     * @return finger_innovate_copyright_apply - 二级指标：著作权申请
     */
    public Double getFingerInnovateCopyrightApply() {
        return fingerInnovateCopyrightApply;
    }

    /**
     * 设置二级指标：著作权申请
     *
     * @param fingerInnovateCopyrightApply 二级指标：著作权申请
     */
    public void setFingerInnovateCopyrightApply(Double fingerInnovateCopyrightApply) {
        this.fingerInnovateCopyrightApply = fingerInnovateCopyrightApply;
    }

    /**
     * 获取三级指标：著作权申请-软件类
     *
     * @return finger_innovate_copyright_apply_soft - 三级指标：著作权申请-软件类
     */
    public Double getFingerInnovateCopyrightApplySoft() {
        return fingerInnovateCopyrightApplySoft;
    }

    /**
     * 设置三级指标：著作权申请-软件类
     *
     * @param fingerInnovateCopyrightApplySoft 三级指标：著作权申请-软件类
     */
    public void setFingerInnovateCopyrightApplySoft(Double fingerInnovateCopyrightApplySoft) {
        this.fingerInnovateCopyrightApplySoft = fingerInnovateCopyrightApplySoft;
    }

    /**
     * 获取三级指标：著作权申请-非软件类
     *
     * @return finger_innovate_copyright_apply_unsoft - 三级指标：著作权申请-非软件类
     */
    public Double getFingerInnovateCopyrightApplyUnsoft() {
        return fingerInnovateCopyrightApplyUnsoft;
    }

    /**
     * 设置三级指标：著作权申请-非软件类
     *
     * @param fingerInnovateCopyrightApplyUnsoft 三级指标：著作权申请-非软件类
     */
    public void setFingerInnovateCopyrightApplyUnsoft(Double fingerInnovateCopyrightApplyUnsoft) {
        this.fingerInnovateCopyrightApplyUnsoft = fingerInnovateCopyrightApplyUnsoft;
    }

    /**
     * 获取二级指标：著作权授权
     *
     * @return finger_innovate_copyright_grant - 二级指标：著作权授权
     */
    public Double getFingerInnovateCopyrightGrant() {
        return fingerInnovateCopyrightGrant;
    }

    /**
     * 设置二级指标：著作权授权
     *
     * @param fingerInnovateCopyrightGrant 二级指标：著作权授权
     */
    public void setFingerInnovateCopyrightGrant(Double fingerInnovateCopyrightGrant) {
        this.fingerInnovateCopyrightGrant = fingerInnovateCopyrightGrant;
    }

    /**
     * 获取三级指标：著作权授权-软件类
     *
     * @return finger_innovate_copyright_grant_soft - 三级指标：著作权授权-软件类
     */
    public Double getFingerInnovateCopyrightGrantSoft() {
        return fingerInnovateCopyrightGrantSoft;
    }

    /**
     * 设置三级指标：著作权授权-软件类
     *
     * @param fingerInnovateCopyrightGrantSoft 三级指标：著作权授权-软件类
     */
    public void setFingerInnovateCopyrightGrantSoft(Double fingerInnovateCopyrightGrantSoft) {
        this.fingerInnovateCopyrightGrantSoft = fingerInnovateCopyrightGrantSoft;
    }

    /**
     * 获取三级指标：著作权授权-非软件类
     *
     * @return finger_innovate_copyright_grant_unsoft - 三级指标：著作权授权-非软件类
     */
    public Double getFingerInnovateCopyrightGrantUnsoft() {
        return fingerInnovateCopyrightGrantUnsoft;
    }

    /**
     * 设置三级指标：著作权授权-非软件类
     *
     * @param fingerInnovateCopyrightGrantUnsoft 三级指标：著作权授权-非软件类
     */
    public void setFingerInnovateCopyrightGrantUnsoft(Double fingerInnovateCopyrightGrantUnsoft) {
        this.fingerInnovateCopyrightGrantUnsoft = fingerInnovateCopyrightGrantUnsoft;
    }

    /**
     * 获取二级指标：新产品/服务
     *
     * @return finger_innovate_new_product - 二级指标：新产品/服务
     */
    public Double getFingerInnovateNewProduct() {
        return fingerInnovateNewProduct;
    }

    /**
     * 设置二级指标：新产品/服务
     *
     * @param fingerInnovateNewProduct 二级指标：新产品/服务
     */
    public void setFingerInnovateNewProduct(Double fingerInnovateNewProduct) {
        this.fingerInnovateNewProduct = fingerInnovateNewProduct;
    }

    /**
     * 获取三级指标：新产品/服务-专利类
     *
     * @return finger_innovate_new_product_patent - 三级指标：新产品/服务-专利类
     */
    public Double getFingerInnovateNewProductPatent() {
        return fingerInnovateNewProductPatent;
    }

    /**
     * 设置三级指标：新产品/服务-专利类
     *
     * @param fingerInnovateNewProductPatent 三级指标：新产品/服务-专利类
     */
    public void setFingerInnovateNewProductPatent(Double fingerInnovateNewProductPatent) {
        this.fingerInnovateNewProductPatent = fingerInnovateNewProductPatent;
    }

    /**
     * 获取三级指标：新产品/服务-专用技术
     *
     * @return finger_innovate_new_product_tech - 三级指标：新产品/服务-专用技术
     */
    public Double getFingerInnovateNewProductTech() {
        return fingerInnovateNewProductTech;
    }

    /**
     * 设置三级指标：新产品/服务-专用技术
     *
     * @param fingerInnovateNewProductTech 三级指标：新产品/服务-专用技术
     */
    public void setFingerInnovateNewProductTech(Double fingerInnovateNewProductTech) {
        this.fingerInnovateNewProductTech = fingerInnovateNewProductTech;
    }

    /**
     * 获取三级指标：新产品/服务-商业模式
     *
     * @return finger_innovate_new_product_bus - 三级指标：新产品/服务-商业模式
     */
    public Double getFingerInnovateNewProductBus() {
        return fingerInnovateNewProductBus;
    }

    /**
     * 设置三级指标：新产品/服务-商业模式
     *
     * @param fingerInnovateNewProductBus 三级指标：新产品/服务-商业模式
     */
    public void setFingerInnovateNewProductBus(Double fingerInnovateNewProductBus) {
        this.fingerInnovateNewProductBus = fingerInnovateNewProductBus;
    }

    /**
     * 获取一级指标：薪酬指数
     *
     * @return finger_salary - 一级指标：薪酬指数
     */
    public Double getFingerSalary() {
        return fingerSalary;
    }

    /**
     * 设置一级指标：薪酬指数
     *
     * @param fingerSalary 一级指标：薪酬指数
     */
    public void setFingerSalary(Double fingerSalary) {
        this.fingerSalary = fingerSalary;
    }

    /**
     * 获取二级指标：员工工资额
     *
     * @return finger_salary_staff - 二级指标：员工工资额
     */
    public Double getFingerSalaryStaff() {
        return fingerSalaryStaff;
    }

    /**
     * 设置二级指标：员工工资额
     *
     * @param fingerSalaryStaff 二级指标：员工工资额
     */
    public void setFingerSalaryStaff(Double fingerSalaryStaff) {
        this.fingerSalaryStaff = fingerSalaryStaff;
    }

    /**
     * 获取三级指标：员工工资额-1万元以上
     *
     * @return finger_salary_staff_up_10 - 三级指标：员工工资额-1万元以上
     */
    public Double getFingerSalaryStaffUp10() {
        return fingerSalaryStaffUp10;
    }

    /**
     * 设置三级指标：员工工资额-1万元以上
     *
     * @param fingerSalaryStaffUp10 三级指标：员工工资额-1万元以上
     */
    public void setFingerSalaryStaffUp10(Double fingerSalaryStaffUp10) {
        this.fingerSalaryStaffUp10 = fingerSalaryStaffUp10;
    }

    /**
     * 获取三级指标：员工工资额-5千到1万
     *
     * @return finger_salary_staff_5_10 - 三级指标：员工工资额-5千到1万
     */
    public Double getFingerSalaryStaff510() {
        return fingerSalaryStaff510;
    }

    /**
     * 设置三级指标：员工工资额-5千到1万
     *
     * @param fingerSalaryStaff510 三级指标：员工工资额-5千到1万
     */
    public void setFingerSalaryStaff510(Double fingerSalaryStaff510) {
        this.fingerSalaryStaff510 = fingerSalaryStaff510;
    }

    /**
     * 获取三级指标：员工工资额-5千以下
     *
     * @return finger_salary_staff_down_5 - 三级指标：员工工资额-5千以下
     */
    public Double getFingerSalaryStaffDown5() {
        return fingerSalaryStaffDown5;
    }

    /**
     * 设置三级指标：员工工资额-5千以下
     *
     * @param fingerSalaryStaffDown5 三级指标：员工工资额-5千以下
     */
    public void setFingerSalaryStaffDown5(Double fingerSalaryStaffDown5) {
        this.fingerSalaryStaffDown5 = fingerSalaryStaffDown5;
    }

    /**
     * 获取二级指标：员工贡献率
     *
     * @return finger_salary_staff_contribution - 二级指标：员工贡献率
     */
    public Double getFingerSalaryStaffContribution() {
        return fingerSalaryStaffContribution;
    }

    /**
     * 设置二级指标：员工贡献率
     *
     * @param fingerSalaryStaffContribution 二级指标：员工贡献率
     */
    public void setFingerSalaryStaffContribution(Double fingerSalaryStaffContribution) {
        this.fingerSalaryStaffContribution = fingerSalaryStaffContribution;
    }

    /**
     * 获取三级指标：员工贡献率-人均销售
     *
     * @return finger_salary_staff_contribution_meansale - 三级指标：员工贡献率-人均销售
     */
    public Double getFingerSalaryStaffContributionMeansale() {
        return fingerSalaryStaffContributionMeansale;
    }

    /**
     * 设置三级指标：员工贡献率-人均销售
     *
     * @param fingerSalaryStaffContributionMeansale 三级指标：员工贡献率-人均销售
     */
    public void setFingerSalaryStaffContributionMeansale(Double fingerSalaryStaffContributionMeansale) {
        this.fingerSalaryStaffContributionMeansale = fingerSalaryStaffContributionMeansale;
    }

    /**
     * 获取三级指标：员工贡献率-人均纳税
     *
     * @return finger_salary_staff_contribution_meantax - 三级指标：员工贡献率-人均纳税
     */
    public Double getFingerSalaryStaffContributionMeantax() {
        return fingerSalaryStaffContributionMeantax;
    }

    /**
     * 设置三级指标：员工贡献率-人均纳税
     *
     * @param fingerSalaryStaffContributionMeantax 三级指标：员工贡献率-人均纳税
     */
    public void setFingerSalaryStaffContributionMeantax(Double fingerSalaryStaffContributionMeantax) {
        this.fingerSalaryStaffContributionMeantax = fingerSalaryStaffContributionMeantax;
    }

    /**
     * 获取一级指标：学习指数
     *
     * @return finger_learn - 一级指标：学习指数
     */
    public Double getFingerLearn() {
        return fingerLearn;
    }

    /**
     * 设置一级指标：学习指数
     *
     * @param fingerLearn 一级指标：学习指数
     */
    public void setFingerLearn(Double fingerLearn) {
        this.fingerLearn = fingerLearn;
    }

    /**
     * 获取二级指标：参加培训的次数
     *
     * @return finger_learn_train - 二级指标：参加培训的次数
     */
    public Double getFingerLearnTrain() {
        return fingerLearnTrain;
    }

    /**
     * 设置二级指标：参加培训的次数
     *
     * @param fingerLearnTrain 二级指标：参加培训的次数
     */
    public void setFingerLearnTrain(Double fingerLearnTrain) {
        this.fingerLearnTrain = fingerLearnTrain;
    }

    /**
     * 获取三级指标：参加培训的次数-管理类
     *
     * @return finger_learn_train_manage - 三级指标：参加培训的次数-管理类
     */
    public Double getFingerLearnTrainManage() {
        return fingerLearnTrainManage;
    }

    /**
     * 设置三级指标：参加培训的次数-管理类
     *
     * @param fingerLearnTrainManage 三级指标：参加培训的次数-管理类
     */
    public void setFingerLearnTrainManage(Double fingerLearnTrainManage) {
        this.fingerLearnTrainManage = fingerLearnTrainManage;
    }

    /**
     * 获取三级指标：参加培训的次数-政策法规
     *
     * @return finger_learn_train_policy - 三级指标：参加培训的次数-政策法规
     */
    public Double getFingerLearnTrainPolicy() {
        return fingerLearnTrainPolicy;
    }

    /**
     * 设置三级指标：参加培训的次数-政策法规
     *
     * @param fingerLearnTrainPolicy 三级指标：参加培训的次数-政策法规
     */
    public void setFingerLearnTrainPolicy(Double fingerLearnTrainPolicy) {
        this.fingerLearnTrainPolicy = fingerLearnTrainPolicy;
    }

    /**
     * 获取三级指标：参加培训的次数-技能类
     *
     * @return finger_learn_train_skill - 三级指标：参加培训的次数-技能类
     */
    public Double getFingerLearnTrainSkill() {
        return fingerLearnTrainSkill;
    }

    /**
     * 设置三级指标：参加培训的次数-技能类
     *
     * @param fingerLearnTrainSkill 三级指标：参加培训的次数-技能类
     */
    public void setFingerLearnTrainSkill(Double fingerLearnTrainSkill) {
        this.fingerLearnTrainSkill = fingerLearnTrainSkill;
    }

    /**
     * 获取二级指标：接受咨询的次数
     *
     * @return finger_learn_conslted - 二级指标：接受咨询的次数
     */
    public Double getFingerLearnConslted() {
        return fingerLearnConslted;
    }

    /**
     * 设置二级指标：接受咨询的次数
     *
     * @param fingerLearnConslted 二级指标：接受咨询的次数
     */
    public void setFingerLearnConslted(Double fingerLearnConslted) {
        this.fingerLearnConslted = fingerLearnConslted;
    }

    /**
     * 获取三级指标：接受咨询的次数-管理类
     *
     * @return finger_learn_conslted_manage - 三级指标：接受咨询的次数-管理类
     */
    public Double getFingerLearnConsltedManage() {
        return fingerLearnConsltedManage;
    }

    /**
     * 设置三级指标：接受咨询的次数-管理类
     *
     * @param fingerLearnConsltedManage 三级指标：接受咨询的次数-管理类
     */
    public void setFingerLearnConsltedManage(Double fingerLearnConsltedManage) {
        this.fingerLearnConsltedManage = fingerLearnConsltedManage;
    }

    /**
     * 获取三级指标：接受咨询的次数-政策法规
     *
     * @return finger_learn_conslted_policy - 三级指标：接受咨询的次数-政策法规
     */
    public Double getFingerLearnConsltedPolicy() {
        return fingerLearnConsltedPolicy;
    }

    /**
     * 设置三级指标：接受咨询的次数-政策法规
     *
     * @param fingerLearnConsltedPolicy 三级指标：接受咨询的次数-政策法规
     */
    public void setFingerLearnConsltedPolicy(Double fingerLearnConsltedPolicy) {
        this.fingerLearnConsltedPolicy = fingerLearnConsltedPolicy;
    }

    /**
     * 获取三级指标：接受咨询的次数-技能类
     *
     * @return finger_learn_conslted_skill - 三级指标：接受咨询的次数-技能类
     */
    public Double getFingerLearnConsltedSkill() {
        return fingerLearnConsltedSkill;
    }

    /**
     * 设置三级指标：接受咨询的次数-技能类
     *
     * @param fingerLearnConsltedSkill 三级指标：接受咨询的次数-技能类
     */
    public void setFingerLearnConsltedSkill(Double fingerLearnConsltedSkill) {
        this.fingerLearnConsltedSkill = fingerLearnConsltedSkill;
    }

    /**
     * 获取一级指标：品牌指数
     *
     * @return finger_brand - 一级指标：品牌指数
     */
    public Double getFingerBrand() {
        return fingerBrand;
    }

    /**
     * 设置一级指标：品牌指数
     *
     * @param fingerBrand 一级指标：品牌指数
     */
    public void setFingerBrand(Double fingerBrand) {
        this.fingerBrand = fingerBrand;
    }

    /**
     * 获取二级指标：企业获奖
     *
     * @return finger_brand_reward - 二级指标：企业获奖
     */
    public Double getFingerBrandReward() {
        return fingerBrandReward;
    }

    /**
     * 设置二级指标：企业获奖
     *
     * @param fingerBrandReward 二级指标：企业获奖
     */
    public void setFingerBrandReward(Double fingerBrandReward) {
        this.fingerBrandReward = fingerBrandReward;
    }

    /**
     * 获取三级指标：企业获奖-区级
     *
     * @return finger_brand_reward_area - 三级指标：企业获奖-区级
     */
    public Double getFingerBrandRewardArea() {
        return fingerBrandRewardArea;
    }

    /**
     * 设置三级指标：企业获奖-区级
     *
     * @param fingerBrandRewardArea 三级指标：企业获奖-区级
     */
    public void setFingerBrandRewardArea(Double fingerBrandRewardArea) {
        this.fingerBrandRewardArea = fingerBrandRewardArea;
    }

    /**
     * 获取三级指标：企业获奖-市级
     *
     * @return finger_brand_reward_city - 三级指标：企业获奖-市级
     */
    public Double getFingerBrandRewardCity() {
        return fingerBrandRewardCity;
    }

    /**
     * 设置三级指标：企业获奖-市级
     *
     * @param fingerBrandRewardCity 三级指标：企业获奖-市级
     */
    public void setFingerBrandRewardCity(Double fingerBrandRewardCity) {
        this.fingerBrandRewardCity = fingerBrandRewardCity;
    }

    /**
     * 获取三级指标：企业获奖-省级
     *
     * @return finger_brand_reward_province - 三级指标：企业获奖-省级
     */
    public Double getFingerBrandRewardProvince() {
        return fingerBrandRewardProvince;
    }

    /**
     * 设置三级指标：企业获奖-省级
     *
     * @param fingerBrandRewardProvince 三级指标：企业获奖-省级
     */
    public void setFingerBrandRewardProvince(Double fingerBrandRewardProvince) {
        this.fingerBrandRewardProvince = fingerBrandRewardProvince;
    }

    /**
     * 获取三级指标：企业获奖-国家级
     *
     * @return finger_brand_reward_country - 三级指标：企业获奖-国家级
     */
    public Double getFingerBrandRewardCountry() {
        return fingerBrandRewardCountry;
    }

    /**
     * 设置三级指标：企业获奖-国家级
     *
     * @param fingerBrandRewardCountry 三级指标：企业获奖-国家级
     */
    public void setFingerBrandRewardCountry(Double fingerBrandRewardCountry) {
        this.fingerBrandRewardCountry = fingerBrandRewardCountry;
    }

    /**
     * 获取二级指标：企业认定
     *
     * @return finger_brand_recognition - 二级指标：企业认定
     */
    public Double getFingerBrandRecognition() {
        return fingerBrandRecognition;
    }

    /**
     * 设置二级指标：企业认定
     *
     * @param fingerBrandRecognition 二级指标：企业认定
     */
    public void setFingerBrandRecognition(Double fingerBrandRecognition) {
        this.fingerBrandRecognition = fingerBrandRecognition;
    }

    /**
     * 获取三级指标：企业认定-区级
     *
     * @return finger_brand_recognition_area - 三级指标：企业认定-区级
     */
    public Double getFingerBrandRecognitionArea() {
        return fingerBrandRecognitionArea;
    }

    /**
     * 设置三级指标：企业认定-区级
     *
     * @param fingerBrandRecognitionArea 三级指标：企业认定-区级
     */
    public void setFingerBrandRecognitionArea(Double fingerBrandRecognitionArea) {
        this.fingerBrandRecognitionArea = fingerBrandRecognitionArea;
    }

    /**
     * 获取三级指标：企业认定-市级
     *
     * @return finger_brand_recognition_city - 三级指标：企业认定-市级
     */
    public Double getFingerBrandRecognitionCity() {
        return fingerBrandRecognitionCity;
    }

    /**
     * 设置三级指标：企业认定-市级
     *
     * @param fingerBrandRecognitionCity 三级指标：企业认定-市级
     */
    public void setFingerBrandRecognitionCity(Double fingerBrandRecognitionCity) {
        this.fingerBrandRecognitionCity = fingerBrandRecognitionCity;
    }

    /**
     * 获取三级指标：企业认定-省级
     *
     * @return finger_brand_recognition_province - 三级指标：企业认定-省级
     */
    public Double getFingerBrandRecognitionProvince() {
        return fingerBrandRecognitionProvince;
    }

    /**
     * 设置三级指标：企业认定-省级
     *
     * @param fingerBrandRecognitionProvince 三级指标：企业认定-省级
     */
    public void setFingerBrandRecognitionProvince(Double fingerBrandRecognitionProvince) {
        this.fingerBrandRecognitionProvince = fingerBrandRecognitionProvince;
    }

    /**
     * 获取三级指标：企业认定-国家级
     *
     * @return finger_brand_recognition_country - 三级指标：企业认定-国家级
     */
    public Double getFingerBrandRecognitionCountry() {
        return fingerBrandRecognitionCountry;
    }

    /**
     * 设置三级指标：企业认定-国家级
     *
     * @param fingerBrandRecognitionCountry 三级指标：企业认定-国家级
     */
    public void setFingerBrandRecognitionCountry(Double fingerBrandRecognitionCountry) {
        this.fingerBrandRecognitionCountry = fingerBrandRecognitionCountry;
    }

    /**
     * 获取二级指标：人才资助
     *
     * @return finger_brand_talent - 二级指标：人才资助
     */
    public Double getFingerBrandTalent() {
        return fingerBrandTalent;
    }

    /**
     * 设置二级指标：人才资助
     *
     * @param fingerBrandTalent 二级指标：人才资助
     */
    public void setFingerBrandTalent(Double fingerBrandTalent) {
        this.fingerBrandTalent = fingerBrandTalent;
    }

    /**
     * 获取三级指标：人才资助-区级
     *
     * @return finger_brand_talent_area - 三级指标：人才资助-区级
     */
    public Double getFingerBrandTalentArea() {
        return fingerBrandTalentArea;
    }

    /**
     * 设置三级指标：人才资助-区级
     *
     * @param fingerBrandTalentArea 三级指标：人才资助-区级
     */
    public void setFingerBrandTalentArea(Double fingerBrandTalentArea) {
        this.fingerBrandTalentArea = fingerBrandTalentArea;
    }

    /**
     * 获取三级指标：人才资助-市级
     *
     * @return finger_brand_talent_city - 三级指标：人才资助-市级
     */
    public Double getFingerBrandTalentCity() {
        return fingerBrandTalentCity;
    }

    /**
     * 设置三级指标：人才资助-市级
     *
     * @param fingerBrandTalentCity 三级指标：人才资助-市级
     */
    public void setFingerBrandTalentCity(Double fingerBrandTalentCity) {
        this.fingerBrandTalentCity = fingerBrandTalentCity;
    }

    /**
     * 获取三级指标：人才资助-省级
     *
     * @return finger_brand_talent_province - 三级指标：人才资助-省级
     */
    public Double getFingerBrandTalentProvince() {
        return fingerBrandTalentProvince;
    }

    /**
     * 设置三级指标：人才资助-省级
     *
     * @param fingerBrandTalentProvince 三级指标：人才资助-省级
     */
    public void setFingerBrandTalentProvince(Double fingerBrandTalentProvince) {
        this.fingerBrandTalentProvince = fingerBrandTalentProvince;
    }

    /**
     * 获取三级指标：人才资助-国家级
     *
     * @return finger_brand_talent_country - 三级指标：人才资助-国家级
     */
    public Double getFingerBrandTalentCountry() {
        return fingerBrandTalentCountry;
    }

    /**
     * 设置三级指标：人才资助-国家级
     *
     * @param fingerBrandTalentCountry 三级指标：人才资助-国家级
     */
    public void setFingerBrandTalentCountry(Double fingerBrandTalentCountry) {
        this.fingerBrandTalentCountry = fingerBrandTalentCountry;
    }
}