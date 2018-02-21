package providence.domain

class Directions(val directions: List<Direction>){

    val SeatingDirections = mapOf(
            // 上を向いている
            0 to mapOf(0 to 5),
            1 to mapOf(0 to 5),
            2 to mapOf(0 to 5),
            3 to mapOf(0 to 5),
            // 下を向いている
            0 to mapOf(1 to 4),
            1 to mapOf(1 to 4),
            2 to mapOf(1 to 4),
            3 to mapOf(1 to 4),
            // 左を向いている
            0 to mapOf(2 to 1),
            1 to mapOf(2 to 6),
            2 to mapOf(2 to 6),
            3 to mapOf(2 to 2),
            // 左前を向いている
            0 to mapOf(3 to 3),
            1 to mapOf(3 to 6),
            2 to mapOf(3 to 6),
            3 to mapOf(3 to 9),
            // 前を向いている
            0 to mapOf(4 to 2),
            1 to mapOf(4 to 3),
            2 to mapOf(4 to 0),
            3 to mapOf(4 to 1),
            // 右前を向いている
            0 to mapOf(5 to 6),
            1 to mapOf(5 to 2),
            2 to mapOf(5 to 1),
            3 to mapOf(5 to 6),
            // 右を向いている
            0 to mapOf(6 to 6),
            1 to mapOf(6 to 0),
            2 to mapOf(6 to 3),
            3 to mapOf(6 to 6)
    )

    fun direction(): List<Int?> {
        return listOf(0,1,1,1)
    }

    fun nod(): IntArray{
        return directions.map { if(it.direction == 1) 1 else 0 }.toIntArray()
    }

}