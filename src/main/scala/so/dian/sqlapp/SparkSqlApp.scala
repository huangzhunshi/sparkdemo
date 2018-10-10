package so.dian.sqlapp

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object SparkSqlApp {

  case class Person(name:String,age:Int,addr:String)

  def main(args: Array[String]): Unit = {

    //设置本机Spark配置
    val conf = new SparkConf().setAppName("wordCount").setMaster("local")
    //创建Spark上下
    val sc = new SparkContext(conf)


    val sqlContext=new SQLContext(sc)

    // /tmp/sqltest

    val person=sc.textFile("/tmp/sqltest")

    val person001= person.map(x=>x.split(","))

//    val tmp =person001.collect()
//
//    for(x<-tmp){
//       for(y<-x){
//         println(y)
//
//       }
//      println("----------------")
//    }

//    val people = sc.textFile("D:\\SparkSqlDataTest\\data1.txt").map(_.split(",")).map( p => Person(p(0),p(1).trim.toInt,p(2))).toDF()
//
//    people.registerTempTable("people")

    import sqlContext._
    import sqlContext.implicits._

    val person002= person001.map(x=>new Person(x(0),x(1).trim.toInt,x(2))).toDF()



    person002.show()
    person002.registerTempTable("p")

//    for(x<-person002){
//      println(x)
//    }

    val result= sql("select * from p where age=25")


    result.map( t => "name:" + t(0) + " age:" + t(1) + " addr:" + t(2)).collect().foreach(println)

  }
}
