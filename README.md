# spring-security-demo

spring seccurity demo
   dao 使用少量hibernate
   
   
项目部署步骤
1.mysql数据库sec:运行sec.sql
2.maven配置jar包
3.运行http://yourip:youport/spring-security-demo/
4.用户列表： 用户名     密码
            admin     admin
            zhangsan  admin
            lisi      admin



项目解析：
  1.CustomUserDetailsService 加载用户信息；
    跟据username获取用户的用户名，密码和用户角色
  2.MyFilterSecurityInterceptor访问拦截器,用来确定公湖是否有权限访问当前url
  3.MyInvocationSecurityMetadataSourceService加载所有的资源信息即所有的url和role,并且将所有的url和角色对应（resourceMap）;
    当启动时进行加载
  4.MyAccessDecisionManager访问决策器 根据当前url的要求所有角色和当前用户的角色惊醒比较判断是否允许访问资源
  
  
