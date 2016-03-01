package com.nishtahir.holidayhacking.model

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import org.joda.time.DateTime

@DatabaseTable
class Feedback {

    @DatabaseField(generatedId = true)
    long id

    @DatabaseField
    String content

    @DatabaseField
    DateTime date
}
