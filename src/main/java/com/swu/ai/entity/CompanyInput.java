package com.swu.ai.entity;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Table(name = "company_input")
public class CompanyInput {
    @Id
    private Long id;

    /**
     * 公司名称
     */
    private String companyname;

    /**
     * 年
     */
    private Integer year;

    /**
     * 季度
     */
    private Integer quarter;

    /**
     * 开票软件收入
     */
    private Double ticketincomesoftware = new Double(0);

    /**
     * 开票硬件收入
     */
    private Double ticketincomehardware = new Double(0);

    /**
     * 开票咨询收入
     */
    private Double ticketincomeconsult = new Double(0);

    /**
     * 开票其他收入
     */
    private Double ticketincomeother = new Double(0);

    /**
     * 合同软件收入
     */
    private Double contractincomesoftware = new Double(0);

    /**
     * 合同硬件收入
     */
    private Double contractincomehardware = new Double(0);

    /**
     * 合同咨询收入
     */
    private Double contractincomeconsult = new Double(0);

    /**
     * 合同其他收入
     */
    private Double contractincomeother = new Double(0);

    /**
     * 所得税
     */
    private Double incometaxable = new Double(0);

    /**
     * 所得税减免
     */
    private Double incometaxdeduction = new Double(0);

    /**
     * 个人所得税
     */
    private Double pensonaltaxable = new Double(0);

    /**
     * 个人所得税减免
     */
    private Double pensonaltaxdecution = new Double(0);

    /**
     * 附加税
     */
    private Double addvaluetaxable = new Double(0);

    /**
     * 附加税减免
     */
    private Double addvaluetaxdecution = new Double(0);

    /**
     * 股权风投
     */
    private Double stockfinancevc = new Double(0);

    /**
     * 股权政府企业
     */
    private Double stockfinancegovenment = new Double(0);

    /**
     * 股权个人
     */
    private Double stockfinancepensonal = new Double(0);

    /**
     * 债务银行
     */
    private Double debtfinancebank = new Double(0);

    /**
     * 债务新型借贷机构
     */
    private Double debtfinanceli = new Double(0);

    /**
     * 债务公司拆解
     */
    private Double debtfinancecompany = new Double(0);

    /**
     * z债务个人
     */
    private Double debtfinancepensonal = new Double(0);

    /**
     * l流动资产
     */
    private Double currentasset = new Double(0);

    /**
     * f非流动资产
     */
    private Double nocurrentasset = new Double(0);

    /**
     * l流动借债
     */
    private Double currentdebt = new Double(0);

    /**
     * f非流动借债
     */
    private Double nocurrentdebt = new Double(0);

    /**
     * s首次融资估值
     */
    private Double firstfinancevalue = new Double(0);

    /**
     * z最后一次融资估值
     */
    private Double lastfinancevalue = new Double(0);

    /**
     * x现在融资估值
     */
    private Double currentfinancevalue = new Double(0);

    /**
     * 兼职研发
     */
    private Integer parttimedevelopment = new Integer(0);

    /**
     * j兼职管理
     */
    private Integer parttimemanager = new Integer(0);

    /**
     * j兼职行政
     */
    private Integer parttimeadmin = new Integer(0);

    /**
     * j兼职销售
     */
    private Integer parttimesell = new Integer(0);

    /**
     * k开发人数
     */
    private Integer development = new Integer(0);

    /**
     * g管理人数
     */
    private Integer manamger = new Integer(0);

    /**
     * g行政人数
     */
    private Integer administrator = new Integer(0);

    /**
     * x销售人数
     */
    private Integer sell = new Integer(0);

    /**
     * 博士人数
     */
    private Integer doctor = new Integer(0);

    /**
     * 硕士人数
     */
    private Integer master = new Integer(0);

    /**
     * 学士人数
     */
    private Integer bachelor = new Integer(0);

    /**
     * 申请专利 发明
     */
    private Integer applypatentinvent = new Integer(0);

    /**
     * 申请专利 实业
     */
    private Integer applypatentindustry = new Integer(0);

    /**
     * 申请专利 设计
     */
    private Integer applypatentdesign = new Integer(0);

    /**
     * 获取专利 研发
     */
    private Integer patentinvent = new Integer(0);

    /**
     * 获取专利 实业
     */
    private Integer patentindustry = new Integer(0);

    /**
     * 获取专利 设计
     */
    private Integer patentdesign = new Integer(0);

    /**
     * 申请著作权 软件
     */
    private Integer applyauthorsoftware = new Integer(0);

    /**
     * 申请著作权 非软件
     */
    private Integer applyauthorother = new Integer(0);

    /**
     * 著作权 软件
     */
    private Integer authorsoftware = new Integer(0);

    /**
     * 著作权 非软件
     */
    private Integer authorother = new Integer(0);

    /**
     * 新产品服务数 专利类
     */
    private Integer servicepatent = new Integer(0);

    /**
     * 新产品服务数 专用技术
     */
    private Integer serviceskill = new Integer(0);

    /**
     * 新产品服务数 商业模式
     */
    private Integer servicesell = new Integer(0);

    /**
     * >10000工资总数
     */
    private Double salaryhigh = new Double(0);

    /**
     * 5000-10000工资总数
     */
    private Double salarymiddle = new Double(0);

    /**
     * <5000工资总和
     */
    private Double salarylow = new Double(0);

