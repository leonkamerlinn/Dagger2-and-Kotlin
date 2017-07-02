package com.project.leon.daggerandkotlin.models

/**
 * Created by Leon on 16.11.2016..
 */

class LocalDataModel {
    var id: Int = 0
    var name: String? = null
    var data: String? = null
    var dateTime: String? = null
    var timeZone: String? = null


    constructor() {

    }

    constructor(id: Int, name: String, data: String, datetime: String, timezone: String) {
        this.id = id
        this.name = name
        this.data = data
        dateTime = datetime
        timeZone = timezone
    }


    constructor(name: String, data: String, datetime: String, timezone: String) {
        this.name = name
        this.data = data
        dateTime = datetime
        timeZone = timezone
    }

}
