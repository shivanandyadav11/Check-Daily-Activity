package db

import TaskType
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewTask(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String? = null,
    val date: String? = null,
    val time: String? = null,
    val description: String? = null,
    val type: String? = "Personal",
    val tags: String? = null
)
