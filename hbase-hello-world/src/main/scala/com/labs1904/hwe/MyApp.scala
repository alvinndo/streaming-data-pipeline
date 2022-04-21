package com.labs1904.hwe

import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.hadoop.hbase.client.{Connection, ConnectionFactory, Delete, Get, Put, ResultScanner, Scan}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.logging.log4j.{LogManager, Logger}

object MyApp {
  lazy val logger: Logger = LogManager.getLogger(this.getClass)

  def main(args: Array[String]): Unit = {
    logger.info("MyApp starting...")
    var connection: Connection = null
    try {
      val conf = HBaseConfiguration.create()
      conf.set("hbase.zookeeper.quorum", "hbase02.hourswith.expert:2181")
      connection = ConnectionFactory.createConnection(conf)
      // Example code... change me
      val table = connection.getTable(TableName.valueOf("ado:users"))

      /**
       * Challenge 1
       */
      val q1 = {
        val get = new Get(Bytes.toBytes("10000001"))
        val result = table.get(get)

        val birthdate = Bytes.toString(result.getValue(Bytes.toBytes("f1"), Bytes.toBytes("birthdate")))
        logger.debug(birthdate)
      }

      /**
       * Challenge 2
       */
      val q2 = {
        val put = new Put(Bytes.toBytes("99"))

        put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("username"), Bytes.toBytes("DE-HWE"))
        put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("name"), Bytes.toBytes("The Panther"))
        put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("sex"), Bytes.toBytes("F"))
        put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("favorite_color"), Bytes.toBytes("pink"))

        table.put(put)

        val get = new Get(Bytes.toBytes("99"))
        val result = table.get(get)

        logger.debug(result)
      }

      /**
       * Challenge 3
       */
      val q3 = {
        val scan = new Scan().withStartRow(Bytes.toBytes("10000001")).withStopRow(Bytes.toBytes("10006001"))
        val scanner = table.getScanner(scan).iterator()

        var numUsers = 0
        while(scanner.hasNext){
          scanner.next()
          numUsers += 1
        }

        logger.debug(numUsers)
      }

      /**
       * Challenge 4
       */
      val q4 = {
        val delete99 = new Delete(Bytes.toBytes("99"))
        table.delete(delete99)

        val get = new Get(Bytes.toBytes("99"))
        val result = table.get(get)

        logger.debug(result)
      }

      /**
       * Challenge 5
       */
      List(Bytes.toBytes("9005729"), Bytes.toBytes("500600"), Bytes.toBytes("30059640"), Bytes.toBytes("6005263"), Bytes.toBytes("800182")).foreach(s => {
        val get = new Get(s)
        val result = table.get(get)

        val email = Bytes.toString(result.getValue(Bytes.toBytes("f1"), Bytes.toBytes("mail")))
        logger.debug(email)
      })

    } catch {
      case e: Exception => logger.error("Error in main", e)
    } finally {
      if (connection != null) connection.close()
    }
  }
}
