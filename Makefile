run:
	mvn spring-boot:run

env-up:
	docker-compose up -d

env-down:
	docker-compose down

consumer:
	kafka-console-consumer --bootstrap-server localhost:9092 \
		--topic strings-processed \
		--from-beginning \
		--formatter kafka.tools.DefaultMessageFormatter \
		--property print.key=false \
		--property print.value=true \
		--property value.deserializer=org.apache.kafka.common.serialization.StringDeserializer

producer:
	kafka-console-producer --bootstrap-server localhost:9092 \
		--property value.serializer=org.apache.kafka.common.serialization.ByteArraySerializer \
 		--topic strings
