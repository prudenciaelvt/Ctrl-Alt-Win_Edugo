package com.example.edugo_app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.edugo_app.R
import com.example.edugo_app.navigation.Screen

@Composable
fun RegisterScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF006769))
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 50.dp)
                .align(Alignment.Center),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "REGISTER",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF006769)
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Untuk belajar asik dengan Edugo",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
                )
                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextFieldWithIcon(
                    value = "",
                    onValueChange = {},
                    label = "Username",
                    icon = R.drawable.iconprofile1
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextFieldWithIcon(
                    value = "",
                    onValueChange = {},
                    label = "Email",
                    icon = R.drawable.iconemail
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextFieldWithIcon(
                    value = "",
                    onValueChange = {},
                    label = "Nomor Handphone",
                    icon = R.drawable.icontelp
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextFieldWithIcon(
                    value = "",
                    onValueChange = {},
                    label = "Password",
                    icon = R.drawable.iconvisibility,
                    isPasswordField = true
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextFieldWithIcon(
                    value = "",
                    onValueChange = {},
                    label = "Confirm Password",
                    icon = R.drawable.iconvisibility,
                    isPasswordField = true
                )
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {   navController.navigate(Screen.Beranda.route)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006769))
                ) {
                    Text(text = "Daftar", color = Color.White, fontSize = 18.sp)
                }
            }
        }
    }
}

@Composable
fun OutlinedTextFieldWithIcon(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: Int,
    isPasswordField: Boolean = false
) {
    var passwordVisibility by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        trailingIcon = {
            IconButton(
                onClick = {
                    if (isPasswordField) passwordVisibility = !passwordVisibility
                },
                enabled = isPasswordField || !isPasswordField
            ) {
                Icon(
                    painter = painterResource(
                        id = if (isPasswordField) {
                            if (passwordVisibility) R.drawable.iconvisibility else R.drawable.iconvisibility
                        } else icon
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )
            }
        },
        visualTransformation = if (isPasswordField && !passwordVisibility) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier.fillMaxWidth()
    )
}




@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(navController = rememberNavController())
}
