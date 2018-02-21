package providence.domain

class Directions(val directions: List<Direction>){

    val SeatingDirections = mapOf<String, Long>(
            // 上を向いている
            "0_0" to 5,
            "1_0" to 5,
            "2_0" to 5,
            "3_0" to 5,
            // 下を向いている
            "0_1" to 4,
            "1_1" to 4,
            "2_1" to 4,
            "3_1" to 4,
            // 左を向いている
            "0_2" to 1,
            "1_2" to 6,
            "2_2" to 6,
            "3_2" to 2,
            // 左前を向いている
            "0_3" to 3,
            "1_3" to 6,
            "2_3" to 6,
            "3_3" to 9,
            // 前を向いている
            "0_4" to 2,
            "1_4" to 3,
            "2_4" to 0,
            "3_4" to 1,
            // 右前を向いている
            "0_5" to 6,
            "1_5" to 2,
            "2_5" to 1,
            "3_5" to 6,
            // 右を向いている
            "0_6" to 6,
            "1_6" to 0,
            "2_6" to 3,
            "3_6" to 6
    )

    fun direction(): List<Long?> {
        return directions.map { SeatingDirections["${it.uid}_${it.direction}"] }
    }

    fun nod(): IntArray{
        return directions.map { if(it.direction == 1) 1 else 0 }.toIntArray()
    }

}