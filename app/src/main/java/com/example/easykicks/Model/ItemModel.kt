package com.example.easykicks.Model

import java.io.Serializable

data class ItemsModel (
    var title: String="",
    var categoryId:Int=0,
    var logo:String="",
    var description:String="",
    var picUrl: ArrayList<String> =ArrayList(),
    var price:Double=0.0,
    var rating: Double=0.0,
    var numberInChart:Int=0,
): Serializable