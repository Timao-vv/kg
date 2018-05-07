package com.kugou.constants

/**
  * Created by idea on 2018/5/7.
  */
object LogConstants {

  //hbase存放日志的表
  final val LOG_HBASE_TABLE: String = "kugou_music_log"
  //标的列族
  final val lOG_HBASE_TABLE_FAMILY: String = "log"

  //国家
  final val LOG_COLUMNS_NAME_COUNTRY = "country"
  //省份
  final val LOG_COLUMNS_NAME_PROVINCE = "province"
  //城市
  final val LOG_COLUMNS_NAME_CITY = "city"
  //用户访问时的ip
  final val LOG_COLUMNS_NAME_IP = "ip"
  //用户访问时间
  final val LOG_COLUMNS_NAME_ACCESS_TIME = "accessTime"
  //请求方式
  final val LOG_COLUMNS_NAME_REQUEST_TYPR = "requestType"
  //用户行为标识
  final val LOG_COLUMNS_NAME_BEHAVIOR_FLAG = "behaviorFlag"
  //用户行为数据
  final val LOG_COLUMNS_NAME_BEHAVIOR_DATA = "behaviorData"
  //操作系统名称
  final val LOG_COLUMNS_NAME_OS_NAME = "osName"
  //操作系统版本
  final val LOG_COLUMNS_NAME_OS_VERSION = "osVersion"
  //设备型号
  final val LOG_COLUMNS_NAME_MODEL_NUM = "modeNum"



}
