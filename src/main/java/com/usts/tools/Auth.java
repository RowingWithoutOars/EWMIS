package com.usts.tools;

import java.util.ArrayList;
import java.util.HashMap;

public class Auth {

    public static HashMap<String,ArrayList<Integer>> getAuth(){
        HashMap<String,ArrayList<Integer>> auth = new HashMap<>();
        ArrayList<Integer> fyzwlist = new ArrayList<>();
        Integer []fyzw = {200,201,202,203,204,204,205,206,207,100,101,102,103,104,105,106,107};
        for (Integer i:fyzw){
            fyzwlist.add(i);
        }
        auth.put("fyzw",fyzwlist);

        ArrayList<Integer> fydwlist = new ArrayList<>();
        Integer []fydw = {700,701,702,703,704,800,801,802,803,804};
        for (Integer i:fydw){
            fydwlist.add(i);
        }
        auth.put("fydw",fydwlist);

        ArrayList<Integer> dqlist = new ArrayList<>();
        Integer []dq = {300,301,302};
        for (Integer i:dq){
            dqlist.add(i);
        }
        auth.put("dq",dqlist);

        ArrayList<Integer> wswlist = new ArrayList<>();
        Integer []wsw = {400,401,402,403,404};
        for (Integer i:wsw){
            wswlist.add(i);
        }
        auth.put("wsw",wswlist);
        ArrayList<Integer> dnlist = new ArrayList<>();
        Integer []dn = {600};
        for (Integer i:dn){
            dnlist.add(i);
        }
        auth.put("dn",dnlist);

        ArrayList<Integer> szlist = new ArrayList<>();
        Integer []sz = {0,1,2,3,4};
        for (Integer i:sz){
            szlist.add(i);
        }
        auth.put("other",szlist);
        return auth;
    }
}
