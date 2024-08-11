package tutorials

fun main() {
    b()
}
fun a(text : ()->String){
    val str = text()
    println(str)
}
fun b(){
    println("hi b")

    a { "hi a" }
}