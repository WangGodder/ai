/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : newswulib3

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-03-05 17:10:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for business_scope
-- ----------------------------
DROP TABLE IF EXISTS `business_scope`;
CREATE TABLE `business_scope` (
`biz_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`biz_scope_id`  bigint(20) NOT NULL COMMENT '经营范围ID' ,
`biz_scope_name`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '经营范围命名' ,
`company_id`  bigint(20) NOT NULL COMMENT '备注' ,
PRIMARY KEY (`biz_id`),
FOREIGN KEY (`biz_scope_id`) REFERENCES `business_scope_dict` (`business_scope_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`biz_scope_name`) REFERENCES `business_scope_dict` (`business_scope_name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id` (`company_id`) USING BTREE ,
INDEX `business_scope_id` (`biz_scope_id`) USING BTREE ,
INDEX `business_scope_name` (`biz_scope_name`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='企业经营范围'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of business_scope
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for business_scope_dict
-- ----------------------------
DROP TABLE IF EXISTS `business_scope_dict`;
CREATE TABLE `business_scope_dict` (
`business_scope_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '经营范围ID' ,
`business_scope_name`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '经营范围名字' ,
PRIMARY KEY (`business_scope_id`),
UNIQUE INDEX `business_scope_name` (`business_scope_name`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='经营范围字典'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of business_scope_dict
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
`company_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公司id' ,
`company_name`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司名字' ,
`company_address`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址' ,
`regis_type`  int(11) NULL DEFAULT NULL COMMENT '注册类型：0、 个体工商户1、个人独资企业2、合伙企业3、有限合伙企业4、有限责任公司5、股份有限公司' ,
`approval_authority`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批准设立机关' ,
`credit_code`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '统一社会信用代码' ,
`estab_date`  date NULL DEFAULT NULL COMMENT '成立日期' ,
`tax_number`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '纳税人识别号' ,
`industry_type`  int(11) NULL DEFAULT NULL COMMENT '所属行业' ,
`industry_type_alias`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属行业' ,
`regis_type_alias`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册类型：0、 个体工商户1、个人独资企业2、合伙企业3、有限合伙企业4、有限责任公司5、股份有限公司' ,
`approval_date`  date NULL DEFAULT NULL COMMENT '核准日期' ,
`busniss_term`  date NULL DEFAULT NULL COMMENT '营业期限 ' ,
`postal_code`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码' ,
`tell_phone`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话' ,
`legal_representative`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法定代表人' ,
`company_name_eng`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业英文名' ,
`location_area`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属地区' ,
`license_picture`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照照片' ,
PRIMARY KEY (`company_id`),
FOREIGN KEY (`industry_type`) REFERENCES `industry_dict` (`industry_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`regis_type_alias`) REFERENCES `industry_dict` (`industry_name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `company_name` (`company_name`) USING BTREE ,
UNIQUE INDEX `credit_code` (`credit_code`) USING BTREE ,
UNIQUE INDEX `tax_number` (`tax_number`) USING BTREE ,
INDEX `industry_id` (`industry_type`) USING BTREE ,
INDEX `industry_name` (`regis_type_alias`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='企业基本信息'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_asset
-- ----------------------------
DROP TABLE IF EXISTS `company_asset`;
CREATE TABLE `company_asset` (
`asset_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`year`  int(11) NOT NULL COMMENT '年' ,
`rank_year`  int(11) NULL DEFAULT NULL COMMENT '年度' ,
`asset_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产名' ,
`asset_amount`  bigint(20) NOT NULL COMMENT '资产数额' ,
`commet`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
PRIMARY KEY (`asset_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_asset` (`company_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='企业资产信息'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_asset
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_business
-- ----------------------------
DROP TABLE IF EXISTS `company_business`;
CREATE TABLE `company_business` (
`cb_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '企业ID' ,
`year`  int(11) NOT NULL COMMENT '年' ,
`month`  int(11) NULL DEFAULT NULL COMMENT '月' ,
`quarter`  varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '季度Q1,Q2,Q3,Q4' ,
`sales`  bigint(20) NULL DEFAULT NULL COMMENT '销售额' ,
`turnover`  bigint(20) NULL DEFAULT NULL COMMENT '营业额' ,
`profit`  bigint(20) NULL DEFAULT NULL COMMENT '净利润' ,
`comment`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
PRIMARY KEY (`cb_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_business` (`company_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='企业的销售额或营业额'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_business
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_honor
-- ----------------------------
DROP TABLE IF EXISTS `company_honor`;
CREATE TABLE `company_honor` (
`honor_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '荣誉ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`honor_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '荣誉名' ,
`honor_level`  int(11) NOT NULL COMMENT '荣誉级别1：世界级2：国家级3：省级4：市级5：区县级6开发区级' ,
`honor_time`  date NOT NULL COMMENT '获奖时间' ,
`honor_refer`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '奖状证明（上传地址）' ,
`comment`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注' ,
PRIMARY KEY (`honor_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_honor` (`company_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='企业所获荣誉'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_honor
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_input
-- ----------------------------
DROP TABLE IF EXISTS `company_input`;
CREATE TABLE `company_input` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`companyname`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司名称' ,
`industry`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属行业' ,
`region`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '区域' ,
`year`  int(11) NOT NULL COMMENT '年' ,
`quarter`  int(11) NOT NULL COMMENT '季度' ,
`ticketincomesoftware`  double(20,5) NULL DEFAULT 0.00000 COMMENT '开票软件收入' ,
`ticketincomehardware`  double(20,5) NULL DEFAULT 0.00000 COMMENT '开票硬件收入' ,
`ticketincomeconsult`  double(20,5) NULL DEFAULT 0.00000 COMMENT '开票咨询收入' ,
`ticketincomeother`  double(20,5) NULL DEFAULT 0.00000 COMMENT '开票其他收入' ,
`contractincomesoftware`  double(20,5) NULL DEFAULT 0.00000 COMMENT '合同软件收入' ,
`contractincomehardware`  double(20,5) NULL DEFAULT 0.00000 COMMENT '合同硬件收入' ,
`contractincomeconsult`  double(20,5) NULL DEFAULT 0.00000 COMMENT '合同咨询收入' ,
`contractincomeother`  double(20,5) NULL DEFAULT 0.00000 COMMENT '合同其他收入' ,
`incometaxable`  double(20,5) NULL DEFAULT 0.00000 COMMENT '所得税' ,
`incometaxdeduction`  double(20,5) NULL DEFAULT 0.00000 COMMENT '所得税减免' ,
`pensonaltaxable`  double(20,5) NULL DEFAULT 0.00000 COMMENT '个人所得税' ,
`pensonaltaxdecution`  double(20,5) NULL DEFAULT 0.00000 COMMENT '个人所得税减免' ,
`addvaluetaxable`  double(20,5) NULL DEFAULT 0.00000 COMMENT '附加税' ,
`addvaluetaxdecution`  double(20,5) NULL DEFAULT 0.00000 COMMENT '附加税减免' ,
`stockfinancevc`  double(20,5) NULL DEFAULT 0.00000 COMMENT '股权风投' ,
`stockfinancegovenment`  double(20,5) NULL DEFAULT 0.00000 COMMENT '股权政府企业' ,
`stockfinancepensonal`  double(20,5) NULL DEFAULT 0.00000 COMMENT '股权个人' ,
`debtfinancebank`  double(20,5) NULL DEFAULT 0.00000 COMMENT '债务银行' ,
`debtfinanceli`  double(20,5) NULL DEFAULT 0.00000 COMMENT '债务新型借贷机构' ,
`debtfinancecompany`  double(20,5) NULL DEFAULT 0.00000 COMMENT '债务公司拆解' ,
`debtfinancepensonal`  double(20,5) NULL DEFAULT 0.00000 COMMENT 'z债务个人' ,
`currentasset`  double(20,5) NULL DEFAULT 0.00000 COMMENT 'l流动资产' ,
`nocurrentasset`  double(20,5) NULL DEFAULT 0.00000 COMMENT 'f非流动资产' ,
`currentdebt`  double(20,5) NULL DEFAULT 0.00000 COMMENT 'l流动借债' ,
`nocurrentdebt`  double(20,5) NULL DEFAULT 0.00000 COMMENT 'f非流动借债' ,
`firstfinancevalue`  double(20,5) NULL DEFAULT 0.00000 COMMENT 's首次融资估值' ,
`lastfinancevalue`  double(20,5) NULL DEFAULT 0.00000 COMMENT 'z最后一次融资估值' ,
`currentfinancevalue`  double(20,5) NULL DEFAULT 0.00000 COMMENT 'x现在融资估值' ,
`parttimedevelopment`  int(11) NULL DEFAULT 0 COMMENT '兼职研发' ,
`parttimemanager`  int(11) NULL DEFAULT 0 COMMENT 'j兼职管理' ,
`parttimeadmin`  int(11) NULL DEFAULT 0 COMMENT 'j兼职行政' ,
`parttimesell`  int(11) NULL DEFAULT 0 COMMENT 'j兼职销售' ,
`development`  int(11) NULL DEFAULT 0 COMMENT 'k开发人数' ,
`manamger`  int(11) NULL DEFAULT 0 COMMENT 'g管理人数' ,
`administrator`  int(11) NULL DEFAULT 0 COMMENT 'g行政人数' ,
`sell`  int(11) NULL DEFAULT 0 COMMENT 'x销售人数' ,
`doctor`  int(11) NULL DEFAULT 0 COMMENT '博士人数' ,
`master`  int(11) NULL DEFAULT 0 COMMENT '硕士人数' ,
`bachelor`  int(11) NULL DEFAULT 0 COMMENT '学士人数' ,
`applypatentinvent`  int(11) NULL DEFAULT 0 COMMENT '申请专利 发明' ,
`applypatentindustry`  int(11) NULL DEFAULT 0 COMMENT '申请专利 实业' ,
`applypatentdesign`  int(11) NULL DEFAULT 0 COMMENT '申请专利 设计' ,
`patentinvent`  int(11) NULL DEFAULT 0 COMMENT '获取专利 研发' ,
`patentindustry`  int(11) NULL DEFAULT 0 COMMENT '获取专利 实业' ,
`patentdesign`  int(11) NULL DEFAULT 0 COMMENT '获取专利 设计' ,
`applyauthorsoftware`  int(11) NULL DEFAULT 0 COMMENT '申请著作权 软件' ,
`applyauthorother`  int(11) NULL DEFAULT 0 COMMENT '申请著作权 非软件' ,
`authorsoftware`  int(11) NULL DEFAULT 0 COMMENT '著作权 软件' ,
`authorother`  int(11) NULL DEFAULT 0 COMMENT '著作权 非软件' ,
`servicepatent`  int(11) NULL DEFAULT 0 COMMENT '新产品服务数 专利类' ,
`serviceskill`  int(11) NULL DEFAULT 0 COMMENT '新产品服务数 专用技术' ,
`servicesell`  int(11) NULL DEFAULT 0 COMMENT '新产品服务数 商业模式' ,
`salaryhigh`  double(20,5) NULL DEFAULT 0.00000 COMMENT '>10000工资总数' ,
`salarymiddle`  double(20,5) NULL DEFAULT 0.00000 COMMENT '5000-10000工资总数' ,
`salarylow`  double(20,5) NULL DEFAULT 0.00000 COMMENT '<5000工资总和' ,
`persell`  double(20,5) NULL DEFAULT 0.00000 COMMENT '人均销售' ,
`pertax`  double(20,5) NULL DEFAULT 0.00000 COMMENT '人均纳税' ,
`trainmanage`  int(11) NULL DEFAULT 0 COMMENT '参加训练次数 管理' ,
`trainlegal`  int(11) NULL DEFAULT 0 COMMENT '参加训练次数 法规' ,
`trainskill`  int(11) NULL DEFAULT 0 COMMENT '参加训练次数 技能' ,
`consultmanage`  int(11) NULL DEFAULT 0 COMMENT '参与咨询次数 管理' ,
`consultlegal`  int(11) NULL DEFAULT 0 COMMENT '参与咨询次数 法规' ,
`consultskill`  int(11) NULL DEFAULT 0 COMMENT '参与咨询次数 技能' ,
`awarddistrict`  int(11) NULL DEFAULT 0 COMMENT '获奖次数 区级' ,
`awardcity`  int(11) NULL DEFAULT 0 COMMENT '获奖次数 市级' ,
`awardprovince`  int(11) NULL DEFAULT 0 COMMENT '获奖次数 省级' ,
`awardnation`  int(11) NULL DEFAULT 0 COMMENT '获奖次数 国家级' ,
`comfirmdistrict`  int(11) NULL DEFAULT 0 COMMENT '认定次数 区级' ,
`comfirmcity`  int(11) NULL DEFAULT 0 COMMENT '认定次数 市级' ,
`comfirmprovince`  int(11) NULL DEFAULT 0 COMMENT '认定次数 省级' ,
`comfirmnation`  int(11) NULL DEFAULT 0 COMMENT '认定次数 国家级' ,
`supportdistrict`  int(11) NULL DEFAULT 0 COMMENT '人才资助 区级' ,
`supportcity`  int(11) NULL DEFAULT 0 COMMENT '人才资助 市级' ,
`supportprovince`  int(11) NULL DEFAULT 0 COMMENT '人才资助 省级' ,
`supportnation`  int(11) NULL DEFAULT 0 COMMENT '人才资助 国家级' ,
PRIMARY KEY (`id`),
INDEX `input_company_id` (`companyname`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
COMMENT='所有录入数据'
AUTO_INCREMENT=4

;

-- ----------------------------
-- Records of company_input
-- ----------------------------
BEGIN;
INSERT INTO `company_input` VALUES ('1', 'company name', 'IT', '中国', '2019', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('2', 'company name2', 'IT', '中国', '2019', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('3', 'company name2', 'IT', '中国', '2018', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('4', 'company name2', 'IT', '西峡区', '2018', '2', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0.00000', '0.00000', '0.00000', '0.00000', '0.00000', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
COMMIT;

-- ----------------------------
-- Table structure for company_investment
-- ----------------------------
DROP TABLE IF EXISTS `company_investment`;
CREATE TABLE `company_investment` (
`invest_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`invest_type_id`  bigint(20) NOT NULL COMMENT '投资类型' ,
`invest_type`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '投资类型名字' ,
`invest_date`  date NULL DEFAULT NULL COMMENT '引入投资时间' ,
`invest_count`  bigint(20) NULL DEFAULT NULL COMMENT '引入投资金额' ,
`investor`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '投资人' ,
`comment`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
PRIMARY KEY (`invest_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`invest_type_id`) REFERENCES `company_investment_type_dict` (`invest_type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`invest_type`) REFERENCES `company_investment_type_dict` (`invest_type_name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_invest` (`company_id`) USING BTREE ,
INDEX `invest_type_id` (`invest_type_id`) USING BTREE ,
INDEX `invest_type_name` (`invest_type`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='引入投资资金'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_investment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_investment_type_dict
-- ----------------------------
DROP TABLE IF EXISTS `company_investment_type_dict`;
CREATE TABLE `company_investment_type_dict` (
`invest_type_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`invest_type_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型名字' ,
`comment`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
PRIMARY KEY (`invest_type_id`),
UNIQUE INDEX `invest_type_name` (`invest_type_name`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='投资类型字典'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_investment_type_dict
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_patent
-- ----------------------------
DROP TABLE IF EXISTS `company_patent`;
CREATE TABLE `company_patent` (
`patent_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`patent_uuid`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请(专利)号' ,
`patent_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专利名称' ,
`patent_type`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专利类型：发明，实用新型，外观设计图形' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`applicate_date`  date NOT NULL COMMENT '申请日' ,
`issuance_date`  date NULL DEFAULT NULL COMMENT '颁发日期' ,
`inventors`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发明人：多个之间用 逗号“，”隔开' ,
`patent_abstract`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摘要' ,
PRIMARY KEY (`patent_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `patent_uuid` (`patent_uuid`) USING BTREE ,
INDEX `company_id_patent` (`company_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='专利情况'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_patent
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_production
-- ----------------------------
DROP TABLE IF EXISTS `company_production`;
CREATE TABLE `company_production` (
`production_id`  bigint(20) NULL DEFAULT NULL COMMENT '产品/系列ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`production_type`  int(11) NULL DEFAULT NULL COMMENT '类型：1服务型，2实物型，3代工（受委托）' ,
`production_kind`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '2' COMMENT '类型：1 系列 2 产品' ,
`father_product`  bigint(20) NULL DEFAULT NULL COMMENT '上级产品->指向上级系列' ,
`production_year`  int(11) NULL DEFAULT NULL COMMENT '上线时间/' ,
`production_status`  int(11) NOT NULL DEFAULT 2 COMMENT '产品状态：1已经上线2正在研发' ,
`production_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称' ,
`production_report`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品报告（存储地址）' ,
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_product` (`company_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='企业产品'

;

-- ----------------------------
-- Records of company_production
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_report
-- ----------------------------
DROP TABLE IF EXISTS `company_report`;
CREATE TABLE `company_report` (
`incentive_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`year`  int(11) NOT NULL COMMENT '年' ,
`financial_statement`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '财务报表(存储文档地址)' ,
`stock_incentive`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '股权激励（存储文档地址）' ,
`salary_incentive`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '薪酬激励（存储文档地址）' ,
`strategic_plan`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '战略规划书(文档地址)' ,
`business_mode`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商业模式(存储文档地址)' ,
`production_management`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产管理（文档地址）' ,
`service_management`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务管理（文档地址）' ,
`quality_control`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '质量管理（文档地址）' ,
PRIMARY KEY (`incentive_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_incentive` (`company_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='企业报告书'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_report
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_staff
-- ----------------------------
DROP TABLE IF EXISTS `company_staff`;
CREATE TABLE `company_staff` (
`staff_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '人员ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '企业ID' ,
`staff_name`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '雇员姓名' ,
`education_background`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历' ,
`title`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称' ,
`staff_tellphone`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机' ,
`staff_role`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色(法人，股东，员工……）' ,
`staff_position_alias`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位（董事长，总经理，开发人员……）' ,
`staff_salary`  decimal(16,2) NOT NULL COMMENT '员工工资' ,
`social_security_base`  decimal(16,2) NOT NULL COMMENT '社保缴纳基数' ,
`social_security_amount`  decimal(16,2) NOT NULL COMMENT '社保缴纳额' ,
`staff_status`  int(11) NULL DEFAULT 1 COMMENT '是否在职：1 在职 2 离职 3 兼职' ,
`staff_status_alias`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否在职：1 在职 2 离职 3 兼职' ,
PRIMARY KEY (`staff_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_staff` (`company_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='企业人员（待完善）'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_staff
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_staff_senior_executive
-- ----------------------------
DROP TABLE IF EXISTS `company_staff_senior_executive`;
CREATE TABLE `company_staff_senior_executive` (
`senior_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '高管ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`staff_id`  bigint(20) NOT NULL COMMENT '人员ID' ,
`work_day`  int(11) NOT NULL DEFAULT 0 COMMENT '每周工作天数' ,
PRIMARY KEY (`senior_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_senior` (`company_id`) USING BTREE ,
INDEX `staff_id_senior` (`staff_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='公司高管名单'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_staff_senior_executive
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_staff_talent
-- ----------------------------
DROP TABLE IF EXISTS `company_staff_talent`;
CREATE TABLE `company_staff_talent` (
`talent_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`staff_id`  bigint(20) NOT NULL COMMENT '人员ID' ,
`telent_type`  int(11) NOT NULL COMMENT '人才引进类型' ,
`talent_type_alias`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '人才级别头衔' ,
`comment`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
PRIMARY KEY (`talent_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`talent_type_alias`) REFERENCES `talent_dict` (`telent_title`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`telent_type`) REFERENCES `talent_dict` (`telent_type`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_talent` (`company_id`) USING BTREE ,
INDEX `staff_id_talent` (`staff_id`) USING BTREE ,
INDEX `telent_type` (`telent_type`) USING BTREE ,
INDEX `talent_type_alias` (`talent_type_alias`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='公司人才引进情况'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_staff_talent
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_staff_team_finance
-- ----------------------------
DROP TABLE IF EXISTS `company_staff_team_finance`;
CREATE TABLE `company_staff_team_finance` (
`fincance_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`staff_id`  bigint(20) NOT NULL COMMENT '人员ID' ,
PRIMARY KEY (`fincance_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_finance` (`company_id`) USING BTREE ,
INDEX `staff_id_finance` (`staff_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='财务团队人员'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_staff_team_finance
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_staff_team_manager
-- ----------------------------
DROP TABLE IF EXISTS `company_staff_team_manager`;
CREATE TABLE `company_staff_team_manager` (
`mananger_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`staff_id`  bigint(20) NOT NULL COMMENT '人员ID' ,
PRIMARY KEY (`mananger_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_manager` (`company_id`) USING BTREE ,
INDEX `staff_id_manager` (`staff_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='管理团队人员'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_staff_team_manager
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_staff_team_saler
-- ----------------------------
DROP TABLE IF EXISTS `company_staff_team_saler`;
CREATE TABLE `company_staff_team_saler` (
`saler_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`staff_id`  bigint(20) NOT NULL COMMENT '人员ID' ,
PRIMARY KEY (`saler_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_saler` (`company_id`) USING BTREE ,
INDEX `staff_id_saler` (`staff_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='营销市场人员'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_staff_team_saler
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_staff_team_tech
-- ----------------------------
DROP TABLE IF EXISTS `company_staff_team_tech`;
CREATE TABLE `company_staff_team_tech` (
`tech_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`staff_id`  bigint(20) NOT NULL COMMENT '人员ID' ,
PRIMARY KEY (`tech_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_team_tech` (`company_id`) USING BTREE ,
INDEX `staff_id_tech` (`staff_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='技术人员'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_staff_team_tech
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_stage
-- ----------------------------
DROP TABLE IF EXISTS `company_stage`;
CREATE TABLE `company_stage` (
`cs_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`change_date`  date NULL DEFAULT NULL COMMENT '更改时间' ,
`campany_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`stage_id`  bigint(20) NOT NULL COMMENT '所处阶段ID' ,
`stage_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所处阶段名字' ,
PRIMARY KEY (`cs_id`),
FOREIGN KEY (`campany_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`stage_id`) REFERENCES `company_stage_dict` (`stage_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`stage_name`) REFERENCES `company_stage_dict` (`stage_name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_stage_name` (`stage_name`) USING BTREE ,
INDEX `company_stage_id` (`stage_id`) USING BTREE ,
INDEX `company_id_stage` (`campany_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='企业所处发展阶段'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_stage
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_stage_dict
-- ----------------------------
DROP TABLE IF EXISTS `company_stage_dict`;
CREATE TABLE `company_stage_dict` (
`stage_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`stage_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名字' ,
`comment`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
PRIMARY KEY (`stage_id`),
UNIQUE INDEX `stage_name` (`stage_name`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='企业生命周期字典'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_stage_dict
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_sub_org
-- ----------------------------
DROP TABLE IF EXISTS `company_sub_org`;
CREATE TABLE `company_sub_org` (
`org_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '子机构ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`org_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '子机构名称' ,
`org_type`  bigint(20) NOT NULL COMMENT '机构类型：1：子公司2：工程中心3：博士后流动站4:政府资助实验室' ,
`founding_time`  date NOT NULL COMMENT '成立时间' ,
`address`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址' ,
`comment`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注' ,
`org_refer`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '子机构文档（上传地址）' ,
PRIMARY KEY (`org_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`org_type`) REFERENCES `company_sub_org_dict` (`org_type`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_sub_org` (`company_id`) USING BTREE ,
INDEX `org_type` (`org_type`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='公司子机构'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_sub_org
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_sub_org_dict
-- ----------------------------
DROP TABLE IF EXISTS `company_sub_org_dict`;
CREATE TABLE `company_sub_org_dict` (
`oc_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`org_type`  bigint(20) NOT NULL COMMENT '机构类型' ,
`org_type_alias`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型名称' ,
`commet`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注' ,
PRIMARY KEY (`oc_id`),
UNIQUE INDEX `org_type` (`org_type`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_sub_org_dict
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_tax
-- ----------------------------
DROP TABLE IF EXISTS `company_tax`;
CREATE TABLE `company_tax` (
`tax_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`biz_tax`  int(11) NOT NULL COMMENT '营业税' ,
`add_value_tax`  int(11) NOT NULL COMMENT '增值税' ,
`ndividual_income_tax`  int(11) NOT NULL COMMENT '个人所得税' ,
`enterprise_income_tax`  int(11) NOT NULL COMMENT '企业所得税' ,
`year`  int(11) NOT NULL COMMENT '年' ,
`rank_year`  int(11) NOT NULL COMMENT '会计年报年度' ,
PRIMARY KEY (`tax_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_tax` (`company_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_tax
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for company_tech_project
-- ----------------------------
DROP TABLE IF EXISTS `company_tech_project`;
CREATE TABLE `company_tech_project` (
`project_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`project_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名字' ,
`project_level`  int(11) NOT NULL DEFAULT 1 COMMENT '项目级别：1：区县 2：市 3：省 4 国家级' ,
`project_report`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '立项报告（文档路径）' ,
`begin_year`  date NULL DEFAULT NULL COMMENT '项目开始的时间' ,
`comment`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
PRIMARY KEY (`project_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_project` (`company_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='企业科技立项'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of company_tech_project
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for finger_dict
-- ----------------------------
DROP TABLE IF EXISTS `finger_dict`;
CREATE TABLE `finger_dict` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '指标id-名称对应字典' ,
`finger_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指标名称' ,
`comment`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='指标字典'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of finger_dict
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for finger_result_v0
-- ----------------------------
DROP TABLE IF EXISTS `finger_result_v0`;
CREATE TABLE `finger_result_v0` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`company_id`  bigint(20) NOT NULL ,
`company_name`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司名字' ,
`company_plate`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司所属的板块' ,
`denominator_type`  varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'mean' COMMENT '分母类型：mean平均值，max最大值，min最小值，极差值range' ,
`year`  int(11) NOT NULL ,
`period_type`  varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'Y' COMMENT 'Y整年 Q1 一季度 Q2 二季度 Q3三季度 Q4四季度' ,
`finger_all`  double NULL DEFAULT NULL COMMENT '综合指数' ,
`finger_sale`  double NULL DEFAULT NULL COMMENT '一级指标：销售指数' ,
`finger_sale_invoice`  double NULL DEFAULT NULL COMMENT '二级指标：已开票的收入' ,
`finger_sale_invoice_soft`  double NULL DEFAULT NULL COMMENT '已开发票的收入-软件产品' ,
`finger_sale_invoice_hard`  double NULL DEFAULT NULL COMMENT '已开发票的收入-硬件产品' ,
`finger_sale_invoice_consultation`  double NULL DEFAULT NULL COMMENT '已开发票的收入-咨询服务' ,
`finger_sale_invoice_other`  double NULL DEFAULT NULL COMMENT '已开发票的收入-其他' ,
`finger_sale_contract`  double NULL DEFAULT NULL COMMENT '二级指标：合同确认额' ,
`finger_sale_contract_soft`  double NULL DEFAULT NULL COMMENT '三级指标：合同确认额-软件产品' ,
`finger_sale_contract_hard`  double NULL DEFAULT NULL COMMENT '三级指标：合同确认额-硬件产品' ,
`finger_sale_contract_consultation`  double NULL DEFAULT NULL COMMENT '三级指标：合同确认额-咨询服务' ,
`finger_sale_contract_other`  double NULL DEFAULT NULL COMMENT '三级指标：合同确认额-其他' ,
`finger_tax`  double NULL DEFAULT NULL COMMENT '一级指标：纳税指数' ,
`finger_tax_corporate`  double NULL DEFAULT NULL COMMENT '二级指标：企业所得税' ,
`finger_tax_corporate_taxable`  double NULL DEFAULT NULL COMMENT '三级指标：企业所得税-应纳税值' ,
`finger_tax_corporate_relief`  double NULL DEFAULT NULL COMMENT '三级指标：企业所得税-税收减免值' ,
`finger_tax_individual`  double NULL DEFAULT NULL COMMENT '二级指标：个人所得税' ,
`finger_tax_individual_taxable`  double NULL DEFAULT NULL COMMENT '三级指标：个人所得税-应纳税值' ,
`finger_tax_individual_relief`  double NULL DEFAULT NULL COMMENT '三级指标：个人所得税-税收减免' ,
`finger_tax_added`  double NULL DEFAULT NULL COMMENT '二级指标：增值税' ,
`finger_tax_added_taxable`  double NULL DEFAULT NULL COMMENT '三级指标：增值税-应纳税值' ,
`finger_tax_added_relief`  double NULL DEFAULT NULL COMMENT '三级指标：增值税-税收减免' ,
`finger_finance`  double NULL DEFAULT NULL COMMENT '一级指标：融资指数' ,
`finger_finance_stock`  double NULL DEFAULT NULL COMMENT '二级指标：股权类融资' ,
`finger_finance_stock_risk`  double NULL DEFAULT NULL COMMENT '三级指标：股权类融资-风投机构' ,
`finger_finance_stock_gov`  double NULL DEFAULT NULL COMMENT '三级指标：股权类融资-政府企业' ,
`finger_finance_stock_person`  double NULL DEFAULT NULL COMMENT '三级指标：股权类融资-个人' ,
`finger_finance_debt`  double NULL DEFAULT NULL COMMENT '二级指标：债务类融资' ,
`finger_finance_debt_bank`  double NULL DEFAULT NULL COMMENT '三级指标：债务类融资-银行' ,
`finger_finance_debt_new`  double NULL DEFAULT NULL COMMENT '三级指标：债务类融资-新型贷款机构' ,
`finger_finance_debt_lending`  double NULL DEFAULT NULL COMMENT '三级指标：债务类融资-企业拆借' ,
`finger_finance_debt_person`  double NULL DEFAULT NULL COMMENT '三级指标：债务类融资-个人' ,
`finger_valuation`  double NULL DEFAULT NULL COMMENT '一级指标:估值指数' ,
`finger_valuation_assets`  double NULL DEFAULT NULL COMMENT '二级指标：净资产' ,
`finger_valuation_assets_circulating`  double NULL DEFAULT NULL COMMENT '三级指标：净资产-流动资产' ,
`finger_valuation_assets_uncirculating`  double NULL DEFAULT NULL COMMENT '三级指标：净资产-非流动资产' ,
`finger_valuation_assets_debt_circulating`  double NULL DEFAULT NULL COMMENT '三级指标：净资产-流动负债' ,
`finger_valuation_assets_debt_uncirculating`  double NULL DEFAULT NULL COMMENT '三级指标：净资产-非流动负债' ,
`finger_valuation_actual`  double NULL DEFAULT NULL COMMENT '二级指标：实际估值' ,
`finger_valuation_actual_first`  double NULL DEFAULT NULL COMMENT '三级指标：实际估值-首次融资' ,
`finger_valuation_actual_latest`  double NULL DEFAULT NULL COMMENT '三级指标：实际估值-最近一次融资估值' ,
`finger_valuation_actual_want`  double NULL DEFAULT NULL COMMENT '三级指标：实际估值-现在准备融资估值' ,
`finger_hr`  double NULL DEFAULT NULL COMMENT '一级指标：人力资源指数' ,
`finger_hr_partime`  double NULL DEFAULT NULL COMMENT '二级指标：兼职员工数' ,
`finger_hr_partime_dev`  double NULL DEFAULT NULL COMMENT '三级指标：兼职员工-研发' ,
`finger_hr_partime_manage`  double NULL DEFAULT NULL COMMENT '三级指标：兼职员工-管理' ,
`finger_hr_partime_admin`  double NULL DEFAULT NULL COMMENT '三级指标：兼职员工-行政' ,
`finger_hr_partime_saler`  double NULL DEFAULT NULL COMMENT '三级指标：兼职员工-销售' ,
`finger_hr_fulltime`  double NULL DEFAULT NULL COMMENT '二级指标：全职员工' ,
`finger_hr_fulltime_dev`  double NULL DEFAULT NULL COMMENT '三级指标：全职员工-研发' ,
`finger_hr_fulltime_senior`  double NULL DEFAULT NULL COMMENT '三级指标：全职员工-高管' ,
`finger_hr_fulltime_admin`  double NULL DEFAULT NULL COMMENT '三级指标：全职员工-行政' ,
`finger_hr_fulltime_saler`  double NULL DEFAULT NULL COMMENT '三级指标：全职员工-销售' ,
`finger_hr_educated`  double NULL DEFAULT NULL COMMENT '二级指标：高学历人员' ,
`finger_hr_educated_doc`  double NULL DEFAULT NULL COMMENT '三级指标：高学历人员-博士' ,
`finger_hr_educated_master`  double NULL DEFAULT NULL COMMENT '三级指标：高学历人员-硕士' ,
`finger_hr_bachelor`  double NULL DEFAULT NULL COMMENT '三级指标：高学历人员-学士' ,
`finger_innovate`  double NULL DEFAULT NULL COMMENT '一级指标：创新指数' ,
`finger_innovate_patent_apply`  double NULL DEFAULT NULL COMMENT '二级指标：专利申请' ,
`finger_innovate_patent_apply_invention`  double NULL DEFAULT NULL COMMENT '三级指标：专利申请-发明' ,
`finger_innovate_patent_apply_utility`  double NULL DEFAULT NULL COMMENT '三级指标：专利申请-实用新型' ,
`finger_innovate_patent_apply_appear`  double NULL DEFAULT NULL COMMENT '三级指标：专利申请-外观设计' ,
`finger_innovate_patent_grant`  double NULL DEFAULT NULL COMMENT '二级指标：专利授权' ,
`finger_innovate_patent_grant_invention`  double NULL DEFAULT NULL COMMENT '三级指标：专利授权-发明' ,
`finger_innovate_patent_grant_utility`  double NULL DEFAULT NULL COMMENT '三级指标：专利授权-实用新型' ,
`finger_innovate_patent_grant_appear`  double NULL DEFAULT NULL COMMENT '三级指标：专利授权-外观设计' ,
`finger_innovate_copyright_apply`  double NULL DEFAULT NULL COMMENT '二级指标：著作权申请' ,
`finger_innovate_copyright_apply_soft`  double NULL DEFAULT NULL COMMENT '三级指标：著作权申请-软件类' ,
`finger_innovate_copyright_apply_unsoft`  double NULL DEFAULT NULL COMMENT '三级指标：著作权申请-非软件类' ,
`finger_innovate_copyright_grant`  double NULL DEFAULT NULL COMMENT '二级指标：著作权授权' ,
`finger_innovate_copyright_grant_soft`  double NULL DEFAULT NULL COMMENT '三级指标：著作权授权-软件类' ,
`finger_innovate_copyright_grant_unsoft`  double NULL DEFAULT NULL COMMENT '三级指标：著作权授权-非软件类' ,
`finger_innovate_new_product`  double NULL DEFAULT NULL COMMENT '二级指标：新产品/服务' ,
`finger_innovate_new_product_patent`  double NULL DEFAULT NULL COMMENT '三级指标：新产品/服务-专利类' ,
`finger_innovate_new_product_tech`  double NULL DEFAULT NULL COMMENT '三级指标：新产品/服务-专用技术' ,
`finger_innovate_new_product_bus`  double NULL DEFAULT NULL COMMENT '三级指标：新产品/服务-商业模式' ,
`finger_salary`  double NULL DEFAULT NULL COMMENT '一级指标：薪酬指数' ,
`finger_salary_staff`  double NULL DEFAULT NULL COMMENT '二级指标：员工工资额' ,
`finger_salary_staff_up_10`  double NULL DEFAULT NULL COMMENT '三级指标：员工工资额-1万元以上' ,
`finger_salary_staff_5_10`  double NULL DEFAULT NULL COMMENT '三级指标：员工工资额-5千到1万' ,
`finger_salary_staff_down_5`  double NULL DEFAULT NULL COMMENT '三级指标：员工工资额-5千以下' ,
`finger_salary_staff_contribution`  double NULL DEFAULT NULL COMMENT '二级指标：员工贡献率' ,
`finger_salary_staff_contribution_meansale`  double NULL DEFAULT NULL COMMENT '三级指标：员工贡献率-人均销售' ,
`finger_salary_staff_contribution_meantax`  double NULL DEFAULT NULL COMMENT '三级指标：员工贡献率-人均纳税' ,
`finger_learn`  double NULL DEFAULT NULL COMMENT '一级指标：学习指数' ,
`finger_learn_train`  double NULL DEFAULT NULL COMMENT '二级指标：参加培训的次数' ,
`finger_learn_train_manage`  double NULL DEFAULT NULL COMMENT '三级指标：参加培训的次数-管理类' ,
`finger_learn_train_policy`  double NULL DEFAULT NULL COMMENT '三级指标：参加培训的次数-政策法规' ,
`finger_learn_train_skill`  double NULL DEFAULT NULL COMMENT '三级指标：参加培训的次数-技能类' ,
`finger_learn_conslted`  double NULL DEFAULT NULL COMMENT '二级指标：接受咨询的次数' ,
`finger_learn_conslted_manage`  double NULL DEFAULT NULL COMMENT '三级指标：接受咨询的次数-管理类' ,
`finger_learn_conslted_policy`  double NULL DEFAULT NULL COMMENT '三级指标：接受咨询的次数-政策法规' ,
`finger_learn_conslted_skill`  double NULL DEFAULT NULL COMMENT '三级指标：接受咨询的次数-技能类' ,
`finger_brand`  double NULL DEFAULT NULL COMMENT '一级指标：品牌指数' ,
`finger_brand_reward`  double NULL DEFAULT NULL COMMENT '二级指标：企业获奖' ,
`finger_brand_reward_area`  double NULL DEFAULT NULL COMMENT '三级指标：企业获奖-区级' ,
`finger_brand_reward_city`  double NULL DEFAULT NULL COMMENT '三级指标：企业获奖-市级' ,
`finger_brand_reward_province`  double NULL DEFAULT NULL COMMENT '三级指标：企业获奖-省级' ,
`finger_brand_reward_country`  double NULL DEFAULT NULL COMMENT '三级指标：企业获奖-国家级' ,
`finger_brand_recognition`  double NULL DEFAULT NULL COMMENT '二级指标：企业认定' ,
`finger_brand_recognition_area`  double NULL DEFAULT NULL COMMENT '三级指标：企业认定-区级' ,
`finger_brand_recognition_city`  double NULL DEFAULT NULL COMMENT '三级指标：企业认定-市级' ,
`finger_brand_recognition_province`  double NULL DEFAULT NULL COMMENT '三级指标：企业认定-省级' ,
`finger_brand_recognition_country`  double NULL DEFAULT NULL COMMENT '三级指标：企业认定-国家级' ,
`finger_brand_talent`  double NULL DEFAULT NULL COMMENT '二级指标：人才资助' ,
`finger_brand_talent_area`  double NULL DEFAULT NULL COMMENT '三级指标：人才资助-区级' ,
`finger_brand_talent_city`  double NULL DEFAULT NULL COMMENT '三级指标：人才资助-市级' ,
`finger_brand_talent_province`  double NULL DEFAULT NULL COMMENT '三级指标：人才资助-省级' ,
`finger_brand_talent_country`  double NULL DEFAULT NULL COMMENT '三级指标：人才资助-国家级' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='写死的表结构'
AUTO_INCREMENT=3

;

-- ----------------------------
-- Records of finger_result_v0
-- ----------------------------
BEGIN;
INSERT INTO `finger_result_v0` VALUES ('1', '1', 'hah', 'A', 'mean', '2018', 'Y', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('2', '2', 'hah', 'A', 'mean', '2018', 'Y', '12', '12', '12', '12', '12', '12', '12', '12', '12', '12', '12', '12', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
-- Table structure for finger_template
-- ----------------------------
DROP TABLE IF EXISTS `finger_template`;
CREATE TABLE `finger_template` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID' ,
`finger_id`  bigint(20) NOT NULL COMMENT '指标id' ,
`finger_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指标名称' ,
`parent_id`  bigint(20) NOT NULL COMMENT '父节点' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of finger_template
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for finger_v1
-- ----------------------------
DROP TABLE IF EXISTS `finger_v1`;
CREATE TABLE `finger_v1` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'main key' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`year`  int(11) NOT NULL COMMENT '年份' ,
`period_type`  varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指标时间类型：默认 Y全年 M1一月 M2二月 Q1第一季度 Q2 第二季度' ,
`finger_name_id`  bigint(20) NOT NULL COMMENT '自定义的指标id' ,
`finger_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指标名称' ,
`finger_value`  double NOT NULL COMMENT '指标值' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='基础指标版本 v1'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of finger_v1
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for industry_dict
-- ----------------------------
DROP TABLE IF EXISTS `industry_dict`;
CREATE TABLE `industry_dict` (
`industry_id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`industry_name`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '行业命名' ,
PRIMARY KEY (`industry_id`),
UNIQUE INDEX `industry_name` (`industry_name`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='所属行业——行业分类字典'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of industry_dict
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for shareholder
-- ----------------------------
DROP TABLE IF EXISTS `shareholder`;
CREATE TABLE `shareholder` (
`shareholder_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`company_id`  bigint(20) NOT NULL COMMENT '公司ID' ,
`staff_id`  bigint(20) NOT NULL COMMENT '人员ID' ,
`staff_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '股东姓名' ,
`proportion`  int(11) NOT NULL COMMENT '股份占比' ,
PRIMARY KEY (`shareholder_id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`staff_id`) REFERENCES `company_staff` (`staff_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id_share` (`company_id`) USING BTREE ,
INDEX `staff_id` (`staff_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='股东信息'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of shareholder
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for talent_dict
-- ----------------------------
DROP TABLE IF EXISTS `talent_dict`;
CREATE TABLE `talent_dict` (
`telent_type_dict`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`telent_type`  int(11) NOT NULL COMMENT '类型' ,
`telent_title`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型名字' ,
`commet`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
PRIMARY KEY (`telent_type_dict`),
UNIQUE INDEX `telent_type` (`telent_type`) USING BTREE ,
INDEX `telent_title` (`telent_title`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='国家人才引进计划字典'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of talent_dict
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`user_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID' ,
`user_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名' ,
`user_phone`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号' ,
`role_id`  bigint(20) NULL DEFAULT 99 COMMENT '角色ID' ,
`user_avatar`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像' ,
PRIMARY KEY (`user_id`),
FOREIGN KEY (`role_id`) REFERENCES `user_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `user_phone` (`user_phone`) USING BTREE ,
INDEX `role_id` (`role_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户信息'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_auth
-- ----------------------------
DROP TABLE IF EXISTS `user_auth`;
CREATE TABLE `user_auth` (
`auth_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一ID' ,
`user_id`  bigint(20) NOT NULL COMMENT '用户ID' ,
`identity_type`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录类型（账号密码，手机，微信微博）' ,
`identity_type_id`  bigint(20) NOT NULL COMMENT '登录类型的ID，看用哪个吧' ,
`identifier`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号，不管什么登录类型总有账号' ,
`credential`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '不管什么，总有密码吧' ,
PRIMARY KEY (`auth_id`),
FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `user_id` (`user_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='username/phone+password or 第三方user+token 都是基础信息表加上用户授权信息的形式'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of user_auth
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
`role_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID' ,
`role_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色命名' ,
`role_level`  int(11) NULL DEFAULT NULL COMMENT '角色级别' ,
`level_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '级别命名' ,
PRIMARY KEY (`role_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户角色定义'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_tk
-- ----------------------------
DROP TABLE IF EXISTS `user_tk`;
CREATE TABLE `user_tk` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`pwd`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`userid`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=19

;

-- ----------------------------
-- Records of user_tk
-- ----------------------------
BEGIN;
INSERT INTO `user_tk` VALUES ('1', '22b2efb8019e52d677649b779241466d', '123456789'), ('2', '22b2efb8019e52d677649b779241466d', '123456789'), ('3', '22b2efb8019e52d677649b779241466d', '123456789'), ('4', '22b2efb8019e52d677649b779241466d', '123456789'), ('5', '22b2efb8019e52d677649b779241466d', '123456789'), ('6', '22b2efb8019e52d677649b779241466d', '123456789'), ('7', '22b2efb8019e52d677649b779241466d', '123456789'), ('8', '22b2efb8019e52d677649b779241466d', '123456789'), ('9', '22b2efb8019e52d677649b779241466d', '123456789'), ('10', '22b2efb8019e52d677649b779241466d', '123456789'), ('11', '22b2efb8019e52d677649b779241466d', '123456789'), ('12', '22b2efb8019e52d677649b779241466d', '123456789'), ('13', '22b2efb8019e52d677649b779241466d', '123456789'), ('14', '22b2efb8019e52d677649b779241466d', '123456789'), ('15', '22b2efb8019e52d677649b779241466d', '1234567890'), ('16', '22b2efb8019e52d677649b779241466d', '1234567890'), ('17', '22b2efb8019e52d677649b779241466d', '1234567890'), ('18', '22b2efb8019e52d677649b779241466d', '1234567890');
COMMIT;

-- ----------------------------
-- Auto increment value for business_scope
-- ----------------------------
ALTER TABLE `business_scope` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for business_scope_dict
-- ----------------------------
ALTER TABLE `business_scope_dict` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company
-- ----------------------------
ALTER TABLE `company` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_asset
-- ----------------------------
ALTER TABLE `company_asset` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_business
-- ----------------------------
ALTER TABLE `company_business` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_honor
-- ----------------------------
ALTER TABLE `company_honor` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_input
-- ----------------------------
ALTER TABLE `company_input` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for company_investment
-- ----------------------------
ALTER TABLE `company_investment` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_investment_type_dict
-- ----------------------------
ALTER TABLE `company_investment_type_dict` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_patent
-- ----------------------------
ALTER TABLE `company_patent` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_report
-- ----------------------------
ALTER TABLE `company_report` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_staff
-- ----------------------------
ALTER TABLE `company_staff` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_staff_senior_executive
-- ----------------------------
ALTER TABLE `company_staff_senior_executive` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_staff_talent
-- ----------------------------
ALTER TABLE `company_staff_talent` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_staff_team_finance
-- ----------------------------
ALTER TABLE `company_staff_team_finance` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_staff_team_manager
-- ----------------------------
ALTER TABLE `company_staff_team_manager` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_staff_team_saler
-- ----------------------------
ALTER TABLE `company_staff_team_saler` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_staff_team_tech
-- ----------------------------
ALTER TABLE `company_staff_team_tech` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_stage
-- ----------------------------
ALTER TABLE `company_stage` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_stage_dict
-- ----------------------------
ALTER TABLE `company_stage_dict` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_sub_org
-- ----------------------------
ALTER TABLE `company_sub_org` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_sub_org_dict
-- ----------------------------
ALTER TABLE `company_sub_org_dict` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_tax
-- ----------------------------
ALTER TABLE `company_tax` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for company_tech_project
-- ----------------------------
ALTER TABLE `company_tech_project` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for finger_dict
-- ----------------------------
ALTER TABLE `finger_dict` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for finger_result_v0
-- ----------------------------
ALTER TABLE `finger_result_v0` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for finger_template
-- ----------------------------
ALTER TABLE `finger_template` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for finger_v1
-- ----------------------------
ALTER TABLE `finger_v1` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for industry_dict
-- ----------------------------
ALTER TABLE `industry_dict` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for shareholder
-- ----------------------------
ALTER TABLE `shareholder` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for talent_dict
-- ----------------------------
ALTER TABLE `talent_dict` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for user
-- ----------------------------
ALTER TABLE `user` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for user_auth
-- ----------------------------
ALTER TABLE `user_auth` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for user_role
-- ----------------------------
ALTER TABLE `user_role` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for user_tk
-- ----------------------------
ALTER TABLE `user_tk` AUTO_INCREMENT=19;
