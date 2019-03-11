package com.swu.ai.entity;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.Date;
import javax.persistence.*;

@Setter
@Getter
@Table(name = "evaluate_result")
public class EvaluateResult {
    @Id
    private Long id;

    @Column(name = "company_id")
    private Long companyId;

    /**
     * 选用评估权重的ID
     */
    @Column(name = "figure_id")
    private Long figureId;

    /**
     * 评估日期
     */
    @Column(name = "evaluate_date")
    private Date evaluateDate;

    /**
     * 评估方式 (均值，最大值，最小值，n分位数)
     */
    @Column(name = "evaluate_type")
    private String evaluateType;

    /**
     * 评估范围 所在行业
     */
    private String industry;

    /**
     * 评估范围 所在地区
     */
    private String region;

    /**
     * 评估条件 起始年份
     */
    @Column(name = "begin_year")
    private Integer beginYear;

    /**
     * 评估范围 终止年份
     */
    @Column(name = "end_year")
    private Integer endYear;

    /**
     * 评估范围 起始季度
     */
    @Column(name = "begin_quarter")
    private Integer beginQuarter;

    /**
     * 评估范围 终止季度
     */
    @Column(name = "end_quarter")
    private Integer endQuarter;

    /**
     * 综合指数
     */
    @Column(name = "figure_all")
    private Double figureAll;

    /**
     * 一级指标：销售指数
     */
    @Column(name = "figure_sale")
    private Double figureSale;

    /**
     * 二级指标：已开票的收入
     */
    @Column(name = "figure_sale_invoice")
    private Double figureSaleInvoice;

    /**
     * 已开发票的收入-软件产品
     */
    @Column(name = "figure_sale_invoice_soft")
    private Double figureSaleInvoiceSoft;

    /**
     * 已开发票的收入-硬件产品
     */
    @Column(name = "figure_sale_invoice_hard")
    private Double figureSaleInvoiceHard;

    /**
     * 已开发票的收入-咨询服务
     */
    @Column(name = "figure_sale_invoice_consultation")
    private Double figureSaleInvoiceConsultation;

    /**
     * 已开发票的收入-其他
     */
    @Column(name = "figure_sale_invoice_other")
    private Double figureSaleInvoiceOther;

    /**
     * 二级指标：合同确认额
     */
    @Column(name = "figure_sale_contract")
    private Double figureSaleContract;

    /**
     * 三级指标：合同确认额-软件产品
     */
    @Column(name = "figure_sale_contract_soft")
    private Double figureSaleContractSoft;

    /**
     * 三级指标：合同确认额-硬件产品
     */
    @Column(name = "figure_sale_contract_hard")
    private Double figureSaleContractHard;

    /**
     * 三级指标：合同确认额-咨询服务
     */
    @Column(name = "figure_sale_contract_consultation")
    private Double figureSaleContractConsultation;

    /**
     * 三级指标：合同确认额-其他
     */
    @Column(name = "figure_sale_contract_other")
    private Double figureSaleContractOther;

    /**
     * 一级指标：纳税指数
     */
    @Column(name = "figure_tax")
    private Double figureTax;

    /**
     * 二级指标：企业所得税
     */
    @Column(name = "figure_tax_corporate")
    private Double figureTaxCorporate;

    /**
     * 三级指标：企业所得税-应纳税值
     */
    @Column(name = "figure_tax_corporate_taxable")
    private Double figureTaxCorporateTaxable;

    /**
     * 三级指标：企业所得税-税收减免值
     */
    @Column(name = "figure_tax_corporate_relief")
    private Double figureTaxCorporateRelief;

    /**
     * 二级指标：个人所得税
     */
    @Column(name = "figure_tax_individual")
    private Double figureTaxIndividual;

    /**
     * 三级指标：个人所得税-应纳税值
     */
    @Column(name = "figure_tax_individual_taxable")
    private Double figureTaxIndividualTaxable;

    /**
     * 三级指标：个人所得税-税收减免
     */
    @Column(name = "figure_tax_individual_relief")
    private Double figureTaxIndividualRelief;

    /**
     * 二级指标：增值税
     */
    @Column(name = "figure_tax_added")
    private Double figureTaxAdded;

