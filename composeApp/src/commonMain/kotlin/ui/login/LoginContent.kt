package ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import checkdailyactivity.composeapp.generated.resources.Res
import checkdailyactivity.composeapp.generated.resources.fb_img
import checkdailyactivity.composeapp.generated.resources.google_img
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LoginContent(
    phone: Boolean = true,
    onLogInButtonClick: (String, String) -> Unit,
    onSignUpTextClick: () -> Unit,
) {
    val modifier: Modifier = if (phone) Modifier.fillMaxWidth() else Modifier.fillMaxWidth(0.4f)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Login",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5B67CA)
            )
            Spacer(modifier = Modifier.height(48.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email ID or Username") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = null
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = if (email.isNotEmpty()) Color(0xFF5B67CA) else Color.Gray,
                    unfocusedBorderColor = if (email.isNotEmpty()) Color(0xFF5B67CA) else Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = if (password.isNotEmpty()) Color(0xFF5B67CA) else Color.Gray,
                    unfocusedBorderColor = if (password.isNotEmpty()) Color(0xFF5B67CA) else Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Forgot Password?",
                color = Color(0xFF5B67CA),
                modifier = Modifier.align(Alignment.End).clickable { }
            )
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    onLogInButtonClick(email, password)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF5B67CA)),
                shape = RoundedCornerShape(24)
            ) {
                Text(text = "Login", color = Color.White)
            }
            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "or with")
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(Res.drawable.google_img),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp).clickable { /* Handle Google login */ }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(Res.drawable.fb_img),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp).clickable { /* Handle Facebook login */ }
                )
            }
            Spacer(modifier = Modifier.height(48.dp))

            Row {
                Text(text = "Don't have an account?")
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Sign Up",
                    color = Color(0xFF5B67CA),
                    modifier = Modifier.clickable { onSignUpTextClick() }
                )
            }
        }
    }
}
