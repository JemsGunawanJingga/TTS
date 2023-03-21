package edu.uksw.fti.pam.acitivityintent.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.acitivityintent.R
import edu.uksw.fti.pam.acitivityintent.ui.theme.PAMAcitivityIntentTheme

@Composable
fun ProfileScreen(firstname:String?,lastname:String?) {
    var firstName: String
    var lastName: String

    firstName = firstname.toString()
    lastName = lastname.toString()


    Column(

    ) {


        TopAppBar(
            modifier = Modifier
                .height(50.dp)
        ) {
            Text(
                text = "Profile",
                modifier = Modifier
                    .padding(start = 5.dp),
                fontWeight = FontWeight.SemiBold
            )
        }

        Row (
            modifier = Modifier
                .clickable { }
                .fillMaxWidth()
                .height(90.dp)
                .padding(top = 10.dp, bottom = 10.dp)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically

        ){
            Image(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .padding(top = 10.dp, start = 10.dp)
                    .background(Color.Cyan),
                alignment = Alignment.TopStart,

                )
            Column {
                Row(
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                {Text(
                    text = "$firstName",
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 5.dp, start = 25.dp)
                )
                    Text(
                        text = "$lastName",
                        color = Color.Black,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 5.dp, start = 5.dp)
                    )
                }
            }
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(color = Color.Black)


        ) {
        }
    Column() {
        Text(text = "Daerah Pemilih",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(start = 110.dp, top= 20.dp)
        )
    }
        Column() {
            Row {
                Text(text = "Provinsi",
                modifier = Modifier
                    .padding(start = 10.dp, top = 20.dp)
                )
                Text(text = ":JAWA TENGAH",
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start = 72.dp, top = 20.dp)

                        )
            }
        }
        Column() {
            Row {
                Text(text = "Kab / Kota ",
                    modifier = Modifier
                        .padding(start = 10.dp, top = 5.dp)
                )
                Text(text = ":KOTA SALATIGA",
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start = 50.dp, top = 5.dp)
                )
            }
        }
        Column() {
            Row {
                Text(text = "Kecamatan",
                    modifier = Modifier
                        .padding(start = 10.dp, top = 5.dp)
                )
                Text(text = ":SIDOREJO",
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start = 50.dp, top = 5.dp)
                )
            }
        }
        Column() {
            Row {
                Text(text = "Desa / Kelurahan",
                    modifier = Modifier
                        .padding(start = 10.dp, top = 5.dp)
                )
                Text(text = ":BLOTONGAN",
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start = 10.dp, top = 5.dp)
                )
            }
        }
        Column() {
            Row {
                Text(text = "Tps",
                    modifier = Modifier
                        .padding(start = 10.dp, top = 5.dp)
                )
                Text(text = ":TPS 006",
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start = 107.dp, top = 5.dp))
            }
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .width(370.dp)
                .padding(start = 20.dp, top = 20.dp, bottom = 10.dp)
        )  {
            Text(text = "POTENSI ALAMAT")
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(color = Color.Black)
                .padding(top = 5.dp)

                ) {
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    PAMAcitivityIntentTheme {
        ProfileScreen(
            firstname = "yono", lastname = "lontong"
        )
    }
}
