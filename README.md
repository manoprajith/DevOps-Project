# DevOps-Project
This project is about Continous Integration using Git&GitHub, Jenkins, Nexus, SonarQube and Slack.

- Developer commits and push code into SCM(GitHub), Jenkins will checkout the code by using webhook feature. If anything is failed, it will trigger the notification to Slack channel.
- Once code is checkedout into jenkins, it will run the testcase, if anything is failed, it will trigger the notification to Slack channel. If it is passed it will move to sonarscanner which is checkstyle.
- Checkstyle will analysis the code and share the report to SonarQube server.
- SonarQube server will perform the quality gate for the code and if anything is failed, it will trigger the notification to Slack channel.
- If quality gates are passed, it will build the project using Maven build tool and store it in repository, here I am using Nexus repository which is sonatype. Here if build is failed, it will trigger the notification to Slack channel.
*******************************************************