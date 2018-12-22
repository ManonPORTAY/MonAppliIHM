package com.example.portay_m.monappliihm;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static DataManager INSTANCE;


    private List<String> nameList;

        private DataManager(){
            nameList = new ArrayList<>();
        }

        static public DataManager getInstance()
        {
            if(INSTANCE == null){
                INSTANCE = new DataManager();
            }
            return INSTANCE;
        }


    public List<String> getNameList() {
        return nameList;
    }

    public void addName(String name)
    {
        nameList.add(name);
    }

}
