package so.dian.sqlapp

import org.apache.spark.sql.SparkSession

import scala.collection.mutable.ListBuffer

object SparkSessionDemo {
  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().appName("sparksession").master("local[2]").enableHiveSupport().getOrCreate()
    //读取josn
    val table= spark.read.json("file:///mywork/yihui.json")
    table.show()
    table.rdd.foreachPartition(x=>{

      /// TODO: 1.,定义计算的列表
      val list=new ListBuffer[InfoTest]
      x.foreach(b=>{
         //println(b)
          val infoTest=InfoTest(b.get(0).toString,b.get(1).toString)
           list.append(infoTest)
         println(infoTest)
      })

      // TODO: ...       //#这里可以写批量入库操作
      //....


    })
    //读取hive
    spark.sqlContext.sql("use testdb")
    val df=spark.sqlContext.sql("select * from stulog")

    df.show()
    spark.stop()
  }

  /**
    * json实体类
    * @param fileldName 文件名称
    * @param id  文件id
    */
  case class InfoTest(fileldName:String,id:String)
}
