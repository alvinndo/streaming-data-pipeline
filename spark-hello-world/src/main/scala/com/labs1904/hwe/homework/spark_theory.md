# Overview

Similar to the work you did for Kafka, this is your crash course into Spark through different questions. In this homework, your
challenge is to write answers that make sense to you, and most importantly, **in your own words!**
Two of the best skills you can get from this class are to find answers to your questions using any means possible, and to
reword confusing descriptions in a way that makes sense to you. 

### Tips
* You don't need to write novels, just write enough that you feel like you've fully answered the question
* Use the helpful resources that we post next to the questions as a starting point, but carve your own path by searching on Google, YouTube, books in a library, etc to get answers!
* We're here if you need us. Reach out anytime if you want to ask deeper questions about a topic 
* This file is a markdown file. We don't expect you to do any fancy markdown, but you're welcome to format however you like
* Spark By Examples is a great resources to start with - [Spark By Examples](https://sparkbyexamples.com/)

### Your Challenge
1. Create a new branch for your answers 
2. Complete all of the questions below by writing your answers under each question
3. Commit your changes and push to your forked repository

## Questions
#### What problem does Spark help solve? Use a specific use case in your answer 
```
Spark helps solve data processing efficiency by running programs up to 100x faster
in memory, or 10x faster on disk, than Hadoop. For example, a use case could be
triggering event detection. Spark is able to process streaming data in real-time,
andw with event detection, Spark streaming allows organizations to detect and 
respond quickly to rare or unusual behaviors.
```

* Helpful resource: [Apache Spark Use Cases](https://www.toptal.com/spark/introduction-to-apache-spark)
* [Overivew of Apache Spark](https://www.youtube.com/watch?v=znBa13Earms&t=42s)

#### What is Apache Spark?
```
Apache Spark is a data processing engine used to store and process batch and real-time
streaming data. Although Spark is written using Scala, Spark supports various programming 
languages such as Python, R, or Java. Spark is also 100 faster than Hadoop's MapReduce.
```
* Helpful resource: [Spark Overview](https://www.youtube.com/watch?v=ymtq8yjmD9I) 

#### What is distributed data processing? How does it relate to Apache Spark?
```
Distributed data processing (DDP) is diverging massive amount of data to several
different nodes running in a cluster for processing. This relates to Apache Spark
because Spark contains a cluster manager to do just that where it works with the
driver program and distrbutes its tasks to the worker nodes.
```
[Apache Spark for Beginners](https://medium.com/@aristo_alex/apache-spark-for-beginners-d3b3791e259e)

#### On the physical side of a spark cluster, you have a driver and executors. Define each and give an example of how they work together to process data
```
The driver is contained within every Spark program which creates the SparkContext. This is a
gateway to all the Spark functionalities. Then the driver interacts with the cluster manager
to distribute the tasks to the executors. These executors are worker nodes that simply run
different tasks. 

As data is being processed, the functionalities that is being held in Spark is contained in the
Spark context of the driver manager. As Spark is seeing all of these transformations and processes,
it will talk to the cluster manager where it will assign the worker nodes tasks to perform these
processes.
```
#### Define each and explain how they are different from each other 
* RDD (Resilient Distributed Dataset)
  * ```
    RDDs are the fundamental data structure of Spark comprised of immutable distributed
    collections of objects of any time. They are fault-tolerante (resilient) records of 
    data that resides in multiple nodes and are ran in parallel.
    
    RDDs are different from a DataFrame and DataSet if we want to do low-level transformations
    on the dataset. It also does not automatically infer the schema of the ingested data.
    ```
* DataFrame
  * ```
    DataFrames are distributed collection of data that are organized into named columns. 
    It's conceptually equivalent to a table in RDBs or data frames in R/Python but with 
    richer optimizations under the hood.
    
    Data in DataFrames are organized into columns while RDDs are not. They allow devs to debug
    the code during runtime which RDDs cannot do, and can read and write into various file
    formats. 
    ```
* DataSet
  * ```
    DataSets are extensions of the Dataframes API with benefits of both RDDs and Datasets.
    It is fast and provides a type-safe interface where the compiler will vavlidate the data
    types of all the columns.
    
    It is faster than RDDs and can process both structured and unstructured data. The only
    limitation is that we cannot create Spark Datasets in Python yet. The API is only
    available in Java and Scala.
    ```

#### What is a spark transformation?
[Spark By Examples-Transformations](https://sparkbyexamples.com/apache-spark-rdd/spark-rdd-transformations/)
```
Spark transformations are Spark operations which are executed on RDD. Since RDDs are immutable,
transformations always create new RDD without updating an existing one, and results in a single
or multiple new RDDs.

Transformations are also lazy meaning the operations get executed until you call an action on
Spark RDD.
```
#### What is a spark action? How do actions differ from transformations? 
```
Spark actions are operations that produces a value othat than an RDD, DataFrame, or Dataset.
So if the output is an RDD, DataFrame, or Data set, the function is a transformation. Anything
else is an action.

Spark transformations are lazily executed while actions are not. From the answer above, you can
do all kinds of Spark transformations on your data but nothing will execute until you perform a
Spark action.
```
#### What is a partition in spark? Why would you ever need to repartition? 
[Spark Partitioning](https://sparkbyexamples.com/spark/spark-repartition-vs-coalesce/)
```
A Spark partition is a logical division of data stored on a node in the Spark cluster. Partitions
are basic units of parallelism in Spark.

You would need to repartition if you want to increase or decreate the number of partitions in
your Spark cluster to re-distribute the data from all the partitions.
```
#### What was the most fascinating aspect of Spark to you while learning? 
```
I'm just fascinated at the performance. From reading about it, Spark processes data up to 100x
faster than Hadoop!
```