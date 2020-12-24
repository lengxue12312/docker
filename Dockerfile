FROM openjdk:8

ADD pom.xml /tmp/build/

ADD src /tmp/build/src
        #构建应用
RUN cd /tmp/build && mvn clean package \
        #拷贝编译结果到指定目录
        && mv target/*.war /app.war \
        #清理编译痕迹
        && cd / && rm -rf /tmp/build
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java","-war","/app.war"]