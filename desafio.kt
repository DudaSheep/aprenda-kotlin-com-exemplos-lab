enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nomeAluno: String) 

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional> = emptyList()) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) : Boolean {    
        return inscritos.add(usuario)               
    }
    
    
    fun printAllInscritos(){
        for (inscrito in inscritos) {                               
    	println("${inscrito.nomeAluno} esta matriculada(o)")
		}
    }
    
    
    fun printAllConteudoEducacional(){
        for (i in conteudos) {                               
    	println("${i.nome} - ${i.nivel} - ${i.duracao} horas")
        }
    }   
    
}


fun main() {
    //Alunos
    val aluno1 = Usuario("Alice")
    val aluno3 = Usuario("Nemo")
    val aluno2 = Usuario("Dora")

    
    //Conteudos
    val conteudo1 = ConteudoEducacional("Code Class", Nivel.BASICO, 60)
    val conteudo2 = ConteudoEducacional("Algoritmo", Nivel.INTERMEDIARIO, 100)
    //cria lista de ConteudoEducacional
    val listCont = mutableListOf<ConteudoEducacional>()
    listCont.add(conteudo1)
    listCont.add(conteudo2)
    
    //Formações
    val kotlin: Formacao = Formacao("Kotlin", Nivel.INTERMEDIARIO, listCont)
    val android: Formacao = Formacao("Test", Nivel.DIFICIL, listCont)
    
    //matricula alunos - Usuario
    kotlin.matricular(aluno1)    
    android.matricular(aluno2)    
    kotlin.matricular(aluno3)
    
    //listas
    kotlin.printAllInscritos()
    kotlin.printAllConteudoEducacional()
    android.printAllInscritos()
    android.printAllConteudoEducacional() 
    
    
    
}