    /**
     * 人均销售
     */
    private Double persell = new Double(0);

    /**
     * 人均纳税
     */
    private Double pertax = new Double(0);

    /**
     * 参加训练次数 管理
     */
    private Integer trainmanage = new Integer(0);

    /**
     * 参加训练次数 法规
     */
    private Integer trainlegal = new Integer(0);

    /**
     * 参加训练次数 技能
     */
    private Integer trainskill = new Integer(0);

    /**
     * 参与咨询次数 管理
     */
    private Integer consultmanage = new Integer(0);

    /**
     * 参与咨询次数 法规
     */
    private Integer consultlegal = new Integer(0);

    /**
     * 参与咨询次数 技能
     */
    private Integer consultskill = new Integer(0);

    /**
     * 获奖次数 区级
     */
    private Integer awarddistrict = new Integer(0);

    /**
     * 获奖次数 市级
     */
    private Integer awardcity = new Integer(0);

    /**
     * 获奖次数 省级
     */
    private Integer awardprovince = new Integer(0);

    /**
     * 获奖次数 国家级
     */
    private Integer awardnation = new Integer(0);

    /**
     * 认定次数 区级
     */
    private Integer comfirmdistrict = new Integer(0);

    /**
     * 认定次数 市级
     */
    private Integer comfirmcity = new Integer(0);

    /**
     * 认定次数 省级
     */
    private Integer comfirmprovince = new Integer(0);

    /**
     * 认定次数 国家级
     */
    private Integer comfirmnation = new Integer(0);

    /**
     * 人才资助 区级
     */
    private Integer supportdistrict = new Integer(0);

    /**
     * 人才资助 市级
     */
    private Integer supportcity = new Integer(0);

    /**
     * 人才资助 省级
     */
    private Integer supportprovince = new Integer(0);

    /**
     * 人才资助 国家级
     */
    private Integer supportnation = new Integer(0);

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
     * 获取公司名称
     *
     * @return companyname - 公司名称
     */
    public String getCompanyname() {
        return companyname;
    }

    /**
     * 设置公司名称
     *
     * @param companyname 公司名称
     */
    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    /**
     * 获取年
     *
     * @return year - 年
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年
     *
     * @param year 年
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取季度
     *
     * @return quarter - 季度
     */
    public Integer getQuarter() {
        return quarter;
    }

    /**
     * 设置季度
     *
     * @param quarter 季度
     */
    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    /**
     * 获取开票软件收入
     *
     * @return ticketincomesoftware - 开票软件收入
     */
    public Double getTicketincomesoftware() {
        return ticketincomesoftware;
    }

    /**
     * 设置开票软件收入
     *
     * @param ticketincomesoftware 开票软件收入
     */
    public void setTicketincomesoftware(Double ticketincomesoftware) {
        this.ticketincomesoftware = ticketincomesoftware;
    }

    /**
     * 获取开票硬件收入
     *
     * @return ticketincomehardware - 开票硬件收入
     */
    public Double getTicketincomehardware() {
        return ticketincomehardware;
    }

    /**
     * 设置开票硬件收入
     *
     * @param ticketincomehardware 开票硬件收入
     */
    public void setTicketincomehardware(Double ticketincomehardware) {
        this.ticketincomehardware = ticketincomehardware;
    }

    /**
     * 获取开票咨询收入
     *
     * @return ticketincomeconsult - 开票咨询收入
     */
    public Double getTicketincomeconsult() {
        return ticketincomeconsult;
    }

    /**
     * 设置开票咨询收入
     *
     * @param ticketincomeconsult 开票咨询收入
     */
    public void setTicketincomeconsult(Double ticketincomeconsult) {
        this.ticketincomeconsult = ticketincomeconsult;
    }

    /**
     * 获取开票其他收入
     *
     * @return ticketincomeother - 开票其他收入
     */
    public Double getTicketincomeother() {
        return ticketincomeother;
    }

    /**
     * 设置开票其他收入
     *
     * @param ticketincomeother 开票其他收入
     */
    public void setTicketincomeother(Double ticketincomeother) {
        this.ticketincomeother = ticketincomeother;
    }

    /**
     * 获取合同软件收入
     *
     * @return contractincomesoftware - 合同软件收入
     */
    public Double getContractincomesoftware() {
        return contractincomesoftware;
    }

    /**
     * 设置合同软件收入
     *
     * @param contractincomesoftware 合同软件收入
     */
    public void setContractincomesoftware(Double contractincomesoftware) {
        this.contractincomesoftware = contractincomesoftware;
    }

    /**
     * 获取合同硬件收入
     *
     * @return contractincomehardware - 合同硬件收入
     */
    public Double getContractincomehardware() {
        return contractincomehardware;
    }

    /**
     * 设置合同硬件收入
     *
     * @param contractincomehardware 合同硬件收入
     */
    public void setContractincomehardware(Double contractincomehardware) {
        this.contractincomehardware = contractincomehardware;
    }

    /**
     * 获取合同咨询收入
     *
     * @return contractincomeconsult - 合同咨询收入
     */
    public Double getContractincomeconsult() {
        return contractincomeconsult;
    }

    /**
     * 设置合同咨询收入
     *
     * @param contractincomeconsult 合同咨询收入
     */
    public void setContractincomeconsult(Double contractincomeconsult) {
        this.contractincomeconsult = contractincomeconsult;
    }

