package providence.application

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import providence.domain.Directions
import providence.infrastracture.datasource.DirectionMapper
import providence.infrastracture.datasource.ExpressionMapper
import providence.infrastracture.datasource.LoudnessMapper
import providence.domain.State
import providence.exception.SeatingDataException

@Component
class ProvidenceApptication(@Autowired private val loudnessMapper: LoudnessMapper,
                            @Autowired private val expressionMapper: ExpressionMapper,
                            @Autowired private val directionMapper: DirectionMapper
                            ) {
    fun state(time: Long) : State {
        // 数を取得する
        val loudnessCount = loudnessMapper.count(time)
        val emotionalCount = expressionMapper.count(time)
        val directionCount = directionMapper.count(time)

        // 4人そろっていなければException。打算的方法。
        if(loudnessCount != 4 || emotionalCount != 4 || directionCount != 4)
            throw SeatingDataException("データが揃ってないのでここで終了")

        /* 4人揃っていれば情報を返す */
        val talking: Int = loudnessMapper.talking(time);

        val expression: IntArray = expressionMapper.expression(time)

        val directions = Directions(directionMapper.directions(time))

        return State(time, talking, expression, directions.direction(), directions.nod())
    }
}