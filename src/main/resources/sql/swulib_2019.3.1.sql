-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1:3306
-- 生成日期： 2019-03-01 15:45:26
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
-- 表的结构 `business_scope`
--

DROP TABLE IF EXISTS `business_scope`;
CREATE TABLE IF NOT EXISTS `business_scope` (
  `biz_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `biz_scope_id` bigint(20) NOT NULL COMMENT '经营范围ID',
  `biz_scope_name` varchar(128) NOT NULL COMMENT '经营范围命名',
  `company_id` bigint(20) NOT NULL COMMENT '备注',
  PRIMARY KEY (`biz_id`),
  KEY `company_id` (`company_id`),
  KEY `business_scope_id` (`biz_scope_id`),
  KEY `business_scope_name` (`biz_scope_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业经营范围';

-- --------------------------------------------------------

--
-- 表的结构 `business_scope_dict`
--

DROP TABLE IF EXISTS `business_scope_dict`;
CREATE TABLE IF NOT EXISTS `business_scope_dict` (
  `business_scope_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '经营范围ID',
  `business_scope_name` varchar(128) NOT NULL COMMENT '经营范围名字',
  PRIMARY KEY (`business_scope_id`),
  UNIQUE KEY `business_scope_name` (`business_scope_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='经营范围字典';

-- --------------------------------------------------------

--
-- 表的结构 `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `company_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `company_name` varchar(128) NOT NULL COMMENT '公司名字',
  `company_address` varchar(128) DEFAULT NULL COMMENT '地址',
  `regis_type` int(11) DEFAULT NULL COMMENT '注册类型：0、 个体工商户1、个人独资企业2、合伙企业3、有限合伙企业4、有限责任公司5、股份有限公司',
  `approval_authority` varchar(128) DEFAULT NULL COMMENT '批准设立机关',
  `credit_code` varchar(32) NOT NULL COMMENT '统一社会信用代码',
  `estab_date` date DEFAULT NULL COMMENT '成立日期',
  `tax_number` varchar(32) NOT NULL COMMENT '纳税人识别号',
  `industry_type` int(11) DEFAULT NULL COMMENT '所属行业',
  `industry_type_alias` varchar(32) DEFAULT NULL COMMENT '所属行业',
  `regis_type_alias` varchar(32) DEFAULT NULL COMMENT '注册类型：0、 个体工商户1、个人独资企业2、合伙企业3、有限合伙企业4、有限责任公司5、股份有限公司',
  `approval_date` date DEFAULT NULL COMMENT '核准日期',
  `busniss_term` date DEFAULT NULL COMMENT '营业期限 ',
  `postal_code` varchar(32) DEFAULT NULL COMMENT '邮政编码',
  `tell_phone` varchar(32) DEFAULT NULL COMMENT '电话',
  `legal_representative` varchar(32) DEFAULT NULL COMMENT '法定代表人',
  `company_name_eng` varchar(256) DEFAULT NULL COMMENT '企业英文名',
  `location_area` varchar(32) DEFAULT NULL COMMENT '所属地区',
  `license_picture` varchar(128) DEFAULT NULL COMMENT '营业执照照片',
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `company_name` (`company_name`),
  UNIQUE KEY `credit_code` (`credit_code`),
  UNIQUE KEY `tax_number` (`tax_number`),
  KEY `industry_id` (`industry_type`),
  KEY `industry_name` (`regis_type_alias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业基本信息';

-- --------------------------------------------------------

--
-- 表的结构 `company_asset`
--

DROP TABLE IF EXISTS `company_asset`;
CREATE TABLE IF NOT EXISTS `company_asset` (
  `asset_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `year` int(11) NOT NULL COMMENT '年',
  `rank_year` int(11) DEFAULT NULL COMMENT '年度',
  `asset_name` varchar(64) NOT NULL COMMENT '资产名',
  `asset_amount` bigint(20) NOT NULL COMMENT '资产数额',
  `commet` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`asset_id`),
  KEY `company_id_asset` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业资产信息';

-- --------------------------------------------------------

--
-- 表的结构 `company_business`
--

DROP TABLE IF EXISTS `company_business`;
CREATE TABLE IF NOT EXISTS `company_business` (
  `cb_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `company_id` bigint(20) NOT NULL COMMENT '企业ID',
  `year` int(11) NOT NULL COMMENT '年',
  `month` int(11) DEFAULT NULL COMMENT '月',
  `quarter` varchar(8) DEFAULT NULL COMMENT '季度Q1,Q2,Q3,Q4',
  `sales` bigint(20) DEFAULT NULL COMMENT '销售额',
  `turnover` bigint(20) DEFAULT NULL COMMENT '营业额',
  `profit` bigint(20) DEFAULT NULL COMMENT '净利润',
  `comment` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`cb_id`),
  KEY `company_id_business` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业的销售额或营业额';

-- --------------------------------------------------------

--
-- 表的结构 `company_honor`
--

DROP TABLE IF EXISTS `company_honor`;
CREATE TABLE IF NOT EXISTS `company_honor` (
  `honor_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '荣誉ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `honor_name` varchar(64) NOT NULL COMMENT '荣誉名',
  `honor_level` int(11) NOT NULL COMMENT '荣誉级别1：世界级2：国家级3：省级4：市级5：区县级6开发区级',
  `honor_time` date NOT NULL COMMENT '获奖时间',
  `honor_refer` varchar(128) NOT NULL COMMENT '奖状证明（上传地址）',
  `comment` varchar(256) NOT NULL COMMENT '备注',
  PRIMARY KEY (`honor_id`),
  KEY `company_id_honor` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业所获荣誉';

-- --------------------------------------------------------

--
-- 表的结构 `company_investment`
--

DROP TABLE IF EXISTS `company_investment`;
CREATE TABLE IF NOT EXISTS `company_investment` (
  `invest_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `invest_type_id` bigint(20) NOT NULL COMMENT '投资类型',
  `invest_type` varchar(64) NOT NULL COMMENT '投资类型名字',
  `invest_date` date DEFAULT NULL COMMENT '引入投资时间',
  `invest_count` bigint(20) DEFAULT NULL COMMENT '引入投资金额',
  `investor` varchar(128) NOT NULL COMMENT '投资人',
  `comment` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`invest_id`),
  KEY `company_id_invest` (`company_id`),
  KEY `invest_type_id` (`invest_type_id`),
  KEY `invest_type_name` (`invest_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='引入投资资金';

-- --------------------------------------------------------

--
-- 表的结构 `company_investment_type_dict`
--

DROP TABLE IF EXISTS `company_investment_type_dict`;
CREATE TABLE IF NOT EXISTS `company_investment_type_dict` (
  `invest_type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `invest_type_name` varchar(64) NOT NULL COMMENT '类型名字',
  `comment` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`invest_type_id`),
  UNIQUE KEY `invest_type_name` (`invest_type_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投资类型字典';

-- --------------------------------------------------------

--
-- 表的结构 `company_patent`
--

DROP TABLE IF EXISTS `company_patent`;
CREATE TABLE IF NOT EXISTS `company_patent` (
  `patent_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `patent_uuid` varchar(128) NOT NULL COMMENT '申请(专利)号',
  `patent_name` varchar(64) NOT NULL COMMENT '专利名称',
  `patent_type` varchar(32) NOT NULL COMMENT '专利类型：发明，实用新型，外观设计图形',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `applicate_date` date NOT NULL COMMENT '申请日',
  `issuance_date` date DEFAULT NULL COMMENT '颁发日期',
  `inventors` varchar(128) NOT NULL COMMENT '发明人：多个之间用 逗号“，”隔开',
  `patent_abstract` varchar(512) DEFAULT NULL COMMENT '摘要',
  PRIMARY KEY (`patent_id`),
  UNIQUE KEY `patent_uuid` (`patent_uuid`),
  KEY `company_id_patent` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专利情况';

-- --------------------------------------------------------

--
-- 表的结构 `company_production`
--

DROP TABLE IF EXISTS `company_production`;
CREATE TABLE IF NOT EXISTS `company_production` (
  `production_id` bigint(20) DEFAULT NULL COMMENT '产品/系列ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `production_type` int(11) DEFAULT NULL COMMENT '类型：1服务型，2实物型，3代工（受委托）',
  `production_kind` varchar(64) DEFAULT '2' COMMENT '类型：1 系列 2 产品',
  `father_product` bigint(20) DEFAULT NULL COMMENT '上级产品->指向上级系列',
  `production_year` int(11) DEFAULT NULL COMMENT '上线时间/',
  `production_status` int(11) NOT NULL DEFAULT '2' COMMENT '产品状态：1已经上线2正在研发',
  `production_name` varchar(64) DEFAULT NULL COMMENT '名称',
  `production_report` varchar(128) DEFAULT NULL COMMENT '产品报告（存储地址）',
  KEY `company_id_product` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业产品';

-- --------------------------------------------------------

--
-- 表的结构 `company_report`
--

DROP TABLE IF EXISTS `company_report`;
CREATE TABLE IF NOT EXISTS `company_report` (
  `incentive_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `year` int(11) NOT NULL COMMENT '年',
  `financial_statement` varchar(128) DEFAULT NULL COMMENT '财务报表(存储文档地址)',
  `stock_incentive` varchar(128) DEFAULT NULL COMMENT '股权激励（存储文档地址）',
  `salary_incentive` varchar(128) DEFAULT NULL COMMENT '薪酬激励（存储文档地址）',
  `strategic_plan` varchar(128) DEFAULT NULL COMMENT '战略规划书(文档地址)',
  `business_mode` varchar(128) DEFAULT NULL COMMENT '商业模式(存储文档地址)',
  `production_management` varchar(128) DEFAULT NULL COMMENT '生产管理（文档地址）',
  `service_management` varchar(128) DEFAULT NULL COMMENT '服务管理（文档地址）',
  `quality_control` varchar(128) DEFAULT NULL COMMENT '质量管理（文档地址）',
  PRIMARY KEY (`incentive_id`),
  KEY `company_id_incentive` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业报告书';

-- --------------------------------------------------------

--
-- 表的结构 `company_staff`
--

DROP TABLE IF EXISTS `company_staff`;
CREATE TABLE IF NOT EXISTS `company_staff` (
  `staff_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '人员ID',
  `company_id` bigint(20) NOT NULL COMMENT '企业ID',
  `staff_name` varchar(128) NOT NULL COMMENT '雇员姓名',
  `education_background` varchar(64) DEFAULT NULL COMMENT '学历',
  `title` varchar(64) DEFAULT NULL COMMENT '职称',
  `staff_tellphone` varchar(32) DEFAULT NULL COMMENT '手机',
  `staff_role` varchar(32) DEFAULT NULL COMMENT '角色(法人，股东，员工……）',
  `staff_position_alias` varchar(32) DEFAULT NULL COMMENT '职位（董事长，总经理，开发人员……）',
  `staff_salary` decimal(16,2) NOT NULL COMMENT '员工工资',
  `social_security_base` decimal(16,2) NOT NULL COMMENT '社保缴纳基数',
  `social_security_amount` decimal(16,2) NOT NULL COMMENT '社保缴纳额',
  `staff_status` int(11) DEFAULT '1' COMMENT '是否在职：1 在职 2 离职 3 兼职',
  `staff_status_alias` varchar(64) DEFAULT NULL COMMENT '是否在职：1 在职 2 离职 3 兼职',
  PRIMARY KEY (`staff_id`),
  KEY `company_id_staff` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业人员（待完善）';

-- --------------------------------------------------------

--
-- 表的结构 `company_staff_senior_executive`
--

DROP TABLE IF EXISTS `company_staff_senior_executive`;
CREATE TABLE IF NOT EXISTS `company_staff_senior_executive` (
  `senior_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '高管ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `staff_id` bigint(20) NOT NULL COMMENT '人员ID',
  `work_day` int(11) NOT NULL DEFAULT '0' COMMENT '每周工作天数',
  PRIMARY KEY (`senior_id`),
  KEY `company_id_senior` (`company_id`),
  KEY `staff_id_senior` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司高管名单';

-- --------------------------------------------------------

--
-- 表的结构 `company_staff_talent`
--

DROP TABLE IF EXISTS `company_staff_talent`;
CREATE TABLE IF NOT EXISTS `company_staff_talent` (
  `talent_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `staff_id` bigint(20) NOT NULL COMMENT '人员ID',
  `telent_type` int(11) NOT NULL COMMENT '人才引进类型',
  `talent_type_alias` varchar(64) NOT NULL COMMENT '人才级别头衔',
  `comment` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`talent_id`),
  KEY `company_id_talent` (`company_id`),
  KEY `staff_id_talent` (`staff_id`),
  KEY `telent_type` (`telent_type`),
  KEY `talent_type_alias` (`talent_type_alias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司人才引进情况';

-- --------------------------------------------------------

--
-- 表的结构 `company_staff_team_finance`
--

DROP TABLE IF EXISTS `company_staff_team_finance`;
CREATE TABLE IF NOT EXISTS `company_staff_team_finance` (
  `fincance_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `staff_id` bigint(20) NOT NULL COMMENT '人员ID',
  PRIMARY KEY (`fincance_id`),
  KEY `company_id_finance` (`company_id`),
  KEY `staff_id_finance` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='财务团队人员';

-- --------------------------------------------------------

--
-- 表的结构 `company_staff_team_manager`
--

DROP TABLE IF EXISTS `company_staff_team_manager`;
CREATE TABLE IF NOT EXISTS `company_staff_team_manager` (
  `mananger_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `staff_id` bigint(20) NOT NULL COMMENT '人员ID',
  PRIMARY KEY (`mananger_id`),
  KEY `company_id_manager` (`company_id`),
  KEY `staff_id_manager` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理团队人员';

-- --------------------------------------------------------

--
-- 表的结构 `company_staff_team_saler`
--

DROP TABLE IF EXISTS `company_staff_team_saler`;
CREATE TABLE IF NOT EXISTS `company_staff_team_saler` (
  `saler_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `staff_id` bigint(20) NOT NULL COMMENT '人员ID',
  PRIMARY KEY (`saler_id`),
  KEY `company_id_saler` (`company_id`),
  KEY `staff_id_saler` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='营销市场人员';

-- --------------------------------------------------------

--
-- 表的结构 `company_staff_team_tech`
--

DROP TABLE IF EXISTS `company_staff_team_tech`;
CREATE TABLE IF NOT EXISTS `company_staff_team_tech` (
  `tech_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `staff_id` bigint(20) NOT NULL COMMENT '人员ID',
  PRIMARY KEY (`tech_id`),
  KEY `company_id_team_tech` (`company_id`),
  KEY `staff_id_tech` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技术人员';

-- --------------------------------------------------------

--
-- 表的结构 `company_stage`
--

DROP TABLE IF EXISTS `company_stage`;
CREATE TABLE IF NOT EXISTS `company_stage` (
  `cs_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `change_date` date DEFAULT NULL COMMENT '更改时间',
  `campany_id` bigint(20) NOT NULL COMMENT '公司ID',
  `stage_id` bigint(20) NOT NULL COMMENT '所处阶段ID',
  `stage_name` varchar(64) NOT NULL COMMENT '所处阶段名字',
  PRIMARY KEY (`cs_id`),
  KEY `company_stage_name` (`stage_name`),
  KEY `company_stage_id` (`stage_id`),
  KEY `company_id_stage` (`campany_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业所处发展阶段';

-- --------------------------------------------------------

--
-- 表的结构 `company_stage_dict`
--

DROP TABLE IF EXISTS `company_stage_dict`;
CREATE TABLE IF NOT EXISTS `company_stage_dict` (
  `stage_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `stage_name` varchar(64) NOT NULL COMMENT '名字',
  `comment` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`stage_id`),
  UNIQUE KEY `stage_name` (`stage_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业生命周期字典';

-- --------------------------------------------------------

--
-- 表的结构 `company_sub_org`
--

DROP TABLE IF EXISTS `company_sub_org`;
CREATE TABLE IF NOT EXISTS `company_sub_org` (
  `org_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '子机构ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `org_name` varchar(64) NOT NULL COMMENT '子机构名称',
  `org_type` bigint(20) NOT NULL COMMENT '机构类型：1：子公司2：工程中心3：博士后流动站4:政府资助实验室',
  `founding_time` date NOT NULL COMMENT '成立时间',
  `address` varchar(256) NOT NULL COMMENT '地址',
  `comment` varchar(256) NOT NULL COMMENT '备注',
  `org_refer` varchar(128) NOT NULL COMMENT '子机构文档（上传地址）',
  PRIMARY KEY (`org_id`),
  KEY `company_id_sub_org` (`company_id`),
  KEY `org_type` (`org_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司子机构';

-- --------------------------------------------------------

--
-- 表的结构 `company_sub_org_dict`
--

DROP TABLE IF EXISTS `company_sub_org_dict`;
CREATE TABLE IF NOT EXISTS `company_sub_org_dict` (
  `oc_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `org_type` bigint(20) NOT NULL COMMENT '机构类型',
  `org_type_alias` varchar(64) NOT NULL COMMENT '类型名称',
  `commet` varchar(256) NOT NULL COMMENT '备注',
  PRIMARY KEY (`oc_id`),
  UNIQUE KEY `org_type` (`org_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `company_tax`
--

DROP TABLE IF EXISTS `company_tax`;
CREATE TABLE IF NOT EXISTS `company_tax` (
  `tax_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `biz_tax` int(11) NOT NULL COMMENT '营业税',
  `add_value_tax` int(11) NOT NULL COMMENT '增值税',
  `ndividual_income_tax` int(11) NOT NULL COMMENT '个人所得税',
  `enterprise_income_tax` int(11) NOT NULL COMMENT '企业所得税',
  `year` int(11) NOT NULL COMMENT '年',
  `rank_year` int(11) NOT NULL COMMENT '会计年报年度',
  PRIMARY KEY (`tax_id`),
  KEY `company_id_tax` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `company_tech_project`
--

DROP TABLE IF EXISTS `company_tech_project`;
CREATE TABLE IF NOT EXISTS `company_tech_project` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `project_name` varchar(64) DEFAULT NULL COMMENT '项目名字',
  `project_level` int(11) NOT NULL DEFAULT '1' COMMENT '项目级别：1：区县 2：市 3：省 4 国家级',
  `project_report` varchar(128) DEFAULT NULL COMMENT '立项报告（文档路径）',
  `begin_year` date DEFAULT NULL COMMENT '项目开始的时间',
  `comment` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`project_id`),
  KEY `company_id_project` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业科技立项';

-- --------------------------------------------------------

--
-- 表的结构 `finger_dict`
--

DROP TABLE IF EXISTS `finger_dict`;
CREATE TABLE IF NOT EXISTS `finger_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '指标id-名称对应字典',
  `finger_name` varchar(64) NOT NULL COMMENT '指标名称',
  `comment` varchar(128) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='指标字典';

-- --------------------------------------------------------

--
-- 表的结构 `finger_result_v0`
--

DROP TABLE IF EXISTS `finger_result_v0`;
CREATE TABLE IF NOT EXISTS `finger_result_v0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_id` bigint(20) NOT NULL,
  `company_name` varchar(128) DEFAULT NULL COMMENT '公司名字',
  `company_plate` varchar(64) DEFAULT NULL COMMENT '公司所属的板块',
  `denominator_type` varchar(8) DEFAULT 'mean' COMMENT '分母类型：mean平均值，max最大值，min最小值，极差值range',
  `year` int(11) NOT NULL,
  `period_type` varchar(8) DEFAULT 'Y' COMMENT 'Y整年 Q1 一季度 Q2 二季度 Q3三季度 Q4四季度',
  `finger_all` double DEFAULT NULL COMMENT '综合指数',
  `finger_sale` double DEFAULT NULL COMMENT '一级指标：销售指数',
  `finger_sale_invoice` double DEFAULT NULL COMMENT '二级指标：已开票的收入',
  `finger_sale_invoice_soft` double DEFAULT NULL COMMENT '已开发票的收入-软件产品',
  `finger_sale_invoice_hard` double DEFAULT NULL COMMENT '已开发票的收入-硬件产品',
  `finger_sale_invoice_consultation` double DEFAULT NULL COMMENT '已开发票的收入-咨询服务',
  `finger_sale_invoice_other` double DEFAULT NULL COMMENT '已开发票的收入-其他',
  `finger_sale_contract` double DEFAULT NULL COMMENT '二级指标：合同确认额',
  `finger_sale_contract_soft` double DEFAULT NULL COMMENT '三级指标：合同确认额-软件产品',
  `finger_sale_contract_hard` double DEFAULT NULL COMMENT '三级指标：合同确认额-硬件产品',
  `finger_sale_contract_consultation` double DEFAULT NULL COMMENT '三级指标：合同确认额-咨询服务',
  `finger_sale_contract_other` double DEFAULT NULL COMMENT '三级指标：合同确认额-其他',
  `finger_tax` double DEFAULT NULL COMMENT '一级指标：纳税指数',
  `finger_tax_corporate` double DEFAULT NULL COMMENT '二级指标：企业所得税',
  `finger_tax_corporate_taxable` double DEFAULT NULL COMMENT '三级指标：企业所得税-应纳税值',
  `finger_tax_corporate_relief` double DEFAULT NULL COMMENT '三级指标：企业所得税-税收减免值',
  `finger_tax_individual` double DEFAULT NULL COMMENT '二级指标：个人所得税',
  `finger_tax_individual_taxable` double DEFAULT NULL COMMENT '三级指标：个人所得税-应纳税值',
  `finger_tax_individual_relief` double DEFAULT NULL COMMENT '三级指标：个人所得税-税收减免',
  `finger_tax_added` double DEFAULT NULL COMMENT '二级指标：增值税',
  `finger_tax_added_taxable` double DEFAULT NULL COMMENT '三级指标：增值税-应纳税值',
  `finger_tax_added_relief` double DEFAULT NULL COMMENT '三级指标：增值税-税收减免',
  `finger_finance` double DEFAULT NULL COMMENT '一级指标：融资指数',
  `finger_finance_stock` double DEFAULT NULL COMMENT '二级指标：股权类融资',
  `finger_finance_stock_risk` double DEFAULT NULL COMMENT '三级指标：股权类融资-风投机构',
  `finger_finance_stock_gov` double DEFAULT NULL COMMENT '三级指标：股权类融资-政府企业',
  `finger_finance_stock_person` double DEFAULT NULL COMMENT '三级指标：股权类融资-个人',
  `finger_finance_debt` double DEFAULT NULL COMMENT '二级指标：债务类融资',
  `finger_finance_debt_bank` double DEFAULT NULL COMMENT '三级指标：债务类融资-银行',
  `finger_finance_debt_new` double DEFAULT NULL COMMENT '三级指标：债务类融资-新型贷款机构',
  `finger_finance_debt_lending` double DEFAULT NULL COMMENT '三级指标：债务类融资-企业拆借',
  `finger_finance_debt_person` double DEFAULT NULL COMMENT '三级指标：债务类融资-个人',
  `finger_valuation` double DEFAULT NULL COMMENT '一级指标:估值指数',
  `finger_valuation_assets` double DEFAULT NULL COMMENT '二级指标：净资产',
  `finger_valuation_assets_circulating` double DEFAULT NULL COMMENT '三级指标：净资产-流动资产',
  `finger_valuation_assets_uncirculating` double DEFAULT NULL COMMENT '三级指标：净资产-非流动资产',
  `finger_valuation_assets_debt_circulating` double DEFAULT NULL COMMENT '三级指标：净资产-流动负债',
  `finger_valuation_assets_debt_uncirculating` double DEFAULT NULL COMMENT '三级指标：净资产-非流动负债',
  `finger_valuation_actual` double DEFAULT NULL COMMENT '二级指标：实际估值',
  `finger_valuation_actual_first` double DEFAULT NULL COMMENT '三级指标：实际估值-首次融资',
  `finger_valuation_actual_latest` double DEFAULT NULL COMMENT '三级指标：实际估值-最近一次融资估值',
  `finger_valuation_actual_want` double DEFAULT NULL COMMENT '三级指标：实际估值-现在准备融资估值',
  `finger_hr` double DEFAULT NULL COMMENT '一级指标：人力资源指数',
  `finger_hr_partime` double DEFAULT NULL COMMENT '二级指标：兼职员工数',
  `finger_hr_partime_dev` double DEFAULT NULL COMMENT '三级指标：兼职员工-研发',
  `finger_hr_partime_manage` double DEFAULT NULL COMMENT '三级指标：兼职员工-管理',
  `finger_hr_partime_admin` double DEFAULT NULL COMMENT '三级指标：兼职员工-行政',
  `finger_hr_partime_saler` double DEFAULT NULL COMMENT '三级指标：兼职员工-销售',
  `finger_hr_fulltime` double DEFAULT NULL COMMENT '二级指标：全职员工',
  `finger_hr_fulltime_dev` double DEFAULT NULL COMMENT '三级指标：全职员工-研发',
  `finger_hr_fulltime_senior` double DEFAULT NULL COMMENT '三级指标：全职员工-高管',
  `finger_hr_fulltime_admin` double DEFAULT NULL COMMENT '三级指标：全职员工-行政',
  `finger_hr_fulltime_saler` double DEFAULT NULL COMMENT '三级指标：全职员工-销售',
  `finger_hr_educated` double DEFAULT NULL COMMENT '二级指标：高学历人员',
  `finger_hr_educated_doc` double DEFAULT NULL COMMENT '三级指标：高学历人员-博士',
  `finger_hr_educated_master` double DEFAULT NULL COMMENT '三级指标：高学历人员-硕士',
  `finger_hr_bachelor` double DEFAULT NULL COMMENT '三级指标：高学历人员-学士',
  `finger_innovate` double DEFAULT NULL COMMENT '一级指标：创新指数',
  `finger_innovate_patent_apply` double DEFAULT NULL COMMENT '二级指标：专利申请',
  `finger_innovate_patent_apply_invention` double DEFAULT NULL COMMENT '三级指标：专利申请-发明',
  `finger_innovate_patent_apply_utility` double DEFAULT NULL COMMENT '三级指标：专利申请-实用新型',
  `finger_innovate_patent_apply_appear` double DEFAULT NULL COMMENT '三级指标：专利申请-外观设计',
  `finger_innovate_patent_grant` double DEFAULT NULL COMMENT '二级指标：专利授权',
  `finger_innovate_patent_grant_invention` double DEFAULT NULL COMMENT '三级指标：专利授权-发明',
  `finger_innovate_patent_grant_utility` double DEFAULT NULL COMMENT '三级指标：专利授权-实用新型',
  `finger_innovate_patent_grant_appear` double DEFAULT NULL COMMENT '三级指标：专利授权-外观设计',
  `finger_innovate_copyright_apply` double DEFAULT NULL COMMENT '二级指标：著作权申请',
  `finger_innovate_copyright_apply_soft` double DEFAULT NULL COMMENT '三级指标：著作权申请-软件类',
  `finger_innovate_copyright_apply_unsoft` double DEFAULT NULL COMMENT '三级指标：著作权申请-非软件类',
  `finger_innovate_copyright_grant` double DEFAULT NULL COMMENT '二级指标：著作权授权',
  `finger_innovate_copyright_grant_soft` double DEFAULT NULL COMMENT '三级指标：著作权授权-软件类',
  `finger_innovate_copyright_grant_unsoft` double DEFAULT NULL COMMENT '三级指标：著作权授权-非软件类',
  `finger_innovate_new_product` double DEFAULT NULL COMMENT '二级指标：新产品/服务',
  `finger_innovate_new_product_patent` double DEFAULT NULL COMMENT '三级指标：新产品/服务-专利类',
  `finger_innovate_new_product_tech` double DEFAULT NULL COMMENT '三级指标：新产品/服务-专用技术',
  `finger_innovate_new_product_bus` double DEFAULT NULL COMMENT '三级指标：新产品/服务-商业模式',
  `finger_salary` double DEFAULT NULL COMMENT '一级指标：薪酬指数',
  `finger_salary_staff` double DEFAULT NULL COMMENT '二级指标：员工工资额',
  `finger_salary_staff_up_10` double DEFAULT NULL COMMENT '三级指标：员工工资额-1万元以上',
  `finger_salary_staff_5_10` double DEFAULT NULL COMMENT '三级指标：员工工资额-5千到1万',
  `finger_salary_staff_down_5` double DEFAULT NULL COMMENT '三级指标：员工工资额-5千以下',
  `finger_salary_staff_contribution` double DEFAULT NULL COMMENT '二级指标：员工贡献率',
  `finger_salary_staff_contribution_meansale` double DEFAULT NULL COMMENT '三级指标：员工贡献率-人均销售',
  `finger_salary_staff_contribution_meantax` double DEFAULT NULL COMMENT '三级指标：员工贡献率-人均纳税',
  `finger_learn` double DEFAULT NULL COMMENT '一级指标：学习指数',
  `finger_learn_train` double DEFAULT NULL COMMENT '二级指标：参加培训的次数',
  `finger_learn_train_manage` double DEFAULT NULL COMMENT '三级指标：参加培训的次数-管理类',
  `finger_learn_train_policy` double DEFAULT NULL COMMENT '三级指标：参加培训的次数-政策法规',
  `finger_learn_train_skill` double DEFAULT NULL COMMENT '三级指标：参加培训的次数-技能类',
  `finger_learn_conslted` double DEFAULT NULL COMMENT '二级指标：接受咨询的次数',
  `finger_learn_conslted_manage` double DEFAULT NULL COMMENT '三级指标：接受咨询的次数-管理类',
  `finger_learn_conslted_policy` double DEFAULT NULL COMMENT '三级指标：接受咨询的次数-政策法规',
  `finger_learn_conslted_skill` double DEFAULT NULL COMMENT '三级指标：接受咨询的次数-技能类',
  `finger_brand` double DEFAULT NULL COMMENT '一级指标：品牌指数',
  `finger_brand_reward` double DEFAULT NULL COMMENT '二级指标：企业获奖',
  `finger_brand_reward_area` double DEFAULT NULL COMMENT '三级指标：企业获奖-区级',
  `finger_brand_reward_city` double DEFAULT NULL COMMENT '三级指标：企业获奖-市级',
  `finger_brand_reward_province` double DEFAULT NULL COMMENT '三级指标：企业获奖-省级',
  `finger_brand_reward_country` double DEFAULT NULL COMMENT '三级指标：企业获奖-国家级',
  `finger_brand_recognition` double DEFAULT NULL COMMENT '二级指标：企业认定',
  `finger_brand_recognition_area` double DEFAULT NULL COMMENT '三级指标：企业认定-区级',
  `finger_brand_recognition_city` double DEFAULT NULL COMMENT '三级指标：企业认定-市级',
  `finger_brand_recognition_province` double DEFAULT NULL COMMENT '三级指标：企业认定-省级',
  `finger_brand_recognition_country` double DEFAULT NULL COMMENT '三级指标：企业认定-国家级',
  `finger_brand_talent` double DEFAULT NULL COMMENT '二级指标：人才资助',
  `finger_brand_talent_area` double DEFAULT NULL COMMENT '三级指标：人才资助-区级',
  `finger_brand_talent_city` double DEFAULT NULL COMMENT '三级指标：人才资助-市级',
  `finger_brand_talent_province` double DEFAULT NULL COMMENT '三级指标：人才资助-省级',
  `finger_brand_talent_country` double DEFAULT NULL COMMENT '三级指标：人才资助-国家级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='写死的表结构';

--
-- 转存表中的数据 `finger_result_v0`
--

INSERT INTO `finger_result_v0` (`id`, `company_id`, `company_name`, `company_plate`, `denominator_type`, `year`, `period_type`, `finger_all`, `finger_sale`, `finger_sale_invoice`, `finger_sale_invoice_soft`, `finger_sale_invoice_hard`, `finger_sale_invoice_consultation`, `finger_sale_invoice_other`, `finger_sale_contract`, `finger_sale_contract_soft`, `finger_sale_contract_hard`, `finger_sale_contract_consultation`, `finger_sale_contract_other`, `finger_tax`, `finger_tax_corporate`, `finger_tax_corporate_taxable`, `finger_tax_corporate_relief`, `finger_tax_individual`, `finger_tax_individual_taxable`, `finger_tax_individual_relief`, `finger_tax_added`, `finger_tax_added_taxable`, `finger_tax_added_relief`, `finger_finance`, `finger_finance_stock`, `finger_finance_stock_risk`, `finger_finance_stock_gov`, `finger_finance_stock_person`, `finger_finance_debt`, `finger_finance_debt_bank`, `finger_finance_debt_new`, `finger_finance_debt_lending`, `finger_finance_debt_person`, `finger_valuation`, `finger_valuation_assets`, `finger_valuation_assets_circulating`, `finger_valuation_assets_uncirculating`, `finger_valuation_assets_debt_circulating`, `finger_valuation_assets_debt_uncirculating`, `finger_valuation_actual`, `finger_valuation_actual_first`, `finger_valuation_actual_latest`, `finger_valuation_actual_want`, `finger_hr`, `finger_hr_partime`, `finger_hr_partime_dev`, `finger_hr_partime_manage`, `finger_hr_partime_admin`, `finger_hr_partime_saler`, `finger_hr_fulltime`, `finger_hr_fulltime_dev`, `finger_hr_fulltime_senior`, `finger_hr_fulltime_admin`, `finger_hr_fulltime_saler`, `finger_hr_educated`, `finger_hr_educated_doc`, `finger_hr_educated_master`, `finger_hr_bachelor`, `finger_innovate`, `finger_innovate_patent_apply`, `finger_innovate_patent_apply_invention`, `finger_innovate_patent_apply_utility`, `finger_innovate_patent_apply_appear`, `finger_innovate_patent_grant`, `finger_innovate_patent_grant_invention`, `finger_innovate_patent_grant_utility`, `finger_innovate_patent_grant_appear`, `finger_innovate_copyright_apply`, `finger_innovate_copyright_apply_soft`, `finger_innovate_copyright_apply_unsoft`, `finger_innovate_copyright_grant`, `finger_innovate_copyright_grant_soft`, `finger_innovate_copyright_grant_unsoft`, `finger_innovate_new_product`, `finger_innovate_new_product_patent`, `finger_innovate_new_product_tech`, `finger_innovate_new_product_bus`, `finger_salary`, `finger_salary_staff`, `finger_salary_staff_up_10`, `finger_salary_staff_5_10`, `finger_salary_staff_down_5`, `finger_salary_staff_contribution`, `finger_salary_staff_contribution_meansale`, `finger_salary_staff_contribution_meantax`, `finger_learn`, `finger_learn_train`, `finger_learn_train_manage`, `finger_learn_train_policy`, `finger_learn_train_skill`, `finger_learn_conslted`, `finger_learn_conslted_manage`, `finger_learn_conslted_policy`, `finger_learn_conslted_skill`, `finger_brand`, `finger_brand_reward`, `finger_brand_reward_area`, `finger_brand_reward_city`, `finger_brand_reward_province`, `finger_brand_reward_country`, `finger_brand_recognition`, `finger_brand_recognition_area`, `finger_brand_recognition_city`, `finger_brand_recognition_province`, `finger_brand_recognition_country`, `finger_brand_talent`, `finger_brand_talent_area`, `finger_brand_talent_city`, `finger_brand_talent_province`, `finger_brand_talent_country`) VALUES
(1, 1, 'hah', 'A', 'mean', 2018, 'Y', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 2, 'hah', 'A', 'mean', 2018, 'Y', 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `finger_template`
--

DROP TABLE IF EXISTS `finger_template`;
CREATE TABLE IF NOT EXISTS `finger_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `finger_id` bigint(20) NOT NULL COMMENT '指标id',
  `finger_name` varchar(64) NOT NULL COMMENT '指标名称',
  `parent_id` bigint(20) NOT NULL COMMENT '父节点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `finger_v1`
--

DROP TABLE IF EXISTS `finger_v1`;
CREATE TABLE IF NOT EXISTS `finger_v1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'main key',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `year` int(11) NOT NULL COMMENT '年份',
  `period_type` varchar(8) NOT NULL COMMENT '指标时间类型：默认 Y全年 M1一月 M2二月 Q1第一季度 Q2 第二季度',
  `finger_name_id` bigint(20) NOT NULL COMMENT '自定义的指标id',
  `finger_name` varchar(64) NOT NULL COMMENT '指标名称',
  `finger_value` double NOT NULL COMMENT '指标值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基础指标版本 v1';

-- --------------------------------------------------------

--
-- 表的结构 `industry_dict`
--

DROP TABLE IF EXISTS `industry_dict`;
CREATE TABLE IF NOT EXISTS `industry_dict` (
  `industry_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `industry_name` varchar(128) NOT NULL COMMENT '行业命名',
  PRIMARY KEY (`industry_id`),
  UNIQUE KEY `industry_name` (`industry_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='所属行业——行业分类字典';

-- --------------------------------------------------------

--
-- 表的结构 `shareholder`
--

DROP TABLE IF EXISTS `shareholder`;
CREATE TABLE IF NOT EXISTS `shareholder` (
  `shareholder_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `staff_id` bigint(20) NOT NULL COMMENT '人员ID',
  `staff_name` varchar(64) DEFAULT NULL COMMENT '股东姓名',
  `proportion` int(11) NOT NULL COMMENT '股份占比',
  PRIMARY KEY (`shareholder_id`),
  KEY `company_id_share` (`company_id`),
  KEY `staff_id` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='股东信息';

-- --------------------------------------------------------

--
-- 表的结构 `talent_dict`
--

DROP TABLE IF EXISTS `talent_dict`;
CREATE TABLE IF NOT EXISTS `talent_dict` (
  `telent_type_dict` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `telent_type` int(11) NOT NULL COMMENT '类型',
  `telent_title` varchar(64) NOT NULL COMMENT '类型名字',
  `commet` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`telent_type_dict`),
  UNIQUE KEY `telent_type` (`telent_type`),
  KEY `telent_title` (`telent_title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='国家人才引进计划字典';

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(64) NOT NULL COMMENT '用户名',
  `user_phone` varchar(32) NOT NULL COMMENT '手机号',
  `role_id` bigint(20) DEFAULT '99' COMMENT '角色ID',
  `user_avatar` varchar(128) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_phone` (`user_phone`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息';

-- --------------------------------------------------------

--
-- 表的结构 `user_auth`
--

DROP TABLE IF EXISTS `user_auth`;
CREATE TABLE IF NOT EXISTS `user_auth` (
  `auth_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `identity_type` varchar(64) NOT NULL COMMENT '登录类型（账号密码，手机，微信微博）',
  `identity_type_id` bigint(20) NOT NULL COMMENT '登录类型的ID，看用哪个吧',
  `identifier` varchar(128) NOT NULL COMMENT '账号，不管什么登录类型总有账号',
  `credential` varchar(128) NOT NULL COMMENT '不管什么，总有密码吧',
  PRIMARY KEY (`auth_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='username/phone+password or 第三方user+token 都是基础信息表加上用户授权信息的形式';

-- --------------------------------------------------------

--
-- 表的结构 `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色命名',
  `role_level` int(11) DEFAULT NULL COMMENT '角色级别',
  `level_name` varchar(64) DEFAULT NULL COMMENT '级别命名',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色定义';

-- --------------------------------------------------------

--
-- 表的结构 `user_tk`
--

DROP TABLE IF EXISTS `user_tk`;
CREATE TABLE IF NOT EXISTS `user_tk` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pwd` varchar(64) NOT NULL,
  `userid` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user_tk`
--

INSERT INTO `user_tk` (`id`, `pwd`, `userid`) VALUES
(1, '22b2efb8019e52d677649b779241466d', '123456789'),
(2, '22b2efb8019e52d677649b779241466d', '123456789'),
(3, '22b2efb8019e52d677649b779241466d', '123456789'),
(4, '22b2efb8019e52d677649b779241466d', '123456789'),
(5, '22b2efb8019e52d677649b779241466d', '123456789'),
(6, '22b2efb8019e52d677649b779241466d', '123456789'),
(7, '22b2efb8019e52d677649b779241466d', '123456789'),
(8, '22b2efb8019e52d677649b779241466d', '123456789'),
(9, '22b2efb8019e52d677649b779241466d', '123456789'),
(10, '22b2efb8019e52d677649b779241466d', '123456789'),
(11, '22b2efb8019e52d677649b779241466d', '123456789'),
(12, '22b2efb8019e52d677649b779241466d', '123456789'),
(13, '22b2efb8019e52d677649b779241466d', '123456789'),
(14, '22b2efb8019e52d677649b779241466d', '123456789'),
(15, '22b2efb8019e52d677649b779241466d', '1234567890'),
(16, '22b2efb8019e52d677649b779241466d', '1234567890'),
(17, '22b2efb8019e52d677649b779241466d', '1234567890'),
(18, '22b2efb8019e52d677649b779241466d', '1234567890');

--
-- 限制导出的表
--

--
-- 限制表 `business_scope`
--
ALTER TABLE `business_scope`
  ADD CONSTRAINT `business_scope_id` FOREIGN KEY (`biz_scope_id`) REFERENCES `business_scope_dict` (`business_scope_id`),
  ADD CONSTRAINT `business_scope_name` FOREIGN KEY (`biz_scope_name`) REFERENCES `business_scope_dict` (`business_scope_name`),
  ADD CONSTRAINT `company_id` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`);

--
-- 限制表 `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `industry_id` FOREIGN KEY (`industry_type`) REFERENCES `industry_dict` (`industry_id`),
  ADD CONSTRAINT `industry_name` FOREIGN KEY (`regis_type_alias`) REFERENCES `industry_dict` (`industry_name`);

--
-- 限制表 `company_asset`
--
ALTER TABLE `company_asset`
  ADD CONSTRAINT `company_id_asset` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`);

--
-- 限制表 `company_business`
--
ALTER TABLE `company_business`
  ADD CONSTRAINT `company_id_business` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`);

--
-- 限制表 `company_honor`
--
ALTER TABLE `company_honor`
  ADD CONSTRAINT `company_id_honor` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`);

--
-- 限制表 `company_investment`
--
ALTER TABLE `company_investment`
  ADD CONSTRAINT `company_id_invest` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `invest_type_id` FOREIGN KEY (`invest_type_id`) REFERENCES `company_investment_type_dict` (`invest_type_id`),
  ADD CONSTRAINT `invest_type_name` FOREIGN KEY (`invest_type`) REFERENCES `company_investment_type_dict` (`invest_type_name`);

--
-- 限制表 `company_patent`
--
ALTER TABLE `company_patent`
  ADD CONSTRAINT `company_id_patent` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`);

--
-- 限制表 `company_production`
--
ALTER TABLE `company_production`
  ADD CONSTRAINT `company_id_product` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`);

--
-- 限制表 `company_report`
--
ALTER TABLE `company_report`
  ADD CONSTRAINT `company_id_incentive` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`);

--
-- 限制表 `company_staff`
--
ALTER TABLE `company_staff`
  ADD CONSTRAINT `company_id_staff` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`);

--
-- 限制表 `company_staff_senior_executive`
--
ALTER TABLE `company_staff_senior_executive`
  ADD CONSTRAINT `company_id_senior` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `staff_id_senior` FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`);

--
-- 限制表 `company_staff_talent`
--
ALTER TABLE `company_staff_talent`
  ADD CONSTRAINT `company_id_talent` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `staff_id_talent` FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`),
  ADD CONSTRAINT `talent_type_alias` FOREIGN KEY (`talent_type_alias`) REFERENCES `talent_dict` (`telent_title`),
  ADD CONSTRAINT `telent_type` FOREIGN KEY (`telent_type`) REFERENCES `talent_dict` (`telent_type`);

--
-- 限制表 `company_staff_team_finance`
--
ALTER TABLE `company_staff_team_finance`
  ADD CONSTRAINT `company_id_finance` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `staff_id_finance` FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`);

--
-- 限制表 `company_staff_team_manager`
--
ALTER TABLE `company_staff_team_manager`
  ADD CONSTRAINT `company_id_manager` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `staff_id_manager` FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`);

--
-- 限制表 `company_staff_team_saler`
--
ALTER TABLE `company_staff_team_saler`
  ADD CONSTRAINT `company_id_saler` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `staff_id_saler` FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`);

--
-- 限制表 `company_staff_team_tech`
--
ALTER TABLE `company_staff_team_tech`
  ADD CONSTRAINT `company_id_team_tech` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `staff_id_tech` FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`);

--
-- 限制表 `company_stage`
--
ALTER TABLE `company_stage`
  ADD CONSTRAINT `company_id_stage` FOREIGN KEY (`campany_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `company_stage_id` FOREIGN KEY (`stage_id`) REFERENCES `company_stage_dict` (`stage_id`),
  ADD CONSTRAINT `company_stage_name` FOREIGN KEY (`stage_name`) REFERENCES `company_stage_dict` (`stage_name`);

--
-- 限制表 `company_sub_org`
--
ALTER TABLE `company_sub_org`
  ADD CONSTRAINT `company_id_sub_org` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `org_type` FOREIGN KEY (`org_type`) REFERENCES `company_sub_org_dict` (`org_type`);

--
-- 限制表 `company_tax`
--
ALTER TABLE `company_tax`
  ADD CONSTRAINT `company_id_tax` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`);

--
-- 限制表 `company_tech_project`
--
ALTER TABLE `company_tech_project`
  ADD CONSTRAINT `company_id_project` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`);

--
-- 限制表 `shareholder`
--
ALTER TABLE `shareholder`
  ADD CONSTRAINT `company_id_share` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `staff_id` FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`);

--
-- 限制表 `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`role_id`);

--
-- 限制表 `user_auth`
--
ALTER TABLE `user_auth`
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