    /**
     * 获取合同其他收入
     *
     * @return contractincomeother - 合同其他收入
     */
    public Double getContractincomeother() {
        return contractincomeother;
    }

    /**
     * 设置合同其他收入
     *
     * @param contractincomeother 合同其他收入
     */
    public void setContractincomeother(Double contractincomeother) {
        this.contractincomeother = contractincomeother;
    }

    /**
     * 获取所得税
     *
     * @return incometaxable - 所得税
     */
    public Double getIncometaxable() {
        return incometaxable;
    }

    /**
     * 设置所得税
     *
     * @param incometaxable 所得税
     */
    public void setIncometaxable(Double incometaxable) {
        this.incometaxable = incometaxable;
    }

    /**
     * 获取所得税减免
     *
     * @return incometaxdeduction - 所得税减免
     */
    public Double getIncometaxdeduction() {
        return incometaxdeduction;
    }

    /**
     * 设置所得税减免
     *
     * @param incometaxdeduction 所得税减免
     */
    public void setIncometaxdeduction(Double incometaxdeduction) {
        this.incometaxdeduction = incometaxdeduction;
    }

    /**
     * 获取个人所得税
     *
     * @return pensonaltaxable - 个人所得税
     */
    public Double getPensonaltaxable() {
        return pensonaltaxable;
    }

    /**
     * 设置个人所得税
     *
     * @param pensonaltaxable 个人所得税
     */
    public void setPensonaltaxable(Double pensonaltaxable) {
        this.pensonaltaxable = pensonaltaxable;
    }

    /**
     * 获取个人所得税减免
     *
     * @return pensonaltaxdecution - 个人所得税减免
     */
    public Double getPensonaltaxdecution() {
        return pensonaltaxdecution;
    }

    /**
     * 设置个人所得税减免
     *
     * @param pensonaltaxdecution 个人所得税减免
     */
    public void setPensonaltaxdecution(Double pensonaltaxdecution) {
        this.pensonaltaxdecution = pensonaltaxdecution;
    }

    /**
     * 获取附加税
     *
     * @return addvaluetaxable - 附加税
     */
    public Double getAddvaluetaxable() {
        return addvaluetaxable;
    }

    /**
     * 设置附加税
     *
     * @param addvaluetaxable 附加税
     */
    public void setAddvaluetaxable(Double addvaluetaxable) {
        this.addvaluetaxable = addvaluetaxable;
    }

    /**
     * 获取附加税减免
     *
     * @return addvaluetaxdecution - 附加税减免
     */
    public Double getAddvaluetaxdecution() {
        return addvaluetaxdecution;
    }

    /**
     * 设置附加税减免
     *
     * @param addvaluetaxdecution 附加税减免
     */
    public void setAddvaluetaxdecution(Double addvaluetaxdecution) {
        this.addvaluetaxdecution = addvaluetaxdecution;
    }

    /**
     * 获取股权风投
     *
     * @return stockfinancevc - 股权风投
     */
    public Double getStockfinancevc() {
        return stockfinancevc;
    }

    /**
     * 设置股权风投
     *
     * @param stockfinancevc 股权风投
     */
    public void setStockfinancevc(Double stockfinancevc) {
        this.stockfinancevc = stockfinancevc;
    }

    /**
     * 获取股权政府企业
     *
     * @return stockfinancegovenment - 股权政府企业
     */
    public Double getStockfinancegovenment() {
        return stockfinancegovenment;
    }

    /**
     * 设置股权政府企业
     *
     * @param stockfinancegovenment 股权政府企业
     */
    public void setStockfinancegovenment(Double stockfinancegovenment) {
        this.stockfinancegovenment = stockfinancegovenment;
    }

    /**
     * 获取股权个人
     *
     * @return stockfinancepensonal - 股权个人
     */
    public Double getStockfinancepensonal() {
        return stockfinancepensonal;
    }

    /**
     * 设置股权个人
     *
     * @param stockfinancepensonal 股权个人
     */
    public void setStockfinancepensonal(Double stockfinancepensonal) {
        this.stockfinancepensonal = stockfinancepensonal;
    }

    /**
     * 获取债务银行
     *
     * @return debtfinancebank - 债务银行
     */
    public Double getDebtfinancebank() {
        return debtfinancebank;
    }

    /**
     * 设置债务银行
     *
     * @param debtfinancebank 债务银行
     */
    public void setDebtfinancebank(Double debtfinancebank) {
        this.debtfinancebank = debtfinancebank;
    }

    /**
     * 获取债务新型借贷机构
     *
     * @return debtfinanceli - 债务新型借贷机构
     */
    public Double getDebtfinanceli() {
        return debtfinanceli;
    }

    /**
     * 设置债务新型借贷机构
     *
     * @param debtfinanceli 债务新型借贷机构
     */
    public void setDebtfinanceli(Double debtfinanceli) {
        this.debtfinanceli = debtfinanceli;
    }

    /**
     * 获取债务公司拆解
     *
     * @return debtfinancecompany - 债务公司拆解
     */
    public Double getDebtfinancecompany() {
        return debtfinancecompany;
    }

    /**
     * 设置债务公司拆解
     *
     * @param debtfinancecompany 债务公司拆解
     */
    public void setDebtfinancecompany(Double debtfinancecompany) {
        this.debtfinancecompany = debtfinancecompany;
    }

