package providence.presentation.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import providence.domain.Loudness
import org.springframework.messaging.handler.annotation.MessageExceptionHandler
import providence.application.ProvidenceApptication
import providence.infrastracture.datasource.DirectionMapper
import providence.infrastracture.datasource.ExpressionMapper
import providence.infrastracture.datasource.LoudnessMapper
import providence.domain.Direction
import providence.domain.Expression
import providence.domain.State


@Controller
class ProvidenceController(@Autowired private val loudnessMapper: LoudnessMapper,
                           @Autowired private val expressionMapper: ExpressionMapper,
                           @Autowired private val directionMapper: DirectionMapper,
                           @Autowired private val providenceApptication: ProvidenceApptication) {

    @MessageMapping("/loudness")
    @SendTo("/topic/state")
    fun loudness(loudness: Loudness): State {
        // データinsert
        loudnessMapper.insert(loudness)

        // データ揃っているかチェックし、状態を取得
        val stateMessage = providenceApptication.state(loudness.time)

        return stateMessage
    }

    @MessageMapping("/expression")
    @SendTo("/topic/state")
    fun expression(expression: Expression): State {
        // データinsert
        expressionMapper.insert(expression)

        // データ揃っているかチェックし、状態を取得
        val stateMessage = providenceApptication.state(expression.time)

        return stateMessage
    }

    @MessageMapping("/direction")
    @SendTo("/topic/state")
    fun direction(direction: Direction): State {
        // データinsert
        directionMapper.insert(direction)

        // データ揃っているかチェックし、状態を取得
        val stateMessage = providenceApptication.state(direction.time)

        return stateMessage
    }

    @MessageExceptionHandler
    fun handleException(exception: Throwable) {
        // 一旦何もしない。ホントはだめだけど
    }
}