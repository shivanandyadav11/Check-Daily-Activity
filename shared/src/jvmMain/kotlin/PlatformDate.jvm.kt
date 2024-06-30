import kotlinx.datetime.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.Calendar

actual class PlatformDate actual constructor() {
    actual fun getCurrentDate(): LocalDate {
        val now = ZonedDateTime.now(ZoneId.systemDefault())
        return LocalDate(now.year, now.monthValue, now.dayOfMonth)
    }

    actual fun getFirstDayOfWeek(currentDate: LocalDate): Int {
        val calendar = Calendar.getInstance()
        calendar.set(currentDate.year, currentDate.monthNumber - 1, currentDate.dayOfMonth)
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        return calendar.get(Calendar.DAY_OF_WEEK)
    }

    actual fun getDaysInMonth(currentDate: LocalDate): Int {
        val calendar = Calendar.getInstance()
        calendar.set(currentDate.year, currentDate.monthNumber - 1, currentDate.dayOfMonth)
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    actual fun getDayOfWeek(date: LocalDate): Int {
        val calendar = Calendar.getInstance()
        calendar.set(date.year, date.monthNumber - 1, date.dayOfMonth)
        return calendar.get(Calendar.DAY_OF_WEEK)
    }

    actual fun getYear(date: LocalDate): Int {
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.YEAR)
    }

    actual fun getNewDay(date: LocalDate, days: Int): LocalDate {
        return LocalDate(date.year, date.monthNumber - 1, days)
    }
}