package so.dian
import org.apache.hadoop.hive.ql.exec.spark.session.SparkSession
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object SqlContextDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("SQLContextApp").setMaster("local[2]")

    val sc=new SparkContext(conf)
    val sqlContext=new SQLContext(sc)
//    val hive = SparkSession.builder().enableHiveSupport().config(conf).getOrCreate()
//    hive.sql(xxx)


    //业务代码
    val table=sqlContext.read.format("json").load("/mywork/yihui.json")
    table.printSchema()
    table.show()
    //业务代码

    sc.stop()
  }

}