    /**
     * 三级指标：增值税-应纳税值
     */
    @Column(name = "figure_tax_added_taxable")
    private Double figureTaxAddedTaxable;

    /**
     * 三级指标：增值税-税收减免
     */
    @Column(name = "figure_tax_added_relief")
    private Double figureTaxAddedRelief;

    /**
     * 一级指标：融资指数
     */
    @Column(name = "figure_finance")
    private Double figureFinance;

    /**
     * 二级指标：股权类融资
     */
    @Column(name = "figure_finance_stock")
    private Double figureFinanceStock;

    /**
     * 三级指标：股权类融资-风投机构
     */
    @Column(name = "figure_finance_stock_risk")
    private Double figureFinanceStockRisk;

    /**
     * 三级指标：股权类融资-政府企业
     */
    @Column(name = "figure_finance_stock_gov")
    private Double figureFinanceStockGov;

    /**
     * 三级指标：股权类融资-个人
     */
    @Column(name = "figure_finance_stock_person")
    private Double figureFinanceStockPerson;

    /**
     * 二级指标：债务类融资
     */
    @Column(name = "figure_finance_debt")
    private Double figureFinanceDebt;

    /**
     * 三级指标：债务类融资-银行
     */
    @Column(name = "figure_finance_debt_bank")
    private Double figureFinanceDebtBank;

    /**
     * 三级指标：债务类融资-新型贷款机构
     */
    @Column(name = "figure_finance_debt_new")
    private Double figureFinanceDebtNew;

    /**
     * 三级指标：债务类融资-企业拆借
     */
    @Column(name = "figure_finance_debt_lending")
    private Double figureFinanceDebtLending;

    /**
     * 三级指标：债务类融资-个人
     */
    @Column(name = "figure_finance_debt_person")
    private Double figureFinanceDebtPerson;

    /**
     * 一级指标:估值指数
     */
    @Column(name = "figure_valuation")
    private Double figureValuation;

    /**
     * 二级指标：净资产
     */
    @Column(name = "figure_valuation_assets")
    private Double figureValuationAssets;

    /**
     * 三级指标：净资产-流动资产
     */
    @Column(name = "figure_valuation_assets_circulating")
    private Double figureValuationAssetsCirculating;

    /**
     * 三级指标：净资产-非流动资产
     */
    @Column(name = "figure_valuation_assets_uncirculating")
    private Double figureValuationAssetsUncirculating;

    /**
     * 三级指标：净资产-流动负债
     */
    @Column(name = "figure_valuation_assets_debt_circulating")
    private Double figureValuationAssetsDebtCirculating;

    /**
     * 三级指标：净资产-非流动负债
     */
    @Column(name = "figure_valuation_assets_debt_uncirculating")
    private Double figureValuationAssetsDebtUncirculating;

    /**
     * 二级指标：实际估值
     */
    @Column(name = "figure_valuation_actual")
    private Double figureValuationActual;

    /**
     * 三级指标：实际估值-首次融资
     */
    @Column(name = "figure_valuation_actual_first")
    private Double figureValuationActualFirst;

    /**
     * 三级指标：实际估值-最近一次融资估值
     */
    @Column(name = "figure_valuation_actual_latest")
    private Double figureValuationActualLatest;

    /**
     * 三级指标：实际估值-现在准备融资估值
     */
    @Column(name = "figure_valuation_actual_want")
    private Double figureValuationActualWant;

    /**
     * 一级指标：人力资源指数
     */
    @Column(name = "figure_hr")
    private Double figureHr;

    /**
     * 二级指标：兼职员工数
     */
    @Column(name = "figure_hr_partime")
    private Double figureHrPartime;

    /**
     * 三级指标：兼职员工-研发
     */
    @Column(name = "figure_hr_partime_dev")
    private Double figureHrPartimeDev;

    /**
     * 三级指标：兼职员工-管理
     */
    @Column(name = "figure_hr_partime_manage")
    private Double figureHrPartimeManage;

    /**
     * 三级指标：兼职员工-行政
     */
    @Column(name = "figure_hr_partime_admin")
    private Double figureHrPartimeAdmin;

    /**
     * 三级指标：兼职员工-销售
     */
    @Column(name = "figure_hr_partime_saler")
    private Double figureHrPartimeSaler;

