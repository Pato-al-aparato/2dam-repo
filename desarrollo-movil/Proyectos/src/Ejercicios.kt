fun main(){
    //ex1()
    //ex2()
    //ex3()
    //ex4()
    ex5()
}

fun ex1 (){
    /*Declara dos variables numericas (con el valor que desees).
    muestra por consola la suma, resta, multiplicación, división y módulo. */

    val num1 = 12.3
    val num2 = 7

    val suma = num1 + num2
    val resta = num1 - num2
    val multi = num1 * num2
    val division = num1 / num2
    val modulo = num1 % num2

    println("La suma de $num1 + $num2 es: $suma")
    println("La resta de $num1 - $num2 es: ${"%.2f".format(resta)}")
    println("La multiplicación de $num1 x ${"%.2f".format(multi)}")
    println("La división de $num1 / $num2 es ${"%.2f".format(division)}")
    println("El módulo de $num1 % $num2 es: ${"%.2f".format(modulo)}")
}

fun ex2 (){
    /* Declara un string que contenga tu nombre, después muestra un
    mensaje de bievenida por consola. Por ejemplo: si la variable
    contiene "Pedro", que muestre "Bievenido Pedro".
     */

    val nombre : String = "Dragos"
    println("Bienvenido $nombre!!")
}

fun ex3 (){
    // Modifica el ejercicio anterior pidiendo al usuario el nombre

    print("¿Cual es tu nombre? ")
    val nombre = readln()
    println("Bienvenido $nombre!!")
}

fun ex4 (){
    /* Solicita por pantalla 2 números y muestra cuál es mayor de los dos.
    Si son iguales indicalo también.*/
    val mayor: Int
    val menor: Int

    print("Introduce un número: ")
    val num1 : Int = readln().toInt()

    print("Introduce otro número: ")
    val num2 : Int = readln().toInt()

    if(num1 > num2){
        mayor = num1
        println("$num1 es mayor")
    } else if (num2 > num1) {
        mayor = num2
        println("$num2 es mayor")
    } else
        println("Los números $num1 y $num2 son iguales")
}

fun ex5 (){
    /* Lee un número por teclado e indica si es divisible entre 2.
    Si no lo es, indícalo también.*/

    print("Introduce un número: ")
    val num : Int = readln().toInt()

    if(num % 2 == 0){
        println("El número $num es divisible entre 2")
    } else {
        println("El número $num no es divisible entre 2")
    }
}
