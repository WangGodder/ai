package com.swu.ai.entity;

import javax.persistence.*;

@Table(name = "finger_weight")
public class FingerWeight {
    @Id
    private Long id;

    @Column(name = "finger_sale_weight")
    private Double fingerSaleWeight;

    @Column(name = "finger_sale_invoice_weight")
    private Double fingerSaleInvoiceWeight;

    @Column(name = "finger_sale_invoice_soft_weight")
    private Double fingerSaleInvoiceSoftWeight;

    /**
     * 已开发票的收入-硬件产品
     */
    @Column(name = "finger_sale_invoice_hard_weight")
    private Double fingerSaleInvoiceHardWeight;

    /**
     * 已开发票的收入-咨询服务
     */
    @Column(name = "finger_sale_invoice_consultation_weight")
    private Double fingerSaleInvoiceConsultationWeight;

    /**
     * 已开发票的收入-其他
     */
    @Column(name = "finger_sale_invoice_other_weight")
    private Double fingerSaleInvoiceOtherWeight;

    /**
     * 二级指标：合同确认额
     */
    @Column(name = "finger_sale_contract_weight")
    private Double fingerSaleContractWeight;

    /**
     * 三级指标：合同确认额-软件产品
     */
    @Column(name = "finger_sale_contract_soft_weight")
    private Double fingerSaleContractSoftWeight;

    /**
     * 三级指标：合同确认额-硬件产品
     */
    @Column(name = "finger_sale_contract_hard_weight")
    private Double fingerSaleContractHardWeight;

    /**
     * 三级指标：合同确认额-咨询服务
     */
    @Column(name = "finger_sale_contract_consultation_weight")
    private Double fingerSaleContractConsultationWeight;

    /**
     * 三级指标：合同确认额-其他
     */
    @Column(name = "finger_sale_contract_other_weight")
    private Double fingerSaleContractOtherWeight;

    /**
     * 一级指标：纳税指数
     */
    @Column(name = "finger_tax_weight")
    private Double fingerTaxWeight;

    /**
     * 二级指标：企业所得税
     */
    @Column(name = "finger_tax_corporate_weight")
    private Double fingerTaxCorporateWeight;

    /**
     * 三级指标：企业所得税-应纳税值
     */
    @Column(name = "finger_tax_corporate_taxable_weight")
    private Double fingerTaxCorporateTaxableWeight;

    /**
     * 三级指标：企业所得税-税收减免值
     */
    @Column(name = "finger_tax_corporate_relief_weight")
    private Double fingerTaxCorporateReliefWeight;

    /**
     * 二级指标：个人所得税
     */
    @Column(name = "finger_tax_individual_weight")
    private Double fingerTaxIndividualWeight;

    /**
     * 三级指标：个人所得税-应纳税值
     */
    @Column(name = "finger_tax_individual_taxable_weight")
    private Double fingerTaxIndividualTaxableWeight;

    /**
     * 三级指标：个人所得税-税收减免
     */
    @Column(name = "finger_tax_individual_relief_weight")
    private Double fingerTaxIndividualReliefWeight;

    /**
     * 二级指标：增值税
     */
    @Column(name = "finger_tax_added_weight")
    private Double fingerTaxAddedWeight;

    /**
     * 三级指标：增值税-应纳税值
     */
    @Column(name = "finger_tax_added_taxable_weight")
    private Double fingerTaxAddedTaxableWeight;

    /**
     * 三级指标：增值税-税收减免
     */
    @Column(name = "finger_tax_added_relief_weight")
    private Double fingerTaxAddedReliefWeight;

    /**
     * 一级指标：融资指数
     */
    @Column(name = "finger_finance_weight")
    private Double fingerFinanceWeight;

    /**
     * 二级指标：股权类融资
     */
    @Column(name = "finger_finance_stock_weight")
    private Double fingerFinanceStockWeight;

    /**
     * 三级指标：股权类融资-风投机构
     */
    @Column(name = "finger_finance_stock_risk_weight")
    private Double fingerFinanceStockRiskWeight;

    /**
     * 三级指标：股权类融资-政府企业
     */
    @Column(name = "finger_finance_stock_gov_weight")
    private Double fingerFinanceStockGovWeight;

    /**
     * 三级指标：股权类融资-个人
     */
    @Column(name = "finger_finance_stock_person_weight")
    private Double fingerFinanceStockPersonWeight;

    /**
     * 二级指标：债务类融资
     */
    @Column(name = "finger_finance_debt_weight")
    private Double fingerFinanceDebtWeight;

    /**
     * 三级指标：债务类融资-银行
     */
    @Column(name = "finger_finance_debt_bank_weight")
    private Double fingerFinanceDebtBankWeight;

    /**
     * 三级指标：债务类融资-新型贷款机构
     */
    @Column(name = "finger_finance_debt_new_weight")
    private Double fingerFinanceDebtNewWeight;

    /**
     * 三级指标：债务类融资-企业拆借
     */
    @Column(name = "finger_finance_debt_lending_weight")
    private Double fingerFinanceDebtLendingWeight;

    /**
     * 三级指标：债务类融资-个人
     */
    @Column(name = "finger_finance_debt_person_weight")
    private Double fingerFinanceDebtPersonWeight;

    /**
     * 一级指标:估值指数
     */
    @Column(name = "finger_valuation_weight")
    private Double fingerValuationWeight;

    /**
     * 二级指标：净资产
     */
    @Column(name = "finger_valuation_assets_weight")
    private Double fingerValuationAssetsWeight;

    /**
     * 三级指标：净资产-流动资产
     */
    @Column(name = "finger_valuation_assets_circulating_weight")
    private Double fingerValuationAssetsCirculatingWeight;

    /**
     * 三级指标：净资产-非流动资产
     */
    @Column(name = "finger_valuation_assets_uncirculating_weight")
    private Double fingerValuationAssetsUncirculatingWeight;

    /**
     * 三级指标：净资产-流动负债
     */
    @Column(name = "finger_valuation_assets_debt_circulating_weight")
    private Double fingerValuationAssetsDebtCirculatingWeight;

    /**
     * 三级指标：净资产-非流动负债
     */
    @Column(name = "finger_valuation_assets_debt_uncirculating_weight")
    private Double fingerValuationAssetsDebtUncirculatingWeight;

    /**
     * 二级指标：实际估值
     */
    @Column(name = "finger_valuation_actual_weight")
    private Double fingerValuationActualWeight;

    /**
     * 三级指标：实际估值-首次融资
     */
    @Column(name = "finger_valuation_actual_first_weight")
    private Double fingerValuationActualFirstWeight;

    /**
     * 三级指标：实际估值-最近一次融资估值
     */
    @Column(name = "finger_valuation_actual_latest_weight")
    private Double fingerValuationActualLatestWeight;

    /**
     * 三级指标：实际估值-现在准备融资估值
     */
    @Column(name = "finger_valuation_actual_want_weight")
    private Double fingerValuationActualWantWeight;

    /**
     * 一级指标：人力资源指数
     */
    @Column(name = "finger_hr_weight")
    private Double fingerHrWeight;

    /**
     * 二级指标：兼职员工数
     */
    @Column(name = "finger_hr_partime_weight")
    private Double fingerHrPartimeWeight;

    /**
     * 三级指标：兼职员工-研发
     */
    @Column(name = "finger_hr_partime_dev_weight")
    private Double fingerHrPartimeDevWeight;

    /**
     * 三级指标：兼职员工-管理
     */
    @Column(name = "finger_hr_partime_manage_weight")
    private Double fingerHrPartimeManageWeight;

    /**
     * 三级指标：兼职员工-行政
     */
    @Column(name = "finger_hr_partime_admin_weight")
    private Double fingerHrPartimeAdminWeight;

    /**
     * 三级指标：兼职员工-销售
     */
    @Column(name = "finger_hr_partime_saler_weight")
    private Double fingerHrPartimeSalerWeight;

    /**
     * 二级指标：全职员工
     */
    @Column(name = "finger_hr_fulltime_weight")
    private Double fingerHrFulltimeWeight;

    /**
     * 三级指标：全职员工-研发
     */
    @Column(name = "finger_hr_fulltime_dev_weight")
    private Double fingerHrFulltimeDevWeight;

    /**
     * 三级指标：全职员工-高管
     */
    @Column(name = "finger_hr_fulltime_senior_weight")
    private Double fingerHrFulltimeSeniorWeight;

    /**
     * 三级指标：全职员工-行政
     */
    @Column(name = "finger_hr_fulltime_admin_weight")
    private Double fingerHrFulltimeAdminWeight;

    /**
     * 三级指标：全职员工-销售
     */
    @Column(name = "finger_hr_fulltime_saler_weight")
    private Double fingerHrFulltimeSalerWeight;

    /**
     * 二级指标：高学历人员
     */
    @Column(name = "finger_hr_educated_weight")
    private Double fingerHrEducatedWeight;

    /**
     * 三级指标：高学历人员-博士
     */
    @Column(name = "finger_hr_educated_doc_weight")
    private Double fingerHrEducatedDocWeight;

    /**
     * 三级指标：高学历人员-硕士
     */
    @Column(name = "finger_hr_educated_master_weight")
    private Double fingerHrEducatedMasterWeight;

    /**
     * 三级指标：高学历人员-学士
     */
    @Column(name = "finger_hr_bachelor_weight")
    private Double fingerHrBachelorWeight;

    /**
     * 一级指标：创新指数
     */
    @Column(name = "finger_innovate_weight")
    private Double fingerInnovateWeight;

    /**
     * 二级指标：专利申请
     */
    @Column(name = "finger_innovate_patent_apply_weight")
    private Double fingerInnovatePatentApplyWeight;

    /**
     * 三级指标：专利申请-发明
     */
    @Column(name = "finger_innovate_patent_apply_invention_weight")
    private Double fingerInnovatePatentApplyInventionWeight;

    /**
     * 三级指标：专利申请-实用新型
     */
    @Column(name = "finger_innovate_patent_apply_utility_weight")
    private Double fingerInnovatePatentApplyUtilityWeight;

    /**
     * 三级指标：专利申请-外观设计
     */
    @Column(name = "finger_innovate_patent_apply_appear_weight")
    private Double fingerInnovatePatentApplyAppearWeight;

    /**
     * 二级指标：专利授权
     */
    @Column(name = "finger_innovate_patent_grant_weight")
    private Double fingerInnovatePatentGrantWeight;

    /**
     * 三级指标：专利授权-发明
     */
    @Column(name = "finger_innovate_patent_grant_invention_weight")
    private Double fingerInnovatePatentGrantInventionWeight;

