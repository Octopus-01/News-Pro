package com.octelspace.newspro.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.octelspace.newspro.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConvertor {

    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id}, ${source.name}"
    }

    fun stringToSource(source: String): Source {
        return source.split(",").let { sourceArray->
            Source(id = sourceArray[0], name = sourceArray[1])
        }
    }
}