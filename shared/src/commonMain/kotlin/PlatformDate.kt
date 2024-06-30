import kotlinx.datetime.LocalDate

expect class PlatformDate() {
    fun getCurrentDate(): LocalDate
    fun getFirstDayOfWeek(currentDate: LocalDate): Int
    fun getDaysInMonth(currentDate: LocalDate): Int
    fun getDayOfWeek(date: LocalDate): Int
    fun getYear(date: LocalDate): Int
    fun getNewDay(date: LocalDate, days: Int): LocalDate
}