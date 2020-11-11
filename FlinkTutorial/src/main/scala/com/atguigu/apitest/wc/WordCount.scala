package com.atguigu.apitest.wc

import org.apache.flink.api.scala._

object WordCount {
  def main(args: Array[String]): Unit = {
    // 创建一个批处理的执行环境
    val env = ExecutionEnvironment.getExecutionEnvironment

    // 从文件中读取数据
    val inputpath="F:\\pratice\\HadoopDemo\\FlinkTutorial\\src\\main\\resources\\hello.txt"
    val value = env.readTextFile(inputpath)

    // 分词之后做count
    val wordCount = value.flatMap(_.split(" "))
      .map((_,1))
      .groupBy(0)
      .sum(1)

    //打印输出
    wordCount.print()
  }
}
