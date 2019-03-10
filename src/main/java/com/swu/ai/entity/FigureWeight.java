package com.swu.ai.entity;

import javax.persistence.*;

@Table(name = "figure_weight")
public class FigureWeight {
    @Id
    private Long id;

    @Column(name = "figure_sale_weight")
    private Double figureSaleWeight;

    @Column(name = "figure_sale_invoice_weight")
    private Double figureSaleInvoiceWeight;

    @Column(name = "figure_sale_invoice_soft_weight")
    private Double figureSaleInvoiceSoftWeight;

    /**
     * 已开发票的收入-硬件产品
     */
    @Column(name = "figure_sale_invoice_hard_weight")
    private Double figureSaleInvoiceHardWeight;

    /**
     * 已开发票的收入-咨询服务
     */
    @Column(name = "figure_sale_invoice_consultation_weight")
    private Double figureSaleInvoiceConsultationWeight;

    /**
     * 已开发票的收入-其他
     */
    @Column(name = "figure_sale_invoice_other_weight")
    private Double figureSaleInvoiceOtherWeight;

    /**
     * 二级指标：合同确认额
     */
    @Column(name = "figure_sale_contract_weight")
    private Double figureSaleContractWeight;

    /**
     * 三级指标：合同确认额-软件产品
     */
    @Column(name = "figure_sale_contract_soft_weight")
    private Double figureSaleContractSoftWeight;

    /**
     * 三级指标：合同确认额-硬件产品
     */
    @Column(name = "figure_sale_contract_hard_weight")
    private Double figureSaleContractHardWeight;

    /**
     * 三级指标：合同确认额-咨询服务
     */
    @Column(name = "figure_sale_contract_consultation_weight")
    private Double figureSaleContractConsultationWeight;

    /**
     * 三级指标：合同确认额-其他
     */
    @Column(name = "figure_sale_contract_other_weight")
    private Double figureSaleContractOtherWeight;

    /**
     * 一级指标：纳税指数
     */
    @Column(name = "figure_tax_weight")
    private Double figureTaxWeight;

    /**
     * 二级指标：企业所得税
     */
    @Column(name = "figure_tax_corporate_weight")
    private Double figureTaxCorporateWeight;

    /**
     * 三级指标：企业所得税-应纳税值
     */
    @Column(name = "figure_tax_corporate_taxable_weight")
    private Double figureTaxCorporateTaxableWeight;

    /**
     * 三级指标：企业所得税-税收减免值
     */
    @Column(name = "figure_tax_corporate_relief_weight")
    private Double figureTaxCorporateReliefWeight;

    /**
     * 二级指标：个人所得税
     */
    @Column(name = "figure_tax_individual_weight")
    private Double figureTaxIndividualWeight;

    /**
     * 三级指标：个人所得税-应纳税值
     */
    @Column(name = "figure_tax_individual_taxable_weight")
    private Double figureTaxIndividualTaxableWeight;

    /**
     * 三级指标：个人所得税-税收减免
     */
    @Column(name = "figure_tax_individual_relief_weight")
    private Double figureTaxIndividualReliefWeight;

    /**
     * 二级指标：增值税
     */
    @Column(name = "figure_tax_added_weight")
    private Double figureTaxAddedWeight;

    /**
     * 三级指标：增值税-应纳税值
     */
    @Column(name = "figure_tax_added_taxable_weight")
    private Double figureTaxAddedTaxableWeight;

    /**
     * 三级指标：增值税-税收减免
     */
    @Column(name = "figure_tax_added_relief_weight")
    private Double figureTaxAddedReliefWeight;

    /**
     * 一级指标：融资指数
     */
    @Column(name = "figure_finance_weight")
    private Double figureFinanceWeight;

    /**
     * 二级指标：股权类融资
     */
    @Column(name = "figure_finance_stock_weight")
    private Double figureFinanceStockWeight;

    /**
     * 三级指标：股权类融资-风投机构
     */
    @Column(name = "figure_finance_stock_risk_weight")
    private Double figureFinanceStockRiskWeight;

    /**
     * 三级指标：股权类融资-政府企业
     */
    @Column(name = "figure_finance_stock_gov_weight")
    private Double figureFinanceStockGovWeight;

    /**
     * 三级指标：股权类融资-个人
     */
    @Column(name = "figure_finance_stock_person_weight")
    private Double figureFinanceStockPersonWeight;

    /**
     * 二级指标：债务类融资
     */
    @Column(name = "figure_finance_debt_weight")
    private Double figureFinanceDebtWeight;

    /**
     * 三级指标：债务类融资-银行
     */
    @Column(name = "figure_finance_debt_bank_weight")
    private Double figureFinanceDebtBankWeight;

    /**
     * 三级指标：债务类融资-新型贷款机构
     */
    @Column(name = "figure_finance_debt_new_weight")
    private Double figureFinanceDebtNewWeight;

    /**
     * 三级指标：债务类融资-企业拆借
     */
    @Column(name = "figure_finance_debt_lending_weight")
    private Double figureFinanceDebtLendingWeight;

    /**
     * 三级指标：债务类融资-个人
     */
    @Column(name = "figure_finance_debt_person_weight")
    private Double figureFinanceDebtPersonWeight;

    /**
     * 一级指标:估值指数
     */
    @Column(name = "figure_valuation_weight")
    private Double figureValuationWeight;

    /**
     * 二级指标：净资产
     */
    @Column(name = "figure_valuation_assets_weight")
    private Double figureValuationAssetsWeight;

    /**
     * 三级指标：净资产-流动资产
     */
    @Column(name = "figure_valuation_assets_circulating_weight")
    private Double figureValuationAssetsCirculatingWeight;

    /**
     * 三级指标：净资产-非流动资产
     */
    @Column(name = "figure_valuation_assets_uncirculating_weight")
    private Double figureValuationAssetsUncirculatingWeight;

    /**
     * 三级指标：净资产-流动负债
     */
    @Column(name = "figure_valuation_assets_debt_circulating_weight")
    private Double figureValuationAssetsDebtCirculatingWeight;

    /**
     * 三级指标：净资产-非流动负债
     */
    @Column(name = "figure_valuation_assets_debt_uncirculating_weight")
    private Double figureValuationAssetsDebtUncirculatingWeight;

    /**
     * 二级指标：实际估值
     */
    @Column(name = "figure_valuation_actual_weight")
    private Double figureValuationActualWeight;

    /**
     * 三级指标：实际估值-首次融资
     */
    @Column(name = "figure_valuation_actual_first_weight")
    private Double figureValuationActualFirstWeight;

    /**
     * 三级指标：实际估值-最近一次融资估值
     */
    @Column(name = "figure_valuation_actual_latest_weight")
    private Double figureValuationActualLatestWeight;

    /**
     * 三级指标：实际估值-现在准备融资估值
     */
    @Column(name = "figure_valuation_actual_want_weight")
    private Double figureValuationActualWantWeight;

    /**
     * 一级指标：人力资源指数
     */
    @Column(name = "figure_hr_weight")
    private Double figureHrWeight;

    /**
     * 二级指标：兼职员工数
     */
    @Column(name = "figure_hr_partime_weight")
    private Double figureHrPartimeWeight;

    /**
     * 三级指标：兼职员工-研发
     */
    @Column(name = "figure_hr_partime_dev_weight")
    private Double figureHrPartimeDevWeight;

    /**
     * 三级指标：兼职员工-管理
     */
    @Column(name = "figure_hr_partime_manage_weight")
    private Double figureHrPartimeManageWeight;

    /**
     * 三级指标：兼职员工-行政
     */
    @Column(name = "figure_hr_partime_admin_weight")
    private Double figureHrPartimeAdminWeight;

    /**
     * 三级指标：兼职员工-销售
     */
    @Column(name = "figure_hr_partime_saler_weight")
    private Double figureHrPartimeSalerWeight;

    /**
     * 二级指标：全职员工
     */
    @Column(name = "figure_hr_fulltime_weight")
    private Double figureHrFulltimeWeight;

    /**
     * 三级指标：全职员工-研发
     */
    @Column(name = "figure_hr_fulltime_dev_weight")
    private Double figureHrFulltimeDevWeight;

    /**
     * 三级指标：全职员工-高管
     */
    @Column(name = "figure_hr_fulltime_senior_weight")
    private Double figureHrFulltimeSeniorWeight;

    /**
     * 三级指标：全职员工-行政
     */
    @Column(name = "figure_hr_fulltime_admin_weight")
    private Double figureHrFulltimeAdminWeight;

    /**
     * 三级指标：全职员工-销售
     */
    @Column(name = "figure_hr_fulltime_saler_weight")
    private Double figureHrFulltimeSalerWeight;

    /**
     * 二级指标：高学历人员
     */
    @Column(name = "figure_hr_educated_weight")
    private Double figureHrEducatedWeight;

    /**
     * 三级指标：高学历人员-博士
     */
    @Column(name = "figure_hr_educated_doc_weight")
    private Double figureHrEducatedDocWeight;

    /**
     * 三级指标：高学历人员-硕士
     */
    @Column(name = "figure_hr_educated_master_weight")
    private Double figureHrEducatedMasterWeight;

    /**
     * 三级指标：高学历人员-学士
     */
    @Column(name = "figure_hr_bachelor_weight")
    private Double figureHrBachelorWeight;

    /**
     * 一级指标：创新指数
     */
    @Column(name = "figure_innovate_weight")
    private Double figureInnovateWeight;

    /**
     * 二级指标：专利申请
     */
    @Column(name = "figure_innovate_patent_apply_weight")
    private Double figureInnovatePatentApplyWeight;

    /**
     * 三级指标：专利申请-发明
     */
    @Column(name = "figure_innovate_patent_apply_invention_weight")
    private Double figureInnovatePatentApplyInventionWeight;

    /**
     * 三级指标：专利申请-实用新型
     */
    @Column(name = "figure_innovate_patent_apply_utility_weight")
    private Double figureInnovatePatentApplyUtilityWeight;

    /**
     * 三级指标：专利申请-外观设计
     */
    @Column(name = "figure_innovate_patent_apply_appear_weight")
    private Double figureInnovatePatentApplyAppearWeight;

    /**
     * 二级指标：专利授权
     */
    @Column(name = "figure_innovate_patent_grant_weight")
    private Double figureInnovatePatentGrantWeight;

    /**
     * 三级指标：专利授权-发明
     */
    @Column(name = "figure_innovate_patent_grant_invention_weight")
    private Double figureInnovatePatentGrantInventionWeight;

