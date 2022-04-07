import java.util.Scanner
import kotlin.random.Random

fun buscaBinaria(listaDeBusca: IntArray, i: Int, j: Int, aux: Int): Int {
    var meio: Int = (j + i)/2

    if (i > j) return -1

    if(listaDeBusca[meio] == aux){
        return meio
    } else if(listaDeBusca[meio] < aux){
        return buscaBinaria(listaDeBusca, ++meio , j, aux)
    } else{
        return buscaBinaria(listaDeBusca, i, --meio, aux)
    }
}


fun palindromo(strAux: String): String{
    val len: Int = strAux.length - 1
    if (len <= 1) return "Palindromo"

    if (strAux[0] != strAux[len]) return "Nao e palindromo"
    else return palindromo(strAux.subSequence(1, len - 1) as String)
}


fun adivinhacao(){
    val numMistery: Int = Random.nextInt(0, 100)
    var tentativas = 5

    println("Pronto para comecar?\n1 para sim ou 2 para nao")
    val start = readln()
    if(start == "1"){
        while (true){
            println("Digite o valor")
            val kick: Int = Scanner(System.`in`).nextInt()

            if (kick == numMistery){
                println("Voce acertou!!\n")
                break
            } else if (kick > numMistery) println("Mais pra baixo um pouco")
             else println("Mais pra cima um pouco")

            tentativas--

            if(tentativas > 0){
                println("Vamos la! Ainda restam $tentativas tentativas\n")
            } else {
                println("\nPoxa... Suas tentativas acabaram :'(\nO numero era $numMistery...")
                break
            }
        }
    }else println("Que pena... Ate a proxima entao")
}
