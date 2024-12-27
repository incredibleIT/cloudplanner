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


登录校验: SpringSecurity

登录过程:  
          1. 自定义登录接口, 自定义接口中调用ProviderManager的方法进行认证, 认证通过生成Token, 将登录信息存入缓存层  √
          2. 自定义UserDetailService实现, 在其中查询数据库信息  √

校验过程: 
          1. 定义Token校验过滤器(获取Token, 解析Token获取uid, 从缓存层查uid对应的用户信息, 存入SecurityContextHolder)