    /**
     * 三级指标：专利授权-实用新型
     */
    @Column(name = "figure_innovate_patent_grant_utility_weight")
    private Double figureInnovatePatentGrantUtilityWeight;

    /**
     * 三级指标：专利授权-外观设计
     */
    @Column(name = "figure_innovate_patent_grant_appear_weight")
    private Double figureInnovatePatentGrantAppearWeight;

    /**
     * 二级指标：著作权申请
     */
    @Column(name = "figure_innovate_copyright_apply_weight")
    private Double figureInnovateCopyrightApplyWeight;

    /**
     * 三级指标：著作权申请-软件类
     */
    @Column(name = "figure_innovate_copyright_apply_soft_weight")
    private Double figureInnovateCopyrightApplySoftWeight;

    /**
     * 三级指标：著作权申请-非软件类
     */
    @Column(name = "figure_innovate_copyright_apply_unsoft_weight")
    private Double figureInnovateCopyrightApplyUnsoftWeight;

    /**
     * 二级指标：著作权授权
     */
    @Column(name = "figure_innovate_copyright_grant_weight")
    private Double figureInnovateCopyrightGrantWeight;

    /**
     * 三级指标：著作权授权-软件类
     */
    @Column(name = "figure_innovate_copyright_grant_soft_weight")
    private Double figureInnovateCopyrightGrantSoftWeight;

    /**
     * 三级指标：著作权授权-非软件类
     */
    @Column(name = "figure_innovate_copyright_grant_unsoft_weight")
    private Double figureInnovateCopyrightGrantUnsoftWeight;

    /**
     * 二级指标：新产品/服务
     */
    @Column(name = "figure_innovate_new_product_weight")
    private Double figureInnovateNewProductWeight;

    /**
     * 三级指标：新产品/服务-专利类
     */
    @Column(name = "figure_innovate_new_product_patent_weight")
    private Double figureInnovateNewProductPatentWeight;

    /**
     * 三级指标：新产品/服务-专用技术
     */
    @Column(name = "figure_innovate_new_product_tech_weight")
    private Double figureInnovateNewProductTechWeight;

    /**
     * 三级指标：新产品/服务-商业模式
     */
    @Column(name = "figure_innovate_new_product_bus_weight")
    private Double figureInnovateNewProductBusWeight;

    /**
     * 一级指标：薪酬指数
     */
    @Column(name = "figure_salary_weight")
    private Double figureSalaryWeight;

    /**
     * 二级指标：员工工资额
     */
    @Column(name = "figure_salary_staff_weight")
    private Double figureSalaryStaffWeight;

    /**
     * 三级指标：员工工资额-1万元以上
     */
    @Column(name = "figure_salary_staff_up_10_weight")
    private Double figureSalaryStaffUp10Weight;

    /**
     * 三级指标：员工工资额-5千到1万
     */
    @Column(name = "figure_salary_staff_5_10_weight")
    private Double figureSalaryStaff510Weight;

    /**
     * 三级指标：员工工资额-5千以下
     */
    @Column(name = "figure_salary_staff_down_5_weight")
    private Double figureSalaryStaffDown5Weight;

    /**
     * 二级指标：员工贡献率
     */
    @Column(name = "figure_salary_staff_contribution_weight")
    private Double figureSalaryStaffContributionWeight;

    /**
     * 三级指标：员工贡献率-人均销售
     */
    @Column(name = "figure_salary_staff_contribution_meansale_weight")
    private Double figureSalaryStaffContributionMeansaleWeight;

    /**
     * 三级指标：员工贡献率-人均纳税
     */
    @Column(name = "figure_salary_staff_contribution_meantax_weight")
    private Double figureSalaryStaffContributionMeantaxWeight;

    /**
     * 一级指标：学习指数
     */
    @Column(name = "figure_learn_weight")
    private Double figureLearnWeight;

    /**
     * 二级指标：参加培训的次数
     */
    @Column(name = "figure_learn_train_weight")
    private Double figureLearnTrainWeight;

    /**
     * 三级指标：参加培训的次数-管理类
     */
    @Column(name = "figure_learn_train_manage_weight")
    private Double figureLearnTrainManageWeight;

    /**
     * 三级指标：参加培训的次数-政策法规
     */
    @Column(name = "figure_learn_train_policy_weight")
    private Double figureLearnTrainPolicyWeight;

    /**
     * 三级指标：参加培训的次数-技能类
     */
    @Column(name = "figure_learn_train_skill_weight")
    private Double figureLearnTrainSkillWeight;

    /**
     * 二级指标：接受咨询的次数
     */
    @Column(name = "figure_learn_conslted_weight")
    private Double figureLearnConsltedWeight;

    /**
     * 三级指标：接受咨询的次数-管理类
     */
    @Column(name = "figure_learn_conslted_manage_weight")
    private Double figureLearnConsltedManageWeight;

    /**
     * 三级指标：接受咨询的次数-政策法规
     */
    @Column(name = "figure_learn_conslted_policy_weight")
    private Double figureLearnConsltedPolicyWeight;

    /**
     * 三级指标：接受咨询的次数-技能类
     */
    @Column(name = "figure_learn_conslted_skill_weight")
    private Double figureLearnConsltedSkillWeight;

    /**
     * 一级指标：品牌指数
     */
    @Column(name = "figure_brand_weight")
    private Double figureBrandWeight;

    /**
     * 二级指标：企业获奖
     */
    @Column(name = "figure_brand_reward_weight")
    private Double figureBrandRewardWeight;

    /**
     * 三级指标：企业获奖-区级
     */
    @Column(name = "figure_brand_reward_area_weight")
    private Double figureBrandRewardAreaWeight;

    /**
     * 三级指标：企业获奖-市级
     */
    @Column(name = "figure_brand_reward_city_weight")
    private Double figureBrandRewardCityWeight;

    /**
     * 三级指标：企业获奖-省级
     */
    @Column(name = "figure_brand_reward_province_weight")
    private Double figureBrandRewardProvinceWeight;

    /**
     * 三级指标：企业获奖-国家级
     */
    @Column(name = "figure_brand_reward_country_weight")
    private Double figureBrandRewardCountryWeight;

    /**
     * 二级指标：企业认定
     */
    @Column(name = "figure_brand_recognition_weight")
    private Double figureBrandRecognitionWeight;

    /**
     * 三级指标：企业认定-区级
     */
    @Column(name = "figure_brand_recognition_area_weight")
    private Double figureBrandRecognitionAreaWeight;

    /**
     * 三级指标：企业认定-市级
     */
    @Column(name = "figure_brand_recognition_city_weight")
    private Double figureBrandRecognitionCityWeight;

    /**
     * 三级指标：企业认定-省级
     */
    @Column(name = "figure_brand_recognition_province_weight")
    private Double figureBrandRecognitionProvinceWeight;

    /**
     * 三级指标：企业认定-国家级
     */
    @Column(name = "figure_brand_recognition_country_weight")
    private Double figureBrandRecognitionCountryWeight;

    /**
     * 二级指标：人才资助
     */
    @Column(name = "figure_brand_talent_weight")
    private Double figureBrandTalentWeight;

    /**
     * 三级指标：人才资助-区级
     */
    @Column(name = "figure_brand_talent_area_weight")
    private Double figureBrandTalentAreaWeight;

    /**
     * 三级指标：人才资助-市级
     */
    @Column(name = "figure_brand_talent_city_weight")
    private Double figureBrandTalentCityWeight;

    /**
     * 三级指标：人才资助-省级
     */
    @Column(name = "figure_brand_talent_province_weight")
    private Double figureBrandTalentProvinceWeight;

    /**
     * 三级指标：人才资助-国家级
     */
    @Column(name = "figure_brand_talent_country_weight")
    private Double figureBrandTalentCountryWeight;

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
     * @return figure_sale_weight
     */
    public Double getFigureSaleWeight() {
        return figureSaleWeight;
    }

    /**
     * @param figureSaleWeight
     */
    public void setFigureSaleWeight(Double figureSaleWeight) {
        this.figureSaleWeight = figureSaleWeight;
    }

    /**
     * @return figure_sale_invoice_weight
     */
    public Double getFigureSaleInvoiceWeight() {
        return figureSaleInvoiceWeight;
    }

    /**
     * @param figureSaleInvoiceWeight
     */
    public void setFigureSaleInvoiceWeight(Double figureSaleInvoiceWeight) {
        this.figureSaleInvoiceWeight = figureSaleInvoiceWeight;
    }

    /**
     * @return figure_sale_invoice_soft_weight
     */
    public Double getFigureSaleInvoiceSoftWeight() {
        return figureSaleInvoiceSoftWeight;
    }

    /**
     * @param figureSaleInvoiceSoftWeight
     */
    public void setFigureSaleInvoiceSoftWeight(Double figureSaleInvoiceSoftWeight) {
        this.figureSaleInvoiceSoftWeight = figureSaleInvoiceSoftWeight;
    }

    /**
     * 获取已开发票的收入-硬件产品
     *
     * @return figure_sale_invoice_hard_weight - 已开发票的收入-硬件产品
     */
    public Double getFigureSaleInvoiceHardWeight() {
        return figureSaleInvoiceHardWeight;
    }

    /**
     * 设置已开发票的收入-硬件产品
     *
     * @param figureSaleInvoiceHardWeight 已开发票的收入-硬件产品
     */
    public void setFigureSaleInvoiceHardWeight(Double figureSaleInvoiceHardWeight) {
        this.figureSaleInvoiceHardWeight = figureSaleInvoiceHardWeight;
    }

    /**
     * 获取已开发票的收入-咨询服务
     *
     * @return figure_sale_invoice_consultation_weight - 已开发票的收入-咨询服务
     */
    public Double getFigureSaleInvoiceConsultationWeight() {
        return figureSaleInvoiceConsultationWeight;
    }

    /**
     * 设置已开发票的收入-咨询服务
     *
     * @param figureSaleInvoiceConsultationWeight 已开发票的收入-咨询服务
     */
    public void setFigureSaleInvoiceConsultationWeight(Double figureSaleInvoiceConsultationWeight) {
        this.figureSaleInvoiceConsultationWeight = figureSaleInvoiceConsultationWeight;
    }

    /**
     * 获取已开发票的收入-其他
     *
     * @return figure_sale_invoice_other_weight - 已开发票的收入-其他
     */
    public Double getFigureSaleInvoiceOtherWeight() {
        return figureSaleInvoiceOtherWeight;
    }

