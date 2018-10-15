package so.dian.streamapp

import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}


/***
  * 官方文档地址: http://spark.apache.org/docs/latest/streaming-programming-guide.html#basic-concepts
  *
  *
  * 客户端命令行打开  nc -lk 9997
  */
object SimapApp {

  def main(args: Array[String]): Unit = {
     val conf=new SparkConf().setAppName("SimapApp").setMaster("local[2]")
     val ssc=new StreamingContext(conf,Seconds(3))

    val lines=ssc.socketTextStream("localhost",9997,StorageLevel.MEMORY_AND_DISK_SER)

    lines.flatMap(x=>x.split(" ")).map(x=>(x,1)).reduceByKey(_+_).print()

    //lines.print()


    ssc.start()
    ssc.awaitTermination()
  }
}