    /**
     * 获取z债务个人
     *
     * @return debtfinancepensonal - z债务个人
     */
    public Double getDebtfinancepensonal() {
        return debtfinancepensonal;
    }

    /**
     * 设置z债务个人
     *
     * @param debtfinancepensonal z债务个人
     */
    public void setDebtfinancepensonal(Double debtfinancepensonal) {
        this.debtfinancepensonal = debtfinancepensonal;
    }

    /**
     * 获取l流动资产
     *
     * @return currentasset - l流动资产
     */
    public Double getCurrentasset() {
        return currentasset;
    }

    /**
     * 设置l流动资产
     *
     * @param currentasset l流动资产
     */
    public void setCurrentasset(Double currentasset) {
        this.currentasset = currentasset;
    }

    /**
     * 获取f非流动资产
     *
     * @return nocurrentasset - f非流动资产
     */
    public Double getNocurrentasset() {
        return nocurrentasset;
    }

    /**
     * 设置f非流动资产
     *
     * @param nocurrentasset f非流动资产
     */
    public void setNocurrentasset(Double nocurrentasset) {
        this.nocurrentasset = nocurrentasset;
    }

    /**
     * 获取l流动借债
     *
     * @return currentdebt - l流动借债
     */
    public Double getCurrentdebt() {
        return currentdebt;
    }

    /**
     * 设置l流动借债
     *
     * @param currentdebt l流动借债
     */
    public void setCurrentdebt(Double currentdebt) {
        this.currentdebt = currentdebt;
    }

    /**
     * 获取f非流动借债
     *
     * @return nocurrentdebt - f非流动借债
     */
    public Double getNocurrentdebt() {
        return nocurrentdebt;
    }

    /**
     * 设置f非流动借债
     *
     * @param nocurrentdebt f非流动借债
     */
    public void setNocurrentdebt(Double nocurrentdebt) {
        this.nocurrentdebt = nocurrentdebt;
    }

    /**
     * 获取s首次融资估值
     *
     * @return firstfinancevalue - s首次融资估值
     */
    public Double getFirstfinancevalue() {
        return firstfinancevalue;
    }

    /**
     * 设置s首次融资估值
     *
     * @param firstfinancevalue s首次融资估值
     */
    public void setFirstfinancevalue(Double firstfinancevalue) {
        this.firstfinancevalue = firstfinancevalue;
    }

    /**
     * 获取z最后一次融资估值
     *
     * @return lastfinancevalue - z最后一次融资估值
     */
    public Double getLastfinancevalue() {
        return lastfinancevalue;
    }

    /**
     * 设置z最后一次融资估值
     *
     * @param lastfinancevalue z最后一次融资估值
     */
    public void setLastfinancevalue(Double lastfinancevalue) {
        this.lastfinancevalue = lastfinancevalue;
    }

    /**
     * 获取x现在融资估值
     *
     * @return currentfinancevalue - x现在融资估值
     */
    public Double getCurrentfinancevalue() {
        return currentfinancevalue;
    }

    /**
     * 设置x现在融资估值
     *
     * @param currentfinancevalue x现在融资估值
     */
    public void setCurrentfinancevalue(Double currentfinancevalue) {
        this.currentfinancevalue = currentfinancevalue;
    }

    /**
     * 获取兼职研发
     *
     * @return parttimedevelopment - 兼职研发
     */
    public Integer getParttimedevelopment() {
        return parttimedevelopment;
    }

    /**
     * 设置兼职研发
     *
     * @param parttimedevelopment 兼职研发
     */
    public void setParttimedevelopment(Integer parttimedevelopment) {
        this.parttimedevelopment = parttimedevelopment;
    }

    /**
     * 获取j兼职管理
     *
     * @return parttimemanager - j兼职管理
     */
    public Integer getParttimemanager() {
        return parttimemanager;
    }

    /**
     * 设置j兼职管理
     *
     * @param parttimemanager j兼职管理
     */
    public void setParttimemanager(Integer parttimemanager) {
        this.parttimemanager = parttimemanager;
    }

    /**
     * 获取j兼职行政
     *
     * @return parttimeadmin - j兼职行政
     */
    public Integer getParttimeadmin() {
        return parttimeadmin;
    }

    /**
     * 设置j兼职行政
     *
     * @param parttimeadmin j兼职行政
     */
    public void setParttimeadmin(Integer parttimeadmin) {
        this.parttimeadmin = parttimeadmin;
    }

    /**
     * 获取j兼职销售
     *
     * @return parttimesell - j兼职销售
     */
    public Integer getParttimesell() {
        return parttimesell;
    }

    /**
     * 设置j兼职销售
     *
     * @param parttimesell j兼职销售
     */
    public void setParttimesell(Integer parttimesell) {
        this.parttimesell = parttimesell;
    }

    /**
     * 获取k开发人数
     *
     * @return development - k开发人数
     */
    public Integer getDevelopment() {
        return development;
    }

    /**
     * 设置k开发人数
     *
     * @param development k开发人数
     */
    public void setDevelopment(Integer development) {
        this.development = development;
    }

    /**
     * 获取g管理人数
     *
     * @return manamger - g管理人数
     */
    public Integer getManamger() {
        return manamger;
    }

    /**
     * 设置g管理人数
     *
     * @param manamger g管理人数
     */
    public void setManamger(Integer manamger) {
        this.manamger = manamger;
    }

