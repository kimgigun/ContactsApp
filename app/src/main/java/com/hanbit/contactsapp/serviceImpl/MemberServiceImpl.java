package com.hanbit.contactsapp.serviceImpl;

import com.hanbit.contactsapp.domain.MemberBean;
import com.hanbit.contactsapp.service.MemberService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2004 on 2017-03-08.
 */

public class MemberServiceImpl implements MemberService{
    @Override
    public void creat(MemberBean bean) {

    }

    @Override
    public MemberBean findByName(MemberBean bean) {
        MemberBean member=new MemberBean();
        return member;
    }

    @Override
    public List<MemberBean> finbBySome(MemberBean bean) {
        List<MemberBean> some=new ArrayList<>();
        return some;
    }

    @Override
    public List<MemberBean> findAll(MemberBean bean) {
        List<MemberBean> list=new ArrayList<>();
        return list;
    }


    @Override
    public void update(MemberBean bean) {

    }

    @Override
    public void delete(MemberBean bean) {

    }
}
