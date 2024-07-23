# CI Project
This project is about continuous integration of simple Java Hello World application using Git&GitHub, Jenkins, Nexus, SonarQube and Slack.

- Developer commits and pushes code into SCM(GitHub), Jenkins will check the code using the webhook feature. If anything fails, it will trigger a notification to the Slack channel.
- Once the code is checked out into Jenkins, it will test the code and build the jar file using the Maven build tool. If anything fails, it will trigger a notification to the Slack channel.
- The sonar scanner will analyse the code and share the report with the SonarQube server.
- The SonarQube server will perform the code's quality gate, if anything fails, it will trigger a notification to the Slack channel.
- If quality gates are passed, the package will be stored in the repository, here I am using the Nexus repository. If the build fails, it will trigger a notification to the Slack channel.