    /**
     * 三级指标：专利授权-实用新型
     */
    @Column(name = "finger_innovate_patent_grant_utility_weight")
    private Double fingerInnovatePatentGrantUtilityWeight;

    /**
     * 三级指标：专利授权-外观设计
     */
    @Column(name = "finger_innovate_patent_grant_appear_weight")
    private Double fingerInnovatePatentGrantAppearWeight;

    /**
     * 二级指标：著作权申请
     */
    @Column(name = "finger_innovate_copyright_apply_weight")
    private Double fingerInnovateCopyrightApplyWeight;

    /**
     * 三级指标：著作权申请-软件类
     */
    @Column(name = "finger_innovate_copyright_apply_soft_weight")
    private Double fingerInnovateCopyrightApplySoftWeight;

    /**
     * 三级指标：著作权申请-非软件类
     */
    @Column(name = "finger_innovate_copyright_apply_unsoft_weight")
    private Double fingerInnovateCopyrightApplyUnsoftWeight;

    /**
     * 二级指标：著作权授权
     */
    @Column(name = "finger_innovate_copyright_grant_weight")
    private Double fingerInnovateCopyrightGrantWeight;

    /**
     * 三级指标：著作权授权-软件类
     */
    @Column(name = "finger_innovate_copyright_grant_soft_weight")
    private Double fingerInnovateCopyrightGrantSoftWeight;

    /**
     * 三级指标：著作权授权-非软件类
     */
    @Column(name = "finger_innovate_copyright_grant_unsoft_weight")
    private Double fingerInnovateCopyrightGrantUnsoftWeight;

    /**
     * 二级指标：新产品/服务
     */
    @Column(name = "finger_innovate_new_product_weight")
    private Double fingerInnovateNewProductWeight;

    /**
     * 三级指标：新产品/服务-专利类
     */
    @Column(name = "finger_innovate_new_product_patent_weight")
    private Double fingerInnovateNewProductPatentWeight;

    /**
     * 三级指标：新产品/服务-专用技术
     */
    @Column(name = "finger_innovate_new_product_tech_weight")
    private Double fingerInnovateNewProductTechWeight;

    /**
     * 三级指标：新产品/服务-商业模式
     */
    @Column(name = "finger_innovate_new_product_bus_weight")
    private Double fingerInnovateNewProductBusWeight;

    /**
     * 一级指标：薪酬指数
     */
    @Column(name = "finger_salary_weight")
    private Double fingerSalaryWeight;

    /**
     * 二级指标：员工工资额
     */
    @Column(name = "finger_salary_staff_weight")
    private Double fingerSalaryStaffWeight;

    /**
     * 三级指标：员工工资额-1万元以上
     */
    @Column(name = "finger_salary_staff_up_10_weight")
    private Double fingerSalaryStaffUp10Weight;

    /**
     * 三级指标：员工工资额-5千到1万
     */
    @Column(name = "finger_salary_staff_5_10_weight")
    private Double fingerSalaryStaff510Weight;

    /**
     * 三级指标：员工工资额-5千以下
     */
    @Column(name = "finger_salary_staff_down_5_weight")
    private Double fingerSalaryStaffDown5Weight;

    /**
     * 二级指标：员工贡献率
     */
    @Column(name = "finger_salary_staff_contribution_weight")
    private Double fingerSalaryStaffContributionWeight;

    /**
     * 三级指标：员工贡献率-人均销售
     */
    @Column(name = "finger_salary_staff_contribution_meansale_weight")
    private Double fingerSalaryStaffContributionMeansaleWeight;

    /**
     * 三级指标：员工贡献率-人均纳税
     */
    @Column(name = "finger_salary_staff_contribution_meantax_weight")
    private Double fingerSalaryStaffContributionMeantaxWeight;

    /**
     * 一级指标：学习指数
     */
    @Column(name = "finger_learn_weight")
    private Double fingerLearnWeight;

    /**
     * 二级指标：参加培训的次数
     */
    @Column(name = "finger_learn_train_weight")
    private Double fingerLearnTrainWeight;

    /**
     * 三级指标：参加培训的次数-管理类
     */
    @Column(name = "finger_learn_train_manage_weight")
    private Double fingerLearnTrainManageWeight;

    /**
     * 三级指标：参加培训的次数-政策法规
     */
    @Column(name = "finger_learn_train_policy_weight")
    private Double fingerLearnTrainPolicyWeight;

    /**
     * 三级指标：参加培训的次数-技能类
     */
    @Column(name = "finger_learn_train_skill_weight")
    private Double fingerLearnTrainSkillWeight;

    /**
     * 二级指标：接受咨询的次数
     */
    @Column(name = "finger_learn_conslted_weight")
    private Double fingerLearnConsltedWeight;

    /**
     * 三级指标：接受咨询的次数-管理类
     */
    @Column(name = "finger_learn_conslted_manage_weight")
    private Double fingerLearnConsltedManageWeight;

    /**
     * 三级指标：接受咨询的次数-政策法规
     */
    @Column(name = "finger_learn_conslted_policy_weight")
    private Double fingerLearnConsltedPolicyWeight;

    /**
     * 三级指标：接受咨询的次数-技能类
     */
    @Column(name = "finger_learn_conslted_skill_weight")
    private Double fingerLearnConsltedSkillWeight;

    /**
     * 一级指标：品牌指数
     */
    @Column(name = "finger_brand_weight")
    private Double fingerBrandWeight;

    /**
     * 二级指标：企业获奖
     */
    @Column(name = "finger_brand_reward_weight")
    private Double fingerBrandRewardWeight;

    /**
     * 三级指标：企业获奖-区级
     */
    @Column(name = "finger_brand_reward_area_weight")
    private Double fingerBrandRewardAreaWeight;

    /**
     * 三级指标：企业获奖-市级
     */
    @Column(name = "finger_brand_reward_city_weight")
    private Double fingerBrandRewardCityWeight;

    /**
     * 三级指标：企业获奖-省级
     */
    @Column(name = "finger_brand_reward_province_weight")
    private Double fingerBrandRewardProvinceWeight;

    /**
     * 三级指标：企业获奖-国家级
     */
    @Column(name = "finger_brand_reward_country_weight")
    private Double fingerBrandRewardCountryWeight;

    /**
     * 二级指标：企业认定
     */
    @Column(name = "finger_brand_recognition_weight")
    private Double fingerBrandRecognitionWeight;

    /**
     * 三级指标：企业认定-区级
     */
    @Column(name = "finger_brand_recognition_area_weight")
    private Double fingerBrandRecognitionAreaWeight;

    /**
     * 三级指标：企业认定-市级
     */
    @Column(name = "finger_brand_recognition_city_weight")
    private Double fingerBrandRecognitionCityWeight;

    /**
     * 三级指标：企业认定-省级
     */
    @Column(name = "finger_brand_recognition_province_weight")
    private Double fingerBrandRecognitionProvinceWeight;

    /**
     * 三级指标：企业认定-国家级
     */
    @Column(name = "finger_brand_recognition_country_weight")
    private Double fingerBrandRecognitionCountryWeight;

    /**
     * 二级指标：人才资助
     */
    @Column(name = "finger_brand_talent_weight")
    private Double fingerBrandTalentWeight;

    /**
     * 三级指标：人才资助-区级
     */
    @Column(name = "finger_brand_talent_area_weight")
    private Double fingerBrandTalentAreaWeight;

    /**
     * 三级指标：人才资助-市级
     */
    @Column(name = "finger_brand_talent_city_weight")
    private Double fingerBrandTalentCityWeight;

    /**
     * 三级指标：人才资助-省级
     */
    @Column(name = "finger_brand_talent_province_weight")
    private Double fingerBrandTalentProvinceWeight;

    /**
     * 三级指标：人才资助-国家级
     */
    @Column(name = "finger_brand_talent_country_weight")
    private Double fingerBrandTalentCountryWeight;

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
     * @return finger_sale_weight
     */
    public Double getFingerSaleWeight() {
        return fingerSaleWeight;
    }

    /**
     * @param fingerSaleWeight
     */
    public void setFingerSaleWeight(Double fingerSaleWeight) {
        this.fingerSaleWeight = fingerSaleWeight;
    }

    /**
     * @return finger_sale_invoice_weight
     */
    public Double getFingerSaleInvoiceWeight() {
        return fingerSaleInvoiceWeight;
    }

    /**
     * @param fingerSaleInvoiceWeight
     */
    public void setFingerSaleInvoiceWeight(Double fingerSaleInvoiceWeight) {
        this.fingerSaleInvoiceWeight = fingerSaleInvoiceWeight;
    }

    /**
     * @return finger_sale_invoice_soft_weight
     */
    public Double getFingerSaleInvoiceSoftWeight() {
        return fingerSaleInvoiceSoftWeight;
    }

    /**
     * @param fingerSaleInvoiceSoftWeight
     */
    public void setFingerSaleInvoiceSoftWeight(Double fingerSaleInvoiceSoftWeight) {
        this.fingerSaleInvoiceSoftWeight = fingerSaleInvoiceSoftWeight;
    }

    /**
     * 获取已开发票的收入-硬件产品
     *
     * @return finger_sale_invoice_hard_weight - 已开发票的收入-硬件产品
     */
    public Double getFingerSaleInvoiceHardWeight() {
        return fingerSaleInvoiceHardWeight;
    }

    /**
     * 设置已开发票的收入-硬件产品
     *
     * @param fingerSaleInvoiceHardWeight 已开发票的收入-硬件产品
     */
    public void setFingerSaleInvoiceHardWeight(Double fingerSaleInvoiceHardWeight) {
        this.fingerSaleInvoiceHardWeight = fingerSaleInvoiceHardWeight;
    }

    /**
     * 获取已开发票的收入-咨询服务
     *
     * @return finger_sale_invoice_consultation_weight - 已开发票的收入-咨询服务
     */
    public Double getFingerSaleInvoiceConsultationWeight() {
        return fingerSaleInvoiceConsultationWeight;
    }

    /**
     * 设置已开发票的收入-咨询服务
     *
     * @param fingerSaleInvoiceConsultationWeight 已开发票的收入-咨询服务
     */
    public void setFingerSaleInvoiceConsultationWeight(Double fingerSaleInvoiceConsultationWeight) {
        this.fingerSaleInvoiceConsultationWeight = fingerSaleInvoiceConsultationWeight;
    }

    /**
     * 获取已开发票的收入-其他
     *
     * @return finger_sale_invoice_other_weight - 已开发票的收入-其他
     */
    public Double getFingerSaleInvoiceOtherWeight() {
        return fingerSaleInvoiceOtherWeight;
    }

