package so.dian

import org.apache.spark.{SparkConf, SparkContext}
import so.dian.model.Users

object RddTest {
  def main(args: Array[String]): Unit = {
    //println("xxxxxx")

//    for(x<-aaa){
//      println(x)
//    }
    val conf = new SparkConf().setAppName("wordCount").setMaster("local")
    val sc=new SparkContext(conf)
    val lines=sc.parallelize(Array( "aa","bb","dd","aa"))

    val sorecrdd=sc.parallelize(Array(("jake",90.0),("jake",85.0),("jake",86.0),("tom",87.0),("tom",89.0),("tom",82.0)))

    sorecrdd.foreach(println)

    val sorcerdd2=sorecrdd.combineByKey(s=>(1,s),(c1:(Int,Double),news)=>(c1._1+1,c1._2+news),(c1:(Int,Double),c2:(Int,Double))=>(c1._1+c2._1,c1._2+c2._2))
    sorcerdd2.foreach(println)

    val sorceavg=sorcerdd2.map((c1:(String,(Int,Double)))=>(c1._1,c1._2._2/c1._2._1))
    sorceavg.foreach(println)


    //    lines.foreach(println)
//
//    val words=lines.map(word=>(word,1))
//    words.foreach(println)
//
//
//
//    val u=new Users("huangz",12)
//    println(u.myage)
//    println(u.myname)
//
//
//    val rddtest=sc.parallelize(Array(1,2,3,4))
//    val rddtestcount= rddtest.reduce((x,y)=>x+y)
//
//    println( rddtestcount)
//
//    val wordsred= words.reduceByKey((x,y)=>x+y)
//    wordsred.foreach(println)
//
//    val wordgroup=words.groupByKey()
//    wordgroup.foreach(println)
//
//     words.keys.foreach(println)
//    words.values.foreach(println)
  }

}
