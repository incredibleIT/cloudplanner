package com.yangyang.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangyang.cloud.entities.Task;
import com.yangyang.cloud.mapper.TaskMapper;
import com.yangyang.cloud.service.TaskService;
import org.springframework.stereotype.Service;


@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {
}