    /**
     * 设置已开发票的收入-其他
     *
     * @param fingerSaleInvoiceOtherWeight 已开发票的收入-其他
     */
    public void setFingerSaleInvoiceOtherWeight(Double fingerSaleInvoiceOtherWeight) {
        this.fingerSaleInvoiceOtherWeight = fingerSaleInvoiceOtherWeight;
    }

    /**
     * 获取二级指标：合同确认额
     *
     * @return finger_sale_contract_weight - 二级指标：合同确认额
     */
    public Double getFingerSaleContractWeight() {
        return fingerSaleContractWeight;
    }

    /**
     * 设置二级指标：合同确认额
     *
     * @param fingerSaleContractWeight 二级指标：合同确认额
     */
    public void setFingerSaleContractWeight(Double fingerSaleContractWeight) {
        this.fingerSaleContractWeight = fingerSaleContractWeight;
    }

    /**
     * 获取三级指标：合同确认额-软件产品
     *
     * @return finger_sale_contract_soft_weight - 三级指标：合同确认额-软件产品
     */
    public Double getFingerSaleContractSoftWeight() {
        return fingerSaleContractSoftWeight;
    }

    /**
     * 设置三级指标：合同确认额-软件产品
     *
     * @param fingerSaleContractSoftWeight 三级指标：合同确认额-软件产品
     */
    public void setFingerSaleContractSoftWeight(Double fingerSaleContractSoftWeight) {
        this.fingerSaleContractSoftWeight = fingerSaleContractSoftWeight;
    }

    /**
     * 获取三级指标：合同确认额-硬件产品
     *
     * @return finger_sale_contract_hard_weight - 三级指标：合同确认额-硬件产品
     */
    public Double getFingerSaleContractHardWeight() {
        return fingerSaleContractHardWeight;
    }

    /**
     * 设置三级指标：合同确认额-硬件产品
     *
     * @param fingerSaleContractHardWeight 三级指标：合同确认额-硬件产品
     */
    public void setFingerSaleContractHardWeight(Double fingerSaleContractHardWeight) {
        this.fingerSaleContractHardWeight = fingerSaleContractHardWeight;
    }

    /**
     * 获取三级指标：合同确认额-咨询服务
     *
     * @return finger_sale_contract_consultation_weight - 三级指标：合同确认额-咨询服务
     */
    public Double getFingerSaleContractConsultationWeight() {
        return fingerSaleContractConsultationWeight;
    }

    /**
     * 设置三级指标：合同确认额-咨询服务
     *
     * @param fingerSaleContractConsultationWeight 三级指标：合同确认额-咨询服务
     */
    public void setFingerSaleContractConsultationWeight(Double fingerSaleContractConsultationWeight) {
        this.fingerSaleContractConsultationWeight = fingerSaleContractConsultationWeight;
    }

    /**
     * 获取三级指标：合同确认额-其他
     *
     * @return finger_sale_contract_other_weight - 三级指标：合同确认额-其他
     */
    public Double getFingerSaleContractOtherWeight() {
        return fingerSaleContractOtherWeight;
    }

    /**
     * 设置三级指标：合同确认额-其他
     *
     * @param fingerSaleContractOtherWeight 三级指标：合同确认额-其他
     */
    public void setFingerSaleContractOtherWeight(Double fingerSaleContractOtherWeight) {
        this.fingerSaleContractOtherWeight = fingerSaleContractOtherWeight;
    }

    /**
     * 获取一级指标：纳税指数
     *
     * @return finger_tax_weight - 一级指标：纳税指数
     */
    public Double getFingerTaxWeight() {
        return fingerTaxWeight;
    }

    /**
     * 设置一级指标：纳税指数
     *
     * @param fingerTaxWeight 一级指标：纳税指数
     */
    public void setFingerTaxWeight(Double fingerTaxWeight) {
        this.fingerTaxWeight = fingerTaxWeight;
    }

    /**
     * 获取二级指标：企业所得税
     *
     * @return finger_tax_corporate_weight - 二级指标：企业所得税
     */
    public Double getFingerTaxCorporateWeight() {
        return fingerTaxCorporateWeight;
    }

    /**
     * 设置二级指标：企业所得税
     *
     * @param fingerTaxCorporateWeight 二级指标：企业所得税
     */
    public void setFingerTaxCorporateWeight(Double fingerTaxCorporateWeight) {
        this.fingerTaxCorporateWeight = fingerTaxCorporateWeight;
    }

    /**
     * 获取三级指标：企业所得税-应纳税值
     *
     * @return finger_tax_corporate_taxable_weight - 三级指标：企业所得税-应纳税值
     */
    public Double getFingerTaxCorporateTaxableWeight() {
        return fingerTaxCorporateTaxableWeight;
    }

    /**
     * 设置三级指标：企业所得税-应纳税值
     *
     * @param fingerTaxCorporateTaxableWeight 三级指标：企业所得税-应纳税值
     */
    public void setFingerTaxCorporateTaxableWeight(Double fingerTaxCorporateTaxableWeight) {
        this.fingerTaxCorporateTaxableWeight = fingerTaxCorporateTaxableWeight;
    }

    /**
     * 获取三级指标：企业所得税-税收减免值
     *
     * @return finger_tax_corporate_relief_weight - 三级指标：企业所得税-税收减免值
     */
    public Double getFingerTaxCorporateReliefWeight() {
        return fingerTaxCorporateReliefWeight;
    }

    /**
     * 设置三级指标：企业所得税-税收减免值
     *
     * @param fingerTaxCorporateReliefWeight 三级指标：企业所得税-税收减免值
     */
    public void setFingerTaxCorporateReliefWeight(Double fingerTaxCorporateReliefWeight) {
        this.fingerTaxCorporateReliefWeight = fingerTaxCorporateReliefWeight;
    }

    /**
     * 获取二级指标：个人所得税
     *
     * @return finger_tax_individual_weight - 二级指标：个人所得税
     */
    public Double getFingerTaxIndividualWeight() {
        return fingerTaxIndividualWeight;
    }

    /**
     * 设置二级指标：个人所得税
     *
     * @param fingerTaxIndividualWeight 二级指标：个人所得税
     */
    public void setFingerTaxIndividualWeight(Double fingerTaxIndividualWeight) {
        this.fingerTaxIndividualWeight = fingerTaxIndividualWeight;
    }

    /**
     * 获取三级指标：个人所得税-应纳税值
     *
     * @return finger_tax_individual_taxable_weight - 三级指标：个人所得税-应纳税值
     */
    public Double getFingerTaxIndividualTaxableWeight() {
        return fingerTaxIndividualTaxableWeight;
    }

    /**
     * 设置三级指标：个人所得税-应纳税值
     *
     * @param fingerTaxIndividualTaxableWeight 三级指标：个人所得税-应纳税值
     */
    public void setFingerTaxIndividualTaxableWeight(Double fingerTaxIndividualTaxableWeight) {
        this.fingerTaxIndividualTaxableWeight = fingerTaxIndividualTaxableWeight;
    }

    /**
     * 获取三级指标：个人所得税-税收减免
     *
     * @return finger_tax_individual_relief_weight - 三级指标：个人所得税-税收减免
     */
    public Double getFingerTaxIndividualReliefWeight() {
        return fingerTaxIndividualReliefWeight;
    }

    /**
     * 设置三级指标：个人所得税-税收减免
     *
     * @param fingerTaxIndividualReliefWeight 三级指标：个人所得税-税收减免
     */
    public void setFingerTaxIndividualReliefWeight(Double fingerTaxIndividualReliefWeight) {
        this.fingerTaxIndividualReliefWeight = fingerTaxIndividualReliefWeight;
    }

    /**
     * 获取二级指标：增值税
     *
     * @return finger_tax_added_weight - 二级指标：增值税
     */
    public Double getFingerTaxAddedWeight() {
        return fingerTaxAddedWeight;
    }

    /**
     * 设置二级指标：增值税
     *
     * @param fingerTaxAddedWeight 二级指标：增值税
     */
    public void setFingerTaxAddedWeight(Double fingerTaxAddedWeight) {
        this.fingerTaxAddedWeight = fingerTaxAddedWeight;
    }

    /**
     * 获取三级指标：增值税-应纳税值
     *
     * @return finger_tax_added_taxable_weight - 三级指标：增值税-应纳税值
     */
    public Double getFingerTaxAddedTaxableWeight() {
        return fingerTaxAddedTaxableWeight;
    }

    /**
     * 设置三级指标：增值税-应纳税值
     *
     * @param fingerTaxAddedTaxableWeight 三级指标：增值税-应纳税值
     */
    public void setFingerTaxAddedTaxableWeight(Double fingerTaxAddedTaxableWeight) {
        this.fingerTaxAddedTaxableWeight = fingerTaxAddedTaxableWeight;
    }

    /**
     * 获取三级指标：增值税-税收减免
     *
     * @return finger_tax_added_relief_weight - 三级指标：增值税-税收减免
     */
    public Double getFingerTaxAddedReliefWeight() {
        return fingerTaxAddedReliefWeight;
    }

    /**
     * 设置三级指标：增值税-税收减免
     *
     * @param fingerTaxAddedReliefWeight 三级指标：增值税-税收减免
     */
    public void setFingerTaxAddedReliefWeight(Double fingerTaxAddedReliefWeight) {
        this.fingerTaxAddedReliefWeight = fingerTaxAddedReliefWeight;
    }

    /**
     * 获取一级指标：融资指数
     *
     * @return finger_finance_weight - 一级指标：融资指数
     */
    public Double getFingerFinanceWeight() {
        return fingerFinanceWeight;
    }

    /**
     * 设置一级指标：融资指数
     *
     * @param fingerFinanceWeight 一级指标：融资指数
     */
    public void setFingerFinanceWeight(Double fingerFinanceWeight) {
        this.fingerFinanceWeight = fingerFinanceWeight;
    }

    /**
     * 获取二级指标：股权类融资
     *
     * @return finger_finance_stock_weight - 二级指标：股权类融资
     */
    public Double getFingerFinanceStockWeight() {
        return fingerFinanceStockWeight;
    }

    /**
     * 设置二级指标：股权类融资
     *
     * @param fingerFinanceStockWeight 二级指标：股权类融资
     */
    public void setFingerFinanceStockWeight(Double fingerFinanceStockWeight) {
        this.fingerFinanceStockWeight = fingerFinanceStockWeight;
    }

    /**
     * 获取三级指标：股权类融资-风投机构
     *
     * @return finger_finance_stock_risk_weight - 三级指标：股权类融资-风投机构
     */
    public Double getFingerFinanceStockRiskWeight() {
        return fingerFinanceStockRiskWeight;
    }

