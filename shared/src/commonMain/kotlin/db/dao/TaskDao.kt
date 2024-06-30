package db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import db.entity.NewTask
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(newTask: NewTask)

    @Query("SELECT * FROM NewTask")
    fun getUserAllTask(): Flow<List<NewTask>?>
}