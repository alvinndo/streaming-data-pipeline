# Overview

By now you've seen some different Big Data frameworks such as Kafka and Spark. Now we'll be focusing in on HBase. In this homework, your
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
#### What is a NoSQL database? 
```
A NoSQL database refers to any non-relational database. The data is stored in a format
other than relational tables. For instance, NoSQL database are stored using key-value
pairs while traditional relational database are stored in tables organized into columns.
In addition, NoSQL databases are schema-less.
```

#### In your own words, what is Apache HBase? 
```
HBase is a type of NoSQL database that runs on top of HDFS, and enables real-time
analysis of data.

The data is stored in tabular format for fast reads/writes. HBase is mostly used in 
scenarios that requires regular and consistent inserting and overwriting of data, such
as Spark streams.
```

#### What are some strengths and limitations of HBase? 
* [HBase By Examples](https://sparkbyexamples.com/apache-hbase-tutorial/)
```
Strengths:
-Easy to scale
-Highly fault-tolerant
-Leverages HDFS file storage to store large datasets and perform queries quickly
-Supports parallel processing via MapReduce and Spark
-Queries execute in parallel across the cluster

Limitations:
-Tough to query with SQL-like operations
-Cannot do join operations on different HBase tables
-CPU and memory intensive
-Sorting only done on Row keys
-Single point of failure
-Requires Hive on top of HBase to run SQL-like queries
-No support of transactions
```
#### Explain the following concepts: 
* Row key
```
A unique identifier for the table row. Since HBase is a NoSQL-like database system, it
requires the usage of key-value pairs. So in order to query the data, it needs the row
key.
```
* Column Qualifier
```
The column names, also known as column keys.
```
* Column Family
```
The logical and physical grouping of columns in a table. Column families contain column
qualifiers.
```

#### What are the differences between Get and Put commands in HBase? 
* [HBase commands](https://www.tutorialspoint.com/hbase/hbase_create_data.htm)
```
The Get command is used to read a single row of the HTable at a time
The Put command is used to insert a row and update the HTable
```

#### What is the HBase Scan command for? 
* [HBase Scan](https://www.tutorialspoint.com/hbase/hbase_scan.htm)
```
The Scan command is used to view the data in HTable. You can get the table data
```

#### What was the most interesting aspect of HBase when went through all the questions? 
```
The fact that HBase is a NoSQL-like database system that utilizes HDFS is pretty unique.
I'm curious to know how to use it hands-on and see what kind of data to expect after 
some executions.
```