    /**
     * 设置三级指标：股权类融资-风投机构
     *
     * @param fingerFinanceStockRiskWeight 三级指标：股权类融资-风投机构
     */
    public void setFingerFinanceStockRiskWeight(Double fingerFinanceStockRiskWeight) {
        this.fingerFinanceStockRiskWeight = fingerFinanceStockRiskWeight;
    }

    /**
     * 获取三级指标：股权类融资-政府企业
     *
     * @return finger_finance_stock_gov_weight - 三级指标：股权类融资-政府企业
     */
    public Double getFingerFinanceStockGovWeight() {
        return fingerFinanceStockGovWeight;
    }

    /**
     * 设置三级指标：股权类融资-政府企业
     *
     * @param fingerFinanceStockGovWeight 三级指标：股权类融资-政府企业
     */
    public void setFingerFinanceStockGovWeight(Double fingerFinanceStockGovWeight) {
        this.fingerFinanceStockGovWeight = fingerFinanceStockGovWeight;
    }

    /**
     * 获取三级指标：股权类融资-个人
     *
     * @return finger_finance_stock_person_weight - 三级指标：股权类融资-个人
     */
    public Double getFingerFinanceStockPersonWeight() {
        return fingerFinanceStockPersonWeight;
    }

    /**
     * 设置三级指标：股权类融资-个人
     *
     * @param fingerFinanceStockPersonWeight 三级指标：股权类融资-个人
     */
    public void setFingerFinanceStockPersonWeight(Double fingerFinanceStockPersonWeight) {
        this.fingerFinanceStockPersonWeight = fingerFinanceStockPersonWeight;
    }

    /**
     * 获取二级指标：债务类融资
     *
     * @return finger_finance_debt_weight - 二级指标：债务类融资
     */
    public Double getFingerFinanceDebtWeight() {
        return fingerFinanceDebtWeight;
    }

    /**
     * 设置二级指标：债务类融资
     *
     * @param fingerFinanceDebtWeight 二级指标：债务类融资
     */
    public void setFingerFinanceDebtWeight(Double fingerFinanceDebtWeight) {
        this.fingerFinanceDebtWeight = fingerFinanceDebtWeight;
    }

    /**
     * 获取三级指标：债务类融资-银行
     *
     * @return finger_finance_debt_bank_weight - 三级指标：债务类融资-银行
     */
    public Double getFingerFinanceDebtBankWeight() {
        return fingerFinanceDebtBankWeight;
    }

    /**
     * 设置三级指标：债务类融资-银行
     *
     * @param fingerFinanceDebtBankWeight 三级指标：债务类融资-银行
     */
    public void setFingerFinanceDebtBankWeight(Double fingerFinanceDebtBankWeight) {
        this.fingerFinanceDebtBankWeight = fingerFinanceDebtBankWeight;
    }

    /**
     * 获取三级指标：债务类融资-新型贷款机构
     *
     * @return finger_finance_debt_new_weight - 三级指标：债务类融资-新型贷款机构
     */
    public Double getFingerFinanceDebtNewWeight() {
        return fingerFinanceDebtNewWeight;
    }

    /**
     * 设置三级指标：债务类融资-新型贷款机构
     *
     * @param fingerFinanceDebtNewWeight 三级指标：债务类融资-新型贷款机构
     */
    public void setFingerFinanceDebtNewWeight(Double fingerFinanceDebtNewWeight) {
        this.fingerFinanceDebtNewWeight = fingerFinanceDebtNewWeight;
    }

    /**
     * 获取三级指标：债务类融资-企业拆借
     *
     * @return finger_finance_debt_lending_weight - 三级指标：债务类融资-企业拆借
     */
    public Double getFingerFinanceDebtLendingWeight() {
        return fingerFinanceDebtLendingWeight;
    }

    /**
     * 设置三级指标：债务类融资-企业拆借
     *
     * @param fingerFinanceDebtLendingWeight 三级指标：债务类融资-企业拆借
     */
    public void setFingerFinanceDebtLendingWeight(Double fingerFinanceDebtLendingWeight) {
        this.fingerFinanceDebtLendingWeight = fingerFinanceDebtLendingWeight;
    }

    /**
     * 获取三级指标：债务类融资-个人
     *
     * @return finger_finance_debt_person_weight - 三级指标：债务类融资-个人
     */
    public Double getFingerFinanceDebtPersonWeight() {
        return fingerFinanceDebtPersonWeight;
    }

    /**
     * 设置三级指标：债务类融资-个人
     *
     * @param fingerFinanceDebtPersonWeight 三级指标：债务类融资-个人
     */
    public void setFingerFinanceDebtPersonWeight(Double fingerFinanceDebtPersonWeight) {
        this.fingerFinanceDebtPersonWeight = fingerFinanceDebtPersonWeight;
    }

    /**
     * 获取一级指标:估值指数
     *
     * @return finger_valuation_weight - 一级指标:估值指数
     */
    public Double getFingerValuationWeight() {
        return fingerValuationWeight;
    }

    /**
     * 设置一级指标:估值指数
     *
     * @param fingerValuationWeight 一级指标:估值指数
     */
    public void setFingerValuationWeight(Double fingerValuationWeight) {
        this.fingerValuationWeight = fingerValuationWeight;
    }

    /**
     * 获取二级指标：净资产
     *
     * @return finger_valuation_assets_weight - 二级指标：净资产
     */
    public Double getFingerValuationAssetsWeight() {
        return fingerValuationAssetsWeight;
    }

    /**
     * 设置二级指标：净资产
     *
     * @param fingerValuationAssetsWeight 二级指标：净资产
     */
    public void setFingerValuationAssetsWeight(Double fingerValuationAssetsWeight) {
        this.fingerValuationAssetsWeight = fingerValuationAssetsWeight;
    }

    /**
     * 获取三级指标：净资产-流动资产
     *
     * @return finger_valuation_assets_circulating_weight - 三级指标：净资产-流动资产
     */
    public Double getFingerValuationAssetsCirculatingWeight() {
        return fingerValuationAssetsCirculatingWeight;
    }

    /**
     * 设置三级指标：净资产-流动资产
     *
     * @param fingerValuationAssetsCirculatingWeight 三级指标：净资产-流动资产
     */
    public void setFingerValuationAssetsCirculatingWeight(Double fingerValuationAssetsCirculatingWeight) {
        this.fingerValuationAssetsCirculatingWeight = fingerValuationAssetsCirculatingWeight;
    }

    /**
     * 获取三级指标：净资产-非流动资产
     *
     * @return finger_valuation_assets_uncirculating_weight - 三级指标：净资产-非流动资产
     */
    public Double getFingerValuationAssetsUncirculatingWeight() {
        return fingerValuationAssetsUncirculatingWeight;
    }

    /**
     * 设置三级指标：净资产-非流动资产
     *
     * @param fingerValuationAssetsUncirculatingWeight 三级指标：净资产-非流动资产
     */
    public void setFingerValuationAssetsUncirculatingWeight(Double fingerValuationAssetsUncirculatingWeight) {
        this.fingerValuationAssetsUncirculatingWeight = fingerValuationAssetsUncirculatingWeight;
    }

    /**
     * 获取三级指标：净资产-流动负债
     *
     * @return finger_valuation_assets_debt_circulating_weight - 三级指标：净资产-流动负债
     */
    public Double getFingerValuationAssetsDebtCirculatingWeight() {
        return fingerValuationAssetsDebtCirculatingWeight;
    }

    /**
     * 设置三级指标：净资产-流动负债
     *
     * @param fingerValuationAssetsDebtCirculatingWeight 三级指标：净资产-流动负债
     */
    public void setFingerValuationAssetsDebtCirculatingWeight(Double fingerValuationAssetsDebtCirculatingWeight) {
        this.fingerValuationAssetsDebtCirculatingWeight = fingerValuationAssetsDebtCirculatingWeight;
    }

    /**
     * 获取三级指标：净资产-非流动负债
     *
     * @return finger_valuation_assets_debt_uncirculating_weight - 三级指标：净资产-非流动负债
     */
    public Double getFingerValuationAssetsDebtUncirculatingWeight() {
        return fingerValuationAssetsDebtUncirculatingWeight;
    }

    /**
     * 设置三级指标：净资产-非流动负债
     *
     * @param fingerValuationAssetsDebtUncirculatingWeight 三级指标：净资产-非流动负债
     */
    public void setFingerValuationAssetsDebtUncirculatingWeight(Double fingerValuationAssetsDebtUncirculatingWeight) {
        this.fingerValuationAssetsDebtUncirculatingWeight = fingerValuationAssetsDebtUncirculatingWeight;
    }

    /**
     * 获取二级指标：实际估值
     *
     * @return finger_valuation_actual_weight - 二级指标：实际估值
     */
    public Double getFingerValuationActualWeight() {
        return fingerValuationActualWeight;
    }

    /**
     * 设置二级指标：实际估值
     *
     * @param fingerValuationActualWeight 二级指标：实际估值
     */
    public void setFingerValuationActualWeight(Double fingerValuationActualWeight) {
        this.fingerValuationActualWeight = fingerValuationActualWeight;
    }

    /**
     * 获取三级指标：实际估值-首次融资
     *
     * @return finger_valuation_actual_first_weight - 三级指标：实际估值-首次融资
     */
    public Double getFingerValuationActualFirstWeight() {
        return fingerValuationActualFirstWeight;
    }

    /**
     * 设置三级指标：实际估值-首次融资
     *
     * @param fingerValuationActualFirstWeight 三级指标：实际估值-首次融资
     */
    public void setFingerValuationActualFirstWeight(Double fingerValuationActualFirstWeight) {
        this.fingerValuationActualFirstWeight = fingerValuationActualFirstWeight;
    }

    /**
     * 获取三级指标：实际估值-最近一次融资估值
     *
     * @return finger_valuation_actual_latest_weight - 三级指标：实际估值-最近一次融资估值
     */
    public Double getFingerValuationActualLatestWeight() {
        return fingerValuationActualLatestWeight;
    }

    /**
     * 设置三级指标：实际估值-最近一次融资估值
     *
     * @param fingerValuationActualLatestWeight 三级指标：实际估值-最近一次融资估值
     */
    public void setFingerValuationActualLatestWeight(Double fingerValuationActualLatestWeight) {
        this.fingerValuationActualLatestWeight = fingerValuationActualLatestWeight;
    }

    /**
     * 获取三级指标：实际估值-现在准备融资估值
     *
     * @return finger_valuation_actual_want_weight - 三级指标：实际估值-现在准备融资估值
     */
    public Double getFingerValuationActualWantWeight() {
        return fingerValuationActualWantWeight;
    }

