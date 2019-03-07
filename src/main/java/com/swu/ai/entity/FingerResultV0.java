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

    @Column(name = "finger_sale_weight")
    private Double fingerSaleWeight = 0.0;

    @Column(name = "finger_sale_invoice_weight")
    private Double fingerSaleInvoiceWeight = 0.0;

    @Column(name = "finger_sale_invoice_soft_weight")
    private Double fingerSaleInvoiceSoftWeight = 0.0;

    /**
     * 已开发票的收入-硬件产品
     */
    @Column(name = "finger_sale_invoice_hard_weight")
    private Double fingerSaleInvoiceHardWeight = 0.0;

    /**
     * 已开发票的收入-咨询服务
     */
    @Column(name = "finger_sale_invoice_consultation_weight")
    private Double fingerSaleInvoiceConsultationWeight = 0.0;

    /**
     * 已开发票的收入-其他
     */
    @Column(name = "finger_sale_invoice_other_weight")
    private Double fingerSaleInvoiceOtherWeight = 0.0;

    /**
     * 二级指标：合同确认额
     */
    @Column(name = "finger_sale_contract_weight")
    private Double fingerSaleContractWeight = 0.0;

    /**
     * 三级指标：合同确认额-软件产品
     */
    @Column(name = "finger_sale_contract_soft_weight")
    private Double fingerSaleContractSoftWeight = 0.0;

    /**
     * 三级指标：合同确认额-硬件产品
     */
    @Column(name = "finger_sale_contract_hard_weight")
    private Double fingerSaleContractHardWeight = 0.0;

    /**
     * 三级指标：合同确认额-咨询服务
     */
    @Column(name = "finger_sale_contract_consultation_weight")
    private Double fingerSaleContractConsultationWeight = 0.0;

    /**
     * 三级指标：合同确认额-其他
     */
    @Column(name = "finger_sale_contract_other_weight")
    private Double fingerSaleContractOtherWeight = 0.0;

    /**
     * 一级指标：纳税指数
     */
    @Column(name = "finger_tax_weight")
    private Double fingerTaxWeight = 0.0;

    /**
     * 二级指标：企业所得税
     */
    @Column(name = "finger_tax_corporate_weight")
    private Double fingerTaxCorporateWeight = 0.0;

    /**
     * 三级指标：企业所得税-应纳税值
     */
    @Column(name = "finger_tax_corporate_taxable_weight")
    private Double fingerTaxCorporateTaxableWeight = 0.0;

    /**
     * 三级指标：企业所得税-税收减免值
     */
    @Column(name = "finger_tax_corporate_relief_weight")
    private Double fingerTaxCorporateReliefWeight = 0.0;

    /**
     * 二级指标：个人所得税
     */
    @Column(name = "finger_tax_individual_weight")
    private Double fingerTaxIndividualWeight = 0.0;

    /**
     * 三级指标：个人所得税-应纳税值
     */
    @Column(name = "finger_tax_individual_taxable_weight")
    private Double fingerTaxIndividualTaxableWeight = 0.0;

    /**
     * 三级指标：个人所得税-税收减免
     */
    @Column(name = "finger_tax_individual_relief_weight")
    private Double fingerTaxIndividualReliefWeight = 0.0;

    /**
     * 二级指标：增值税
     */
    @Column(name = "finger_tax_added_weight")
    private Double fingerTaxAddedWeight = 0.0;

    /**
     * 三级指标：增值税-应纳税值
     */
    @Column(name = "finger_tax_added_taxable_weight")
    private Double fingerTaxAddedTaxableWeight = 0.0;

    /**
     * 三级指标：增值税-税收减免
     */
    @Column(name = "finger_tax_added_relief_weight")
    private Double fingerTaxAddedReliefWeight = 0.0;

    /**
     * 一级指标：融资指数
     */
    @Column(name = "finger_finance_weight")
    private Double fingerFinanceWeight = 0.0;

    /**
     * 二级指标：股权类融资
     */
    @Column(name = "finger_finance_stock_weight")
    private Double fingerFinanceStockWeight = 0.0;

    /**
     * 三级指标：股权类融资-风投机构
     */
    @Column(name = "finger_finance_stock_risk_weight")
    private Double fingerFinanceStockRiskWeight = 0.0;

    /**
     * 三级指标：股权类融资-政府企业
     */
    @Column(name = "finger_finance_stock_gov_weight")
    private Double fingerFinanceStockGovWeight = 0.0;

    /**
     * 三级指标：股权类融资-个人
     */
    @Column(name = "finger_finance_stock_person_weight")
    private Double fingerFinanceStockPersonWeight = 0.0;

    /**
     * 二级指标：债务类融资
     */
    @Column(name = "finger_finance_debt_weight")
    private Double fingerFinanceDebtWeight = 0.0;

    /**
     * 三级指标：债务类融资-银行
     */
    @Column(name = "finger_finance_debt_bank_weight")
    private Double fingerFinanceDebtBankWeight = 0.0;

    /**
     * 三级指标：债务类融资-新型贷款机构
     */
    @Column(name = "finger_finance_debt_new_weight")
    private Double fingerFinanceDebtNewWeight = 0.0;

    /**
     * 三级指标：债务类融资-企业拆借
     */
    @Column(name = "finger_finance_debt_lending_weight")
    private Double fingerFinanceDebtLendingWeight = 0.0;

    /**
     * 三级指标：债务类融资-个人
     */
    @Column(name = "finger_finance_debt_person_weight")
    private Double fingerFinanceDebtPersonWeight = 0.0;

    /**
     * 一级指标:估值指数
     */
    @Column(name = "finger_valuation_weight")
    private Double fingerValuationWeight = 0.0;

    /**
     * 二级指标：净资产
     */
    @Column(name = "finger_valuation_assets_weight")
    private Double fingerValuationAssetsWeight = 0.0;

    /**
     * 三级指标：净资产-流动资产
     */
    @Column(name = "finger_valuation_assets_circulating_weight")
    private Double fingerValuationAssetsCirculatingWeight = 0.0;

    /**
     * 三级指标：净资产-非流动资产
     */
    @Column(name = "finger_valuation_assets_uncirculating_weight")
    private Double fingerValuationAssetsUncirculatingWeight = 0.0;

    /**
     * 三级指标：净资产-流动负债
     */
    @Column(name = "finger_valuation_assets_debt_circulating_weight")
    private Double fingerValuationAssetsDebtCirculatingWeight = 0.0;

    /**
     * 三级指标：净资产-非流动负债
     */
    @Column(name = "finger_valuation_assets_debt_uncirculating_weight")
    private Double fingerValuationAssetsDebtUncirculatingWeight = 0.0;

    /**
     * 二级指标：实际估值
     */
    @Column(name = "finger_valuation_actual_weight")
    private Double fingerValuationActualWeight = 0.0;

    /**
     * 三级指标：实际估值-首次融资
     */
    @Column(name = "finger_valuation_actual_first_weight")
    private Double fingerValuationActualFirstWeight = 0.0;

    /**
     * 三级指标：实际估值-最近一次融资估值
     */
    @Column(name = "finger_valuation_actual_latest_weight")
    private Double fingerValuationActualLatestWeight = 0.0;

    /**
     * 三级指标：实际估值-现在准备融资估值
     */
    @Column(name = "finger_valuation_actual_want_weight")
    private Double fingerValuationActualWantWeight = 0.0;

    /**
     * 一级指标：人力资源指数
     */
    @Column(name = "finger_hr_weight")
    private Double fingerHrWeight = 0.0;

    /**
     * 二级指标：兼职员工数
     */
    @Column(name = "finger_hr_partime_weight")
    private Double fingerHrPartimeWeight = 0.0;

    /**
     * 三级指标：兼职员工-研发
     */
    @Column(name = "finger_hr_partime_dev_weight")
    private Double fingerHrPartimeDevWeight = 0.0;

    /**
     * 三级指标：兼职员工-管理
     */
    @Column(name = "finger_hr_partime_manage_weight")
    private Double fingerHrPartimeManageWeight = 0.0;

    /**
     * 三级指标：兼职员工-行政
     */
    @Column(name = "finger_hr_partime_admin_weight")
    private Double fingerHrPartimeAdminWeight = 0.0;

    /**
     * 三级指标：兼职员工-销售
     */
    @Column(name = "finger_hr_partime_saler_weight")
    private Double fingerHrPartimeSalerWeight = 0.0;

    /**
     * 二级指标：全职员工
     */
    @Column(name = "finger_hr_fulltime_weight")
    private Double fingerHrFulltimeWeight = 0.0;

    /**
     * 三级指标：全职员工-研发
     */
    @Column(name = "finger_hr_fulltime_dev_weight")
    private Double fingerHrFulltimeDevWeight = 0.0;

    /**
     * 三级指标：全职员工-高管
     */
    @Column(name = "finger_hr_fulltime_senior_weight")
    private Double fingerHrFulltimeSeniorWeight = 0.0;

    /**
     * 三级指标：全职员工-行政
     */
    @Column(name = "finger_hr_fulltime_admin_weight")
    private Double fingerHrFulltimeAdminWeight = 0.0;

    /**
     * 三级指标：全职员工-销售
     */
    @Column(name = "finger_hr_fulltime_saler_weight")
    private Double fingerHrFulltimeSalerWeight = 0.0;

    /**
     * 二级指标：高学历人员
     */
    @Column(name = "finger_hr_educated_weight")
    private Double fingerHrEducatedWeight = 0.0;

    /**
     * 三级指标：高学历人员-博士
     */
    @Column(name = "finger_hr_educated_doc_weight")
    private Double fingerHrEducatedDocWeight = 0.0;

    /**
     * 三级指标：高学历人员-硕士
     */
    @Column(name = "finger_hr_educated_master_weight")
    private Double fingerHrEducatedMasterWeight = 0.0;

    /**
     * 三级指标：高学历人员-学士
     */
    @Column(name = "finger_hr_bachelor_weight")
    private Double fingerHrBachelorWeight = 0.0;

    /**
     * 一级指标：创新指数
     */
    @Column(name = "finger_innovate_weight")
    private Double fingerInnovateWeight = 0.0;

    /**
     * 二级指标：专利申请
     */
    @Column(name = "finger_innovate_patent_apply_weight")
    private Double fingerInnovatePatentApplyWeight = 0.0;

    /**
     * 三级指标：专利申请-发明
     */
    @Column(name = "finger_innovate_patent_apply_invention_weight")
    private Double fingerInnovatePatentApplyInventionWeight = 0.0;

    /**
     * 三级指标：专利申请-实用新型
     */
    @Column(name = "finger_innovate_patent_apply_utility_weight")
    private Double fingerInnovatePatentApplyUtilityWeight = 0.0;

    /**
     * 三级指标：专利申请-外观设计
     */
    @Column(name = "finger_innovate_patent_apply_appear_weight")
    private Double fingerInnovatePatentApplyAppearWeight = 0.0;

    /**
     * 二级指标：专利授权
     */
    @Column(name = "finger_innovate_patent_grant_weight")
    private Double fingerInnovatePatentGrantWeight = 0.0;

    /**
     * 三级指标：专利授权-发明
     */
    @Column(name = "finger_innovate_patent_grant_invention_weight")
    private Double fingerInnovatePatentGrantInventionWeight = 0.0;

    /**
     * 三级指标：专利授权-实用新型
     */
    @Column(name = "finger_innovate_patent_grant_utility_weight")
    private Double fingerInnovatePatentGrantUtilityWeight = 0.0;

    /**
     * 三级指标：专利授权-外观设计
     */
    @Column(name = "finger_innovate_patent_grant_appear_weight")
    private Double fingerInnovatePatentGrantAppearWeight = 0.0;

    /**
     * 二级指标：著作权申请
     */
    @Column(name = "finger_innovate_copyright_apply_weight")
    private Double fingerInnovateCopyrightApplyWeight = 0.0;

    /**
     * 三级指标：著作权申请-软件类
     */
    @Column(name = "finger_innovate_copyright_apply_soft_weight")
    private Double fingerInnovateCopyrightApplySoftWeight = 0.0;

    /**
     * 三级指标：著作权申请-非软件类
     */
    @Column(name = "finger_innovate_copyright_apply_unsoft_weight")
    private Double fingerInnovateCopyrightApplyUnsoftWeight = 0.0;

    /**
     * 二级指标：著作权授权
     */
    @Column(name = "finger_innovate_copyright_grant_weight")
    private Double fingerInnovateCopyrightGrantWeight = 0.0;

    /**
     * 三级指标：著作权授权-软件类
     */
    @Column(name = "finger_innovate_copyright_grant_soft_weight")
    private Double fingerInnovateCopyrightGrantSoftWeight = 0.0;

    /**
     * 三级指标：著作权授权-非软件类
     */
    @Column(name = "finger_innovate_copyright_grant_unsoft_weight")
    private Double fingerInnovateCopyrightGrantUnsoftWeight = 0.0;

    /**
     * 二级指标：新产品/服务
     */
    @Column(name = "finger_innovate_new_product_weight")
    private Double fingerInnovateNewProductWeight = 0.0;

    /**
     * 三级指标：新产品/服务-专利类
     */
    @Column(name = "finger_innovate_new_product_patent_weight")
    private Double fingerInnovateNewProductPatentWeight = 0.0;

    /**
     * 三级指标：新产品/服务-专用技术
     */
    @Column(name = "finger_innovate_new_product_tech_weight")
    private Double fingerInnovateNewProductTechWeight = 0.0;

    /**
     * 三级指标：新产品/服务-商业模式
     */
    @Column(name = "finger_innovate_new_product_bus_weight")
    private Double fingerInnovateNewProductBusWeight = 0.0;

    /**
     * 一级指标：薪酬指数
     */
    @Column(name = "finger_salary_weight")
    private Double fingerSalaryWeight = 0.0;

    /**
     * 二级指标：员工工资额
     */
    @Column(name = "finger_salary_staff_weight")
    private Double fingerSalaryStaffWeight = 0.0;

    /**
     * 三级指标：员工工资额-1万元以上
     */
    @Column(name = "finger_salary_staff_up_10_weight")
    private Double fingerSalaryStaffUp10Weight = 0.0;

    /**
     * 三级指标：员工工资额-5千到1万
     */
    @Column(name = "finger_salary_staff_5_10_weight")
    private Double fingerSalaryStaff510Weight = 0.0;

    /**
     * 三级指标：员工工资额-5千以下
     */
    @Column(name = "finger_salary_staff_down_5_weight")
    private Double fingerSalaryStaffDown5Weight = 0.0;

    /**
     * 二级指标：员工贡献率
     */
    @Column(name = "finger_salary_staff_contribution_weight")
    private Double fingerSalaryStaffContributionWeight = 0.0;

    /**
     * 三级指标：员工贡献率-人均销售
     */
    @Column(name = "finger_salary_staff_contribution_meansale_weight")
    private Double fingerSalaryStaffContributionMeansaleWeight = 0.0;

    /**
     * 三级指标：员工贡献率-人均纳税
     */
    @Column(name = "finger_salary_staff_contribution_meantax_weight")
    private Double fingerSalaryStaffContributionMeantaxWeight = 0.0;

    /**
     * 一级指标：学习指数
     */
    @Column(name = "finger_learn_weight")
    private Double fingerLearnWeight = 0.0;

    /**
     * 二级指标：参加培训的次数
     */
    @Column(name = "finger_learn_train_weight")
    private Double fingerLearnTrainWeight = 0.0;

    /**
     * 三级指标：参加培训的次数-管理类
     */
    @Column(name = "finger_learn_train_manage_weight")
    private Double fingerLearnTrainManageWeight = 0.0;

    /**
     * 三级指标：参加培训的次数-政策法规
     */
    @Column(name = "finger_learn_train_policy_weight")
    private Double fingerLearnTrainPolicyWeight = 0.0;

    /**
     * 三级指标：参加培训的次数-技能类
     */
    @Column(name = "finger_learn_train_skill_weight")
    private Double fingerLearnTrainSkillWeight = 0.0;

    /**
     * 二级指标：接受咨询的次数
     */
    @Column(name = "finger_learn_conslted_weight")
    private Double fingerLearnConsltedWeight = 0.0;

    /**
     * 三级指标：接受咨询的次数-管理类
     */
    @Column(name = "finger_learn_conslted_manage_weight")
    private Double fingerLearnConsltedManageWeight = 0.0;

    /**
     * 三级指标：接受咨询的次数-政策法规
     */
    @Column(name = "finger_learn_conslted_policy_weight")
    private Double fingerLearnConsltedPolicyWeight = 0.0;

    /**
     * 三级指标：接受咨询的次数-技能类
     */
    @Column(name = "finger_learn_conslted_skill_weight")
    private Double fingerLearnConsltedSkillWeight = 0.0;

    /**
     * 一级指标：品牌指数
     */
    @Column(name = "finger_brand_weight")
    private Double fingerBrandWeight = 0.0;

    /**
     * 二级指标：企业获奖
     */
    @Column(name = "finger_brand_reward_weight")
    private Double fingerBrandRewardWeight = 0.0;

    /**
     * 三级指标：企业获奖-区级
     */
    @Column(name = "finger_brand_reward_area_weight")
    private Double fingerBrandRewardAreaWeight = 0.0;

    /**
     * 三级指标：企业获奖-市级
     */
    @Column(name = "finger_brand_reward_city_weight")
    private Double fingerBrandRewardCityWeight = 0.0;

    /**
     * 三级指标：企业获奖-省级
     */
    @Column(name = "finger_brand_reward_province_weight")
    private Double fingerBrandRewardProvinceWeight = 0.0;

    /**
     * 三级指标：企业获奖-国家级
     */
    @Column(name = "finger_brand_reward_country_weight")
    private Double fingerBrandRewardCountryWeight = 0.0;

    /**
     * 二级指标：企业认定
     */
    @Column(name = "finger_brand_recognition_weight")
    private Double fingerBrandRecognitionWeight = 0.0;

    /**
     * 三级指标：企业认定-区级
     */
    @Column(name = "finger_brand_recognition_area_weight")
    private Double fingerBrandRecognitionAreaWeight = 0.0;

    /**
     * 三级指标：企业认定-市级
     */
    @Column(name = "finger_brand_recognition_city_weight")
    private Double fingerBrandRecognitionCityWeight = 0.0;

    /**
     * 三级指标：企业认定-省级
     */
    @Column(name = "finger_brand_recognition_province_weight")
    private Double fingerBrandRecognitionProvinceWeight = 0.0;

    /**
     * 三级指标：企业认定-国家级
     */
    @Column(name = "finger_brand_recognition_country_weight")
    private Double fingerBrandRecognitionCountryWeight = 0.0;

    /**
     * 二级指标：人才资助
     */
    @Column(name = "finger_brand_talent_weight")
    private Double fingerBrandTalentWeight = 0.0;

    /**
     * 三级指标：人才资助-区级
     */
    @Column(name = "finger_brand_talent_area_weight")
    private Double fingerBrandTalentAreaWeight = 0.0;

    /**
     * 三级指标：人才资助-市级
     */
    @Column(name = "finger_brand_talent_city_weight")
    private Double fingerBrandTalentCityWeight = 0.0;

    /**
     * 三级指标：人才资助-省级
     */
    @Column(name = "finger_brand_talent_province_weight")
    private Double fingerBrandTalentProvinceWeight = 0.0;

    /**
     * 三级指标：人才资助-国家级
     */
    @Column(name = "finger_brand_talent_country_weight")
    private Double fingerBrandTalentCountryWeight = 0.0;

    /**
     * 初始化三级指标后，计算所有指标
     */
    public void evaluate() {
        this.fingerSaleInvoice = this.fingerSaleInvoiceSoft * this.fingerSaleInvoiceSoftWeight + this.fingerSaleInvoiceHard *  this.fingerSaleInvoiceHardWeight + this.fingerSaleInvoiceConsultation * this.fingerSaleInvoiceConsultationWeight + this.fingerSaleInvoiceSoft * this.fingerSaleInvoiceSoftWeight;
        this.fingerSaleContract = this.fingerSaleContractSoft * this.fingerSaleContractSoftWeight + this.fingerSaleContractHard * this.fingerSaleContractHardWeight + this.fingerSaleContractConsultation * this.fingerSaleContractConsultationWeight + this.fingerSaleContractOther * this.fingerSaleContractOtherWeight;
        this.fingerSale = this.fingerSaleInvoice * this.fingerSaleInvoiceWeight + this.fingerSaleContract * this.fingerSaleContractWeight;

        this.fingerTaxCorporate = this.fingerTaxCorporateTaxable * this.fingerTaxCorporateTaxableWeight + this.fingerTaxCorporateRelief * this.fingerTaxCorporateReliefWeight;
        this.fingerTaxIndividual = this.fingerTaxIndividualRelief * this.fingerTaxIndividualReliefWeight + this.fingerTaxIndividualRelief * this.fingerTaxIndividualReliefWeight;
        this.fingerTaxAdded = this.fingerTaxAddedTaxable * this.fingerTaxAddedTaxableWeight + this.fingerTaxAddedRelief * this.fingerTaxAddedReliefWeight;
        this.fingerTax = this.fingerTaxCorporate * this.fingerTaxCorporateWeight + this.fingerTaxIndividual * this.fingerTaxIndividualWeight  + this.fingerTaxAdded * this.fingerTaxAddedWeight;

        this.fingerFinanceStock = this.fingerFinanceStockRisk * this.fingerFinanceStockRiskWeight + this.fingerFinanceStockGov * this.fingerFinanceStockGovWeight + this.fingerFinanceStockPerson * this.fingerFinanceStockPersonWeight;
        this.fingerFinanceDebt = this.fingerFinanceDebtBank * this.fingerFinanceDebtBankWeight + this.fingerFinanceDebtLending * this.fingerFinanceDebtLendingWeight + this.fingerFinanceDebtNew * this.fingerFinanceDebtNewWeight + this.fingerFinanceDebtPerson * this.fingerFinanceDebtPersonWeight;
        this.fingerFinance = this.fingerFinanceStock * this.fingerFinanceStockWeight + this.fingerFinanceDebt * this.fingerFinanceDebtWeight;

        this.fingerValuationAssets = this.fingerValuationAssetsCirculating * this.fingerValuationAssetsCirculatingWeight + this.fingerValuationAssetsUncirculating * this.fingerValuationAssetsUncirculatingWeight + this.fingerValuationAssetsDebtCirculating * this.fingerValuationAssetsDebtCirculatingWeight + this.fingerValuationAssetsDebtUncirculating * this.fingerValuationAssetsDebtUncirculatingWeight;
        this.fingerValuationActual = this.fingerValuationActualFirst * this.fingerValuationActualFirstWeight + this.fingerValuationActualLatest * this.fingerValuationActualLatestWeight + this.fingerValuationActualWant * this.fingerValuationActualWantWeight;
        this.fingerValuation = this.fingerValuationAssets * this.fingerValuationAssetsWeight + this.fingerValuationActual * this.fingerValuationActualWantWeight;

        this.fingerHrPartime = this.fingerHrPartimeDev * this.fingerHrPartimeDevWeight + this.fingerHrPartimeManage * this.fingerHrPartimeManageWeight + this.fingerHrPartimeAdmin * this.fingerHrPartimeAdminWeight + this.fingerHrPartimeSaler * this.fingerHrPartimeSalerWeight;
        this.fingerHrFulltime = this.fingerHrFulltimeDev * this.fingerHrFulltimeDevWeight + this.fingerHrFulltimeSenior * this.fingerHrFulltimeSeniorWeight + this.fingerHrFulltimeAdmin * this.fingerHrFulltimeAdminWeight + this.fingerHrFulltimeSaler * this.fingerHrFulltimeSalerWeight;
        this.fingerHrEducated = this.fingerHrEducatedDoc * this.fingerHrEducatedDocWeight + this.fingerHrEducatedMaster * this.fingerHrEducatedMasterWeight + this.fingerHrBachelor * this.fingerHrBachelor;
        this.fingerHr = this.fingerHrPartime * this.fingerHrPartimeWeight + this.fingerHrFulltime * this.fingerHrFulltimeWeight + this.fingerHrEducated * this.fingerHrEducatedWeight;

        this.fingerInnovatePatentApply = this.fingerInnovatePatentApplyInvention * this.fingerInnovatePatentApplyInventionWeight + this.fingerInnovatePatentApplyUtility * this.fingerInnovatePatentApplyUtilityWeight + this.fingerInnovatePatentApplyAppear * this.fingerInnovatePatentApplyAppearWeight;
        this.fingerInnovatePatentGrant = this.fingerInnovatePatentGrantInvention * this.fingerInnovatePatentGrantInventionWeight + this.fingerInnovatePatentGrantUtility * this.fingerInnovatePatentGrantUtilityWeight + this.fingerInnovatePatentGrantAppear * this.fingerInnovatePatentGrantAppearWeight;
        this.fingerInnovateCopyrightApply = this.fingerInnovateCopyrightApplySoft * this.fingerInnovateCopyrightApplySoftWeight + this.fingerInnovateCopyrightApplyUnsoft * this.fingerInnovateCopyrightApplyUnsoftWeight;
        this.fingerInnovateCopyrightGrant = this.fingerInnovateCopyrightGrantSoft * this.fingerInnovateCopyrightGrantSoftWeight + this.fingerInnovateCopyrightGrantUnsoft * this.fingerInnovateCopyrightGrantUnsoftWeight;
        this.fingerInnovateNewProduct = this.fingerInnovateNewProductPatent * this.fingerInnovateNewProductPatentWeight + this.fingerInnovateNewProductTech * this.fingerInnovateNewProductTechWeight + this.fingerInnovateNewProductBus * this.fingerInnovateNewProductBusWeight;
        this.fingerInnovate = this.fingerInnovatePatentApply * this.fingerInnovatePatentApplyWeight + this.fingerInnovatePatentGrant * this.fingerInnovatePatentGrantWeight + this.fingerInnovateCopyrightApply * this.fingerInnovateCopyrightApplyWeight + this.fingerInnovateCopyrightGrant * this.fingerInnovateCopyrightGrantWeight + this.fingerInnovateNewProduct * this.fingerInnovateNewProductWeight;

        this.fingerSalaryStaff = this.fingerSalaryStaffUp10 * this.fingerSalaryStaffUp10Weight + this.fingerSalaryStaff510 * this.fingerSalaryStaff510Weight + this.fingerSalaryStaffDown5 * this.fingerSalaryStaffDown5;
        this.fingerSalaryStaffContribution = this.fingerSalaryStaffContributionMeansale * this.fingerSalaryStaffContributionMeansaleWeight + this.fingerSalaryStaffContributionMeantax * this.fingerSalaryStaffContributionMeantaxWeight;
        this.fingerSalary = this.fingerSalaryStaff * this.fingerSalaryStaffWeight + this.fingerSalaryStaffContribution * this.fingerSalaryStaffContributionWeight;

        this.fingerLearnTrain = this.fingerLearnTrainManage * this.fingerLearnTrainManageWeight + this.fingerLearnTrainPolicy * this.fingerLearnTrainPolicyWeight + this.fingerLearnTrainSkill * this.fingerLearnTrainSkillWeight;
        this.fingerLearnConslted = this.fingerLearnConsltedManage * this.fingerLearnConsltedManageWeight + this.fingerLearnTrainPolicy * this.fingerLearnTrainPolicyWeight + this.fingerLearnTrainSkill * this.fingerLearnTrainSkillWeight;
        this.fingerLearn = this.fingerLearnTrain * this.fingerLearnTrainWeight + this.fingerLearnConslted * this.fingerLearnConsltedWeight;

        this.fingerBrandReward = this.fingerBrandRewardArea * this.fingerBrandRewardAreaWeight + this.fingerBrandRewardCity * this.fingerBrandRewardCityWeight + this.fingerBrandRewardProvince * this.fingerBrandRewardProvinceWeight + this.fingerBrandRewardCountry * this.fingerBrandRewardCountryWeight;
        this.fingerBrandRecognition = this.fingerBrandRecognitionArea * this.fingerBrandRecognitionAreaWeight + this.fingerBrandRecognitionCity * this.fingerBrandRecognitionCityWeight + this.fingerBrandRecognitionProvince * this.fingerBrandRecognitionProvinceWeight + this.fingerBrandRecognitionCountry * this.fingerBrandRecognitionCountryWeight;
        this.fingerBrandTalent = this.fingerBrandTalentArea * this.fingerBrandTalentAreaWeight + this.fingerBrandTalentCity * this.fingerBrandTalentCityWeight + this.fingerBrandTalentProvince * this.fingerBrandTalentProvinceWeight + this.fingerBrandTalentCountry * this.fingerBrandTalentCountryWeight;
        this.fingerBrand = this.fingerBrandReward * this.fingerBrandRewardWeight + this.fingerBrandRecognition * this.fingerBrandRecognitionWeight + this.fingerBrandTalent * this.fingerBrandTalentWeight;

        this.fingerAll = this.fingerSale * this.fingerSaleWeight + this.fingerTax * this.fingerTaxWeight + this.fingerFinance * this.fingerFinanceWeight + this.fingerValuation * this.fingerValuationWeight + this.fingerHr * this.fingerHrWeight + this.fingerInnovate * this.fingerInnovateWeight + this.fingerSalary * this.fingerSalaryWeight + this.fingerLearn * this.fingerLearnWeight + this.fingerBrand * this.fingerBrandWeight;
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

    public Double getFingerSaleWeight() {
        return fingerSaleWeight;
    }

    public void setFingerSaleWeight(Double fingerSaleWeight) {
        this.fingerSaleWeight = fingerSaleWeight;
    }

    public Double getFingerSaleInvoiceWeight() {
        return fingerSaleInvoiceWeight;
    }

    public void setFingerSaleInvoiceWeight(Double fingerSaleInvoiceWeight) {
        this.fingerSaleInvoiceWeight = fingerSaleInvoiceWeight;
    }

    public Double getFingerSaleInvoiceSoftWeight() {
        return fingerSaleInvoiceSoftWeight;
    }

    public void setFingerSaleInvoiceSoftWeight(Double fingerSaleInvoiceSoftWeight) {
        this.fingerSaleInvoiceSoftWeight = fingerSaleInvoiceSoftWeight;
    }

    public Double getFingerSaleInvoiceHardWeight() {
        return fingerSaleInvoiceHardWeight;
    }

    public void setFingerSaleInvoiceHardWeight(Double fingerSaleInvoiceHardWeight) {
        this.fingerSaleInvoiceHardWeight = fingerSaleInvoiceHardWeight;
    }

    public Double getFingerSaleInvoiceConsultationWeight() {
        return fingerSaleInvoiceConsultationWeight;
    }

    public void setFingerSaleInvoiceConsultationWeight(Double fingerSaleInvoiceConsultationWeight) {
        this.fingerSaleInvoiceConsultationWeight = fingerSaleInvoiceConsultationWeight;
    }

    public Double getFingerSaleInvoiceOtherWeight() {
        return fingerSaleInvoiceOtherWeight;
    }

    public void setFingerSaleInvoiceOtherWeight(Double fingerSaleInvoiceOtherWeight) {
        this.fingerSaleInvoiceOtherWeight = fingerSaleInvoiceOtherWeight;
    }

    public Double getFingerSaleContractWeight() {
        return fingerSaleContractWeight;
    }

    public void setFingerSaleContractWeight(Double fingerSaleContractWeight) {
        this.fingerSaleContractWeight = fingerSaleContractWeight;
    }

    public Double getFingerSaleContractSoftWeight() {
        return fingerSaleContractSoftWeight;
    }

    public void setFingerSaleContractSoftWeight(Double fingerSaleContractSoftWeight) {
        this.fingerSaleContractSoftWeight = fingerSaleContractSoftWeight;
    }

    public Double getFingerSaleContractHardWeight() {
        return fingerSaleContractHardWeight;
    }

    public void setFingerSaleContractHardWeight(Double fingerSaleContractHardWeight) {
        this.fingerSaleContractHardWeight = fingerSaleContractHardWeight;
    }

    public Double getFingerSaleContractConsultationWeight() {
        return fingerSaleContractConsultationWeight;
    }

    public void setFingerSaleContractConsultationWeight(Double fingerSaleContractConsultationWeight) {
        this.fingerSaleContractConsultationWeight = fingerSaleContractConsultationWeight;
    }

    public Double getFingerSaleContractOtherWeight() {
        return fingerSaleContractOtherWeight;
    }

    public void setFingerSaleContractOtherWeight(Double fingerSaleContractOtherWeight) {
        this.fingerSaleContractOtherWeight = fingerSaleContractOtherWeight;
    }

    public Double getFingerTaxWeight() {
        return fingerTaxWeight;
    }

    public void setFingerTaxWeight(Double fingerTaxWeight) {
        this.fingerTaxWeight = fingerTaxWeight;
    }

    public Double getFingerTaxCorporateWeight() {
        return fingerTaxCorporateWeight;
    }

    public void setFingerTaxCorporateWeight(Double fingerTaxCorporateWeight) {
        this.fingerTaxCorporateWeight = fingerTaxCorporateWeight;
    }

    public Double getFingerTaxCorporateTaxableWeight() {
        return fingerTaxCorporateTaxableWeight;
    }

    public void setFingerTaxCorporateTaxableWeight(Double fingerTaxCorporateTaxableWeight) {
        this.fingerTaxCorporateTaxableWeight = fingerTaxCorporateTaxableWeight;
    }

    public Double getFingerTaxCorporateReliefWeight() {
        return fingerTaxCorporateReliefWeight;
    }

    public void setFingerTaxCorporateReliefWeight(Double fingerTaxCorporateReliefWeight) {
        this.fingerTaxCorporateReliefWeight = fingerTaxCorporateReliefWeight;
    }

    public Double getFingerTaxIndividualWeight() {
        return fingerTaxIndividualWeight;
    }

    public void setFingerTaxIndividualWeight(Double fingerTaxIndividualWeight) {
        this.fingerTaxIndividualWeight = fingerTaxIndividualWeight;
    }

    public Double getFingerTaxIndividualTaxableWeight() {
        return fingerTaxIndividualTaxableWeight;
    }

    public void setFingerTaxIndividualTaxableWeight(Double fingerTaxIndividualTaxableWeight) {
        this.fingerTaxIndividualTaxableWeight = fingerTaxIndividualTaxableWeight;
    }

    public Double getFingerTaxIndividualReliefWeight() {
        return fingerTaxIndividualReliefWeight;
    }

    public void setFingerTaxIndividualReliefWeight(Double fingerTaxIndividualReliefWeight) {
        this.fingerTaxIndividualReliefWeight = fingerTaxIndividualReliefWeight;
    }

    public Double getFingerTaxAddedWeight() {
        return fingerTaxAddedWeight;
    }

    public void setFingerTaxAddedWeight(Double fingerTaxAddedWeight) {
        this.fingerTaxAddedWeight = fingerTaxAddedWeight;
    }

    public Double getFingerTaxAddedTaxableWeight() {
        return fingerTaxAddedTaxableWeight;
    }

    public void setFingerTaxAddedTaxableWeight(Double fingerTaxAddedTaxableWeight) {
        this.fingerTaxAddedTaxableWeight = fingerTaxAddedTaxableWeight;
    }

    public Double getFingerTaxAddedReliefWeight() {
        return fingerTaxAddedReliefWeight;
    }

    public void setFingerTaxAddedReliefWeight(Double fingerTaxAddedReliefWeight) {
        this.fingerTaxAddedReliefWeight = fingerTaxAddedReliefWeight;
    }

    public Double getFingerFinanceWeight() {
        return fingerFinanceWeight;
    }

    public void setFingerFinanceWeight(Double fingerFinanceWeight) {
        this.fingerFinanceWeight = fingerFinanceWeight;
    }

    public Double getFingerFinanceStockWeight() {
        return fingerFinanceStockWeight;
    }

    public void setFingerFinanceStockWeight(Double fingerFinanceStockWeight) {
        this.fingerFinanceStockWeight = fingerFinanceStockWeight;
    }

    public Double getFingerFinanceStockRiskWeight() {
        return fingerFinanceStockRiskWeight;
    }

    public void setFingerFinanceStockRiskWeight(Double fingerFinanceStockRiskWeight) {
        this.fingerFinanceStockRiskWeight = fingerFinanceStockRiskWeight;
    }

    public Double getFingerFinanceStockGovWeight() {
        return fingerFinanceStockGovWeight;
    }

    public void setFingerFinanceStockGovWeight(Double fingerFinanceStockGovWeight) {
        this.fingerFinanceStockGovWeight = fingerFinanceStockGovWeight;
    }

    public Double getFingerFinanceStockPersonWeight() {
        return fingerFinanceStockPersonWeight;
    }

    public void setFingerFinanceStockPersonWeight(Double fingerFinanceStockPersonWeight) {
        this.fingerFinanceStockPersonWeight = fingerFinanceStockPersonWeight;
    }

    public Double getFingerFinanceDebtWeight() {
        return fingerFinanceDebtWeight;
    }

    public void setFingerFinanceDebtWeight(Double fingerFinanceDebtWeight) {
        this.fingerFinanceDebtWeight = fingerFinanceDebtWeight;
    }

    public Double getFingerFinanceDebtBankWeight() {
        return fingerFinanceDebtBankWeight;
    }

    public void setFingerFinanceDebtBankWeight(Double fingerFinanceDebtBankWeight) {
        this.fingerFinanceDebtBankWeight = fingerFinanceDebtBankWeight;
    }

    public Double getFingerFinanceDebtNewWeight() {
        return fingerFinanceDebtNewWeight;
    }

    public void setFingerFinanceDebtNewWeight(Double fingerFinanceDebtNewWeight) {
        this.fingerFinanceDebtNewWeight = fingerFinanceDebtNewWeight;
    }

    public Double getFingerFinanceDebtLendingWeight() {
        return fingerFinanceDebtLendingWeight;
    }

    public void setFingerFinanceDebtLendingWeight(Double fingerFinanceDebtLendingWeight) {
        this.fingerFinanceDebtLendingWeight = fingerFinanceDebtLendingWeight;
    }

    public Double getFingerFinanceDebtPersonWeight() {
        return fingerFinanceDebtPersonWeight;
    }

    public void setFingerFinanceDebtPersonWeight(Double fingerFinanceDebtPersonWeight) {
        this.fingerFinanceDebtPersonWeight = fingerFinanceDebtPersonWeight;
    }

    public Double getFingerValuationWeight() {
        return fingerValuationWeight;
    }

    public void setFingerValuationWeight(Double fingerValuationWeight) {
        this.fingerValuationWeight = fingerValuationWeight;
    }

    public Double getFingerValuationAssetsWeight() {
        return fingerValuationAssetsWeight;
    }

    public void setFingerValuationAssetsWeight(Double fingerValuationAssetsWeight) {
        this.fingerValuationAssetsWeight = fingerValuationAssetsWeight;
    }

    public Double getFingerValuationAssetsCirculatingWeight() {
        return fingerValuationAssetsCirculatingWeight;
    }

    public void setFingerValuationAssetsCirculatingWeight(Double fingerValuationAssetsCirculatingWeight) {
        this.fingerValuationAssetsCirculatingWeight = fingerValuationAssetsCirculatingWeight;
    }

    public Double getFingerValuationAssetsUncirculatingWeight() {
        return fingerValuationAssetsUncirculatingWeight;
    }

    public void setFingerValuationAssetsUncirculatingWeight(Double fingerValuationAssetsUncirculatingWeight) {
        this.fingerValuationAssetsUncirculatingWeight = fingerValuationAssetsUncirculatingWeight;
    }

    public Double getFingerValuationAssetsDebtCirculatingWeight() {
        return fingerValuationAssetsDebtCirculatingWeight;
    }

    public void setFingerValuationAssetsDebtCirculatingWeight(Double fingerValuationAssetsDebtCirculatingWeight) {
        this.fingerValuationAssetsDebtCirculatingWeight = fingerValuationAssetsDebtCirculatingWeight;
    }

    public Double getFingerValuationAssetsDebtUncirculatingWeight() {
        return fingerValuationAssetsDebtUncirculatingWeight;
    }

    public void setFingerValuationAssetsDebtUncirculatingWeight(Double fingerValuationAssetsDebtUncirculatingWeight) {
        this.fingerValuationAssetsDebtUncirculatingWeight = fingerValuationAssetsDebtUncirculatingWeight;
    }

    public Double getFingerValuationActualWeight() {
        return fingerValuationActualWeight;
    }

    public void setFingerValuationActualWeight(Double fingerValuationActualWeight) {
        this.fingerValuationActualWeight = fingerValuationActualWeight;
    }

    public Double getFingerValuationActualFirstWeight() {
        return fingerValuationActualFirstWeight;
    }

    public void setFingerValuationActualFirstWeight(Double fingerValuationActualFirstWeight) {
        this.fingerValuationActualFirstWeight = fingerValuationActualFirstWeight;
    }

    public Double getFingerValuationActualLatestWeight() {
        return fingerValuationActualLatestWeight;
    }

    public void setFingerValuationActualLatestWeight(Double fingerValuationActualLatestWeight) {
        this.fingerValuationActualLatestWeight = fingerValuationActualLatestWeight;
    }

    public Double getFingerValuationActualWantWeight() {
        return fingerValuationActualWantWeight;
    }

    public void setFingerValuationActualWantWeight(Double fingerValuationActualWantWeight) {
        this.fingerValuationActualWantWeight = fingerValuationActualWantWeight;
    }

    public Double getFingerHrWeight() {
        return fingerHrWeight;
    }

    public void setFingerHrWeight(Double fingerHrWeight) {
        this.fingerHrWeight = fingerHrWeight;
    }

    public Double getFingerHrPartimeWeight() {
        return fingerHrPartimeWeight;
    }

    public void setFingerHrPartimeWeight(Double fingerHrPartimeWeight) {
        this.fingerHrPartimeWeight = fingerHrPartimeWeight;
    }

    public Double getFingerHrPartimeDevWeight() {
        return fingerHrPartimeDevWeight;
    }

    public void setFingerHrPartimeDevWeight(Double fingerHrPartimeDevWeight) {
        this.fingerHrPartimeDevWeight = fingerHrPartimeDevWeight;
    }

    public Double getFingerHrPartimeManageWeight() {
        return fingerHrPartimeManageWeight;
    }

    public void setFingerHrPartimeManageWeight(Double fingerHrPartimeManageWeight) {
        this.fingerHrPartimeManageWeight = fingerHrPartimeManageWeight;
    }

    public Double getFingerHrPartimeAdminWeight() {
        return fingerHrPartimeAdminWeight;
    }

    public void setFingerHrPartimeAdminWeight(Double fingerHrPartimeAdminWeight) {
        this.fingerHrPartimeAdminWeight = fingerHrPartimeAdminWeight;
    }

    public Double getFingerHrPartimeSalerWeight() {
        return fingerHrPartimeSalerWeight;
    }

    public void setFingerHrPartimeSalerWeight(Double fingerHrPartimeSalerWeight) {
        this.fingerHrPartimeSalerWeight = fingerHrPartimeSalerWeight;
    }

    public Double getFingerHrFulltimeWeight() {
        return fingerHrFulltimeWeight;
    }

    public void setFingerHrFulltimeWeight(Double fingerHrFulltimeWeight) {
        this.fingerHrFulltimeWeight = fingerHrFulltimeWeight;
    }

    public Double getFingerHrFulltimeDevWeight() {
        return fingerHrFulltimeDevWeight;
    }

    public void setFingerHrFulltimeDevWeight(Double fingerHrFulltimeDevWeight) {
        this.fingerHrFulltimeDevWeight = fingerHrFulltimeDevWeight;
    }

    public Double getFingerHrFulltimeSeniorWeight() {
        return fingerHrFulltimeSeniorWeight;
    }

    public void setFingerHrFulltimeSeniorWeight(Double fingerHrFulltimeSeniorWeight) {
        this.fingerHrFulltimeSeniorWeight = fingerHrFulltimeSeniorWeight;
    }

    public Double getFingerHrFulltimeAdminWeight() {
        return fingerHrFulltimeAdminWeight;
    }

    public void setFingerHrFulltimeAdminWeight(Double fingerHrFulltimeAdminWeight) {
        this.fingerHrFulltimeAdminWeight = fingerHrFulltimeAdminWeight;
    }

    public Double getFingerHrFulltimeSalerWeight() {
        return fingerHrFulltimeSalerWeight;
    }

    public void setFingerHrFulltimeSalerWeight(Double fingerHrFulltimeSalerWeight) {
        this.fingerHrFulltimeSalerWeight = fingerHrFulltimeSalerWeight;
    }

    public Double getFingerHrEducatedWeight() {
        return fingerHrEducatedWeight;
    }

    public void setFingerHrEducatedWeight(Double fingerHrEducatedWeight) {
        this.fingerHrEducatedWeight = fingerHrEducatedWeight;
    }

    public Double getFingerHrEducatedDocWeight() {
        return fingerHrEducatedDocWeight;
    }

    public void setFingerHrEducatedDocWeight(Double fingerHrEducatedDocWeight) {
        this.fingerHrEducatedDocWeight = fingerHrEducatedDocWeight;
    }

    public Double getFingerHrEducatedMasterWeight() {
        return fingerHrEducatedMasterWeight;
    }

    public void setFingerHrEducatedMasterWeight(Double fingerHrEducatedMasterWeight) {
        this.fingerHrEducatedMasterWeight = fingerHrEducatedMasterWeight;
    }

    public Double getFingerHrBachelorWeight() {
        return fingerHrBachelorWeight;
    }

    public void setFingerHrBachelorWeight(Double fingerHrBachelorWeight) {
        this.fingerHrBachelorWeight = fingerHrBachelorWeight;
    }

    public Double getFingerInnovateWeight() {
        return fingerInnovateWeight;
    }

    public void setFingerInnovateWeight(Double fingerInnovateWeight) {
        this.fingerInnovateWeight = fingerInnovateWeight;
    }

    public Double getFingerInnovatePatentApplyWeight() {
        return fingerInnovatePatentApplyWeight;
    }

    public void setFingerInnovatePatentApplyWeight(Double fingerInnovatePatentApplyWeight) {
        this.fingerInnovatePatentApplyWeight = fingerInnovatePatentApplyWeight;
    }

    public Double getFingerInnovatePatentApplyInventionWeight() {
        return fingerInnovatePatentApplyInventionWeight;
    }

    public void setFingerInnovatePatentApplyInventionWeight(Double fingerInnovatePatentApplyInventionWeight) {
        this.fingerInnovatePatentApplyInventionWeight = fingerInnovatePatentApplyInventionWeight;
    }

    public Double getFingerInnovatePatentApplyUtilityWeight() {
        return fingerInnovatePatentApplyUtilityWeight;
    }

    public void setFingerInnovatePatentApplyUtilityWeight(Double fingerInnovatePatentApplyUtilityWeight) {
        this.fingerInnovatePatentApplyUtilityWeight = fingerInnovatePatentApplyUtilityWeight;
    }

    public Double getFingerInnovatePatentApplyAppearWeight() {
        return fingerInnovatePatentApplyAppearWeight;
    }

    public void setFingerInnovatePatentApplyAppearWeight(Double fingerInnovatePatentApplyAppearWeight) {
        this.fingerInnovatePatentApplyAppearWeight = fingerInnovatePatentApplyAppearWeight;
    }

    public Double getFingerInnovatePatentGrantWeight() {
        return fingerInnovatePatentGrantWeight;
    }

    public void setFingerInnovatePatentGrantWeight(Double fingerInnovatePatentGrantWeight) {
        this.fingerInnovatePatentGrantWeight = fingerInnovatePatentGrantWeight;
    }

    public Double getFingerInnovatePatentGrantInventionWeight() {
        return fingerInnovatePatentGrantInventionWeight;
    }

    public void setFingerInnovatePatentGrantInventionWeight(Double fingerInnovatePatentGrantInventionWeight) {
        this.fingerInnovatePatentGrantInventionWeight = fingerInnovatePatentGrantInventionWeight;
    }

    public Double getFingerInnovatePatentGrantUtilityWeight() {
        return fingerInnovatePatentGrantUtilityWeight;
    }

    public void setFingerInnovatePatentGrantUtilityWeight(Double fingerInnovatePatentGrantUtilityWeight) {
        this.fingerInnovatePatentGrantUtilityWeight = fingerInnovatePatentGrantUtilityWeight;
    }

    public Double getFingerInnovatePatentGrantAppearWeight() {
        return fingerInnovatePatentGrantAppearWeight;
    }

    public void setFingerInnovatePatentGrantAppearWeight(Double fingerInnovatePatentGrantAppearWeight) {
        this.fingerInnovatePatentGrantAppearWeight = fingerInnovatePatentGrantAppearWeight;
    }

    public Double getFingerInnovateCopyrightApplyWeight() {
        return fingerInnovateCopyrightApplyWeight;
    }

    public void setFingerInnovateCopyrightApplyWeight(Double fingerInnovateCopyrightApplyWeight) {
        this.fingerInnovateCopyrightApplyWeight = fingerInnovateCopyrightApplyWeight;
    }

    public Double getFingerInnovateCopyrightApplySoftWeight() {
        return fingerInnovateCopyrightApplySoftWeight;
    }

    public void setFingerInnovateCopyrightApplySoftWeight(Double fingerInnovateCopyrightApplySoftWeight) {
        this.fingerInnovateCopyrightApplySoftWeight = fingerInnovateCopyrightApplySoftWeight;
    }

    public Double getFingerInnovateCopyrightApplyUnsoftWeight() {
        return fingerInnovateCopyrightApplyUnsoftWeight;
    }

    public void setFingerInnovateCopyrightApplyUnsoftWeight(Double fingerInnovateCopyrightApplyUnsoftWeight) {
        this.fingerInnovateCopyrightApplyUnsoftWeight = fingerInnovateCopyrightApplyUnsoftWeight;
    }

    public Double getFingerInnovateCopyrightGrantWeight() {
        return fingerInnovateCopyrightGrantWeight;
    }

    public void setFingerInnovateCopyrightGrantWeight(Double fingerInnovateCopyrightGrantWeight) {
        this.fingerInnovateCopyrightGrantWeight = fingerInnovateCopyrightGrantWeight;
    }

    public Double getFingerInnovateCopyrightGrantSoftWeight() {
        return fingerInnovateCopyrightGrantSoftWeight;
    }

    public void setFingerInnovateCopyrightGrantSoftWeight(Double fingerInnovateCopyrightGrantSoftWeight) {
        this.fingerInnovateCopyrightGrantSoftWeight = fingerInnovateCopyrightGrantSoftWeight;
    }

    public Double getFingerInnovateCopyrightGrantUnsoftWeight() {
        return fingerInnovateCopyrightGrantUnsoftWeight;
    }

    public void setFingerInnovateCopyrightGrantUnsoftWeight(Double fingerInnovateCopyrightGrantUnsoftWeight) {
        this.fingerInnovateCopyrightGrantUnsoftWeight = fingerInnovateCopyrightGrantUnsoftWeight;
    }

    public Double getFingerInnovateNewProductWeight() {
        return fingerInnovateNewProductWeight;
    }

    public void setFingerInnovateNewProductWeight(Double fingerInnovateNewProductWeight) {
        this.fingerInnovateNewProductWeight = fingerInnovateNewProductWeight;
    }

    public Double getFingerInnovateNewProductPatentWeight() {
        return fingerInnovateNewProductPatentWeight;
    }

    public void setFingerInnovateNewProductPatentWeight(Double fingerInnovateNewProductPatentWeight) {
        this.fingerInnovateNewProductPatentWeight = fingerInnovateNewProductPatentWeight;
    }

    public Double getFingerInnovateNewProductTechWeight() {
        return fingerInnovateNewProductTechWeight;
    }

    public void setFingerInnovateNewProductTechWeight(Double fingerInnovateNewProductTechWeight) {
        this.fingerInnovateNewProductTechWeight = fingerInnovateNewProductTechWeight;
    }

    public Double getFingerInnovateNewProductBusWeight() {
        return fingerInnovateNewProductBusWeight;
    }

    public void setFingerInnovateNewProductBusWeight(Double fingerInnovateNewProductBusWeight) {
        this.fingerInnovateNewProductBusWeight = fingerInnovateNewProductBusWeight;
    }

    public Double getFingerSalaryWeight() {
        return fingerSalaryWeight;
    }

    public void setFingerSalaryWeight(Double fingerSalaryWeight) {
        this.fingerSalaryWeight = fingerSalaryWeight;
    }

    public Double getFingerSalaryStaffWeight() {
        return fingerSalaryStaffWeight;
    }

    public void setFingerSalaryStaffWeight(Double fingerSalaryStaffWeight) {
        this.fingerSalaryStaffWeight = fingerSalaryStaffWeight;
    }

    public Double getFingerSalaryStaffUp10Weight() {
        return fingerSalaryStaffUp10Weight;
    }

    public void setFingerSalaryStaffUp10Weight(Double fingerSalaryStaffUp10Weight) {
        this.fingerSalaryStaffUp10Weight = fingerSalaryStaffUp10Weight;
    }

    public Double getFingerSalaryStaff510Weight() {
        return fingerSalaryStaff510Weight;
    }

    public void setFingerSalaryStaff510Weight(Double fingerSalaryStaff510Weight) {
        this.fingerSalaryStaff510Weight = fingerSalaryStaff510Weight;
    }

    public Double getFingerSalaryStaffDown5Weight() {
        return fingerSalaryStaffDown5Weight;
    }

    public void setFingerSalaryStaffDown5Weight(Double fingerSalaryStaffDown5Weight) {
        this.fingerSalaryStaffDown5Weight = fingerSalaryStaffDown5Weight;
    }

    public Double getFingerSalaryStaffContributionWeight() {
        return fingerSalaryStaffContributionWeight;
    }

    public void setFingerSalaryStaffContributionWeight(Double fingerSalaryStaffContributionWeight) {
        this.fingerSalaryStaffContributionWeight = fingerSalaryStaffContributionWeight;
    }

    public Double getFingerSalaryStaffContributionMeansaleWeight() {
        return fingerSalaryStaffContributionMeansaleWeight;
    }

    public void setFingerSalaryStaffContributionMeansaleWeight(Double fingerSalaryStaffContributionMeansaleWeight) {
        this.fingerSalaryStaffContributionMeansaleWeight = fingerSalaryStaffContributionMeansaleWeight;
    }

    public Double getFingerSalaryStaffContributionMeantaxWeight() {
        return fingerSalaryStaffContributionMeantaxWeight;
    }

    public void setFingerSalaryStaffContributionMeantaxWeight(Double fingerSalaryStaffContributionMeantaxWeight) {
        this.fingerSalaryStaffContributionMeantaxWeight = fingerSalaryStaffContributionMeantaxWeight;
    }

    public Double getFingerLearnWeight() {
        return fingerLearnWeight;
    }

    public void setFingerLearnWeight(Double fingerLearnWeight) {
        this.fingerLearnWeight = fingerLearnWeight;
    }

    public Double getFingerLearnTrainWeight() {
        return fingerLearnTrainWeight;
    }

    public void setFingerLearnTrainWeight(Double fingerLearnTrainWeight) {
        this.fingerLearnTrainWeight = fingerLearnTrainWeight;
    }

    public Double getFingerLearnTrainManageWeight() {
        return fingerLearnTrainManageWeight;
    }

    public void setFingerLearnTrainManageWeight(Double fingerLearnTrainManageWeight) {
        this.fingerLearnTrainManageWeight = fingerLearnTrainManageWeight;
    }

    public Double getFingerLearnTrainPolicyWeight() {
        return fingerLearnTrainPolicyWeight;
    }

    public void setFingerLearnTrainPolicyWeight(Double fingerLearnTrainPolicyWeight) {
        this.fingerLearnTrainPolicyWeight = fingerLearnTrainPolicyWeight;
    }

    public Double getFingerLearnTrainSkillWeight() {
        return fingerLearnTrainSkillWeight;
    }

    public void setFingerLearnTrainSkillWeight(Double fingerLearnTrainSkillWeight) {
        this.fingerLearnTrainSkillWeight = fingerLearnTrainSkillWeight;
    }

    public Double getFingerLearnConsltedWeight() {
        return fingerLearnConsltedWeight;
    }

    public void setFingerLearnConsltedWeight(Double fingerLearnConsltedWeight) {
        this.fingerLearnConsltedWeight = fingerLearnConsltedWeight;
    }

    public Double getFingerLearnConsltedManageWeight() {
        return fingerLearnConsltedManageWeight;
    }

    public void setFingerLearnConsltedManageWeight(Double fingerLearnConsltedManageWeight) {
        this.fingerLearnConsltedManageWeight = fingerLearnConsltedManageWeight;
    }

    public Double getFingerLearnConsltedPolicyWeight() {
        return fingerLearnConsltedPolicyWeight;
    }

    public void setFingerLearnConsltedPolicyWeight(Double fingerLearnConsltedPolicyWeight) {
        this.fingerLearnConsltedPolicyWeight = fingerLearnConsltedPolicyWeight;
    }

    public Double getFingerLearnConsltedSkillWeight() {
        return fingerLearnConsltedSkillWeight;
    }

    public void setFingerLearnConsltedSkillWeight(Double fingerLearnConsltedSkillWeight) {
        this.fingerLearnConsltedSkillWeight = fingerLearnConsltedSkillWeight;
    }

    public Double getFingerBrandWeight() {
        return fingerBrandWeight;
    }

    public void setFingerBrandWeight(Double fingerBrandWeight) {
        this.fingerBrandWeight = fingerBrandWeight;
    }

    public Double getFingerBrandRewardWeight() {
        return fingerBrandRewardWeight;
    }

    public void setFingerBrandRewardWeight(Double fingerBrandRewardWeight) {
        this.fingerBrandRewardWeight = fingerBrandRewardWeight;
    }

    public Double getFingerBrandRewardAreaWeight() {
        return fingerBrandRewardAreaWeight;
    }

    public void setFingerBrandRewardAreaWeight(Double fingerBrandRewardAreaWeight) {
        this.fingerBrandRewardAreaWeight = fingerBrandRewardAreaWeight;
    }

    public Double getFingerBrandRewardCityWeight() {
        return fingerBrandRewardCityWeight;
    }

    public void setFingerBrandRewardCityWeight(Double fingerBrandRewardCityWeight) {
        this.fingerBrandRewardCityWeight = fingerBrandRewardCityWeight;
    }

    public Double getFingerBrandRewardProvinceWeight() {
        return fingerBrandRewardProvinceWeight;
    }

    public void setFingerBrandRewardProvinceWeight(Double fingerBrandRewardProvinceWeight) {
        this.fingerBrandRewardProvinceWeight = fingerBrandRewardProvinceWeight;
    }

    public Double getFingerBrandRewardCountryWeight() {
        return fingerBrandRewardCountryWeight;
    }

    public void setFingerBrandRewardCountryWeight(Double fingerBrandRewardCountryWeight) {
        this.fingerBrandRewardCountryWeight = fingerBrandRewardCountryWeight;
    }

    public Double getFingerBrandRecognitionWeight() {
        return fingerBrandRecognitionWeight;
    }

    public void setFingerBrandRecognitionWeight(Double fingerBrandRecognitionWeight) {
        this.fingerBrandRecognitionWeight = fingerBrandRecognitionWeight;
    }

    public Double getFingerBrandRecognitionAreaWeight() {
        return fingerBrandRecognitionAreaWeight;
    }

    public void setFingerBrandRecognitionAreaWeight(Double fingerBrandRecognitionAreaWeight) {
        this.fingerBrandRecognitionAreaWeight = fingerBrandRecognitionAreaWeight;
    }

    public Double getFingerBrandRecognitionCityWeight() {
        return fingerBrandRecognitionCityWeight;
    }

    public void setFingerBrandRecognitionCityWeight(Double fingerBrandRecognitionCityWeight) {
        this.fingerBrandRecognitionCityWeight = fingerBrandRecognitionCityWeight;
    }

    public Double getFingerBrandRecognitionProvinceWeight() {
        return fingerBrandRecognitionProvinceWeight;
    }

    public void setFingerBrandRecognitionProvinceWeight(Double fingerBrandRecognitionProvinceWeight) {
        this.fingerBrandRecognitionProvinceWeight = fingerBrandRecognitionProvinceWeight;
    }

    public Double getFingerBrandRecognitionCountryWeight() {
        return fingerBrandRecognitionCountryWeight;
    }

    public void setFingerBrandRecognitionCountryWeight(Double fingerBrandRecognitionCountryWeight) {
        this.fingerBrandRecognitionCountryWeight = fingerBrandRecognitionCountryWeight;
    }

    public Double getFingerBrandTalentWeight() {
        return fingerBrandTalentWeight;
    }

    public void setFingerBrandTalentWeight(Double fingerBrandTalentWeight) {
        this.fingerBrandTalentWeight = fingerBrandTalentWeight;
    }

    public Double getFingerBrandTalentAreaWeight() {
        return fingerBrandTalentAreaWeight;
    }

    public void setFingerBrandTalentAreaWeight(Double fingerBrandTalentAreaWeight) {
        this.fingerBrandTalentAreaWeight = fingerBrandTalentAreaWeight;
    }

    public Double getFingerBrandTalentCityWeight() {
        return fingerBrandTalentCityWeight;
    }

    public void setFingerBrandTalentCityWeight(Double fingerBrandTalentCityWeight) {
        this.fingerBrandTalentCityWeight = fingerBrandTalentCityWeight;
    }

    public Double getFingerBrandTalentProvinceWeight() {
        return fingerBrandTalentProvinceWeight;
    }

    public void setFingerBrandTalentProvinceWeight(Double fingerBrandTalentProvinceWeight) {
        this.fingerBrandTalentProvinceWeight = fingerBrandTalentProvinceWeight;
    }

    public Double getFingerBrandTalentCountryWeight() {
        return fingerBrandTalentCountryWeight;
    }

    public void setFingerBrandTalentCountryWeight(Double fingerBrandTalentCountryWeight) {
        this.fingerBrandTalentCountryWeight = fingerBrandTalentCountryWeight;
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