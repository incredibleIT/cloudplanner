package com.yangyang.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangyang.cloud.entities.Category;
import com.yangyang.cloud.mapper.CategoryMapper;
import com.yangyang.cloud.service.CategoryService;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
