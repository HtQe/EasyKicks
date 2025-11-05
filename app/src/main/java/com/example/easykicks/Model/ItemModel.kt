package com.example.easykicks.Model

import java.io.Serializable

data class ItemModel (
    var title: String="",
    var categoryId:Int=0,
    var logo:String="",
    var description:String="",
    var picUrl: ArrayList<String> =ArrayList(),
    var price:Double=0.0,
    var reating: Double=0.0,
    var numberInChart:Int=0,
): Serializable