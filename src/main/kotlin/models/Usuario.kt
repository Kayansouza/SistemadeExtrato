/**
 * CLASSE USUARIO - O JOGADOR DO NOSSO TIME
 *
 * Representa um usuário do sistema bancário com seus dados pessoais.
 * Como um jogador de futebol, tem nome, documentação, contato e "matrícula" (senha).
 */
data class Usuario(
    val nome: String,
    val cpf: String,
    val email: String,
    val telefone: String,
    val dataNascimento: String,
    val senha: String
)

