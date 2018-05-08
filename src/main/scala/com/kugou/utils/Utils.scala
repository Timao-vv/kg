package com.kugou.utils

import java.text.SimpleDateFormat
import java.util.{Base64, Locale}
import java.util.regex.Pattern

/**
  * Created by idea on 2018/5/7.
  */
object Utils {

  /**
    * 验证ip是否符合ip格式
    * @param ip
    * @return
    */
  def validateIP(ip:String) = {
    val reg = "((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))"
    val pattern = Pattern.compile(reg)
    pattern.matcher(ip).matches()
  }

  /**
    * 将日志服务器时间转化成时间戳
    * @param accessTime
    * @return
    */
  def parseLogServerTimeToLong(accessTime: String) = {
    val simpleSateFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss + 0800",Locale.ENGLISH)
    val date = simpleSateFormat.parse(accessTime)
    date.getTime
  }

  /**
    * base64解码
    * @param base64EndcodeString
    */
  def base64Decode(base64EndcodeString: String) = {
    Base64.getDecoder.decode(base64EndcodeString)
  }

  /**
    * 验证日期是否是yyyy-MM-dd
    * @param date
    */
  def validateDate(date:String) = {
    val reg = "((((19|20)\\d{2})-(0?(1|[3-9])|1[012])-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-(0?[13578]|1[02])-31)|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$"
    val pattern = Pattern.compile(reg)
    pattern.matcher(date).matches()
  }

  /**
    * 将时间戳转化为指定格式的日期
    * @param longTime
    * @param pattern
    */
  def formatDate(longTime: Long,pattern: String) = {
    val sdf = new SimpleDateFormat(pattern)
    val calendar = sdf.getCalendar
    calendar.setTimeInMillis(longTime)
    sdf.format(calendar.getTime)
  }

  /**
    * 将字符串时间转换成指定格式的日期
    * @param strDate
    * @param patter
    * @return
    */
  def parseDateToLong(strDate: String,patter: String) = {
    val sdf = new SimpleDateFormat(patter)
    sdf.parse(strDate).getTime
  }


}
