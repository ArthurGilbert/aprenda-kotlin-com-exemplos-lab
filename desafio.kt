enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val name: String, val email: String, val matricula: Int)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int)

data class Formacao(val nome: String, val conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
        }
    }
        
    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos += conteudo
    }
    
    fun listarConteudos(): List<ConteudoEducacional> {
        return conteudos
    }
        
    fun buscarConteudosPorNivel(nivel: Nivel): List<ConteudoEducacional> {
        return conteudos.filter { it.nivel == nivel }
    }
    
    fun listarAlunosMatriculados(): List<Usuario> {
        return inscritos
    }
}

fun main() {
    val usuario1 = Usuario("João", "joao@email.com", 1)
    val usuario2 = Usuario("Maria", "maria@email.com", 2)

    val formacao = Formacao("Formacao de Kotlin", mutableListOf())
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", nivel = Nivel.BASICO, duracao = 30)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", nivel = Nivel.INTERMEDIARIO, duracao = 60)

    formacao.adicionarConteudo(conteudo1)
    formacao.adicionarConteudo(conteudo2)

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    val conteudosBasicos = formacao.buscarConteudosPorNivel(Nivel.BASICO)
    println("Conteúdos básicos na formação: $conteudosBasicos")

    val alunosMatriculados = formacao.listarAlunosMatriculados()
    println("Alunos matriculados na formação: $alunosMatriculados")
}