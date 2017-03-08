package com.hanbit.contactsapp.dao;

import com.hanbit.contactsapp.domain.MemberBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2004 on 2017-03-08.
 */

public class MemberDao {
    public void insert(MemberBean bean){

    };
    public MemberBean selectOne(MemberBean bean) {
    MemberBean member=new MemberBean();
        return member;
    };
    public List<MemberBean> selectSome(MemberBean bean){
    List<MemberBean> some=new ArrayList<>();
        return some;
    };
    public List<MemberBean> selectAll(MemberBean bean){
    List<MemberBean> list=new ArrayList<>();
        return list;
    };
    public void update(MemberBean bean){};
    public void delete(MemberBean bean){};




}
