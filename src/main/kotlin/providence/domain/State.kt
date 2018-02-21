package providence.domain

data class State(val time: Long, val talking: Int, val expression: IntArray, val direction: List<Long?>, val nod: IntArray)