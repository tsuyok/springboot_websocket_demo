package providence.domain

data class State(val time: Int, val taking: Int, val expression: IntArray, val direction: List<Int?>, val nod: IntArray)