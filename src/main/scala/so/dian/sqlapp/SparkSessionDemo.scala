package so.dian.sqlapp

import org.apache.spark.sql.SparkSession

object SparkSessionDemo {
  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().appName("sparksession").master("local[2]").getOrCreate()
    val table= spark.read.json("file:///mywork/yihui.json")
    table.show()
    spark.stop()
  }
}
