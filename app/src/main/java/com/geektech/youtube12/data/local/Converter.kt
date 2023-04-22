package com.geektech.youtube12.data.local

import androidx.room.TypeConverter
import com.geektech.youtube12.model.playlist.Item
import com.geektech.youtube12.model.playlist.PageInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object Converter {

    val gson= Gson()

    @TypeConverter
    fun jsonToItems(data:String?):List<Item>{
        val type:Type=object: TypeToken<List<Item>>(){}.type
        return gson.fromJson(data,type)
    }

    @TypeConverter
    fun itemToString(items:List<Item>):String{
        return gson.toJson(items)
    }

    @TypeConverter
    fun jsonToPageInfo(data:String?):PageInfo{
        return gson.fromJson(data,PageInfo::class.java)
    }

    @TypeConverter
    fun itemToString(pageInfo: PageInfo):String{
        return gson.toJson(pageInfo)
    }
}