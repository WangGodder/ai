package com.swu.ai.Result;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class CompanyInputBase {

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
    private Double parttimedevelopment = new Double(0);

    /**
     * j兼职管理
     */
    private Double parttimemanager = new Double(0);

    /**
     * j兼职行政
     */
    private Double parttimeadmin = new Double(0);

    /**
     * j兼职销售
     */
    private Double parttimesell = new Double(0);

    /**
     * k开发人数
     */
    private Double development = new Double(0);

    /**
     * g管理人数
     */
    private Double manamger = new Double(0);

    /**
     * g行政人数
     */
    private Double administrator = new Double(0);

    /**
     * x销售人数
     */
    private Double sell = new Double(0);

    /**
     * 博士人数
     */
    private Double doctor = new Double(0);

    /**
     * 硕士人数
     */
    private Double master = new Double(0);

    /**
     * 学士人数
     */
    private Double bachelor = new Double(0);

    /**
     * 申请专利 发明
     */
    private Double applypatentinvent = new Double(0);

    /**
     * 申请专利 实业
     */
    private Double applypatentindustry = new Double(0);

    /**
     * 申请专利 设计
     */
    private Double applypatentdesign = new Double(0);

    /**
     * 获取专利 研发
     */
    private Double patentinvent = new Double(0);

    /**
     * 获取专利 实业
     */
    private Double patentindustry = new Double(0);

    /**
     * 获取专利 设计
     */
    private Double patentdesign = new Double(0);

    /**
     * 申请著作权 软件
     */
    private Double applyauthorsoftware = new Double(0);

    /**
     * 申请著作权 非软件
     */
    private Double applyauthorother = new Double(0);

    /**
     * 著作权 软件
     */
    private Double authorsoftware = new Double(0);

    /**
     * 著作权 非软件
     */
    private Double authorother = new Double(0);

    /**
     * 新产品服务数 专利类
     */
    private Double servicepatent = new Double(0);

    /**
     * 新产品服务数 专用技术
     */
    private Double serviceskill = new Double(0);

    /**
     * 新产品服务数 商业模式
     */
    private Double servicesell = new Double(0);

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
    private Double trainmanage = new Double(0);

    /**
     * 参加训练次数 法规
     */
    private Double trainlegal = new Double(0);

    /**
     * 参加训练次数 技能
     */
    private Double trainskill = new Double(0);

    /**
     * 参与咨询次数 管理
     */
    private Double consultmanage = new Double(0);

    /**
     * 参与咨询次数 法规
     */
    private Double consultlegal = new Double(0);

    /**
     * 参与咨询次数 技能
     */
    private Double consultskill = new Double(0);

    /**
     * 获奖次数 区级
     */
    private Double awarddistrict = new Double(0);

    /**
     * 获奖次数 市级
     */
    private Double awardcity = new Double(0);

    /**
     * 获奖次数 省级
     */
    private Double awardprovince = new Double(0);

    /**
     * 获奖次数 国家级
     */
    private Double awardnation = new Double(0);

    /**
     * 认定次数 区级
     */
    private Double comfirmdistrict = new Double(0);

    /**
     * 认定次数 市级
     */
    private Double comfirmcity = new Double(0);

    /**
     * 认定次数 省级
     */
    private Double comfirmprovince = new Double(0);

    /**
     * 认定次数 国家级
     */
    private Double comfirmnation = new Double(0);

    /**
     * 人才资助 区级
     */
    private Double supportdistrict = new Double(0);

    /**
     * 人才资助 市级
     */
    private Double supportcity = new Double(0);

    /**
     * 人才资助 省级
     */
    private Double supportprovince = new Double(0);

    /**
     * 人才资助 国家级
     */
    private Double supportnation = new Double(0);


    @Override
    public String toString() {
        return "CompanyInputBase{" +
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

    /**
     * 通过String数组生成CompanyInput对象
     * @param input 输入String数组
     * @return
     */
    // TODO: input的长度必须与CompanyInput除ID外的属性一一对应，空值请用空字符串，不要用null
    public static CompanyInputBase inputByArray(String[] input) {
        CompanyInputBase companyInput = new CompanyInputBase();
        List<String> list = Arrays.asList(input);
        Iterator<String> iterator = list.iterator();
        Field[] fields = CompanyInputBase.class.getDeclaredFields();
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
                if (fields[i].getGenericType() == Double.class) {
                    fields[i].set(companyInput, Double.parseDouble(next));
                }
                if (fields[i].getGenericType() == String.class) {
                    fields[i].set(companyInput, next);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return companyInput;
    }

    /**
     * 通过Map生成
     * @param map 与companyInput属性名称对应的Map，且value中的String数组长度必须为1，若无值则长度为0或为单个空字符串
     * @return
     */
    public static CompanyInputBase inputByMap(Map<String, String[]> map){
        CompanyInputBase companyInput = new CompanyInputBase();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            try {
                if (entry.getValue().length > 1) {
                    throw new RuntimeException("map中 key=" + entry.getKey() + " value值不唯一");
                }
                if (entry.getValue().length == 0 || entry.getValue()[0].isEmpty()) {
                    continue;
                }
                Field field = CompanyInputBase.class.getDeclaredField(entry.getKey());
                field.setAccessible(true);
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