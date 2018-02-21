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
        SELECT count(*)
        FROM loudness
        WHERE unixtime = #{time}
        """
    )
    fun count(time: Int): Int

    // 最大が重なった場合は考慮していないよ
    @Select("""
        SELECT uid
        FROM loudness
        WHERE unixtime = #{time}
          AND loudness = (SELECT MAX(loudness) FROM loudness WHERE unixtime = #{time})
        """
    )
    fun talking(time: Int): Int

}