    /**
     * 设置已开发票的收入-其他
     *
     * @param figureSaleInvoiceOtherWeight 已开发票的收入-其他
     */
    public void setFigureSaleInvoiceOtherWeight(Double figureSaleInvoiceOtherWeight) {
        this.figureSaleInvoiceOtherWeight = figureSaleInvoiceOtherWeight;
    }

    /**
     * 获取二级指标：合同确认额
     *
     * @return figure_sale_contract_weight - 二级指标：合同确认额
     */
    public Double getFigureSaleContractWeight() {
        return figureSaleContractWeight;
    }

    /**
     * 设置二级指标：合同确认额
     *
     * @param figureSaleContractWeight 二级指标：合同确认额
     */
    public void setFigureSaleContractWeight(Double figureSaleContractWeight) {
        this.figureSaleContractWeight = figureSaleContractWeight;
    }

    /**
     * 获取三级指标：合同确认额-软件产品
     *
     * @return figure_sale_contract_soft_weight - 三级指标：合同确认额-软件产品
     */
    public Double getFigureSaleContractSoftWeight() {
        return figureSaleContractSoftWeight;
    }

    /**
     * 设置三级指标：合同确认额-软件产品
     *
     * @param figureSaleContractSoftWeight 三级指标：合同确认额-软件产品
     */
    public void setFigureSaleContractSoftWeight(Double figureSaleContractSoftWeight) {
        this.figureSaleContractSoftWeight = figureSaleContractSoftWeight;
    }

    /**
     * 获取三级指标：合同确认额-硬件产品
     *
     * @return figure_sale_contract_hard_weight - 三级指标：合同确认额-硬件产品
     */
    public Double getFigureSaleContractHardWeight() {
        return figureSaleContractHardWeight;
    }

    /**
     * 设置三级指标：合同确认额-硬件产品
     *
     * @param figureSaleContractHardWeight 三级指标：合同确认额-硬件产品
     */
    public void setFigureSaleContractHardWeight(Double figureSaleContractHardWeight) {
        this.figureSaleContractHardWeight = figureSaleContractHardWeight;
    }

    /**
     * 获取三级指标：合同确认额-咨询服务
     *
     * @return figure_sale_contract_consultation_weight - 三级指标：合同确认额-咨询服务
     */
    public Double getFigureSaleContractConsultationWeight() {
        return figureSaleContractConsultationWeight;
    }

    /**
     * 设置三级指标：合同确认额-咨询服务
     *
     * @param figureSaleContractConsultationWeight 三级指标：合同确认额-咨询服务
     */
    public void setFigureSaleContractConsultationWeight(Double figureSaleContractConsultationWeight) {
        this.figureSaleContractConsultationWeight = figureSaleContractConsultationWeight;
    }

    /**
     * 获取三级指标：合同确认额-其他
     *
     * @return figure_sale_contract_other_weight - 三级指标：合同确认额-其他
     */
    public Double getFigureSaleContractOtherWeight() {
        return figureSaleContractOtherWeight;
    }

    /**
     * 设置三级指标：合同确认额-其他
     *
     * @param figureSaleContractOtherWeight 三级指标：合同确认额-其他
     */
    public void setFigureSaleContractOtherWeight(Double figureSaleContractOtherWeight) {
        this.figureSaleContractOtherWeight = figureSaleContractOtherWeight;
    }

    /**
     * 获取一级指标：纳税指数
     *
     * @return figure_tax_weight - 一级指标：纳税指数
     */
    public Double getFigureTaxWeight() {
        return figureTaxWeight;
    }

    /**
     * 设置一级指标：纳税指数
     *
     * @param figureTaxWeight 一级指标：纳税指数
     */
    public void setFigureTaxWeight(Double figureTaxWeight) {
        this.figureTaxWeight = figureTaxWeight;
    }

    /**
     * 获取二级指标：企业所得税
     *
     * @return figure_tax_corporate_weight - 二级指标：企业所得税
     */
    public Double getFigureTaxCorporateWeight() {
        return figureTaxCorporateWeight;
    }

    /**
     * 设置二级指标：企业所得税
     *
     * @param figureTaxCorporateWeight 二级指标：企业所得税
     */
    public void setFigureTaxCorporateWeight(Double figureTaxCorporateWeight) {
        this.figureTaxCorporateWeight = figureTaxCorporateWeight;
    }

    /**
     * 获取三级指标：企业所得税-应纳税值
     *
     * @return figure_tax_corporate_taxable_weight - 三级指标：企业所得税-应纳税值
     */
    public Double getFigureTaxCorporateTaxableWeight() {
        return figureTaxCorporateTaxableWeight;
    }

    /**
     * 设置三级指标：企业所得税-应纳税值
     *
     * @param figureTaxCorporateTaxableWeight 三级指标：企业所得税-应纳税值
     */
    public void setFigureTaxCorporateTaxableWeight(Double figureTaxCorporateTaxableWeight) {
        this.figureTaxCorporateTaxableWeight = figureTaxCorporateTaxableWeight;
    }

    /**
     * 获取三级指标：企业所得税-税收减免值
     *
     * @return figure_tax_corporate_relief_weight - 三级指标：企业所得税-税收减免值
     */
    public Double getFigureTaxCorporateReliefWeight() {
        return figureTaxCorporateReliefWeight;
    }

    /**
     * 设置三级指标：企业所得税-税收减免值
     *
     * @param figureTaxCorporateReliefWeight 三级指标：企业所得税-税收减免值
     */
    public void setFigureTaxCorporateReliefWeight(Double figureTaxCorporateReliefWeight) {
        this.figureTaxCorporateReliefWeight = figureTaxCorporateReliefWeight;
    }

    /**
     * 获取二级指标：个人所得税
     *
     * @return figure_tax_individual_weight - 二级指标：个人所得税
     */
    public Double getFigureTaxIndividualWeight() {
        return figureTaxIndividualWeight;
    }

    /**
     * 设置二级指标：个人所得税
     *
     * @param figureTaxIndividualWeight 二级指标：个人所得税
     */
    public void setFigureTaxIndividualWeight(Double figureTaxIndividualWeight) {
        this.figureTaxIndividualWeight = figureTaxIndividualWeight;
    }

    /**
     * 获取三级指标：个人所得税-应纳税值
     *
     * @return figure_tax_individual_taxable_weight - 三级指标：个人所得税-应纳税值
     */
    public Double getFigureTaxIndividualTaxableWeight() {
        return figureTaxIndividualTaxableWeight;
    }

    /**
     * 设置三级指标：个人所得税-应纳税值
     *
     * @param figureTaxIndividualTaxableWeight 三级指标：个人所得税-应纳税值
     */
    public void setFigureTaxIndividualTaxableWeight(Double figureTaxIndividualTaxableWeight) {
        this.figureTaxIndividualTaxableWeight = figureTaxIndividualTaxableWeight;
    }

    /**
     * 获取三级指标：个人所得税-税收减免
     *
     * @return figure_tax_individual_relief_weight - 三级指标：个人所得税-税收减免
     */
    public Double getFigureTaxIndividualReliefWeight() {
        return figureTaxIndividualReliefWeight;
    }

    /**
     * 设置三级指标：个人所得税-税收减免
     *
     * @param figureTaxIndividualReliefWeight 三级指标：个人所得税-税收减免
     */
    public void setFigureTaxIndividualReliefWeight(Double figureTaxIndividualReliefWeight) {
        this.figureTaxIndividualReliefWeight = figureTaxIndividualReliefWeight;
    }

    /**
     * 获取二级指标：增值税
     *
     * @return figure_tax_added_weight - 二级指标：增值税
     */
    public Double getFigureTaxAddedWeight() {
        return figureTaxAddedWeight;
    }

    /**
     * 设置二级指标：增值税
     *
     * @param figureTaxAddedWeight 二级指标：增值税
     */
    public void setFigureTaxAddedWeight(Double figureTaxAddedWeight) {
        this.figureTaxAddedWeight = figureTaxAddedWeight;
    }

    /**
     * 获取三级指标：增值税-应纳税值
     *
     * @return figure_tax_added_taxable_weight - 三级指标：增值税-应纳税值
     */
    public Double getFigureTaxAddedTaxableWeight() {
        return figureTaxAddedTaxableWeight;
    }

    /**
     * 设置三级指标：增值税-应纳税值
     *
     * @param figureTaxAddedTaxableWeight 三级指标：增值税-应纳税值
     */
    public void setFigureTaxAddedTaxableWeight(Double figureTaxAddedTaxableWeight) {
        this.figureTaxAddedTaxableWeight = figureTaxAddedTaxableWeight;
    }

    /**
     * 获取三级指标：增值税-税收减免
     *
     * @return figure_tax_added_relief_weight - 三级指标：增值税-税收减免
     */
    public Double getFigureTaxAddedReliefWeight() {
        return figureTaxAddedReliefWeight;
    }

    /**
     * 设置三级指标：增值税-税收减免
     *
     * @param figureTaxAddedReliefWeight 三级指标：增值税-税收减免
     */
    public void setFigureTaxAddedReliefWeight(Double figureTaxAddedReliefWeight) {
        this.figureTaxAddedReliefWeight = figureTaxAddedReliefWeight;
    }

    /**
     * 获取一级指标：融资指数
     *
     * @return figure_finance_weight - 一级指标：融资指数
     */
    public Double getFigureFinanceWeight() {
        return figureFinanceWeight;
    }

    /**
     * 设置一级指标：融资指数
     *
     * @param figureFinanceWeight 一级指标：融资指数
     */
    public void setFigureFinanceWeight(Double figureFinanceWeight) {
        this.figureFinanceWeight = figureFinanceWeight;
    }

    /**
     * 获取二级指标：股权类融资
     *
     * @return figure_finance_stock_weight - 二级指标：股权类融资
     */
    public Double getFigureFinanceStockWeight() {
        return figureFinanceStockWeight;
    }

    /**
     * 设置二级指标：股权类融资
     *
     * @param figureFinanceStockWeight 二级指标：股权类融资
     */
    public void setFigureFinanceStockWeight(Double figureFinanceStockWeight) {
        this.figureFinanceStockWeight = figureFinanceStockWeight;
    }

