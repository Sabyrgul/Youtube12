package com.geektech.youtube12.data.remote

class Resource <out T>(val status: Status, val data: T?, message:String?) {


}

enum class Status{
    SUCCESS,
    ERROR,
    LOADING
}