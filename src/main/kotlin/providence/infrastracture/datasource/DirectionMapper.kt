package providence.infrastracture.datasource

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import providence.domain.Direction

@Mapper
interface DirectionMapper {
    @Insert("""
        INSERT INTO direction (uid, unixtime, direction, created_at) VALUES
        (#{uid}, #{time}, #{direction}, now())
        """
    )
    fun insert(direction: Direction)

    @Select("""
        SELECT COUNT(DISTINCT uid)
        FROM direction
        WHERE unixtime = #{time}
        """
    )
    fun count(time: Long): Int

    @Select("""
        SELECT uid, unixtime as time, MIN(direction)
        FROM direction
        WHERE unixtime = #{time}
        GROUP BY uid
        ORDER BY uid
        """
    )
    fun directions(time: Long): List<Direction>

}
