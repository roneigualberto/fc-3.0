package main

import (
	"log"

	"github.com/confluentinc/confluent-kafka-go/kafka"
)

func main() {
	producer := NewKafkaProducer()

	Publish("Message", "teste", producer, nil)

	producer.Flush(1000)

}

func NewKafkaProducer() *kafka.Producer {
	configMap := &kafka.ConfigMap{
		"bootstrap.servers": "fc2-kafka_kafka_1:9092",
	}

	p, err := kafka.NewProducer(configMap)

	if err != nil {
		log.Println(err.Error())
	}

	return p
}

func Publish(msg string, topic string, producer *kafka.Producer, key []byte) error {
	message := &kafka.Message{
		Value:          []byte(msg),
		TopicPartition: kafka.TopicPartition{Topic: &topic, Partition: kafka.PartitionAny},
		Key:            key,
	}

	return producer.Produce(message, nil)

}
