package ui.personal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.Colors.floatingButtonBackgroundColor
import theme.Colors.floatingButtonContentColor
import ui.widgets.SearchAndFilterBar
import ui.widgets.TaskItem

@Composable
fun PersonalContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            TopBar()
            Spacer(modifier = Modifier.height(16.dp))
            SearchAndFilterBar()
            Spacer(modifier = Modifier.height(16.dp))
            TaskList()
        }
        FloatingActionButton(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            backgroundColor = floatingButtonBackgroundColor,
            contentColor = floatingButtonContentColor,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .clip(CircleShape)
                .graphicsLayer {
                    shadowElevation = 16.dp.toPx()
                    shape = CircleShape
                    clip = true
                }
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }
}


@Composable
fun TopBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text("Personal", fontWeight = FontWeight.Bold, fontSize = 20.sp)
    }
}

@Composable
fun TaskList() {
    Column {
        for (i in 1..5) {
            TaskItem("Cleaning Clothes", "07:00 - 07:15", listOf("Urgent", "Home"))
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
