package so.dian

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka.KafkaUtils

//https://blog.csdn.net/winwill2012/article/details/71628225 明天看看
object kafkaApp {

  def aaa[A,B](a:A,b:B): Unit ={
    println(a)
    println(b)
  }

  def main(args: Array[String]): Unit = {
   // aaa(12,2122)
//    val conf = new SparkConf().setAppName("kafka").setMaster("local")
//    val ssc = new StreamingContext(conf, Seconds(10))
//    val kafkaParam = Map("metadata.broker.list" -> "192.168.3.119:9092")
//    val topics = Set("demo") //我们需要消费的kafka数据的topic
//    val stream = KafkaUtils.createDirectStream(ssc, kafkaParam, topics)
//    stream.print()

//    aaaa()
//
    //println(abc("abc"))

     // abb(10,"xxx","vvv")

    //abb(func,"232323","232323")

     // op(add)

 //    strmain(stradd,"huang","zhun")

     //println(aaaa(10,200))
//     println(jian(10)(100))
//    println(jianok(20))
//    println(jianok(30))zzzz

     //println(fc(2,2))
//    val b:Int=bbbb(add1,2,3)
//
//
//    println(b)

     //println(foo(100))
    //hi()
//     val a= oph((x,y)=>{x+y+100},1,2)
//     println(a)

  }

  def oph(op:(Int,Int)=>Int,x:Int,y:Int):Int={
     return op(x,y)
  }


  def hi(): Unit ={
    val q=List(List(1,2,3),List(4,5,6))
  //  q.flatMap(_)).foreach(println(_))
    //q.map(_.filter(_>5)).foreach(println(_))
//      val a=List(1,2,3,4)
//    val b=0::a
//     for(x<-b){
//       println(x)
//     }
//    a.foreach(x=>{
//      val b=x+100
//      println(b)
//    })
//
//    println(a.max)

//    val c= a.filter(x=>{x<3})
    //     c.foreach(x=>println(x))

//     val b=List("a","b","c")
//     val c=b.map(_.toUpperCase())
//     c.foreach(println(_))
  }


  def foo(x:Int) =x

  def add(s1:Int,s2:Int): Int ={
    return s1+s2
  }

  def bbbb(func:(Int,Int)=>Int,s1:Int,s2:Int):Int={
     val b= func(s1,s2)
     return b
  }

  @annotation.tailrec
  def fc(n:Int,m:Int):Int={
    if(n<=0) return m
    else fc(n-1,m*n)
  }

  def jianok=jian(10)_

   def jian(x:Int)(y:Int)=x-y
   def aaaa(x:Int,y:Int)=x+y

   def op(f:(Int,Int)=>Int)={
     println( f(4,4))
   }

   def add1(x:Int,y:Int): Int ={
     return x+y
   }

    def stradd(v1:String,v2:String):String={
       return v1+v2;
    }

    def strmain(f1:(String,String)=>String,v1:String,v2:String)={
      val str= f1(v1,v2)
      println(str)
    }
  def abb(f1:(String,String)=>String,v1:String,v2:String)=f1(v1,v2)

  def func(x:String,y:String): String ={
    return "xxxxxx"
  }

//  def apply(f:Int=>String,v:Int)=f(v)
//
//  def layout[A](x:A)="["+x.toString+"]"
//
//  def abc( a:String):String={
//    return a;
//  }
//
  def aaaa(): Unit ={
    var array=Array(1,2,3,5,6)
   println(array.max)
    //print(array)
    for(x<-array){
      println(x)
    }
    println("xxxxx")
  }
}
