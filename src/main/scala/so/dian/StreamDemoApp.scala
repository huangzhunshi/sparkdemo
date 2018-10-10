package so.dian

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamDemoApp {
  def main(args: Array[String]): Unit = {
    //设置本机Spark配置
    val conf = new SparkConf().setAppName("stream").setMaster("local")
    //创建Spark上下
    //val sc = new SparkContext(conf)

    val ssc=new StreamingContext(conf,Seconds(6))

    //val lines=ssc.socketTextStream("127.0.0.1",10001,StorageLevel.MEMORY_AND_DISK_SER)

    val kafkaParam = Map("metadata.broker.list" -> "127.0.0.1:9092")
    val topics = Set("test") //我们需要消费的kafka数据的topic
    val dstream = KafkaUtils.createDirectStream(ssc, kafkaParam, topics)

    val topicData: DStream[String] = dstream.map(_._2)
    //8、切分每一行,每个单词计为1
    val wordAndOne: DStream[(String, Int)] = topicData.flatMap(_.split(" ")).map((_,1))
    //9、相同单词出现的次数累加
    val result: DStream[(String, Int)] = wordAndOne.reduceByKey(_+_)
    //10、打印输出
    result.print()
    //开启计算
    ssc.start()
    ssc.awaitTermination()

    //val words=lines.flatMap(x=>x.split(" "))


//    val wordhash=words.map(x=>(x,1))
//
//    val wordCount=wordhash.reduceByKey((x,y)=>(x+y))
//
//    wordCount.print()
//
//
//    ssc.start()
//    ssc.awaitTermination()
  }
}