    /**
     * 获取g行政人数
     *
     * @return administrator - g行政人数
     */
    public Integer administrator() {
        return administrator;
    }

    /**
     * 设置g行政人数
     *
     * @param administrator g行政人数
     */
    public void administrator(Integer administrator) {
        this.administrator = administrator;
    }

    /**
     * 获取x销售人数
     *
     * @return sell - x销售人数
     */
    public Integer getSell() {
        return sell;
    }

    /**
     * 设置x销售人数
     *
     * @param sell x销售人数
     */
    public void setSell(Integer sell) {
        this.sell = sell;
    }

    /**
     * 获取博士人数
     *
     * @return doctor - 博士人数
     */
    public Integer getDoctor() {
        return doctor;
    }

    /**
     * 设置博士人数
     *
     * @param doctor 博士人数
     */
    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    /**
     * 获取硕士人数
     *
     * @return master - 硕士人数
     */
    public Integer getMaster() {
        return master;
    }

    /**
     * 设置硕士人数
     *
     * @param master 硕士人数
     */
    public void setMaster(Integer master) {
        this.master = master;
    }

    /**
     * 获取学士人数
     *
     * @return bachelor - 学士人数
     */
    public Integer getBachelor() {
        return bachelor;
    }

    /**
     * 设置学士人数
     *
     * @param bachelor 学士人数
     */
    public void setBachelor(Integer bachelor) {
        this.bachelor = bachelor;
    }

    /**
     * 获取申请专利 发明
     *
     * @return applypatentinvent - 申请专利 发明
     */
    public Integer getApplypatentinvent() {
        return applypatentinvent;
    }

    /**
     * 设置申请专利 发明
     *
     * @param applypatentinvent 申请专利 发明
     */
    public void setApplypatentinvent(Integer applypatentinvent) {
        this.applypatentinvent = applypatentinvent;
    }

    /**
     * 获取申请专利 实业
     *
     * @return applypatentindustry - 申请专利 实业
     */
    public Integer getApplypatentindustry() {
        return applypatentindustry;
    }

    /**
     * 设置申请专利 实业
     *
     * @param applypatentindustry 申请专利 实业
     */
    public void setApplypatentindustry(Integer applypatentindustry) {
        this.applypatentindustry = applypatentindustry;
    }

    /**
     * 获取申请专利 设计
     *
     * @return applypatentdesign - 申请专利 设计
     */
    public Integer getApplypatentdesign() {
        return applypatentdesign;
    }

    /**
     * 设置申请专利 设计
     *
     * @param applypatentdesign 申请专利 设计
     */
    public void setApplypatentdesign(Integer applypatentdesign) {
        this.applypatentdesign = applypatentdesign;
    }

    /**
     * 获取获取专利 研发
     *
     * @return patentinvent - 获取专利 研发
     */
    public Integer getPatentinvent() {
        return patentinvent;
    }

    /**
     * 设置获取专利 研发
     *
     * @param patentinvent 获取专利 研发
     */
    public void setPatentinvent(Integer patentinvent) {
        this.patentinvent = patentinvent;
    }

    /**
     * 获取获取专利 实业
     *
     * @return patentindustry - 获取专利 实业
     */
    public Integer getPatentindustry() {
        return patentindustry;
    }

    /**
     * 设置获取专利 实业
     *
     * @param patentindustry 获取专利 实业
     */
    public void setPatentindustry(Integer patentindustry) {
        this.patentindustry = patentindustry;
    }

    /**
     * 获取获取专利 设计
     *
     * @return patentdesign - 获取专利 设计
     */
    public Integer getPatentdesign() {
        return patentdesign;
    }

    /**
     * 设置获取专利 设计
     *
     * @param patentdesign 获取专利 设计
     */
    public void setPatentdesign(Integer patentdesign) {
        this.patentdesign = patentdesign;
    }

    /**
     * 获取申请著作权 软件
     *
     * @return applyauthorsoftware - 申请著作权 软件
     */
    public Integer getApplyauthorsoftware() {
        return applyauthorsoftware;
    }

    /**
     * 设置申请著作权 软件
     *
     * @param applyauthorsoftware 申请著作权 软件
     */
    public void setApplyauthorsoftware(Integer applyauthorsoftware) {
        this.applyauthorsoftware = applyauthorsoftware;
    }

    /**
     * 获取申请著作权 非软件
     *
     * @return applyauthorother - 申请著作权 非软件
     */
    public Integer getApplyauthorother() {
        return applyauthorother;
    }

    /**
     * 设置申请著作权 非软件
     *
     * @param applyauthorother 申请著作权 非软件
     */
    public void setApplyauthorother(Integer applyauthorother) {
        this.applyauthorother = applyauthorother;
    }

    /**
     * 获取著作权 软件
     *
     * @return authorsoftware - 著作权 软件
     */
    public Integer getAuthorsoftware() {
        return authorsoftware;
    }

    /**
     * 设置著作权 软件
     *
     * @param authorsoftware 著作权 软件
     */
    public void setAuthorsoftware(Integer authorsoftware) {
        this.authorsoftware = authorsoftware;
    }

    /**
     * 获取著作权 非软件
     *
     * @return authorother - 著作权 非软件
     */
    public Integer getAuthorother() {
        return authorother;
    }

