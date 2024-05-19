package ui.landing

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import checkdailyactivity.composeapp.generated.resources.Res
import checkdailyactivity.composeapp.generated.resources.daily_activity_image
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LandingContent(
    phone: Boolean = true,
    onLogInClick : () -> Unit,
    onSignUpClick: () -> Unit,
) {
    
    val modifier: Modifier = if (phone) Modifier.fillMaxWidth() else Modifier.fillMaxWidth(0.4f)
    
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxHeight(),
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                Image(
                    painter = painterResource(Res.drawable.daily_activity_image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    alignment = Alignment.Center,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom,
            ) {
                Spacer(modifier = Modifier.height(64.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 32.dp).fillMaxWidth(),
                    text = "Check Daily Activity",
                    color = Color(0xFF5B67CA),
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 32.dp),
                    text = "Plan what you will do to be more organized for today, tomorrow and beyond",
                    color = Color(0xFF2C406E),
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(25),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF5B67CA)),
                    onClick = onLogInClick,
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        text = "Login",
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(25),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    onClick = { onSignUpClick() },
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        text = "Sign Up",
                        color = Color(0xFF5B67CA),
                        fontSize = 20.sp,
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}