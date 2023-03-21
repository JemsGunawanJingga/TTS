package edu.uksw.fti.pam.acitivityintent.ui.screens

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.acitivityintent.HomeActivity
import edu.uksw.fti.pam.acitivityintent.contracts.SignUpContract
import edu.uksw.fti.pam.acitivityintent.ui.theme.PAMAcitivityIntentTheme
import edu.uksw.fti.pam.acitivityintent.R

internal fun doAuth(
    username: String,
    password: String, ): Boolean {
    return (username.equals("admin") && password.equals("admin"))
}

internal fun doAuthregistrasi(username: String,password:String, cuser:String,cpassword:String): Boolean {
    return (username.equals(cuser) && password.equals(cpassword))
}

@Composable
fun LoginForm() {
    val lContext = LocalContext.current

    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var firstnameInput by remember { mutableStateOf("") }
    var lastnameInput by remember { mutableStateOf("") }
    var cuser by remember { mutableStateOf("Belum Registrasi") }
    var cpass by remember { mutableStateOf("Sama") }
    var listprofile: ArrayList<String>?
    val paddingModifier = Modifier.padding(10.dp)



    val getUsernameFromSignedUpForm = rememberLauncherForActivityResult(
        contract = SignUpContract(),
        onResult = { listprofile = it!!
        usernameInput = listprofile!![2]
        passwordInput = listprofile!![3]
        firstnameInput = listprofile!![1]
        lastnameInput = listprofile!![0]
        cuser = listprofile!![2]
        cpass = listprofile!![3]
        })

    val gradient = Brush.verticalGradient(
        0.0f to Color.Magenta,
        0.5f to Color.Cyan,
        startY = 0.0f,
        endY = 1500.0f
    )


    Column(
        modifier = Modifier
            .background(gradient)
            .fillMaxSize()
            .padding(top = 50.dp)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = stringResource(id = R.string.label_Login1),
            fontSize=24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 110.dp)


        )
        OutlinedTextField(
            value = usernameInput,
            onValueChange = { usernameInput = it },
            label = { Text(text = stringResource(R.string.label_username)) },
            modifier = Modifier.fillMaxWidth(),

            )
        OutlinedTextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            label = { Text(text = stringResource(R.string.label_password)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
        )
        Row(

            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                modifier = Modifier
                    .padding(start = 2.dp),
                onClick = {
                    val isAuthenticated = doAuth(usernameInput, passwordInput)
                    val isAuthenticatedregistrasi = doAuthregistrasi(usernameInput, passwordInput, cuser, cpass)
                    if (isAuthenticated||isAuthenticatedregistrasi) {
                        lContext.startActivity(
                            Intent(lContext, HomeActivity::class.java)
                                .apply {
                                    putExtra("nama", listNama(firstnameInput,lastnameInput))
                                }
                        )
                    }
                }
            ) {
                Text(text = stringResource(R.string.btn_title_login))
            }
            Button(

                onClick = {
                    getUsernameFromSignedUpForm.launch("")
                }
            ) {
                Text(text = stringResource(R.string.btn_title_signup))
            }
        }
    }
}

fun listNama(first:String,last:String):ArrayList<String>{
    val list = ArrayList<String>()
    list.add(last)
    list.add(first)
    return list
}


@Preview(showBackground = true)
@Composable
fun LoginFormPreview() {
    PAMAcitivityIntentTheme {
        LoginForm()
    }
}