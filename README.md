# 项目信息

<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=false} -->

<!-- code_chunk_output -->

- [项目信息](#项目信息)
  - [introduce](#introduce)
  - [server port program](#server-port-program)
    - [geteway-server01](#geteway-server01)
    - [order-server01-8090](#order-server01-8090)
    - [rocketmq-server01](#rocketmq-server01)
    - [server-sentinel01-8070](#server-sentinel01-8070)
    - [user-server01](#user-server01)
    - [nacos-server01-8050](#nacos-server01-8050)

<!-- /code_chunk_output -->

## introduce

this repository organizes the versions of commonly used components in the spring cloud alibaba ecosystem

* **integrate version**
  * **spring boot**: 2.2.5.RELEASE
  * **spring-cloud-dependencies**: Hoxton.SR4
  * **spring-cloud-alibaba-dependencies**: 2.2.1.RELEASE
  * **openfeign**: 2.2.1.RELEASE
  * **gateway**: 2.2.2.RELEASE
  * **Nacos**: 2.2.1.RELEASE
  * **Sentinel**: 2.2.1.RELEASE
  * **RocketMQ**: 2.0.3
  * **dubbo**: 2.2.1.RELEASE
  * **Seata**: 
  * **spring-security**:

* **reference**
  * [spring cloud alibaba version](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)

## server port program

### geteway-server01

* port:8040

### order-server01-8090

* port:8090
* server-name: order-server01-8090

### rocketmq-server01

* port:9000

### server-sentinel01-8070

* port: 8070
* server-name: sentinel01-server-8070

### user-server01

* port:8085

### nacos-server01-8050

* port:8085
* server-name: nacos-server01-8050