    /**
     * 设置三级指标：实际估值-现在准备融资估值
     *
     * @param fingerValuationActualWantWeight 三级指标：实际估值-现在准备融资估值
     */
    public void setFingerValuationActualWantWeight(Double fingerValuationActualWantWeight) {
        this.fingerValuationActualWantWeight = fingerValuationActualWantWeight;
    }

    /**
     * 获取一级指标：人力资源指数
     *
     * @return finger_hr_weight - 一级指标：人力资源指数
     */
    public Double getFingerHrWeight() {
        return fingerHrWeight;
    }

    /**
     * 设置一级指标：人力资源指数
     *
     * @param fingerHrWeight 一级指标：人力资源指数
     */
    public void setFingerHrWeight(Double fingerHrWeight) {
        this.fingerHrWeight = fingerHrWeight;
    }

    /**
     * 获取二级指标：兼职员工数
     *
     * @return finger_hr_partime_weight - 二级指标：兼职员工数
     */
    public Double getFingerHrPartimeWeight() {
        return fingerHrPartimeWeight;
    }

    /**
     * 设置二级指标：兼职员工数
     *
     * @param fingerHrPartimeWeight 二级指标：兼职员工数
     */
    public void setFingerHrPartimeWeight(Double fingerHrPartimeWeight) {
        this.fingerHrPartimeWeight = fingerHrPartimeWeight;
    }

    /**
     * 获取三级指标：兼职员工-研发
     *
     * @return finger_hr_partime_dev_weight - 三级指标：兼职员工-研发
     */
    public Double getFingerHrPartimeDevWeight() {
        return fingerHrPartimeDevWeight;
    }

    /**
     * 设置三级指标：兼职员工-研发
     *
     * @param fingerHrPartimeDevWeight 三级指标：兼职员工-研发
     */
    public void setFingerHrPartimeDevWeight(Double fingerHrPartimeDevWeight) {
        this.fingerHrPartimeDevWeight = fingerHrPartimeDevWeight;
    }

    /**
     * 获取三级指标：兼职员工-管理
     *
     * @return finger_hr_partime_manage_weight - 三级指标：兼职员工-管理
     */
    public Double getFingerHrPartimeManageWeight() {
        return fingerHrPartimeManageWeight;
    }

    /**
     * 设置三级指标：兼职员工-管理
     *
     * @param fingerHrPartimeManageWeight 三级指标：兼职员工-管理
     */
    public void setFingerHrPartimeManageWeight(Double fingerHrPartimeManageWeight) {
        this.fingerHrPartimeManageWeight = fingerHrPartimeManageWeight;
    }

    /**
     * 获取三级指标：兼职员工-行政
     *
     * @return finger_hr_partime_admin_weight - 三级指标：兼职员工-行政
     */
    public Double getFingerHrPartimeAdminWeight() {
        return fingerHrPartimeAdminWeight;
    }

    /**
     * 设置三级指标：兼职员工-行政
     *
     * @param fingerHrPartimeAdminWeight 三级指标：兼职员工-行政
     */
    public void setFingerHrPartimeAdminWeight(Double fingerHrPartimeAdminWeight) {
        this.fingerHrPartimeAdminWeight = fingerHrPartimeAdminWeight;
    }

    /**
     * 获取三级指标：兼职员工-销售
     *
     * @return finger_hr_partime_saler_weight - 三级指标：兼职员工-销售
     */
    public Double getFingerHrPartimeSalerWeight() {
        return fingerHrPartimeSalerWeight;
    }

    /**
     * 设置三级指标：兼职员工-销售
     *
     * @param fingerHrPartimeSalerWeight 三级指标：兼职员工-销售
     */
    public void setFingerHrPartimeSalerWeight(Double fingerHrPartimeSalerWeight) {
        this.fingerHrPartimeSalerWeight = fingerHrPartimeSalerWeight;
    }

    /**
     * 获取二级指标：全职员工
     *
     * @return finger_hr_fulltime_weight - 二级指标：全职员工
     */
    public Double getFingerHrFulltimeWeight() {
        return fingerHrFulltimeWeight;
    }

    /**
     * 设置二级指标：全职员工
     *
     * @param fingerHrFulltimeWeight 二级指标：全职员工
     */
    public void setFingerHrFulltimeWeight(Double fingerHrFulltimeWeight) {
        this.fingerHrFulltimeWeight = fingerHrFulltimeWeight;
    }

    /**
     * 获取三级指标：全职员工-研发
     *
     * @return finger_hr_fulltime_dev_weight - 三级指标：全职员工-研发
     */
    public Double getFingerHrFulltimeDevWeight() {
        return fingerHrFulltimeDevWeight;
    }

    /**
     * 设置三级指标：全职员工-研发
     *
     * @param fingerHrFulltimeDevWeight 三级指标：全职员工-研发
     */
    public void setFingerHrFulltimeDevWeight(Double fingerHrFulltimeDevWeight) {
        this.fingerHrFulltimeDevWeight = fingerHrFulltimeDevWeight;
    }

    /**
     * 获取三级指标：全职员工-高管
     *
     * @return finger_hr_fulltime_senior_weight - 三级指标：全职员工-高管
     */
    public Double getFingerHrFulltimeSeniorWeight() {
        return fingerHrFulltimeSeniorWeight;
    }

    /**
     * 设置三级指标：全职员工-高管
     *
     * @param fingerHrFulltimeSeniorWeight 三级指标：全职员工-高管
     */
    public void setFingerHrFulltimeSeniorWeight(Double fingerHrFulltimeSeniorWeight) {
        this.fingerHrFulltimeSeniorWeight = fingerHrFulltimeSeniorWeight;
    }

    /**
     * 获取三级指标：全职员工-行政
     *
     * @return finger_hr_fulltime_admin_weight - 三级指标：全职员工-行政
     */
    public Double getFingerHrFulltimeAdminWeight() {
        return fingerHrFulltimeAdminWeight;
    }

    /**
     * 设置三级指标：全职员工-行政
     *
     * @param fingerHrFulltimeAdminWeight 三级指标：全职员工-行政
     */
    public void setFingerHrFulltimeAdminWeight(Double fingerHrFulltimeAdminWeight) {
        this.fingerHrFulltimeAdminWeight = fingerHrFulltimeAdminWeight;
    }

    /**
     * 获取三级指标：全职员工-销售
     *
     * @return finger_hr_fulltime_saler_weight - 三级指标：全职员工-销售
     */
    public Double getFingerHrFulltimeSalerWeight() {
        return fingerHrFulltimeSalerWeight;
    }

    /**
     * 设置三级指标：全职员工-销售
     *
     * @param fingerHrFulltimeSalerWeight 三级指标：全职员工-销售
     */
    public void setFingerHrFulltimeSalerWeight(Double fingerHrFulltimeSalerWeight) {
        this.fingerHrFulltimeSalerWeight = fingerHrFulltimeSalerWeight;
    }

    /**
     * 获取二级指标：高学历人员
     *
     * @return finger_hr_educated_weight - 二级指标：高学历人员
     */
    public Double getFingerHrEducatedWeight() {
        return fingerHrEducatedWeight;
    }

    /**
     * 设置二级指标：高学历人员
     *
     * @param fingerHrEducatedWeight 二级指标：高学历人员
     */
    public void setFingerHrEducatedWeight(Double fingerHrEducatedWeight) {
        this.fingerHrEducatedWeight = fingerHrEducatedWeight;
    }

    /**
     * 获取三级指标：高学历人员-博士
     *
     * @return finger_hr_educated_doc_weight - 三级指标：高学历人员-博士
     */
    public Double getFingerHrEducatedDocWeight() {
        return fingerHrEducatedDocWeight;
    }

    /**
     * 设置三级指标：高学历人员-博士
     *
     * @param fingerHrEducatedDocWeight 三级指标：高学历人员-博士
     */
    public void setFingerHrEducatedDocWeight(Double fingerHrEducatedDocWeight) {
        this.fingerHrEducatedDocWeight = fingerHrEducatedDocWeight;
    }

    /**
     * 获取三级指标：高学历人员-硕士
     *
     * @return finger_hr_educated_master_weight - 三级指标：高学历人员-硕士
     */
    public Double getFingerHrEducatedMasterWeight() {
        return fingerHrEducatedMasterWeight;
    }

    /**
     * 设置三级指标：高学历人员-硕士
     *
     * @param fingerHrEducatedMasterWeight 三级指标：高学历人员-硕士
     */
    public void setFingerHrEducatedMasterWeight(Double fingerHrEducatedMasterWeight) {
        this.fingerHrEducatedMasterWeight = fingerHrEducatedMasterWeight;
    }

    /**
     * 获取三级指标：高学历人员-学士
     *
     * @return finger_hr_bachelor_weight - 三级指标：高学历人员-学士
     */
    public Double getFingerHrBachelorWeight() {
        return fingerHrBachelorWeight;
    }

    /**
     * 设置三级指标：高学历人员-学士
     *
     * @param fingerHrBachelorWeight 三级指标：高学历人员-学士
     */
    public void setFingerHrBachelorWeight(Double fingerHrBachelorWeight) {
        this.fingerHrBachelorWeight = fingerHrBachelorWeight;
    }

    /**
     * 获取一级指标：创新指数
     *
     * @return finger_innovate_weight - 一级指标：创新指数
     */
    public Double getFingerInnovateWeight() {
        return fingerInnovateWeight;
    }

    /**
     * 设置一级指标：创新指数
     *
     * @param fingerInnovateWeight 一级指标：创新指数
     */
    public void setFingerInnovateWeight(Double fingerInnovateWeight) {
        this.fingerInnovateWeight = fingerInnovateWeight;
    }

    /**
     * 获取二级指标：专利申请
     *
     * @return finger_innovate_patent_apply_weight - 二级指标：专利申请
     */
    public Double getFingerInnovatePatentApplyWeight() {
        return fingerInnovatePatentApplyWeight;
    }

    /**
     * 设置二级指标：专利申请
     *
     * @param fingerInnovatePatentApplyWeight 二级指标：专利申请
     */
    public void setFingerInnovatePatentApplyWeight(Double fingerInnovatePatentApplyWeight) {
        this.fingerInnovatePatentApplyWeight = fingerInnovatePatentApplyWeight;
    }

    /**
     * 获取三级指标：专利申请-发明
     *
     * @return finger_innovate_patent_apply_invention_weight - 三级指标：专利申请-发明
     */
    public Double getFingerInnovatePatentApplyInventionWeight() {
        return fingerInnovatePatentApplyInventionWeight;
    }

