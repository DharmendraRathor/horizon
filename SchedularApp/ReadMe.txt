DESCRIPTION

Spring boot application uses circular priority blocking queue to run set of task. 
Next task to run will be picked from priority queue based on time in Task. 

Each task can be used to do business logic and send data to Kafka topic.



STEPS TO RUN APPLICATION

1. Installed kafka from following site
https://kafka.apache.org/quickstart

2. “QuickStart” section has steps to install and run Zookeeper and kafka.

3. Once Kafka and zookeeper is up , create topic using following commond.

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test

4. check topic is created using following command
bin/kafka-topics.sh --list --zookeeper localhost:2181

5. Start consumer 
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning

6. Run Application
	6.1 Using command line

	Go to 	/myProjects/SchedularApp
	mvn package
	mvn spring-boot:run


	6.2 Using eclipse.
	
	Right click on MainApplication.java
	Run As > Java Application. 







