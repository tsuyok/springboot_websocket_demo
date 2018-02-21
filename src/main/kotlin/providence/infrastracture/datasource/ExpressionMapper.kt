package providence.infrastracture.datasource

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import providence.domain.Expression

@Mapper
interface ExpressionMapper {
    @Insert("""
        INSERT INTO expression (uid, unixtime, expression, created_at) VALUES
        (#{uid}, #{time}, #{expression}, now())
        """
    )
    fun insert(expression: Expression)

    @Select("""
        SELECT COUNT(DISTINCT uid)
        FROM expression
        WHERE unixtime = #{time}
        """
    )
    fun count(time: Long): Int

    @Select("""
        SELECT MIN(expression)
        FROM expression
        WHERE unixtime = #{time}
        GROUP BY uid
        ORDER BY uid
        """
    )
    fun expression(time: Long): IntArray

}