    /**
     * 设置三级指标：专利申请-发明
     *
     * @param fingerInnovatePatentApplyInventionWeight 三级指标：专利申请-发明
     */
    public void setFingerInnovatePatentApplyInventionWeight(Double fingerInnovatePatentApplyInventionWeight) {
        this.fingerInnovatePatentApplyInventionWeight = fingerInnovatePatentApplyInventionWeight;
    }

    /**
     * 获取三级指标：专利申请-实用新型
     *
     * @return finger_innovate_patent_apply_utility_weight - 三级指标：专利申请-实用新型
     */
    public Double getFingerInnovatePatentApplyUtilityWeight() {
        return fingerInnovatePatentApplyUtilityWeight;
    }

    /**
     * 设置三级指标：专利申请-实用新型
     *
     * @param fingerInnovatePatentApplyUtilityWeight 三级指标：专利申请-实用新型
     */
    public void setFingerInnovatePatentApplyUtilityWeight(Double fingerInnovatePatentApplyUtilityWeight) {
        this.fingerInnovatePatentApplyUtilityWeight = fingerInnovatePatentApplyUtilityWeight;
    }

    /**
     * 获取三级指标：专利申请-外观设计
     *
     * @return finger_innovate_patent_apply_appear_weight - 三级指标：专利申请-外观设计
     */
    public Double getFingerInnovatePatentApplyAppearWeight() {
        return fingerInnovatePatentApplyAppearWeight;
    }

    /**
     * 设置三级指标：专利申请-外观设计
     *
     * @param fingerInnovatePatentApplyAppearWeight 三级指标：专利申请-外观设计
     */
    public void setFingerInnovatePatentApplyAppearWeight(Double fingerInnovatePatentApplyAppearWeight) {
        this.fingerInnovatePatentApplyAppearWeight = fingerInnovatePatentApplyAppearWeight;
    }

    /**
     * 获取二级指标：专利授权
     *
     * @return finger_innovate_patent_grant_weight - 二级指标：专利授权
     */
    public Double getFingerInnovatePatentGrantWeight() {
        return fingerInnovatePatentGrantWeight;
    }

    /**
     * 设置二级指标：专利授权
     *
     * @param fingerInnovatePatentGrantWeight 二级指标：专利授权
     */
    public void setFingerInnovatePatentGrantWeight(Double fingerInnovatePatentGrantWeight) {
        this.fingerInnovatePatentGrantWeight = fingerInnovatePatentGrantWeight;
    }

    /**
     * 获取三级指标：专利授权-发明
     *
     * @return finger_innovate_patent_grant_invention_weight - 三级指标：专利授权-发明
     */
    public Double getFingerInnovatePatentGrantInventionWeight() {
        return fingerInnovatePatentGrantInventionWeight;
    }

    /**
     * 设置三级指标：专利授权-发明
     *
     * @param fingerInnovatePatentGrantInventionWeight 三级指标：专利授权-发明
     */
    public void setFingerInnovatePatentGrantInventionWeight(Double fingerInnovatePatentGrantInventionWeight) {
        this.fingerInnovatePatentGrantInventionWeight = fingerInnovatePatentGrantInventionWeight;
    }

    /**
     * 获取三级指标：专利授权-实用新型
     *
     * @return finger_innovate_patent_grant_utility_weight - 三级指标：专利授权-实用新型
     */
    public Double getFingerInnovatePatentGrantUtilityWeight() {
        return fingerInnovatePatentGrantUtilityWeight;
    }

    /**
     * 设置三级指标：专利授权-实用新型
     *
     * @param fingerInnovatePatentGrantUtilityWeight 三级指标：专利授权-实用新型
     */
    public void setFingerInnovatePatentGrantUtilityWeight(Double fingerInnovatePatentGrantUtilityWeight) {
        this.fingerInnovatePatentGrantUtilityWeight = fingerInnovatePatentGrantUtilityWeight;
    }

    /**
     * 获取三级指标：专利授权-外观设计
     *
     * @return finger_innovate_patent_grant_appear_weight - 三级指标：专利授权-外观设计
     */
    public Double getFingerInnovatePatentGrantAppearWeight() {
        return fingerInnovatePatentGrantAppearWeight;
    }

    /**
     * 设置三级指标：专利授权-外观设计
     *
     * @param fingerInnovatePatentGrantAppearWeight 三级指标：专利授权-外观设计
     */
    public void setFingerInnovatePatentGrantAppearWeight(Double fingerInnovatePatentGrantAppearWeight) {
        this.fingerInnovatePatentGrantAppearWeight = fingerInnovatePatentGrantAppearWeight;
    }

    /**
     * 获取二级指标：著作权申请
     *
     * @return finger_innovate_copyright_apply_weight - 二级指标：著作权申请
     */
    public Double getFingerInnovateCopyrightApplyWeight() {
        return fingerInnovateCopyrightApplyWeight;
    }

    /**
     * 设置二级指标：著作权申请
     *
     * @param fingerInnovateCopyrightApplyWeight 二级指标：著作权申请
     */
    public void setFingerInnovateCopyrightApplyWeight(Double fingerInnovateCopyrightApplyWeight) {
        this.fingerInnovateCopyrightApplyWeight = fingerInnovateCopyrightApplyWeight;
    }

    /**
     * 获取三级指标：著作权申请-软件类
     *
     * @return finger_innovate_copyright_apply_soft_weight - 三级指标：著作权申请-软件类
     */
    public Double getFingerInnovateCopyrightApplySoftWeight() {
        return fingerInnovateCopyrightApplySoftWeight;
    }

    /**
     * 设置三级指标：著作权申请-软件类
     *
     * @param fingerInnovateCopyrightApplySoftWeight 三级指标：著作权申请-软件类
     */
    public void setFingerInnovateCopyrightApplySoftWeight(Double fingerInnovateCopyrightApplySoftWeight) {
        this.fingerInnovateCopyrightApplySoftWeight = fingerInnovateCopyrightApplySoftWeight;
    }

    /**
     * 获取三级指标：著作权申请-非软件类
     *
     * @return finger_innovate_copyright_apply_unsoft_weight - 三级指标：著作权申请-非软件类
     */
    public Double getFingerInnovateCopyrightApplyUnsoftWeight() {
        return fingerInnovateCopyrightApplyUnsoftWeight;
    }

    /**
     * 设置三级指标：著作权申请-非软件类
     *
     * @param fingerInnovateCopyrightApplyUnsoftWeight 三级指标：著作权申请-非软件类
     */
    public void setFingerInnovateCopyrightApplyUnsoftWeight(Double fingerInnovateCopyrightApplyUnsoftWeight) {
        this.fingerInnovateCopyrightApplyUnsoftWeight = fingerInnovateCopyrightApplyUnsoftWeight;
    }

    /**
     * 获取二级指标：著作权授权
     *
     * @return finger_innovate_copyright_grant_weight - 二级指标：著作权授权
     */
    public Double getFingerInnovateCopyrightGrantWeight() {
        return fingerInnovateCopyrightGrantWeight;
    }

    /**
     * 设置二级指标：著作权授权
     *
     * @param fingerInnovateCopyrightGrantWeight 二级指标：著作权授权
     */
    public void setFingerInnovateCopyrightGrantWeight(Double fingerInnovateCopyrightGrantWeight) {
        this.fingerInnovateCopyrightGrantWeight = fingerInnovateCopyrightGrantWeight;
    }

    /**
     * 获取三级指标：著作权授权-软件类
     *
     * @return finger_innovate_copyright_grant_soft_weight - 三级指标：著作权授权-软件类
     */
    public Double getFingerInnovateCopyrightGrantSoftWeight() {
        return fingerInnovateCopyrightGrantSoftWeight;
    }

    /**
     * 设置三级指标：著作权授权-软件类
     *
     * @param fingerInnovateCopyrightGrantSoftWeight 三级指标：著作权授权-软件类
     */
    public void setFingerInnovateCopyrightGrantSoftWeight(Double fingerInnovateCopyrightGrantSoftWeight) {
        this.fingerInnovateCopyrightGrantSoftWeight = fingerInnovateCopyrightGrantSoftWeight;
    }

    /**
     * 获取三级指标：著作权授权-非软件类
     *
     * @return finger_innovate_copyright_grant_unsoft_weight - 三级指标：著作权授权-非软件类
     */
    public Double getFingerInnovateCopyrightGrantUnsoftWeight() {
        return fingerInnovateCopyrightGrantUnsoftWeight;
    }

    /**
     * 设置三级指标：著作权授权-非软件类
     *
     * @param fingerInnovateCopyrightGrantUnsoftWeight 三级指标：著作权授权-非软件类
     */
    public void setFingerInnovateCopyrightGrantUnsoftWeight(Double fingerInnovateCopyrightGrantUnsoftWeight) {
        this.fingerInnovateCopyrightGrantUnsoftWeight = fingerInnovateCopyrightGrantUnsoftWeight;
    }

    /**
     * 获取二级指标：新产品/服务
     *
     * @return finger_innovate_new_product_weight - 二级指标：新产品/服务
     */
    public Double getFingerInnovateNewProductWeight() {
        return fingerInnovateNewProductWeight;
    }

    /**
     * 设置二级指标：新产品/服务
     *
     * @param fingerInnovateNewProductWeight 二级指标：新产品/服务
     */
    public void setFingerInnovateNewProductWeight(Double fingerInnovateNewProductWeight) {
        this.fingerInnovateNewProductWeight = fingerInnovateNewProductWeight;
    }

    /**
     * 获取三级指标：新产品/服务-专利类
     *
     * @return finger_innovate_new_product_patent_weight - 三级指标：新产品/服务-专利类
     */
    public Double getFingerInnovateNewProductPatentWeight() {
        return fingerInnovateNewProductPatentWeight;
    }

    /**
     * 设置三级指标：新产品/服务-专利类
     *
     * @param fingerInnovateNewProductPatentWeight 三级指标：新产品/服务-专利类
     */
    public void setFingerInnovateNewProductPatentWeight(Double fingerInnovateNewProductPatentWeight) {
        this.fingerInnovateNewProductPatentWeight = fingerInnovateNewProductPatentWeight;
    }

    /**
     * 获取三级指标：新产品/服务-专用技术
     *
     * @return finger_innovate_new_product_tech_weight - 三级指标：新产品/服务-专用技术
     */
    public Double getFingerInnovateNewProductTechWeight() {
        return fingerInnovateNewProductTechWeight;
    }

