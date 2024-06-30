import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.datetime.LocalDate
import platform.Foundation.*

actual class PlatformDate actual constructor() {
    actual fun getCurrentDate(): LocalDate {
        val calendar = NSCalendar.currentCalendar
        val components = calendar.components(NSCalendarUnitDay or NSCalendarUnitMonth or NSCalendarUnitYear, fromDate = NSDate())
        return LocalDate(components.year.toInt(), components.month.toInt(), components.day.toInt())
    }

    actual fun getFirstDayOfWeek(currentDate: LocalDate): Int {
        val calendar = NSCalendar.currentCalendar()
        val components = NSDateComponents().apply {
            year = currentDate.year.toLong()  // Ensure types match expected platform types
            month = currentDate.monthNumber.toLong()
            day = 1L  // First day of the month
        }
        val date = calendar.dateFromComponents(components)!!
        return calendar.component(NSCalendarUnitWeekday, fromDate = date).toInt()
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun getDaysInMonth(currentDate: LocalDate): Int {
        val calendar = NSCalendar.currentCalendar()
        val components = NSDateComponents().apply {
            year = currentDate.year.toLong()
            month = currentDate.monthNumber.toLong()
        }
        val date = calendar.dateFromComponents(components)!!
        val range = calendar.rangeOfUnit(NSCalendarUnitDay, inUnit = NSCalendarUnitMonth, forDate = date)
        return range.size
    }

    actual fun getDayOfWeek(date: LocalDate): Int {
        val calendar = NSCalendar.currentCalendar()
        val components = NSDateComponents().apply {
            year = date.year.toLong()
            month = date.monthNumber.toLong()
            day = date.dayOfMonth.toLong()
        }
        val nsDate = calendar.dateFromComponents(components)!!
        return calendar.component(NSCalendarUnitWeekday, fromDate = nsDate).toInt()
    }

    actual fun getYear(date: LocalDate): Int {
        val calendar = NSCalendar.currentCalendar()
        val components = NSDateComponents().apply {
            year = date.year.toLong()
            month = date.monthNumber.toLong()
            day = date.dayOfMonth.toLong()
        }
        val nsDate = calendar.dateFromComponents(components)!!
        return calendar.component(NSYearForWeekOfYearCalendarUnit, fromDate = nsDate).toInt()
    }

    actual fun getNewDay(date: LocalDate, days: Int): LocalDate {
        val calendar = NSCalendar.currentCalendar
        val components = calendar.components(NSCalendarUnitDay or NSCalendarUnitMonth or NSCalendarUnitYear, fromDate = NSDate())
        return LocalDate(components.year.toInt(), components.month.toInt(), days)
    }
}
