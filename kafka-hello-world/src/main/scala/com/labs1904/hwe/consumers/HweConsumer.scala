package com.labs1904.hwe.consumers

import com.labs1904.hwe.producers.SimpleProducer
import com.labs1904.hwe.util.Util
import com.labs1904.hwe.util.Util.getScramAuthString
import net.liftweb.json.DefaultFormats
import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord, ConsumerRecords, KafkaConsumer}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.common.serialization.StringDeserializer

import java.time.Duration
import java.util.{Arrays, Properties, UUID}
case class RawUser(id: Int, name: String, email: String)
case class EnrichedUser(id: Int, numberAsWord: String, name: String, email: String, hweDeveloper: String)

object HweConsumer {
  val BootstrapServer : String = "CHANGE-ME"
  val consumerTopic: String = "question-1"
  val producerTopic: String = "question-1-output"
  val username: String = "CHANGE-ME"
  val password: String = "CHANGE-ME"
  //Use this for Windows
  //val trustStore: String = "src\\main\\resources\\kafka.client.truststore.jks"
  //Use this for Mac
  val trustStore: String = "src/main/resources/kafka.client.truststore.jks"

  implicit val formats: DefaultFormats.type = DefaultFormats

  def main(args: Array[String]): Unit = {

    // Create the KafkaConsumer
    val consumerProperties = SimpleConsumer.getProperties(BootstrapServer)
    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](consumerProperties)

    // Create the KafkaProducer
    val producerProperties = SimpleProducer.getProperties(BootstrapServer)
    val producer = new KafkaProducer[String, String](producerProperties)

    // Subscribe to the topic
    consumer.subscribe(Arrays.asList(consumerTopic))

    while ( {
      true
    }) {
      // poll for new data
      val duration: Duration = Duration.ofMillis(100)
      val records: ConsumerRecords[String, String] = consumer.poll(duration)

      records.forEach((record: ConsumerRecord[String, String]) => {
        // Retrieve the message from each record
        val message = record.value()
        //println(s"Message Received: $message")
        // TODO: Add business logic here!
        /*
        RawUser
         */
        // Splitting messages from comma
        val user = message.split(",").map(u => u.trim)
        val id: Int = user(0).toInt
        val name: String = user(1)
        val email: String = user(2)

        // Creating new RawUser instances
        val rawUserLog = new RawUser(id, name, email)

        //println("Message Received: " + rawUserLog.id + " " + rawUserLog.name + " " + rawUserLog.email)

        /*
        EnrichedUser
         */
        val numAsWord = Util.mapNumberToWord(id)

        val enrichedUserLog = new EnrichedUser(id, numAsWord, name, email, "Alvin Do")

        //println(s"Message Received: ${enrichedUserLog.id}, ${enrichedUserLog.numberAsWord}, ${enrichedUserLog.name}, ${enrichedUserLog.email}, ${enrichedUserLog.hweDeveloper}")

        /*
        Producer
         */
        val enrichedRecord = s"${enrichedUserLog.id},${enrichedUserLog.numberAsWord},${enrichedUserLog.name},${enrichedUserLog.email},${enrichedUserLog.hweDeveloper}"
        producer.send(new ProducerRecord[String, String](producerTopic, enrichedRecord))

        println(s"Sent record: $enrichedRecord")

      })
    }
    producer.close()
  }
}