package com.labs1904.hwe

import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

case class WordCount(word:String, count:Int)
object WordCountBatchApp {
  lazy val logger: Logger = Logger.getLogger(this.getClass)
  val jobName = "WordCountBatchApp"

  def main(args: Array[String]): Unit = {
    logger.info(s"$jobName starting...")
    try {
      val spark = SparkSession.builder()
        .appName(jobName)
        .config("spark.sql.shuffle.partitions", "3")
        .master("local[*]")
        .getOrCreate()
      import spark.implicits._

      val sentences = spark.read.csv("src/main/resources/sentences.txt").as[String]
      sentences.printSchema
      // TODO: implement me
      val splitSentence = sentences.flatMap(row => splitSentenceIntoWords(row))

      val words = splitSentence.map(row => WordCount(row,1))
      val wordCount = words.groupBy(col("word")).count().orderBy(col("count").desc)

      wordCount.show(false)

    } catch {
      case e: Exception => logger.error(s"$jobName error in main", e)
    }
  }

  // TODO: implement this function
  // HINT: you may have done this before in Scala practice...
  def splitSentenceIntoWords(sentence: String): Array[String] = sentence.split(" ").map(s => s.toLowerCase().replaceAll("[^a-z]", ""))
}