    /**
     * 二级指标：全职员工
     */
    @Column(name = "figure_hr_fulltime")
    private Double figureHrFulltime;

    /**
     * 三级指标：全职员工-研发
     */
    @Column(name = "figure_hr_fulltime_dev")
    private Double figureHrFulltimeDev;

    /**
     * 三级指标：全职员工-高管
     */
    @Column(name = "figure_hr_fulltime_senior")
    private Double figureHrFulltimeSenior;

    /**
     * 三级指标：全职员工-行政
     */
    @Column(name = "figure_hr_fulltime_admin")
    private Double figureHrFulltimeAdmin;

    /**
     * 三级指标：全职员工-销售
     */
    @Column(name = "figure_hr_fulltime_saler")
    private Double figureHrFulltimeSaler;

    /**
     * 二级指标：高学历人员
     */
    @Column(name = "figure_hr_educated")
    private Double figureHrEducated;

    /**
     * 三级指标：高学历人员-博士
     */
    @Column(name = "figure_hr_educated_doc")
    private Double figureHrEducatedDoc;

    /**
     * 三级指标：高学历人员-硕士
     */
    @Column(name = "figure_hr_educated_master")
    private Double figureHrEducatedMaster;

    /**
     * 三级指标：高学历人员-学士
     */
    @Column(name = "figure_hr_bachelor")
    private Double figureHrBachelor;

    /**
     * 一级指标：创新指数
     */
    @Column(name = "figure_innovate")
    private Double figureInnovate;

    /**
     * 二级指标：专利申请
     */
    @Column(name = "figure_innovate_patent_apply")
    private Double figureInnovatePatentApply;

    /**
     * 三级指标：专利申请-发明
     */
    @Column(name = "figure_innovate_patent_apply_invention")
    private Double figureInnovatePatentApplyInvention;

    /**
     * 三级指标：专利申请-实用新型
     */
    @Column(name = "figure_innovate_patent_apply_utility")
    private Double figureInnovatePatentApplyUtility;

    /**
     * 三级指标：专利申请-外观设计
     */
    @Column(name = "figure_innovate_patent_apply_appear")
    private Double figureInnovatePatentApplyAppear;

    /**
     * 二级指标：专利授权
     */
    @Column(name = "figure_innovate_patent_grant")
    private Double figureInnovatePatentGrant;

    /**
     * 三级指标：专利授权-发明
     */
    @Column(name = "figure_innovate_patent_grant_invention")
    private Double figureInnovatePatentGrantInvention;

    /**
     * 三级指标：专利授权-实用新型
     */
    @Column(name = "figure_innovate_patent_grant_utility")
    private Double figureInnovatePatentGrantUtility;

    /**
     * 三级指标：专利授权-外观设计
     */
    @Column(name = "figure_innovate_patent_grant_appear")
    private Double figureInnovatePatentGrantAppear;

    /**
     * 二级指标：著作权申请
     */
    @Column(name = "figure_innovate_copyright_apply")
    private Double figureInnovateCopyrightApply;

    /**
     * 三级指标：著作权申请-软件类
     */
    @Column(name = "figure_innovate_copyright_apply_soft")
    private Double figureInnovateCopyrightApplySoft;

    /**
     * 三级指标：著作权申请-非软件类
     */
    @Column(name = "figure_innovate_copyright_apply_unsoft")
    private Double figureInnovateCopyrightApplyUnsoft;

    /**
     * 二级指标：著作权授权
     */
    @Column(name = "figure_innovate_copyright_grant")
    private Double figureInnovateCopyrightGrant;

    /**
     * 三级指标：著作权授权-软件类
     */
    @Column(name = "figure_innovate_copyright_grant_soft")
    private Double figureInnovateCopyrightGrantSoft;

    /**
     * 三级指标：著作权授权-非软件类
     */
    @Column(name = "figure_innovate_copyright_grant_unsoft")
    private Double figureInnovateCopyrightGrantUnsoft;

    /**
     * 二级指标：新产品/服务
     */
    @Column(name = "figure_innovate_new_product")
    private Double figureInnovateNewProduct;