    /**
     * 获取三级指标：股权类融资-风投机构
     *
     * @return figure_finance_stock_risk_weight - 三级指标：股权类融资-风投机构
     */
    public Double getFigureFinanceStockRiskWeight() {
        return figureFinanceStockRiskWeight;
    }

    /**
     * 设置三级指标：股权类融资-风投机构
     *
     * @param figureFinanceStockRiskWeight 三级指标：股权类融资-风投机构
     */
    public void setFigureFinanceStockRiskWeight(Double figureFinanceStockRiskWeight) {
        this.figureFinanceStockRiskWeight = figureFinanceStockRiskWeight;
    }

    /**
     * 获取三级指标：股权类融资-政府企业
     *
     * @return figure_finance_stock_gov_weight - 三级指标：股权类融资-政府企业
     */
    public Double getFigureFinanceStockGovWeight() {
        return figureFinanceStockGovWeight;
    }

    /**
     * 设置三级指标：股权类融资-政府企业
     *
     * @param figureFinanceStockGovWeight 三级指标：股权类融资-政府企业
     */
    public void setFigureFinanceStockGovWeight(Double figureFinanceStockGovWeight) {
        this.figureFinanceStockGovWeight = figureFinanceStockGovWeight;
    }

    /**
     * 获取三级指标：股权类融资-个人
     *
     * @return figure_finance_stock_person_weight - 三级指标：股权类融资-个人
     */
    public Double getFigureFinanceStockPersonWeight() {
        return figureFinanceStockPersonWeight;
    }

    /**
     * 设置三级指标：股权类融资-个人
     *
     * @param figureFinanceStockPersonWeight 三级指标：股权类融资-个人
     */
    public void setFigureFinanceStockPersonWeight(Double figureFinanceStockPersonWeight) {
        this.figureFinanceStockPersonWeight = figureFinanceStockPersonWeight;
    }

    /**
     * 获取二级指标：债务类融资
     *
     * @return figure_finance_debt_weight - 二级指标：债务类融资
     */
    public Double getFigureFinanceDebtWeight() {
        return figureFinanceDebtWeight;
    }

    /**
     * 设置二级指标：债务类融资
     *
     * @param figureFinanceDebtWeight 二级指标：债务类融资
     */
    public void setFigureFinanceDebtWeight(Double figureFinanceDebtWeight) {
        this.figureFinanceDebtWeight = figureFinanceDebtWeight;
    }

    /**
     * 获取三级指标：债务类融资-银行
     *
     * @return figure_finance_debt_bank_weight - 三级指标：债务类融资-银行
     */
    public Double getFigureFinanceDebtBankWeight() {
        return figureFinanceDebtBankWeight;
    }

    /**
     * 设置三级指标：债务类融资-银行
     *
     * @param figureFinanceDebtBankWeight 三级指标：债务类融资-银行
     */
    public void setFigureFinanceDebtBankWeight(Double figureFinanceDebtBankWeight) {
        this.figureFinanceDebtBankWeight = figureFinanceDebtBankWeight;
    }

    /**
     * 获取三级指标：债务类融资-新型贷款机构
     *
     * @return figure_finance_debt_new_weight - 三级指标：债务类融资-新型贷款机构
     */
    public Double getFigureFinanceDebtNewWeight() {
        return figureFinanceDebtNewWeight;
    }

    /**
     * 设置三级指标：债务类融资-新型贷款机构
     *
     * @param figureFinanceDebtNewWeight 三级指标：债务类融资-新型贷款机构
     */
    public void setFigureFinanceDebtNewWeight(Double figureFinanceDebtNewWeight) {
        this.figureFinanceDebtNewWeight = figureFinanceDebtNewWeight;
    }

    /**
     * 获取三级指标：债务类融资-企业拆借
     *
     * @return figure_finance_debt_lending_weight - 三级指标：债务类融资-企业拆借
     */
    public Double getFigureFinanceDebtLendingWeight() {
        return figureFinanceDebtLendingWeight;
    }

    /**
     * 设置三级指标：债务类融资-企业拆借
     *
     * @param figureFinanceDebtLendingWeight 三级指标：债务类融资-企业拆借
     */
    public void setFigureFinanceDebtLendingWeight(Double figureFinanceDebtLendingWeight) {
        this.figureFinanceDebtLendingWeight = figureFinanceDebtLendingWeight;
    }

    /**
     * 获取三级指标：债务类融资-个人
     *
     * @return figure_finance_debt_person_weight - 三级指标：债务类融资-个人
     */
    public Double getFigureFinanceDebtPersonWeight() {
        return figureFinanceDebtPersonWeight;
    }

    /**
     * 设置三级指标：债务类融资-个人
     *
     * @param figureFinanceDebtPersonWeight 三级指标：债务类融资-个人
     */
    public void setFigureFinanceDebtPersonWeight(Double figureFinanceDebtPersonWeight) {
        this.figureFinanceDebtPersonWeight = figureFinanceDebtPersonWeight;
    }

    /**
     * 获取一级指标:估值指数
     *
     * @return figure_valuation_weight - 一级指标:估值指数
     */
    public Double getFigureValuationWeight() {
        return figureValuationWeight;
    }

    /**
     * 设置一级指标:估值指数
     *
     * @param figureValuationWeight 一级指标:估值指数
     */
    public void setFigureValuationWeight(Double figureValuationWeight) {
        this.figureValuationWeight = figureValuationWeight;
    }

    /**
     * 获取二级指标：净资产
     *
     * @return figure_valuation_assets_weight - 二级指标：净资产
     */
    public Double getFigureValuationAssetsWeight() {
        return figureValuationAssetsWeight;
    }

    /**
     * 设置二级指标：净资产
     *
     * @param figureValuationAssetsWeight 二级指标：净资产
     */
    public void setFigureValuationAssetsWeight(Double figureValuationAssetsWeight) {
        this.figureValuationAssetsWeight = figureValuationAssetsWeight;
    }

    /**
     * 获取三级指标：净资产-流动资产
     *
     * @return figure_valuation_assets_circulating_weight - 三级指标：净资产-流动资产
     */
    public Double getFigureValuationAssetsCirculatingWeight() {
        return figureValuationAssetsCirculatingWeight;
    }

    /**
     * 设置三级指标：净资产-流动资产
     *
     * @param figureValuationAssetsCirculatingWeight 三级指标：净资产-流动资产
     */
    public void setFigureValuationAssetsCirculatingWeight(Double figureValuationAssetsCirculatingWeight) {
        this.figureValuationAssetsCirculatingWeight = figureValuationAssetsCirculatingWeight;
    }

    /**
     * 获取三级指标：净资产-非流动资产
     *
     * @return figure_valuation_assets_uncirculating_weight - 三级指标：净资产-非流动资产
     */
    public Double getFigureValuationAssetsUncirculatingWeight() {
        return figureValuationAssetsUncirculatingWeight;
    }

    /**
     * 设置三级指标：净资产-非流动资产
     *
     * @param figureValuationAssetsUncirculatingWeight 三级指标：净资产-非流动资产
     */
    public void setFigureValuationAssetsUncirculatingWeight(Double figureValuationAssetsUncirculatingWeight) {
        this.figureValuationAssetsUncirculatingWeight = figureValuationAssetsUncirculatingWeight;
    }

    /**
     * 获取三级指标：净资产-流动负债
     *
     * @return figure_valuation_assets_debt_circulating_weight - 三级指标：净资产-流动负债
     */
    public Double getFigureValuationAssetsDebtCirculatingWeight() {
        return figureValuationAssetsDebtCirculatingWeight;
    }

    /**
     * 设置三级指标：净资产-流动负债
     *
     * @param figureValuationAssetsDebtCirculatingWeight 三级指标：净资产-流动负债
     */
    public void setFigureValuationAssetsDebtCirculatingWeight(Double figureValuationAssetsDebtCirculatingWeight) {
        this.figureValuationAssetsDebtCirculatingWeight = figureValuationAssetsDebtCirculatingWeight;
    }

    /**
     * 获取三级指标：净资产-非流动负债
     *
     * @return figure_valuation_assets_debt_uncirculating_weight - 三级指标：净资产-非流动负债
     */
    public Double getFigureValuationAssetsDebtUncirculatingWeight() {
        return figureValuationAssetsDebtUncirculatingWeight;
    }

    /**
     * 设置三级指标：净资产-非流动负债
     *
     * @param figureValuationAssetsDebtUncirculatingWeight 三级指标：净资产-非流动负债
     */
    public void setFigureValuationAssetsDebtUncirculatingWeight(Double figureValuationAssetsDebtUncirculatingWeight) {
        this.figureValuationAssetsDebtUncirculatingWeight = figureValuationAssetsDebtUncirculatingWeight;
    }

    /**
     * 获取二级指标：实际估值
     *
     * @return figure_valuation_actual_weight - 二级指标：实际估值
     */
    public Double getFigureValuationActualWeight() {
        return figureValuationActualWeight;
    }

    /**
     * 设置二级指标：实际估值
     *
     * @param figureValuationActualWeight 二级指标：实际估值
     */
    public void setFigureValuationActualWeight(Double figureValuationActualWeight) {
        this.figureValuationActualWeight = figureValuationActualWeight;
    }

    /**
     * 获取三级指标：实际估值-首次融资
     *
     * @return figure_valuation_actual_first_weight - 三级指标：实际估值-首次融资
     */
    public Double getFigureValuationActualFirstWeight() {
        return figureValuationActualFirstWeight;
    }

    /**
     * 设置三级指标：实际估值-首次融资
     *
     * @param figureValuationActualFirstWeight 三级指标：实际估值-首次融资
     */
    public void setFigureValuationActualFirstWeight(Double figureValuationActualFirstWeight) {
        this.figureValuationActualFirstWeight = figureValuationActualFirstWeight;
    }

    /**
     * 获取三级指标：实际估值-最近一次融资估值
     *
     * @return figure_valuation_actual_latest_weight - 三级指标：实际估值-最近一次融资估值
     */
    public Double getFigureValuationActualLatestWeight() {
        return figureValuationActualLatestWeight;
    }

    /**
     * 设置三级指标：实际估值-最近一次融资估值
     *
     * @param figureValuationActualLatestWeight 三级指标：实际估值-最近一次融资估值
     */
    public void setFigureValuationActualLatestWeight(Double figureValuationActualLatestWeight) {
        this.figureValuationActualLatestWeight = figureValuationActualLatestWeight;
    }

