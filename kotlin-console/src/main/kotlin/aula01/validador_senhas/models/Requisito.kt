package aula01.validador_senhas.models

data class Requisito(
    val mensagemErro: String,
    val validacao: (String) -> Boolean
)