    /**
     * 三级指标：新产品/服务-专利类
     */
    @Column(name = "figure_innovate_new_product_patent")
    private Double figureInnovateNewProductPatent;

    /**
     * 三级指标：新产品/服务-专用技术
     */
    @Column(name = "figure_innovate_new_product_tech")
    private Double figureInnovateNewProductTech;

    /**
     * 三级指标：新产品/服务-商业模式
     */
    @Column(name = "figure_innovate_new_product_bus")
    private Double figureInnovateNewProductBus;

    /**
     * 一级指标：薪酬指数
     */
    @Column(name = "figure_salary")
    private Double figureSalary;

    /**
     * 二级指标：员工工资额
     */
    @Column(name = "figure_salary_staff")
    private Double figureSalaryStaff;

    /**
     * 三级指标：员工工资额-1万元以上
     */
    @Column(name = "figure_salary_staff_up_10")
    private Double figureSalaryStaffUp10;

    /**
     * 三级指标：员工工资额-5千到1万
     */
    @Column(name = "figure_salary_staff_5_10")
    private Double figureSalaryStaff510;

    /**
     * 三级指标：员工工资额-5千以下
     */
    @Column(name = "figure_salary_staff_down_5")
    private Double figureSalaryStaffDown5;

    /**
     * 二级指标：员工贡献率
     */
    @Column(name = "figure_salary_staff_contribution")
    private Double figureSalaryStaffContribution;

    /**
     * 三级指标：员工贡献率-人均销售
     */
    @Column(name = "figure_salary_staff_contribution_meansale")
    private Double figureSalaryStaffContributionMeansale;

    /**
     * 三级指标：员工贡献率-人均纳税
     */
    @Column(name = "figure_salary_staff_contribution_meantax")
    private Double figureSalaryStaffContributionMeantax;

    /**
     * 一级指标：学习指数
     */
    @Column(name = "figure_learn")
    private Double figureLearn;

    /**
     * 二级指标：参加培训的次数
     */
    @Column(name = "figure_learn_train")
    private Double figureLearnTrain;

    /**
     * 三级指标：参加培训的次数-管理类
     */
    @Column(name = "figure_learn_train_manage")
    private Double figureLearnTrainManage;

    /**
     * 三级指标：参加培训的次数-政策法规
     */
    @Column(name = "figure_learn_train_policy")
    private Double figureLearnTrainPolicy;

    /**
     * 三级指标：参加培训的次数-技能类
     */
    @Column(name = "figure_learn_train_skill")
    private Double figureLearnTrainSkill;

    /**
     * 二级指标：接受咨询的次数
     */
    @Column(name = "figure_learn_conslted")
    private Double figureLearnConslted;

    /**
     * 三级指标：接受咨询的次数-管理类
     */
    @Column(name = "figure_learn_conslted_manage")
    private Double figureLearnConsltedManage;

    /**
     * 三级指标：接受咨询的次数-政策法规
     */
    @Column(name = "figure_learn_conslted_policy")
    private Double figureLearnConsltedPolicy;

    /**
     * 三级指标：接受咨询的次数-技能类
     */
    @Column(name = "figure_learn_conslted_skill")
    private Double figureLearnConsltedSkill;

    /**
     * 一级指标：品牌指数
     */
    @Column(name = "figure_brand")
    private Double figureBrand;

    /**
     * 二级指标：企业获奖
     */
    @Column(name = "figure_brand_reward")
    private Double figureBrandReward;

    /**
     * 三级指标：企业获奖-区级
     */
    @Column(name = "figure_brand_reward_area")
    private Double figureBrandRewardArea;

    /**
     * 三级指标：企业获奖-市级
     */
    @Column(name = "figure_brand_reward_city")
    private Double figureBrandRewardCity;

    /**
     * 三级指标：企业获奖-省级
     */
    @Column(name = "figure_brand_reward_province")
    private Double figureBrandRewardProvince;

    /**
     * 三级指标：企业获奖-国家级
     */
    @Column(name = "figure_brand_reward_country")
    private Double figureBrandRewardCountry;

    /**
     * 二级指标：企业认定
     */
    @Column(name = "figure_brand_recognition")
    private Double figureBrandRecognition;