    /**
     * 获取三级指标：实际估值-现在准备融资估值
     *
     * @return figure_valuation_actual_want_weight - 三级指标：实际估值-现在准备融资估值
     */
    public Double getFigureValuationActualWantWeight() {
        return figureValuationActualWantWeight;
    }

    /**
     * 设置三级指标：实际估值-现在准备融资估值
     *
     * @param figureValuationActualWantWeight 三级指标：实际估值-现在准备融资估值
     */
    public void setFigureValuationActualWantWeight(Double figureValuationActualWantWeight) {
        this.figureValuationActualWantWeight = figureValuationActualWantWeight;
    }

    /**
     * 获取一级指标：人力资源指数
     *
     * @return figure_hr_weight - 一级指标：人力资源指数
     */
    public Double getFigureHrWeight() {
        return figureHrWeight;
    }

    /**
     * 设置一级指标：人力资源指数
     *
     * @param figureHrWeight 一级指标：人力资源指数
     */
    public void setFigureHrWeight(Double figureHrWeight) {
        this.figureHrWeight = figureHrWeight;
    }

    /**
     * 获取二级指标：兼职员工数
     *
     * @return figure_hr_partime_weight - 二级指标：兼职员工数
     */
    public Double getFigureHrPartimeWeight() {
        return figureHrPartimeWeight;
    }

    /**
     * 设置二级指标：兼职员工数
     *
     * @param figureHrPartimeWeight 二级指标：兼职员工数
     */
    public void setFigureHrPartimeWeight(Double figureHrPartimeWeight) {
        this.figureHrPartimeWeight = figureHrPartimeWeight;
    }

    /**
     * 获取三级指标：兼职员工-研发
     *
     * @return figure_hr_partime_dev_weight - 三级指标：兼职员工-研发
     */
    public Double getFigureHrPartimeDevWeight() {
        return figureHrPartimeDevWeight;
    }

    /**
     * 设置三级指标：兼职员工-研发
     *
     * @param figureHrPartimeDevWeight 三级指标：兼职员工-研发
     */
    public void setFigureHrPartimeDevWeight(Double figureHrPartimeDevWeight) {
        this.figureHrPartimeDevWeight = figureHrPartimeDevWeight;
    }

    /**
     * 获取三级指标：兼职员工-管理
     *
     * @return figure_hr_partime_manage_weight - 三级指标：兼职员工-管理
     */
    public Double getFigureHrPartimeManageWeight() {
        return figureHrPartimeManageWeight;
    }

    /**
     * 设置三级指标：兼职员工-管理
     *
     * @param figureHrPartimeManageWeight 三级指标：兼职员工-管理
     */
    public void setFigureHrPartimeManageWeight(Double figureHrPartimeManageWeight) {
        this.figureHrPartimeManageWeight = figureHrPartimeManageWeight;
    }

    /**
     * 获取三级指标：兼职员工-行政
     *
     * @return figure_hr_partime_admin_weight - 三级指标：兼职员工-行政
     */
    public Double getFigureHrPartimeAdminWeight() {
        return figureHrPartimeAdminWeight;
    }

    /**
     * 设置三级指标：兼职员工-行政
     *
     * @param figureHrPartimeAdminWeight 三级指标：兼职员工-行政
     */
    public void setFigureHrPartimeAdminWeight(Double figureHrPartimeAdminWeight) {
        this.figureHrPartimeAdminWeight = figureHrPartimeAdminWeight;
    }

    /**
     * 获取三级指标：兼职员工-销售
     *
     * @return figure_hr_partime_saler_weight - 三级指标：兼职员工-销售
     */
    public Double getFigureHrPartimeSalerWeight() {
        return figureHrPartimeSalerWeight;
    }

    /**
     * 设置三级指标：兼职员工-销售
     *
     * @param figureHrPartimeSalerWeight 三级指标：兼职员工-销售
     */
    public void setFigureHrPartimeSalerWeight(Double figureHrPartimeSalerWeight) {
        this.figureHrPartimeSalerWeight = figureHrPartimeSalerWeight;
    }

    /**
     * 获取二级指标：全职员工
     *
     * @return figure_hr_fulltime_weight - 二级指标：全职员工
     */
    public Double getFigureHrFulltimeWeight() {
        return figureHrFulltimeWeight;
    }

    /**
     * 设置二级指标：全职员工
     *
     * @param figureHrFulltimeWeight 二级指标：全职员工
     */
    public void setFigureHrFulltimeWeight(Double figureHrFulltimeWeight) {
        this.figureHrFulltimeWeight = figureHrFulltimeWeight;
    }

    /**
     * 获取三级指标：全职员工-研发
     *
     * @return figure_hr_fulltime_dev_weight - 三级指标：全职员工-研发
     */
    public Double getFigureHrFulltimeDevWeight() {
        return figureHrFulltimeDevWeight;
    }

    /**
     * 设置三级指标：全职员工-研发
     *
     * @param figureHrFulltimeDevWeight 三级指标：全职员工-研发
     */
    public void setFigureHrFulltimeDevWeight(Double figureHrFulltimeDevWeight) {
        this.figureHrFulltimeDevWeight = figureHrFulltimeDevWeight;
    }

    /**
     * 获取三级指标：全职员工-高管
     *
     * @return figure_hr_fulltime_senior_weight - 三级指标：全职员工-高管
     */
    public Double getFigureHrFulltimeSeniorWeight() {
        return figureHrFulltimeSeniorWeight;
    }

    /**
     * 设置三级指标：全职员工-高管
     *
     * @param figureHrFulltimeSeniorWeight 三级指标：全职员工-高管
     */
    public void setFigureHrFulltimeSeniorWeight(Double figureHrFulltimeSeniorWeight) {
        this.figureHrFulltimeSeniorWeight = figureHrFulltimeSeniorWeight;
    }

    /**
     * 获取三级指标：全职员工-行政
     *
     * @return figure_hr_fulltime_admin_weight - 三级指标：全职员工-行政
     */
    public Double getFigureHrFulltimeAdminWeight() {
        return figureHrFulltimeAdminWeight;
    }

    /**
     * 设置三级指标：全职员工-行政
     *
     * @param figureHrFulltimeAdminWeight 三级指标：全职员工-行政
     */
    public void setFigureHrFulltimeAdminWeight(Double figureHrFulltimeAdminWeight) {
        this.figureHrFulltimeAdminWeight = figureHrFulltimeAdminWeight;
    }

    /**
     * 获取三级指标：全职员工-销售
     *
     * @return figure_hr_fulltime_saler_weight - 三级指标：全职员工-销售
     */
    public Double getFigureHrFulltimeSalerWeight() {
        return figureHrFulltimeSalerWeight;
    }

    /**
     * 设置三级指标：全职员工-销售
     *
     * @param figureHrFulltimeSalerWeight 三级指标：全职员工-销售
     */
    public void setFigureHrFulltimeSalerWeight(Double figureHrFulltimeSalerWeight) {
        this.figureHrFulltimeSalerWeight = figureHrFulltimeSalerWeight;
    }

    /**
     * 获取二级指标：高学历人员
     *
     * @return figure_hr_educated_weight - 二级指标：高学历人员
     */
    public Double getFigureHrEducatedWeight() {
        return figureHrEducatedWeight;
    }

    /**
     * 设置二级指标：高学历人员
     *
     * @param figureHrEducatedWeight 二级指标：高学历人员
     */
    public void setFigureHrEducatedWeight(Double figureHrEducatedWeight) {
        this.figureHrEducatedWeight = figureHrEducatedWeight;
    }

    /**
     * 获取三级指标：高学历人员-博士
     *
     * @return figure_hr_educated_doc_weight - 三级指标：高学历人员-博士
     */
    public Double getFigureHrEducatedDocWeight() {
        return figureHrEducatedDocWeight;
    }

    /**
     * 设置三级指标：高学历人员-博士
     *
     * @param figureHrEducatedDocWeight 三级指标：高学历人员-博士
     */
    public void setFigureHrEducatedDocWeight(Double figureHrEducatedDocWeight) {
        this.figureHrEducatedDocWeight = figureHrEducatedDocWeight;
    }

    /**
     * 获取三级指标：高学历人员-硕士
     *
     * @return figure_hr_educated_master_weight - 三级指标：高学历人员-硕士
     */
    public Double getFigureHrEducatedMasterWeight() {
        return figureHrEducatedMasterWeight;
    }

    /**
     * 设置三级指标：高学历人员-硕士
     *
     * @param figureHrEducatedMasterWeight 三级指标：高学历人员-硕士
     */
    public void setFigureHrEducatedMasterWeight(Double figureHrEducatedMasterWeight) {
        this.figureHrEducatedMasterWeight = figureHrEducatedMasterWeight;
    }

    /**
     * 获取三级指标：高学历人员-学士
     *
     * @return figure_hr_bachelor_weight - 三级指标：高学历人员-学士
     */
    public Double getFigureHrBachelorWeight() {
        return figureHrBachelorWeight;
    }

    /**
     * 设置三级指标：高学历人员-学士
     *
     * @param figureHrBachelorWeight 三级指标：高学历人员-学士
     */
    public void setFigureHrBachelorWeight(Double figureHrBachelorWeight) {
        this.figureHrBachelorWeight = figureHrBachelorWeight;
    }

    /**
     * 获取一级指标：创新指数
     *
     * @return figure_innovate_weight - 一级指标：创新指数
     */
    public Double getFigureInnovateWeight() {
        return figureInnovateWeight;
    }

    /**
     * 设置一级指标：创新指数
     *
     * @param figureInnovateWeight 一级指标：创新指数
     */
    public void setFigureInnovateWeight(Double figureInnovateWeight) {
        this.figureInnovateWeight = figureInnovateWeight;
    }

    /**
     * 获取二级指标：专利申请
     *
     * @return figure_innovate_patent_apply_weight - 二级指标：专利申请
     */
    public Double getFigureInnovatePatentApplyWeight() {
        return figureInnovatePatentApplyWeight;
    }

    /**
     * 设置二级指标：专利申请
     *
     * @param figureInnovatePatentApplyWeight 二级指标：专利申请
     */
    public void setFigureInnovatePatentApplyWeight(Double figureInnovatePatentApplyWeight) {
        this.figureInnovatePatentApplyWeight = figureInnovatePatentApplyWeight;
    }

    /**
     * 获取三级指标：专利申请-发明
     *
     * @return figure_innovate_patent_apply_invention_weight - 三级指标：专利申请-发明
     */
    public Double getFigureInnovatePatentApplyInventionWeight() {
        return figureInnovatePatentApplyInventionWeight;
    }

