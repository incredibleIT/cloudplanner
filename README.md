任务提交微服务task-submission-service(Consumer) -> 任务存储微服务task-storage-service(Producer)集群

全局组件共享(global-commons)

数据库表信息:  
    用户表 -> user, 用户的基本信息 
    任务表 -> task, 用户所定义的任务信息
    财务表 -> finance_record, 用户的流水账单信息
    分类表 -> category, 用户定义任务或财务记录所属的类别

实体类 -> entities
    User
    Task
    FinanceRecord
    Category