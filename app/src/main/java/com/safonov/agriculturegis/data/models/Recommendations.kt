package com.safonov.agriculturegis.data.models

sealed class Recommendations(
    open val range: IntRange,
    open val recommendation: String
){
    class FirstCategory(
        override val range: IntRange = 0..6,
        override val recommendation: String = FIRST_ADVISE
    ): Recommendations(range, recommendation)
    class SecondCategory(
        override val range: IntRange = 6..13,
        override val recommendation: String = SECOND_ADVISE
    ): Recommendations(range, recommendation)
    class ThirdCategory(
        override val range: IntRange = 13..19,
        override val recommendation: String = THIRD_ADVISE
    ):  Recommendations(range, recommendation)
    class FourthCategory(
        override val range: IntRange = 19..25,
        override val recommendation: String = FOURTH_ADVISE
    ): Recommendations(range, recommendation)
    object Unknown {
        const val recommendation: String = UNKNOWN
    }

    private companion object {
        const val FIRST_ADVISE = "Переувлажнение почвы. Требуются мероприятия, направленные на ускорение формирования и отвода поверхностного стока: узкозагонная вспашка, профилирование поверхности, выборочное "
        const val SECOND_ADVISE = "Регулярный полив. Требуется умеренный режим орошения"
        const val THIRD_ADVISE = "Обильный полив. Требуется гибкий и обильный режим орошения для обеспечения растений влагой в период роста и развития культуры"
        const val FOURTH_ADVISE = "Засуха. Требуется долгий и обильный полив в прохладные часы, идеальный график с 5-6 утра до 12-13 дня, с 17-18 часов до захода солнца"
        const val UNKNOWN = "Значение не предусмотрено"
    }
}
