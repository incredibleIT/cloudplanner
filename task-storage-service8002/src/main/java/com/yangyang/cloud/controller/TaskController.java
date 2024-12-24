package com.yangyang.cloud.controller;


import com.yangyang.cloud.entities.Task;
import com.yangyang.cloud.entities.TaskDto;
import com.yangyang.cloud.response.ResultData;
import com.yangyang.cloud.service.TaskService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
public class TaskController {
    @Resource
    private TaskService taskService;

    /**
     *查询所有任务
     * */
    @GetMapping("/list")
    public ResultData<List<Task>> taskList() {
//        List<TaskDto> taskDtoList = taskService.list().stream().map(task -> {
//            TaskDto taskDto = new TaskDto();
//            BeanUtils.copyProperties(task, taskDto);
//            return taskDto;
//        }).collect(Collectors.toList());

        System.out.println(taskService.list());

        return ResultData.success(taskService.list());
    }
    /**
     *
     * 查询某个id的任务
     * */
    @GetMapping("/taskInfo")
    public ResultData<TaskDto> taskInfo(@RequestParam("id") Integer id) {

        Task task = taskService.getById(id);
        if (task == null) {
            throw new RuntimeException("无查询结果");
        } else {
            TaskDto taskDto = new TaskDto();
            BeanUtils.copyProperties(task, taskDto);
            return ResultData.success(taskDto);
        }
    }

    /**
     *
     * 添加任务
     *
     */
    @PostMapping("/add")
    public ResultData<String> addTask(@RequestBody TaskDto taskDto) {
        Task task = new Task();
        BeanUtils.copyProperties(taskDto, task);
        taskService.save(task);
        return ResultData.success("存储成功");
    }

    /**
     *
     * 修改任务
     */
    @PutMapping("/update")
    public ResultData<String> updateTask(@RequestBody TaskDto taskDto) {
        Task task = new Task();
        BeanUtils.copyProperties(taskDto, task);
        System.out.println(taskDto);
        System.out.println(task);
        taskService.updateById(task);
        return ResultData.success("修改成功");
    }

    @DeleteMapping("/del/{id}")
    public ResultData<String> delTask(@PathVariable("id") Integer id) {
        taskService.removeById(id);
        return ResultData.success("成功移除");
    }
}