    /**
     * 设置著作权 非软件
     *
     * @param authorother 著作权 非软件
     */
    public void setAuthorother(Integer authorother) {
        this.authorother = authorother;
    }

    /**
     * 获取新产品服务数 专利类
     *
     * @return servicepatent - 新产品服务数 专利类
     */
    public Integer getServicepatent() {
        return servicepatent;
    }

    /**
     * 设置新产品服务数 专利类
     *
     * @param servicepatent 新产品服务数 专利类
     */
    public void setServicepatent(Integer servicepatent) {
        this.servicepatent = servicepatent;
    }

    /**
     * 获取新产品服务数 专用技术
     *
     * @return serviceskill - 新产品服务数 专用技术
     */
    public Integer getServiceskill() {
        return serviceskill;
    }

    /**
     * 设置新产品服务数 专用技术
     *
     * @param serviceskill 新产品服务数 专用技术
     */
    public void setServiceskill(Integer serviceskill) {
        this.serviceskill = serviceskill;
    }

    /**
     * 获取新产品服务数 商业模式
     *
     * @return servicesell - 新产品服务数 商业模式
     */
    public Integer getServicesell() {
        return servicesell;
    }

    /**
     * 设置新产品服务数 商业模式
     *
     * @param servicesell 新产品服务数 商业模式
     */
    public void setServicesell(Integer servicesell) {
        this.servicesell = servicesell;
    }

    /**
     * 获取>10000工资总数
     *
     * @return salaryhigh - >10000工资总数
     */
    public Double getSalaryhigh() {
        return salaryhigh;
    }

    /**
     * 设置>10000工资总数
     *
     * @param salaryhigh >10000工资总数
     */
    public void setSalaryhigh(Double salaryhigh) {
        this.salaryhigh = salaryhigh;
    }

    /**
     * 获取5000-10000工资总数
     *
     * @return salarymiddle - 5000-10000工资总数
     */
    public Double getSalarymiddle() {
        return salarymiddle;
    }

    /**
     * 设置5000-10000工资总数
     *
     * @param salarymiddle 5000-10000工资总数
     */
    public void setSalarymiddle(Double salarymiddle) {
        this.salarymiddle = salarymiddle;
    }

    /**
     * 获取<5000工资总和
     *
     * @return salarylow - <5000工资总和
     */
    public Double getSalarylow() {
        return salarylow;
    }

    /**
     * 设置<5000工资总和
     *
     * @param salarylow <5000工资总和
     */
    public void setSalarylow(Double salarylow) {
        this.salarylow = salarylow;
    }

    /**
     * 获取人均销售
     *
     * @return persell - 人均销售
     */
    public Double getPersell() {
        return persell;
    }

    /**
     * 设置人均销售
     *
     * @param persell 人均销售
     */
    public void setPersell(Double persell) {
        this.persell = persell;
    }

    /**
     * 获取人均纳税
     *
     * @return pertax - 人均纳税
     */
    public Double getPertax() {
        return pertax;
    }

    /**
     * 设置人均纳税
     *
     * @param pertax 人均纳税
     */
    public void setPertax(Double pertax) {
        this.pertax = pertax;
    }

    /**
     * 获取参加训练次数 管理
     *
     * @return trainmanage - 参加训练次数 管理
     */
    public Integer getTrainmanage() {
        return trainmanage;
    }

    /**
     * 设置参加训练次数 管理
     *
     * @param trainmanage 参加训练次数 管理
     */
    public void setTrainmanage(Integer trainmanage) {
        this.trainmanage = trainmanage;
    }

    /**
     * 获取参加训练次数 法规
     *
     * @return trainlegal - 参加训练次数 法规
     */
    public Integer getTrainlegal() {
        return trainlegal;
    }

    /**
     * 设置参加训练次数 法规
     *
     * @param trainlegal 参加训练次数 法规
     */
    public void setTrainlegal(Integer trainlegal) {
        this.trainlegal = trainlegal;
    }

    /**
     * 获取参加训练次数 技能
     *
     * @return trainskill - 参加训练次数 技能
     */
    public Integer getTrainskill() {
        return trainskill;
    }

    /**
     * 设置参加训练次数 技能
     *
     * @param trainskill 参加训练次数 技能
     */
    public void setTrainskill(Integer trainskill) {
        this.trainskill = trainskill;
    }

    /**
     * 获取参与咨询次数 管理
     *
     * @return consultmanage - 参与咨询次数 管理
     */
    public Integer getConsultmanage() {
        return consultmanage;
    }

    /**
     * 设置参与咨询次数 管理
     *
     * @param consultmanage 参与咨询次数 管理
     */
    public void setConsultmanage(Integer consultmanage) {
        this.consultmanage = consultmanage;
    }

    /**
     * 获取参与咨询次数 法规
     *
     * @return consultlegal - 参与咨询次数 法规
     */
    public Integer getConsultlegal() {
        return consultlegal;
    }

    /**
     * 设置参与咨询次数 法规
     *
     * @param consultlegal 参与咨询次数 法规
     */
    public void setConsultlegal(Integer consultlegal) {
        this.consultlegal = consultlegal;
    }

    /**
     * 获取参与咨询次数 技能
     *
     * @return consultskill - 参与咨询次数 技能
     */
    public Integer getConsultskill() {
        return consultskill;
    }

