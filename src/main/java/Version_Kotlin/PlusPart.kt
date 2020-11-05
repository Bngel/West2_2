import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

class PlusPart (private val start: Long,private val end: Long, private val x: Int):Runnable {
    var ans = 0L;
    var isAlive = false

    override fun run() {
        isAlive = true
        println(start)
        for (j in start until end)
            if (contain(j, x))
                ans += j
        isAlive = false
    }
}

fun main(args: Array<String>) {
    var ans = 0L
    val scanner = Scanner(System.`in`)
    val x: Int = scanner.nextInt()
    val ThreadList = ArrayList<PlusPart>()
    var i = 0L
    while (i < 1000000001) {
        ThreadList.add(PlusPart(i,i+100000,x))
        i += 100000
    }
    for (part in ThreadList)
        part.run()

    var isFinished = false
    while (!isFinished) {
        var finish = true
        for (part in ThreadList) {
            if (part.isAlive) {
                finish = false
                break
            }
        }
        isFinished = finish
    }
    for (p in ThreadList) {
        ans += p.ans
    }
    if (x == 0 || x == 1) ans -= 1000000000
    println(ans)
}

fun contain(num:Long, x:Int) = num.toString().contains(x.toString())