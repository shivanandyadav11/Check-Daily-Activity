package db.convertor

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromTagList(tags: List<String>?): String? {
        return tags?.joinToString(",")
    }

    @TypeConverter
    fun toTagList(data: String?): List<String>? {
        return data?.split(",")
    }
}