package com.api.fisher.repository;

import com.api.fisher.domain.Domain;
import com.api.fisher.domain.QDomain;
import com.api.fisher.dto.Request;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ApiRepository extends JpaRepository<Domain,Long>, QuerydslPredicateExecutor<Domain> {

    public default Predicate makePredicate(Request request){
        BooleanBuilder builder = new BooleanBuilder();
        QDomain domain = QDomain.domain;

        builder.and(domain.id.gt(0));
        if(request.getType().contains("place")){
            builder.and(domain.rdnmadr.like("%" + request.getPlace() +"%").or(domain.lnmadr.like("%" + request.getPlace() +"%")));
        }
        if(request.getType().contains("detail"))
            builder.and(domain.rdnmadr.like("%"+request.getPlace2()+"%").or(domain.lnmadr.like("%"+request.getPlace2()+"%")));
        if(request.getType().contains("fish"))
            builder.and(domain.kdfsh.like("%" + request.getFish()+ "%"));
        if(request.getType().contains("type"))
            builder.and(domain.fshlcType.like("%" + request.getFisherType()+"%"));
        if(request.getType().contains("name"))
            builder.and(domain.fshlcNm.like("%"+request.getName()+"%"));

        System.out.println(builder.getValue());
        System.out.println(builder);
        return builder;
    }
}