    /**
     * 设置三级指标：专利申请-发明
     *
     * @param figureInnovatePatentApplyInventionWeight 三级指标：专利申请-发明
     */
    public void setFigureInnovatePatentApplyInventionWeight(Double figureInnovatePatentApplyInventionWeight) {
        this.figureInnovatePatentApplyInventionWeight = figureInnovatePatentApplyInventionWeight;
    }

    /**
     * 获取三级指标：专利申请-实用新型
     *
     * @return figure_innovate_patent_apply_utility_weight - 三级指标：专利申请-实用新型
     */
    public Double getFigureInnovatePatentApplyUtilityWeight() {
        return figureInnovatePatentApplyUtilityWeight;
    }

    /**
     * 设置三级指标：专利申请-实用新型
     *
     * @param figureInnovatePatentApplyUtilityWeight 三级指标：专利申请-实用新型
     */
    public void setFigureInnovatePatentApplyUtilityWeight(Double figureInnovatePatentApplyUtilityWeight) {
        this.figureInnovatePatentApplyUtilityWeight = figureInnovatePatentApplyUtilityWeight;
    }

    /**
     * 获取三级指标：专利申请-外观设计
     *
     * @return figure_innovate_patent_apply_appear_weight - 三级指标：专利申请-外观设计
     */
    public Double getFigureInnovatePatentApplyAppearWeight() {
        return figureInnovatePatentApplyAppearWeight;
    }

    /**
     * 设置三级指标：专利申请-外观设计
     *
     * @param figureInnovatePatentApplyAppearWeight 三级指标：专利申请-外观设计
     */
    public void setFigureInnovatePatentApplyAppearWeight(Double figureInnovatePatentApplyAppearWeight) {
        this.figureInnovatePatentApplyAppearWeight = figureInnovatePatentApplyAppearWeight;
    }

    /**
     * 获取二级指标：专利授权
     *
     * @return figure_innovate_patent_grant_weight - 二级指标：专利授权
     */
    public Double getFigureInnovatePatentGrantWeight() {
        return figureInnovatePatentGrantWeight;
    }

    /**
     * 设置二级指标：专利授权
     *
     * @param figureInnovatePatentGrantWeight 二级指标：专利授权
     */
    public void setFigureInnovatePatentGrantWeight(Double figureInnovatePatentGrantWeight) {
        this.figureInnovatePatentGrantWeight = figureInnovatePatentGrantWeight;
    }

    /**
     * 获取三级指标：专利授权-发明
     *
     * @return figure_innovate_patent_grant_invention_weight - 三级指标：专利授权-发明
     */
    public Double getFigureInnovatePatentGrantInventionWeight() {
        return figureInnovatePatentGrantInventionWeight;
    }

    /**
     * 设置三级指标：专利授权-发明
     *
     * @param figureInnovatePatentGrantInventionWeight 三级指标：专利授权-发明
     */
    public void setFigureInnovatePatentGrantInventionWeight(Double figureInnovatePatentGrantInventionWeight) {
        this.figureInnovatePatentGrantInventionWeight = figureInnovatePatentGrantInventionWeight;
    }

    /**
     * 获取三级指标：专利授权-实用新型
     *
     * @return figure_innovate_patent_grant_utility_weight - 三级指标：专利授权-实用新型
     */
    public Double getFigureInnovatePatentGrantUtilityWeight() {
        return figureInnovatePatentGrantUtilityWeight;
    }

    /**
     * 设置三级指标：专利授权-实用新型
     *
     * @param figureInnovatePatentGrantUtilityWeight 三级指标：专利授权-实用新型
     */
    public void setFigureInnovatePatentGrantUtilityWeight(Double figureInnovatePatentGrantUtilityWeight) {
        this.figureInnovatePatentGrantUtilityWeight = figureInnovatePatentGrantUtilityWeight;
    }

    /**
     * 获取三级指标：专利授权-外观设计
     *
     * @return figure_innovate_patent_grant_appear_weight - 三级指标：专利授权-外观设计
     */
    public Double getFigureInnovatePatentGrantAppearWeight() {
        return figureInnovatePatentGrantAppearWeight;
    }

    /**
     * 设置三级指标：专利授权-外观设计
     *
     * @param figureInnovatePatentGrantAppearWeight 三级指标：专利授权-外观设计
     */
    public void setFigureInnovatePatentGrantAppearWeight(Double figureInnovatePatentGrantAppearWeight) {
        this.figureInnovatePatentGrantAppearWeight = figureInnovatePatentGrantAppearWeight;
    }

    /**
     * 获取二级指标：著作权申请
     *
     * @return figure_innovate_copyright_apply_weight - 二级指标：著作权申请
     */
    public Double getFigureInnovateCopyrightApplyWeight() {
        return figureInnovateCopyrightApplyWeight;
    }

    /**
     * 设置二级指标：著作权申请
     *
     * @param figureInnovateCopyrightApplyWeight 二级指标：著作权申请
     */
    public void setFigureInnovateCopyrightApplyWeight(Double figureInnovateCopyrightApplyWeight) {
        this.figureInnovateCopyrightApplyWeight = figureInnovateCopyrightApplyWeight;
    }

    /**
     * 获取三级指标：著作权申请-软件类
     *
     * @return figure_innovate_copyright_apply_soft_weight - 三级指标：著作权申请-软件类
     */
    public Double getFigureInnovateCopyrightApplySoftWeight() {
        return figureInnovateCopyrightApplySoftWeight;
    }

    /**
     * 设置三级指标：著作权申请-软件类
     *
     * @param figureInnovateCopyrightApplySoftWeight 三级指标：著作权申请-软件类
     */
    public void setFigureInnovateCopyrightApplySoftWeight(Double figureInnovateCopyrightApplySoftWeight) {
        this.figureInnovateCopyrightApplySoftWeight = figureInnovateCopyrightApplySoftWeight;
    }

    /**
     * 获取三级指标：著作权申请-非软件类
     *
     * @return figure_innovate_copyright_apply_unsoft_weight - 三级指标：著作权申请-非软件类
     */
    public Double getFigureInnovateCopyrightApplyUnsoftWeight() {
        return figureInnovateCopyrightApplyUnsoftWeight;
    }

    /**
     * 设置三级指标：著作权申请-非软件类
     *
     * @param figureInnovateCopyrightApplyUnsoftWeight 三级指标：著作权申请-非软件类
     */
    public void setFigureInnovateCopyrightApplyUnsoftWeight(Double figureInnovateCopyrightApplyUnsoftWeight) {
        this.figureInnovateCopyrightApplyUnsoftWeight = figureInnovateCopyrightApplyUnsoftWeight;
    }

    /**
     * 获取二级指标：著作权授权
     *
     * @return figure_innovate_copyright_grant_weight - 二级指标：著作权授权
     */
    public Double getFigureInnovateCopyrightGrantWeight() {
        return figureInnovateCopyrightGrantWeight;
    }

    /**
     * 设置二级指标：著作权授权
     *
     * @param figureInnovateCopyrightGrantWeight 二级指标：著作权授权
     */
    public void setFigureInnovateCopyrightGrantWeight(Double figureInnovateCopyrightGrantWeight) {
        this.figureInnovateCopyrightGrantWeight = figureInnovateCopyrightGrantWeight;
    }

    /**
     * 获取三级指标：著作权授权-软件类
     *
     * @return figure_innovate_copyright_grant_soft_weight - 三级指标：著作权授权-软件类
     */
    public Double getFigureInnovateCopyrightGrantSoftWeight() {
        return figureInnovateCopyrightGrantSoftWeight;
    }

    /**
     * 设置三级指标：著作权授权-软件类
     *
     * @param figureInnovateCopyrightGrantSoftWeight 三级指标：著作权授权-软件类
     */
    public void setFigureInnovateCopyrightGrantSoftWeight(Double figureInnovateCopyrightGrantSoftWeight) {
        this.figureInnovateCopyrightGrantSoftWeight = figureInnovateCopyrightGrantSoftWeight;
    }

    /**
     * 获取三级指标：著作权授权-非软件类
     *
     * @return figure_innovate_copyright_grant_unsoft_weight - 三级指标：著作权授权-非软件类
     */
    public Double getFigureInnovateCopyrightGrantUnsoftWeight() {
        return figureInnovateCopyrightGrantUnsoftWeight;
    }

    /**
     * 设置三级指标：著作权授权-非软件类
     *
     * @param figureInnovateCopyrightGrantUnsoftWeight 三级指标：著作权授权-非软件类
     */
    public void setFigureInnovateCopyrightGrantUnsoftWeight(Double figureInnovateCopyrightGrantUnsoftWeight) {
        this.figureInnovateCopyrightGrantUnsoftWeight = figureInnovateCopyrightGrantUnsoftWeight;
    }

    /**
     * 获取二级指标：新产品/服务
     *
     * @return figure_innovate_new_product_weight - 二级指标：新产品/服务
     */
    public Double getFigureInnovateNewProductWeight() {
        return figureInnovateNewProductWeight;
    }

    /**
     * 设置二级指标：新产品/服务
     *
     * @param figureInnovateNewProductWeight 二级指标：新产品/服务
     */
    public void setFigureInnovateNewProductWeight(Double figureInnovateNewProductWeight) {
        this.figureInnovateNewProductWeight = figureInnovateNewProductWeight;
    }

    /**
     * 获取三级指标：新产品/服务-专利类
     *
     * @return figure_innovate_new_product_patent_weight - 三级指标：新产品/服务-专利类
     */
    public Double getFigureInnovateNewProductPatentWeight() {
        return figureInnovateNewProductPatentWeight;
    }

    /**
     * 设置三级指标：新产品/服务-专利类
     *
     * @param figureInnovateNewProductPatentWeight 三级指标：新产品/服务-专利类
     */
    public void setFigureInnovateNewProductPatentWeight(Double figureInnovateNewProductPatentWeight) {
        this.figureInnovateNewProductPatentWeight = figureInnovateNewProductPatentWeight;
    }

    /**
     * 获取三级指标：新产品/服务-专用技术
     *
     * @return figure_innovate_new_product_tech_weight - 三级指标：新产品/服务-专用技术
     */
    public Double getFigureInnovateNewProductTechWeight() {
        return figureInnovateNewProductTechWeight;
    }

