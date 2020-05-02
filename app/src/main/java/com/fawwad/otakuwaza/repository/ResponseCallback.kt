package com.fawwad.otakuwaza.repository

import java.lang.Exception

interface ResponseCallback <E>{

    fun onResponse(response:E)

    fun onFailure(e:Exception)

}