    /**
     * 设置三级指标：新产品/服务-专用技术
     *
     * @param fingerInnovateNewProductTechWeight 三级指标：新产品/服务-专用技术
     */
    public void setFingerInnovateNewProductTechWeight(Double fingerInnovateNewProductTechWeight) {
        this.fingerInnovateNewProductTechWeight = fingerInnovateNewProductTechWeight;
    }

    /**
     * 获取三级指标：新产品/服务-商业模式
     *
     * @return finger_innovate_new_product_bus_weight - 三级指标：新产品/服务-商业模式
     */
    public Double getFingerInnovateNewProductBusWeight() {
        return fingerInnovateNewProductBusWeight;
    }

    /**
     * 设置三级指标：新产品/服务-商业模式
     *
     * @param fingerInnovateNewProductBusWeight 三级指标：新产品/服务-商业模式
     */
    public void setFingerInnovateNewProductBusWeight(Double fingerInnovateNewProductBusWeight) {
        this.fingerInnovateNewProductBusWeight = fingerInnovateNewProductBusWeight;
    }

    /**
     * 获取一级指标：薪酬指数
     *
     * @return finger_salary_weight - 一级指标：薪酬指数
     */
    public Double getFingerSalaryWeight() {
        return fingerSalaryWeight;
    }

    /**
     * 设置一级指标：薪酬指数
     *
     * @param fingerSalaryWeight 一级指标：薪酬指数
     */
    public void setFingerSalaryWeight(Double fingerSalaryWeight) {
        this.fingerSalaryWeight = fingerSalaryWeight;
    }

    /**
     * 获取二级指标：员工工资额
     *
     * @return finger_salary_staff_weight - 二级指标：员工工资额
     */
    public Double getFingerSalaryStaffWeight() {
        return fingerSalaryStaffWeight;
    }

    /**
     * 设置二级指标：员工工资额
     *
     * @param fingerSalaryStaffWeight 二级指标：员工工资额
     */
    public void setFingerSalaryStaffWeight(Double fingerSalaryStaffWeight) {
        this.fingerSalaryStaffWeight = fingerSalaryStaffWeight;
    }

    /**
     * 获取三级指标：员工工资额-1万元以上
     *
     * @return finger_salary_staff_up_10_weight - 三级指标：员工工资额-1万元以上
     */
    public Double getFingerSalaryStaffUp10Weight() {
        return fingerSalaryStaffUp10Weight;
    }

    /**
     * 设置三级指标：员工工资额-1万元以上
     *
     * @param fingerSalaryStaffUp10Weight 三级指标：员工工资额-1万元以上
     */
    public void setFingerSalaryStaffUp10Weight(Double fingerSalaryStaffUp10Weight) {
        this.fingerSalaryStaffUp10Weight = fingerSalaryStaffUp10Weight;
    }

    /**
     * 获取三级指标：员工工资额-5千到1万
     *
     * @return finger_salary_staff_5_10_weight - 三级指标：员工工资额-5千到1万
     */
    public Double getFingerSalaryStaff510Weight() {
        return fingerSalaryStaff510Weight;
    }

    /**
     * 设置三级指标：员工工资额-5千到1万
     *
     * @param fingerSalaryStaff510Weight 三级指标：员工工资额-5千到1万
     */
    public void setFingerSalaryStaff510Weight(Double fingerSalaryStaff510Weight) {
        this.fingerSalaryStaff510Weight = fingerSalaryStaff510Weight;
    }

    /**
     * 获取三级指标：员工工资额-5千以下
     *
     * @return finger_salary_staff_down_5_weight - 三级指标：员工工资额-5千以下
     */
    public Double getFingerSalaryStaffDown5Weight() {
        return fingerSalaryStaffDown5Weight;
    }

    /**
     * 设置三级指标：员工工资额-5千以下
     *
     * @param fingerSalaryStaffDown5Weight 三级指标：员工工资额-5千以下
     */
    public void setFingerSalaryStaffDown5Weight(Double fingerSalaryStaffDown5Weight) {
        this.fingerSalaryStaffDown5Weight = fingerSalaryStaffDown5Weight;
    }

    /**
     * 获取二级指标：员工贡献率
     *
     * @return finger_salary_staff_contribution_weight - 二级指标：员工贡献率
     */
    public Double getFingerSalaryStaffContributionWeight() {
        return fingerSalaryStaffContributionWeight;
    }

    /**
     * 设置二级指标：员工贡献率
     *
     * @param fingerSalaryStaffContributionWeight 二级指标：员工贡献率
     */
    public void setFingerSalaryStaffContributionWeight(Double fingerSalaryStaffContributionWeight) {
        this.fingerSalaryStaffContributionWeight = fingerSalaryStaffContributionWeight;
    }

    /**
     * 获取三级指标：员工贡献率-人均销售
     *
     * @return finger_salary_staff_contribution_meansale_weight - 三级指标：员工贡献率-人均销售
     */
    public Double getFingerSalaryStaffContributionMeansaleWeight() {
        return fingerSalaryStaffContributionMeansaleWeight;
    }

    /**
     * 设置三级指标：员工贡献率-人均销售
     *
     * @param fingerSalaryStaffContributionMeansaleWeight 三级指标：员工贡献率-人均销售
     */
    public void setFingerSalaryStaffContributionMeansaleWeight(Double fingerSalaryStaffContributionMeansaleWeight) {
        this.fingerSalaryStaffContributionMeansaleWeight = fingerSalaryStaffContributionMeansaleWeight;
    }

    /**
     * 获取三级指标：员工贡献率-人均纳税
     *
     * @return finger_salary_staff_contribution_meantax_weight - 三级指标：员工贡献率-人均纳税
     */
    public Double getFingerSalaryStaffContributionMeantaxWeight() {
        return fingerSalaryStaffContributionMeantaxWeight;
    }

    /**
     * 设置三级指标：员工贡献率-人均纳税
     *
     * @param fingerSalaryStaffContributionMeantaxWeight 三级指标：员工贡献率-人均纳税
     */
    public void setFingerSalaryStaffContributionMeantaxWeight(Double fingerSalaryStaffContributionMeantaxWeight) {
        this.fingerSalaryStaffContributionMeantaxWeight = fingerSalaryStaffContributionMeantaxWeight;
    }

    /**
     * 获取一级指标：学习指数
     *
     * @return finger_learn_weight - 一级指标：学习指数
     */
    public Double getFingerLearnWeight() {
        return fingerLearnWeight;
    }

    /**
     * 设置一级指标：学习指数
     *
     * @param fingerLearnWeight 一级指标：学习指数
     */
    public void setFingerLearnWeight(Double fingerLearnWeight) {
        this.fingerLearnWeight = fingerLearnWeight;
    }

    /**
     * 获取二级指标：参加培训的次数
     *
     * @return finger_learn_train_weight - 二级指标：参加培训的次数
     */
    public Double getFingerLearnTrainWeight() {
        return fingerLearnTrainWeight;
    }

    /**
     * 设置二级指标：参加培训的次数
     *
     * @param fingerLearnTrainWeight 二级指标：参加培训的次数
     */
    public void setFingerLearnTrainWeight(Double fingerLearnTrainWeight) {
        this.fingerLearnTrainWeight = fingerLearnTrainWeight;
    }

    /**
     * 获取三级指标：参加培训的次数-管理类
     *
     * @return finger_learn_train_manage_weight - 三级指标：参加培训的次数-管理类
     */
    public Double getFingerLearnTrainManageWeight() {
        return fingerLearnTrainManageWeight;
    }

    /**
     * 设置三级指标：参加培训的次数-管理类
     *
     * @param fingerLearnTrainManageWeight 三级指标：参加培训的次数-管理类
     */
    public void setFingerLearnTrainManageWeight(Double fingerLearnTrainManageWeight) {
        this.fingerLearnTrainManageWeight = fingerLearnTrainManageWeight;
    }

    /**
     * 获取三级指标：参加培训的次数-政策法规
     *
     * @return finger_learn_train_policy_weight - 三级指标：参加培训的次数-政策法规
     */
    public Double getFingerLearnTrainPolicyWeight() {
        return fingerLearnTrainPolicyWeight;
    }

    /**
     * 设置三级指标：参加培训的次数-政策法规
     *
     * @param fingerLearnTrainPolicyWeight 三级指标：参加培训的次数-政策法规
     */
    public void setFingerLearnTrainPolicyWeight(Double fingerLearnTrainPolicyWeight) {
        this.fingerLearnTrainPolicyWeight = fingerLearnTrainPolicyWeight;
    }

    /**
     * 获取三级指标：参加培训的次数-技能类
     *
     * @return finger_learn_train_skill_weight - 三级指标：参加培训的次数-技能类
     */
    public Double getFingerLearnTrainSkillWeight() {
        return fingerLearnTrainSkillWeight;
    }

    /**
     * 设置三级指标：参加培训的次数-技能类
     *
     * @param fingerLearnTrainSkillWeight 三级指标：参加培训的次数-技能类
     */
    public void setFingerLearnTrainSkillWeight(Double fingerLearnTrainSkillWeight) {
        this.fingerLearnTrainSkillWeight = fingerLearnTrainSkillWeight;
    }

    /**
     * 获取二级指标：接受咨询的次数
     *
     * @return finger_learn_conslted_weight - 二级指标：接受咨询的次数
     */
    public Double getFingerLearnConsltedWeight() {
        return fingerLearnConsltedWeight;
    }

    /**
     * 设置二级指标：接受咨询的次数
     *
     * @param fingerLearnConsltedWeight 二级指标：接受咨询的次数
     */
    public void setFingerLearnConsltedWeight(Double fingerLearnConsltedWeight) {
        this.fingerLearnConsltedWeight = fingerLearnConsltedWeight;
    }

    /**
     * 获取三级指标：接受咨询的次数-管理类
     *
     * @return finger_learn_conslted_manage_weight - 三级指标：接受咨询的次数-管理类
     */
    public Double getFingerLearnConsltedManageWeight() {
        return fingerLearnConsltedManageWeight;
    }

    /**
     * 设置三级指标：接受咨询的次数-管理类
     *
     * @param fingerLearnConsltedManageWeight 三级指标：接受咨询的次数-管理类
     */
    public void setFingerLearnConsltedManageWeight(Double fingerLearnConsltedManageWeight) {
        this.fingerLearnConsltedManageWeight = fingerLearnConsltedManageWeight;
    }

    /**
     * 获取三级指标：接受咨询的次数-政策法规
     *
     * @return finger_learn_conslted_policy_weight - 三级指标：接受咨询的次数-政策法规
     */
    public Double getFingerLearnConsltedPolicyWeight() {
        return fingerLearnConsltedPolicyWeight;
    }

