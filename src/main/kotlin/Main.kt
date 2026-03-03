import kotlin.system.exitProcess

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
var saldo = 250.0f
var transacoes = mutableListOf<String>()

fun main(){
    println("Informe seu nome: ")
    val nome = readLine()
    println("Olá, $nome, eu sou o gerente do banco KuriBank ")
    inicio()
}

fun inicio() {

    println ("Escolha sua operção")
    println ("1 - Ver Saldo")
    println ("2-  Fazer Depósito")
    println ("3 - Fazer Saque")
    println ("4 - Ver Extrato")
    println ("5 - Transferencia")
    println("6 -  Sair")


    val escolha = readLine()?.toIntOrNull()

    when (escolha) {
        1 ->
        {
            verSaldo()
            alertadeSaldoInsuficiente()
        }


        2 ->
        {
            fazerDeposito()
            alertadeHorario()
        }


        3 ->
            fazerSaque()


        4 ->
            verExtrato()

        5 ->
            Transferencia()

        6->
            sair()

        else -> erro()
    }

}

fun verSaldo() {
    println("Conferir Saldo: $saldo ")
    inicio()
}

fun  fazerDeposito () {
    println(" Qual valor para depósito? ")
    val deposito = readLine()?.toFloatOrNull()

// Funcionando

    if (deposito == null) {
        println("Por favor, informe um número válido ")
        fazerDeposito()

    }
    else {
        saldo += deposito
        transacoes.add("+ Depósito: R$ $deposito")
        verSaldo()
    }

}

 fun alertadeHorario () {
     val horaAtual = java.time.LocalTime.now().hour
     if (horaAtual < 9 || horaAtual > 22) {
         println("⚠️  Aviso: Você está realizando um depósito fora do horário comercial (9h às 17h).")
     } else {
         println("Depósito realizado dentro do horário comercial.")
     }
    }


// Funcionando
fun fazerSaque () {
    println("Qual o valor para saque? ")
    val saque = readlnOrNull()?.toFloatOrNull()


    if (saque == null) { // Funcionando
        println("Por favor, informe um valor positivo:  ")
        fazerSaque()
    } else {
        saldo -= saque
        transacoes.add("- Saque: R$ $saque")
        verSaldo()
    }

}

fun alertadeSaldoInsuficiente( limite: Double = 50.0) {
    if (saldo < 0) {
        println("⚠️  Atenção: seu saldo (R$ %.2f) está abaixo de R$ %.2f".format(saldo, limite))
    }
    else {
        println("Saldo suficiente para realizar transações.")
    }
}

fun verExtrato () {
    println("Extrato: ")
    println("Saldo atual: $saldo")
    println("\n Ultimas transações: " )

    if (transacoes.isEmpty()) {
        println("Nenhuma transação realizada.")
    } else {

        transacoes.forEach { println(it) }
    }
}


fun Transferencia() {
    println("Informe o valor para transferência: ")
    val valorTransferencia = readLine()?.toFloatOrNull()

    if (valorTransferencia == null) {
        println("Por favor, informe um número válido")
        Transferencia()
    } else {
        saldo -= valorTransferencia
        transacoes.add("- Transferência: R$ $valorTransferencia")
        verSaldo()
    }
}

fun erro(){
    println("Por favor, informe um número de 1 a 6")
    inicio()
}

fun sair() {
    println("Você deseja sair? (S/N")
    val confirma = readLine()!!.uppercase()   //Tá ai amigo Kayan : '!!' esse é o diferencial
    //Funcionando
    when (confirma) {
        "S" -> exitProcess(0)
        "N" -> inicio()
        else -> sair()
    }
}



