package com.noriteo.delinori.security.mapper;

import com.noriteo.delinori.security.domain.Member;

public interface MemberMapper {

   Member findById(String mid);
}
