package so.dian.sqlapp

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

object HiveContextDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()

    conf.setAppName("HiveContextApp").setMaster("local[2]")
      //.setJars(Array("/mywork/lib/mysql/mysql-connector-java/5.1.46/mysql-connector-java-5.1.46.jar"))

    val sc=new SparkContext(conf)
    val hiveContext=new HiveContext(sc)

    //hiveContext.sql("use testdb").table("stulog").show()
    hiveContext.sql("use testdb")
    hiveContext.table("stulog").show()

    //业务代码
    //  val table=sqlContext.read.format("json").load("/mywork/yihui.json")
    //  table.printSchema()
    //  table.show()
    //业务代码

    sc.stop()
  }
}
