package com.rs132studio.fragment.Model

import java.io.Serializable

data class Contacts(
    var name : String = "",
    var description : String = "",
    var cImages : Int = 0
) : Serializable