    /**
     * 三级指标：企业认定-区级
     */
    @Column(name = "figure_brand_recognition_area")
    private Double figureBrandRecognitionArea;

    /**
     * 三级指标：企业认定-市级
     */
    @Column(name = "figure_brand_recognition_city")
    private Double figureBrandRecognitionCity;

    /**
     * 三级指标：企业认定-省级
     */
    @Column(name = "figure_brand_recognition_province")
    private Double figureBrandRecognitionProvince;

    /**
     * 三级指标：企业认定-国家级
     */
    @Column(name = "figure_brand_recognition_country")
    private Double figureBrandRecognitionCountry;

    /**
     * 二级指标：人才资助
     */
    @Column(name = "figure_brand_talent")
    private Double figureBrandTalent;

    /**
     * 三级指标：人才资助-区级
     */
    @Column(name = "figure_brand_talent_area")
    private Double figureBrandTalentArea;

    /**
     * 三级指标：人才资助-市级
     */
    @Column(name = "figure_brand_talent_city")
    private Double figureBrandTalentCity;

    /**
     * 三级指标：人才资助-省级
     */
    @Column(name = "figure_brand_talent_province")
    private Double figureBrandTalentProvince;

    /**
     * 三级指标：人才资助-国家级
     */
    @Column(name = "figure_brand_talent_country")
    private Double figureBrandTalentCountry;

