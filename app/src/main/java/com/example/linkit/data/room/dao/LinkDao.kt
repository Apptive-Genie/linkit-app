package com.example.linkit.data.room.dao

import androidx.room.*
import com.example.linkit.data.room.entity.Link
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object. 데이터베이스에 쿼리를 날린다.
 */

@Dao
interface LinkDao {
    // Flow는 객체만 생성되고, SELECT 작업은 .collect에서 이루어진다.
    // 객체 생성은 변수 선언과 같으므로 코루틴으로 작업하지 않아도 된다.
    @Query("SELECT * from link_table")
    fun getLinks(): Flow<List<Link>>

    @Query("SELECT * from link_table where id = :id")
    suspend fun getLinkById(id: Long): Link

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(link: Link)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(link: Link)

    @Query("DELETE FROM link_table")
    suspend fun delete()

    @Delete
    suspend fun deleteLink(link: Link)
}