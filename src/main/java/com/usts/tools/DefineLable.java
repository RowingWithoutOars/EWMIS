package com.usts.tools;

import org.apache.ibatis.jdbc.Null;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DefineLable {
    int label;

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    String 硅藻门[] = {"扎卡四棘藻", "颗粒沟链藻", "颗粒沟链藻最窄变种", "螺旋颗粒沟链藻", "模糊沟链藻", "变异直链藻", "小环藻", "圆筛藻", "普通等片藻", "脆杆藻", "肘状脆杆藻", "尖针杆藻", "肘状针杆藻", "舟形藻", "隐头舟形藻", "瞳孔舟形藻", "放射舟形藻", "英吉利舟形藻","细布纹藻", "异极藻", "窄异极藻", "缢缩异极藻", "双头异极藻","扁圆卵形藻", "曲壳藻", "桥弯藻",
            "纤细桥弯藻", "箱型桥弯藻", "近缘桥弯藻", "Cymbella minuta", "卵圆双眉藻", "谷皮菱形藻", "双菱藻", "卵形双菱藻", "侧链藻",
            "美丽星杆藻", "连结脆杆藻", "橄榄形异极藻", "柄卵形藻" };
    String 甲藻门[] = {"多甲藻", "裸甲藻" };
    String 金藻门[] = {"分歧锥囊藻", "圆筒锥囊藻", "长锥形锥囊藻" };
    String 隐藻门[] = {"尖尾蓝隐藻", "卵形隐藻", "啮蚀隐藻" };
    String 裸藻门[] = {"裸藻", "绿色裸藻", "尖尾裸藻", "囊裸藻", "扁裸藻", "尾裸藻" };
    String 蓝藻门[] = {"铜绿微囊藻", "色球藻","假鱼腥藻", "水华鱼腥藻", "鱼腥藻", "小席藻" };
    String 绿藻门[] = {"衣藻", "空球藻", "小球藻", "纤维藻", "镰形纤维藻", "狭形纤维藻", "卵囊藻", "月牙藻", "三角四角藻", "十字藻",
            "小空星藻", "空星藻", "单角盘星藻", "单角盘星藻具孔变种", "短棘盘星藻", "栅藻", "二形栅藻",
            "鼓藻", "氺溪绿球藻", "四刺顶棘藻", "粗刺四刺藻", "转板藻" };
    String 浮游植物[] = {"硅藻门", "甲藻门", "金藻门", "裸藻门", "蓝藻门", "绿藻门", "隐藻门","Shannon_H"};


    String 微生物[] = {"Archaea", "Bacteria", "物种丰富度Richness", "群落内部多样性香浓指数Shannon Indices","Unclassified"};
    String Archaea[] = {"Altiarchaeota", "Asgardaeota", "Crenarchaeota", "Diapherotrites", "Euryarchaeota",
            "Nanoarchaeaeota", "Thaumarchaeota" };
    String Bacteria[] = {"Altiarchaeota", "Asgardaeota", "Crenarchaeota", "Diapherotrites", "Euryarchaeota", "Nanoarchaeaeota",
            "Thaumarchaeota", "Acetothermia", "Acidobacteria", "Actinobacteria", "AncK6", "Armatimonadetes", "Atribacteria",
            "Bacteroidetes", "BRC1", "Caldiserica", "Calditrichaeota", "Chlamydiae", "Chloroflexi", "Cloacimonetes", "Cyanobacteria",
            "Dadabacteria", "Deinococcus-Thermus", "Dependentiae", "Elusimicrobia", "Entotheonellaeota", "Epsilonbacteraeota", "FBP",
            "FCPU426", "Fibrobacteres", "Firmicutes", "Fusobacteria", "GAL15", "Gemmatimonadetes", "Hydrogenedentes", "Kiritimatiellaeota",
            "Latescibacteria", "LCP-89", "Lentisphaerae", "Margulisbacteria", "MAT-CR-M4-B07", "Nitrospinae", "Nitrospirae", "Omnitrophicaeota",
            "Patescibacteria", "PAUC34f", "Planctomycetes", "Proteobacteria", "Rokubacteria", "Spirochaetes", "Synergistetes", "TA06",
            "Tenericutes", "Thermotogae", "Verrucomicrobia", "WPS-2", "WS1", "Zixibacteria", "(空白)" };
    String 物种丰富度Richness[] = {"物种丰富度Richness" };
    String 群落内部多样性香浓指数Shannon[] = {"群落内部多样性香浓指数Shannon" };
    String NULL[] = {"NULL" };

    String 弱吸附态磷[]={"弱吸附态磷mg/kg"};
    String 铁结合态磷数量[]={"铁结合态磷数量Fe-Pmg/kg"};
    String 铝结合态磷[]={"铝结合态磷Al-Pmg/kg"};
    String 有机磷数量[]={"有机磷数量Org-Pmg/kg"};
    String 钙结合态磷[]={"钙结合态磷Ca-Pmg/kg"};
    String 残渣磷Res[]={"残渣磷Res-Pmg/kg"};
    String 铜[]={"铜μg/g"};
    String 锌[]={"锌μg/g"};
    String 镍[]={"镍μg/g"};
    String 铅[]={"铅μg/g"};
    String 含水率[]={"含水率"};
    String 有机质LOI[]={"有机质LOI"};
    String 间隙水P[]={"间隙水Pmg/L"};
    String 间隙水Fe[]={"间隙水Femg/L"};


    String 密度[]={"沙蚕目","霍甫水丝蚓","苏氏尾鳃蚓","泽蛭","宽身舌蛭","流粗腹摇蚊属","中国长足摇蚊","长足摇蚊",
            "隐摇蚊","多足摇蚊","恩非摇蚊","摇蚊属","库蠓","大鳌蜚","环棱螺属","纹沼螺","放逸短沟蜷","圆顶珠蚌","河蚬"};
    String 生物量[]={"沙蚕目","霍甫水丝蚓","苏氏尾鳃蚓","泽蛭","宽身舌蛭","流粗腹摇蚊属","中国长足摇蚊","长足摇蚊",
            "隐摇蚊","多足摇蚊","恩非摇蚊","摇蚊属","库蠓","大鳌蜚","环棱螺属","纹沼螺","放逸短沟蜷","圆顶珠蚌","河蚬"};


    String 浮游动物[] = {"原生动物","轮虫","枝角类","桡足类","Shannon_H"};
    String 原生动物Protozoa[] = {"针棘匣壳虫 Centropyxis aculeata","王氏似铃壳虫 Tintinnopsis wangi","江苏似铃壳虫 Tintinnopsis kiangsuensis",
            "普通表壳虫 Arcella vulgaris","球砂壳虫 Difflugia globulosa","尖顶砂壳虫 Difflugia acuminata","毛板壳虫 Coleps hirtus",
            "小单环栉毛虫 Didinium balbianii nanum","螅状独缩虫 Carchesium polypinum","坛状曲颈虫 Cyphoderia ampulla",
            "急游虫 Strombidium sp.","砂壳虫 Difflugia sp.","麻铃虫 Leprotintinnus sp.","侠盗虫 Strobilidium sp.",
            "钟虫 Vorticella sp.","纤毛虫 Ciliophora sp.","累枝虫 Epistylis sp.","喇叭虫 Stentor sp."};
    String 轮虫Rotifera[] = {"聚花轮虫 Conochilus sp.","高跷轮虫 Scaridium longicaudum","扁平泡轮虫 Pompholyx complanata",
            "月形腔轮虫 Lecane luna","广布多肢轮虫 Polyarthra vulgaris","迈氏三肢轮虫 Filinia maior",
            "螺形龟甲轮虫 Keratella cochlearis","曲腿龟甲轮虫 Keratella valga","矩形龟甲轮虫 Keratella quadrata",
            "爱德里亚狭甲轮虫 Colurella adriatica","盘状鞍甲轮虫 Lepadella patella","前节晶囊轮虫 Asplanchna priodonta",
            "萼花臂尾轮虫 Brachionus calyciflorus","等刺异尾轮虫 Trichocerca similis","刺盖异尾轮虫 Trichocerca capucina",
            "纤巧同尾轮虫 Diurella tenuior","腹棘管轮虫 Mytilina ventralis","梨形单趾轮虫 Monostyla pyriformis",
            "囊形单趾轮虫 Monostyla bulla","尖趾单趾轮虫 Monostyla closterocerca","大肚须足轮虫 Euchlanis dilatata",
            "裂痕龟纹轮虫 Anuraeopsis fissa","疣毛轮虫 Synchaeta sp.","多态胶鞘轮虫 Collotheca ambigua","角突臂尾轮虫 Brachionus angularia","轮虫未定种"};

    String 枝角类Cladocera[]={"长额象鼻溞 Bosmina longirostris ","大洋洲弯尾溞 Camptocercus australis","点滴尖额溞 Alona guttata",
            "中型尖额溞 Alona intermedia","老年低额溞 Simocephalus vetulus","三角平直溞 Pleuroxus trigonellus","颈沟基合溞 Bosminopsis deitersi",
            "圆形盘肠溞 Chydorus sphaericus","短尾秀体溞 Diaphanosoma brachyurum","微型裸腹溞 Moina micrura",
            "角突网纹溞 Ceriodaphnia cornuta","透明薄皮溞 Leptodora kindti","西方笔纹溞 Graptoleberis testudinaria","多刺粗毛溞 Macrothrix spinosa"};

    String 桡足类Copepoda[] = {"汤匙华哲水蚤 Sinocalanus dorrii","中华窄腹水蚤 Limnoithona sinensis","跨立小剑水蚤 Microcyclops varicans",
            "广布中剑水蚤 Mesocyclops leuckarti","台湾温剑水蚤 Thermocyclops taihokuensis","球状许水蚤 Schmackeria torbesi",
            "指状许水蚤 Schmackeria inopinus","剑水蚤桡足幼体","哲水蚤桡足幼体","无节幼体","英勇剑水蚤 Cyclops strenuus","透明温剑水蚤 Thermocyclops hyalinus","哲水蚤幼体","汤匙华哲水蚤 Sinocalanus dorii"};

    String 水生底栖[]={"沙蚕目","霍甫水丝蚓","苏氏尾鳃蚓","泽蛭","宽身舌蛭","流粗腹摇蚊属","中国长足摇蚊","长足摇蚊","隐摇蚊","多足摇蚊","恩非摇蚊",
            "摇蚊属","库蠓","大鳌蜚","环棱螺属","纹沼螺","放逸短沟蜷","圆顶珠蚌","河蚬"};

    String 底泥[]={"弱吸附态磷（mg/kg)","铁结合态磷数量Fe-P（mg/kg)","铝结合态磷Al-P（mg/kg)",
            "有机磷数量Org-P（mg/kg)","钙结合态磷Ca-P（mg/kg)","残渣磷Res-P（mg/kg)","铜（μg/g）",
            "锌（μg/g）","镍（μg/g）","铅（μg/g）","含水率","有机质LOI","间隙水P（mg/L）","间隙水Fe（mg/L）"};

    String 水质数据[]={"水温（℃）","pH","DO   (mg/L)","CODM n   (mg/L)","CODcr (mg/L)","BOD5 (mg/L)",
            "挥发酚(ug/L)","氰化物    ( µg/L)","砷( µg/L)","汞                ( µg/L)","六价铬   (mg/L)",
            "铅           (µg/L)","镉  (µg/L)","氟离子 (mg/L)","大肠菌数(mpn/L)","NH3-N  (mg/L)","TP(mg/L)","硫化物(mg/L)",
            "石油类(mg/L)","阴离子表面活性剂(mg/L)","铜   (mg/L)","锌   (mg/L)","硒(ug/L)","TN    (mg/L)",
            "叶绿素a ( µg/L)","IPMP","IBMP","2-MIB","β-cycocitra","2,4,6-TCA","2,3,6-TCA","Geosmin",
            "2,3,4-TCA","紫罗酮"};

    String 新型烟碱类农药含量[]={"6-氯烟酸","啶虫脒","噻虫胺","噻虫啉","吡虫啉","噻虫嗪"};

    String 有机磷酸酯的含量[]={"TEP","TPrP","TiBP","TBP","TCEP","TCPP","TDCPP","TBEP","TPhP","TEHP"};

    String 磺胺类抗生素的含量[]={"SM","SMR","ST","SMZ","SD","SPD"};

    String 微囊藻毒素含量[]={"MC-LR","MC-RR"};


    public int defineLb(String sxKey,String kind) {
        String category = "";
        Map<String, String[]> map = new HashMap();

        map.put("硅藻门", 硅藻门);
        map.put("甲藻门", 甲藻门);
        map.put("金藻门", 金藻门);
        map.put("裸藻门", 裸藻门);
        map.put("蓝藻门", 蓝藻门);
        map.put("绿藻门", 绿藻门);
        map.put("隐藻门", 隐藻门);
        map.put("浮游植物", 浮游植物);
        map.put("微生物", 微生物);
        map.put("Archaea", Archaea);
        map.put("Bacteria", Bacteria);
        map.put("物种丰富度Richness", 物种丰富度Richness);
        map.put("群落内部多样性香浓指数Shannon", 群落内部多样性香浓指数Shannon);
        map.put("NULL", NULL);
        map.put("弱吸附态磷mg/kg",弱吸附态磷);
        map.put("铁结合态磷数量Fe-Pmg/kg",铁结合态磷数量);
        map.put("铝结合态磷Al-Pmg/kg",铝结合态磷);
        map.put("有机磷数量Org-Pmg/kg",有机磷数量);
        map.put("钙结合态磷Ca-Pmg/kg",钙结合态磷);
        map.put("残渣磷Res-Pmg/kg",残渣磷Res);
        map.put("铜μg/g",铜);
        map.put("锌μg/g",锌);
        map.put("镍μg/g",镍);
        map.put("铅μg/g",铅);
        map.put("含水率",含水率);
        map.put("有机质LOI",有机质LOI);
        map.put("间隙水Pmg/L",间隙水P);
        map.put("间隙水Femg/L",间隙水Fe);
        map.put("浮游动物",浮游动物);
        map.put("原生动物Protozoa",原生动物Protozoa);
        map.put("轮虫Rotifera",轮虫Rotifera);
        map.put("枝角类Cladocera",枝角类Cladocera);
        map.put("桡足类Copepoda",桡足类Copepoda);
        map.put("水生底栖",水生底栖);
        map.put("底泥",底泥);
        map.put("水质数据",水质数据);
        map.put("新型烟碱类农药含量",新型烟碱类农药含量);
        map.put("有机磷酸酯的含量",有机磷酸酯的含量);
        map.put("磺胺类抗生素的含量",磺胺类抗生素的含量);
        map.put("微囊藻毒素含量",微囊藻毒素含量);


        Iterator<Map.Entry<String, String[]>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> entry = iterator.next();
            for (String str : entry.getValue()) {
                if (sxKey.trim().toLowerCase().equals(str.trim().toLowerCase())) {
                    category = entry.getKey().trim();
                    break;
                }
            }
        }
        System.out.println("define: "+category+"====="+sxKey+"; "+kind);
//        category.contains("浮游动物")&&sxKey.toLowerßCase().trim().contains("Shannon_H".toLowerCase())&&kind.contains("生物量")
//        System.out.println( category.contains("浮游动物"));
//        System.out.println( sxKey.toLowerCase().trim().contains("Shannon_H".toLowerCase()));
//        System.out.println( kind.contains("生物量"));

        if((category.contains("浮游植物"))
                &&(sxKey.toLowerCase().trim().contains("Shannon_H".toLowerCase()))
                &&kind.contains("密度"))
            return 108;
        else if(category.contains("浮游植物")&&kind.contains("密度"))
            return 100;
        else if(category.contains("硅藻门")&&kind.contains("密度"))
            return 101;
        else if(category.contains("甲藻门")&&kind.contains("密度"))
            return 102;
        else if(category.contains("金藻门")&&kind.contains("密度"))
            return 103;
        else if(category.contains("裸藻门")&&kind.contains("密度"))
            return 105;
        else if(category.contains("蓝藻门")&&kind.contains("密度"))
            return 104;
        else if(category.contains("绿藻门")&&kind.contains("密度"))
            return 106;
        else if(category.contains("隐藻门")&&kind.contains("密度"))
            return 107;

        if((sxKey.toLowerCase().trim().contains("浮游植物生物量Shannon_H".toLowerCase())))
            return 208;
        if(category.contains("浮游植物")&&kind.contains("生物量"))
            return 200;
        if(category.contains("浮游植物")&&kind.contains("生物量"))
            return 200;
        else if(category.contains("硅藻门")&&kind.contains("生物量"))
            return 201;
        else if(category.contains("甲藻门")&&kind.contains("生物量"))
            return 202;
        else if(category.contains("金藻门")&&kind.contains("生物量"))
            return 203;
        else if(category.contains("裸藻门")&&kind.contains("生物量"))
            return 204;
        else if(category.contains("蓝藻门")&&kind.contains("生物量"))
            return 205;
        else if(category.contains("绿藻门")&&kind.contains("生物量"))
            return 206;
        else if(category.contains("隐藻门")&&kind.contains("生物量"))
            return 207;


        else if(category.contains("水生底栖")&&kind.contains("密度"))
            return 301;
        else if(category.contains("水生底栖")&&kind.contains("生物量"))
            return 302;


        else if(category.contains("微生物"))
            return 400;
        else if(sxKey.contains("物种丰富度")&&kind.contains("微生物"))
            return 400;
        else if(sxKey.toLowerCase().contains("Shannon".toLowerCase())&&kind.contains("微生物"))
            return 400;
        else if(category.contains("Archaea"))
            return 403;
        else if(category.contains("Bacteria"))
            return 404;
        else if(category.contains("NULL"))
            return 405;

        else if(category.contains("底泥"))
            return 600;

        else if(sxKey.toLowerCase().trim().contains("浮游动物生物量Shannon_H".toLowerCase()))
            return 805;
        else if(category.contains("浮游动物")&&kind.contains("密度"))
            return 700;
        else if(category.contains("原生动物")&&kind.contains("密度"))
            return 701;
        else if(category.contains("轮虫")&&kind.contains("密度"))
            return 702;
        else if(category.contains("枝角类")&&kind.contains("密度"))
            return 703;
        else if(category.contains("桡足类")&&kind.contains("密度"))
            return 704;
        else if(category.contains("浮游动物")&&kind.contains("生物量"))
            return 800;
        else if(category.contains("原生动物")&&kind.contains("生物量"))
            return 801;
        else if(category.contains("轮虫")&&kind.contains("生物量"))
            return 802;
        else if(category.contains("枝角类")&&kind.contains("生物量"))
            return 803;
        else if(category.contains("桡足类")&&kind.contains("生物量"))
            return 804;

        else if(category.contains("水质"))
            return 0;
        else if(category.contains("新型烟碱类农药含量"))
            return 1;
        else if(category.contains("有机磷酸酯的含量"))
            return 2;
        else if(category.contains("磺胺类抗生素的含量"))
            return 3;
        else if(category.contains("微囊藻毒素含量"))
            return 4;
        else return 9999;

    }


    public int defineSelfLb(String sxKey,String kind) {
        String category = sxKey;
        Map<String, String[]> map = new HashMap();

        map.put("硅藻门", 硅藻门);
        map.put("甲藻门", 甲藻门);
        map.put("金藻门", 金藻门);
        map.put("裸藻门", 裸藻门);
        map.put("蓝藻门", 蓝藻门);
        map.put("绿藻门", 绿藻门);
        map.put("隐藻门", 隐藻门);
        map.put("浮游植物", 浮游植物);
        map.put("微生物", 微生物);
        map.put("Archaea", Archaea);
        map.put("Bacteria", Bacteria);
        map.put("物种丰富度Richness", 物种丰富度Richness);
        map.put("群落内部多样性香浓指数Shannon", 群落内部多样性香浓指数Shannon);
        map.put("NULL", NULL);
        map.put("弱吸附态磷mg/kg",弱吸附态磷);
        map.put("铁结合态磷数量Fe-Pmg/kg",铁结合态磷数量);
        map.put("铝结合态磷Al-Pmg/kg",铝结合态磷);
        map.put("有机磷数量Org-Pmg/kg",有机磷数量);
        map.put("钙结合态磷Ca-Pmg/kg",钙结合态磷);
        map.put("残渣磷Res-Pmg/kg",残渣磷Res);
        map.put("铜μg/g",铜);
        map.put("锌μg/g",锌);
        map.put("镍μg/g",镍);
        map.put("铅μg/g",铅);
        map.put("含水率",含水率);
        map.put("有机质LOI",有机质LOI);
        map.put("间隙水Pmg/L",间隙水P);
        map.put("间隙水Femg/L",间隙水Fe);
        map.put("浮游动物",浮游动物);
        map.put("原生动物Protozoa",原生动物Protozoa);
        map.put("轮虫Rotifera",轮虫Rotifera);
        map.put("枝角类Cladocera",枝角类Cladocera);
        map.put("桡足类Copepoda",桡足类Copepoda);
        map.put("水生底栖",水生底栖);
        map.put("底泥",底泥);
        map.put("水质数据",水质数据);
        map.put("新型烟碱类农药含量",新型烟碱类农药含量);
        map.put("有机磷酸酯的含量",有机磷酸酯的含量);
        map.put("磺胺类抗生素的含量",磺胺类抗生素的含量);
        map.put("微囊藻毒素含量",微囊藻毒素含量);

        System.out.println("category:" + category);

        if((category.contains("浮游植物"))
                &&(sxKey.toLowerCase().trim().contains("Shannon_H".toLowerCase()))
                &&kind.contains("密度"))
            return 108;
        else if(category.contains("浮游植物")&&kind.contains("密度"))
            return 100;
        else if(category.contains("硅藻门")&&kind.contains("密度"))
            return 101;
        else if(category.contains("甲藻门")&&kind.contains("密度"))
            return 102;
        else if(category.contains("金藻门")&&kind.contains("密度"))
            return 103;
        else if(category.contains("裸藻门")&&kind.contains("密度"))
            return 105;
        else if(category.contains("蓝藻门")&&kind.contains("密度"))
            return 104;
        else if(category.contains("绿藻门")&&kind.contains("密度"))
            return 106;
        else if(category.contains("隐藻门")&&kind.contains("密度"))
            return 107;

        if((sxKey.toLowerCase().trim().contains("浮游植物生物量Shannon_H".toLowerCase())))
            return 208;
        if(category.contains("浮游植物")&&kind.contains("生物量"))
            return 200;
        if(category.contains("浮游植物")&&kind.contains("生物量"))
            return 200;
        else if(category.contains("硅藻门")&&kind.contains("生物量"))
            return 201;
        else if(category.contains("甲藻门")&&kind.contains("生物量"))
            return 202;
        else if(category.contains("金藻门")&&kind.contains("生物量"))
            return 203;
        else if(category.contains("裸藻门")&&kind.contains("生物量"))
            return 204;
        else if(category.contains("蓝藻门")&&kind.contains("生物量"))
            return 205;
        else if(category.contains("绿藻门")&&kind.contains("生物量"))
            return 206;
        else if(category.contains("隐藻门")&&kind.contains("生物量"))
            return 207;


        else if(category.contains("水生底栖")&&kind.contains("密度"))
            return 301;
        else if(category.contains("水生底栖")&&kind.contains("生物量"))
            return 302;


        else if(category.contains("微生物"))
            return 400;
        else if(sxKey.contains("物种丰富度")&&kind.contains("微生物"))
            return 400;
        else if(sxKey.toLowerCase().contains("Shannon".toLowerCase())&&kind.contains("微生物"))
            return 400;
        else if(category.contains("Archaea"))
            return 403;
        else if(category.contains("Bacteria"))
            return 404;
        else if(category.contains("NULL"))
            return 405;

        else if(category.contains("底泥"))
            return 600;

        else if(sxKey.toLowerCase().trim().contains("浮游动物生物量Shannon_H".toLowerCase()))
            return 805;
        else if(category.contains("浮游动物")&&kind.contains("密度"))
            return 700;
        else if(category.contains("原生动物")&&kind.contains("密度"))
            return 701;
        else if(category.contains("轮虫")&&kind.contains("密度"))
            return 702;
        else if(category.contains("枝角类")&&kind.contains("密度"))
            return 703;
        else if(category.contains("桡足类")&&kind.contains("密度"))
            return 704;
        else if(category.contains("浮游动物")&&kind.contains("生物量"))
            return 800;
        else if(category.contains("原生动物")&&kind.contains("生物量"))
            return 801;
        else if(category.contains("轮虫")&&kind.contains("生物量"))
            return 802;
        else if(category.contains("枝角类")&&kind.contains("生物量"))
            return 803;
        else if(category.contains("桡足类")&&kind.contains("生物量"))
            return 804;

        else if(category.contains("水质"))
            return 0;
        else if(category.contains("新型烟碱类农药含量"))
            return 1;
        else if(category.contains("有机磷酸酯的含量"))
            return 2;
        else if(category.contains("磺胺类抗生素的含量"))
            return 3;
        else if(category.contains("微囊藻毒素含量"))
            return 4;
        else return 9999;

    }


}
