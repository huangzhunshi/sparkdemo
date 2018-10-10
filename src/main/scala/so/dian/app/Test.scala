package so.dian.app

import kafka.serializer.StringDecoder
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.kafka.KafkaUtils

object Test {

  //https://blog.csdn.net/autumnforest290/article/details/78802412
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("kafka").setMaster("local")
    val ssc = new StreamingContext(conf, Seconds(10))
    val kafkaParam = Map("metadata.broker.list" -> "127.0.0.1:9092")
    val topics = Set("demo") //我们需要消费的kafka数据的topic
    val stream = KafkaUtils.createDirectStream(ssc, kafkaParam, topics)
    stream.print()
    ssc.awaitTermination()

    //KafkaCluster 需要从源码拷贝，此类是私有类。
//    directKafkaStream.foreachRDD(
//      rdd => {
//        val offsetLists = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
//        val kc = new KafkaCluster(kafkaParams)
//        for (offsets <- offsetLists) {
//          val topicAndPartition = TopicAndPartition(offsets.topic, offsets.partition)
//          val o = kc.setConsumerOffsets(kafkaGroupId, Map((topicAndPartition, offsets.untilOffset)))
//          if (o.isLeft) {
//            println(s"Error updating the offset to Kafka cluster: ${o.left.get}")
//          }
//        }
//      }


     //t(add,10,20)

//    val kafkaStream = KafkaUtils.createStream(streamingContext,
//      [ZK quorum], [consumer group id], [per-topic number of Kafka partitions to consume]

//    val conf = new SparkConf().setAppName("kafka").setMaster("local")
//    val sc= new SparkContext(conf)
//    val ssc = new StreamingContext(sc,Seconds(5))
//    ssc.checkpoint("checkpoint")

//    val lines = KafkaUtils.createStream[String, String, StringDecoder, StringDecoder](ssc,
//      kafkaParams, topicMap, StorageLevel.MEMORY_AND_DISK_SER).map(_._2)
  }

  def t(t:(Int,Int)=>Int,a:Int,b:Int):Unit={
     val x= t(a,b)
    println(x)
    println("hi")
  }

  def add(a:Int,b:Int):Int={
    return a+b;
  }

  def aaa(): String ={
    return "xxxx"
  }

}
