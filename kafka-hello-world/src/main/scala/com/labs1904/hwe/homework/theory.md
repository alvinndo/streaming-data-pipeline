# Overview

Kafka has many moving pieces, but also has a ton of helpful resources to learn available online. In this homework, your
challenge is to write answers that make sense to you, and most importantly, **in your own words!**
Two of the best skills you can get from this class are to find answers to your questions using any means possible, and to
reword confusing descriptions in a way that makes sense to you. 

### Tips
* You don't need to write novels, just write enough that you feel like you've fully answered the question
* Use the helpful resources that we post next to the questions as a starting point, but carve your own path by searching on Google, YouTube, books in a library, etc to get answers!
* We're here if you need us. Reach out anytime if you want to ask deeper questions about a topic 
* This file is a markdown file. We don't expect you to do any fancy markdown, but you're welcome to format however you like

### Your Challenge
1. Create a new branch for your answers 
2. Complete all of the questions below by writing your answers under each question
3. Commit your changes and push to your forked repository

## Questions
#### What problem does Kafka help solve? Use a specific use case in your answer 
* Helpful resource: [Confluent Motivations and Use Cases](https://youtu.be/BsojaA1XnpM)

```
Kafka helps solve static, high-latency batch systems to distribute real-time event 
driven data to consumers. 

In one of the examples given in the video, the host mentions banking systems where many 
are still using old traditional systems that capture states of data. This data gets 
updated in batches, which is why it takes several days for your bank account to update 
after sending or receiving money transfers. New, modern banking systems are transition 
to event driven data systems to receive updated data in real-time.
```
#### What is Kafka?
* Helpful resource: [Kafka in 6 minutes](https://youtu.be/Ch5VhJzaoaI) 

```
Kafka is a distributed and scalable system that provides real-time data streams to
consumers from various sources. 
```
#### Describe each of the following with an example of how they all fit together: 
 * Topic 
```
A grouping of partitions that handle the same type of data. Whether it's one
partition or one-hundred partitions, they are all a part of one topic if data
received from the producer are the same.
```
 * Producer 
```
The process that reads updates from various sources and writes them onto a queue.
The process "produces" the updates onto the queue. If the queue is a part of
several other partitions, then producer feeds into the topic of partitions.
```
 * Consumer
```
The down-stream data process from the queue that gets displayed to end-users.
The consumers "consume" the updates from the queue that gets produced from the producer,
and displays that data.
```
 * Broker
```
A server that holds one or more partitions. A partition is handled by a designated
broker to allow data to be run in parallel.
```
 * Partition
```
Each number of queues holding the steaming data written in by the producer. These
partitions are held within a broker server that allows the data streams to be run
in parallel.
```

#### Describe Kafka Producers and Consumers
```
Kafka producers reads updates from various sources and writes them onto a queue or
partition. For each record in the partition, the down-stream data gets presented to
the consumers (the end-users) needing the data. 
```

#### How are consumers and consumer groups different in Kafka? 
* Helpful resource: [Consumers](https://youtu.be/lAdG16KaHLs)
* Helpful resource: [Confluent Consumer Overview](https://youtu.be/Z9g4jMQwog0)

```
Consumers are client applications (end-users) that are are typically a part of a consumer group. 
A consumer group is simply a grouping of one or more consumers, where the only 
restriction is that there cannot be more consumers than number of partitions. 
```
#### How are Kafka offsets different than partitions? 
```
Kafka offets are simply "checkpoints" within the partition where if the consumer
process dies, it will start back where it left off when it comes back - starting at
the offset.

Partitions are simply multiple queues of data running in parallel from the
producer to consumer.
```

#### How is data assigned to a specific partition in Kafka? 
```
Data is assigned automatically by Kafka based on a key/value pair. Kafka assigns data
a key and the data with its key will go to its respective partition. However, if there's
no key assigned, the data will fill a partition randomly.

Under the hood, the data goes through a hash function and you take the mod of th
output by the number of partitions. The resulting number is the partition number
the data will be written to.

hash(topic) % (# of partitions) = parititon key
```

#### Describe immutability - Is data on a Kafka topic immutable? 
```
Immutability means the data, variable, or object cannot be altered or changed. For 
example, in Python, lists are mutable because you can alter and change the data within
the list. However, you cannot change or alter a tuple once it's instantiated because
the data structure is immutable.

In Kafka, yes data in topics are immutable, meaning it cannot be changed or altered.
It will be read as-is.
```

#### How is data replicated across brokers in kafka? If you have a replication factor of 3 and 3 brokers, explain how data is spread across brokers
* Helpful resource [Brokers and Replication factors](https://youtu.be/ZOU7PJWZU9w)
```
Data is replicated across brokers by copying the leader broker for a given partition.
The ISR (in-sync replica) will copy everything from the leader to a different broker.

Data with a replication factor of 3 and 3 brokers will have its topic and partition
copied through all 3 brokers. If broker 1 contains the partition leader, then broker 
2 and 3 will be the ISRs.
```


#### What was the most fascinating aspect of Kafka to you while learning? 
```
The most fascinating aspect in Kafka in my opinion is how easily scalable and
distrubited it is. The fact that Kafka does this all without all the manual work is 
what makes it even more easier and powerful!
```