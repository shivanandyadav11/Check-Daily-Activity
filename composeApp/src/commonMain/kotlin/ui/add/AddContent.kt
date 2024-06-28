package ui.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddContent() {
    var title by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("4 August 2021") }
    var startTime by remember { mutableStateOf("07:00 AM") }
    var endTime by remember { mutableStateOf("07:30 AM") }
    var description by remember { mutableStateOf("Creating this month's work plan") }
    var selectedType by remember { mutableStateOf("Personal") }
    val tags = listOf("Office", "Home", "Urgent", "Work")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(end = 32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Add Task")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                backgroundColor = Color.White
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(24.dp)
        ) {
            Text("Title", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF8E8E8E))
            Spacer(modifier = Modifier.height(4.dp))
            StyledTextField(value = title, onValueChange = { title = it })

            Spacer(modifier = Modifier.height(16.dp))

            Text("Date", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF8E8E8E))
            Spacer(modifier = Modifier.height(4.dp))
            StyledTextField(value = date, onValueChange = { date = it })

            Spacer(modifier = Modifier.height(16.dp))

            Text("Time", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF8E8E8E))
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StyledTextField(
                    value = startTime,
                    onValueChange = { startTime = it },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                StyledTextField(
                    value = endTime,
                    onValueChange = { endTime = it },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Description",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF8E8E8E)
            )
            Spacer(modifier = Modifier.height(4.dp))
            StyledTextField(value = description, onValueChange = { description = it })

            Spacer(modifier = Modifier.height(16.dp))

            Text("Type", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF8E8E8E))
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                listOf("Personal", "Private", "Secret").forEach { type ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        RadioButton(
                            selected = (type == selectedType),
                            onClick = { selectedType = type }
                        )
                        Text(text = type, fontSize = 14.sp, color = Color(0xFF000000))
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Tags", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF8E8E8E))
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                tags.forEach { tag ->
                    Chip(tag)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "+ Add new tag",
                fontSize = 14.sp,
                color = Color(0xFF8E8E8E),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(25),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF5B67CA)),
                onClick = { /* TODO */ },
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = "Create",
                    color = Color.White,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

@Composable
fun StyledTextField(value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 8.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFE0E0E0))
        )
    }
}

@Composable
fun Chip(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color(0xFFE0E0E0), shape = CircleShape)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = text, fontSize = 14.sp, color = Color(0xFF000000))
    }
}
