package com.spring.e0723.repository;

import com.spring.e0723.entity.Article;
import com.spring.e0723.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{

    @Override
    Iterable<Member> findAll();
}
