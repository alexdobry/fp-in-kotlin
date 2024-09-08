// 2.1

//fun fib(n: Int): Int {
//    if (n == 0) return 0
//    if (n == 1) return 1
//    return fib(n-1) + fib(n-2)
//}

fun fib(n: Int): Int {
    tailrec fun go(n: Int, acc1: Int, acc2: Int): Int {
        if (n == 0) return acc1
        if (n == 1) return acc2
        return go(n - 1, acc2, acc1 + acc2)
    }
    return go(n, 0, 1)
}

// 2.2
val <T> List<T>.tail: List<T>
    get() = drop(1)

val <T> List<T>.head: T
    get() = first()

fun <A> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean {
    tailrec fun loop(aa: List<A>, acc: Boolean): Boolean {
        if (aa.size <= 1) return acc
        val tail = aa.tail
        return loop(tail, acc && order(aa.head, tail.head))
    }
    return loop(aa, true)
}

// 2.3
fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C =
    { a -> { b -> f(a, b) } }

// 2.4
fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C =
    { a, b -> f(a)(b) }

// 2.5
fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C =
    { a -> f(g(a)) }

fun main() {
    println(fib(0))
    println(fib(1))
    println(fib(9))
    println(fib(10))

    val intOrd = { a: Int, b: Int -> a < b }
    println(isSorted(emptyList(), intOrd))
    println(isSorted(listOf(1, 2, 3), intOrd))
    println(isSorted(listOf(1, 3, 2), intOrd))
}