    /**
     * 根据已有三级指标评按照权重估二级指标和一级指标的得分
     * @param figureWeight 所用权重
     */
    public void evaluate(FigureWeight figureWeight) {
        this.figureId = figureWeight.getId();
        try {
            // 二级指标求值
            this.figureSaleInvoice = this.findWeightAndCalc(figureWeight, "figureSaleInvoiceSoft", "figureSaleInvoiceHard", "figureSaleInvoiceConsultation", "figureSaleInvoiceOther");
            this.figureSaleContract = this.findWeightAndCalc(figureWeight, "figureSaleContractSoft", "figureSaleContractHard", "figureSaleContractConsultation", "figureSaleContractOther");

            this.figureTaxCorporate = this.findWeightAndCalc(figureWeight, "figureTaxCorporateTaxable", "figureTaxCorporateRelief");
            this.figureTaxIndividual = this.findWeightAndCalc(figureWeight, "figureTaxIndividualTaxable", "figureTaxIndividualRelief");
            this.figureTaxAdded = this.findWeightAndCalc(figureWeight, "figureTaxAddedTaxable", "figureTaxAddedRelief");

            this.figureFinanceStock = this.findWeightAndCalc(figureWeight, "figureFinanceStockRisk", "figureFinanceStockGov", "figureFinanceStockPerson");
            this.figureFinanceDebt = this.findWeightAndCalc(figureWeight, "figureFinanceDebtBank", "figureFinanceDebtNew", "figureFinanceDebtLending", "figureFinanceDebtPerson");

            this.figureValuationAssets = this.findWeightAndCalc(figureWeight, "figureValuationAssetsCirculating", "figureValuationAssetsUncirculating", "figureValuationAssetsDebtCirculating", "figureValuationAssetsDebtUncirculating");
            this.figureValuationActual = this.findWeightAndCalc(figureWeight, "figureValuationActualFirst", "figureValuationActualLatest", "figureValuationActualWant");

            this.figureHrPartime = this.findWeightAndCalc(figureWeight, "figureHrPartimeDev", "figureHrPartimeManage", "figureHrPartimeAdmin", "figureHrPartimeSaler");
            this.figureHrFulltime = this.findWeightAndCalc(figureWeight, "figureHrFulltimeDev", "figureHrFulltimeSenior", "figureHrFulltimeAdmin", "figureHrFulltimeSaler");
            this.figureHrEducated = this.findWeightAndCalc(figureWeight, "figureHrEducatedDoc", "figureHrEducatedMaster", "figureHrBachelor");

            this.figureInnovatePatentApply = this.findWeightAndCalc(figureWeight, "figureInnovatePatentApplyInvention", "figureInnovatePatentApplyUtility", "figureInnovatePatentApplyAppear");
            this.figureInnovatePatentGrant = this.findWeightAndCalc(figureWeight, "figureInnovatePatentGrantInvention", "figureInnovatePatentGrantUtility", "figureInnovatePatentGrantAppear");
            this.figureInnovateCopyrightApply = this.findWeightAndCalc(figureWeight, "figureInnovateCopyrightApplySoft", "figureInnovateCopyrightApplyUnsoft");
            this.figureInnovateCopyrightGrant = this.findWeightAndCalc(figureWeight, "figureInnovateCopyrightGrantSoft", "figureInnovateCopyrightGrantUnsoft");
            this.figureInnovateNewProduct = this.findWeightAndCalc(figureWeight, "figureInnovateNewProductPatent", "figureInnovateNewProductTech", "figureInnovateNewProductBus");

            this.figureSalaryStaff = this.findWeightAndCalc(figureWeight, "figureSalaryStaffUp10", "figureSalaryStaff510", "figureSalaryStaffDown5");
            this.figureSalaryStaffContribution = this.findWeightAndCalc(figureWeight, "figureSalaryStaffContributionMeansale", "figureSalaryStaffContributionMeantax");

            this.figureLearnTrain = this.findWeightAndCalc(figureWeight, "figureLearnTrainManage", "figureLearnTrainPolicy", "figureLearnTrainSkill");
            this.figureLearnConslted = this.findWeightAndCalc(figureWeight, "figureLearnConsltedManage", "figureLearnConsltedPolicy");

            this.figureBrandReward = this.findWeightAndCalc(figureWeight, "figureBrandRewardArea", "figureBrandRewardCity", "figureBrandRewardProvince", "figureBrandRewardCountry");
            this.figureBrandRecognition = this.findWeightAndCalc(figureWeight, "figureBrandRecognitionArea", "figureBrandRecognitionCity", "figureBrandRecognitionProvince", "figureBrandRecognitionCountry");
            this.figureBrandTalent = this.findWeightAndCalc(figureWeight, "figureBrandTalentArea", "figureBrandTalentCity", "figureBrandTalentProvince", "figureBrandTalentCountry");

            // 一级指标
            this.figureSale = this.findWeightAndCalc(figureWeight, "figureSaleInvoice", "figureSaleComtract");
            this.figureTax = this.findWeightAndCalc(figureWeight, "figureTaxCorporate", "figureTaxIndividual", "figureTaxAdded");
            this.figureFinance = this.findWeightAndCalc(figureWeight, "figureFinanceStock", "figureFinanceDebt");
            this.figureValuation = this.findWeightAndCalc(figureWeight, "figureValuationAssets", "figureValuationActual");
            this.figureHr = this.findWeightAndCalc(figureWeight, "figureHrPartime", "figureHrFulltime", "figureHrEducated");
            this.figureInnovate = this.findWeightAndCalc(figureWeight, "figureInnovatePatentApply", "figureInnovatePatentGrant", "figureInnovateCopyrightApply", "figureInnovateCopyrightGrant", "figureInnovateNewProduct");
            this.figureSalary = this.findWeightAndCalc(figureWeight, "figureSalaryStaff", "figureSalaryStaffContribution");
            this.figureLearn = this.findWeightAndCalc(figureWeight, "figureLearnTrain", "figureLearnConslted");
            this.figureBrand = this.findWeightAndCalc(figureWeight, "figureBrandReward", "figureBrandRecognition", "figureBrandTalent");

            // 综合指标
            this.figureAll = this.findWeightAndCalc(figureWeight, "figureSale", "figureTax", "figureFinance", "figureValuation", "figureHr", "figureInnovate", "figureSalary", "figureLearn", "figureBrand");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private double findWeightAndCalc(FigureWeight figureWeight, String ... fieldNames) throws NoSuchFieldException, IllegalAccessException {
        int result = 0;
        for (String fieldName : fieldNames) {
            fieldName = fieldName.trim();
            Field scoreField = this.getClass().getField(fieldName);
            Field weightField = FigureWeight.class.getField(fieldName + "Weight");
            scoreField.setAccessible(true);
            double score = (double) scoreField.get(this);
            scoreField.setAccessible(false);
            weightField.setAccessible(true);
            double weight = (double) weightField.get(figureWeight);
            weightField.setAccessible(false);
            result += score * weight;
        }
        return result;
    }
}