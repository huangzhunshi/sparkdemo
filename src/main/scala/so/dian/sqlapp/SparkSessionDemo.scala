package so.dian.sqlapp

import org.apache.spark.sql.SparkSession

object SparkSessionDemo {
  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().appName("sparksession").master("local[2]").enableHiveSupport().getOrCreate()
    //读取josn
    val table= spark.read.json("file:///mywork/yihui.json")
    table.show()

    //读取hive
    spark.sqlContext.sql("use testdb")
    val df=spark.sqlContext.sql("select * from stulog")
    df.show()

    spark.stop()


  }
}
