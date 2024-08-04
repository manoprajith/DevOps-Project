FROM openjdk:11
WORKDIR /DevOps
COPY . /DevOps
ENTRYPOINT ["java", "-jar"]
CMD ["App.java"]
