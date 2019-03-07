-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1:3306
-- 生成日期： 2019-03-07 16:53:18
-- 服务器版本： 5.7.23
-- PHP 版本： 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `swulib`
--

-- --------------------------------------------------------

--
-- 表的结构 `finger_weight`
--

DROP TABLE IF EXISTS `finger_weight`;
CREATE TABLE IF NOT EXISTS `finger_weight` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `finger_sale_weight` double DEFAULT NULL,
  `finger_sale_invoice_weight` double DEFAULT NULL,
  `finger_sale_invoice_soft_weight` double DEFAULT NULL,
  `finger_sale_invoice_hard_weight` double DEFAULT NULL COMMENT '已开发票的收入-硬件产品',
  `finger_sale_invoice_consultation_weight` double DEFAULT NULL COMMENT '已开发票的收入-咨询服务',
  `finger_sale_invoice_other_weight` double DEFAULT NULL COMMENT '已开发票的收入-其他',
  `finger_sale_contract_weight` double DEFAULT NULL COMMENT '二级指标：合同确认额',
  `finger_sale_contract_soft_weight` double DEFAULT NULL COMMENT '三级指标：合同确认额-软件产品',
  `finger_sale_contract_hard_weight` double DEFAULT NULL COMMENT '三级指标：合同确认额-硬件产品',
  `finger_sale_contract_consultation_weight` double DEFAULT NULL COMMENT '三级指标：合同确认额-咨询服务',
  `finger_sale_contract_other_weight` double DEFAULT NULL COMMENT '三级指标：合同确认额-其他',
  `finger_tax_weight` double DEFAULT NULL COMMENT '一级指标：纳税指数',
  `finger_tax_corporate_weight` double DEFAULT NULL COMMENT '二级指标：企业所得税',
  `finger_tax_corporate_taxable_weight` double DEFAULT NULL COMMENT '三级指标：企业所得税-应纳税值',
  `finger_tax_corporate_relief_weight` double DEFAULT NULL COMMENT '三级指标：企业所得税-税收减免值',
  `finger_tax_individual_weight` double DEFAULT NULL COMMENT '二级指标：个人所得税',
  `finger_tax_individual_taxable_weight` double DEFAULT NULL COMMENT '三级指标：个人所得税-应纳税值',
  `finger_tax_individual_relief_weight` double DEFAULT NULL COMMENT '三级指标：个人所得税-税收减免',
  `finger_tax_added_weight` double DEFAULT NULL COMMENT '二级指标：增值税',
  `finger_tax_added_taxable_weight` double DEFAULT NULL COMMENT '三级指标：增值税-应纳税值',
  `finger_tax_added_relief_weight` double DEFAULT NULL COMMENT '三级指标：增值税-税收减免',
  `finger_finance_weight` double DEFAULT NULL COMMENT '一级指标：融资指数',
  `finger_finance_stock_weight` double DEFAULT NULL COMMENT '二级指标：股权类融资',
  `finger_finance_stock_risk_weight` double DEFAULT NULL COMMENT '三级指标：股权类融资-风投机构',
  `finger_finance_stock_gov_weight` double DEFAULT NULL COMMENT '三级指标：股权类融资-政府企业',
  `finger_finance_stock_person_weight` double DEFAULT NULL COMMENT '三级指标：股权类融资-个人',
  `finger_finance_debt_weight` double DEFAULT NULL COMMENT '二级指标：债务类融资',
  `finger_finance_debt_bank_weight` double DEFAULT NULL COMMENT '三级指标：债务类融资-银行',
  `finger_finance_debt_new_weight` double DEFAULT NULL COMMENT '三级指标：债务类融资-新型贷款机构',
  `finger_finance_debt_lending_weight` double DEFAULT NULL COMMENT '三级指标：债务类融资-企业拆借',
  `finger_finance_debt_person_weight` double DEFAULT NULL COMMENT '三级指标：债务类融资-个人',
  `finger_valuation_weight` double DEFAULT NULL COMMENT '一级指标:估值指数',
  `finger_valuation_assets_weight` double DEFAULT NULL COMMENT '二级指标：净资产',
  `finger_valuation_assets_circulating_weight` double DEFAULT NULL COMMENT '三级指标：净资产-流动资产',
  `finger_valuation_assets_uncirculating_weight` double DEFAULT NULL COMMENT '三级指标：净资产-非流动资产',
  `finger_valuation_assets_debt_circulating_weight` double DEFAULT NULL COMMENT '三级指标：净资产-流动负债',
  `finger_valuation_assets_debt_uncirculating_weight` double DEFAULT NULL COMMENT '三级指标：净资产-非流动负债',
  `finger_valuation_actual_weight` double DEFAULT NULL COMMENT '二级指标：实际估值',
  `finger_valuation_actual_first_weight` double DEFAULT NULL COMMENT '三级指标：实际估值-首次融资',
  `finger_valuation_actual_latest_weight` double DEFAULT NULL COMMENT '三级指标：实际估值-最近一次融资估值',
  `finger_valuation_actual_want_weight` double DEFAULT NULL COMMENT '三级指标：实际估值-现在准备融资估值',
  `finger_hr_weight` double DEFAULT NULL COMMENT '一级指标：人力资源指数',
  `finger_hr_partime_weight` double DEFAULT NULL COMMENT '二级指标：兼职员工数',
  `finger_hr_partime_dev_weight` double DEFAULT NULL COMMENT '三级指标：兼职员工-研发',
  `finger_hr_partime_manage_weight` double DEFAULT NULL COMMENT '三级指标：兼职员工-管理',
  `finger_hr_partime_admin_weight` double DEFAULT NULL COMMENT '三级指标：兼职员工-行政',
  `finger_hr_partime_saler_weight` double DEFAULT NULL COMMENT '三级指标：兼职员工-销售',
  `finger_hr_fulltime_weight` double DEFAULT NULL COMMENT '二级指标：全职员工',
  `finger_hr_fulltime_dev_weight` double DEFAULT NULL COMMENT '三级指标：全职员工-研发',
  `finger_hr_fulltime_senior_weight` double DEFAULT NULL COMMENT '三级指标：全职员工-高管',
  `finger_hr_fulltime_admin_weight` double DEFAULT NULL COMMENT '三级指标：全职员工-行政',
  `finger_hr_fulltime_saler_weight` double DEFAULT NULL COMMENT '三级指标：全职员工-销售',
  `finger_hr_educated_weight` double DEFAULT NULL COMMENT '二级指标：高学历人员',
  `finger_hr_educated_doc_weight` double DEFAULT NULL COMMENT '三级指标：高学历人员-博士',
  `finger_hr_educated_master_weight` double DEFAULT NULL COMMENT '三级指标：高学历人员-硕士',
  `finger_hr_bachelor_weight` double DEFAULT NULL COMMENT '三级指标：高学历人员-学士',
  `finger_innovate_weight` double DEFAULT NULL COMMENT '一级指标：创新指数',
  `finger_innovate_patent_apply_weight` double DEFAULT NULL COMMENT '二级指标：专利申请',
  `finger_innovate_patent_apply_invention_weight` double DEFAULT NULL COMMENT '三级指标：专利申请-发明',
  `finger_innovate_patent_apply_utility_weight` double DEFAULT NULL COMMENT '三级指标：专利申请-实用新型',
  `finger_innovate_patent_apply_appear_weight` double DEFAULT NULL COMMENT '三级指标：专利申请-外观设计',
  `finger_innovate_patent_grant_weight` double DEFAULT NULL COMMENT '二级指标：专利授权',
  `finger_innovate_patent_grant_invention_weight` double DEFAULT NULL COMMENT '三级指标：专利授权-发明',
  `finger_innovate_patent_grant_utility_weight` double DEFAULT NULL COMMENT '三级指标：专利授权-实用新型',
  `finger_innovate_patent_grant_appear_weight` double DEFAULT NULL COMMENT '三级指标：专利授权-外观设计',
  `finger_innovate_copyright_apply_weight` double DEFAULT NULL COMMENT '二级指标：著作权申请',
  `finger_innovate_copyright_apply_soft_weight` double DEFAULT NULL COMMENT '三级指标：著作权申请-软件类',
  `finger_innovate_copyright_apply_unsoft_weight` double DEFAULT NULL COMMENT '三级指标：著作权申请-非软件类',
  `finger_innovate_copyright_grant_weight` double DEFAULT NULL COMMENT '二级指标：著作权授权',
  `finger_innovate_copyright_grant_soft_weight` double DEFAULT NULL COMMENT '三级指标：著作权授权-软件类',
  `finger_innovate_copyright_grant_unsoft_weight` double DEFAULT NULL COMMENT '三级指标：著作权授权-非软件类',
  `finger_innovate_new_product_weight` double DEFAULT NULL COMMENT '二级指标：新产品/服务',
  `finger_innovate_new_product_patent_weight` double DEFAULT NULL COMMENT '三级指标：新产品/服务-专利类',
  `finger_innovate_new_product_tech_weight` double DEFAULT NULL COMMENT '三级指标：新产品/服务-专用技术',
  `finger_innovate_new_product_bus_weight` double DEFAULT NULL COMMENT '三级指标：新产品/服务-商业模式',
  `finger_salary_weight` double DEFAULT NULL COMMENT '一级指标：薪酬指数',
  `finger_salary_staff_weight` double DEFAULT NULL COMMENT '二级指标：员工工资额',
  `finger_salary_staff_up_10_weight` double DEFAULT NULL COMMENT '三级指标：员工工资额-1万元以上',
  `finger_salary_staff_5_10_weight` double DEFAULT NULL COMMENT '三级指标：员工工资额-5千到1万',
  `finger_salary_staff_down_5_weight` double DEFAULT NULL COMMENT '三级指标：员工工资额-5千以下',
  `finger_salary_staff_contribution_weight` double DEFAULT NULL COMMENT '二级指标：员工贡献率',
  `finger_salary_staff_contribution_meansale_weight` double DEFAULT NULL COMMENT '三级指标：员工贡献率-人均销售',
  `finger_salary_staff_contribution_meantax_weight` double DEFAULT NULL COMMENT '三级指标：员工贡献率-人均纳税',
  `finger_learn_weight` double DEFAULT NULL COMMENT '一级指标：学习指数',
  `finger_learn_train_weight` double DEFAULT NULL COMMENT '二级指标：参加培训的次数',
  `finger_learn_train_manage_weight` double DEFAULT NULL COMMENT '三级指标：参加培训的次数-管理类',
  `finger_learn_train_policy_weight` double DEFAULT NULL COMMENT '三级指标：参加培训的次数-政策法规',
  `finger_learn_train_skill_weight` double DEFAULT NULL COMMENT '三级指标：参加培训的次数-技能类',
  `finger_learn_conslted_weight` double DEFAULT NULL COMMENT '二级指标：接受咨询的次数',
  `finger_learn_conslted_manage_weight` double DEFAULT NULL COMMENT '三级指标：接受咨询的次数-管理类',
  `finger_learn_conslted_policy_weight` double DEFAULT NULL COMMENT '三级指标：接受咨询的次数-政策法规',
  `finger_learn_conslted_skill_weight` double DEFAULT NULL COMMENT '三级指标：接受咨询的次数-技能类',
  `finger_brand_weight` double DEFAULT NULL COMMENT '一级指标：品牌指数',
  `finger_brand_reward_weight` double DEFAULT NULL COMMENT '二级指标：企业获奖',
  `finger_brand_reward_area_weight` double DEFAULT NULL COMMENT '三级指标：企业获奖-区级',
  `finger_brand_reward_city_weight` double DEFAULT NULL COMMENT '三级指标：企业获奖-市级',
  `finger_brand_reward_province_weight` double DEFAULT NULL COMMENT '三级指标：企业获奖-省级',
  `finger_brand_reward_country_weight` double DEFAULT NULL COMMENT '三级指标：企业获奖-国家级',
  `finger_brand_recognition_weight` double DEFAULT NULL COMMENT '二级指标：企业认定',
  `finger_brand_recognition_area_weight` double DEFAULT NULL COMMENT '三级指标：企业认定-区级',
  `finger_brand_recognition_city_weight` double DEFAULT NULL COMMENT '三级指标：企业认定-市级',
  `finger_brand_recognition_province_weight` double DEFAULT NULL COMMENT '三级指标：企业认定-省级',
  `finger_brand_recognition_country_weight` double DEFAULT NULL COMMENT '三级指标：企业认定-国家级',
  `finger_brand_talent_weight` double DEFAULT NULL COMMENT '二级指标：人才资助',
  `finger_brand_talent_area_weight` double DEFAULT NULL COMMENT '三级指标：人才资助-区级',
  `finger_brand_talent_city_weight` double DEFAULT NULL COMMENT '三级指标：人才资助-市级',
  `finger_brand_talent_province_weight` double DEFAULT NULL COMMENT '三级指标：人才资助-省级',
  `finger_brand_talent_country_weight` double DEFAULT NULL COMMENT '三级指标：人才资助-国家级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='写死的表结构';

