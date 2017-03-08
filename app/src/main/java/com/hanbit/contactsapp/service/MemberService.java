package com.hanbit.contactsapp.service;

import com.hanbit.contactsapp.domain.MemberBean;

import java.util.List;

/**
 * Created by hb2004 on 2017-03-08.
 */

public interface MemberService {
    public void creat(MemberBean bean);
    public MemberBean findByName(MemberBean bean);
    public List<MemberBean> finbBySome(MemberBean bean);
    public List<MemberBean> findAll(MemberBean bean);
    public void update(MemberBean bean);
    public void delete(MemberBean bean);
}
