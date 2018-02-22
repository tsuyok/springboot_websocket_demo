package providence.infrastracture.datasource

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import providence.domain.Loudness

@Mapper
interface LoudnessMapper {
    @Insert("""
        INSERT INTO loudness (uid, unixtime, loudness, created_at) VALUES
        (#{uid}, #{time}, #{loudness}, now())
        """
    )
    fun insert(loudness: Loudness)

    @Select("""
        SELECT COUNT(DISTINCT uid)
        FROM loudness
        WHERE unixtime = #{time}
        """
    )
    fun count(time: Long): Int

    // 最大が重なった場合は考慮していないよ
    @Select("""
        SELECT uid, unixtime, loudness
        FROM loudness
        WHERE unixtime = #{time}
          AND loudness = (SELECT MAX(loudness) FROM loudness WHERE unixtime = #{time})
        ORDER BY loudness
        LIMIT 1
        """
    )
    fun talking(time: Long): Loudness

}
