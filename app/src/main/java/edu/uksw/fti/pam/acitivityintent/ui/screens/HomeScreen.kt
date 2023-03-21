package edu.uksw.fti.pam.acitivityintent.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.acitivityintent.ui.theme.PAMAcitivityIntentTheme
import edu.uksw.fti.pam.acitivityintent.R
import edu.uksw.fti.pam.acitivityintent.models.TodosViewModel




@Composable
fun HomeScreen() {

    val vm = TodosViewModel()

    LaunchedEffect(
        Unit,
        block = {
            vm.getToDoList()
        }
    )
    Column {
        if (vm.errorMessage.isEmpty()){
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(vm.toDoList.size){index ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .clickable { }
                            .padding(10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0XFFF6EDFF))
                            .padding(horizontal = 15.dp, vertical = 20.dp)
                            .fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                text = vm.toDoList[index].nama,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = vm.toDoList[index].nik,
                                fontSize = 13.sp,
                            )
                            Text(
                                text = vm.toDoList[index].title,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color.Blue)
                                .padding(10.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_checklist),
                                contentDescription = "Terdaftar",
                                tint = Color.White,
                                modifier = Modifier.size(26.dp)
                            )
                        }
                    }
                }
            }

        }
        else {
            Text(text = vm.errorMessage)
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PAMAcitivityIntentTheme {
        HomeScreen()
    }
}