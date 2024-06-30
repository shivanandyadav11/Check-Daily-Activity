package ui.widgets

import PlatformDate
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun CustomDatePickerDialog(
    onDismissRequest: () -> Unit,
    onDateSelected: (String) -> Unit
) {
    val platformDate = PlatformDate()
    var selectedDate by remember { mutableStateOf(platformDate.getCurrentDate()) }
    val firstDayOfWeek = platformDate.getFirstDayOfWeek(selectedDate)
    val daysInMonth = platformDate.getDaysInMonth(selectedDate)
    val dayOfWeek = platformDate.getDayOfWeek(selectedDate)
    val year = platformDate.getYear(selectedDate)
    val days = (1..daysInMonth).toList()
    val paddingDays = (1 until dayOfWeek).toList()

    Dialog(onDismissRequest = onDismissRequest, properties = DialogProperties()) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "October 2020", fontSize = 20.sp, color = Color.Black)
                Spacer(modifier = Modifier.height(16.dp))
                DaysOfWeekHeader()
                CalendarGrid(
                    days = days,
                    paddingDays = paddingDays,
                    selectedDate = daysInMonth,
                    onDayClick = { day ->
                        // TODO fix date picker
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(onClick = onDismissRequest) {
                        Text(text = "Cancel", color = Color(0xFF5B67CA))
                    }
                    Button(
                        onClick = {
                            onDateSelected("${daysInMonth}/${daysInMonth + 1}/${year}")
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF5B67CA))
                    ) {
                        Text(text = "Save", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun DaysOfWeekHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val daysOfWeek = listOf("Mo", "Tu", "We", "Th", "Fr", "Sa", "Su")
        daysOfWeek.forEach { day ->
            Text(text = day, fontSize = 16.sp, color = Color.Gray)
        }
    }
}

@Composable
fun CalendarGrid(
    days: List<Int>,
    paddingDays: List<Int>,
    selectedDate: Int,
    onDayClick: (Int) -> Unit
) {
    val totalCells = paddingDays.size + days.size
    val rows = (totalCells / 7) + if (totalCells % 7 == 0) 0 else 1
    Column {
        for (i in 0 until rows) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (j in 0..6) {
                    val index = i * 7 + j
                    if (index < paddingDays.size) {
                        Box(modifier = Modifier.size(40.dp)) // Empty cells before the first day
                    } else {
                        val dayIndex = index - paddingDays.size
                        if (dayIndex < days.size) {
                            val day = days[dayIndex]
                            val isSelected = day == selectedDate
                            DayCell(day = day, isSelected = isSelected, onClick = { onDayClick(day) })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DayCell(day: Int, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(
                color = if (isSelected) Color(0xFF5B67CA) else Color.Transparent,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = day.toString(),
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 16.sp
        )
    }
}
