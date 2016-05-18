# hazelcast-shell-spring-boot-starter
hazelcast shell command for spring-boot-starter-remote-shell

# Including it in your project

Maven dependency:

```xml
<dependency>
  <groupId>it.uliana.hazelcastshell</groupId>
  <artifactId>hazelcast-shell</artifactId>
  <version>0.0.6</version>
</dependency>
```

## Usage

Connect to the remote shell [guide](http://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-remote-shell.html#production-ready-connecting-to-the-remote-shell)


```
ssh user@localhost -p 2000

> hazelcast list

> hazelcast get MY_KEY

> hazelcast clear
```

## Example

![hazelcast](http://i.imgur.com/QHPvtCH.gif)
