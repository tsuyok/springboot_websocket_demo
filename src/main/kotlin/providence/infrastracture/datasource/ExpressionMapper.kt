package providence.infrastracture.datasource

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import providence.domain.Expression

@Mapper
interface ExpressionMapper {
    @Insert("""
        INSERT INTO expression (uid, unixtime, expression, created_at) VALUES
        (#{uid}, #{time}, #{emotional}, now())
        """
    )
    fun insert(expression: Expression)

    @Select("""
        SELECT count(*)
        FROM expression
        WHERE unixtime = #{time}
        """
    )
    fun count(time: Int): Int

    @Select("""
        SELECT expression
        FROM expression
        WHERE unixtime = #{time}
        ORDER BY uid
        """
    )
    fun expression(time: Int): IntArray

}