--
-- 转存表中的数据 `finger_weight`
--

INSERT INTO `finger_weight` (`id`, `finger_sale_weight`, `finger_sale_invoice_weight`, `finger_sale_invoice_soft_weight`, `finger_sale_invoice_hard_weight`, `finger_sale_invoice_consultation_weight`, `finger_sale_invoice_other_weight`, `finger_sale_contract_weight`, `finger_sale_contract_soft_weight`, `finger_sale_contract_hard_weight`, `finger_sale_contract_consultation_weight`, `finger_sale_contract_other_weight`, `finger_tax_weight`, `finger_tax_corporate_weight`, `finger_tax_corporate_taxable_weight`, `finger_tax_corporate_relief_weight`, `finger_tax_individual_weight`, `finger_tax_individual_taxable_weight`, `finger_tax_individual_relief_weight`, `finger_tax_added_weight`, `finger_tax_added_taxable_weight`, `finger_tax_added_relief_weight`, `finger_finance_weight`, `finger_finance_stock_weight`, `finger_finance_stock_risk_weight`, `finger_finance_stock_gov_weight`, `finger_finance_stock_person_weight`, `finger_finance_debt_weight`, `finger_finance_debt_bank_weight`, `finger_finance_debt_new_weight`, `finger_finance_debt_lending_weight`, `finger_finance_debt_person_weight`, `finger_valuation_weight`, `finger_valuation_assets_weight`, `finger_valuation_assets_circulating_weight`, `finger_valuation_assets_uncirculating_weight`, `finger_valuation_assets_debt_circulating_weight`, `finger_valuation_assets_debt_uncirculating_weight`, `finger_valuation_actual_weight`, `finger_valuation_actual_first_weight`, `finger_valuation_actual_latest_weight`, `finger_valuation_actual_want_weight`, `finger_hr_weight`, `finger_hr_partime_weight`, `finger_hr_partime_dev_weight`, `finger_hr_partime_manage_weight`, `finger_hr_partime_admin_weight`, `finger_hr_partime_saler_weight`, `finger_hr_fulltime_weight`, `finger_hr_fulltime_dev_weight`, `finger_hr_fulltime_senior_weight`, `finger_hr_fulltime_admin_weight`, `finger_hr_fulltime_saler_weight`, `finger_hr_educated_weight`, `finger_hr_educated_doc_weight`, `finger_hr_educated_master_weight`, `finger_hr_bachelor_weight`, `finger_innovate_weight`, `finger_innovate_patent_apply_weight`, `finger_innovate_patent_apply_invention_weight`, `finger_innovate_patent_apply_utility_weight`, `finger_innovate_patent_apply_appear_weight`, `finger_innovate_patent_grant_weight`, `finger_innovate_patent_grant_invention_weight`, `finger_innovate_patent_grant_utility_weight`, `finger_innovate_patent_grant_appear_weight`, `finger_innovate_copyright_apply_weight`, `finger_innovate_copyright_apply_soft_weight`, `finger_innovate_copyright_apply_unsoft_weight`, `finger_innovate_copyright_grant_weight`, `finger_innovate_copyright_grant_soft_weight`, `finger_innovate_copyright_grant_unsoft_weight`, `finger_innovate_new_product_weight`, `finger_innovate_new_product_patent_weight`, `finger_innovate_new_product_tech_weight`, `finger_innovate_new_product_bus_weight`, `finger_salary_weight`, `finger_salary_staff_weight`, `finger_salary_staff_up_10_weight`, `finger_salary_staff_5_10_weight`, `finger_salary_staff_down_5_weight`, `finger_salary_staff_contribution_weight`, `finger_salary_staff_contribution_meansale_weight`, `finger_salary_staff_contribution_meantax_weight`, `finger_learn_weight`, `finger_learn_train_weight`, `finger_learn_train_manage_weight`, `finger_learn_train_policy_weight`, `finger_learn_train_skill_weight`, `finger_learn_conslted_weight`, `finger_learn_conslted_manage_weight`, `finger_learn_conslted_policy_weight`, `finger_learn_conslted_skill_weight`, `finger_brand_weight`, `finger_brand_reward_weight`, `finger_brand_reward_area_weight`, `finger_brand_reward_city_weight`, `finger_brand_reward_province_weight`, `finger_brand_reward_country_weight`, `finger_brand_recognition_weight`, `finger_brand_recognition_area_weight`, `finger_brand_recognition_city_weight`, `finger_brand_recognition_province_weight`, `finger_brand_recognition_country_weight`, `finger_brand_talent_weight`, `finger_brand_talent_area_weight`, `finger_brand_talent_city_weight`, `finger_brand_talent_province_weight`, `finger_brand_talent_country_weight`) VALUES
(1, 5, 5, 2, 2.5, 1, 0.5, 1, 2, 2.5, 1, 0.5, 2, 3, 1, 2, 2, 1, 2, 4, 1, 2, 0.5, 4, 3, 2, 1, 1, 3, 2, 2, 1, 1, 4, 4, 3, 1, 2, 1, 2, 3, 0.000001, 3, 1, 1, 1, 1, 1, 3, 3, 4, 1, 2, 4, 3, 2, 1, 4, 2, 3, 2, 1, 4, 3, 2, 1, 2, 2, 1, 3, 2, 1, 4, 2, 1, 1, 2, 1, 1, 1, 1, 4, 1, 2, 2, 3, 1, 1, 1, 4, 1, 1, 1, 4, 2, 1, 2, 3, 5, 3, 1, 2, 3, 5, 2, 1, 2, 3, 5);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
