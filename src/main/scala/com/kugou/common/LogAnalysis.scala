package com.kugou.common

import com.kugou.caseclass.IPRule
import com.kugou.constants.LogConstants

import scala.collection.mutable

/**
  * Created by idea on 2018/5/7.
  */
object LogAnalysis {

  /**
    * 解析ip
    * @param ip
    * @param ipRules
    * @param logMap
    * @return
    */
  private def handleIP(ip: String, ipRules: Array[IPRule], logMap:mutable.Map[String,String]) = {
    val regionInfo = IPAnalysis.analysisIP(ip,ipRules)
    logMap.put(LogConstants.LOG_COLUMNS_NAME_COUNTRY,regionInfo.country)
    logMap.put(LogConstants.LOG_COLUMNS_NAME_PROVINCE,regionInfo.province)
    logMap.put(LogConstants.LOG_COLUMNS_NAME_CITY,regionInfo.city)
    logMap.put(LogConstants.LOG_COLUMNS_NAME_IP,ip)
  }

  /**
    * 处理请求数据
    * @param requesParams
    * @param logMap
    */
  private def handleRequesParams(requesParams:String, logMap: mutable.Map[String,String]) = {

  }


}
