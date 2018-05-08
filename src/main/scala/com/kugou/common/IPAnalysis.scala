package com.kugou.common

import com.kugou.caseclass.{IPRule, RegionInfo}
import com.kugou.utils.Utils
import scala.util.control.Breaks._

/**
  * Created by idea on 2018/5/7.
  */
object IPAnalysis {

  /**
    * 解析ip
    *
    * @param ip
    * @param ipRules
    * @return
    */
  def analysisIP(ip:String, ipRules:Array[IPRule]) ={
    var regionInfo = RegionInfo()
    if(Utils.validateIP(ip)){
      //将ip解析成完整的十进制数字
      val numIP = ip2Long(ip)
      //获取numIP的地域信息
      val index = binarySearch(numIP,ipRules)
      if(index != -1){
        val iPRule = ipRules(index)
        regionInfo.country = iPRule.country
        regionInfo.province = iPRule.province
        regionInfo.city = iPRule.city
      }
    }
    regionInfo
  }

  /**
    * 二分查找，查找ip对应的地域信息，并把地域信息对应的索引返回
    * @param numIP
    * @param ipRules
    */
  def binarySearch(numIP: Long, ipRules: Array[IPRule]) = {
    //最小角标
    var min: Int = 0
    //最大角标
    var max: Int = ipRules.length - 1
    //目标角标
    var index: Int = -1
    breakable({
      while (min <= max){
        //中间角标
        var middle = (min + max) / 2
        //取出中间角标对应的规则
        val iPRule = ipRules(middle)
        //判断numIP是否在规则起始ip内
        if(numIP >= iPRule.startIP && numIP <= iPRule.endIP){
          index = middle
          break()
        }else if(numIP < iPRule.startIP) {
          max = middle - 1
        }else if(numIP > iPRule.endIP) {
          min = middle + 1
        }
      }
    })
    index
  }


  /**
    * 将ip解析成完整的十进制数字
    * @param ip
    */
  def ip2Long(ip: String) = {

    val fields = ip.split("[.]")
    var numIP:Long = 0L
    for(i <- 0 until (fields.length)){
      numIP = numIP << 8 | fields(i).toLong
    }
    numIP
  }



}
