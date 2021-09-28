package org.techtown.first_clone.Fragment


class Franchise_Item_Class(var Image:Int?=null, var Name:String?=null,
                           var Rating:String?=null, var RaterNumber:String?=null, var Distance:String?=null,var Free:String?=null) {

    init {
        if(Name!!.length>5){
            Name= Name!!.substring(0,6)+".."
        }
    }


}
