# demo

## Project Structure
``` 
demo
-- src # project code root path
   -- main
      -- java
	     -- com
		    -- example
			   -- demo
			      -- controller
				     -- DemoController.java
				  -- service
				     -- impl
					    -- DemoServiceImpl.java
					 -- DemoService.java
				  -- DemoApplication.java
	  -- resources
	     -- static
		    -- bootstrap
			-- js
			-- css
		 -- templates
		    -- index.html
		 -- application.properties
   -- test
      -- java
	     -- com
		    -- example
			   -- demo
			      -- DemoServiceTest.java
-- pom.xml # project dependencies
``` 

## Operation Instruction
```
# clone 代码
git clone https://github.com/dongjinnan/demo.git

# 配置jdk 1.8
# 配置maven
# maven build
# springboot:run DemoApplication.java

# 浏览器访问http://localhost:8080/index/

# 城市的配置文件为：application.properties中的city属性，以“,”分隔
```