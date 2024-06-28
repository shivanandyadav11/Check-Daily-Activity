package ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.action.ActionHandler

@Composable
fun HomeContent(name: State<String?>, actionHandler: ActionHandler) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            GreetingSection(name)
            Spacer(modifier = Modifier.height(16.dp))
            TaskOverviewSection()
            Spacer(modifier = Modifier.height(40.dp))
            TodayTasksSection()
        }
        BottomNavigationBar(modifier = Modifier.align(Alignment.BottomCenter), actionHandler)
    }
}

@Composable
fun GreetingSection(name: State<String?>) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        Column {
            Text("Hi, ${name.value}", fontWeight = FontWeight.Bold, fontSize = 32.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Let's make this day productive")
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            Icons.Default.Person,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Gray)
        )
    }
}

@Composable
fun TaskOverviewSection() {
    val completedBrush = Brush.linearGradient(listOf(Color(0xFF66CCFF), Color(0xFF0099FF)))
    val canceledBrush = Brush.linearGradient(listOf(Color(0xFFFFA726), Color(0xFFFF6F00)))
    val pendingBrush = Brush.linearGradient(listOf(Color(0xFFBA68C8), Color(0xFF7E57C2)))
    val onGoingBrush = Brush.linearGradient(listOf(Color(0xFFAED581), Color(0xFF7CB342)))

    Spacer(modifier = Modifier.height(16.dp))
    Text("My Task", fontWeight = FontWeight.Bold, fontSize = 32.sp)
    Spacer(modifier = Modifier.height(24.dp))
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        Column(modifier = Modifier.weight(1f)) {
            TaskOverviewCard(
                "Completed",
                86,
                completedBrush,
                Icons.Default.CheckCircle,
                modifier = Modifier.size(88.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            TaskOverviewCard("Canceled", 15, canceledBrush, Icons.Default.Close)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            TaskOverviewCard("Pending", 15, pendingBrush, Icons.Default.Notifications)
            Spacer(modifier = Modifier.height(8.dp))
            TaskOverviewCard(
                "On Going",
                67,
                onGoingBrush,
                Icons.Default.Face,
                modifier = Modifier.size(88.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun TaskOverviewCard(
    title: String,
    count: Int,
    brush: Brush,
    icon: ImageVector,
    modifier: Modifier = Modifier.size(24.dp)
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(16.dp))
            .shadow(8.dp, RoundedCornerShape(16.dp)),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(brush)
                .clip(RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Icon(
                        icon,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = modifier
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        Icons.Default.AddCircle,
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(title, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Text("$count Task", color = Color.White)
            }
        }
    }
}

@Composable
fun TodayTasksSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Today Task", fontWeight = FontWeight.Bold, fontSize = 32.sp)
        Text("View all", color = Color(0xFF5B67CA))
    }
    Spacer(modifier = Modifier.height(8.dp))
    TodayTaskItem("Cleaning Clothes", "07:00 - 07:15", listOf("Urgent", "Home"))
    Spacer(modifier = Modifier.height(8.dp))
    TodayTaskItem("Cleaning Clothes", "07:00 - 07:15", listOf("Urgent", "Home"))
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun TodayTaskItem(taskName: String, time: String, tags: List<String>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(taskName, fontWeight = FontWeight.Bold)
            Text(time, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                tags.forEach {
                    Text(
                        it,
                        color = Color.White,
                        modifier = Modifier
                            .background(Color.Gray, RoundedCornerShape(8.dp))
                            .padding(4.dp)
                            .padding(horizontal = 8.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier, actionHandler: ActionHandler) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        BottomAppBar(
            cutoutShape = CircleShape,
            backgroundColor = Color.White,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .height(80.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 16.dp,
                    shape = RoundedCornerShape(16.dp),
                    spotColor = Color.Black
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Home, contentDescription = "Home")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
                FloatingActionButton(
                    onClick = { actionHandler.onAddButtonClick.invoke() },
                    shape = CircleShape,
                    backgroundColor = Color(0xFF5B67CA),
                    contentColor = Color.White,
                    modifier = Modifier
                        .clip(CircleShape)
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Person, contentDescription = "Profile")
                }
            }
        }
    }
}

