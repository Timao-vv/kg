package com.kugou.caseclass

/**
  * Created by idea on 2018/5/7.
  */
case class IPRule (var startIP: Long,var endIP: Long,var country: String,var province: String,var city: String) extends  Serializable{

}
