package com.ohgiraffers.associationmapping.section02.onetomany;

import com.ohgiraffers.associationmapping.section01.manytoone.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OneToManyService {

    @Autowired
    private OneToManyRepository oneToManyRepository;

    @Transactional(readOnly = true)
    public Category findCategory(int categoryCode) {

        Category category = oneToManyRepository.find(categoryCode);

        return category;
    }
}