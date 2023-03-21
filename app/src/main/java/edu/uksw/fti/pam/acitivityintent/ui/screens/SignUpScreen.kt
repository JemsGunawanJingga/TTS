package edu.uksw.fti.pam.acitivityintent.ui.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.acitivityintent.HomeActivity
import edu.uksw.fti.pam.acitivityintent.ui.theme.PAMAcitivityIntentTheme
import edu.uksw.fti.pam.acitivityintent.R

@Composable
fun SignUpForm(
    btnOnClickAction: (ArrayList<String>?) -> Unit

) {
    val lContext = LocalContext.current
    var firstnameInput by remember { mutableStateOf("") }
    var lastnameInput by remember { mutableStateOf("") }
    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var confirmpasswordInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color(0XFFF6EDFF))
            .fillMaxSize()
            .padding(top = 50.dp)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = stringResource(id = R.string.label_Signup1),fontSize=24.sp ,
            modifier = Modifier
                .padding(start = 120.dp, bottom = 15.dp)
        )
        Row {
            TextField(
                modifier = Modifier
                    .width(170.dp)
                    .padding(end = 10.dp)
                    .clip(CircleShape),
                value = firstnameInput,
                onValueChange = {firstnameInput= it},
                label = { Text(text = stringResource(R.string.label_firstname))}
            )
            Spacer(modifier = Modifier.weight(1f))
            TextField(
                modifier = Modifier
                    .clip(CircleShape),
                value = lastnameInput,
                onValueChange = {lastnameInput = it},
                label = { Text(text = stringResource(R.string.label_lastname)) },

                )
        }
        TextField(
            value = usernameInput,
            onValueChange = {usernameInput = it},
            label = { Text(text = stringResource(R.string.label_username)) },
            modifier = Modifier.fillMaxWidth(),
        )
        TextField(
            value = passwordInput,
            onValueChange = {passwordInput = it},
            label = { Text(text = stringResource(R.string.label_password)) },
            modifier = Modifier.fillMaxWidth(),
        )
        TextField(
            value = confirmpasswordInput,
            onValueChange = {confirmpasswordInput = it},
            label = { Text(text = stringResource(R.string.label_passwordconfirm)) },
            modifier = Modifier.fillMaxWidth(),
        )
        Button(
            modifier = Modifier
                .padding(start = 255.dp),
            onClick = {
                btnOnClickAction(listProfile(firstnameInput,lastnameInput,usernameInput,passwordInput))
            }
        ) {
            Text(stringResource(R.string.btn_label_ok))
        }
    }
}

fun listProfile(first:String,last:String,username:String,password:String): ArrayList<String> {
    val list = ArrayList<String>()
    list.add(first)
    list.add(last)
    list.add(username)
    list.add(password)
    return list
}


@Preview(showBackground = true)
@Composable
fun SignUpFormPreview() {
    PAMAcitivityIntentTheme {
        SignUpForm({})
    }
}