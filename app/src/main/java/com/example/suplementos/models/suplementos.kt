package com.example.suplementos.models


import com.example.suplementos.R

data class suplementos(
    val imagem:Int,
    val nome:String,
    val descricao: String,
    val preco: String,
    val video: Int,

)
object SuplementosRepository{
    fun getSuplementos():List<suplementos>{
        return listOf(
            suplementos(R.drawable.whey,"whey","Whey Protein Growth é a proteína ideal para quem treina hipertrofia e quer ganhar massa muscular. Ideal porque é um suplemento de alto valor biológico com grande concentração de proteínas e aminoácidos essenciais é também rico em Glutamina, BCAA (incluindo Leucina).","R$ 100,00",R.raw.sobrewhey),
            suplementos(R.drawable.creatina,"Creatina","Esse produto é uma das principais escolhas dos atletas mais famosos e de quem está investindo na hipertrofia. Você consegue ganhar massa muscular e, ao mesmo tempo, garantir um ganho de força sem igual.","R$ 49,90", R.raw.sobrecreatina),
            suplementos(R.drawable.bcaa,"BCAA","Um dos suplementos líderes em vendas, o BCAA é a opção perfeita para quem deseja evolução nos treinos, como o ganho de massa muscular. Isso acontece porque seu consumo estimula uma melhora importante no metabolismo de quem está buscando mudanças no físico.","R$ 29,99", R.raw.sobrewhey),
            suplementos(R.drawable.glutamina,"Glutamina","Indispensável para o metabolismo de um organismo saudável, a glutamina tem importantes funções e pode ser um auxílio tanto para quem pratica exercícios físicos intensos quanto para quem busca apenas uma rotina ainda mais saudável. Consulte um profissional nutricionista para ser orientado acerca da necessidade deste suplemento.","R$ 39,99", R.raw.sobreglutamina),
            suplementos(R.drawable.albumina,"Albumina","Quem busca suplementos para ganhar massa muscular encontra na albumina uma das melhores alternativas. Rica fonte de proteína, ela tem destaque especialmente entre quem aposta em um estilo de vida mais saudável combinado a exercícios físicos regulare","R$ 85,50", R.raw.sobrewhey),
            suplementos(R.drawable.pretreino,"Pré-treino","Pré-treino é tudo aquilo que pode ser consumido como fonte de nutrientes e energia na refeição que antecede o treino. Não há limitação, podemos falar de uma refeição - alimentos ou podemos falar de suplementos. Por conveniência os suplementos pré-treino são confeccionados com substâncias fontes de calorias e/ou substâncias estimulantes da performance física isentos de calorias.","R$ 89,99", R.raw.sobrewhey)

        )
    }
}
