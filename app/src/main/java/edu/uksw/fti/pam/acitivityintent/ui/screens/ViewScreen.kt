package edu.uksw.fti.pam.acitivityintent.ui.screens

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.acitivityintent.R
import edu.uksw.fti.pam.acitivityintent.ui.theme.PAMAcitivityIntentTheme


@Composable
fun ViewScreen() {

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    var bitmap = remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()){
            uri: Uri? -> imageUri = uri
    }

    //konten

    Column(
        modifier = Modifier
            .padding(top = 20.dp, start = 115.dp)
            .background(Color.White)
            .clickable { }
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(horizontal = 15.dp, vertical = 20.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.kpu1) ,
                contentDescription = "Logo KPU",

                modifier = Modifier
                    .size(100.dp)
            )
        }
    }
    Column(
        modifier = Modifier
            .padding(top = 170.dp, start = 40.dp)
            .background(Color(0XFFF6EDFF))
            .clickable { }
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(horizontal = 15.dp, vertical = 20.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.calon) ,
                contentDescription = "Calon",

                modifier = Modifier
                    .size(100.dp)
            )
        }
        Text(
            text = "Cek Calon",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start=24.dp)
        )
    }
    Column(
        modifier = Modifier
            .padding(top = 170.dp, start = 190.dp)
            .background(Color(0XFFF6EDFF))
            .clickable { }
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(horizontal = 15.dp, vertical = 20.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.hasil) ,
                contentDescription = "Hasil",

                modifier = Modifier
                    .size(100.dp)
            )
        }
        Text(
            text = "Cek Hasil",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start=27.dp)
        )
    }
    Column(
        modifier = Modifier
            .padding(top = 360.dp, start = 40.dp)
            .background(Color(0XFFF6EDFF))
            .clickable { }
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(horizontal = 15.dp, vertical = 20.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.pemilih) ,
                contentDescription = "Pemilih",

                modifier = Modifier
                    .size(100.dp)
            )
        }
        Text(
            text = "Cek Pemilih",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start=17.dp)
        )
    }
    Column(
        modifier = Modifier
            .padding(top = 360.dp, start = 190.dp)
            .background(Color(0XFFF6EDFF))
            .clickable { }
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(horizontal = 15.dp, vertical = 20.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.info) ,
                contentDescription = "Info",

                modifier = Modifier
                    .size(100.dp)
            )
        }
        Text(
            text = "Info Pemilu",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start=17.dp)
        )
    }

    Column (
        modifier = Modifier.fillMaxWidth().padding(top = 540.dp),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
            ) {
        imageUri?.let {
            if(Build.VERSION.SDK_INT < 28) {
                bitmap.value = MediaStore.Images
                    .Media.getBitmap(context.contentResolver, it)
            }else {
                val source = ImageDecoder.createSource(context.contentResolver, it)
                bitmap.value = ImageDecoder.decodeBitmap(source)
            }

            bitmap.value?.let {btm ->
                Image(
                    bitmap = btm.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(20.dp)
                )
            }
        }
        Button(onClick = {launcher.launch("image/*")}) {
            Text(text = "KTP Peserta")
        }
        
    }
}




@Preview(showBackground = true)
@Composable
fun ViewScreenPreview() {
    PAMAcitivityIntentTheme {
        ViewScreen()
    }
}