    /**
     * 设置三级指标：新产品/服务-专用技术
     *
     * @param figureInnovateNewProductTechWeight 三级指标：新产品/服务-专用技术
     */
    public void setFigureInnovateNewProductTechWeight(Double figureInnovateNewProductTechWeight) {
        this.figureInnovateNewProductTechWeight = figureInnovateNewProductTechWeight;
    }

    /**
     * 获取三级指标：新产品/服务-商业模式
     *
     * @return figure_innovate_new_product_bus_weight - 三级指标：新产品/服务-商业模式
     */
    public Double getFigureInnovateNewProductBusWeight() {
        return figureInnovateNewProductBusWeight;
    }

    /**
     * 设置三级指标：新产品/服务-商业模式
     *
     * @param figureInnovateNewProductBusWeight 三级指标：新产品/服务-商业模式
     */
    public void setFigureInnovateNewProductBusWeight(Double figureInnovateNewProductBusWeight) {
        this.figureInnovateNewProductBusWeight = figureInnovateNewProductBusWeight;
    }

    /**
     * 获取一级指标：薪酬指数
     *
     * @return figure_salary_weight - 一级指标：薪酬指数
     */
    public Double getFigureSalaryWeight() {
        return figureSalaryWeight;
    }

    /**
     * 设置一级指标：薪酬指数
     *
     * @param figureSalaryWeight 一级指标：薪酬指数
     */
    public void setFigureSalaryWeight(Double figureSalaryWeight) {
        this.figureSalaryWeight = figureSalaryWeight;
    }

    /**
     * 获取二级指标：员工工资额
     *
     * @return figure_salary_staff_weight - 二级指标：员工工资额
     */
    public Double getFigureSalaryStaffWeight() {
        return figureSalaryStaffWeight;
    }

    /**
     * 设置二级指标：员工工资额
     *
     * @param figureSalaryStaffWeight 二级指标：员工工资额
     */
    public void setFigureSalaryStaffWeight(Double figureSalaryStaffWeight) {
        this.figureSalaryStaffWeight = figureSalaryStaffWeight;
    }

    /**
     * 获取三级指标：员工工资额-1万元以上
     *
     * @return figure_salary_staff_up_10_weight - 三级指标：员工工资额-1万元以上
     */
    public Double getFigureSalaryStaffUp10Weight() {
        return figureSalaryStaffUp10Weight;
    }

    /**
     * 设置三级指标：员工工资额-1万元以上
     *
     * @param figureSalaryStaffUp10Weight 三级指标：员工工资额-1万元以上
     */
    public void setFigureSalaryStaffUp10Weight(Double figureSalaryStaffUp10Weight) {
        this.figureSalaryStaffUp10Weight = figureSalaryStaffUp10Weight;
    }

    /**
     * 获取三级指标：员工工资额-5千到1万
     *
     * @return figure_salary_staff_5_10_weight - 三级指标：员工工资额-5千到1万
     */
    public Double getFigureSalaryStaff510Weight() {
        return figureSalaryStaff510Weight;
    }

    /**
     * 设置三级指标：员工工资额-5千到1万
     *
     * @param figureSalaryStaff510Weight 三级指标：员工工资额-5千到1万
     */
    public void setFigureSalaryStaff510Weight(Double figureSalaryStaff510Weight) {
        this.figureSalaryStaff510Weight = figureSalaryStaff510Weight;
    }

    /**
     * 获取三级指标：员工工资额-5千以下
     *
     * @return figure_salary_staff_down_5_weight - 三级指标：员工工资额-5千以下
     */
    public Double getFigureSalaryStaffDown5Weight() {
        return figureSalaryStaffDown5Weight;
    }

    /**
     * 设置三级指标：员工工资额-5千以下
     *
     * @param figureSalaryStaffDown5Weight 三级指标：员工工资额-5千以下
     */
    public void setFigureSalaryStaffDown5Weight(Double figureSalaryStaffDown5Weight) {
        this.figureSalaryStaffDown5Weight = figureSalaryStaffDown5Weight;
    }

    /**
     * 获取二级指标：员工贡献率
     *
     * @return figure_salary_staff_contribution_weight - 二级指标：员工贡献率
     */
    public Double getFigureSalaryStaffContributionWeight() {
        return figureSalaryStaffContributionWeight;
    }

    /**
     * 设置二级指标：员工贡献率
     *
     * @param figureSalaryStaffContributionWeight 二级指标：员工贡献率
     */
    public void setFigureSalaryStaffContributionWeight(Double figureSalaryStaffContributionWeight) {
        this.figureSalaryStaffContributionWeight = figureSalaryStaffContributionWeight;
    }

    /**
     * 获取三级指标：员工贡献率-人均销售
     *
     * @return figure_salary_staff_contribution_meansale_weight - 三级指标：员工贡献率-人均销售
     */
    public Double getFigureSalaryStaffContributionMeansaleWeight() {
        return figureSalaryStaffContributionMeansaleWeight;
    }

    /**
     * 设置三级指标：员工贡献率-人均销售
     *
     * @param figureSalaryStaffContributionMeansaleWeight 三级指标：员工贡献率-人均销售
     */
    public void setFigureSalaryStaffContributionMeansaleWeight(Double figureSalaryStaffContributionMeansaleWeight) {
        this.figureSalaryStaffContributionMeansaleWeight = figureSalaryStaffContributionMeansaleWeight;
    }

    /**
     * 获取三级指标：员工贡献率-人均纳税
     *
     * @return figure_salary_staff_contribution_meantax_weight - 三级指标：员工贡献率-人均纳税
     */
    public Double getFigureSalaryStaffContributionMeantaxWeight() {
        return figureSalaryStaffContributionMeantaxWeight;
    }

    /**
     * 设置三级指标：员工贡献率-人均纳税
     *
     * @param figureSalaryStaffContributionMeantaxWeight 三级指标：员工贡献率-人均纳税
     */
    public void setFigureSalaryStaffContributionMeantaxWeight(Double figureSalaryStaffContributionMeantaxWeight) {
        this.figureSalaryStaffContributionMeantaxWeight = figureSalaryStaffContributionMeantaxWeight;
    }

    /**
     * 获取一级指标：学习指数
     *
     * @return figure_learn_weight - 一级指标：学习指数
     */
    public Double getFigureLearnWeight() {
        return figureLearnWeight;
    }

    /**
     * 设置一级指标：学习指数
     *
     * @param figureLearnWeight 一级指标：学习指数
     */
    public void setFigureLearnWeight(Double figureLearnWeight) {
        this.figureLearnWeight = figureLearnWeight;
    }

    /**
     * 获取二级指标：参加培训的次数
     *
     * @return figure_learn_train_weight - 二级指标：参加培训的次数
     */
    public Double getFigureLearnTrainWeight() {
        return figureLearnTrainWeight;
    }

    /**
     * 设置二级指标：参加培训的次数
     *
     * @param figureLearnTrainWeight 二级指标：参加培训的次数
     */
    public void setFigureLearnTrainWeight(Double figureLearnTrainWeight) {
        this.figureLearnTrainWeight = figureLearnTrainWeight;
    }

    /**
     * 获取三级指标：参加培训的次数-管理类
     *
     * @return figure_learn_train_manage_weight - 三级指标：参加培训的次数-管理类
     */
    public Double getFigureLearnTrainManageWeight() {
        return figureLearnTrainManageWeight;
    }

    /**
     * 设置三级指标：参加培训的次数-管理类
     *
     * @param figureLearnTrainManageWeight 三级指标：参加培训的次数-管理类
     */
    public void setFigureLearnTrainManageWeight(Double figureLearnTrainManageWeight) {
        this.figureLearnTrainManageWeight = figureLearnTrainManageWeight;
    }

    /**
     * 获取三级指标：参加培训的次数-政策法规
     *
     * @return figure_learn_train_policy_weight - 三级指标：参加培训的次数-政策法规
     */
    public Double getFigureLearnTrainPolicyWeight() {
        return figureLearnTrainPolicyWeight;
    }

    /**
     * 设置三级指标：参加培训的次数-政策法规
     *
     * @param figureLearnTrainPolicyWeight 三级指标：参加培训的次数-政策法规
     */
    public void setFigureLearnTrainPolicyWeight(Double figureLearnTrainPolicyWeight) {
        this.figureLearnTrainPolicyWeight = figureLearnTrainPolicyWeight;
    }

    /**
     * 获取三级指标：参加培训的次数-技能类
     *
     * @return figure_learn_train_skill_weight - 三级指标：参加培训的次数-技能类
     */
    public Double getFigureLearnTrainSkillWeight() {
        return figureLearnTrainSkillWeight;
    }

    /**
     * 设置三级指标：参加培训的次数-技能类
     *
     * @param figureLearnTrainSkillWeight 三级指标：参加培训的次数-技能类
     */
    public void setFigureLearnTrainSkillWeight(Double figureLearnTrainSkillWeight) {
        this.figureLearnTrainSkillWeight = figureLearnTrainSkillWeight;
    }

    /**
     * 获取二级指标：接受咨询的次数
     *
     * @return figure_learn_conslted_weight - 二级指标：接受咨询的次数
     */
    public Double getFigureLearnConsltedWeight() {
        return figureLearnConsltedWeight;
    }

    /**
     * 设置二级指标：接受咨询的次数
     *
     * @param figureLearnConsltedWeight 二级指标：接受咨询的次数
     */
    public void setFigureLearnConsltedWeight(Double figureLearnConsltedWeight) {
        this.figureLearnConsltedWeight = figureLearnConsltedWeight;
    }

    /**
     * 获取三级指标：接受咨询的次数-管理类
     *
     * @return figure_learn_conslted_manage_weight - 三级指标：接受咨询的次数-管理类
     */
    public Double getFigureLearnConsltedManageWeight() {
        return figureLearnConsltedManageWeight;
    }

    /**
     * 设置三级指标：接受咨询的次数-管理类
     *
     * @param figureLearnConsltedManageWeight 三级指标：接受咨询的次数-管理类
     */
    public void setFigureLearnConsltedManageWeight(Double figureLearnConsltedManageWeight) {
        this.figureLearnConsltedManageWeight = figureLearnConsltedManageWeight;
    }

    /**
     * 获取三级指标：接受咨询的次数-政策法规
     *
     * @return figure_learn_conslted_policy_weight - 三级指标：接受咨询的次数-政策法规
     */
    public Double getFigureLearnConsltedPolicyWeight() {
        return figureLearnConsltedPolicyWeight;
    }

