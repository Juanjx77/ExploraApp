package com.example.juan.mora.exploraapp.ui.elements


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    onClickLogout: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Explora Colombia") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("add_touristic_place")
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text("Home Screen")
        }
    }
}


//   val auth = Firebase.auth
 //   val user = auth.currentUser

//    Box(
//        modifier = Modifier.fillMaxSize(),
 //       contentAlignment = Alignment.Center
  //  ) {
   //     Column(horizontalAlignment = Alignment.CenterHorizontally) {
  //          Text("HOME SCREEN", fontSize = 30.sp, fontWeight = FontWeight.Bold)

   //         Spacer(modifier = Modifier.height(8.dp))

   //         if (user != null) {
                //Text(text = user.email ?: "Correo no disponible", fontSize = 16.sp)
  //          } else {
               // Text(text = "No hay usuario activo", color = Color.Gray)
 //           }

   //         Spacer(modifier = Modifier.height(24.dp))

   //         Button(
               // onClick = {
     //               auth.signOut()
                  //  OnclickLogout()
                //},
                //colors = ButtonDefaults.buttonColors(
                 //   containerColor = Color(0xFFFF9900)
                //),
                //shape = RoundedCornerShape(12.dp)
            //) {
                //Text("Cerrar Sesión", color = Color.White)
//            }
        //}
    //}
//}