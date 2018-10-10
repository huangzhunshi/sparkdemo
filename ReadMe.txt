1.spark环境相关

1.1  Local模式  spark-shell --master local[2]

1.2  standalone模式 修改配置文件（本机路径/usr/local/Cellar/Spark/spark-2.3.1-bin-hadoop2.7）

conf/spark-env.sh
新增如下配置
SPARK_MASTER_HOST=hadoop01
SPARK_WORKER_CORES=2
SPARK_WORKER_MEMORY=2g
SPRAK_WORKER_INSTANCES=1

2.启动
sbin/start-all.sh

spark命令行，本地
spark-shell

链接环境
spark-shell --master spark://host:port

3.服务器上执行jar包命令 (本机mysql驱动包路径 /mywork/lib/mysql/mysql-connector-java/5.1.46/mysql-connector-java-5.1.46.jar)
bin/spark-submit --Class com.xxx.app --jars mysql驱动包路径（hive需要选） --master local[2] xxx.jar


4.本地hive和spark路径
hivie 路径  /usr/local/Cellar/Hive/apache-hive-2.3.3-bin/
spark 路径  /usr/local/Cellar/Spark/spark-2.3.1-bin-hadoop2.7/

