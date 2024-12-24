package com.yangyang.cloud.entities;


import lombok.Data;

@Data
public class CategoryDto {

    private String type;              // 分类类型（任务、财务）
    private String name;              // 分类名称（如工作、娱乐、餐饮等）
}