    /**
     * 设置三级指标：接受咨询的次数-政策法规
     *
     * @param fingerLearnConsltedPolicyWeight 三级指标：接受咨询的次数-政策法规
     */
    public void setFingerLearnConsltedPolicyWeight(Double fingerLearnConsltedPolicyWeight) {
        this.fingerLearnConsltedPolicyWeight = fingerLearnConsltedPolicyWeight;
    }

    /**
     * 获取三级指标：接受咨询的次数-技能类
     *
     * @return finger_learn_conslted_skill_weight - 三级指标：接受咨询的次数-技能类
     */
    public Double getFingerLearnConsltedSkillWeight() {
        return fingerLearnConsltedSkillWeight;
    }

    /**
     * 设置三级指标：接受咨询的次数-技能类
     *
     * @param fingerLearnConsltedSkillWeight 三级指标：接受咨询的次数-技能类
     */
    public void setFingerLearnConsltedSkillWeight(Double fingerLearnConsltedSkillWeight) {
        this.fingerLearnConsltedSkillWeight = fingerLearnConsltedSkillWeight;
    }

    /**
     * 获取一级指标：品牌指数
     *
     * @return finger_brand_weight - 一级指标：品牌指数
     */
    public Double getFingerBrandWeight() {
        return fingerBrandWeight;
    }

    /**
     * 设置一级指标：品牌指数
     *
     * @param fingerBrandWeight 一级指标：品牌指数
     */
    public void setFingerBrandWeight(Double fingerBrandWeight) {
        this.fingerBrandWeight = fingerBrandWeight;
    }

    /**
     * 获取二级指标：企业获奖
     *
     * @return finger_brand_reward_weight - 二级指标：企业获奖
     */
    public Double getFingerBrandRewardWeight() {
        return fingerBrandRewardWeight;
    }

    /**
     * 设置二级指标：企业获奖
     *
     * @param fingerBrandRewardWeight 二级指标：企业获奖
     */
    public void setFingerBrandRewardWeight(Double fingerBrandRewardWeight) {
        this.fingerBrandRewardWeight = fingerBrandRewardWeight;
    }

    /**
     * 获取三级指标：企业获奖-区级
     *
     * @return finger_brand_reward_area_weight - 三级指标：企业获奖-区级
     */
    public Double getFingerBrandRewardAreaWeight() {
        return fingerBrandRewardAreaWeight;
    }

    /**
     * 设置三级指标：企业获奖-区级
     *
     * @param fingerBrandRewardAreaWeight 三级指标：企业获奖-区级
     */
    public void setFingerBrandRewardAreaWeight(Double fingerBrandRewardAreaWeight) {
        this.fingerBrandRewardAreaWeight = fingerBrandRewardAreaWeight;
    }

    /**
     * 获取三级指标：企业获奖-市级
     *
     * @return finger_brand_reward_city_weight - 三级指标：企业获奖-市级
     */
    public Double getFingerBrandRewardCityWeight() {
        return fingerBrandRewardCityWeight;
    }

    /**
     * 设置三级指标：企业获奖-市级
     *
     * @param fingerBrandRewardCityWeight 三级指标：企业获奖-市级
     */
    public void setFingerBrandRewardCityWeight(Double fingerBrandRewardCityWeight) {
        this.fingerBrandRewardCityWeight = fingerBrandRewardCityWeight;
    }

    /**
     * 获取三级指标：企业获奖-省级
     *
     * @return finger_brand_reward_province_weight - 三级指标：企业获奖-省级
     */
    public Double getFingerBrandRewardProvinceWeight() {
        return fingerBrandRewardProvinceWeight;
    }

    /**
     * 设置三级指标：企业获奖-省级
     *
     * @param fingerBrandRewardProvinceWeight 三级指标：企业获奖-省级
     */
    public void setFingerBrandRewardProvinceWeight(Double fingerBrandRewardProvinceWeight) {
        this.fingerBrandRewardProvinceWeight = fingerBrandRewardProvinceWeight;
    }

    /**
     * 获取三级指标：企业获奖-国家级
     *
     * @return finger_brand_reward_country_weight - 三级指标：企业获奖-国家级
     */
    public Double getFingerBrandRewardCountryWeight() {
        return fingerBrandRewardCountryWeight;
    }

    /**
     * 设置三级指标：企业获奖-国家级
     *
     * @param fingerBrandRewardCountryWeight 三级指标：企业获奖-国家级
     */
    public void setFingerBrandRewardCountryWeight(Double fingerBrandRewardCountryWeight) {
        this.fingerBrandRewardCountryWeight = fingerBrandRewardCountryWeight;
    }

    /**
     * 获取二级指标：企业认定
     *
     * @return finger_brand_recognition_weight - 二级指标：企业认定
     */
    public Double getFingerBrandRecognitionWeight() {
        return fingerBrandRecognitionWeight;
    }

    /**
     * 设置二级指标：企业认定
     *
     * @param fingerBrandRecognitionWeight 二级指标：企业认定
     */
    public void setFingerBrandRecognitionWeight(Double fingerBrandRecognitionWeight) {
        this.fingerBrandRecognitionWeight = fingerBrandRecognitionWeight;
    }

    /**
     * 获取三级指标：企业认定-区级
     *
     * @return finger_brand_recognition_area_weight - 三级指标：企业认定-区级
     */
    public Double getFingerBrandRecognitionAreaWeight() {
        return fingerBrandRecognitionAreaWeight;
    }

    /**
     * 设置三级指标：企业认定-区级
     *
     * @param fingerBrandRecognitionAreaWeight 三级指标：企业认定-区级
     */
    public void setFingerBrandRecognitionAreaWeight(Double fingerBrandRecognitionAreaWeight) {
        this.fingerBrandRecognitionAreaWeight = fingerBrandRecognitionAreaWeight;
    }

    /**
     * 获取三级指标：企业认定-市级
     *
     * @return finger_brand_recognition_city_weight - 三级指标：企业认定-市级
     */
    public Double getFingerBrandRecognitionCityWeight() {
        return fingerBrandRecognitionCityWeight;
    }

    /**
     * 设置三级指标：企业认定-市级
     *
     * @param fingerBrandRecognitionCityWeight 三级指标：企业认定-市级
     */
    public void setFingerBrandRecognitionCityWeight(Double fingerBrandRecognitionCityWeight) {
        this.fingerBrandRecognitionCityWeight = fingerBrandRecognitionCityWeight;
    }

    /**
     * 获取三级指标：企业认定-省级
     *
     * @return finger_brand_recognition_province_weight - 三级指标：企业认定-省级
     */
    public Double getFingerBrandRecognitionProvinceWeight() {
        return fingerBrandRecognitionProvinceWeight;
    }

    /**
     * 设置三级指标：企业认定-省级
     *
     * @param fingerBrandRecognitionProvinceWeight 三级指标：企业认定-省级
     */
    public void setFingerBrandRecognitionProvinceWeight(Double fingerBrandRecognitionProvinceWeight) {
        this.fingerBrandRecognitionProvinceWeight = fingerBrandRecognitionProvinceWeight;
    }

    /**
     * 获取三级指标：企业认定-国家级
     *
     * @return finger_brand_recognition_country_weight - 三级指标：企业认定-国家级
     */
    public Double getFingerBrandRecognitionCountryWeight() {
        return fingerBrandRecognitionCountryWeight;
    }

    /**
     * 设置三级指标：企业认定-国家级
     *
     * @param fingerBrandRecognitionCountryWeight 三级指标：企业认定-国家级
     */
    public void setFingerBrandRecognitionCountryWeight(Double fingerBrandRecognitionCountryWeight) {
        this.fingerBrandRecognitionCountryWeight = fingerBrandRecognitionCountryWeight;
    }

    /**
     * 获取二级指标：人才资助
     *
     * @return finger_brand_talent_weight - 二级指标：人才资助
     */
    public Double getFingerBrandTalentWeight() {
        return fingerBrandTalentWeight;
    }

    /**
     * 设置二级指标：人才资助
     *
     * @param fingerBrandTalentWeight 二级指标：人才资助
     */
    public void setFingerBrandTalentWeight(Double fingerBrandTalentWeight) {
        this.fingerBrandTalentWeight = fingerBrandTalentWeight;
    }

    /**
     * 获取三级指标：人才资助-区级
     *
     * @return finger_brand_talent_area_weight - 三级指标：人才资助-区级
     */
    public Double getFingerBrandTalentAreaWeight() {
        return fingerBrandTalentAreaWeight;
    }

    /**
     * 设置三级指标：人才资助-区级
     *
     * @param fingerBrandTalentAreaWeight 三级指标：人才资助-区级
     */
    public void setFingerBrandTalentAreaWeight(Double fingerBrandTalentAreaWeight) {
        this.fingerBrandTalentAreaWeight = fingerBrandTalentAreaWeight;
    }

    /**
     * 获取三级指标：人才资助-市级
     *
     * @return finger_brand_talent_city_weight - 三级指标：人才资助-市级
     */
    public Double getFingerBrandTalentCityWeight() {
        return fingerBrandTalentCityWeight;
    }

    /**
     * 设置三级指标：人才资助-市级
     *
     * @param fingerBrandTalentCityWeight 三级指标：人才资助-市级
     */
    public void setFingerBrandTalentCityWeight(Double fingerBrandTalentCityWeight) {
        this.fingerBrandTalentCityWeight = fingerBrandTalentCityWeight;
    }

    /**
     * 获取三级指标：人才资助-省级
     *
     * @return finger_brand_talent_province_weight - 三级指标：人才资助-省级
     */
    public Double getFingerBrandTalentProvinceWeight() {
        return fingerBrandTalentProvinceWeight;
    }

    /**
     * 设置三级指标：人才资助-省级
     *
     * @param fingerBrandTalentProvinceWeight 三级指标：人才资助-省级
     */
    public void setFingerBrandTalentProvinceWeight(Double fingerBrandTalentProvinceWeight) {
        this.fingerBrandTalentProvinceWeight = fingerBrandTalentProvinceWeight;
    }

    /**
     * 获取三级指标：人才资助-国家级
     *
     * @return finger_brand_talent_country_weight - 三级指标：人才资助-国家级
     */
    public Double getFingerBrandTalentCountryWeight() {
        return fingerBrandTalentCountryWeight;
    }

    /**
     * 设置三级指标：人才资助-国家级
     *
     * @param fingerBrandTalentCountryWeight 三级指标：人才资助-国家级
     */
    public void setFingerBrandTalentCountryWeight(Double fingerBrandTalentCountryWeight) {
        this.fingerBrandTalentCountryWeight = fingerBrandTalentCountryWeight;
    }
}