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
     val ssc=new StreamingContext(conf,Seconds(5))

    val lines=ssc.socketTextStream("localhost",9997,StorageLevel.MEMORY_AND_DISK_SER)

    //获取数据并打印
    lines.flatMap(x=>x.split(" ")).map(x=>(x,1)).reduceByKey(_+_).print()

    //循环获取数据并持久化
//     val aa=lines.flatMap(x=>x.split(" ")).map(x=>(x,1)).reduceByKey(_+_)
//    aa.foreachRDD(x=>{
//
//      x.foreachPartition(b=>{
//        b.foreach(c=>{
//
//          println(c)
//        })
//
//      })
//    })

    //  窗口函数，每隔5秒计算10秒的数据
//    lines.flatMap(x=>x.split(" ")).map(x=>(x,1))
//      .reduceByKeyAndWindow(((x:Int,y:Int)=>x+y),Seconds(10),Seconds(5)).print()


    //lines.print()


    ssc.start()
    ssc.awaitTermination()
  }
}
