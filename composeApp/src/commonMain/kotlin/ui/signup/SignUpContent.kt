package ui.signup

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
fun SignUpContent(
    phone: Boolean = true,
    onCreateButtonClick: (String, String, String) -> Unit,
    onLoginTextClicked: () -> Unit,
) {
    val modifier: Modifier = if (phone) Modifier.fillMaxWidth() else Modifier.fillMaxWidth(0.4f)
    var username by remember { mutableStateOf("") }
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
                text = "Sign Up",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5B67CA)
            )
            Spacer(modifier = Modifier.height(48.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                leadingIcon = {
                    Icon(Icons.Filled.Person, contentDescription = null)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = if (username.isNotEmpty()) Color(0xFF5B67CA) else Color.Gray,
                    unfocusedBorderColor = if (username.isNotEmpty()) Color(0xFF5B67CA) else Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email ID") },
                leadingIcon = {
                    Icon(Icons.Filled.Email, contentDescription = null)
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
                    Icon(Icons.Filled.Lock, contentDescription = null)
                },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = if (password.isNotEmpty()) Color(0xFF5B67CA) else Color.Gray,
                    unfocusedBorderColor = if (password.isNotEmpty()) Color(0xFF5B67CA) else Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { onCreateButtonClick(username, email, password) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF5B67CA)),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(text = "Create", color = Color.White)
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
                    modifier = Modifier.size(40.dp).clickable { /* Handle Google sign up */ }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(Res.drawable.fb_img),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp).clickable { /* Handle Facebook sign up */ }
                )
            }
            Spacer(modifier = Modifier.height(48.dp))

            Row {
                Text(text = "Have any account?")
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Sign In",
                    color = Color(0xFF5B67CA),
                    modifier = Modifier.clickable { onLoginTextClicked() }
                )
            }
        }
    }
}
