# Asgard 项目上下文文档

## 项目概述

**Asgard** 是一个多模块 Maven 项目，用于学习和实践各种 Java 技术。项目采用北欧神话命名约定，每个模块代表一个不同的学习领域。

### 技术栈
- **Java**: 1.8
- **构建工具**: Maven 3.x
- **测试框架**: JUnit 4.13.1
- **Spring Framework**: 5.3.30
- **Spring Security**: 5.4.6
- **MyBatis**: 3.5.6
- **Log4j2**: 2.23.1
- **Guava**: 33.4.8-jre
- **MySQL Connector**: 8.0.18
- **Redis**: Jedis 3.2.0, Redisson 3.13.6

## 模块结构

```
asgard/
├── asgard-common/          # 通用工具类和共享组件
├── asgard-algo/            # 算法练习（LeetCode、数据结构）
├── asgard-pattern/         # 设计模式学习
├── asgard-thor/            # Spring Framework 学习
│   ├── asgard-thor-model/
│   ├── asgard-thor-mysql/
│   ├── asgard-thor-service/
│   └── asgard-thor-web/
├── asgard-frigg/           # MyBatis 学习
│   ├── asgard-frigg-model/
│   └── asgard-frigg-mysql/
├── asgard-loki/            # 实验性测试和验证
│   ├── asgard-loki-model/
│   ├── asgard-loki-mysql/
│   ├── asgard-loki-service/
│   └── asgard-loki-web/
├── asgard-underlying/      # 底层 Java 学习（JVM、JUC）
└── arsgard-loki/           # 额外的 Loki 模块
    └── arsgard-loki-service/
```

### 模块说明

| 模块 | 用途 |
|------|------|
| `asgard-common` | 通用工具类、HTTP 客户端、JSON 序列化、布隆过滤器等 |
| `asgard-algo` | LeetCode 算法题、数据结构实现、排序算法 |
| `asgard-pattern` | 设计模式实现（单例、策略、观察者、工厂、装饰器等） |
| `asgard-thor` | Spring Framework 学习（AOP、IoC、Web MVC） |
| `asgard-frigg` | MyBatis 持久层框架学习 |
| `asgard-loki` | 各种实验性代码和验证测试 |
| `asgard-underlying` | JVM  internals、JUC 并发包等底层学习 |

## 构建和运行命令

### 构建整个项目
```bash
mvn clean install
```

### 构建特定模块
```bash
mvn clean install -pl asgard-common
mvn clean install -pl asgard-thor
```

### 运行测试
```bash
# 运行所有测试
mvn test

# 运行特定模块的测试
mvn test -pl asgard-algo

# 运行单个测试类
mvn test -Dtest=Problem1Test -pl asgard-algo
```

### 跳过测试构建
```bash
mvn clean install -DskipTests
```

## 代码组织约定

### 命名规范
- **算法题**: 按问题编号命名，如 `Problem1.java`, `Problem141.java`
- **测试类**: 与主类名对应，添加 `Test` 后缀，如 `Problem1Test.java`
- **工具类**: 以 `Util` 结尾，如 `HttpUtil`, `GsonUtil`

### 包结构
- 基础包名：`com.will.asgard`
- 各模块子包：`asgard.algo`, `asgard.common`, `asgard.pattern` 等

### 依赖管理
- 父 POM 统一管理所有依赖版本
- 大多数模块依赖 `asgard-common` 获取共享工具
- `asgard-loki` 和 `asgard-frigg` 依赖 MyBatis 进行数据库访问

## 主要依赖版本

| 依赖 | 版本 |
|------|------|
| Spring Framework | 5.3.30 |
| Spring Security | 5.4.6 |
| Spring Cloud (OpenFeign) | 2.2.6.RELEASE |
| MyBatis | 3.5.6 |
| MyBatis Spring Boot | 2.1.4 |
| Log4j2 | 2.23.1 |
| Guava | 33.4.8-jre |
| Gson | 2.10.1 |
| Lombok | 1.18.10 |
| JUnit | 4.13.1 |
| MySQL Connector | 8.0.18 |
| Redisson | 3.13.6 |

## 开发注意事项

1. **Java 版本**: 项目使用 Java 1.8，确保编译环境一致
2. **编码**: 所有文件使用 UTF-8 编码
3. **Lombok**: 项目使用 Lombok 简化代码，IDE 需安装相应插件
4. **日志**: 使用 Log4j2，配置异步日志（Disruptor）
5. **Web 模块**: 部分模块打包为 WAR，使用传统 `web.xml` 配置

## 常用工具类 (asgard-common)

- `HttpUtil`: HTTP 客户端工具
- `GsonUtil`: JSON 序列化/反序列化
- `GuavaBloomFilter`: 布隆过滤器实现
- 日期、图片、视频处理工具
- 随机数生成工具