    /**
     * 设置参与咨询次数 技能
     *
     * @param consultskill 参与咨询次数 技能
     */
    public void setConsultskill(Integer consultskill) {
        this.consultskill = consultskill;
    }

    /**
     * 获取获奖次数 区级
     *
     * @return awarddistrict - 获奖次数 区级
     */
    public Integer getAwarddistrict() {
        return awarddistrict;
    }

    /**
     * 设置获奖次数 区级
     *
     * @param awarddistrict 获奖次数 区级
     */
    public void setAwarddistrict(Integer awarddistrict) {
        this.awarddistrict = awarddistrict;
    }

    /**
     * 获取获奖次数 市级
     *
     * @return awardcity - 获奖次数 市级
     */
    public Integer getAwardcity() {
        return awardcity;
    }

    /**
     * 设置获奖次数 市级
     *
     * @param awardcity 获奖次数 市级
     */
    public void setAwardcity(Integer awardcity) {
        this.awardcity = awardcity;
    }

    /**
     * 获取获奖次数 省级
     *
     * @return awardprovince - 获奖次数 省级
     */
    public Integer getAwardprovince() {
        return awardprovince;
    }

    /**
     * 设置获奖次数 省级
     *
     * @param awardprovince 获奖次数 省级
     */
    public void setAwardprovince(Integer awardprovince) {
        this.awardprovince = awardprovince;
    }

    /**
     * 获取获奖次数 国家级
     *
     * @return awardnation - 获奖次数 国家级
     */
    public Integer getAwardnation() {
        return awardnation;
    }

    /**
     * 设置获奖次数 国家级
     *
     * @param awardnation 获奖次数 国家级
     */
    public void setAwardnation(Integer awardnation) {
        this.awardnation = awardnation;
    }

    /**
     * 获取认定次数 区级
     *
     * @return comfirmdistrict - 认定次数 区级
     */
    public Integer getComfirmdistrict() {
        return comfirmdistrict;
    }

    /**
     * 设置认定次数 区级
     *
     * @param comfirmdistrict 认定次数 区级
     */
    public void setComfirmdistrict(Integer comfirmdistrict) {
        this.comfirmdistrict = comfirmdistrict;
    }

    /**
     * 获取认定次数 市级
     *
     * @return comfirmcity - 认定次数 市级
     */
    public Integer getComfirmcity() {
        return comfirmcity;
    }

    /**
     * 设置认定次数 市级
     *
     * @param comfirmcity 认定次数 市级
     */
    public void setComfirmcity(Integer comfirmcity) {
        this.comfirmcity = comfirmcity;
    }

    /**
     * 获取认定次数 省级
     *
     * @return comfirmprovince - 认定次数 省级
     */
    public Integer getComfirmprovince() {
        return comfirmprovince;
    }

    /**
     * 设置认定次数 省级
     *
     * @param comfirmprovince 认定次数 省级
     */
    public void setComfirmprovince(Integer comfirmprovince) {
        this.comfirmprovince = comfirmprovince;
    }

    /**
     * 获取认定次数 国家级
     *
     * @return comfirmnation - 认定次数 国家级
     */
    public Integer getComfirmnation() {
        return comfirmnation;
    }

    /**
     * 设置认定次数 国家级
     *
     * @param comfirmnation 认定次数 国家级
     */
    public void setComfirmnation(Integer comfirmnation) {
        this.comfirmnation = comfirmnation;
    }

    /**
     * 获取人才资助 区级
     *
     * @return supportdistrict - 人才资助 区级
     */
    public Integer getSupportdistrict() {
        return supportdistrict;
    }

    /**
     * 设置人才资助 区级
     *
     * @param supportdistrict 人才资助 区级
     */
    public void setSupportdistrict(Integer supportdistrict) {
        this.supportdistrict = supportdistrict;
    }

    /**
     * 获取人才资助 市级
     *
     * @return supportcity - 人才资助 市级
     */
    public Integer getSupportcity() {
        return supportcity;
    }

    /**
     * 设置人才资助 市级
     *
     * @param supportcity 人才资助 市级
     */
    public void setSupportcity(Integer supportcity) {
        this.supportcity = supportcity;
    }

    /**
     * 获取人才资助 省级
     *
     * @return supportprovince - 人才资助 省级
     */
    public Integer getSupportprovince() {
        return supportprovince;
    }

    /**
     * 设置人才资助 省级
     *
     * @param supportprovince 人才资助 省级
     */
    public void setSupportprovince(Integer supportprovince) {
        this.supportprovince = supportprovince;
    }

    /**
     * 获取人才资助 国家级
     *
     * @return supportnation - 人才资助 国家级
     */
    public Integer getSupportnation() {
        return supportnation;
    }

    /**
     * 设置人才资助 国家级
     *
     * @param supportnation 人才资助 国家级
     */
    public void setSupportnation(Integer supportnation) {
        this.supportnation = supportnation;
    }

