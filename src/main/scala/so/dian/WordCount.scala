package so.dian


import org.apache.spark.{SparkConf, SparkContext}

/**
 * A Main to run Camel with MyRouteBuilder
 */
object WordCount  {

  def main(args: Array[String]) {
//    val main = new Main()
//    // create the CamelContext
//    val context = main.getOrCreateCamelContext()
//    // add our route using the created CamelContext
//    main.addRouteBuilder(new MyRouteBuilder(context))
//    // must use run to start the main application
//    main.run()

    //设置本机Spark配置
    val conf = new SparkConf().setAppName("wordCount").setMaster("local")
    //创建Spark上下
    val sc = new SparkContext(conf)
    //从文件中获取数据
    val input = sc.textFile("/tmp/bb")
    //分析并排序输出统计结果
    input.flatMap(line => line.split(" ")).map(word => (word, 1)).
      reduceByKey((x, y) => x + y).
      sortBy(_._2,false).
      foreach(println _)
  }
}

