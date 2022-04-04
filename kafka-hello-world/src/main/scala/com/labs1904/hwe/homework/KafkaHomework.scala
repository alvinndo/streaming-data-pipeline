package com.labs1904.hwe.homework

import java.time.Duration
import java.util.{Arrays, Properties, UUID}

import net.liftweb.json.DefaultFormats
import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord, ConsumerRecords, KafkaConsumer}
import org.apache.kafka.common.serialization.StringDeserializer

object KafkaHomework {
  /**
   * Your task is to try to understand this code and run the consumer successfully. Follow each step below for completion.
   * Implement all the todos below
   */

    //TODO: If these are given in class, change them so that you can run a test. If not, don't worry about this step
  val BootstrapServer = "change-me"
  val Topic: String = "change-me"

  implicit val formats: DefaultFormats.type = DefaultFormats

  def main(args: Array[String]): Unit = {

    // Create the KafkaConsumer
    //TODO: Write in a comment what these lines are doing. What are the properties necessary to instantiate a consumer?
    val properties = getProperties(BootstrapServer) // Configuring Kafka property by defining the Bootstrap server name
    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](properties) // Instantiating a Kafka consumer to be connected to the Bootstrap server


    //TODO: What does this line mean? Write your answer in a comment below
    consumer.subscribe(Arrays.asList(Topic)) // This line is allowing the consumer to be subscribed to a topic. Possibly allowing it to receive data from the partitions?

    while (true) {
      // TODO: Change this to be every 5 seconds
      val duration: Duration = Duration.ofMillis(5000) // Changed from 100 to 5000 ms

      //TODO: Look up the ConsumerRecords class below, in your own words what is the class designed to do?
      val records: ConsumerRecords[String, String] = consumer.poll(duration) // The ConsumerRecords class is designed to hold a list of consumer records per partition for a particular topic.
      // The ConsumerRecord class is a key/value pair, and it also consists of a topic name and partition number

      records.forEach((record: ConsumerRecord[String, String]) => {
        // Retrieve the message from each record
        //TODO: Describe why we need the .value() at the end of record
        val message = record.value() // We need the value because each record is stored as a key/value pair within the ConsumerRecord class. The key holds which partition the record is located in, and the value contains the information on the data.

        //TODO: If you were given the values for the bootstrap servers in class, run the app with the green play button and make sure it runs successfully. You should see message(s) printing out to the screen
        println(s"Message Received: $message")
      })
    }
  }

  def getProperties(bootstrapServer: String): Properties = {
    // Set Properties to be used for Kafka Consumer
    val properties = new Properties
    properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer)
    properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
    properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString)

    properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
    properties
  }

}