    @Override
    public String toString() {
        return "CompanyInput{" +
                "id=" + id +
                ", companyname='" + companyname + '\'' +
                ", year=" + year +
                ", quarter=" + quarter +
                ", ticketincomesoftware=" + ticketincomesoftware +
                ", ticketincomehardware=" + ticketincomehardware +
                ", ticketincomeconsult=" + ticketincomeconsult +
                ", ticketincomeother=" + ticketincomeother +
                ", contractincomesoftware=" + contractincomesoftware +
                ", contractincomehardware=" + contractincomehardware +
                ", contractincomeconsult=" + contractincomeconsult +
                ", contractincomeother=" + contractincomeother +
                ", incometaxable=" + incometaxable +
                ", incometaxdeduction=" + incometaxdeduction +
                ", pensonaltaxable=" + pensonaltaxable +
                ", pensonaltaxdecution=" + pensonaltaxdecution +
                ", addvaluetaxable=" + addvaluetaxable +
                ", addvaluetaxdecution=" + addvaluetaxdecution +
                ", stockfinancevc=" + stockfinancevc +
                ", stockfinancegovenment=" + stockfinancegovenment +
                ", stockfinancepensonal=" + stockfinancepensonal +
                ", debtfinancebank=" + debtfinancebank +
                ", debtfinanceli=" + debtfinanceli +
                ", debtfinancecompany=" + debtfinancecompany +
                ", debtfinancepensonal=" + debtfinancepensonal +
                ", currentasset=" + currentasset +
                ", nocurrentasset=" + nocurrentasset +
                ", currentdebt=" + currentdebt +
                ", nocurrentdebt=" + nocurrentdebt +
                ", firstfinancevalue=" + firstfinancevalue +
                ", lastfinancevalue=" + lastfinancevalue +
                ", currentfinancevalue=" + currentfinancevalue +
                ", parttimedevelopment=" + parttimedevelopment +
                ", parttimemanager=" + parttimemanager +
                ", parttimeadmin=" + parttimeadmin +
                ", parttimesell=" + parttimesell +
                ", development=" + development +
                ", manamger=" + manamger +
                ", administrator=" + administrator +
                ", sell=" + sell +
                ", doctor=" + doctor +
                ", master=" + master +
                ", bachelor=" + bachelor +
                ", applypatentinvent=" + applypatentinvent +
                ", applypatentindustry=" + applypatentindustry +
                ", applypatentdesign=" + applypatentdesign +
                ", patentinvent=" + patentinvent +
                ", patentindustry=" + patentindustry +
                ", patentdesign=" + patentdesign +
                ", applyauthorsoftware=" + applyauthorsoftware +
                ", applyauthorother=" + applyauthorother +
                ", authorsoftware=" + authorsoftware +
                ", authorother=" + authorother +
                ", servicepatent=" + servicepatent +
                ", serviceskill=" + serviceskill +
                ", servicesell=" + servicesell +
                ", salaryhigh=" + salaryhigh +
                ", salarymiddle=" + salarymiddle +
                ", salarylow=" + salarylow +
                ", persell=" + persell +
                ", pertax=" + pertax +
                ", trainmanage=" + trainmanage +
                ", trainlegal=" + trainlegal +
                ", trainskill=" + trainskill +
                ", consultmanage=" + consultmanage +
                ", consultlegal=" + consultlegal +
                ", consultskill=" + consultskill +
                ", awarddistrict=" + awarddistrict +
                ", awardcity=" + awardcity +
                ", awardprovince=" + awardprovince +
                ", awardnation=" + awardnation +
                ", comfirmdistrict=" + comfirmdistrict +
                ", comfirmcity=" + comfirmcity +
                ", comfirmprovince=" + comfirmprovince +
                ", comfirmnation=" + comfirmnation +
                ", supportdistrict=" + supportdistrict +
                ", supportcity=" + supportcity +
                ", supportprovince=" + supportprovince +
                ", supportnation=" + supportnation +
                '}';
    }

    public CompanyInput() {
    }

    public static CompanyInput inputByArray(String[] input) {
        CompanyInput companyInput = new CompanyInput();
        List<String> list = Arrays.asList(input);
        Iterator<String> iterator = list.iterator();
        Field[] fields = CompanyInput.class.getDeclaredFields();
        try {
            if (fields.length - 1 != input.length) {
                throw new RuntimeException("输入的list的个数必须匹配companyInput属性个数(id属性除外)");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < fields.length && iterator.hasNext(); i++) {
            fields[i].setAccessible(true);
            String next = iterator.next();
            if (next.isEmpty()) {
                continue;
            }
            try {
                if (fields[i].getGenericType() == Integer.class) {
                    fields[i].set(companyInput, Integer.parseInt(iterator.next()));
                }
                if (fields[i].getGenericType() == Double.class) {
                    fields[i].set(companyInput, Double.parseDouble(iterator.next()));
                }
                if (fields[i].getGenericType() == String.class) {
                    fields[i].set(companyInput, iterator.next());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return companyInput;
    }
    public static CompanyInput inputByMap(Map<String, String[]> map){
        CompanyInput companyInput = new CompanyInput();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            try {
                if (entry.getValue().length > 1) {
                    throw new RuntimeException("map中 key=" + entry.getKey() + " value值不唯一");
                }
                if (entry.getValue().length == 0 || entry.getValue()[0].isEmpty()) {
                    continue;
                }
                Field field = CompanyInput.class.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                if (field.getGenericType() == Integer.class) {
                    field.set(companyInput, Integer.parseInt(entry.getValue()[0]));
                }
                if (field.getGenericType() == Double.class) {
                    field.set(companyInput, Double.parseDouble(entry.getValue()[0]));
                }
                if (field.getGenericType() == String.class) {
                    field.set(companyInput, entry.getValue()[0]);
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return companyInput;
    }
}