    /**
     * 设置三级指标：接受咨询的次数-政策法规
     *
     * @param figureLearnConsltedPolicyWeight 三级指标：接受咨询的次数-政策法规
     */
    public void setFigureLearnConsltedPolicyWeight(Double figureLearnConsltedPolicyWeight) {
        this.figureLearnConsltedPolicyWeight = figureLearnConsltedPolicyWeight;
    }

    /**
     * 获取三级指标：接受咨询的次数-技能类
     *
     * @return figure_learn_conslted_skill_weight - 三级指标：接受咨询的次数-技能类
     */
    public Double getFigureLearnConsltedSkillWeight() {
        return figureLearnConsltedSkillWeight;
    }

    /**
     * 设置三级指标：接受咨询的次数-技能类
     *
     * @param figureLearnConsltedSkillWeight 三级指标：接受咨询的次数-技能类
     */
    public void setFigureLearnConsltedSkillWeight(Double figureLearnConsltedSkillWeight) {
        this.figureLearnConsltedSkillWeight = figureLearnConsltedSkillWeight;
    }

    /**
     * 获取一级指标：品牌指数
     *
     * @return figure_brand_weight - 一级指标：品牌指数
     */
    public Double getFigureBrandWeight() {
        return figureBrandWeight;
    }

    /**
     * 设置一级指标：品牌指数
     *
     * @param figureBrandWeight 一级指标：品牌指数
     */
    public void setFigureBrandWeight(Double figureBrandWeight) {
        this.figureBrandWeight = figureBrandWeight;
    }

    /**
     * 获取二级指标：企业获奖
     *
     * @return figure_brand_reward_weight - 二级指标：企业获奖
     */
    public Double getFigureBrandRewardWeight() {
        return figureBrandRewardWeight;
    }

    /**
     * 设置二级指标：企业获奖
     *
     * @param figureBrandRewardWeight 二级指标：企业获奖
     */
    public void setFigureBrandRewardWeight(Double figureBrandRewardWeight) {
        this.figureBrandRewardWeight = figureBrandRewardWeight;
    }

    /**
     * 获取三级指标：企业获奖-区级
     *
     * @return figure_brand_reward_area_weight - 三级指标：企业获奖-区级
     */
    public Double getFigureBrandRewardAreaWeight() {
        return figureBrandRewardAreaWeight;
    }

    /**
     * 设置三级指标：企业获奖-区级
     *
     * @param figureBrandRewardAreaWeight 三级指标：企业获奖-区级
     */
    public void setFigureBrandRewardAreaWeight(Double figureBrandRewardAreaWeight) {
        this.figureBrandRewardAreaWeight = figureBrandRewardAreaWeight;
    }

    /**
     * 获取三级指标：企业获奖-市级
     *
     * @return figure_brand_reward_city_weight - 三级指标：企业获奖-市级
     */
    public Double getFigureBrandRewardCityWeight() {
        return figureBrandRewardCityWeight;
    }

    /**
     * 设置三级指标：企业获奖-市级
     *
     * @param figureBrandRewardCityWeight 三级指标：企业获奖-市级
     */
    public void setFigureBrandRewardCityWeight(Double figureBrandRewardCityWeight) {
        this.figureBrandRewardCityWeight = figureBrandRewardCityWeight;
    }

    /**
     * 获取三级指标：企业获奖-省级
     *
     * @return figure_brand_reward_province_weight - 三级指标：企业获奖-省级
     */
    public Double getFigureBrandRewardProvinceWeight() {
        return figureBrandRewardProvinceWeight;
    }

    /**
     * 设置三级指标：企业获奖-省级
     *
     * @param figureBrandRewardProvinceWeight 三级指标：企业获奖-省级
     */
    public void setFigureBrandRewardProvinceWeight(Double figureBrandRewardProvinceWeight) {
        this.figureBrandRewardProvinceWeight = figureBrandRewardProvinceWeight;
    }

    /**
     * 获取三级指标：企业获奖-国家级
     *
     * @return figure_brand_reward_country_weight - 三级指标：企业获奖-国家级
     */
    public Double getFigureBrandRewardCountryWeight() {
        return figureBrandRewardCountryWeight;
    }

    /**
     * 设置三级指标：企业获奖-国家级
     *
     * @param figureBrandRewardCountryWeight 三级指标：企业获奖-国家级
     */
    public void setFigureBrandRewardCountryWeight(Double figureBrandRewardCountryWeight) {
        this.figureBrandRewardCountryWeight = figureBrandRewardCountryWeight;
    }

    /**
     * 获取二级指标：企业认定
     *
     * @return figure_brand_recognition_weight - 二级指标：企业认定
     */
    public Double getFigureBrandRecognitionWeight() {
        return figureBrandRecognitionWeight;
    }

    /**
     * 设置二级指标：企业认定
     *
     * @param figureBrandRecognitionWeight 二级指标：企业认定
     */
    public void setFigureBrandRecognitionWeight(Double figureBrandRecognitionWeight) {
        this.figureBrandRecognitionWeight = figureBrandRecognitionWeight;
    }

    /**
     * 获取三级指标：企业认定-区级
     *
     * @return figure_brand_recognition_area_weight - 三级指标：企业认定-区级
     */
    public Double getFigureBrandRecognitionAreaWeight() {
        return figureBrandRecognitionAreaWeight;
    }

    /**
     * 设置三级指标：企业认定-区级
     *
     * @param figureBrandRecognitionAreaWeight 三级指标：企业认定-区级
     */
    public void setFigureBrandRecognitionAreaWeight(Double figureBrandRecognitionAreaWeight) {
        this.figureBrandRecognitionAreaWeight = figureBrandRecognitionAreaWeight;
    }

    /**
     * 获取三级指标：企业认定-市级
     *
     * @return figure_brand_recognition_city_weight - 三级指标：企业认定-市级
     */
    public Double getFigureBrandRecognitionCityWeight() {
        return figureBrandRecognitionCityWeight;
    }

    /**
     * 设置三级指标：企业认定-市级
     *
     * @param figureBrandRecognitionCityWeight 三级指标：企业认定-市级
     */
    public void setFigureBrandRecognitionCityWeight(Double figureBrandRecognitionCityWeight) {
        this.figureBrandRecognitionCityWeight = figureBrandRecognitionCityWeight;
    }

    /**
     * 获取三级指标：企业认定-省级
     *
     * @return figure_brand_recognition_province_weight - 三级指标：企业认定-省级
     */
    public Double getFigureBrandRecognitionProvinceWeight() {
        return figureBrandRecognitionProvinceWeight;
    }

    /**
     * 设置三级指标：企业认定-省级
     *
     * @param figureBrandRecognitionProvinceWeight 三级指标：企业认定-省级
     */
    public void setFigureBrandRecognitionProvinceWeight(Double figureBrandRecognitionProvinceWeight) {
        this.figureBrandRecognitionProvinceWeight = figureBrandRecognitionProvinceWeight;
    }

    /**
     * 获取三级指标：企业认定-国家级
     *
     * @return figure_brand_recognition_country_weight - 三级指标：企业认定-国家级
     */
    public Double getFigureBrandRecognitionCountryWeight() {
        return figureBrandRecognitionCountryWeight;
    }

    /**
     * 设置三级指标：企业认定-国家级
     *
     * @param figureBrandRecognitionCountryWeight 三级指标：企业认定-国家级
     */
    public void setFigureBrandRecognitionCountryWeight(Double figureBrandRecognitionCountryWeight) {
        this.figureBrandRecognitionCountryWeight = figureBrandRecognitionCountryWeight;
    }

    /**
     * 获取二级指标：人才资助
     *
     * @return figure_brand_talent_weight - 二级指标：人才资助
     */
    public Double getFigureBrandTalentWeight() {
        return figureBrandTalentWeight;
    }

    /**
     * 设置二级指标：人才资助
     *
     * @param figureBrandTalentWeight 二级指标：人才资助
     */
    public void setFigureBrandTalentWeight(Double figureBrandTalentWeight) {
        this.figureBrandTalentWeight = figureBrandTalentWeight;
    }

    /**
     * 获取三级指标：人才资助-区级
     *
     * @return figure_brand_talent_area_weight - 三级指标：人才资助-区级
     */
    public Double getFigureBrandTalentAreaWeight() {
        return figureBrandTalentAreaWeight;
    }

    /**
     * 设置三级指标：人才资助-区级
     *
     * @param figureBrandTalentAreaWeight 三级指标：人才资助-区级
     */
    public void setFigureBrandTalentAreaWeight(Double figureBrandTalentAreaWeight) {
        this.figureBrandTalentAreaWeight = figureBrandTalentAreaWeight;
    }

    /**
     * 获取三级指标：人才资助-市级
     *
     * @return figure_brand_talent_city_weight - 三级指标：人才资助-市级
     */
    public Double getFigureBrandTalentCityWeight() {
        return figureBrandTalentCityWeight;
    }

    /**
     * 设置三级指标：人才资助-市级
     *
     * @param figureBrandTalentCityWeight 三级指标：人才资助-市级
     */
    public void setFigureBrandTalentCityWeight(Double figureBrandTalentCityWeight) {
        this.figureBrandTalentCityWeight = figureBrandTalentCityWeight;
    }

    /**
     * 获取三级指标：人才资助-省级
     *
     * @return figure_brand_talent_province_weight - 三级指标：人才资助-省级
     */
    public Double getFigureBrandTalentProvinceWeight() {
        return figureBrandTalentProvinceWeight;
    }

    /**
     * 设置三级指标：人才资助-省级
     *
     * @param figureBrandTalentProvinceWeight 三级指标：人才资助-省级
     */
    public void setFigureBrandTalentProvinceWeight(Double figureBrandTalentProvinceWeight) {
        this.figureBrandTalentProvinceWeight = figureBrandTalentProvinceWeight;
    }

    /**
     * 获取三级指标：人才资助-国家级
     *
     * @return figure_brand_talent_country_weight - 三级指标：人才资助-国家级
     */
    public Double getFigureBrandTalentCountryWeight() {
        return figureBrandTalentCountryWeight;
    }

    /**
     * 设置三级指标：人才资助-国家级
     *
     * @param figureBrandTalentCountryWeight 三级指标：人才资助-国家级
     */
    public void setFigureBrandTalentCountryWeight(Double figureBrandTalentCountryWeight) {
        this.figureBrandTalentCountryWeight = figureBrandTalentCountryWeight;
    }
}